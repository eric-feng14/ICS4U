package unit_0_review;
import java.util.Scanner;

/**
 * Calculates the tax for a given income
 * @author Eric Feng
 * @version Feb 10 2025
 */
public class A4E1 {

	public static void main(String[] args) {
		// Declare variables
		int income, tax = 0;
		double bracket1, bracket2, bracket3;
		bracket1 = 0.17;
		bracket2 = 0.24;
		bracket3 = 0.29;
		
		// Collect input
		Scanner input = new Scanner(System.in);
		income = input.nextInt();
		input.close();
		
		if (income >= 27500) {
			tax += bracket1 * 27500;
		
			if (income >= 27500 * 2) {
				tax += bracket2 * 27500;
				
				if (income >= )
			}
			else {
				tax += bracket2 * income
			}
		}
		else {
			tax += bracket1 * income;
		}
		
	}

}
