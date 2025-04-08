package unit_2_robotOOP;
import becker.robots.*;

public class A3E2 extends HurdleRobot{

	public A3E2(City c, int ave, int street, Direction d) {
		super(c, ave, street, d); //calls the parent's constructor
	};
	
	public static void main(String[] args) {
		City oakville = new City();
		oakville.showThingCounts(true);
		HurdleRobot thisRobot = new HurdleRobot(oakville,1,1,Direction.EAST);
		/*
		 * 1. Place all the things in a line with random counts
		 * 2. Pick them up and spread them out
		 * 3. Go back for the next row and continue spreading until the end is reached
		 */
		
	}

}
