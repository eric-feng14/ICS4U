package unit_2_robotOOP;
import becker.robots.*;
import java.util.*;

/**
 * Template class for replicated assignment in class
 * @author Eric Feng
 * @version April 8 2025
 */
public class BarGraphRobot extends RobotSE{
	
	final private static int numberOfThings = 7;
	
	//Constructor
	public BarGraphRobot(City c, int ave, int street, Direction d) {
		super(c, ave, street, d); //calls the parent's constructor
	}
	
	/**
	 * creates a bar graph with things of random count between 1 to 10
	 */
	public void createBarGraph() {
		Random generator = new Random();
		//Create the initial setup
		for (int i = 1; i <= numberOfThings; ++i) {
			int num = generator.nextInt(10) + 1;
			for (int j = 0; j < num; ++j) {
				Thing thisThing = new Thing(this.getCity(), i, 1);
			}
		}
	}
	
	/**
	 * puts all things in order for a section of the bar graph
	 */
	public void spreadBarGraph() {
		for (int i = 0; i < numberOfThings; ++i) {
			this.pickAllThings();
			this.placeThingsInALine();
			this.goBack();
		}
	}
	
	/**
	 * puts all things into a line
	 */
	private void placeThingsInALine() {
		while (this.countThingsInBackpack() > 0) {
			this.move();
			this.putThing();
		}
	}
	
	/**
	 * goes backwards and prepares for the next row
	 */
	private void goBack() {
		this.turnAround();
		while (this.canPickThing()) {
			this.move();
		}
		this.turnLeft();
		this.move();
		this.turnLeft();
	}
}
