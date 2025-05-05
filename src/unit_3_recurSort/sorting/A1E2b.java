package unit_3_recurSort.sorting;
import java.util.*;
import java.io.*;

public class A1E2b {
	
	final static private int SIZE = 8000;
	
	public static int minValue(int[] arr) { 
		int m = Integer.MAX_VALUE;
		for (int i : arr) {
			if (i < m) {
				m = i;
			}
		}
		return m;
	}
	
	/**
	 * returns the value that is greater than or equal to "val"
	 * assumes all values in the array are distinct
	 * @param arr
	 * @param val
	 */
	public static int search(int[] arr, int val) {
		int min_val = val;
		int[] greaterValues = new int[SIZE];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == val) return arr[i];
			if (arr[i] > val) {
				greaterValues[i] = arr[i];
			}
		}
		return minValue(greaterValues);
	}
	
	public static void sort() {
		//Read input from a file
		try {
			Scanner input = new Scanner(new File("numbers2.txt"));
			int[] originalNums = new int[SIZE];
			int idx = 0;
			//Collect input
			while (input.hasNext()) {
				int n = input.nextInt();
				originalNums[idx] = n;
				idx++;
			}
			int[] sortedNums = new int[SIZE];
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		sort();
	}
}
