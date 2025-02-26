package unit_0_review;
import java.util.*;

public class Test {

	public static void main(String[] args) {
//		// Declare variables
//		int numberOfPrimes;
//		int counter = 0;
//		int currentNumber = 3;
//		
//		// Collect input
//		Scanner input = new Scanner(System.in);
//		System.out.print("Enter number of primes: ");
//		numberOfPrimes = input.nextInt();
//		input.close();
//		
//		System.out.println(2);
//		
//		// Perform calculations
//		while (counter < numberOfPrimes) {
//			boolean isPrime = true;
//			for (int i = 3; i <= (int) Math.sqrt(currentNumber); i+=2) {
//				if (currentNumber % i == 0) { // currentNumber is NOT prime
//					isPrime = false;
//					break;
//				}
//			}
//			if (isPrime) {
//				counter++;
//				System.out.println(currentNumber);
//			}
//			currentNumber += 2;
//			
//		}
		int n = 654;
		System.out.println("n" + "\t" + n/100 + "\t" + (n%100 - n%10) / 10 + "\t" + (n%10));
	}
}
