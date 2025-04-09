package unit_2_robotOOP;
import becker.robots.*;

/**
 * Template class for replicated assignment in class
 * @author Eric Feng
 * @version April 8 2025
 */
public class HurdleRobot extends RobotSE{
	
	//Constructor
	public HurdleRobot(City c, int ave, int street, Direction d) {
		super(c, ave, street, d); //calls the parent's constructor
	}
	
	/**
	 * runs the whole race for a single robot
	 * pre: robot is on the coin
	 * post: robot is done the race, places the coin back down
	 */
	
	public static void createHurdles(City c) {
		for (int i = 0; i < 10; ++i) {
			Wall x = new Wall(c, 3, i, Direction.SOUTH);
		}
		for (int i = 1; i <= 7; i+=2) {
			for (int j = 2; j < 4; ++j) {
				Wall a = new Wall(c,j,i,Direction.EAST);
			}
		}
	}
	
	public void runRace() {
		this.pickAllThings();
		for (int i = 0; i < 2; ++i) {
			this.goToHurdle();
			this.jump();
			this.land();
		}
		this.putAllThings();
	}
	
	/**
	 * runs to the hurdle
	 * pre: robot is facing the hurdle
	 * post: robot is right before the hurdle, still facing it
	 */
	private void goToHurdle() {
		while (this.frontIsClear()) {
			this.move();
		}
	}
	
	/**
	 * jumps over the hurdle
	 * pre: is at the hurdle, facing it
	 * post: ends at the top of the hurdle, facing forwards
	 */
	private void jump() {
		this.turnLeft();
		for (int i = 0; i < 2; i++) {
			this.move();
		}
		this.turnRight();
		this.move();
	}
	
	/**
	 * lands on the groud
	 * pre: facing forward on the top of the hurdle
	 * post: ends at the ground, facing the next hurdle
	 */
	private void land() {
		this.turnRight();
		for (int i = 0; i < 2; i++) {
			this.move();
		}
		this.turnLeft();
	}
}
