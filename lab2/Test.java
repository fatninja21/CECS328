package ProgrammingAssignment2;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*********************************************************************");
		System.out.println("********************PART A*******************************************");
		//PART A
		SquareRootFunction function= new SquareRootFunction();
		Scanner in = new Scanner(System.in);		
		System.out.println("enter a value to find the square root");
		int n = in.nextInt();
		function.squareRoot(n);
		//end of partA 
		System.out.println("---------------------------------------------------------------------");
		System.out.println("********************PART B*******************************************");
		System.out.println("");
		//Part B
		BinaryArrayPositionFinder finder=  new BinaryArrayPositionFinder();
		Scanner arraySize = new Scanner(System.in);
		System.out.println("please enter number of 0's you would like in your binary array: " );
		int k1= arraySize.nextInt();
		System.out.println("please enter number of 1's you would like in your binary array: " );
		int k2= arraySize.nextInt();
		
		int[] binaryArray = new int[k1+k2];		
		for (int i = 0;i < binaryArray.length; i++){
		    binaryArray[i] = 1;
		    for (int j=0;j<k1;j++) {
		    	binaryArray[j] = 0;
			} 
		}
		
		finder.binaryArrayPositionSearch(binaryArray);//locate position of Array
	
	in.close();
	arraySize.close();
	}
	

}
