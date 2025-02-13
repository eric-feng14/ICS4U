package unit_0_review;
import java.util.Scanner;

/**
 * Calculates the tax for a given income
 * @author Eric Feng
 * @version Feb 10 2025
 */
public class A4E1 {

	public static void main(String[] args) {
		// Declare constants and variables
		final int amount1 = 27500, amount2 = 55000;
		final double rate1 = 0.17, rate2 = 0.24, rate3 = 0.29;
		double income, tax = 0;
		
		// Collect input
		Scanner input = new Scanner(System.in);
		income = input.nextInt();
		input.close();

		if (income > 0) {
			if (income <= amount1) {
				tax = rate1 * income;
			}
			else if (income <= 55000) {
				tax = (rate1 * amount1) + (rate2 * (income - amount1));
			}
			else {
				tax = (rate1 * amount2) + (rate3 * (income - amount2));
			}
			
			System.out.format("%.2f", tax);
		}
		else {
			System.out.println("Invalid income");
		}
	}

}
