package unit_0_review;

/**
 * Prints a gift shop receipt
 * @author Eric, Jovitha
 * @version Feb 6 2025
 */
public class A2pair {

	public static void main(String[] args) {
		// Initialize constant
		final double HST = 0.13;
		
		// Declared variables
		double item1, item2, item3, sum, tax, total;
		item1 = 12.89;
		item2 = 18.99;
		item3 = 20.00;
		sum = 12.89 + 18.99 + 20.00;
		tax = HST * sum;
		total = sum + tax;
		
		// print out receipt information
		System.out.println("WOSS Gift Shop Receipt");
		System.out.println("----------------------");
		System.out.format("glove           $%5.2f\n", item1);
		System.out.format("toque           $%5.2f\n", item2);
		System.out.format("scarf           $%5.2f\n", item3);
		System.out.println("                ------");
		System.out.format("HST (13%%)       $%5.2f\n", tax);
		System.out.println("                ------");
		System.out.format("TOTAL           $%5.2f", total);
	}

}
