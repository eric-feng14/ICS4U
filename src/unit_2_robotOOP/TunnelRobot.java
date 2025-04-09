package unit_2_robotOOP;
import becker.robots.*;

public class TunnelRobot extends RobotSE{
	
	//Encapsulated data member
	final private static int separation = 2;
	private int tunnelLength = 0;
	
	//Constructor
	public TunnelRobot(City c, int ave, int street, Direction d) {
		super(c, ave, street, d); //calls the parent's constructor
	}
	
	/**
	 * creates n walls representing the tunnel, as well as one behind the robot
	 * @param x x is the x value for robot start pos
	 * @param y y is the y value for robot start pos
	 * @param n n is the number of walls to create
	 */
	public void createBoundariesWithThings(int x, int y, int n) {
		this.tunnelLength = n;
		Wall myWall = new Wall(this.getCity(),x,y,Direction.WEST);
		for (int i = y+this.separation; i < y+this.separation+n; i++) {
			Wall wall1 = new Wall(this.getCity(),x,i,Direction.NORTH);
			Wall wall2 = new Wall(this.getCity(),x,i,Direction.SOUTH);
			Thing thisThing = new Thing(this.getCity(),x,i);
		}
		Wall thisWall = new Wall(this.getCity(),x,y+this.separation+n-1,Direction.EAST);
	}
	
	/**
	 * main loop for collecting the things
	 */
	public void run() {
		for (int i = 0; i < this.tunnelLength; i++) {
			this.findNextThing();
			this.goBack();
		}
	}
	
	/**
	 * goes back from the picked up thing and returns it back to the starting position
	 */
	private void goBack() {
		this.turnAround();
		while (this.frontIsClear()) {
			this.move();
		}
		this.putThing(); //again this can be changed if necessary
		this.turnAround();
	}
	
	/**
	 * finds the next thing by moving forward and checking each time
	 */
	private void findNextThing() {
		//Edge case
		while (this.frontIsClear()) {
			this.move();
			if (this.canPickThing()) {
				this.pickThing(); //assuming only 1 thing, this can be changed later if necessary
				return;
			}
		}
	}
	
}
