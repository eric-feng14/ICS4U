package unit_2_robotOOP;
import becker.robots.*;

/**
 * /**
 * application class for testing a tunnel robot
 * @author Eric Feng
 * @version April 10 2025
 */
public class A3E3 {
	
	/**
	 * creates n walls representing the tunnel, as well as one behind the robot
	 * @param c c is the city to be drawn on
	 * @param x x is the starting x value of the robot 
	 * @param y y is the starting y value of the robot 
	 * @param size size is the size of the tunnel
	 * @param separation the initial distance between robot and the tunnel
	 */
	public static void createBoundariesWithThings(City c, int x, int y, int size, int separation) {
		Wall myWall = new Wall(c,x,y,Direction.WEST);
		//Loop through the tunnel
		for (int i = y+separation; i < y+separation+size; i++) {
			Wall wall1 = new Wall(c,x,i,Direction.NORTH);
			Wall wall2 = new Wall(c,x,i,Direction.SOUTH);
			Thing thisThing = new Thing(c,x,i);
			Thing newThing = new Thing(c,x,i);
		}
		Wall thisWall = new Wall(c,x,y+separation+size-1,Direction.EAST);
	}

	public static void main(String[] args) {
		final int robotX = 2, robotY = 2;
		final int size = 8, separation = 2;
		City oakville = new City(3, 13);
		oakville.showThingCounts(true);
		TunnelRobot thisRobot = new TunnelRobot(oakville,robotX, robotY,Direction.EAST);
		
		createBoundariesWithThings(oakville, robotX, robotY, size, separation);
		thisRobot.run();
		

	}

}
