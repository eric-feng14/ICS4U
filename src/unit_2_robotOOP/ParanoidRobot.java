package unit_2_robotOOP;
import becker.robots.*;
/**
 * Paranoid Robot always looks both ways before moving.
 */
public class ParanoidRobot extends RobotSE
{
	/**
	 * Constructor for ParanoidRobot.
	 * @param theCity Object for the City that the robot will be in
	 * @param street initial street location of the robot
	 * @param avenue initial avenue location of the robot
	 * @param direction initial direction the robot should be facing
	 */
	public ParanoidRobot (City theCity, int street, int avenue, Direction direction)
	{
		// Call constructor of super class (i.e. Robot)
		super(theCity, street, avenue, direction);
	}
	/**
	 * Override the move method in superclass (RobotSE), so it will check both ways
	 */
	public void move()
	{
		this.lookBothWays(); // make use of “stepwise refinement”
		super.move(); // Call move from superclass to move forward
	}
	/**
	 * Method that makes the robot look left and then right.
	 */
	private void lookBothWays()
	{
		this.turnLeft();
		this.turnAround();
		this.turnLeft();
	}
}