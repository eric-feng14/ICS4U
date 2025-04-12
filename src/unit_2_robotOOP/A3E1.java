package unit_2_robotOOP;
import becker.robots.*;

/**
 * Application class for A3E1
 * @author Eric Feng
 * @version April 8 2025
 */
public class A3E1{
	
	/**
	 * runs the whole race for a single robot
	 * pre: robot is on the coin
	 * post: robot is done the race, places the coin back down
	 */
	
	public static void createHurdles(City c) {
		//Create the main wall
		for (int i = 0; i < 10; ++i) {
			Wall x = new Wall(c, 3, i, Direction.SOUTH);
		}
		//Create the actual hurdles
		for (int i = 1; i <= 7; i+=2) {
			for (int j = 2; j < 4; ++j) {
				Wall a = new Wall(c,j,i,Direction.EAST);
			}
		}
	}
	
	public static void main(String[] args) {
		City oakville = new City();
		HurdleRobot robot1 = new HurdleRobot(oakville, 3, 0, Direction.EAST);
		HurdleRobot robot2 = new HurdleRobot(oakville, 3, 4, Direction.EAST);
		
		createHurdles(oakville);
		
		Thing coin = new Thing(oakville,3,0);
		robot1.runRace();
		robot2.runRace();
	}

}
