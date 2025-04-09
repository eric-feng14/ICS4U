package unit_2_robotOOP;
import becker.robots.*;

public class A3E3 {

	public static void main(String[] args) {
		final int robotX = 2, robotY = 2;
		final int size = 8;
		City oakville = new City();
		oakville.showThingCounts(true);
		TunnelRobot thisRobot = new TunnelRobot(oakville,robotX, robotY,Direction.EAST);
		
		thisRobot.createBoundariesWithThings(robotX, robotY, size);
		thisRobot.run();
		

	}

}
