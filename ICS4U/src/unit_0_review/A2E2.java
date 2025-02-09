package unit_0_review;

/**
 * Calculates the sum of 3 numbers and prints the result in a receipt format
 * @author Eric feng
 * @version Feb 5 2025
 */
public class A2E2 {

	public static void main(String[] args) {
		// stores 3 numbers and prints out the sum in
		double item1 = 2.55;
		double item2 = 3.2;
		double item3 = 4;
		double sum = item1 + item2 + item3;
		
		// prints out the numbers and their sum in a receipt format
		System.out.format("First item:  $ %5.2f\n", item1);
		System.out.format("Second item: $ %5.2f\n", item2);
		System.out.format("Third item:  $ %5.2f\n", item3);
		System.out.format("             -------\n");
		System.out.format("Total cost:  $ %5.2f\n", sum);
		
	}

}
