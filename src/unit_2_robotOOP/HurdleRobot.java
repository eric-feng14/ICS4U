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
	 * runs the race for 1 robot
	 */
	public void runRace() {
		this.pickBaton();
		this.jumpHurdle();
		this.putBaton();
	}
	
	/**
	 * jump over one hurdle
	 */
	private void jumpHurdle() {
		//Jump over each hurdle twice
		for (int i = 0; i < 2; ++i) {
			this.goToHurdle(); 
			this.jump();
			this.land();
		}
	}
	
	/**
	 * picks up the baton
	 */
	private void pickBaton() {
		this.pickAllThings();
	}
	
	/**
	 * puts the baton back down
	 */
	private void putBaton() {
		this.putAllThings();
	}
	
	/**
	 * runs to the hurdle
	 * pre: robot is facing the hurdle
	 * post: robot is right before the hurdle, still facing it
	 */
	private void goToHurdle() {
		//continue moving while front is clear
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
		//move up twice
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
		//move down twice
		for (int i = 0; i < 2; i++) {
			this.move();
		}
		this.turnLeft();
	}
}
