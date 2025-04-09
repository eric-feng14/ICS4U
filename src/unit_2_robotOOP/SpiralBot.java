package unit_2_robotOOP;
import becker.robots.*;

public class SpiralBot extends RobotSE{
	
	//Constructor method
	public SpiralBot(City c, int x, int y, Direction d) {
		super(c,x,y,d);
	}
	
	/**
	 * main logic for creating the spiral
	 * @param numLoops numLoops the number of loops wanted
	 */
	public void makeSpiral(int numLoops) {
		/*
		 * Pattern
		 * 2 moves of length 1
		 * 2 moves of length 2
		 * 2 moves of length 3
		 * ... so on
		 * 
		 * 1 loop cycle is 2 steps of the pattern + 1 extra line
		 */
		this.pickUpEverything();
		
		for (int i = 1; i <= 2*numLoops; i++) {
			this.wrapAround(i);
		}

		this.addEndingLine();
	}
	
	private void pickUpEverything() {
		this.pickAllThings();
	}
	
	/**
	 * adds the final line of things to complete the spiral
	 */
	private void addEndingLine() {
		for (int i = 0; i < 2*A3E4.numLoops+1; i++) {
			depositAndMove();
		}
	}
	
	/**
	 * moves n time for 2 iterations
	 * @param n distance to move for each iteration
	 */
	private void wrapAround(int n) {
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < n; ++j) {
				depositAndMove();
			}
			this.turnLeft();
			
		}
	}
	
	/**
	 * puts a thing and moves forward
	 */
	private void depositAndMove() {
		this.putThing();
		this.move();
	}
	
}
