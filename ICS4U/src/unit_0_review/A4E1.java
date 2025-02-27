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
		final int AMOUNT1 = 27500, AMOUNT2 = 55000;
		final double RATE1 = 0.17, RATE2 = 0.24, RATE3 = 0.29;
		double income, tax = 0;
		
		// Collect input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter amount: ");
		income = input.nextInt();
		input.close();

		// Check if income is valid
		if (income > 0) {
			//If income is below first rate
			if (income <= AMOUNT1) { 
				tax = RATE1 * income;
			}
			//If income is below second rate
			else if (income <= AMOUNT2) { 
				tax = (RATE1 * AMOUNT1) + (RATE2 * (income - AMOUNT1));
			}
			else {
				tax = (RATE1 * AMOUNT1) + (RATE2 * (AMOUNT2 - AMOUNT1)) + (RATE3 * (income - AMOUNT2));
			}
			
			System.out.format("Your tax is: %.2f", tax);
		}
		else {
			System.out.println("Invalid income");
		}
	}

}
