package unit_2_robotOOP;
import becker.robots.*;

public class A3E3 {
	
	final static int size = 8, separation = 2;
	
	/**
	 * creates n walls representing the tunnel, as well as one behind the robot
	 * @param c c is the city to be drawn on
	 * @param x x is the starting x value of the robot 
	 * @param y y is the starting y value of the robot 
	 */
	public static void createBoundariesWithThings(City c, int x, int y) {
		Wall myWall = new Wall(c,x,y,Direction.WEST);
		for (int i = y+A3E3.separation; i < y+A3E3.separation+A3E3.size; i++) {
			Wall wall1 = new Wall(c,x,i,Direction.NORTH);
			Wall wall2 = new Wall(c,x,i,Direction.SOUTH);
			Thing thisThing = new Thing(c,x,i);
		}
		Wall thisWall = new Wall(c,x,y+A3E3.separation+A3E3.size-1,Direction.EAST);
	}

	public static void main(String[] args) {
		final int robotX = 2, robotY = 2;
		City oakville = new City();
		oakville.showThingCounts(true);
		TunnelRobot thisRobot = new TunnelRobot(oakville,robotX, robotY,Direction.EAST);
		
		createBoundariesWithThings(oakville, robotX, robotY);
		thisRobot.run();
		

	}

}
