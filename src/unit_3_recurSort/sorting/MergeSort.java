package unit_3_recurSort.sorting;
import java.util.*;
import java.io.*;

/**
 * Merge sorting algorithm
 * Extra self note:
 * For java, primitives are passed by value, meaning that their values are copied when passed to a function.
 * Changes to these values within a function do not affect the original variable.
 * Reference types like objects or arrays, java copies the reference (memory address) to the object.
 * The method receives a copy of the reference, so that both the original and method's parameter point to the same object.
 * Within a function, changes to the object do affect the original. Note: reassigning the reference inside the method does
 * not affect the original reference. (e.g. trying to make the method array point to another one does not affect the original array's memory address)
 * For c++ you have full customizability, whenever you want to pass by reference, you add ampersand, otherwise its always pass by value
 * @author Eric Feng
 * @version May 9 2025
 */
public class MergeSort {
	final private static int SIZE = 8000;
	
	/**
	 * merges two sorted arrays together
	 * @param arr arr is the original array
	 * @param start start is where to start merging
	 * @param mid mid is the position that separates the two arrays
	 * @param end end is where to stop merging
	 */
	private static void merge(int[] arr, int start, int mid, int end) {
		int[] temp = new int[arr.length]; //sorted subarray
		int pos1 = start, idx = start, pos2 = mid+1;
		
		/*
		 * This way of doing it makes the conditions more blocky and complicated.
		 * As an alternative, you can loop through the rest of the left and the right arrays at the end
		 * e.g. while (pos1 <= mid && pos2 <= end). this guarentees that at least one of the pointers will reach the end
		 * looping through the rest of both arrays at the end ensures that we don't miss anything
		 */
		while (pos1 <= mid || pos2 <= end) {
			//Insert from right subarray if the first one is full or the second one has the smaller element
			if (pos1 > mid || (pos2 <= end && arr[pos2] < arr[pos1])) {
				temp[idx] = arr[pos2];
				pos2++;
			} else { //else if( pos2 > end || (pos1 <= mid && arr[pos1] <= arr[pos2]))
				temp[idx] = arr[pos1];
				pos1++;
			}
			idx++;
		}
		
		//Fill the original array with the sorted values from temp. Note: Java arrays are pass by reference
		for (int i = start; i <= end; i++) {
			arr[i] = temp[i];
		}
	}

	/**
	 * recursive method that divides the array into halves
	 * @param arr arr is the current array
	 * @param start start is the starting position of the array to be divided
	 * @param end end is the ending position of the array to be divided
	 */
	public static void mergeSort(int[] arr, int start, int end) {
		//If there is still room to divide, if they are equal, we reached the base case of 1 element
		if (start < end) {
			int mid = (start + end) / 2; //equivalent to start + (end - start) / 2, can be proved algebraically
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}

	public static void main(String[] args) {
		//Read input from a file
		try {
			Scanner input = new Scanner(new File("numbers.txt"));
			int[] nums = new int[SIZE];
			int k = 0;
			
			//Collect input and store the numbers in an array of size 8000
			while (input.hasNext()) {
				nums[k] = input.nextInt();
				k++;
			}
			
			mergeSort(nums, 0, nums.length - 1);

			//Output the elements
			for (int elem : nums) {
				System.out.println(elem);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
	}
}
