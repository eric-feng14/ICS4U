package unit_2_robotOOP;
import becker.robots.*;

/**
 * Template class for creating a cleaner robot
 * @author Eric Feng
 * @version April 11 2025
 */
public class FengChairMoverRobot extends RobotSE{
	
	final private static int maxStorageHeight = 10; //how much each position in the storage can contain
	
	private int chairsStacked = 0, depositIndexIncrease = 0;
	private int[] door;
	private int storageStreet, storageAve;
	private boolean onAlternateRow = true;
	
	/**
	 * constructor method for creating a cleaner robot
	 * @param c c is the city
	 * @param street street is the number on the vertical axis
	 * @param avenue avenue is the number on the horizontal axis
	 * @param d d is the direction the robot is initially facing
	 */
	public FengChairMoverRobot(City c, int street, int avenue, Direction d, int[] door, int storageStreet, int storageAve) {
		super(c, street, avenue, d);
		this.door = door;
		this.storageStreet = storageStreet;
		this.storageAve = storageAve;
	}
	
	/**
	 * main logic for cleaning up the room
	 */
	public void moveChairs() {
		this.getDoorAndStorageInfo();
		this.goToPosition(this.door[0], this.door[1]);
		this.turnEast();
		this.continueMoving();
		this.turnWest();
		
		int totalChairCount = 0;
		
		while (true) {
			while (this.frontIsClear()) {
				if (this.canPickThing()) {
					this.pickUpChair();
					this.depositChairAndReturn();
					totalChairCount++;
				} else {
					this.move();
				}
			}
			//Add the missing check
			while (this.canPickThing()) {
				this.pickUpChair();
				this.depositChairAndReturn();
				totalChairCount++;
			}
			
			if (this.onAlternateRow) {
				this.turnRight();
				if (! this.frontIsClear()) {
					break;
				}
				this.move();
				this.turnRight();
			} else {
				this.turnLeft();
				if (! this.frontIsClear()) {
					break;
				}
				this.move();
				this.turnLeft();
			}
			
			this.onAlternateRow = ! this.onAlternateRow;
		}
		this.goToPosition(this.door[0] + 1, this.door[1]);
		this.goToPosition(this.storageStreet-1, this.storageAve + this.depositIndexIncrease);
		this.turnNorth();
	}
	
	
	private void depositChairAndReturn() {
		int prevStreet = this.getStreet();
		int prevAve = this.getAvenue();

		this.goToPosition(this.door[0]+1, this.door[1]);
		this.goToPosition(this.storageStreet, this.storageAve + this.depositIndexIncrease);
		
		this.placeChair();
		this.chairsStacked++;
		
		if (this.chairsStacked == maxStorageHeight) {
			this.depositIndexIncrease++;
			this.chairsStacked = 0;
		}
		
		this.goToPosition(this.door[0], this.door[1]);
		this.goToPosition(prevStreet, prevAve);
		
		if (this.onAlternateRow) {
			this.turnWest();
		} else {
			this.turnEast();
		}
	}
	
	private void getDoorAndStorageInfo() {
		this.moveToLeftCaf();
		if (this.isAtDoor()) {
			this.door[0] = this.getStreet();
			this.door[1] = this.getAvenue();
			return;
		}
		this.turnEast();
		
		//Continue searching for the door
		while (this.frontIsClear()) {
			this.move();
			this.turnRight();
			if (this.isAtDoor()) {
				this.door[0] = this.getStreet();
				this.door[1] = this.getAvenue();
				break;
			}
			moveNextPosition();
		}
		
		
	}
	
	/**
	 * scans downwards and attempts to find the position of the door if the robot can move to it
	 */
	private boolean isAtDoor() {
		this.turnSouth();
		while (this.frontIsClear()) {
			this.move();
			this.turnWest();
			if (! this.frontIsClear()) {
				this.turnEast();
				if (! this.frontIsClear()) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void moveNextPosition() {
		this.turnLeft();
		this.move();
		this.turnRight();
	}
	
	private void moveToLeftCaf() {
		this.turnWest();
		this.storageAve = this.getAvenue();
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
