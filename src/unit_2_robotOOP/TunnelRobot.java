package unit_2_robotOOP;
import becker.robots.*;

/**
 * template class for tunnel robot
 * @author Eric Feng
 * @version April 10 2025
 */
public class TunnelRobot extends RobotSE{
	
	/**
	 * constructor method for creating a tunnel robot
	 * @param c c is the city
	 * @param ave ave is the vertical nums
	 * @param street street is the horizontal nums
	 * @param d d is the direction
	 */
	public TunnelRobot(City c, int ave, int street, Direction d) {
		super(c, ave, street, d); //calls the parent's constructor
	}
	
	/**
	 * main loop for collecting the things
	 */
	public void run() {
		boolean targetReached = false;
		//While we haven't reached the end of the tunnel
		while (! targetReached) {
			this.pickNextThing();
			//Checks if the we have reached the end of the tunnel
			if (this.endReached()) {
				targetReached = true;
			}
			this.returnAndDeposit();
		}
		this.exitPile();
	}
	
	private void returnAndDeposit() {
		this.returnToStart();
		this.deposit();
	}
	
	/**
	 * exit the pile by moving once toward the tunnel
	 */
	private void exitPile() {
		this.move();
	}
	
	/**
	 * Moves the robot back to the starting pile after picking up a thing
	 */
	private void returnToStart() {
		this.turnAround();
		this.continueMoving();
	}
	
	/**
	 * continues moving forward until the robot is blocked by a wall
	 */
	private void continueMoving() {
		//while not blocked
		while (this.frontIsClear()) {
			this.move();
		}
	}
	
	/**
	 * finds the next thing in the tunnel and picks it up
	 */
	private void pickNextThing() {
		//keep moving until blocked
		while (this.frontIsClear()) {
			this.move();
			//found a Thing
			if (this.canPickThing()) {
				this.pickThing();
				return;
			}
		}
	}
	

	/**
	 * deposits a thing and turns around to prepare for the next cycle
	 */
	private void deposit() {
		this.putThing();
		this.turnAround();
	}
	
	/**
	 * determines whether the end of the tunnel has been reached
	 * @return returns a boolean value (if the end is reached)
	 */
	private boolean endReached() {
		//front is blocked and no more items to pick up in the future
		if (! this.frontIsClear() && this.countThingsAtPos() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * counts the number of things at the robot's current position
	 * @return returns an integer representing the num of things at the robots position
	 */
	private int countThingsAtPos() {
		int counter = 0;
		//Keep picking things up
		while (this.canPickThing()) {
			this.pickThing();
			counter++;
		}
		
		//For loop is safer, so if things were already in the backpack, they won't be placed back down. 
		// The function puts down every thing that has been picked up before.
		for (int i = 0; i < counter; i++) {
			this.putThing();
		}
		return counter;
	}
	
}
