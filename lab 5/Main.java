package lab5;

import java.util.Arrays;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("*******************************PART A*******************************************");
        System.out.println("Least K Value  ");
        System.out.println("_______________");
		System.out.print("Enter a number for value N:"); 
		
		//step 1
		int n= (CheckInput.getPositiveInt());
		
		//step 2
		int high=n; int low=1; // ranges for k 
		int minArrayValue=-100; int maxArrayValue=100;
		int []arrayA= new int [n];// create an array with n amount of integers
		arrayA = generateIntArray(n, maxArrayValue, minArrayValue);
		
		//step 3
		System.out.println(Arrays.toString(arrayA));
		
		//step 4
		System.out.print("Enter a k value greater than 1 and less than n: ");
		int k=(CheckInput.getIntRange(low, high));
		int mid= (arrayA.length-1)/2;
 		System.out.println("");

		
		//step 5  Run time for this step is O(n) as it is using quick sort and runtime for quick is O(n)
		int median= quick_select(arrayA,0,arrayA.length-1,mid);
		System.out.println("sorted array with median in middle");
		System.out.println(Arrays.toString(arrayA)); //semi sorted array with median in middle
 		System.out.println("median is "+ median);
 		System.out.println("");
		
 		
 		
 		//step 6 Time complexity is O(n) as a for loop is being used to save the differences
		System.out.println("diff array");
 		
		
		int [] diff = new int [n];
 		int [] nonabsdiff= new int [n];
 		int [][] diff2dArray= new int [2][n];
 		for( int i=0; i<arrayA.length; i++) {
			int tempDiff= arrayA[i]- median;
			nonabsdiff[i]=tempDiff;
			diff[i]= Math.abs(tempDiff);
 		}
		int initialArrayPosition=0;
		
		Swap(diff,(diff.length-1)/2,initialArrayPosition );
		Swap(nonabsdiff,(nonabsdiff.length-1)/2,initialArrayPosition );
	//	Swap2d(diff2dArray,(diff2dArray.length-1)/2,initialArrayPosition);	
		System.out.println(Arrays.toString(diff));
 		System.out.println("");
 		//run time O(n)
 		for( int i=0; i<nonabsdiff.length; i++) {
			diff2dArray[0][i]= nonabsdiff[i];
 		}
 		//run time O(n)
 		for( int i=0; i<diff.length; i++) {
			diff2dArray[1][i]=diff[i];
 		}
 		System.out.println("size of 2d array"+ diff2dArray[0].length);
 		
 	
 		
 		//step 7  Run time O(n) since its still utilizing a form of quick sort
 		minNumbers2d(diff2dArray, 1, diff2dArray[1].length-1, k);
 		 		
 		
 		//step8 run Time O(n) since its one for loop
 		System.out.print("closest K values to median are [");
 		for(int i =1; i<k+1;i++) {
 			int tempDiff = diff2dArray[0][i]+median;
 			diff2dArray[0][i]= tempDiff;
 			System.out.print(diff2dArray[0][i]+",");
 		}
 		System.out.println("]");
 		System.out.println("Total runtime is O(n)+O(n)+O(n)+O(n)+O(n) = O(n)");
	}
	


public static void Swap(int [] arr,int a, int b ) {
	int temp = arr[a];
	arr[a]=arr[b];
	arr[b]=temp;
}


public static int quick_select(int[] a, int left, int right, int k) {
//	int pIndex= calculatePivot(a,left,right);
	int median=0;
	int pIndex = 0;

		pIndex = Partition(a, left, right);
	//	int partition;
		if(k== pIndex) {
			return median = a[pIndex];
			
			//System.out.println("k is: " + a[pIndex]);
	        
		}else if(k<pIndex) {
			return quick_select(a,left,pIndex-1,k); 
		}else if(k>pIndex) {
			return quick_select(a,pIndex+1,right,k);
	        
	   }

   //}

	return -101;
}// end quickselect




public static int calculatePivot(int[] a, int left, int right) {
	int middle = (right + left) / 2;
    int pivot =0;
    //checks the position of the first, last, and middle number and then compares to find which number will be the median
    //once it compares the 3 values it will define that number as the pivot
	if( (a[left] > a[middle]) && (a[left] < a[right])  || ( (a[left]<a[middle]) && (a[left]>a[right]) )){
		pivot= left;
	}else if ( (a[right]>a[middle]) && (a[right]<a[left]) || ( (a[right]<a[middle]) && (a[right]>a[left]) ) ) {
		pivot = right;
	}else if( (a[middle]>a[left]) && (a[middle]<a[right]) || ( (a[middle]>a[right]) && (a[middle]<a[left]) )) {
		pivot = middle;
	}
	/*else if( (a[middle]>a[right]) && (a[middle]<a[left]) ) {
		pivot = middle;
	}*/
	
	//this portion swaps the index of pivot w/ the last value of the array to make it easier to
	//work with the pivot
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
	int pivotIndex = calculatePivot(a,left,right);//call calculatePivot in order to get a new pivot index each time Partition is called
	int pivot= a[pivotIndex];//pivot value
	int leftPointer = left;//update leftPointer
	int rightPointer = right - 1;//updaterightPointer one less than right to be less than pivot
	int temp = 0;//initialize temp to 0
//	System.out.println("pivot index is"+ pivotIndex);
//	System.out.println("pivot is:"+ pivot);
	// System.out.println(Arrays.toString(a));

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
		}else if( a[leftPointer]== a[rightPointer]){
			leftPointer++;
			rightPointer--;
		} else {
		temp = a[leftPointer];
		a[leftPointer] = a[rightPointer];
		a[rightPointer] = temp;

		}
	} // end while true
	 // System.out.println(Arrays.toString(a));
	
	temp = a[leftPointer];
	a[leftPointer] = a[right];
	a[right] = temp;

	return leftPointer;// this value is the new pivot

}// end partition function
	
	


