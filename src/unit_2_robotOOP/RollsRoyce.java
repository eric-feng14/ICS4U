package unit_2_robotOOP;

public class RollsRoyce extends Vehicle{
	public RollsRoyce(String name, double price) { 
		super(name, price);
	}
	
	public void drive() {
		System.out.println("This is a rolls royce");
	}
}
