package unit_3_recurSort.sorting;
import java.util.*;
import java.io.*;

/**
 * Exercise a of Q2	for the first few sorting exercises
 * @author Eric Feng
 * @version April 5 2025
 */
public class A1E2a {
	
	final static private int SIZE = 119;
	
	/**
	 * returns the value that is greater than or equal to "val"
	 * assumes all values in the array are distinct
	 * @param arr arr is the array that we are searching
	 * @param val val is the threshold for how large the resulting value should be
	 */
	public static int search(int[] arr, int val) {
		int upperLimit = Integer.MAX_VALUE; //alternatively, you could make this a very large value
		
		/*
		 * Loop all elements and search for elements that are greater than or equal to "val".
		 * For all of these elements, find the minimum of them. 
		 */
		for (int i : arr) {
			if (i > val && i < upperLimit) {
				upperLimit = i;
			}
		}
		
		//Value not found: there is no number that is greater than val
		if (upperLimit == Integer.MAX_VALUE) {
			return -1;
		}
		return upperLimit;
	}
	
	
	public static void sort() {
		//Read input from a file
		try {
			Scanner input = new Scanner(new File("numbers2.txt"));
			int[] originalNums = new int[SIZE];
			int[] sortedNums = new int[SIZE];
			int idx = 0;
			
			//Collect input and store the numbers in an array of size 8000
			while (input.hasNext()) {
				originalNums[idx] = input.nextInt();
				idx++;
			}
			
			//Place the correct elements in the correct positions
			int val = -1;
			for (int i = 0 ; i < sortedNums.length; i++) {
				val = search(originalNums, val);
				sortedNums[i] = val;
				System.out.format("%d, %d\n", sortedNums[i], i);
			}
			
			//Output the values
//			for (int i : sortedNums) {
//				System.out.println(i);
//			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		sort();
	}
}
