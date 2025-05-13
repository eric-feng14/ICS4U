package unit_3_recurSort.sorting;

/**
 * Parent template class for creating a vehicle 
 * @author Eric Feng
 * @version May 13 2025
 */
public abstract class Vehicle {
	private String type, manufacturer, name;
	private double price;
	
	/**
	 * Constructor method
	 * @param type
	 * @param manufacturer
	 * @param name
	 * @param price
	 */
	public Vehicle(String type, String manufacturer, String name, double price) {
		this.type = type;
		this.manufacturer = manufacturer;
		this.name = name;
		this.price = price;
	}
	/**
	 * get the type of vehicle it is
	 * @return the type of vehicle
	 */
	public String getType() {
		return this.type;
	}
	/**
	 * get the manufacturer of the vehicle
	 * @return returns the manufacturer
	 */
	public String getManufacturer() {
		return this.manufacturer;
	}
	/**
	 * returns the name of the vehicle e.g. model
	 * @return the model
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * returns the price of the vehicle
	 * @return returns the price
	 */
	public double price() {
		return this.price;
	}
	public abstract String toString();
	
}
