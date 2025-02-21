package unit_0_review;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// Declare variables
		int numberOfPrimes;
		int counter = 0;
		int currentNumber = 2;
		
		// Collect input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of primes: ");
		numberOfPrimes = input.nextInt();
		input.close();
		
		// Perform calculations
		while (counter < numberOfPrimes) {
			boolean isPrime = true;
			for (int i = 2; i <= (int) Math.sqrt(currentNumber); i++) {
				if (currentNumber % i == 0) { // currentNumber is NOT prime
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				counter++;
				System.out.println(currentNumber);
			}
			currentNumber++;
			
		}
	}
}
