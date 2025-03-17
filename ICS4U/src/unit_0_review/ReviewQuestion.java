package unit_0_review;
import java.util.*;

public class ReviewQuestion {

	public static void displayMenu(int amountOfMoney, String foodNames[], double foodPrices[]) {
		for (int i = 0; i < foodPrices.length; ++i) {
			if (amountOfMoney >= foodPrices[i]) {
				System.out.format("%-50s $%.2f\n", foodNames[i], foodPrices[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		// Variables
		Scanner input = new Scanner(System.in);
		int num, money;
		System.out.print("Enter your budget: ");
		money = input.nextInt();
		
		String foodNames[] = {
				"1.  Miso Soup",
				"2.  House Salad", 
				"3.  Tuna Tataki Salad", 
				"4.  Agedashi Tofu",
				"5.  Lemon Grass Beef Skewers",
				"6.  Chicken Lettuce Wrap", 
				"7.  Samurai Steak 14oz", 
				"8.  Hotate -Yaki", 
				"9.  Teriyaki Striploin 8oz", 
				"10. The Emperor’s Choice", 
				"11. Wasabi Chicken", 
				"12. Fresh Grilled Shitake Mushrooms",
				"13. Fresh Grilled Asparagus",
				"14. Teppanyaki Heaven",
				"15. Steamed Rice", 
				"16. Grilled Tofu"
		};
		
		double foodPrices[] = {
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
				4.95
		};
		
		displayMenu(money, foodNames, foodPrices);
		
		//continuously collect input until user inputs 0
		while (true) {
			System.out.print("Enter your choice (0 to quit): ");
			num = input.nextInt();
			
			//Exit condition
			if (num == 0) {
				System.out.println("stuff");
				break;
			}
			
			money -= num;
			
			displayMenu(money, foodNames, foodPrices);
			
		}

	}

}
