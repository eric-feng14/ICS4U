package unit_2_robotOOP;

/**
 * Template class for A4E2
 * @author Eric Feng
 * @version April 23 2025
 */
public abstract class Vehicle {
	private String name;
	private double price;
	
	/**
	 * constructor method because subclasses cannot access the name and price directly
	 * @param name
	 * @param price
	 */
	public Vehicle(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	/**
	 * subclasses must override this, and make their own driving sound
	 */
	public abstract void drive();
	
	/**
	 * get the name of the current Vehicle object
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * get the price of the current Vehicle object
	 */
	public double getPrice() {
		return this.price;
	}
}
