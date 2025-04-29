package unit_2_robotOOP;

public class Audi extends Vehicle{
	private String sound = "vroom";
	
	/**
	 * constrcutor for creating an audi vehicle
	 * @param name
	 * @param price
	 */
	public Audi() {
		super("Audi", 300);
	}
	
	/**
	 * Overridden method - makes the sound for an audi
	 */
	public void drive() {
		System.out.println(this.sound);
	}
}
