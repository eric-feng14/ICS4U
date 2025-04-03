package unit_2_robotOOP;
import becker.robots.*;
import java.util.Random;

/**
 * Modified version of the second exercise
 * @author Eric Feng
 * @version April 1 2025
 */
public class A1E3 {

	public static void main(String[] args) {
		City oakville = new City();
		oakville.showThingCounts(true);
		Robot karel = new Robot(oakville,1,1,Direction.EAST);
		//avenue, street
		Wall[][] walls = new Wall[4][5];
		
		//Horizontal barriers
		for (int i = 0; i < 5; ++i) {
			walls[0][i] = new Wall(oakville,1,i+1,Direction.NORTH);
			walls[3][i] = new Wall(oakville,4,i+1,Direction.SOUTH);
		}
		
		//Vertical Barriers
		for (int i = 0; i < 4; ++i) {
			walls[i][0] = new Wall(oakville,i+1,1,Direction.WEST);
			walls[i][4] = new Wall(oakville,i+1,5,Direction.EAST);
		}
		
		/*
		 * Note that x represents the column value, as x and y are swapped
		 * For the random x position, it must be:
		 * 1 <= x <= 4
		 * For the random y position, it must be:
		 * 1 <= y <= 5 
		 * Note: some Thing's may overlap, so there is a counter
		 */
		Random generator = new Random();
		for (int i = 0; i < 5; ++i) {
			int x = 1 + generator.nextInt(4);
			int y = 1 + generator.nextInt(5);
			Thing obj = new Thing(oakville,x,y);
		}
		
		//Make sure it checks every single position (sample test case)
//		for (int i = 1; i < 5; ++i) {
//			for (int j = 1; j < 6; ++j) {
//				Thing x = new Thing(oakville,i,j);
//			}
//		}
		
		//Sample comment
		
		//Edge case, check the first square
		while (karel.canPickThing()) karel.pickThing();
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				karel.move();
				while (karel.canPickThing())
					karel.pickThing();
			}
			//Break condition
			if (i == 3)
				break;
			
			//Separate twisting right and left
			if (i % 2 == 0) {
				for (int k = 0; k<3; ++k) {
					karel.turnLeft();
				}
				karel.move();
				while (karel.canPickThing())
					karel.pickThing();
				for (int k = 0; k<3; ++k) {
					karel.turnLeft();
				}
			} else {
				karel.turnLeft();
				karel.move();
				while (karel.canPickThing())
					karel.pickThing();
				karel.turnLeft();
			}
		}
		
		//Return to origin and deposit all things
		for (int k = 0; k<3; ++k) {
			karel.turnLeft();
		}
		for (int k = 0; k<3; ++k) {
			karel.move();
		}
		while (karel.countThingsInBackpack() > 0)
			karel.putThing();
	}

}
