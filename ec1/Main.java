package ec1;

import java.util.Arrays;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	int []a= {0,2,10,26,68};
//	int []b= {1,11,18,20,41};
//	int []c= {5,6,14,26};
//	int []d= {3,41,88,100};

	System.out.println("******************PART A*******************************************");		
	Search median1= new Search();
	int []a= {0,2,10,26,68};
	int []b= {1,11,18,20,41};
	System.out.println("Array TEST 1");
	System.out.println(Arrays.toString(a));
	System.out.println(Arrays.toString(b));
	median1.Median(a,0,a.length-1, b,0,b.length-1);
	System.out.println();
	
	
	int []c= {5,6,14,26};
	int []d= {3,41,88,100};
	System.out.println("Array TEST 2");
	System.out.println(Arrays.toString(c));
	System.out.println(Arrays.toString(d));
	median1.Median(c,0,c.length-1, d,0,d.length-1);
	System.out.println();
	
	int []e= {5,10};
 	int []f= {2,41};
	System.out.println("Array TEST 3");
 	System.out.println(Arrays.toString(e));
 	System.out.println(Arrays.toString(f));
	median1.Median(e,0,e.length-1, f,0,f.length-1);
	System.out.println();
	
	
	
	System.out.println("******************PART A*******************************************");		
    Search generate= new Search();
	int m1=10;	
//	int []arrayA= new int [m1];
	int [] arrayA= {0,1,3,8,9};
	System.out.println(Arrays.toString(arrayA));
	generate.SmallestMissingInt(arrayA,0,arrayA.length-1);
//	arrayA = generate.generateIntArray(4, m1, 0);

	int m2= 15;
//	int []arrayB= new int [m2];
	int [] arrayB= {2,5,7,11};
	System.out.println(Arrays.toString(arrayB));
	generate.SmallestMissingInt(arrayB,0,arrayB.length-1);

//	arrayB = generate.generateIntArray(4, m2, 0);

	int m3=8;
//	int []arrayC= new int [m3];
	int [] arrayC= {0,1,2,3,4};
	System.out.println(Arrays.toString(arrayC));
	generate.SmallestMissingInt(arrayC,0,arrayC.length-1);

//	arrayC = generate.generateIntArray(4, m3, 0);

	int m4=13;
//	int []arrayD= new int [m4];
	int [] arrayD= {12};
	System.out.println(Arrays.toString(arrayD));
	generate.SmallestMissingInt(arrayD,0,arrayD.length-1);

//	arrayD = generate.generateIntArray(1, m4, 0);

	
	}
	
	
	

	
}
