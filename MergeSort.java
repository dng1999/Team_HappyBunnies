/* Team HappyBunnies - Zicheng Zhen, Dorothy Ng, Vincent Liok
   APCS2 pd10
   HW11 -- Wrapping It Up / MergeSort Time Complexity Testing and Space Complexity
   2016-03-09 */

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  While the array to be sorted is greater than length one, cut the list in half, sort each half, and then merge it.
  To merge two ordered lists, create another array and add elements from the two arrays to be merged, smallest first.
  ======================================*/

// Used for data collection
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int indexA = 0; int lenA = a.length;
	int indexB = 0; int lenB = b.length;
	int[] ret = new int[lenA + lenB];
	for (int i = 0; i < ret.length; i++) {
	    if (indexA == lenA) {
		ret[i] = b[indexB];
		indexB++;
	    } else if (indexB == lenB) {
		ret[i] = a[indexA];
		indexA++;
	    } else if (a[indexA] > b[indexB]) {
		ret[i] = b[indexB];
		indexB++;
	    } else {
		ret[i] = a[indexA];
		indexA++;
	    }
	}
	return ret;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	int len = arr.length;
	if (len > 1) {
	    int[] a = new int[(len+1)/2];
	    int[] b = new int[len/2];
	    // Populate a and b
	    for (int i = 0; i < len; i++) {
		if (i < a.length)
		    a[i] = arr[i];
		else
		    b[i-a.length] = arr[i];
	    }
	    return merge(sort(a),sort(b));
	} else {
	    return arr;
	}
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	//System.out.println(Arrays.toString(a)); // Debugging
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) throws FileNotFoundException {


	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};
	int[] arr8 = {3,4,5,6,7,1,24,5,125,125,1,2312,4,51,51,52,125,16,123,
		      125,26,357,856,9,324,12,4,654,856,8,4542,35,675,469,67};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-8...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	printArray( sort( arr8 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	// Data Collection
	System.out.println("\nBegin Data Collection:");
	for (int i = 1; i <= 10000000; i *= 10) {
	    PrintWriter printer = new PrintWriter(new File (new String("size" + i + ".out")));
	    System.out.println("100 iterations of an array of size " + i + ":");
	    for (int j = 0; j < 100; j++) {
		int[] test = new int[i];
		for (int place = 0; place < i; place++) { // Populating the Array
		    test[place] = (int)(Math.random() * i);
		}
		long start = System.currentTimeMillis();
		sort(test);
		long end = System.currentTimeMillis();
		double time = (end - start) / 1000.0;
		printer.println(time);
	    }
	    printer.close();
	}
	
    }//end main()

}//end class MergeSort
