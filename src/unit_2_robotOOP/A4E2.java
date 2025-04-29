package unit_2_robotOOP;

/**
 * Application class for A4E2
 * @author Eric Feng
 * @version April 18 2025
 */
public class A4E2 {

	public static void main(String[] args) {
		//Polymorphic array of vehicles
		Vehicle[] vehicles = new Vehicle[3];
		
		//Add the specific types of vehicles
		vehicles[0] = new Cybertruck();
		vehicles[1] = new Audi();
		vehicles[2] = new RollsRoyce();
		
		//Get information about each vehicle
		for (Vehicle v : vehicles) {
			System.out.println(v.getName());
			System.out.println(v.getPrice());
			v.drive();
			System.out.println();
		}
	}

}
