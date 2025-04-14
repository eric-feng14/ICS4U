package unit_2_robotOOP;
import becker.robots.*;

/**
 * Template class for creating a cleaner robot
 * @author Eric Feng
 * @version April 11 2025
 */
public class FengChairMoverRobot extends RobotSE{
	
	final private static int maxStorageHeight = 10; //how much each position in the storage can contain
	private int[] storage; //1d array representing the storage space (does not correspond to the storage's coordinates)
	private int[][] chairs; //2d array representing the street and avenue values for each chair
	private int lowerDoorStreet, upperDoorStreet, doorAve; //represents information about the door
	private int depositIndex = 0; //integer used to fill up the storage space
	private int referenceAve, storageStreet; //information used to place the chairs in storage
	
	/**
	 * constructor method for creating a cleaner robot
	 * @param c c is the city
	 * @param street street is the number on the vertical axis
	 * @param avenue avenue is the number on the horizontal axis
	 * @param d d is the direction the robot is initially facing
	 * @length length is the length of the cafeteria
	 * @param chairs chairs is a 2d array representing the positions of the chairs
	 * @param door door is an array of size 2 representing the position of the door
	 */
	public FengChairMoverRobot(City c, int street, int avenue, Direction d, 
			int length, int[][] chairs, int[] door, int referenceAve, int storageStreet) {
		super(c, street, avenue, d);
		
		//Get chair positions and storage size
		this.storage = new int[length];
		this.chairs = chairs;
		
		//Get door position information
		this.upperDoorStreet = door[0];
		this.lowerDoorStreet = door[0] + 1;
		this.doorAve = door[1];
		
		//Get position information about storage
		this.referenceAve = referenceAve;
		this.storageStreet = storageStreet;
	}
	
	/**
	 * main logic for cleaning up the room
	 * @param referenceAve referenceAve is the leftmost Avenue within the room
	 * @param storageStreet storageStreet is the the street where the storage should be placed
	 */
	public void moveChairs() {
		/*
		 * When you're bringing a chair from the cafeteria to the storage space, it is a better idea to
		 * go to the lower door. When you're coming from the storage to the cafeteria, it is a better idea 
		 * to go to the upper door. See goToPosition() to understand why. 
		 */
		
		//Edge case: the first iteration starts differently; the robot spawns within the cafeteria, not the storage
		this.goToPosition(this.chairs[0][0], this.chairs[0][1]);
		this.pickUpChair();
		this.goToPosition(this.lowerDoorStreet, this.doorAve);
		this.deposit(storageStreet, referenceAve); //first deposit

		for (int i = 1; i < this.chairs.length; i++) {		
			this.getAndDepositChair(i);
		}
	}
	
	private void getAndDepositChair(int chairNum) {
		this.goToPosition(this.upperDoorStreet, this.doorAve);
		this.goToPosition(this.chairs[chairNum][0], this.chairs[chairNum][1]);
		this.pickUpChair();
		this.goToPosition(this.lowerDoorStreet, this.doorAve);
		
		if (positionIsFull()) {
			this.depositIndex++;
			this.referenceAve++;
		}
		this.deposit(this.storageStreet, this.referenceAve);
	}
	
	/**
	 * determines whether the storage is full at the previous position
	 * @return returns a boolean representing whether the storage is currently full
	 */
	private boolean positionIsFull() {
		if (this.storage[this.depositIndex] == maxStorageHeight) {
			return true;
		}
		return false;
	}
	
	private void deposit(int street, int ave) {
		this.goToPosition(street, ave);
		this.placeChair();
		this.storage[this.depositIndex]++;
		this.exitStorage();
	}
	
	private void exitStorage() {
		this.turnNorth();
		if (this.frontIsClear()) {
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
