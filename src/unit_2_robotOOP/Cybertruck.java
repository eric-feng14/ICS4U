package unit_2_robotOOP;

public class Cybertruck extends Vehicle{
	public Cybertruck(String name, double price) {
		super(name, price);
	}
	
	public void drive() {
		System.out.println("This is a cybertruck");
	}
}
