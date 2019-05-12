package lab4;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {	
		
		//*****************PART A****************************************************************//
		//implement quick_select to find the k least element
        System.out.println("*******************************PART A*******************************************");
        System.out.println("Least K Value  ");
        System.out.println("_______________");
		System.out.print("Enter a number for value N:"); 
		int n= (CheckInput.getPositiveInt());
		System.out.print("Enter a k value greater than 1 and less than n: ");
		int high=n; int low=1; // ranges for k 
		int k=(CheckInput.getIntRange(low, high));
		int initialArrayPosition=0;
		int minArrayValue=-100; int maxArrayValue=100;
		int []arrayA= new int [n];// create an array with n amount of integers
		arrayA = generateIntArray(n, maxArrayValue, minArrayValue);
	//System.out.println(Arrays.toString(arrayA));
		int kUpdatedIndex= k-1;
		System.out.print("Unsorted Array");
		System.out.println(Arrays.toString(arrayA));
		quick_select(arrayA,initialArrayPosition,arrayA.length-1,kUpdatedIndex);
		Arrays.sort(arrayA);
		  System.out.print("first values of the array are: [");
        for(int i=0; i<k; i++) {
        	System.out.print(arrayA[i]+ " ");
        }
        System.out.println("]");
        
        
//**************************PART B************************************************************//
//Part B modifies quick_Select in order to return maxK numbers from an unsorted array
		
        System.out.println("*******************************PART B*******************************************");
        System.out.println("Max K Numbers");
        System.out.println("_______________");
        System.out.print("Enter a number for value N:"); 
		n= (CheckInput.getPositiveInt());
		System.out.print("Enter a k value greater than 1 and less than n: ");
		k=(CheckInput.getIntRange(low, high));//k cannot be less than 1 and greater than n
		int []arrayB= new int [n];// create an array with n amount of integers	 
		int kMax=arrayB.length-1-(k);//update index for K
		arrayB = generateIntArray(n, maxArrayValue, minArrayValue);//create arrayB with random integers
		System.out.print("Unsorted Array");
		System.out.println(Arrays.toString(arrayB));
		maxNumbers(arrayB,initialArrayPosition,arrayB.length-1,kMax);//call function to return max numbers in array

	}


public static void Swap(int [] arr,int a, int b ) {
	int temp = arr[a];
	arr[a]=arr[b];
	arr[b]=temp;
}

public static void quick_select(int[] a, int left, int right, int k) {
//	int pIndex= calculatePivot(a,left,right);
	if(right - left == 1){ //array size of current iteration is 2
        if(a[left] > a[right]) { //swap if out of order
            Swap(a,right,left);
        }
    }else {
	
		int pIndex = Partition(a, left, right);
	//	int partition;
		if(k== pIndex) {
			System.out.println("k is: " + a[pIndex]);
	        
		}else if(k<pIndex) {
			quick_select(a,left,pIndex-1,k); 
		}else if(k>pIndex) {
			quick_select(a,pIndex+1,right,k);
	        
	   }
   }
}// end quickSort


public static void maxNumbers(int[] a, int left, int right, int k) {
	if(a.length==1) {//check for array length to be greater than 1 to be able to find the max value
		System.out.print(a[0]+"  ");
	}else {
		int pIndex = Partition(a, left, right);
		
		if(k== pIndex) {//if k= pIndex print out values
			
			System.out.print("k max values are: [");
			for(int i=pIndex+1;i<a.length;i++) { //for loop to print out K max values
				System.out.print(a[i]+"  ");
			}
			System.out.println("]");
		//	System.out.println("k is: " + a[pIndex] );
		}else if(k<pIndex) {//if k<pIndex recursively call maxNumbers with updated left and right
			maxNumbers(a,left,pIndex-1,k); 
		}else if(k>pIndex) {//if k>pIndex recursively call maxNumbers with updated left and right
			maxNumbers(a,pIndex+1,right,k);	        
	   }
	}	

}

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