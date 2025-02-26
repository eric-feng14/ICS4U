package unit_0_review;
import java.util.*;

/**
 * Prints out a savings schedule and grant amount based on user input
 * @author Eric Feng
 * @version Feb 24 2025
 */
public class FengSavings {

	public static void main(String[] args) {
		// Declare constants
		final int maxGrantAmount = 500, maxOverallGrantAmount = 7200, maxContributionTotal = 50000, maxYears = 31;
		final double grantPercent = 0.2;
		
		// Declare variables
		int numberOfYears = 0; //user inputed
		double annualContribution = 0, annualInterestRate = 0; //user inputed
		double initialBalance = 0, finalBalance = 0, currentInterest;
		boolean inputFinished = false, interestExists = false, contributionExists = false, yearNumExists = false;

		// Continue collecting input until all variables have been initialized
		while (! inputFinished){
			try { // Collect input
				Scanner input = new Scanner(System.in);

				// If the user has already enter a valid number for the annualContribution amount 
				if (! contributionExists) {
					System.out.print("Enter the annual contribution amount: ");
					annualContribution = input.nextDouble();
					// Catch negative numbers
					if (annualContribution < 0) {
						System.out.println("Invalid input! No negatives. ");
						continue; //continue until input is valid
					} else { //user has entered valid input, no need to prompt again for this question
						contributionExists = true;
					}
				}

				// Flow moves here once the user has already entered a valid contribution amount. They are now prompted to enter an interest rate.
				if (! interestExists) {
					System.out.print("Enter the annual interest rate: ");
					annualInterestRate = input.nextDouble() / 100;
					if (annualInterestRate < 0) { // catch negative numbers
						System.out.println("Invalid input! No negatives. ");
						continue;
					} else { // input is valid, moves onto the next block
						interestExists = true;
					}
				}

				// Flow moves here once contribution amount and interest rate inputs are valid. They are now prompted to enter the number of years.
				if (! yearNumExists) {
					System.out.print("Enter the number of years (int) you want to save for: ");
					numberOfYears = input.nextInt();
					if (numberOfYears < 0) { //Catch negatives
						System.out.println("Invalid input! No negatives. ");
						continue;
					} else if (numberOfYears > maxYears) { // Prevent user from entering too many years
						System.out.format("Max number of years is %d\n", maxYears);
						continue;
					} else {
						yearNumExists = true;
					}
				}
				
				// Check if the user will be putting in too much money. If so, prompt them to reenter two inputs (not the interest rate)
				if (annualContribution * numberOfYears > maxContributionTotal) {
					System.out.format("Over the course of %d years, you can contribute a maximum of $%d\n", numberOfYears, maxContributionTotal);
					contributionExists = false;
					yearNumExists = false;
					continue;
				}

				//Close input and exit out of the main while loop
				input.close();
				inputFinished = true;
			} catch (Exception ex) { // catches the error, continues to the next iteration of while until user enters valid input
				System.out.println("Invalid input!"); //output error/debug message
			}
		}

		// Calculate the current grant, create an accumulator to store the grants, store the total contributions, and store the total interest
		double currentGrant = Math.min(maxGrantAmount, grantPercent * annualContribution), totalGrantedAmount = 0;
		double totalContribution = numberOfYears * annualContribution, totalInterest = 0;
		
		//Output and calculations
		System.out.format("Year%5sInitial Balance%5sContribution%5sGrant%5sInterest%5sFinal Balance\n","","","","","","");
		for (int yr = 1; yr <= numberOfYears; yr++) {
			// Prevent the government from giving you more than some amount (7200 in this case) for your RESP
			if (totalGrantedAmount + currentGrant > maxOverallGrantAmount) {
				currentGrant = maxOverallGrantAmount - totalGrantedAmount;
			}
			// Reset initial balance for each new line (entry)
			initialBalance = finalBalance;
			
			// Calculate the final balance and interest
			finalBalance += annualContribution + currentGrant;
			currentInterest = annualInterestRate * finalBalance;
			finalBalance += currentInterest;
			
			//Keep track of how much has been granted and earned in interest
			totalGrantedAmount += currentGrant;
			totalInterest += currentInterest;
			System.out.format("%-3d%21.2f%17.2f%10.2f%13.2f%18.2f\n", yr, initialBalance, annualContribution, currentGrant, currentInterest, finalBalance);
		}
		System.out.format("After %d years, you contributed $%.2f and earned $%.2f in grants and $%.2f in interest.\n", numberOfYears, totalContribution, totalGrantedAmount, totalInterest);
		
	}

}
