package unit_2_robotOOP;
import becker.robots.*;
import java.util.*;

/**
 * Application class for a cleaner robot
 * @author Eric Feng
 * @version April 11 2025
 */
public class ChairMoverRobotTester {
	
	//Is this okay?
	private static Random generator = new Random();
	
	private static int[] setup(City c, int refStreet, int refAve, int separation, int length, int height, int numOfChairs) {
		int[] door = new int[2];
		//the wall that will be missing, representing the door. range = [refAve, length+refAve-1] (both inclusive)
		int randomIndex = generator.nextInt(length) + refAve;
		
		//Create the horizontal walls
		for (int i = refAve; i < length + refAve; i++) {
			Wall topWall = new Wall(c, refStreet, i, Direction.NORTH);
			Wall storageWall = new Wall(c, refStreet + height + separation, i, Direction.SOUTH);
			if (i != randomIndex) {
				Wall bottomWall = new Wall(c, refStreet + height - 1, i, Direction.SOUTH);
			} else {
				door[0] = refStreet + height - 1;
				door[1] = i;
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
			int chairStreet = generator.nextInt(height) + refStreet; //represents the street that the chair is on. range = [refStreet, height+refStreet-1]
			int chairAve = generator.nextInt(length) + refAve; //represents the avenue that the chair is on. range = [refAve, length+refAve-1]
			Thing thisChair = new Thing(c, chairStreet, chairAve);
		}
		
		return door;
	}
	
	

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
		
		//Setup the drawing so that its ready for the robot to traverse (e.g. clean chairs up)
		int[] door = setup(oakville, referenceStreet, referenceAve, separation, length, height, numOfChairs);
		
		//Randomize the robot's position within the cafeteria
		int roboX = generator.nextInt(height) + referenceStreet; //represents the street that the robot is on
		int roboY = generator.nextInt(length) + referenceAve; //represents the avenue that the robot is on
		
		//Create the robot and use it to clean the room
		int storageStreet = referenceStreet + height + separation;
		FengChairMoverRobot thisRobot = new FengChairMoverRobot(oakville, roboX, roboY, directions[randomDirection], door, storageStreet, referenceAve);
		thisRobot.moveChairs();
	}

}
