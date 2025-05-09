package unit_3_recurSort.sorting;
import java.io.*;
import java.util.*;

/**
 * Insertion sort algorithm
 * @author Eric Feng
 * @version May 9 2025
 */
public class InsertionSort {
	final private static int SIZE = 8000;
	
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
			
//			int[] nums = {4,3,2,1};
			
			//Loop through all array elements
			for (int i = 1; i < nums.length; i++) {
				int val = nums[i], j = i;
				//Continue shifting elements until the desired position is found -> this could be optimized with binary search
				for (; j > 0 && val < nums[j-1]; j--) {
					nums[j] = nums[j-1];
				}
				nums[j] = val;
			}
			
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
