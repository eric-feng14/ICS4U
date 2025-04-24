package unit_2_robotOOP;

import java.awt.*;

public abstract class Character {
	public static final int WIDTH = 150;
	public static final int HEIGHT = 150;
	
	protected int x, y;
	protected Graphics g;
	
	public Character() {
		System.out.println("Constructor called");
	}
	
	public abstract void draw();
}
