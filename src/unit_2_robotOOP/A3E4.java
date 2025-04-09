package unit_2_robotOOP;
import becker.robots.*;

public class A3E4 {

	public static void main(String[] args) {
		final int robotX = 4, robotY = 4;
		City oakville = new City();
		oakville.showThingCounts(true);
		SpiralBot thisRobot = new SpiralBot(oakville,robotX,robotY,Direction.EAST);
		
		
		thisRobot.addThings(robotX,robotY,49);
		thisRobot.pickAllThings();
		thisRobot.makeSpiral(3);
	}

}
