package unit_2_robotOOP;

public class RollsRoyce extends Vehicle{
	/**
	 * Constructor for creating a rollsroyce vehicle
	 * @param name
	 * @param price
	 */
	public RollsRoyce(String name, double price) { 
		super(name, price);
	}
	
	/**
	 * Overridden method - creates a rollsroyce driving soudn
	 */
	public void drive() {
		System.out.println("This is a rolls royce");
	}
}
