package unit_2_robotOOP;
import becker.robots.*;

/**
 * Template class for a spiral robot
 * @author Eric Feng
 * @version April 10 2025
 */
public class SpiralBot extends RobotSE{
	
	/**
	 * Constructor method for a tunnel robot
	 * @param c c is the city
	 * @param x x is the x value of the robot
	 * @param y y is the y value of the robot
	 * @param d d is the direction the robot is facing
	 */
	public SpiralBot(City c, int x, int y, Direction d) {
		super(c,x,y,d);
	}
	
	/**
	 * main logic for creating the spiral
	 * @param numLoops numLoops the number of loops wanted
	 */
	public void makeSpiral(int numLoops) {
		this.pickUpEverything();
		
		for (int i = 1; i <= 2*numLoops; i++) {
			this.wrapAround(i);
		}

		this.addEndingLine(numLoops);
	}
	
	/**
	 * picks up every thing at the robot's current position. easier for user to understand?
	 */
	private void pickUpEverything() {
		this.pickAllThings();
	}
	
	/**
	 * adds the final line of things to complete the spiral
	 */
	private void addEndingLine(int numLoops) {
		//Loop the necessary amount of times to add the ending line
		for (int i = 0; i < 2*numLoops+1; i++) {
			depositAndMove();
		}
	}
	
	/**
	 * moves n time for 2 iterations
	 * @param n distance to move for each iteration
	 */
	private void wrapAround(int cycleLength) {
		//Performs a cycle 2 times
		for (int i = 0; i < 2; ++i) {
			this.cycle(cycleLength);
		}
	}
	
	/**
	 * place n items in a row and prepare to do it for the next cycle by turning left
	 * @param n how many items to place in a row
	 */
	private void cycle(int cycleLength) {
		for (int i = 0; i < cycleLength; i++) {
			this.depositAndMove();
		}
		this.turnLeft();
	}
	
	/**
	 * puts a thing and moves forward
	 */
	private void depositAndMove() {
		this.putThing();
		this.move();
	}
	
}
