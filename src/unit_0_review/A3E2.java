package unit_0_review;
import java.util.Scanner;

/**
 * This is a modified version of assignment one program. This program allows 
 * the user to enter input for the names of the products and the prices.
 * @author Eric Feng
 * @version Feb 9 2025
 */
public class A3E2 {

	public static void main(String[] args) {
		// Assign constants
		final double HST = 0.13;
		
		// Variable declarations
		String item1, item2, item3;
		double cost1, cost2, cost3, sum, tax, total;
		
		//User input
		Scanner input = new Scanner(System.in);
		System.out.print("What is the name of the first item: ");
		item1 = input.nextLine();
		System.out.print("What is the price of the first item: ");
		cost1 = input.nextDouble();
		input.nextLine();
		
		System.out.print("What is the name of the second item: ");
		item2 = input.nextLine();
		System.out.print("What is the price of the second item: ");
		cost2 = input.nextDouble();
		input.nextLine();
		
		System.out.print("What is the name of the third item: ");
		item3 = input.nextLine();
		System.out.print("What is the price of the third item: ");
		cost3 = input.nextDouble();
		input.close();
		
		// calculations
		sum = cost1 + cost2 + cost3;
		tax = HST * sum;
		total = sum + tax;
		
		// print out receipt information
		System.out.println("WOSS Gift Shop Receipt");
		System.out.println("----------------------");
		System.out.format("%-16s$%5.2f\n", item1, cost1);
		System.out.format("%-16s$%5.2f\n", item2, cost2);
		System.out.format("%-16s$%5.2f\n", item3, cost3);
		System.out.println("                ------");
		System.out.format("HST (13%%)       $%5.2f\n", tax);
		System.out.println("                ------");
		System.out.format("TOTAL           $%5.2f", total);
	}

}
