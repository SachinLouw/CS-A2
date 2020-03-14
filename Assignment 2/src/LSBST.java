import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
* <h1>LSBST</h1>
* Stores data from file in a BST and processes it based on given input criteria
* <p>
*
* @author  LWXSAC001
*/

public class LSBST extends BinarySearchTree<LSObj>{
    private BinarySearchTree<LSObj> tree;
	private static int insCount;
	private static int findCount;

	public LSBST(){
    }
	
    public BinarySearchTree<LSObj> makeTree(String fileName){
		/**Creates a AVL tree containing loadshedding data*/
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
	
	public void printAreas (String stage, String day, String startTime){
		/*Outputs the areas affected by loadshedding given stage, date and time as input */
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
	
	public int[] printAreas (String stage, String day, String startTime, String output ){
		/*Outputs the areas affected by loadshedding given stage, date and time as input */
		String str1 = stage + "_" + day + "_" + startTime;
		String str2 = "";
		LSObj input = new LSObj(str1, str2);
		findCount = 0;
		
		try{
			BinaryTreeNode<LSObj> found = tree.find(input);
			String zones = (found.data).getZones();		
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
	
	public static void insIncrement(){
		insCount++;
	}
	
	public static void findIncrement(){
		findCount++;
	}
}