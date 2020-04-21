/**
* Program used to create data tables from pre-generated randomised subsets of the original loadshedding data
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
		
				//insert variables
				int bestAVLInsert = 0;
				int worstAVLinsert = 0;
				int sumAVLInsert = 0;
		
				int bestBSTIns = 0;
				int worstBSTIns = 0;
				int SumBSTIns = 0;

				//find variables
				int bestAVLFind = 0;
				int worstAVLFind = 0;
				int sumAVLFind = 0;
		
				int bestBSTFind = 0;
				int worstBSTFind = 0;
				int SumBSTFind = 0;
				
				//balance variables
				int bestAVLBalance = 0;
				int worstAVLBalance = 0;
				int sumAVLBalance = 0;
				
				int n = 297*i;

				String a = item[0][0].split("_")[0];
				String b = item[0][0].split("_")[1];
				String c = item[0][0].split("_")[2];
				
				lsResult[0] = ls.printAreas(a, b, c, output);
				bsResult[0] = bs.printAreas(a, b, c, output);
				
				bestAVLInsert = lsResult[0][0];
				worstAVLinsert = lsResult[0][0];
				bestBSTIns = bsResult[0][0];
				worstBSTIns = bsResult[0][0];

				bestAVLFind = lsResult[0][1];
				worstAVLFind = lsResult[0][1];
				bestBSTFind = bsResult[0][1];
				worstBSTFind = bsResult[0][1];
				
				bestAVLBalance = lsResult[0][2];
				worstAVLBalance = lsResult[0][2];

				sumAVLInsert += lsResult[0][0];
				SumBSTIns += bsResult[0][0];

				sumAVLFind += lsResult[0][1];
				SumBSTFind += bsResult[0][1];
				
				sumAVLBalance += lsResult[0][2];
				
				for (int j = 1; j<item.length; j++){
					//creates best, worst and average cases
					a = item[j][0].split("_")[0];
					b = item[j][0].split("_")[1];
					c = item[j][0].split("_")[2];

					lsResult[j] = ls.printAreas(a, b, c, output);
					bsResult[j] = bs.printAreas(a, b, c, output);
					
					bestAVLInsert = Math.min(bestAVLInsert, lsResult[j-1][0]);
					worstAVLinsert = Math.max(worstAVLinsert, lsResult[j-1][0]);
					bestBSTIns = Math.min(bestBSTIns, bsResult[j-1][0]);
					worstBSTIns = Math.max(worstBSTIns, bsResult[j-1][0]);

					bestAVLFind = Math.min(bestAVLFind, lsResult[j-1][1]);
					worstAVLFind = Math.max(worstAVLFind, lsResult[j-1][1]);
					bestBSTFind = Math.min(bestBSTFind, bsResult[j-1][1]);
					worstBSTFind = Math.max(worstBSTFind, bsResult[j-1][1]);
					
					bestAVLBalance = Math.min(bestAVLBalance, lsResult[j-1][2]);
					worstAVLBalance = Math.max(worstAVLBalance, lsResult[j-1][2]);
					
					sumAVLInsert += lsResult[j][0];
					SumBSTIns += bsResult[j][0];

					sumAVLFind += lsResult[j][1];
					SumBSTFind += bsResult[j][1];
					
					sumAVLBalance += lsResult[j][2];
				}

				File results = new File(output);
				// take above results and insert into a csv table  
				try{
					if(!results.exists()){
						results.createNewFile();
					}
			
					FileWriter fileWriter = new FileWriter(results, true);
			
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					bufferedWriter.write(Integer.toString(n) + ",InsertAVL,InsertBST,FindAVL,FindBST,BalanceAVL\n");
					bufferedWriter.write("Best case," + Integer.toString(bestAVLInsert) + "," + Integer.toString(bestBSTIns) + 
					"," + Integer.toString(bestAVLFind) + "," + Integer.toString(bestBSTFind) + "," + Integer.toString(bestAVLBalance) + "\n");
					bufferedWriter.write("Worst case," + Integer.toString(worstAVLinsert) + "," + Integer.toString(worstBSTIns) + 
					"," + Integer.toString(worstAVLFind) + "," + Integer.toString(worstBSTFind) + "," + Integer.toString(worstAVLBalance) + "\n");
					bufferedWriter.write("Average case," + Integer.toString(sumAVLInsert/n) + "," + Integer.toString(SumBSTIns/n) + 
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
			
		}
		
    }
}
