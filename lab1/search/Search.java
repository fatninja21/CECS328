package search;

import java.util.Random;


public class Search {
	//empty constructor
	public Search() {
	}
	
	public int linearSearch(int[] data, int key) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == key) {
				// System.out.println("key was in linear location: " + i);
				return i;
			}
		}
		return -1001;// if key does not exist
	}//end linearsearch

	public  int binarySearch(int[] list, int keyValue) {		
		int low = 0;
		int high = list.length - 1;
		int middle = 0;
		while (low != high) {
			middle = (int) Math.ceil((low + high) / 2);//picks upper digit from remainder 
			if (high < low) {
			} else if (keyValue < list[middle]) {
				high = middle - 1;
			} else if (keyValue > list[middle]) {
				low = middle + 1;
			} else if (keyValue == list[middle]) {
				return middle;
			}
		} // end while loop
		return -10001;
	}// end binarysearch function

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


}
