package unit_3_recurSort.sorting;
import java.io.*;
import java.util.*;

/**
 * Searches through a file of numbers and determines whether a specific number exists in the sequence
 * @author Eric Feng
 * @version April 5 2025
 */
public class A1E1 {
	
	final private static int SIZE = 8000;
	
	/**
	 * Checks if a specific number exists within the "numbers.txt" file
	 * @param num num is the desired number, the one to search for
	 * @return returns a boolean value representing whether the number is in the file or not
	 */
	public static boolean numExists(int num) {
		
		//Read input from a file
		try {
			Scanner input = new Scanner(new File("numbers.txt"));
			int[] nums = new int[SIZE];
			int idx = 0;
			//Collect input and store it the array "nums"
			while (input.hasNext()) {
				nums[idx] = input.nextInt();
				idx++;
			}
			
			//Loop through the array and check if each element equals the desired one
			for (int i : nums) {
				if (i == num) return true;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		
		//Once execution reaches here, it means the result was not found.
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Which number do you want to check? ");
		int n = input.nextInt();
		System.out.println(numExists(n));
		
	}

}
