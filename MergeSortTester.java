/*======================================
  class MergeSortTester

  ALGORITHM:
  While the array to be sorted is greater than length one, cut the list in half, sort each half, and then merge it.
  To merge two ordered lists, create another array and add elements from the two arrays to be merged, smallest first.  

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(n log n)

  Mean execution times for dataset of size n:
  Batch size: 100
  n=1        time: 0 s
  n=10       time: 0.0001 s
  n=100      time: 0.0001 s
  n=1000     time: 0.0003 s
  n=10000    time: 0.0019 s
  n=100000   time: 0.0213 s
  n=1000000  time: 0.2497 s
  n=10000000 time: 2.7912 s

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class MergeSortTester 
{

    /******************************
     * execution time analysis 
     *  Run the MergeSort code for randomized data sets with a search space
     *  that will increase by magnitudes of 10.
     *  For each search space, create a text file
     *  and record the runtime for each run of MergeSort into that file.
     ******************************/
    public static void main( String[] args ) 
    {
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
    }//end main

}//end class