package lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

// *****************PART A*********************************************************************************************
// CREATE A HEAPSORT TO SORT A RANDOM ARRAY OF 1k VALUES AND COMPARE THE AVERAGE RUN TIME

		System.out.println("****************PART A******************************");
		System.out.print("Enter a number for value N:");
		 int n= (CheckInput.getPositiveInt());
		 double heapTotalTime = 0.00;
		 int itterationAmount = 100;
		 int minArrayValue=-10000; int maxArrayValue=10000;
		 for(int i=0; i< itterationAmount;i++) {
			 int []a= new int[n];
			 a = generateIntArray(n, maxArrayValue, minArrayValue);
			double heapSortStart = System.nanoTime();
        	heap_sort(a);
        	double heapSortStop = System.nanoTime();
			double heapTime = ( heapSortStop - heapSortStart );
			heapTotalTime += heapTime;
        }
        System.out.println( " HeapSort averageTime is : " + heapTotalTime / itterationAmount + " NanoSeconds ");
		 
        double selectionSortTotalTime = 0.00;
		 for(int i=0; i< itterationAmount;i++) {
			 int []a= new int[n];
			 a = generateIntArray(n, maxArrayValue, minArrayValue);
			double selectionSortStart = System.nanoTime();
			SelectionSort(a);
        	double selectionSortStop = System.nanoTime();
			double selectionTime = ( selectionSortStop - selectionSortStart );
			selectionSortTotalTime += selectionTime;
        }
        System.out.println( " SelectionSort averageTime is : " + selectionSortTotalTime / itterationAmount + " NanoSeconds ");
        System.out.println("");

  
//***********************************PART B**********************************************************************************
//Create a 10 int array and use Heapsort to sort it and output the result
     System.out.println("******************PART B*********************************");
     int []a2 = new int[10];   
	 a2 = generateIntArray(10, maxArrayValue, minArrayValue);
 	 System.out.println("ARRAY BEFORE SORT");
	 System.out.println(Arrays.toString(a2));
	 heap_sort(a2);
	 System.out.println("ARRAY AFTER SORT");
	 System.out.println(Arrays.toString(a2));
 
        
        
	}
	
	
	public static void SelectionSort( int []a) {
		int n = a.length;	
		int min = a[0];
		for (int i=0;i<n;i++) {
			int min_Value=i;
			for (int j=i+1;j<n;j++) {
				if( a[j]<a[min_Value]) {
					min_Value=j;
				}
			Swap(a,i,j);
			}
		}	
	}
    
	
	public static void Swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void heap_sort(int[] a) {
        int n = a.length-1; 
        //creates max heap
		for (int i = n / 2 ; i >= 0; i--) {
			MaxHeapify(a,n, i);
		}		
		//swap first and last value of heap after heap has been created
		//call maxheapify to sort the heap again until it is a max heap once again
		for(int i= n; i>=0;i--) {
		Swap(a,0,i);	
		MaxHeapify(a,i,0);
		}		
	}
		

	public static void MaxHeapify(int[] a,int n, int index) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int max = index;
		if (left < n && a[left] > a[index]) {
			max = left;
		}if (right < n && a[right] > a[max]) {
			max = right;	
		}if (max != index) {
			Swap(a,index,max);
			MaxHeapify(a,n, max);
		}
	}

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
