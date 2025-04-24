package unit_2_robotOOP;

public class Audi extends Vehicle{
	/**
	 * constrcutor for creating an audi vehicle
	 * @param name
	 * @param price
	 */
	public Audi(String name, double price) {
		super(name, price);
	}
	
	/**
	 * Overridden method - makes the sound for an audi
	 */
	public void drive() {
		System.out.println("This is an audi");
	}
}
