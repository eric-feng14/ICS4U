package unit_2_robotOOP;
import becker.robots.*;

/**
 * Template class for creating a cleaner robot
 * @author Eric Feng
 * @version April 11 2025
 */
public class FengChairMoverRobot extends RobotSE{
	
	final private static int maxStorageHeight = 10; //how much each position in the storage can contain
	
	private int chairsStacked = 0; //amount of chairs stacked on the previous pile
	private int depositIndexIncrease = 0; //num of spots to the right to place the new pile of chairs
	private int doorStreet, doorAve; // (street, avenue) of the door's position
	private int storageStreet, storageAve; // (street, avenue) of the leftmost position in the storage
	private boolean onAlternateRow = true; //helps determine which direction to turn when switching rows during traversal
	
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
		this.getDoorAndStorageInfo();
		this.prepareToClean();
		
		//Main loop to keep scanning the grid
		while (true) {
			this.checkForwards();
			//If there is nothing else to scan
			if (this.endReached()) {
				break;
			}
			this.switchRows();
		}
		this.finishCleaning();
	}
	
	/**
	 * places the robot in the desired position after it has finished cleaning
	 */
	private void finishCleaning() {
		this.goToPosition(this.doorStreet + 1, this.doorAve);
		this.goToPosition(this.storageStreet-1, this.storageAve + this.depositIndexIncrease);
		this.turnNorth();
	}
	
	/**
	 * checks if the robot has finished scanning everything
	 * @return returns a boolean value representing if the robot is finished cleaning
	 */
	private boolean endReached() {
		this.turnNorth();
		
		//If the robot is blocked by a wall on the north side, it is finished cleaning
		if (!this.frontIsClear()) {
			return true;
		}
		return false;
	}
	
	/**
	 * modifies the robots position so that it can scan the next row above
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
	 * continue moving forward and checking if the robot can pick up a chair
	 */
	private void checkForwards() {
		//keep going if robot is not blocked
		while (this.frontIsClear()) {
			this.continuePickingChairs();
			this.move();
		}
		
		//Add the missing check for the end of the row (there's a move command at the end of the while loop)
		this.continuePickingChairs();
	}
	
	/**
	 * continues picking chairs and depositing them in the storage, while at a singular position in the caf
	 */
	private void continuePickingChairs() {
		//While there are chairs to be picked up
		while (this.canPickThing()) {
			this.pickUpChair();
			this.depositChairAndReturn();
		}
	}
	
	/**
	 * After the robot has scanned everything and gathered its information,
	 * it will go to the bottom right corner of the cafeteria and start cleaning.
	 */
	private void prepareToClean() {
		this.goToPosition(this.doorStreet, this.doorAve);
		this.turnEast();
		this.continueMoving();
		this.turnWest();
	}
	
	/**
	 * moves the robot to the storage area and places the chair in the correct position.
	 * this function also keeps track of where to place the chairs.
	 */
	private void moveAndPlaceChair() {
		this.goToPosition(this.doorStreet+1, this.doorAve);
		this.goToPosition(this.storageStreet, this.storageAve + this.depositIndexIncrease);
		this.placeChair();
		this.chairsStacked++;
		
		//if the max height has been reached, move the index to the next column
		if (this.chairsStacked == maxStorageHeight) {
			this.depositIndexIncrease++;
			this.chairsStacked = 0;
		}
	}
	
	/**
	 * places a chair in the storage and then returns to the robot's original position.
	 * The robot's initial direction is kept the same.
	 */
	private void depositChairAndReturn() {
		//Save the robot's original position
		int prevStreet = this.getStreet();
		int prevAve = this.getAvenue();

		this.moveAndPlaceChair();
		
		//return to original position
		this.goToPosition(this.doorStreet, this.doorAve);
		this.goToPosition(prevStreet, prevAve);
		
		//Determine which direction to turn
		if (this.onAlternateRow) {
			this.turnWest();
		} else {
			this.turnEast();
		}
	}
	
	/**
	 * main function that performs the scanning to find the leftmost position of the storage, as well as the door.
	 * Note: we need to ensure that the door is found by using a boolean because 
	 * there is the possibility that the door is at the leftmost position in the cafeteria
	 */
	private void getDoorAndStorageInfo() {
		boolean doorFound; 
		this.moveBottomLeft();
		this.turnEast();
		doorFound = this.findDoor();

		//Edge case, door must be at the leftmost position of the cafeteria
		if (! doorFound) {
			this.collectDoorInfo();
		}
		
		//Collect storage information
		this.moveToBottomLeftStorage();
	}
	
	/**
	 * This function handles the edge case for door scanning. Since the avenue has already been saved
	 * because of the default storage avenue value, the robot simply needs to move upwards until it reaches the cafeteria.
	 * Then the street of the door is just the closest street below the cafeteria - 1.
	 */
	private void collectDoorInfo() {
		this.turnNorth();
		this.continueMoving();
		this.doorStreet = this.getStreet() - 1;
	}
	
	/**
	 * After the door's information has been saved, this function moves the robot 
	 * to the leftmost position in the storage. It then saves that information for later use.
	 */
	private void moveToBottomLeftStorage() {
		this.turnSouth();
		this.continueMoving();
		this.turnWest();
		this.continueMoving();
		
		this.saveStorageInfo();
	}
	
	/**
	 * saves the leftmost position in the storage according to the robot's current position
	 */
	private void saveStorageInfo() {
		this.storageStreet = this.getStreet();
		this.storageAve = this.getAvenue();
	}
	
	/**
	 * scans the south wall of the cafeteria/storage to find the door.
	 * if the door wasn't found, it means that the robot was scanning the storage.
	 * this means that the door is at the leftmost position (because of the edge case).
	 * @return returns a boolean that represents if the door was found.
	 */
	private boolean findDoor() {
		//While the robot can keep moving to the east side
		while (this.frontIsClear()) {
			this.move();
			this.turnSouth();
			//If there is a gap to the south, it must be the door
			if (this.frontIsClear()) {
				this.saveDoorInfo();
				return true;
			}
			this.turnEast();
		}
		return false;
	}
	
	/**
	 * saves the door information according to the robot's current position
	 */
	private void saveDoorInfo() {
		this.doorStreet = this.getStreet();
		this.doorAve = this.getAvenue();
	}
	
	/**
	 * moves the robot to the bottom left of the cafeteria or storage.
	 * this function helps prepare the robot to scan the room (to find the door). 
	 * in the case where the door is at the bottom left side of the caf (edge case),
	 * the avenue is saved as the leftmost value by default, so no further checks would be necessary.
	 * If the door were somewhere else, this location would simply be replaced. 
	 */
	private void moveBottomLeft() {
		this.turnWest();
		this.continueMoving();
		
		//Keep default information for the door
		this.doorAve = this.getAvenue();
		
		this.turnSouth();
		this.continueMoving();
	}
	
	/**
	 * continues moving in one direction until the robot is blocked by a barrier
	 */
	private void continueMoving() {
		//while the robot isn't blocked by walls
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
		this.moveHorizontally(horizontalDistance);
		this.moveVertically(verticalDistance);
	}
	
	/**
	 * Based on a precalculated distance, move north or south for "dist" amount of times
	 * e.g. negative values mean to move down, while positive values mean to move up 
	 * @param dist dist is the number representing how many steps to move
	 */
	private void moveVertically(int dist) {
		//Determine which way to turn
		if (dist > 0) { //current robot position is below the target
			this.turnNorth();
		} else if (dist < 0) { //current robot position is above the target
			this.turnSouth();
		}
		
		//Perform movements
		for (int i = 0; i < Math.abs(dist); i++) {
			this.move();
		}
	}
	
	/**
	 * Based on a precalculated distance amount, move to the left or right for "dist" amount of times
	 * e.g. negative values mean move right, positive values mean move to the left
	 * @param dist dist is the number representing how many steps to move
	 */
	private void moveHorizontally(int dist) {
		//Determine which way to turn
		if (dist > 0) { //current robot position is to the right of the target
			this.turnWest();
		} else if (dist < 0) { //current robot position is to the left
			this.turnEast();
		}
		
		//Perform the actual movements
		for (int i = 0; i < Math.abs(dist); i++) {
			this.move();
		}
	}
	
	/**
	 * turns the robot west
	 */
	private void turnWest() {
		Direction dir = this.getDirection();
		
		//Determine which direction the robot is currently facing
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
		
		//Determine which direction the robot is currently facing
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
		
		//Determine which direction the robot is currently facing
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
		
		//Determine which direction the robot is currently facing
		if (dir == Direction.EAST) {
			this.turnLeft();
		} else if (dir == Direction.SOUTH) {
			this.turnAround();
		} else if (dir == Direction.WEST) {
			this.turnRight();
		}
	}
	
}
