
import java.io.PrintStream;
import java.util.Scanner;
import java.util.StringTokenizer;

// import Graphs.Graph;

public class SimulatorOne {

    private Graph g;
    private int numVictims;
    private int numHospitals;
    private String victims;
    private String hospitals;
    private String output;

    public void makeGraph(){
        g = new Graph( );
    
        Scanner graphFile = new Scanner(System.in);

        int numNodes = Integer.parseInt(graphFile.nextLine());
        if (numNodes>0){
            int num = numNodes;
            while (num>0){
                String nodes = graphFile.nextLine();
                StringTokenizer st = new StringTokenizer(nodes.replaceAll("\\s+", " "), " ");
                String source = st.nextToken();
                while(st.hasMoreTokens())
                {
                    String dest = st.nextToken();
                    Double weight = Double.parseDouble(st.nextToken());
                    g.addEdge(source, dest, weight);
                    // st.nextToken();
                }
                num--;
            }
        }

        numHospitals = Integer.parseInt(graphFile.nextLine());
        if (numHospitals>0){
            hospitals = graphFile.nextLine();
            StringTokenizer ht = new StringTokenizer(hospitals, " ");
            while (ht.hasMoreTokens()){
                String number = ht.nextToken();
                Vertex v = g.getVertex(number);
                v.changeName("hospital");   
            }

        }
        
        numVictims = Integer.parseInt(graphFile.nextLine());
        if (numVictims>0){
            while(graphFile.hasNextInt()){
                victims = graphFile.nextLine().trim();
            }
            StringTokenizer vt = new StringTokenizer(victims, " ");
            while(vt.hasMoreTokens()){
                String number = vt.nextToken();
                Vertex v = g.getVertex(number);
                v.changeName("victim");
            }
        }

        graphFile.close();
       
    }

    public String processPath(){
        StringTokenizer v = new StringTokenizer(victims, " ");       
        CustomOutputStream out = new CustomOutputStream("");
        PrintStream printStream = new PrintStream(out);
        PrintStream stdOut = System.out;
        PrintStream stdErr = System.err; 
        System.setOut(printStream);
        System.setErr(printStream);
        while(v.hasMoreTokens()){
            String victim = v.nextToken();

            System.out.println("victim " + victim);
            StringTokenizer h = new StringTokenizer(hospitals, " ");
            while(h.hasMoreTokens())
            {
                String hospital = h.nextToken();
                g.dijkstra(hospital);
                System.out.println("hospital " + hospital);
                g.printPath(victim);
                g.dijkstra(victim);
                g.printPath(hospital);
            }
            System.out.println("-");

        }

            this.output = out.getOutput();
            System.setOut(stdOut); System.setErr(stdErr);
            return this.output;
    }
    
    public String getTrips(String input){
        Scanner sc = new Scanner(input).useDelimiter("-");
        String victim;
        String trips = "";
        while(sc.hasNextLine()){
            victim = sc.nextLine();
            Hospital h;
            h = new Hospital(sc.next());
            trips += victim + "\n" + h.toString() + "\n";
            sc.nextLine();
        } 
        sc.close();
        return trips;
    }

    public static void main( String [ ] args )
    {
        SimulatorOne graph = new SimulatorOne();

        // graph.makeGraph(args[0]);
        graph.makeGraph();
        String paths = graph.processPath();
        
        System.out.println(graph.getTrips(paths));
        // System.out.println(Arrays.toString(graph.processPath().split("\n")));
    }
}