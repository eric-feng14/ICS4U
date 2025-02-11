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
		int income = 0;
		double tax = 0;

		// Collect input
		Scanner input = new Scanner(System.in);
		income = input.nextInt();
		input.close();

		if (income > 0) {
			if (income > 0 && income <= 27500) {
				tax += 0.17 * income;
			}
			else if (income > 27500 && income <= 55000) {
				tax += (0.17 * 27500) + (0.24 * (income - 27500));
			}
			else {
				tax += (0.17 * 27500) + (0.24 * 27500) + (0.29 * (income - 55000));
			}
			System.out.format("%.2f",tax);
		}
		else {
			System.out.println("Invalid income");
		}
	}

}
