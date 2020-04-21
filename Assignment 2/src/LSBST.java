import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
* Stores data from file in a BST and processes it based on given input criteria
**/

public class LSBST extends BinarySearchTree<LSObj>{
    private BinarySearchTree<LSObj> tree;
	private static int insCount;
	private static int findCount;

	public LSBST(){
    }
	
	/**
	 * Creates a binary search tree containing loadshedding data
	 */	

    public BinarySearchTree<LSObj> makeTree(String fileName){
		insCount  = 0;
    	this.tree = new BinarySearchTree<LSObj>();
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
	
	/**
	 * Outputs the areas affected by loadshedding given stage, date and time as input 
	 */

	public void printAreas (String stage, String day, String startTime){

		String str1 = stage + "_" + day + "_" + startTime;
		String str2 = "";
		LSObj input = new LSObj(str1, str2);
		findCount = 0;
		
		try{
			BinaryTreeNode<LSObj> found = tree.find(input);
			String zones = (found.data).getZones();
			System.out.println(zones);
		
		}

		catch(NullPointerException nodeIsNull) {
			System.out.println("No results found"); 
		}

		System.out.println("Number of insertions: "+ Integer.toString(insCount));
		System.out.println("Number of find operations: "+ Integer.toString(findCount));
	}
	
	/**
	 * Returns count variables for operations used in automated data procesing
	 */

	public int[] printAreas (String stage, String day, String startTime, String output){

		//String str1 = stage + "_" + day + "_" + startTime;
		//String str2 = "";
		//LSObj input = new LSObj(str1, str2);
		findCount = 0;
		
		try{
		//	BinaryTreeNode<LSObj> found = tree.find(input);
		
		}
		catch(NullPointerException nodeIsNull){}

		int[] result = {insCount, findCount};
		return result;
	}

	public void printAllAreas (){
		/*Outputs all the areas affected by loadshedding for all stages*/
		tree.inOrder();
		System.out.println("Number of insertions: "+ Integer.toString(insCount));
	}
	/**
	* Counter method for insert operations
	*/
	public static void insIncrement(){
		insCount++;
	}

	/**
	* Counter method for search operations
	*/
	public static void findIncrement(){
		findCount++;
	}

}