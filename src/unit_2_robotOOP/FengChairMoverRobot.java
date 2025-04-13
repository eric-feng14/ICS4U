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
	public FengChairMoverRobot(City c, int street, int avenue, Direction d, int length, int[][] chairs, int[] door) {
		super(c, street, avenue, d);
		this.storage = new int[length];
		this.chairs = chairs;
		this.upperDoorStreet = door[0];
		this.lowerDoorStreet = door[0] + 1;
		this.doorAve = door[1];
	}
	
	/**
	 * main logic for cleaning up the room
	 * @param referenceAve referenceAve is the leftmost Avenue within the room
	 * @param storageStreet storageStreet is the the street where the storage should be placed
	 */
	public void moveChairs(int referenceAve, int storageStreet) {
		/*
		 * When you're bringing a chair from the cafeteria to the storage space, it is a better idea to
		 * go to the lower door. When you're coming from the storage to the cafeteria, it is a better idea 
		 * to go to the upper door. See goToPosition() to understand why. 
		 */
		this.organizeChairs(this.upperDoorStreet, this.doorAve);
		this.goToPosition(this.chairs[0][0], this.chairs[0][1]);
		this.pickUpChair();
		this.goToPosition(this.lowerDoorStreet, this.doorAve);
		this.deposit(storageStreet, referenceAve); //first deposit

		for (int i = 1; i < this.chairs.length; i++) {
			this.goToPosition(this.upperDoorStreet, this.doorAve);
			this.goToPosition(this.chairs[i][0], this.chairs[i][1]);
			this.pickUpChair();
			this.goToPosition(this.lowerDoorStreet, this.doorAve);
			
			if (positionIsFull()) {
				depositIndex++;
				referenceAve++;
			}
			this.deposit(storageStreet, referenceAve);

		}
	}
	
	/**
	 * determines whether the previous i
	 * @return
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
		this.move();
	}
	
	private void placeChair() {
		this.putThing();
	}
	
	private void pickUpChair() {
		this.pickThing();
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
		this.move(Math.abs(horizontalDistance));
		
		//Move vertically
		if (verticalDistance > 0) { //current robot position is below the target
			this.turnNorth();
		} else if (verticalDistance < 0) { //current robot position is above the target
			this.turnSouth();
		}
		this.move(Math.abs(verticalDistance));
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
	
	/**
	 * Basic bubble sorting algorithm -> sorts the array by ascending order in terms of their distances to the starting node
	 * @param startStreet startStreet represents the street of the starting node
	 * @param startAve startAve represents the avenue of the starting node
	 */
	private void organizeChairs(int startStreet, int startAve) {
		
		for (int i = 0; i < chairs.length-1; i++) {
			boolean swapped = false;
			for (int j = 0; j < chairs.length-i-1; j++) {
				//Get the manhattan distance of the current chair to the start position, as well as the next chair to the starting position
				double firstDistance = Math.abs(startStreet - chairs[j][0]) + Math.abs(startAve - chairs[j][1]);
				double secondDistance = Math.abs(startStreet - chairs[j+1][0]) + Math.abs(startAve - chairs[j+1][1]);
				if (firstDistance > secondDistance) {
					int tempStreet = chairs[j][0], tempAve = chairs[j][1];
					chairs[j][0] = chairs[j+1][0];
					chairs[j][1] = chairs[j+1][1];
					chairs[j+1][0] = tempStreet;
					chairs[j+1][1] = tempAve;
					swapped = true;
				}
			}
			if (! swapped) {
				break;
			}
		}
	}
	
}
