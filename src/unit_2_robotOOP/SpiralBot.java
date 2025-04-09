package unit_2_robotOOP;
import becker.robots.*;

public class SpiralBot extends RobotSE{
	
	private int numLoops = 0;
	
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
		this.numLoops = numLoops;
		
		for (int i = 1; i <= 2*numLoops; i++) {
			this.performIteration(i);
		}

		this.addEndingLine();
	}
	
	/**
	 * puts things and moves forward for a specific amount of time
	 */
	private void addEndingLine() {
		for (int i = 0; i < 2*this.numLoops+1; i++) {
			this.putThing();
			this.move();
		}
	}
	
	/**
	 * moves n time for 2 iterations
	 * @param n distance to move for each iteration
	 */
	private void performIteration(int n) {
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < n; ++j) {
				this.putThing();
				this.move();
			}
			this.turnLeft();
			
		}
//		System.out.println("iteration done"); // Kept for debugging purposes
	}
	
}
