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
	 * searches through the number.txt file and prints out a sorted array
	 */
	public static void sort() {
		//Read input from a file
		try {
			Scanner input = new Scanner(new File("numbers.txt"));
			int[] originalNums = new int[SIZE];
			int[] sortedNums = new int[SIZE];
			int idx = 0;
			
			//Collect input and store the numbers in an array of size 8000
			while (input.hasNext()) {
				originalNums[idx] = input.nextInt();
				idx++;
			}
			
			//Loop through all of the sorted numbers
			for (int i = 0; i < sortedNums.length; i++) {
				int currentElement = originalNums[i];
				int j = i - 1;
				
				/*
				 * Start from the element before currentElement and search to the left. If the value is greater than currentElement, 
				 * it means that the value should be placed more to the left: continue searching. 
				 * Only when you reach a value that is less than or equal to currentValue, you would stop searching. 
				 * Then, we insert "currentElement" into the corresponding open position.
				 * Notice that all subsequent elements would be shifted 1 space to the right.
				 * This is basically the same thing as finding the index of the smallest element that is greater than currentElement.
				 * You could also perform this loop starting from index 0, it wouldn't make a difference. 
				 * The idea is to shift the elements and insert the current element to its corresponding position.
				 */
				while (j >= 0 && sortedNums[j] > currentElement) {
					sortedNums[j+1] = sortedNums[j];
					j--;
				}
				sortedNums[j+1] = currentElement;
			}
			
			//Output the values
			for (int i : sortedNums) {
				System.out.println(i);
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
