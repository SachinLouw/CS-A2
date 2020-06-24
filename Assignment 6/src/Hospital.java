import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hospital {

    ArrayList <String> hospitals = new ArrayList<String>();
    ArrayList <Integer> cost = new ArrayList<Integer>();
    ArrayList <String> path = new ArrayList<String>();

    Hospital(String input)
    {
        String hospital; int costForward; String pathForward; int costBack; String pathBack;
        Scanner sc = new Scanner(input);
        while(sc.hasNextLine()){
            hospital = sc.nextLine();
            costForward = Integer.parseInt(sc.nextLine());
            pathForward = sc.nextLine();
            costBack = Integer.parseInt(sc.nextLine());
            pathBack = sc.nextLine();
            hospitals.add(hospital);
            cost.add(costForward + costBack);
            path.add(pathForward.concat(pathBack.substring(1)));
        }
        sc.close();
    }


    public String toString()
    {
        int minCost = Collections.min(cost);
        int minTrip = cost.indexOf(minCost);
        String trips = hospitals.get(minTrip) + "\n" + 
                        path.get(minTrip);
        for (int i = 0; i<hospitals.size(); i++){
            if (i==minTrip) continue;
            else if ((cost.get(i)==minCost)
                    &&(!(path.get(i).equals(path.get(minTrip)))))
            trips += "\n" + hospitals.get(i) + 
                     "\n" + path.get(i);
        }
        return trips;
    }
}
