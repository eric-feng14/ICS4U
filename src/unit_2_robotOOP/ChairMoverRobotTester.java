package unit_2_robotOOP;
import becker.robots.*;

/**
 * Application class for a cleaner robot
 * @author Eric Feng
 * @version April 11 2025
 */
public class ChairMoverRobotTester {
	
	private static void setup(City c, int length, int height) {
		//Create the horizontal walls
		for (int i = 1; i < length; i++) {
			Wall wall1 = new Wall(c, 1, i, Direction.NORTH);
			Wall wall2 = new Wall(c, height, i, Direction.SOUTH);
		}
		
		//Create the vertical walls
		for (int i = 1; i <= height; i++) {
			Wall wall1 = new Wall(c,i,1,Direction.WEST);
			Wall wall2 = new Wall(c,i,length-1,Direction.EAST);
		}
	}
	
	

	public static void main(String[] args) {
		City oakville = new City(10, 10);
		setup(oakville, 9, 5);

	}

}
