package unit_2_robotOOP;
import becker.robots.*;

/**
 * Application class for A3E1
 * @author Eric Feng
 * @version April 8 2025
 */
public class A3E1 extends HurdleRobot{

	public A3E1(City c, int ave, int street, Direction d) {
		super(c, ave, street, d); //calls the parent's constructor
	};
	
	public static void main(String[] args) {
		City oakville = new City();
		HurdleRobot robot1 = new HurdleRobot(oakville, 3, 0, Direction.EAST);
		HurdleRobot robot2 = new HurdleRobot(oakville, 3, 4, Direction.EAST);
		
		robot1.createHurdles(oakville);
		
		Thing coin = new Thing(oakville,3,0);
		robot1.runRace();
		robot2.runRace();
	}

}
