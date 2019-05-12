package search;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
//**********************************************************************************************************************************//
//******************************PART A**********************************************************************************************//
		//objects to use functions ins search and mergeSorter
		MergeSorter sortA = new MergeSorter();
		Search binary  = new Search();
		Search linear = new Search();
		Search randomizer=  new Search();
		int arrayMaxValue = 1000, arrayMinValue = -1000;
		
		//	boolean testInput = true;
		Scanner in = new Scanner(System.in);		
		System.out.print("please enter 100,000 for the size of the array: ");
		int n = in.nextInt();// user will input n as 10^5
		int[] arrayA = new int[n];	
		arrayA = randomizer.generateIntArray(n, arrayMaxValue, arrayMinValue);//generate values for arrayA	
		sortA.sort(arrayA);//sort arrayA

	
		//initialize variables 
		double binaryTotalTime = 0.00;	
		double linearSearchTotalTime = 0.00;
		int itterationAmount = 100;
		for(int i = 0; i < itterationAmount; i++) {
			int randomPositionValue=randomizer.randomNumber(arrayA.length-1, 0);
			int key = arrayA[randomPositionValue];
			//linear search record time
			double linearStartTime = System.nanoTime();
			linear.linearSearch(arrayA, key);
			double linearStopTime = System.nanoTime();
			double linearTime = (linearStopTime - linearStartTime);
			linearSearchTotalTime += linearTime;

			//binary search record time
			double binaryStartTime = System.nanoTime();
			binary.binarySearch(arrayA, key);
			double binaryStopTime = System.nanoTime();
			double binaryTime = (binaryStopTime - binaryStartTime);
			binaryTotalTime += binaryTime;
		}
		
		System.out.println("==========================================================================");
		System.out.println("Part A: Find the Average time elapsed for binary search and Linear Search");
		System.out.println("===========================================================================");
		System.out.println();
		System.out.println("************************************************************************************************");
		System.out.println(
				"Average time elapsed for binary search is: " + (binaryTotalTime / itterationAmount) + " x 10^-9 seconds.");
		System.out.println(
				"Average time elapsed for linear search is: " + (linearSearchTotalTime / itterationAmount) + " x 10^-9 seconds.");
		System.out.println("************************************************************************************************");
		
		
//*********************************************************************************************************************************************//		
//***********************************************************PART B***************************************************************************//
		MergeSorter sortB= new MergeSorter();
		System.out.println("=====================================================");
		System.out.println("PART B: CALCULATE WORST CASE RUNNING TIME");
		System.out.println("=====================================================");
		System.out.print("please enter 100,000 for the size of the array: ");
		n= in.nextInt();//ask for user input for n
		int key= 50000;//set key to search for sort through array to 5k
		int[] arrayB = new int[n];//create arrayB
		arrayB=randomizer.generateIntArray(n, arrayMaxValue, arrayMinValue);//generate random values for arrayB
		sortB.sort(arrayB);//sort second array before beginning to search
		
		double linearWorstTimeStart = System.nanoTime();//get start time 	
		linear.linearSearch(arrayB, key);//call linear search to search for key			
		double linearWorstStopTime = System.nanoTime();//get stop time
		double linearTime = linearWorstStopTime - linearWorstTimeStart;//find time it takes to do linear search
		System.out.println("**************************************************************************");
		System.out.println("Time it takes to calculate worst case linearSearch for n=10^5 is: " + linearTime + " x 10^-9 seconds.");
		System.out.println("**************************************************************************");
		double binaryWorstTimeStart, binaryWorstStopTime;
		binaryWorstTimeStart = System.nanoTime();	
		binary.binarySearch(arrayB, key);			
		binaryWorstStopTime = System.nanoTime();
		double binaryTime = binaryWorstStopTime - binaryWorstTimeStart;
		System.out.println("Time it takes to calculate worst case BinarySearch for n= 10^5 is: " + binaryTime + " x 10^-9 seconds.");
		System.out.println("**************************************************************************");
		
		//part4  single line = O(1), worst-case is O(log(n)), so time to run one line =  total time / log(n) lines
		System.out.println("************************PART 4 RUNTIME*************************************");
		double singleLineTime = binaryTime / (Math.log(n)/Math.log(2));
        System.out.println("Time to run a single line for n= 10^5 is " + singleLineTime + " x 10^-9 seconds.");
        
        //part 5 equation
		System.out.println("************************PART 5 RUNTIME*************************************");
        double binaryRunTime = (Math.log(Math.pow(10, 7))/Math.log(2)) * singleLineTime;
        double linearRunTime = Math.pow(10, 7) * singleLineTime;
		System.out.println("Worst time taken to run binary search for n=10^7 is: "+ binaryRunTime + " X 10^-9 seconds");
		System.out.println("Worst time taken to run Linear search for n=10^7 is: "+ linearRunTime +  " X 10^-9 seconds");
        
	in.close();
	
	}//end main

}//end test
