package unit_0_review;

/**
 * Calculates the sum of 3 number and prints the result
 * @author Eric Feng
 * @version Feb 5 2025
 */
public class A2E1 {

	public static void main(String[] args) {
		// stores 3 numbers and prints out the sum
		double item1 = 2.55;
		double item2 = 3.2;
		double item3 = 4;
		double sum = item1 + item2 + item3;
		
		// prints out the info (numbers, and their sum)
		System.out.format("$%.2f + $%.2f + $%.2f = $%.2f", item1, item2, item3, sum);
		
	}

}
