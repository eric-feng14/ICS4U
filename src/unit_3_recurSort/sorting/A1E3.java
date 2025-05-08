package unit_3_recurSort.sorting;
import java.util.*;
import java.io.*;

/**
 * Bubble sorting algorithm
 * @author Eric Feng
 * @version May 8 2025
 */
public class A1E3 {

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
			
			//Loop through the whole array for a maximum of length of "nums" array times
			for (int i = 0; i < nums.length; i++) {
				boolean swapped = false; //check if we perform any swpas
				for (int j = 0; j < nums.length - 1; j++) {
					//If the left element is greater than the right element, swap them
					if (nums[j] > nums[j+1]) {
						int tmp = nums[j];
						nums[j] = nums[j+1];
						nums[j+1] = tmp;
						swapped = true;
					}
				}
				//If we don't perform any swaps, the array is already sorted
				if (! swapped) {
					break;
				}
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
