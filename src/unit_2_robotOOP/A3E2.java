package unit_2_robotOOP;
import becker.robots.*;
import java.util.*;

public class A3E2 extends HurdleRobot{

	public A3E2(City c, int ave, int street, Direction d) {
		super(c, ave, street, d); //calls the parent's constructor
	};
	
	public static void main(String[] args) {
		City oakville = new City();
		oakville.showThingCounts(true);
		BarGraphRobot thisRobot = new BarGraphRobot(oakville,1,1,Direction.EAST);
		
		thisRobot.createBarGraph();
		thisRobot.spreadBarGraph();
	}

}
