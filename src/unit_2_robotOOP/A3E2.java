package unit_2_robotOOP;
import becker.robots.*;
import java.util.*;

public class A3E2{
	
	final static int numberOfThings = 7;

	/**
	 * creates a bar graph with things of random count between 1 to 10
	 */
	public static void createBarGraph(City c) {
		Random generator = new Random();
		//Create the initial setup
		for (int i = 1; i <= A3E2.numberOfThings; ++i) {
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
		
		createBarGraph(oakville);
		thisRobot.spreadBarGraph();
	}

}
