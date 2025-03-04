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
		final int MAX_GRANT_AMOUNT = 500, MAX_OVERALL_GRANT_AMOUNT = 7200, MAX_CONTRIBUTION_TOTAL = 50000, MAX_YEARS = 31;
		final double GRANT_PERCENT = 0.2;
		
		// Declare variables
		int numberOfYears = 0; //user inputed
		double annualContribution = 0, annualInterestRate = 0; //user inputed
		double initialBalance = 0, finalBalance = 0, currentInterest;
		boolean inputFinished = false, interestExists = false, contributionExists = false, yearNumExists = false;
		
		// Prepare to collect input
		Scanner input = new Scanner(System.in);
		
		// Continue collecting input until all variables have been initialized
		while (! inputFinished){
			try { 
				// If the user has NOT already entered a valid number for the annualContribution amount 
				if (! contributionExists) {
					System.out.print("Enter the annual contribution amount: ");
					annualContribution = input.nextDouble();
					// Catch negative numbers
					if (annualContribution < 0) {
						System.out.println("Invalid input! No negatives. ");
						continue; //keep collecting input until input is valid
					// Check if the user input exceeds maximum contribution amount
					} else if (annualContribution > MAX_CONTRIBUTION_TOTAL) {
						System.out.format("You can contribute a maximum of $%d over your entire savings schedule\n", MAX_CONTRIBUTION_TOTAL);
						continue;
					}
					//user has entered valid input, no need to prompt again for this question
					else { 
						contributionExists = true;
					}
				}

				// Flow moves here once the user has already entered a valid contribution amount. They are now prompted to enter an interest rate.
				if (! interestExists) {
					System.out.print("Enter the annual interest rate (%): ");
					annualInterestRate = input.nextDouble() / 100;
					// catch negative numbers
					if (annualInterestRate < 0) { 
						System.out.println("Invalid input! No negatives. ");
						continue;
					// input is valid, moves onto the next block
					} else { 
						interestExists = true;
					}
				}

				// Flow moves here once contribution amount and interest rate inputs are valid. They are now prompted to enter the number of years.
				if (! yearNumExists) {
					System.out.print("Enter the number of years (int) you want to save for: ");
					numberOfYears = input.nextInt();
					//Catch negatives
					if (numberOfYears < 0) { 
						System.out.println("Invalid input! No negatives. ");
						continue;
					// Prevent user from entering too many years
					} else if (numberOfYears > MAX_YEARS) { 
						System.out.format("Max number of years is %d\n", MAX_YEARS);
						continue;
					// Check again if the user input exceeds maximum contribution amount based on new inputs
					} else if (annualContribution * numberOfYears > MAX_CONTRIBUTION_TOTAL) { // Check if the user will be putting in too much money. Reprompt if necessary.
						System.out.format("Over the course of %d years, you can contribute a maximum of $%d\n", numberOfYears, MAX_CONTRIBUTION_TOTAL);
						System.out.format("Based on your current inputs, you will be contributing $%.2f\n", annualContribution * numberOfYears);
						contributionExists = false; // no need to reprompt for interest again (because it's valid)
						continue;
					}
					// valid input
					else {
						yearNumExists = true;
					}
				}

				//Close input and exit out of the main while loop
				input.close();
				inputFinished = true;
			} catch (InputMismatchException ex) { // catches error, continues to the next iteration of while until user enters valid input
				System.out.println("Invalid input!"); //output error/debug message
				input.nextLine(); // clear the invalid input
			}
		}

		// Calculate the current grant (min between MAX_GRANT_AMOUNT and GRANT_PERCENT * annualContribution)
		double currentGrant;
		if (MAX_GRANT_AMOUNT > GRANT_PERCENT * annualContribution) {
			currentGrant = GRANT_PERCENT * annualContribution;
		} else {
			currentGrant = MAX_GRANT_AMOUNT;
		}
		
		// Create an accumulator to store the grants, store the total interest, and store the total contributions
		double totalGrantedAmount = 0, totalInterest = 0;
		double totalContribution = numberOfYears * annualContribution;
		
		//Output and calculations
		System.out.format("Year%5sInitial Balance%5sContribution%5sGrant%5sInterest%5sFinal Balance\n","","","","","","");
		for (int yr = 1; yr <= numberOfYears; yr++) {
			// Prevent the government from giving you more than some amount (7200 in this case) for your RESP
			if (totalGrantedAmount + currentGrant > MAX_OVERALL_GRANT_AMOUNT) {
				currentGrant = MAX_OVERALL_GRANT_AMOUNT - totalGrantedAmount;
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
		// Final output line
		System.out.format("After %d years, you contributed $%.2f and earned $%.2f in grants and $%.2f in interest.\n", numberOfYears, totalContribution, totalGrantedAmount, totalInterest);
		
	}

}
