package unit_2_robotOOP;
import becker.robots.*;

/**
 * Boxed area
 * @author Eric Feng
 * @version April 1 2025
 */
public class A1E2 {

	public static void main(String[] args) {
		City oakville = new City();
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
	}

}
