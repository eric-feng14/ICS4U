package unit_2_robotOOP;
import becker.robots.*;

public class MyFirstRobot {

	public static void main(String[] args) {
		City oakville = new City();
		oakville.showThingCounts(true);
		Robot karel = new Robot(oakville,1,0,Direction.EAST);
		Thing toy = new Thing(oakville,0,1);
		Thing toy2 = new Thing(oakville,0,1);
		Wall barrier = new Wall(oakville,0,1,Direction.EAST);
		karel.move();
		karel.turnLeft();
		karel.move();
		if (karel.canPickThing()) karel.pickThing();
		for (int i =0; i<3;++i) karel.turnLeft();
		for (int i =0; i < 4;++i) {
			if (karel.frontIsClear()) {
				karel.move();
			}
		}
		if (karel.countThingsInBackpack() > 0) karel.putThing();
	}

}
