import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class LSAVL extends AVLTree<LSObj>{
    private AVLTree<LSObj> tree;
	private static int insCount;
	private static int findCount;
	private static int balCount;

	public LSAVL(){
    }
	
    public AVLTree<LSObj> makeTree(String fileName){
		insCount  = 0;
		balCount = 0;
    	this.tree = new AVLTree<LSObj>();
    	try{
			File lsSc = new File(fileName);
			Scanner sc;
			sc = new Scanner(lsSc);
			while (sc.hasNextLine()){
				String[] line = sc.nextLine().split(" ",2);
				LSObj data = new LSObj(line[0], line[1]);
				tree.insert(data);
			}
		sc.close();
       
		} 	
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return tree;
    }
	
   public void printAreas (String stage, String day, String startTime, String output ){
		String str1 = stage + "_" + day + "_" + startTime;
		String str2 = "";
		LSObj input = new LSObj(str1, str2);
		findCount = 0;
		String zones = (tree.find(input).data).getZones();
		if (zones.length()>0)
		{
			System.out.println(zones);
		
		}
		else
		{
			System.out.println("No results found"); 
		}

		if (output!="")
		{
			File results = new File(output);
		
			try{
				if(!results.exists()){
					results.createNewFile();
				}
		
				FileWriter fileWriter = new FileWriter(results, true);
		
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write("logn, " + output.substring(7, (output.length() - 3)) + ", " + Integer.toString(insCount) + ", " + Integer.toString(findCount) +"\n");
				bufferedWriter.close();
			} catch(Exception e) {
				System.out.println("COULD NOT LOG!!");
			}
		}
		System.out.println("Number of insertions: "+ Integer.toString(insCount));
		System.out.println("Number of balance operations: "+ Integer.toString(balCount));
		System.out.println("Number of find operations: "+ Integer.toString(findCount));
    }
    
   public void printAllAreas (){
		tree.inOrder();
		System.out.println("Number of insertions: "+ Integer.toString(insCount));
		System.out.println("Number of balance operations: "+ Integer.toString(balCount));
	}
	
	public static void insIncrement(){
		insCount++;
	}
	
	public static void findIncrement(){
		findCount++;
	}

	public static void balIncrement(){
		balCount++;
	}
}