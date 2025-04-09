package unit_2_robotOOP;
import becker.robots.*;

public class TunnelRobot extends RobotSE{
	
	//Constructor
	public TunnelRobot(City c, int ave, int street, Direction d) {
		super(c, ave, street, d); //calls the parent's constructor
	}
	
	/**
	 * main loop for collecting the things
	 */
	public void run() {
		for (int i = 0; i < A3E3.size; i++) {
			this.findNextThing();
			this.goBack();
		}
	}
	
	/**
	 * goes back from the picked up thing and returns it back to the starting position
	 */
	private void goBack() {
		this.turnAround();
		continueMoving();
		this.deposit();
	}
	
	/**
	 * continues moving in one direction until a boundary is hit
	 */
	private void continueMoving() {
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
	
	/**
	 * finds the next thing by moving forward and checking each time
	 */
	private void findNextThing() {
		//Continue moving until a thing is found or the end is reached
		while (this.frontIsClear()) {
			this.move();
			if (this.thingPresentThenPick()) {
				return;
			}
		}
	}
	
	/**
	 * At the robot's current position, check if an item can be picked up. If so, pick it up
	 */
	private boolean thingPresentThenPick() {
		if (this.canPickThing()) {
			this.pickThing();
			return true;
		}
		return false;
	}
	
}
