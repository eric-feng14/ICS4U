package unit_2_robotOOP;

public class Audi extends Vehicle{
	public Audi(String name, double price) {
		super(name, price);
	}
	
	public void drive() {
		System.out.println("This is an audi");
	}
}
