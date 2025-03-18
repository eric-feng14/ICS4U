package unit_0_review;
import java.util.*;

public class ReviewQuestion {

	/**
	 * Prints out items that the user can purchase based on their current amount of money
	 * Note that ArrayList is an object and all objects are passed by reference, so modifying the object here modifies the actual object too.
	 * @param amountOfMoney, foodNames, foodPrices
	 * @return 
	 */
	public static void displayMenu(double amountOfMoney, ArrayList<String> foodNames, ArrayList<Double> foodPrices) {
		int i = 0;
		while (i < foodPrices.size()) {
			if (amountOfMoney >= foodPrices.get(i)) {
				System.out.format("%-3s %-50s $%.2f\n", (i+1) + ".", foodNames.get(i), foodPrices.get(i));
				++i;
			} else { // Do not increment i because the whole array shifts to the left.
				foodNames.remove(i);
				foodPrices.remove(i);
			}
		}
	}
	
	public static void main(String[] args) {
		// Variables
		Scanner input = new Scanner(System.in);
		int num; double money;
		System.out.print("Enter your budget: ");
		money = input.nextDouble();
		
		ArrayList<String> foodNames = new ArrayList<String>(Arrays.asList(
				"Miso Soup",
				"House Salad", 
				"Tuna Tataki Salad", 
				"Agedashi Tofu",
				"Lemon Grass Beef Skewers",
				"Chicken Lettuce Wrap", 
				"Samurai Steak 14oz", 
				"Hotate -Yaki", 
				"Teriyaki Striploin 8oz", 
				"The Emperor’s Choice", 
				"Wasabi Chicken", 
				"Fresh Grilled Shitake Mushrooms",
				"Fresh Grilled Asparagus",
				"Teppanyaki Heaven",
				"Steamed Rice", 
				"Grilled Tofu"));
		
		ArrayList<Double> foodPrices = new ArrayList<Double>(Arrays.asList(
				3.50,
				4.00,
				14.95,
				6.00,
				7.50,
				9.95,
				29.00,
				12.00,
				32.00,
				49.00,
				18.00, 
				6.95, 
				4.95, 
				89.00,
				2.50,  
				4.95));
		
		displayMenu(money, foodNames, foodPrices);
		
		//continuously collect input until user inputs 0
		while (true) {
			System.out.print("Enter your item choice (0 to quit): ");
			num = input.nextInt();
			
			//Exit condition
			if (num == 0) {
				System.out.format("Your total is %.2f", money);
				break;
			}
			
			money -= foodPrices.get(num-1);
			displayMenu(money, foodNames, foodPrices);
//			System.out.format("Your total is %.2f\n", money); // Debugging purposes
		}

	}

}
