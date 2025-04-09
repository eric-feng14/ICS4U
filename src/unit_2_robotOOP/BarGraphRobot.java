package unit_2_robotOOP;
import becker.robots.*;
import java.util.*;

/**
 * Template class for replicated assignment in class
 * @author Eric Feng
 * @version April 8 2025
 */
public class BarGraphRobot extends RobotSE{
	
	//Constructor
	public BarGraphRobot(City c, int ave, int street, Direction d) {
		super(c, ave, street, d); //calls the parent's constructor
	}
	
	/*
	 * puts all things in order for a section of the bar graph
	 */
	public void spreadBarGraph() {
		for (int i = 0; i < A3E2.numberOfThings; ++i) {
			this.pickUpEverything();
			this.placeThingsInALine();
			this.goBack();
		}
	}
	
	/**
	 * picks up all things at the robots currents location
	 */
	private void pickUpEverything() {
		this.pickAllThings();
	}
	
	/**
	 * puts all things into a line
	 */
	private void placeThingsInALine() {
		while (this.countThingsInBackpack() > 0) {
			this.moveAndPutThing();
		}
	}
	
	/**
	 * moves and puts a thing
	 */
	private void moveAndPutThing() {
		this.move();
		this.putThing();
	}
	
	/**
	 * goes backwards and prepares for the next row
	 */
	private void goBack() {
		this.turnAround();
		continuePickingThings();
		prepareNextRow();
	}
	
	/**
	 * continues going forward and picking things if they exist
	 */
	private void continuePickingThings() {
		while (this.canPickThing()) {
			this.move();
		}
	}
	
	/**
	 * prepares the robot to spread the things on the next row
	 */
	private void prepareNextRow() {
		this.turnLeft();
		this.move();
		this.turnLeft();
	}
	
}
