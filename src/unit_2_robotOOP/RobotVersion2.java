package unit_2_robotOOP;
import becker.robots.*;

public class RobotVersion2 extends Robot{
	
	/**
	 * Moves for a set amount of steps
	 * @param numSteps numSteps represents how much the robot will move
	 */
	public void move(int numSteps) {
		for (int i = 0; i < numSteps; ++i) {
			this.move();
		}
	}
	
	/**
	 * Picks up a fixed amount of things
	 * @param numThings numThings represents how many things to pick up
	 */
	public void pickThing(int numThings) {
		for (int i = 0; i < numThings; ++i) {
			if (this.canPickThing()) //Prevent picking up nothing
				this.pickThing();
		}
	}
	
	/**
	 * Counts the number of things by picking them up and them placing them back
	 */
	public int countThings() {
		int count = 0;
		while (this.canPickThing()) {
			this.pickThing();
			count++;
		}
		while (this.countThingsInBackpack()>0)
			this.putThing();
		return count;
	}
	
	/**
	 * picks up all things at the current intersection
	 */
	public void pickAllThings() {
		while (this.canPickThing())
			this.pickThing();
	}
	
	/**
	 * puts down all things in the backpack
	 */
	public void putAllThings() {
		while (this.countThingsInBackpack() > 0)
			this.putThing();
	}
	
	/**
	 * Replicates turning the robot right
	 */
	public void turnRight() {
		for (int i=0;i<3;++i) {
			this.turnLeft();
		}
	}
	
	/**
	 * Replicates turning the robot around
	 */
	public void turnAround() {
		this.turnLeft();
		this.turnLeft();
	}
	
	/**
	 * places two things
	 */
	public void placeTwoThings() {
		if (this.countThingsInBackpack() > 0)
			this.putThing();
		this.move();
		if (this.countThingsInBackpack() > 0)
			this.putThing();
	}
	
	/**
	 * Constructor method -> reinitializes encapsulated data members
	 * @param c c is the city
	 * @param ave ave is the avnue
	 * @param street street is the streets
	 * @param d is direction
	 */
	public RobotVersion2(City c, int ave, int street, Direction d) {
		super(c, ave, street, d); //calls the parent's constructor
	}
}
