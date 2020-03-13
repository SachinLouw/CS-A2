/**
* <h1>Testing</h1>
* Program used to create data tables from generated samples
* <p>
*
* @author  LWXSAC001
*/

import java.lang.Math;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class GenDataTables{
    public static void main (String[] args){

		for(int i = 1; i<=10; i++){
			String output = "results/results" + Integer.toString(297*i) + ".csv";
			try{
				String item[][] = new String[297*i][];
				File lsSc = new File("data/sample_" + Integer.toString(i) + ".txt");
				Scanner sc;
				sc = new Scanner(lsSc);
				int k = 0;
				while (sc.hasNextLine()){
					String data = sc.nextLine();
					item[k] = data.split(" ",2);
					k++;
				}
				sc.close();
				LSAVL ls = new LSAVL ();
				int lsResult[][] = new int[297*i][];
				ls.makeTree("data/sample_" + Integer.toString(i) + ".txt");
				LSBST bs = new LSBST ();
				int bsResult[][] = new int[297*i][];
				bs.makeTree("data/sample_" + Integer.toString(i) + ".txt");
		
				int bestAVL;
				int worstAVL;
				int sumAVL = 0;
		
				int bestBST;
				int worstBST;
				int sumBST = 0;

				for (int j = 0; j<item.length; j++){
					String a = item[j][0].split("_")[0];
					String b = item[j][0].split("_")[1];
					String c = item[j][0].split("_")[2];

					lsResult[j] = ls.printAreas(a, b, c, output);
					bsResult[j] = bs.printAreas(a, b, c, output);
					
					if (j>0){
						bestAVL = Math.min(lsResult[j][0], lsResult[j-1][0]);
						worstAVL = Math.max(lsResult[j][0], lsResult[j-1][0]);
					}

					sumAVL += lsResult[j][0];
				}


				File results = new File(output);
		
				try{
					if(!results.exists()){
						results.createNewFile();
					}
			
					FileWriter fileWriter = new FileWriter(results, true);
			
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					bufferedWriter.write("\n");
					bufferedWriter.close();
				} 
				catch(Exception e) {
					System.out.println("COULD NOT LOG!!");
				}
			
			}

			catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			//write a blank line
			

			
		}
		
    }
}
