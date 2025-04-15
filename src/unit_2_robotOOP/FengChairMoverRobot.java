package unit_2_robotOOP;
import becker.robots.*;

/**
 * Template class for creating a cleaner robot
 * @author Eric Feng
 * @version April 11 2025
 */
public class FengChairMoverRobot extends RobotSE{
	
	final private static int maxStorageHeight = 10; //how much each position in the storage can contain
	
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
	
	/**
	 * main logic for cleaning up the room
	 * @param referenceAve referenceAve is the leftmost Avenue within the room
	 * @param storageStreet storageStreet is the the street where the storage should be placed
	 */
	public void moveChairs(int numOfChairs) {
		//First two values represent the door's coordinates. Last two values represent the bottom left of the storage
		int[] info = getDoorAndStorageInfo();
		
		int rowNum = 0;
		int chairCount = 0;
		while (chairCount < numOfChairs) {
			this.turnLeft();
			this.continueMoving();
			break;
		}
	}
	
	private void depositChair(int street, int avenue) {
		this.pickUpChair();
		this.goToPosition(street, avenue);
		
	}
	
	private void exitStorage() {
		this.turnNorth();
		if (this.frontIsClear()) {
			this.move();
		}
	}
	
	private int[] getDoorAndStorageInfo() {
		int[] positions = new int[4];
		this.moveToBottomLeftCaf();
		positions[3] = this.getAvenue();
		
		//Continue searching for the door
		while (true) {
			if (this.frontIsClear()) {
				positions[0] = this.getStreet();
				positions[1] = this.getAvenue();
				//Move through the door to the storage to find the street of where the storage is located
				this.continueMoving();
				positions[2] = this.getStreet();
				break;
			}
			moveNextPosition();
		}
		//Return to original position
		this.turnAround();
		while (this.getStreet() > positions[0]) {
			this.move();
		}
		
		return positions;
	}
	
	private void moveNextPosition() {
		this.turnLeft();
		this.move();
		this.turnRight();
	}
	
	private void moveToBottomLeftCaf() {
		this.turnSouth();
		this.continueMoving();
		this.turnWest();
		this.continueMoving();
		this.turnLeft();
	}
	
	private void continueMoving() {
		while (this.frontIsClear()) {
			this.move();
		}
	}
	
	private void placeChair() {
		if (this.countThingsInBackpack() > 0) {
			this.putThing();
		}
	}
	
	private void pickUpChair() {
		if (this.canPickThing()) {
			this.pickThing();
		}
	}
	
	/**
	 * goes to a specific intersection (street, avenue)
	 * this function first moves horizontally then moves vertically.
	 * this is important because it can cause boundary collisions
	 * e.g. if you tried to move from the upper door to the storage area, you would collide.
	 * to solve this, simply create an upper door and lower door
	 * @param street
	 * @param avenue
	 */
	private void goToPosition(int street, int avenue) {
		int horizontalDistance = this.getAvenue() - avenue;
		int verticalDistance = this.getStreet() - street;
		
		//Move horizontally
		if (horizontalDistance > 0) { //current robot position is to the right of the target
			this.turnWest();
		} else if (horizontalDistance < 0) { //current robot position is to the left
			this.turnEast();
		}
		
		for (int i = 0; i < Math.abs(horizontalDistance); i++) {
			if (this.frontIsClear()) {
				this.move();
			}
		}
		
		//Move vertically
		if (verticalDistance > 0) { //current robot position is below the target
			this.turnNorth();
		} else if (verticalDistance < 0) { //current robot position is above the target
			this.turnSouth();
		}
		
		for (int i = 0; i < Math.abs(verticalDistance); i++) {
			if (this.frontIsClear()) {
				this.move();
			}
		}
	}
	
	/**
	 * turns the robot west
	 */
	private void turnWest() {
		Direction dir = this.getDirection();
		
		if (dir == Direction.NORTH) {
			this.turnLeft();
		} else if (dir == Direction.EAST) {
			this.turnAround();
		} else if (dir == Direction.SOUTH) {
			this.turnRight();
		}
	}
	
	/**
	 * turns the robot south
	 */
	private void turnSouth() {
		Direction dir = this.getDirection();
		
		if (dir == Direction.WEST) {
			this.turnLeft();
		} else if (dir == Direction.NORTH) {
			this.turnAround();
		} else if (dir == Direction.EAST) {
			this.turnRight();
		}
	}
	
	/**
	 * turns the robot east
	 */
	private void turnEast() {
		Direction dir = this.getDirection();
		
		if (dir == Direction.SOUTH) {
			this.turnLeft();
		} else if (dir == Direction.WEST) {
			this.turnAround();
		} else if (dir == Direction.NORTH) {
			this.turnRight();
		}
	}
	
	/**
	 * turns the robot north
	 */
	private void turnNorth() {
		Direction dir = this.getDirection();
		
		if (dir == Direction.EAST) {
			this.turnLeft();
		} else if (dir == Direction.SOUTH) {
			this.turnAround();
		} else if (dir == Direction.WEST) {
			this.turnRight();
		}
	}
	
}
