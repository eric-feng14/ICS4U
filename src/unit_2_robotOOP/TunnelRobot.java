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
		while (true) {
			this.findNextThing();
			if (this.endReached()) {
				this.goBack();
				break;
			}
			this.goBack();
		}
		
	}
	
	/**
	 * goes back from the picked up thing and returns it back to the starting position
	 */
	private void goBack() {
		this.continueMoving();
		this.deposit();
	}
	
	/**
	 * continues moving in one direction until a boundary is hit
	 */
	private void continueMoving() {
		this.turnAround();
		//continuing moving backwards until the original position is reached
		while (this.frontIsClear()) {
			this.move();
		}
	}
	
	/**
	 * deposits a thing
	 */
	private void deposit() {
		//put the thing down and turn around
		this.putThing();
		this.turnAround();
	}
	
//	/**
//	 * finds the next thing by moving forward and checking each time
//	 */
//	private void findNextThing() {
//		//Continue moving until a thing is found or the end is reached
//		while (this.frontIsClear()) {
//			this.move();
//			if (this.thingPresentThenPick()) {
//				break;
//			}
//		}
//	}
	
	/**
	 * determines whether the end of the tunnel has been reached
	 * @return returns a boolean value (if the end is reached)
	 */
	private boolean endReached() {
		if (! this.frontIsClear() && this.countThingsAtPos() == 1) {
			return true;
		}
		return false;
	}
	
	private int countThingsAtPos() {
		int counter = 0;
		while (this.canPickThing()) {
			this.pickThing();
			counter++;
		}
		this.putAllThings();
		return counter;
	}
	
	/**
	 * finds the next thing by moving forward and checking each time
	 * @return if the end of tunnel has been reached
	 */
	private void findNextThing() {
		//Continue moving until a thing is found or the end is reached
		while (this.frontIsClear()) {
			this.move();
			if (this.thingPresentThenPick()) {
				break;
			}
		}
	}
	
	/**
	 * At the robot's current position, check if an item can be picked up. If so, pick it up
	 * @return whether something can be picked
	 */
	private boolean thingPresentThenPick() {
		if (this.canPickThing()) {
			this.pickThing();
			return true;
		}
		return false;
	}
	
}
