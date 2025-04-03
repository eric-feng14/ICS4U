package unit_2_robotOOP;
import becker.robots.*;

public class A2E1 {

	public static void main(String[] args) {
		City oakville = new City();
		oakville.showThingCounts(true);
		RobotVersion2 karel = new RobotVersion2(oakville,1,1,Direction.EAST);
		
		karel.move(2);
		for (int i=0;i<3;++i) {
			Thing myThing = new Thing(oakville,1,3);
		}
		karel.pickThing(1);
		System.out.println(karel.countThings());
		karel.pickAllThings();
		karel.move(2);
		karel.putAllThings();
		karel.turnRight();
		karel.move(2);
		karel.turnAround();
	}

}
