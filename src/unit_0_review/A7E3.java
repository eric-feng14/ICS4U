package unit_0_review;
import java.util.*;

/**
 * display all of the prime factors of the user inputed number
 * @author Eric Feng
 * Feb 28 2025
 */
public class A7E3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			// Collect input
			System.out.print("Enter an integer: ");
			int n = input.nextInt();
			
			// Exit condition
			if (n == -1) {
				break;
			}
			
			// Initialize an array of true booleans
			boolean [] arr = new boolean[n + 1];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = true;
			}

			// Modify booleans
			for (int i = 2; i < arr.length; i++) {
				if (arr[i]) { //if the number is initially set to true (this would have to be a prime number)
					// check the rest of the array and mark all multiples as false starting from the next one
					for (int j = i * 2; j < arr.length; j += i) {
						arr[j] = false;
					}
				}
			}

			// Output
			for (int i = 2; i < arr.length; i++) {
				if (arr[i] && n % i == 0) {
					System.out.println(i);
				}
			}
		}
		input.close();
	}
}
