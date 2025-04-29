package unit_2_robotOOP;

public class RollsRoyce extends Vehicle{
	private String sound = "buzz";
	
	/**
	 * Constructor for creating a rollsroyce vehicle
	 * @param name
	 * @param price
	 */
	public RollsRoyce() { 
		super("Rolls Royce", 100);
	}
	
	/**
	 * Overridden method - creates a rollsroyce driving soudn
	 */
	public void drive() {
		System.out.println(this.sound);
	}
}
