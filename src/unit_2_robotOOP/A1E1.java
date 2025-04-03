package unit_2_robotOOP;
import becker.robots.*;

/**
 * Prints my name on the field
 * @author Eric Feng
 * @version April 1 2025
 */
public class A1E1 {
	
	public static void main(String[] args) {
		City oakville = new City();
		oakville.showThingCounts(true);
		RobotVersion2 karel = new RobotVersion2(oakville,0,0,Direction.SOUTH);
		Thing[] things = new Thing[100];
		for (int i = 0; i < 11; ++i) {
			things[i] = new Thing(oakville,0,0);
		}
		while (karel.canPickThing()) 
			karel.pickThing();
		for (int i = 0; i < 4; ++i) {
			karel.putThing();
			karel.move();
		}
		karel.putThing();
		
		karel.turnLeft();
		karel.move();
		karel.placeTwoThings();
		
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.placeTwoThings();
		
		karel.turnRight();
		karel.move();
		karel.move();
		karel.turnRight();
		karel.placeTwoThings();
	}

}
