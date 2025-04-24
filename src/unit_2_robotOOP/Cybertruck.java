package unit_2_robotOOP;

public class Cybertruck extends Vehicle{
	/**
	 * Creates a cybertruck
	 * @param name
	 * @param price
	 */
	public Cybertruck(String name, double price) {
		super(name, price);
	}
	
	/**
	 * Overridden method - makes cybertruck sound
	 */
	public void drive() {
		System.out.println("This is a cybertruck");
	}
}
