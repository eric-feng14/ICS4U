package unit_2_robotOOP;
import becker.robots.*;

/**
 * Template class for creating a cleaner robot
 * @author Eric Feng
 * @version April 11 2025
 */
public class FengChairMoverRobot extends RobotSE{
	
	final private static int maxStorageHeight = 10;
	
	/**
	 * constructor method for creating a cleaner robot
	 * @param c c is the city
	 * @param street street is the number on the vertical axis
	 * @param avenue avenue is the number on the horizontal axis
	 * @param d d is the direction the robot is initially facing
	 */
	public FengChairMoverRobot(City c, int street, int avenue, Direction d) {
		super(c, street, avenue, d);
	}
	
	/*
	 * Plan:
	 * use an array to represent the storage space
	 * use a separate array to keep track of the most optimal coins at the current position
	 */
	
	/**
	 * main logic - robot moves around and cleans up the chairs in the cafeteria
	 */
	public void moveChairs() {
		
	}
	
}
