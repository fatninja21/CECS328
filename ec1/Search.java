package ec1;

import java.util.Random;


public class Search {
	//empty constructor
	public Search() {
	}
	

	public double max(int a, int b){
		double max=0;
		if(a>b) {
			max = a;
		}else if (a<b) {
			 max=b;
		}else if( a==b) {
			max =a;
		}
		return max;
	}
	
	public double min(int a, int b){
		double min=0;
		if(a>b) {
			min = b;
		}else if (a<b) {
			 min=a;
		}else if( a==b) {
			min =a;
		}
		return min;		
	}
	
	
    public void Median(int[] arrayA,int aLeft, int aRight, int[]arrayB, int bLeft, int bRight) {
    	double median = 0.00;
        int middleB= (bLeft + bRight) / 2;
        int middleA= (aLeft + aRight) / 2;
        //base case
        //if both array size of array A and array B is size 2
        int aSize = aRight-aLeft;
        int bSize= bRight-bLeft;
        if((aSize==1) && (bSize==1)) 
        { 
       //array is sorted and size is 4 therefore
       //sake of formating made maxInt and minInt into integers
       int maxInt=(int) max(arrayA[aLeft],arrayB[bLeft]);
       int minInt= (int) min(arrayA[aRight],arrayB[bRight]);
       //calculate minimum
       median = (max(arrayA[aLeft],arrayB[bLeft]) + min(arrayA[aRight],arrayB[bRight]))/2;
       System.out.println("Median is equal to ("+ maxInt +"+"+ minInt +")"+ "/2"+"= " + median);
        
        }else 
	        //if array size is even then do the following   	
        	if ( ((bSize)%2 ==0) && ((aSize)%2 ==0) ) {
        		//check on middle values of both arrays to determine recursive call
	    	   if(arrayA[middleA]>arrayB[middleB]) {
	    		   Median(arrayA,aLeft,middleA,arrayB, middleB, bRight);
		       }
		       else if(arrayA[middleA]<arrayB[middleB]) {//if array a value is less than b then 
		    	   Median(arrayA,middleA,aRight,arrayB,bLeft,middleB);//array a starts with middle- right array b starts with left - middle
		       }
	    	 //if array size is odd then do the following
           } else if (((aSize)%2 !=0)&& ((bSize)%2 !=0) ) {
        	   if(arrayA[middleA]>arrayB[middleB]) {
	    		   Median(arrayA,aLeft,middleA,arrayB, middleB, bRight);
		       }
		       else if(arrayA[middleA]<arrayB[middleB]) {
		    	   Median(arrayA,middleA,aRight,arrayB,bLeft,middleB+1);
		       }
           }
	//	return median;    
    }
    
	
    
    public int[] generateIntArray(int size, int max, int min) {
		int[] a = new int[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = randomNumber(max, min);
		}
		return a;
	}//end generateIntArray

	public int randomNumber(int max, int min) {
		Random rand = new Random();
		int number = rand.nextInt((max - min) + 1) + min;
		return number;
	}//end randomNumber



    public  void SmallestMissingInt(int[] a,int left, int right) {
        int middle= (left + right) / 2;
        int currentMissingInt=0;
        //this is if there is no missing number so smallest missing would be one after the last
        if (left > right) {
            currentMissingInt= right + 1;
            System.out.println("Smallest missing int is "+ currentMissingInt);
        //since array is sorted checks against left value. if left (usually initially 0 does not equal a[left] then missing int should be left
        }else if (left != a[left]){ 
            currentMissingInt= left;
            System.out.println("Smallest missing int is "+ currentMissingInt);
        }
        //if this condition is true the the element that is missing has to be to the right of the array
        //since the array is sorted and middle= list[middle] then every value before it would be unable to have a missing number
        else if(a[middle] == middle  ) {
        	 SmallestMissingInt(a, middle+1,right);
        //if a[mid]!= middle then that means the smallest missing value should be in the left
        }else if(a[middle]!=middle) { 
        	SmallestMissingInt(a, left, middle);
        }

    }

 	
}

