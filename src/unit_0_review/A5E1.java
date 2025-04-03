package unit_0_review;
import java.util.*;
/**
 * Calculates the factor of a number
 * @author Eric Feng
 * @version Feb 19 2025
 */
public class A5E1 {

	public static void main(String[] args) {
		// Declare variables
		int n;
		
		// Collect input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		n = input.nextInt();
		input.close();
		
		// Calculations
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.println(i);
			}
		}
	}

}
