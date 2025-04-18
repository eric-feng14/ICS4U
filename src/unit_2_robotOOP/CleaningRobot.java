package unit_2_robotOOP;
import becker.robots.*;

/**
 * Template class used to create a cleaning robot
 * @author Eric Feng
 * @version April 18 2025
 */
public class CleaningRobot extends RobotSE{

	private boolean onAlternateRow = false;
	
	/**
	 * Constructor method for creating a cleaning robot
	 * @param c c is the city
	 * @param street street is the street
	 * @param avenue avenue is the avenue
	 * @param d d is the direction
	 */
	public CleaningRobot(City c, int street, int avenue, Direction d) {
		super(c, street, avenue, d);
	}
	
	/**
	 *  Override the move() method so that CleaningRobot will always move
and pick up any Thing that is at the new intersection
	 */
	public void move() {
		super.move();
		super.pickAllThings();
	}
	
	/**
	 * cleans the whole room that the CleaningRobot is in
	 */
	public void cleanRoom() {
		this.prepareToClean();
		//Main loop to keep scanning the grid
		while (true) {
			this.cleanRow();
			//If there is nothing else to scan
			if (this.endReached()) {
				break;
			}
			this.switchRows();
		}
	}
	
	/**
	 * cleans one row of the room
	 */
	private void cleanRow() {
		//While the robot can move forwards
		while (this.frontIsClear()) {
			this.move();
		}
	}
	
	/**
	 * moves the robot to the bottom left corner and picks up everything there (edge case)
	 */
	private void prepareToClean() {
		this.moveBottomLeft();
		this.turnTo(Direction.EAST);
		this.pickAllThings();
	}
	
	/**
	 * checks if the robot has finished scanning everything
	 * @return returns a boolean value representing if the robot is finished cleaning
	 */
	private boolean endReached() {
		this.turnTo(Direction.NORTH);
		
		//If the robot is blocked by a wall on the north side, it is finished cleaning
		return !this.frontIsClear();
	}
	
	/**
	 * modifies the robots position so that it can scan the next row. also scans the start of each row
	 */
	private void switchRows() {
		//If the robot is moving to the left
		if (this.onAlternateRow) {
			this.move();
			this.turnRight();
		} else { //If the robot is moving to the right
			this.move();
			this.turnLeft();
		}
		
		//Reverse the boolean for each switch
		this.onAlternateRow = ! this.onAlternateRow;
	}
	
	/**
	 * move the robot to the bottom left corner
	 */
	private void moveBottomLeft() {
		this.turnTo(Direction.WEST);
		this.moveToEnd();
		this.turnTo(Direction.SOUTH);
		this.moveToEnd();
	}
	
	/**
	 * move to the end of the row
	 */
	private void moveToEnd() {
		//Continue moving forward and doing nothing else
		while (super.frontIsClear()) {
			super.move();
		}
	}
	
	/**
	 * turns to a specific direction
	 * @param targetDir targetDir is the direction to turn to
	 */
	private void turnTo(Direction targetDir) {
		//Continue turning left while the desired direction has not been reached
	    while (super.getDirection() != targetDir) {
	        super.turnLeft();
	    }
	}

	
}

