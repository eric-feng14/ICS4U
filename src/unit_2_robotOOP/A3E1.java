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
		
		//draw the walls
		for (int i = 0; i < 10; ++i) {
			Wall x = new Wall(oakville, 3, i, Direction.SOUTH);
		}
		for (int i = 1; i <= 7; i+=2) {
			for (int j = 2; j < 4; ++j) {
				Wall a = new Wall(oakville,j,i,Direction.EAST);
			}
		}
		
		Thing coin = new Thing(oakville,3,0);
		robot1.runRace();
		robot2.runRace();
	}

}
