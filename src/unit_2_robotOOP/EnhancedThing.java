package unit_2_robotOOP;
import becker.robots.*;
import java.util.*;

public class EnhancedThing extends Thing{
	
	//Encapsulated data members
	private City c;
	
	//Constructor method
	public EnhancedThing(City c, int x, int y) {
		super(c,x,y);
	}
	
	/**
	 * This could be modified so that it works for all directions
	 * It places a row of things in a line
	 * @param x start x position of line
	 * @param y start y position of line
	 */
	public void putThingsInLine(int x, int y, int count) { 
		Random generator = new Random();
		for (int i = 0; i < count; ++i) {
			int num = generator.nextInt(10) + 1;
			for (int j = 0; j < num; ++j) {
				Thing x = new Thing(oakville, )
				EnhancedThing x = new EnhancedThing(this.c, x+i, y);
			}
		}
	}
}
