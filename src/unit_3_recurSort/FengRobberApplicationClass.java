package unit_3_recurSort;
import becker.robots.*;

/**
 * Application class for programming assessment
 * @author Eric Feng
 * @version May 1 2025
 */
public class FengRobberApplicationClass {
	
	/**
	 * sets up everything (walls, things, etc)
	 * @param c the city to be drawn on 
	 */
	private static void setup(City c) {
		Wall start = new Wall(c, 1, 1, Direction.NORTH);
		Wall home1 = new Wall(c, 4, 4, Direction.EAST);
		Wall home2 = new Wall(c, 7, 4, Direction.EAST);
		Thing thing1 = new Thing(c, 4, 1);
		Thing thing2 = new Thing(c, 7, 1);
		
		//Create the things in the homes
		for (int i = 0; i < 4; i++) {
			Thing thing3 = new Thing(c, 4, 4);
			Thing thing4 = new Thing(c, 7, 4);
		}
	}

	public static void main(String[] args) {
		City oakville = new City(10, 10);
		oakville.showThingCounts(true);
		setup(oakville);
		FengRobberRobot karel = new FengRobberRobot(oakville, 1, 1, Direction.SOUTH, 4);
		karel.robHouse();
		karel.robHouse();
	}

}
