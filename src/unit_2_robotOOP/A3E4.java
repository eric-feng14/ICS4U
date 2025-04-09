package unit_2_robotOOP;
import becker.robots.*;

public class A3E4 {

	final static int numLoops = 3;
	
	/**
	 * adds n thing at position (x,y)
	 * @param x x value of position
	 * @param y y value of position
	 * @param n number of things to add
	 */
	public static void addThings(City c, int x, int y, int n) {
		for (int i = 0; i < n; ++i) {
			Thing t = new Thing(c,x,y);
		}
	}
	
	public static void main(String[] args) {
		final int robotX = 4, robotY = 4;
		City oakville = new City();
		oakville.showThingCounts(true);
		SpiralBot thisRobot = new SpiralBot(oakville,robotX,robotY,Direction.EAST);
		
		addThings(oakville, robotX, robotY, 49);
		thisRobot.makeSpiral(A3E4.numLoops);
	}

}
