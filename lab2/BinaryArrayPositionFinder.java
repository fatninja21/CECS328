package ProgrammingAssignment2;

public class BinaryArrayPositionFinder {

	public int binaryArrayPositionSearch(int[] list) {
        int low = 0;
        int high = list.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (list[middle] == 1  && ((list[middle-1] ) == 1)) {
            		high = middle - 2;
            } else if ((list[middle] == 1  &&list[middle-1] == 0)) {
                	System.out.println("K is : "+ middle);
                    return middle;
            }else if (list[middle] == 0 && (list[middle+1] == 0)) {
            		low = middle + 2;
            } else if ((list[middle] == 0 &&list[middle+1] == 1)) {
                	System.out.println("K is : "+(middle+1));
                	return middle + 1;
            }
        }//end while
        return -1;
    }

}
