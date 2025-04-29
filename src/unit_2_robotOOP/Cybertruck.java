package unit_2_robotOOP;

public class Cybertruck extends Vehicle{
	private String sound = "hummmmmm";
	
	/**
	 * Creates a cybertruck
	 * @param name
	 * @param price
	 */
	public Cybertruck() {
		super("Cybertruck", 200);
	}

	
	/**
	 * Overridden method - makes cybertruck sound
	 */
	public void drive() {
		System.out.println(this.sound);
	}
}
