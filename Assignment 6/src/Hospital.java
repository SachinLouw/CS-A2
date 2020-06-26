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
            path.add(pathForward.concat(pathBack.substring(pathBack.indexOf(" "))));
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

        // boolean multi = false;
        // int minCost = Collections.min(cost);
        // int minTrip = cost.indexOf(minCost);
        // String trips = hospitals.get(minTrip) + "\n" + 
        //                 path.get(minTrip);
        // String multiple = "multiple solutions cost " + 
        //                 Integer.toString(minCost);
        // String multiTrips = hospitals.get(minTrip) + "\n" + multiple;
        // for (int i = 0; i<hospitals.size(); i++){
        //     if (i==minTrip) {continue;}
        //     else if ((cost.get(i)==minCost)
        //             &&(!(path.get(i).equals(path.get(minTrip)))))
        //     {
        //         multi = true;
        //         multiTrips += "\n" + hospitals.get(i) + 
        //              "\n" + multiple;
        //     }
        // }
        // if (multi) return multiTrips;
        // return trips;
    }
}
