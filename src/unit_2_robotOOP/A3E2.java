package unit_2_robotOOP;
import becker.robots.*;
import java.util.*;

/**
 * /**
 * application class for testing a bar graph robot
 * @author Eric Feng
 * @version April 10 2025
 */
public class A3E2{

	/**
	 * creates a bar graph with things of random count between 1 to 10
	 */
	public static void createBarGraph(City c, int n) {
		Random generator = new Random();
		//Create the initial setup
		for (int i = 1; i <= n; ++i) {
			int num = generator.nextInt(10) + 1;
			for (int j = 0; j < num; ++j) {
				Thing thisThing = new Thing(c, i, 1);
			}
		}
	}
	
	public static void main(String[] args) {
		City oakville = new City();
		oakville.showThingCounts(true);
		BarGraphRobot thisRobot = new BarGraphRobot(oakville,1,1,Direction.EAST);
		
		createBarGraph(oakville, 7);
		thisRobot.spreadBarGraph();
	}

}
