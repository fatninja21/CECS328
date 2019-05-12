package lab;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		  int nInputSize= 1000;
		  System.out.println("Enter 1000 for value N:"); 
		  int n=(CheckInput.getIntRange(nInputSize,nInputSize));//only allows 1k for n
		  int[] a = new int[n] ;

		  
		  int loopIteration=100;
		  double totalQuick_SortTime=0; double totalInsertionTime=0;		  
		  for (int i = 0; i < loopIteration; i++) {
			  a = generateIntArray(n, 5000, -5000);//generate random array 100 times
			  //linear search time
			  double startTimeInsertion= System.nanoTime();
			  insertion_sort(a);
			  double endTimeInsertion= System.nanoTime();
			  totalInsertionTime= totalInsertionTime + (endTimeInsertion- startTimeInsertion); 
	        }
		  for (int i = 0; i < loopIteration; i++) {
			  a = generateIntArray(n, 5000, -5000);//generate random array 100 times
			  //quick_sort time
			  double startTimeBinary = System.nanoTime(); 
			  quick_sort(a, 0, a.length - 1);
	          double endTimeBinary = System.nanoTime();
	          totalQuick_SortTime= totalQuick_SortTime+(endTimeBinary - startTimeBinary);
	        }
		  System.out.println("total quicksort time is "+ totalQuick_SortTime  + "nanoseconds" );
	      System.out.println("Average-running time for quick sort is " + totalQuick_SortTime / loopIteration + " nanoseconds");
	      System.out.println();
		  System.out.println("total Linear time is " + totalInsertionTime + "nanoseconds");
	      System.out.println("Average-running time for insertion sort is " + totalInsertionTime / loopIteration + " nanoseconds");

		  

	      //Insertion Sort equations
	      double growth = n*n;
	      double nanoSecondConversion= 1000000000;
	      double totalInsertionTimeinSeconds= totalInsertionTime* nanoSecondConversion;
	      double lineTimeTaken = (totalInsertionTimeinSeconds / growth);// (totaltime converted to seconds) / growth
	      double instructionsPerSec = 1 / lineTimeTaken;
	      System.out.println("Insertion sort can run " + instructionsPerSec + " in one second");

	      
	
	}// end main


	public static void Swap(int [] arr,int a, int b ) {
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}


	public static void quick_sort(int[] a, int left, int right) {
	
		if(right - left > 1) {//if right=left>1 recursively call quickSort on left and right side of pivot
			int pIndex = Partition(a, left, right);
			quick_sort(a, left, (pIndex-1));
			quick_sort(a, (pIndex+1), right);
        } else if(right - left == 1){ //array size of current iteration is 2
            if(a[left] > a[right]) { //swap if out of order
                Swap(a,left,right);

            }
        }
        
	}// end quickSort


	public static int calculatePivot(int[] a, int left, int right) {
		int middle = (right + left) / 2;
        int pivot =0;
        //checks the position of the first, last, and middle number and then compares to find which number will be the median
        //once it compares the 3 values it will define that number as the pivot
		if( (a[left] > a[middle]) && (a[left] < a[right])  || ( (a[left]<a[middle]) && (a[left]>a[right]) )){
			pivot= left;
		}else if ( (a[right]>a[middle]) && (a[right]<a[right]) || ( (a[right]<a[middle]) && (a[right]>a[left]) ) ) {
			pivot = right;
		}else if( (a[middle]>a[left]) && (a[middle]<a[right]) || ( (a[middle]>a[right]) && (a[middle]<a[left]) )) {
			pivot = middle;
		}else if( (a[middle]>a[right]) && (a[middle]<a[left]) ) {
			pivot = middle;
		}
		//this portion swaps the index of pivot w/ the last value of the array
		if (pivot == left) {
			Swap(a,right,left);
			pivot = right;
		} else if ( pivot == middle) {
			Swap(a,middle,right);
			pivot = right;
		} else  {
			pivot = right;
		}

		return pivot;
	}

	public static int Partition(int[] a, int left, int right) {
		int pivotIndex = calculatePivot(a,left,right);
		int pivot= a[pivotIndex];
		int leftPointer = left;
		int rightPointer = right - 1;
		int temp = 0;
		while (true) {
			// this while loop acts as left hand and will compare value at left side against
			// pivot
			// if value is less than pivot then move to next right location
			while (a[leftPointer] <= pivot && leftPointer<rightPointer) {
				leftPointer++;// increment because a[leftPointer]> pivot
			}
			// this while loop acts as right hand and will compare value at right side
			// against pivot
			// if value is greater than pivot then move to next left location
			// if the value reaches the first position it will no longer decrement
			while (rightPointer > 0 && a[rightPointer] >= pivot) {
				rightPointer--;// decrement because a[rightPointer]> pivot
			}
			// takes a look at location of leftPointer and rightPointer
			// if its less than right Pointer then swap values of a[leftPointer] and
			// a[rightPointer]
			// if leftPointer> rightPointer it means that it passed the location meaning
			// numbers are sorted
			if (leftPointer > rightPointer ) {
				break;// gets out of while loop when the if statement condition is met
			} else if( a[leftPointer]== a[rightPointer]){
				leftPointer++;
				rightPointer--;
			}else {
			temp = a[leftPointer];
			a[leftPointer] = a[rightPointer];
			a[rightPointer] = temp;
			}
		} // end while true

		temp = a[leftPointer];
		a[leftPointer] = a[right];
		a[right] = temp;
	
		return leftPointer;// this value is the new pivot

	}// end partition function
	
	
	public static void insertion_sort(int[] a) {

		// for loop will go from i=1 to end of array so that it will begin looking at
		// the array value after a[0] compare it to initial and begin sorting after a[0]
		// to end of array
		int tempSwapValue;
		for (int i = 1; i < a.length; i++) {// loops through array from a[1] to a[end] since we don't look at the first element
			for (int j = i; j > 0; j--) {//decrement j until j<0 so that j will compare every value before it to swap if needed
				tempSwapValue = a[j];
				if (a[j] < a[j - 1]) {// check if a[j] is less than a[j-1] ( for the first iteration checks a[j]<a[0]
					a[j] = a[j - 1]; // condition above was true therefore we switch second value with the first value
					a[j - 1] = tempSwapValue; // a[j-1] now holds temp value which is the original a[j]
				}
			}//end inner for loop
		} // end outer for loop
	}// end InsertionSort

	public static int[] generateIntArray(int size, int max, int min) {
		int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = randomNumber(max, min);
		}
		return a;
	}// end generateIntArray

	public static int randomNumber(int max, int min) {
		Random rand = new Random();
		int number = rand.nextInt((max - min) + 1) + min;
		return number;
	}// end randomNumber
  
}


