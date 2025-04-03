package unit_1_oop;
import java.util.*;

/**
 * returns total from input for various coins amounts
 * @author Eric Feng
 * @version Feb 7 2025
 */
public class A1E3 {

	/**
	 * @param coinValues - each index represents a coin value 
	 * @param freqArr - each index represents the number of coins for each corresponding coin value
	 * @return returns the total value of your current wallet
	 */
	public static double calcTotal(double[] coinValues, int[] freqArr) {
		double total = 0;
		//Loop through the coins and take the corresponding count of coins from the frequency array
		for (int i = 0; i < coinValues.length; i ++) {
			total += coinValues[i] * freqArr[i];
		}
		return total;
	}
	
	public static void main(String[] args) {
		//Create variables
		final int numberOfCoins = 5;
		double total;
		int[] freqArr = new int[numberOfCoins]; //counts the frequency of the coins
		String[] coinNames = {"toonies", "dollars", "quarters", "dimes", "nickels"};
		double[] coinValues = {2,1,0.25,0.1,0.05}; // holds the coin values 
		Scanner input = new Scanner(System.in);

		// Collect number of coins of each value
		for (int i = 0; i<numberOfCoins; i++) {
			System.out.print(coinNames[i] + ": ");
			freqArr[i] = input.nextInt();
		}

		//Calculate and print result
		total = calcTotal(coinValues, freqArr);
		System.out.format("total is $%.2f", total);
	}

}