public static void Swap2d(int [][] arr, int a, int b ) {
	int temp = arr[1][a];
	arr[1][a]=arr[1][b];
	arr[1][b]=temp;
	
	int temp2 = arr[0][a];
	arr[0][a]=arr[0][b];
	arr[0][b]=temp2;

}

public static  int minNumbers2d(int[][] a, int left, int right, int k) {
	/*
	if(a.length==1) {//check for array length to be greater than 1 to be able to find the max value
		System.out.print(a[0]+"  ");
	}else {
*/
		int pIndex = PartitionAbsolute(a, left, right);
		
		if(k== pIndex) {//if k= pIndex print out values
			
			System.out.print("k closest values are: [");
			for(int i=pIndex;i>0;i--) { //for loop to print out K max values
				System.out.print(a[1][i]+"  ");
			}
			System.out.println("]");
		//	System.out.println("k is: " + a[pIndex] );
		}else if(k<pIndex) {//if k<pIndex recursively call maxNumbers with updated left and right
			minNumbers2d(a,left,pIndex-1,k); 
		}else if(k>pIndex) {//if k>pIndex recursively call maxNumbers with updated left and right
			minNumbers2d(a,pIndex+1,right,k);	        
	   }
	//}
	return -1;	

}

public static int calculatePivot2(int[][] a, int left, int right) {
	int middle = (right + left) / 2;
    int pivot =0;
    //checks the position of the first, last, and middle number and then compares to find which number will be the median
    //once it compares the 3 values it will define that number as the pivot
	if( (a[1][left] > a[1][middle]) && (a[1][left] < a[1][right])  || ( (a[1][left]<a[1][middle]) && (a[1][left]>a[1][right]) )){
		pivot= left;
	}else if ( (a[1][right]>a[1][middle]) && (a[1][right]<a[1][left]) || ( (a[1][right]<a[1][middle]) && (a[1][right]>a[1][left]) ) ) {
		pivot = right;
	}else if( (a[1][middle]>a[1][left]) && (a[1][middle]<a[1][right]) || ( (a[1][middle]>a[1][right]) && (a[1][middle]<a[1][left]) )) {
		pivot = middle;
	}

	
	//this portion swaps the index of pivot w/ the last value of the array to make it easier to
	//work with the pivot
	if (pivot == left) {
		Swap2d(a,right,left);
		pivot = right;
	} else if ( pivot == middle) {
		Swap2d(a,middle,right);
		pivot = right;
	} else  {
		pivot = right;
	}

	return pivot;
}



public static int PartitionAbsolute(int[][] a, int left, int right) {
	int pivotIndex = calculatePivot2(a,left,right);//call calculatePivot in order to get a new pivot index each time Partition is called
	int pivot= a[1][pivotIndex];//pivot value
	int leftPointer = left;//update leftPointer
	int rightPointer = right - 1;//updaterightPointer one less than right to be less than pivot
	int temp = 0;//initialize temp to 0
//	System.out.println("pivot index is"+ pivotIndex);
//	System.out.println("pivot is:"+ pivot);
	// System.out.println(Arrays.toString(a));

	while (true) {
		// this while loop acts as left hand and will compare value at left side against
		// pivot
		// if value is less than pivot then move to next right location
		while (a[1][leftPointer] <= pivot && leftPointer<rightPointer) {
			leftPointer++;// increment because a[leftPointer]> pivot
		}
		// this while loop acts as right hand and will compare value at right side
		// against pivot
		// if value is greater than pivot then move to next left location
		// if the value reaches the first position it will no longer decrement
		while (rightPointer > 0 && a[1][rightPointer] >= pivot) {
			rightPointer--;// decrement because a[rightPointer]> pivot
		}

		// takes a look at location of leftPointer and rightPointer
		// if its less than right Pointer then swap values of a[leftPointer] and
		// a[rightPointer]
		// if leftPointer> rightPointer it means that it passed the location meaning
		// numbers are sorted
	
		if (leftPointer > rightPointer ) {
			break;// gets out of while loop when the if statement condition is met
		}else if( a[1][leftPointer]== a[1][rightPointer]){
			leftPointer++;
			rightPointer--;
		} else {
		Swap2d(a,leftPointer,rightPointer);	

		}
	} // end while true
	 // System.out.println(Arrays.toString(a));
	Swap2d(a,leftPointer,right);
	return leftPointer;// this value is the new pivot

}// end partition function
	

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
