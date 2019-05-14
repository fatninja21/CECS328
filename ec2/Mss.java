package ec2;

import java.util.Arrays;
import java.util.Random;


public class Mss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("Enter a number for value N:");
		int n= (CheckInput.getPositiveInt());
		int []a= new int[n];
		 int minArrayValue = -100; int maxArrayValue = 100;
		a = generateIntArray(n, maxArrayValue, minArrayValue);
		System.out.println(Arrays.toString(a));
		
//		int []a= { -5,-6,4,6,2,-1,-7,10,-6,-5,-3,5};
		int []b= {21, -67, 99, -1, 93};
		int maxSum= MSS(a,0,a.length-1);
		System.out.println("MSS is "+ maxSum);
		int bestSum= MSSFaster(a);
		System.out.println("MSS faster is"+ bestSum);
		
	}
	
	
	
	public static int MSSM(int []a, int left, int middle, int right) {
	//left sum 
	int sum =0;
	int leftSum= -1000;
	//for loop to keep finding new max sum for left side
	for ( int i=middle; i>=left; i--) {
		sum= sum+ a[i]; // add current sum to a[i]
		// check condition if current sum is greater than sumvalue then update leftsum 
		if(sum> leftSum)  
			leftSum=sum;
	}
	sum=0;
	
	//right sum
	int rightSum=-1000;
	//for loop to keep finding new max sum for right side 
	for(int i=middle+1;i<=right;i++) {
		sum= sum+ a[i];
		// check condition if current sum is greater than sumvalue then update rightsum 
		if(sum> rightSum) 
			rightSum=sum;
	}
		//return the adddition of both sides
		return leftSum+rightSum;
	}
	
	
	
	
	
	public static int MSS(int []a, int left, int right ) {
		
		int middle = (left + right)/2;
		if( left == right ) {
			return a[left];
		}
		//recursive call left
		int mss_left = MSS(a,left,middle);
		//recursive call right
		int mss_right= MSS(a,middle+1,right);
		//recursive call middle
		int mss_middle = MSSM(a,left,middle,right);
		//return max of three recursive calls 
		return MaxOfThree(mss_left,mss_right,mss_middle);
	}
	
	public static int MaxOfThree(int a, int b, int c) {
		if( a>b && a>c) {
			return a;
		}else if( b>a && b>c) {
			return b;
		}else
			return c;
	}

	public static int MSSFaster(int []a) {
		int maxSum=0;
		int sum = 0;
		for(int i=0; i<a.length;i++) {
			sum+=a[i];
			if ( sum>maxSum) {
				maxSum= sum;
			}else if(sum<0) {
				sum=0;
			}
		}
		return maxSum;
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
