package unit_2_robotOOP;
import becker.robots.*;
import java.util.*;

/**
 * Application class for maze traversal
 * @author Eric Feng
 * @version April 11 2025
 */
public class MazeRunner {
	
	final static int gridHeight = 10, gridLength = 10;

	/**
	 * add a ending position by random
	 * @param c c is the city for where to put the thing
	 */
	public static void addTarget(City c) {
		//Generate random coordinates for the end target
//		Random generator = new Random();
//		int x = generator.nextInt(MazeRunner.gridHeight);
//		int y = generator.nextInt(MazeRunner.gridLength);
//		Thing endPoint = new Thing(c, x, y);
		
		//Make it as far as possible for manual testing
		Thing endPoint = new Thing(c, 9, 9);
	}
	
	public static void main(String[] args) {
		MazeCity oakville = new MazeCity(MazeRunner.gridHeight, MazeRunner.gridLength);
		SimpleMazeBot thisRobot = new SimpleMazeBot(oakville, 0, 0, Direction.EAST);
		
		addTarget(oakville);
		thisRobot.run();
	}

}
