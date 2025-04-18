package unit_2_robotOOP;
import becker.robots.*;
import java.util.*;

/**
 * Application class for a cleaner robot
 * @author Eric Feng
 * @version April 17 2025
 */
public class ChairMoverRobotTester {
	
	//Helpful Random object used amongst various methods 
	private static Random generator = new Random();
	
	/**
	 * sets up the whole map for the robot
	 * @param c c is the city to draw the map on
	 * @param refStreet refStreet is the street of the top left corner of the cafeteria
	 * @param refAve refAve is the avenue of the top left corner of the cafeteria
	 * @param separation separation is the distance between the cafeteria and the storage
	 * @param length length is the length of the cafeteria
	 * @param height height is the height of the cafeteria
	 * @param numOfChairs numOfChairs is the number of chairs the robot needs to clean
	 */
	private static void setup(City c, int refStreet, int refAve, int separation, int length, int height, int numOfChairs) {
		//the wall that will be missing, representing the door
		int randomIndex = generator.nextInt(length) + refAve;
		
		//Create the horizontal walls
		for (int i = refAve; i < length + refAve; i++) {
			Wall topWall = new Wall(c, refStreet, i, Direction.NORTH);
			Wall storageWall = new Wall(c, refStreet + height + separation, i, Direction.SOUTH);
			//Make the wall if the current position is not equal to the door's position
			if (i != randomIndex) {
				Wall bottomWall = new Wall(c, refStreet + height - 1, i, Direction.SOUTH);
			}
		}
		
		//Create the vertical walls
		for (int i = refStreet; i < height + refStreet; i++) {
			Wall leftWall = new Wall(c,i,refAve,Direction.WEST);
			Wall rightWall = new Wall(c,i,refAve+length-1,Direction.EAST);
		}
		
		//Draw the sides of the storage
		Wall leftStorageWall = new Wall(c, refStreet + height + separation, refAve, Direction.WEST);
		Wall rightStorageWall = new Wall(c, refStreet + height + separation, refAve+length-1, Direction.EAST);
		
		//Randomly fill with chairs
		for (int i = 0; i < numOfChairs; i++) {
			int chairStreet = generator.nextInt(height) + refStreet; 
			int chairAve = generator.nextInt(length) + refAve;
			Thing thisChair = new Thing(c, chairStreet, chairAve);
		}
	}
	
	/**
	 * Program execution starts here
	 * @param args
	 */
	public static void main(String[] args) {
		//Declare constants
		final int referenceStreet = 1, referenceAve = 1; //top left of the cafeteria
		final int length = 8, height = 5;
		final int numOfChairs = 25, separation = 2;
		
		//Create the city
		City oakville = new City(10, 10);
		oakville.showThingCounts(true);
		
		//Generate a random direction for the robot to start with.
		Direction[] directions = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
		int randomDirection = generator.nextInt(directions.length);
		
		//Setup the drawing so that its ready for the robot to traverse
		setup(oakville, referenceStreet, referenceAve, separation, length, height, numOfChairs);
		
		//Randomize the robot's position within the cafeteria
		int roboX = generator.nextInt(height) + referenceStreet; //represents the street that the robot is on
		int roboY = generator.nextInt(length) + referenceAve; //represents the avenue that the robot is on
		
		//Create the robot and use it to clean the room
		FengChairMoverRobot thisRobot = new FengChairMoverRobot(oakville, roboX, roboY, directions[randomDirection]);
		thisRobot.moveChairs();
	}

}
