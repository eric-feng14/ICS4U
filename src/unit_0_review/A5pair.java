package unit_0_review;
import java.util.*;

/**
 * prints out the first n prime numbers - optimized
 * @author Eric Feng
 * @version March 13 2025
 */

public class A5pair {

	public static void optimizedFunc() {
		int n;
		int counter = 0, currentNum = 3;
		
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		
		System.out.println(2);
		
		while (counter < n) {
			boolean found = false;
			for (int i = 3; i <= Math.sqrt(currentNum); i += 2) {
				if (currentNum % i == 0) {
					found = true;
					break;
				}
			}
			
			if (! found) {
				System.out.println(currentNum);
				++counter;
			}
			
			currentNum += 2;
		}
	}
	
	public static void main(String[] args) {
		optimizedFunc();
//		int n;
//		int counter = 0, currentNum = 2;
//		
//		Scanner input = new Scanner(System.in);
//		n = input.nextInt();
//		
//		while (counter < n) {
//			boolean found = false;
//			for (int i = 2; i <= Math.sqrt(currentNum); ++i) {
//				if (currentNum % i == 0) {
//					found = true;
//					break;
//				}
//			}
//			
//			if (! found) {
//				System.out.println(currentNum);
//				++counter;
//			}
//			
//			++currentNum;
//		}

	}

}
