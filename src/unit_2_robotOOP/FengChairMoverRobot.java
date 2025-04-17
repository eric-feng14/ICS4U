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
	private int[] door = new int[2];
	private int storageStreet, storageAve;
	private boolean onAlternateRow = true;
	
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
	 */
	public void moveChairs() {
		int totalChairCount = 0;
		this.getDoorAndStorageInfo();
		this.prepareToClean();
		
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
			//Add the missing check for the end of the row
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
	
	private void prepareToClean() {
		this.goToPosition(this.door[0], this.door[1]);
		this.turnEast();
		this.continueMoving();
		this.turnWest();
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
		//we need to ensure that the door is found because there is the possibility that the door is at the leftmost position in the caf
		boolean doorFound; 
		this.moveBottomLeft();
		this.turnEast();
		doorFound = this.findDoor();

		//Edge case, door must be at the leftmost position of the caf
		if (! doorFound) {
			this.collectDoorInfo();
		}
		
		this.moveToBottomLeftStorage();
	}
	
	private void collectDoorInfo() {
		this.turnNorth();
		this.continueMoving();
		//We don't need to consider the avenue because the default is the leftmost
		this.door[0] = this.getStreet() - 1;
	}
	
	private void moveToBottomLeftStorage() {
		this.turnSouth();
		this.continueMoving();
		this.turnWest();
		this.continueMoving();
		this.storageStreet = this.getStreet();
		this.storageAve = this.getAvenue();
	}
	
	private boolean findDoor() {
		while (this.frontIsClear()) {
			this.move();
			this.turnSouth();
			if (this.frontIsClear()) {
				this.door[0] = this.getStreet();
				this.door[1] = this.getAvenue();
				return true;
			}
			this.turnEast();
		}
		return false;
	}
	
	private void moveBottomLeft() {
		this.turnWest();
		this.continueMoving();
		this.door[1] = this.getAvenue();
		
		this.turnSouth();
		this.continueMoving();
	}
	
	/**
	 * continues moving in one direction until the robot is blocked by a barrier
	 */
	private void continueMoving() {
		//while the robot can move forward (is not blocked)
		while (this.frontIsClear()) {
			this.move();
		}
	}
	
	/**
	 * places one chair down on the ground if the robot can
	 */
	private void placeChair() {
		//If the robot has a chair in its backpack
		if (this.countThingsInBackpack() > 0) {
			this.putThing();
		}
	}
	
	/**
	 * picks up one chair up and stores it in the backpack if the robot can
	 */
	private void pickUpChair() {
		//If there is a chair at the robot's current position
		if (this.canPickThing()) {
			this.pickThing();
		}
	}
	
	/**
	 * moves the robot to a new position (street, avenue). 
	 * @param street street is the street to move to
	 * @param avenue avenue is the avenue to move to
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
