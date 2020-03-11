
public class LSAVLApp{
    public static void main (String[] args){

      LSAVL ls = new LSAVL ();
      ls.makeTree("data/original.txt");

      if (args.length == 3){
            if ((Integer.parseInt(args[2]))%2==0){
               System.out.println("Stage " + args[0] + " loadshedding \nDay " + args[1] + ", " + args[2] + ":00");
               ls.printAreas(args[0], args[1], args[2], "");
               ls.printAreas(args[0], args[1], args[2], "");
            }
            else{
               int time = Integer.parseInt(args[2]);
               System.out.println("Giving most relevant results");
               System.out.println("Stage " + args[0] + " loadshedding \nDay " + args[1] + ", " + Integer.toString(time - 1) + ":00");
               ls.printAreas(args[0], args[1], Integer.toString(time - 1), "");
               System.out.println("Day " + args[1] + ", " + Integer.toString(time + 1) + ":00");
               ls.printAreas(args[0], args[1], Integer.toString(time + 1), "");
            }
         }
      else{
         ls.printAllAreas ();
      }
    }
}
