package unit_3_recurSort.sorting;
import java.io.*;
import java.util.*;

/**
 * Selection sort activity
 * @author Eric Feng
 * @version May 9 2025
 */
public class SelectionSort {

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
			
			//Loop through the entire array
			for (int i = 0; i < nums.length-1; i++) {
				//Pass "i" to find the min element through the rest of the array
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] < nums[i]) {
						int tmp = nums[i];
						nums[i] = nums[j];
						nums[j] = tmp;
					}
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
