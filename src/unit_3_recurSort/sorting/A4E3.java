package unit_3_recurSort.sorting;

/**
 * exercise 3 of the sorting exercises - Application class
 * @author Eric Feng
 * @version May 12 205
 */
public class A4E3 {
	
	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[3];
		vehicles[0] = new Car("Audi", "R8", 1000, 2, 2);
		vehicles[1] = new SUV("Honda", "CR-V", 9000, 4, 5);
		vehicles[2] = new Truck("Dodge", "Pickup", 9500, 2, 4, 5000);
		for (Vehicle v : vehicles) {
			System.out.println(v);
			System.out.println(v.getType());
		}

	}
}