package unit_0_review;
import java.util.*;

/**
 * Prints out a savings schedule and grant amount based on user input
 * Notes: the logic when collecting input was a bit buggy. try to fix it tomorrow.
 * @author Eric Feng
 * @version Feb 24 2025
 */
public class LastnameSavings {

	public static void main(String[] args) {
		// Declare variables
		int annualContribution, numberOfYears;
		double annualInterestRate;
		boolean inputFinished = false, interestExists = false, contributionExists = false, yearNumExists = false;

		// Continue collecting input until all variables have been initialized
		while (! inputFinished){
			try { // Collect input
				Scanner input = new Scanner(System.in);

				if (! contributionExists) {
					System.out.print("Enter the annual contribution amount: ");
					annualContribution = input.nextInt();
					if (annualContribution < 0) {
						continue;
					} else {
						contributionExists = true;
					}
				}

				if (! interestExists) {
					System.out.print("Enter the annual interest rate (int): ");
					annualInterestRate = input.nextInt() / 100;
					if (annualInterestRate < 0) {
						continue;
					} else {
						interestExists = true;
					}
				}

				if (! yearNumExists) {
					System.out.print("Enter the number of years you want to save for: ");
					numberOfYears = input.nextInt();
					if (numberOfYears < 0) {
						continue;
					} else {
						yearNumExists = true;
					}
				}

				input.close();
				inputFinished = true;
			} catch (Exception ex) { //catch any exception e.g. InputMismatch
				System.out.println("Invalid input!");
			}
		}

		// Perform Calculations


		// Output

	}

}
