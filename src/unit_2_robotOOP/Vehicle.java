package unit_2_robotOOP;

public class Vehicle {
	private String name;
	private double price;
	
	public Vehicle(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public void drive() {
		System.out.println("This is a vehicle");
	}
	
	public void getName() {
		System.out.println(this.name);
	}
	
	public void getPrice() {
		System.out.println(this.price);
	}
}
