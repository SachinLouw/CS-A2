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
			String output = "results/results.csv";
			
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
		
				int bestAVLInsert = 0;
				int worstAVLinsert = 0;
				int sumAVLInsert = 0;
		
				int bestBSTIns = 0;
				int worstBSTIns = 0;
				int SumBSTIns = 0;

				int bestAVLFind = 0;
				int worstAVLFind = 0;
				int sumAVLFind = 0;
		
				int bestBSTFind = 0;
				int worstBSTFind = 0;
				int SumBSTFind = 0;
				
				int bestAVLBalance = 0;
				int worstAVLBalance = 0;
				int sumAVLBalance = 0;
				
				int n = 297*i;
			

				for (int j = 0; j<item.length; j++){
					String a = item[j][0].split("_")[0];
					String b = item[j][0].split("_")[1];
					String c = item[j][0].split("_")[2];

					lsResult[j] = ls.printAreas(a, b, c, output);
					bsResult[j] = bs.printAreas(a, b, c, output);
					
					if (j>0){
						worstAVLinsert = Math.max(lsResult[j][0], lsResult[j-1][0]);
						bestBSTIns = Math.min(bsResult[j][0], bsResult[j-1][0]);
						worstBSTIns = Math.max(bsResult[j][0], bsResult[j-1][0]);

						worstAVLFind = Math.max(lsResult[j][1], lsResult[j-1][1]);
						bestBSTFind = Math.min(bsResult[j][1], bsResult[j-1][1]);
						worstBSTFind = Math.max(bsResult[j][1], bsResult[j-1][1]);
						
						bestAVLBalance = Math.min(lsResult[j][2], lsResult[j-1][2]);
						worstAVLBalance = Math.max(lsResult[j][2], lsResult[j-1][2]);
					
					}
					sumAVLInsert += lsResult[j][0];
					SumBSTIns += bsResult[j][0];

					sumAVLFind += lsResult[j][1];
					SumBSTFind += bsResult[j][1];
					
					sumAVLBalance += lsResult[j][2];
				}
				bestAVLInsert = lsResult[0][0];
				bestAVLFind = lsResult[0][1];
				
				File results = new File(output);
			
				try{
					if(!results.exists()){
						results.createNewFile();
					}
			
					FileWriter fileWriter = new FileWriter(results, true);
			
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					bufferedWriter.write(Integer.toString(n) + ",InsertAVL,InsertBST,FindAVL,FindBST,BalanceAVL\n");
					bufferedWriter.write("Best case," + Integer.toString(bestAVLInsert) + "," + Integer.toString(bestBSTIns) + 
					"," + Integer.toString(bestAVLFind) + "," + Integer.toString(bestBSTFind) + "," + Integer.toString(bestAVLBalance) + "\n");
					bufferedWriter.write("Worst case, " + Integer.toString(worstAVLinsert) + "," + Integer.toString(worstBSTIns) + 
					"," + Integer.toString(worstAVLFind) + "," + Integer.toString(worstBSTFind) + "," + Integer.toString(worstAVLBalance) + "\n");
					bufferedWriter.write("Average case, " + Integer.toString(sumAVLInsert/n) + "," + Integer.toString(SumBSTIns/n) + 
					"," + Integer.toString(sumAVLFind/n) + "," + Integer.toString(SumBSTFind/n) + "," + Integer.toString(sumAVLBalance/n) + "\n");
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
