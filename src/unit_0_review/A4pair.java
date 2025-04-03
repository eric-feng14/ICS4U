package unit_0_review;
import java.util.Scanner;

/**
 * Prints a receipt for lunch at a restaurant
 * @author Eric Feng
 * @version Feb 12 2025
 */
public class A4pair {

	public static void main(String[] args) {
		// Declare constants
		final int BOUNDARY = 4;
		final double TAX13 = 0.13, TAX05 = 0.05;
		double addedTaxPercent = TAX13 - TAX05;
		
		// Declare variables
		double baseTax = 0.05, taxAmount, mealCost, total;
		int taxPercent;
		
		// Collect input
		Scanner input = new Scanner(System.in);
		mealCost = input.nextDouble();
		input.close();
		
		// Add necessary tax
		if (mealCost > BOUNDARY) {
			baseTax += addedTaxPercent;
		}
		
		// Calculations
		taxAmount = baseTax * mealCost;
		total = mealCost + taxAmount;
		taxPercent = (int) (baseTax * 100);
		
		// print out receipt information
		System.out.println("WOSS Gift Shop Receipt");
		System.out.println("----------------------");
		System.out.format("Meal cost:      $%5.2f\n", mealCost);
		System.out.println("                ------");
		System.out.format("HST (%2d%%)       $%5.2f\n", taxPercent, taxAmount);
		System.out.println("                ------");
		System.out.format("TOTAL           $%5.2f", total);

	}

}
