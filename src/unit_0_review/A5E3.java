package unit_0_review;

/**
 * Task: Find all three digit numbers that are equal to the sum of the cubes of their digits
 * @author Eric Feng
 * @version Feb 20 2025
 */
public class A5E3 {

	public static void main(String[] args) {
		final int start = 100, stop = 1000;
//		final int numberOfDigits = 3;
		final int power = 3;
		
		for (int n = start; n < stop; n++) {
//			String stringNum = i + "";
//			int currentSum = 0, value;
//			
//			// loop through the 3 digits
//			for (int j = 0; j < numberOfDigits; j++) {
//				value = Character.getNumericValue(stringNum.charAt(j)); //???
//				currentSum += Math.pow(value, power);
//			}
//			
//			// Check if the number is equal to the sum of the cube of its digits
//			if (i == currentSum) {
//				System.out.println(i);

			int d1 = n/100, d2 = (n%100 - n%10) / 10, d3 = n%10;
			if (Math.pow(d1, power) + Math.pow(d2, power) + Math.pow(d3, power) == n) {
				System.out.println(n);
			}
		
		//Solution 2
		
		}
	}

}
