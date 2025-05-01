package unit_3_recurSort;
import becker.robots.*;

/**
 * Programming assessment
 * @author Eric Feng
 * @version May 1 2025
 */
public class FengRobberRobot extends RobotSE{
	
	private int maxLoad; // the max number of things the robot can carry
	
	/**
	 * Constructor method for creating a FengRobberRobot
	 * @param c c is the city
	 * @param street street is the street number
	 * @param ave ave is the ave number
	 * @param d d is the initial direction the robot faces
	 * @param maxLoad maxLoad is the maximum number of things the robot can carry at one time
	 */
	public FengRobberRobot(City c, int street, int ave, Direction d, int maxLoad) {
		super(c, street, ave, d);
		this.maxLoad = maxLoad;
	}
	
	/**
	 * Main logic for robbing a singular house
	 */
	public void robHouse() {
		int cycles;
		
		this.findNextFlag();
		this.moveToHouse();
		cycles = calculateNumberOfTrips();
		//The loop runs 1 less than the number of cycles, because the last cycle has some special properties
		for (int i = 0; i < cycles - 1; i++) {
			this.stashThings();
			this.returnToStart();
			this.continueRobbing();
		}
		//Last cycle of robbing
		this.finishRobbing();
	}
	
	/**
	 * Final cycle for robbing the house. There is a separate method for this because of an edge case.
	 */
	private void finishRobbing() {
		this.stashThings();
		this.turnAndFindNextFlag();
		
		//Pick up the flag if possible. Edge case: if the backpack is already full, then you cant pick it up
		this.pickFlagAndReturnToStart();
	}
	
	/**
	 * 
	 */
	private void continueRobbing() {
		this.turnAndFindNextFlag();
		this.moveToHouse();
	}
	
	/**
	 * turns the robot around and finds the next flag
	 */
	private void turnAndFindNextFlag() {
		this.turnAround();
		this.findNextFlag();
	}
	
	/**
	 * After picking up every thing at the house, return to the start and deposit everything
	 */
	private void returnToStart() {
		this.turnAndFindNextFlag();
		this.returnToStartAndDeposit();
	}
	
	/**
	 * After leaving the house and reaching the flag, deposit all the Things at the starting location
	 */
	private void returnToStartAndDeposit() {
		this.turnRight();
		this.continueMoving();
		this.putAllThings();
	}
	
	/**
	 * Once the flag is reached, handle for the edge case. either pick it up return to start or perform another iteration
	 */
	private void pickFlagAndReturnToStart() {
		//Backpack is already full, perform another iteration
		if (this.countThingsInBackpack() == this.maxLoad) {
			this.returnToStartAndDeposit();
			this.turnAndFindNextFlag();
			this.pickThing();
			this.turnAround();
		} else { //it's fine: normal case
			this.pickThing();
			this.turnRight();
		}
		this.finalDeposit();
	}
	
	/**
	 * deposit everything for the final iteration
	 */
	private void finalDeposit() {
		this.continueMoving();
		this.putAllThings();
		this.turnAround();
	}
	
	
	/**
	 * The robot keeps picking up things until its full capacity is reached or until there are no more things to pick
	 */
	private void stashThings() {
		//pick maxLoad number of things if possible
		for (int i = 0; i < this.maxLoad; i++) { 
			if (this.canPickThing()) {
				this.pickThing();
			} else { //Prevent unnecessary looping
				return;
			}
		}
	}
	
	/**
	 * Based on the number of things counted, we can calculate how many times the robot needs to travel 
	 * to the house using simple math. This helps avoids unnecessary trips.
	 * We need the ceiling of things / maxLoad because we want to make sure we pick up everything, 
	 * even though the last cycle may not pick up "maxLoad" things. This simulates it:
	 * @return returns the number of cycles (the number of trips the robot has to make)
	 */
	private int calculateNumberOfTrips() {
		int numOfThingsAtPos = this.countThings();
		int cycles = numOfThingsAtPos / this.maxLoad;
		//Edge case: if the number of things at the house doesn't divide equally with the maxLoad
		if (numOfThingsAtPos % this.maxLoad != 0) {
			cycles++;
		}
		return cycles;
	}
	
	/**
	 * After leaving the starting position and finding the thing, this moves the robot to the house
	 */
	private void moveToHouse() {
		this.turnLeft();
		this.continueMoving();
	}
	
	/**
	 * Continues moving the robot until it hits a wall
	 */
	private void continueMoving() {
		//Keep moving until a wall is hit
		while (this.frontIsClear()) {
			this.move();
		}
	}
	
	/**
	 * Continues moving the robot until it reaches a thing
	 */
	private void findNextFlag() {
		//Keep moving while it can
		while (this.frontIsClear()) {
			this.move();
			//If it found a thing, stop moving
			if (this.canPickThing()) {
				return;
			}
		}
	}
	
	/**
	 * counts the number of things at the current position
	 * @return the number of things at the current position
	 */
	private int countThings() {
		int count = 0;
		//Pick up everything and keep track of how many things have been picked up
		while (this.canPickThing()) {
			this.pickThing();
			count++;
		}
		
		//A for loop is safer, since there could already be things in the backpack
		for (int i = 0; i < count; i++) {
			this.putThing();
		}
		return count;
	}
	
}
