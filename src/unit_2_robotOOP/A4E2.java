package unit_2_robotOOP;

/**
 * Application class for A4E2
 * @author Eric Feng
 * @version April 18 2025
 */
public class A4E2 {

	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[3];
		vehicles[0] = new Cybertruck("Model 1", 200.34);
		vehicles[1] = new Audi("R8", 400.2);
		vehicles[2] = new RollsRoyce("Model 2", 324.96);
		for (Vehicle v : vehicles) {
			v.getName();
			v.getPrice();
			System.out.println();
		}
	}

}
