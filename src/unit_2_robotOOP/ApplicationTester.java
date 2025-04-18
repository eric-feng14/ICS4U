package unit_2_robotOOP;
import becker.robots.*;

public class ApplicationTester {

	public static void main(String[] args) {
		City oakville = new City(10, 10);
		oakville.showThingCounts(true);
		Robot karel = new ParanoidRobot(oakville, 1, 1, Direction.SOUTH);
		karel.move();
		
	}

}
