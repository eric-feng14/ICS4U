package unit_0_review;
import java.util.*;

/**
 * Determine if an array of 5 doubles entered by the user is in sorted order(smallest to largest)without using the sort method
 * @author Eric Feng
 * @version Feb 28 2025
 */
public class A7E1 {

	public static void main(String[] args) {
		//Constant
		final int NUMBER_OF_INPUTS = 5; 
		
		//Initialize array
		double [] arr = new double[NUMBER_OF_INPUTS];
		boolean isSorted = true;
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < NUMBER_OF_INPUTS; i++) {
			arr[i] = input.nextDouble();
		}
		input.close();
		
		double prev_element = arr[0];
		for (int i = 1; i < arr.length;i++) {
			if (arr[i] < prev_element) {
				isSorted = false;
				break;
			}
			prev_element = arr[i];
		}
		
		if (isSorted) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

}
