package unit_3_recurSort.sorting;

/**
 * Template class -> subclass of the vehicle class
 * @author Eric Feng
 * @version May 13 2025
 */
public class Truck extends Vehicle{
	private int numOfDoors, maxPassengers;
	private double towingCapacity;
	
	/**
	 * Constructor method
	 * @param type type is the type of vehicle
	 * @param manufacturer manufacturer is the manufacturer 
	 * @param name name is the model
	 * @param price price is the price
	 * @param numOfDoors numOfDoors is the number of doors the car has
	 * @param maxPassengers maxPassengers is the maximum number of passengers the vehicle can carry
	 * @param towingCapcity towingCapacity is the maximum load capacity for the truck
	 */
	public Truck(String manufacturer, String name, double price, int numOfDoors, int maxPassengers, int towingCapacity) {
		super("Truck", manufacturer, name, price);
		this.numOfDoors = numOfDoors; this.maxPassengers = maxPassengers;
		this.towingCapacity = towingCapacity;
	}
	
	/**
	 * provides more information tailored to this specific type of vehicle
	 */
	public String toString() {
		return "numOfDoors: " + numOfDoors + ", maxPassengers: " + maxPassengers + ", towing capacity: " + towingCapacity;
	}
}
