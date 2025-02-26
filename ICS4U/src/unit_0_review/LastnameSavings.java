package unit_0_review;
import java.util.*;

/**
 * Prints out a savings schedule and grant amount based on user input
 * @author Eric Feng
 * @version Feb 24 2025
 */
public class LastnameSavings {

	public static void main(String[] args) {
		// Declare constants
		final int maxGrantAmount = 500, maxOverallGrantAmount = 7200, maxContributionTotal = 50000;
		final double grantPercent = 0.2;
		
		// Declare variables
		int annualContribution = 0, numberOfYears = 0;
		double initialBalance = 0, finalBalance = 0, totalGrantedAmount = 0;
		double annualInterestRate = 0, currentInterest = 0;
		boolean inputFinished = false, interestExists = false, contributionExists = false, yearNumExists = false;

		// Continue collecting input until all variables have been initialized
		while (! inputFinished){
			try { // Collect input
				Scanner input = new Scanner(System.in);

				if (! contributionExists) {
					System.out.print("Enter the annual contribution amount: ");
					annualContribution = input.nextInt();
					if (annualContribution < 0) {
						System.out.println("Invalid input!");
						continue;
					} else {
						contributionExists = true;
					}
				}

				if (! interestExists) {
					System.out.print("Enter the annual interest rate (int): ");
					annualInterestRate = input.nextDouble() / 100;
					if (annualInterestRate < 0) {
						System.out.println("Invalid input!");
						continue;
					} else {
						interestExists = true;
					}
				}

				if (! yearNumExists) {
					System.out.print("Enter the number of years you want to save for: ");
					numberOfYears = input.nextInt();
					if (numberOfYears < 0) {
						System.out.println("Invalid input!");
						continue;
					} else if (numberOfYears > 31) {
						System.out.println("Max number of years is 31");
						continue;
					} else {
						yearNumExists = true;
					}
				}
				
				if (annualContribution * numberOfYears > maxContributionTotal) {
					System.out.format("Over the course of %d years, you can contribute a maximum of $%d\n", numberOfYears, maxContributionTotal);
					contributionExists = false;
					yearNumExists = false;
					continue;
				}

				input.close();
				inputFinished = true;
			} catch (Exception ex) { //catch any exception e.g. InputMismatch
				System.out.println("Invalid input!");
			}
		}

		// Perform Calculations and output results
		int currentGrant = Math.min(maxGrantAmount, (int) (grantPercent * annualContribution));
		System.out.format("Year%3sInitial Balance%3sContribution%3sGrant%3sInterest%3sFinal Balance\n","","","","","","");
		for (int yr = 1; yr <= numberOfYears; yr++) {
			if (totalGrantedAmount > maxOverallGrantAmount) {
				currentGrant = 0;
			}
			System.out.println(totalGrantedAmount);
			initialBalance = finalBalance;
			finalBalance += annualContribution + currentGrant;
			currentInterest = annualInterestRate * finalBalance;
			finalBalance += currentInterest;
			totalGrantedAmount += currentGrant;
			System.out.format("%d%21.2f%13.2f%10.2f%10.2f%15.2f\n", yr, (double) initialBalance, (double) annualContribution, (double) currentGrant, currentInterest, (double) finalBalance);
		}
		
		
	}

}
