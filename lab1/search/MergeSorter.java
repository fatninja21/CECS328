package search;

public class MergeSorter {
	// no variables in construct
	public MergeSorter() {
	}
	public void sort(int[] a) {
		if (a.length <= 1) {
			return;
		} // an array size 1 or 0 is already sorted
		else {

			int[] first = new int[a.length / 2];
			int[] second = new int[a.length - first.length];

			// copy elements into first and second halves
			for (int i = 0; i < first.length; i++) {
				first[i] = a[i];
			}

			for (int j = 0; j < second.length; j++) {
				second[j] = a[j + first.length];
			}

			sort(first); // recursive call
			sort(second); // recursive call
			merge(first, second, a); // merge first and second halves into a
		}
	}//end sort

	public void merge(int[] firstHalf, int[] secondHalf, int[] a) {

		int iFirst = 0; // index to iterate through the first half
		int iSecond = 0; // index to iterate through the second half
		int i = 0; // index of current location in array a

		while (iFirst < firstHalf.length && iSecond < secondHalf.length) {
			if (firstHalf[iFirst] < secondHalf[iSecond]) {
				a[i] = firstHalf[iFirst]; // element in the first half is smaller
				iFirst++; // increment the index for the first half array
			} else {
				a[i] = secondHalf[iSecond]; // element in the second half is smaller
				iSecond++;
			}
			i++; // increment the current position of a
		}

		// accounting for leftover elements
		while (iFirst < firstHalf.length) // there are leftover elements in the first half
		{
			a[i] = firstHalf[iFirst];
			iFirst++;
			i++;
		}//end while (isecond< firstHalf.length)

		while (iSecond < secondHalf.length) // there are leftover elements in the second half
		{
			a[i] = secondHalf[iSecond];
			iSecond++;
			i++;
		}//end while (isecond< secondHalf.length)

	}//end merge

}
