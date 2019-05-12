package ProgrammingAssignment2;

public class SquareRootFunction {
	
	
	
	
	public  int squareRoot(int keyValue) {		
		int ceilingIncrement=1; // add one
		int low = 0;
		int updateByone=1;
		int high = keyValue;
		int middle = 0;
		while (low != high && (keyValue!= middle*middle) ) {
			middle = (low + high) / 2;//picks upper digit from remainder 
			if (high < low) {
			} else if (keyValue < middle*middle) {
				high = high - updateByone;
			} else if (keyValue > middle*middle) {
				low = low + updateByone;
			}
		} // end while loop
		
//		System.out.println();
		if(keyValue== middle*middle) {
			System.out.println("Square root value is:"+ middle);
			return middle ;
		}else
		System.out.println("Ceiling square root value is: "+ (middle + ceilingIncrement) );
		return (middle + ceilingIncrement)  ;
	}// end binarysearch function

	
	
	
	
	
	
}
