package unit_0_review;

/**
 * Prints a gift shop receipt
 * @author Eric, Jovitha
 * @version Feb 6 2025
 */
public class A2pair {

	public static void main(String[] args) {
		// Declared variables
		double item1, item2, item3, sum, tax, total;
		item1 = 12.89;
		item2 = 18.99;
		item3 = 20.00;
		sum = item1 + item2 + item3;
		tax = 0.13 * sum;
		total = 1.13 * sum;
		
		// print out receipt information
		System.out.println("WOSS Gift Shop Receipt");
		System.out.println("----------------------");
		System.out.format("glove     $10%.2f\n", item1);
		System.out.format("toque     $%.2f\n", item2);
		System.out.format("scarf     $%.2f\n", item3);
		System.out.println("          -----");
		System.out.format("HST (13%%)  $%.2f\n", tax);
		System.out.println("          -----");
		System.out.format("TOTAL     $%.2f", total);
	}

}
