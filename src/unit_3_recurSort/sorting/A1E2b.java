package unit_3_recurSort.sorting;
import java.util.*;
import java.io.*;

/**
 * Exercise a of Q2	for the first few sorting exercises
 * @author Eric Feng
 * @version April 5 2025
 */
public class A1E2b {
	
	final static private int SIZE = 8000;
	
	/**
	 * returns the value that is greater than or equal to "val"
	 * @param arr arr is the array that we are searching
	 * @param val val is the threshold for how large the resulting value should be, the previous value in the sorted array
	 * @param idx idx is the index of the "val"
	 */
	public static int[] search(int[] arr, int val, int idx) {
		int upperLimit = Integer.MAX_VALUE; //alternatively, you could make this a very large value
		int[] temp = new int[2];
		
		/*
		 * Loop all elements and search for elements that are greater than or equal to "val".
		 * For all of these elements, find the minimum of them. 
		 */
		for (int i = 0; i < arr.length; i++) {
			int elem = arr[i];
			
			//Checks for duplicates, and returns right away so that the index tracking can be kept in order
			// e.g. imagine the array {6,4,3,1,1,1}. You cannot loop to the end each time because you want to make use of "i > idx"
			if (elem == val && i > idx) {
				return new int[] {elem, i};
			}
			
			//Normal checking if there were no duplicate elements
			if (elem > val && elem < upperLimit) {
				upperLimit = elem; //lower the upper bound (min value <= "val")
				temp[0] = elem;
				temp[1] = i;
			}
		}
		
		return temp;
	}
	
	/**
	 * searches through the number.txt file and prints out a sorted array
	 */
	public static void sort() {
		//Read input from a file
		try {
			Scanner input = new Scanner(new File("numbers.txt"));
			int[] originalNums = new int[SIZE];
			int[] sortedNums = new int[originalNums.length];
			int k = 0;
			
			//Collect input and store the numbers in an array of size 8000
			while (input.hasNext()) {
				originalNums[k] = input.nextInt();
				k++;
			}
			
			//Place the correct elements in the correct positions
			int val = -1, idx = -1;
			for (int i = 0 ; i < sortedNums.length; i++) {
				int[] tmp = search(originalNums, val, idx);
				val = tmp[0];
				idx = tmp[1];
				sortedNums[i] = val;
				System.out.println(val);
			}
		
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		sort();
	}
}
