package unit_1_oop.traffic;
import java.awt.*;

/**
 * Class for creating traffic light objects
 * @author Eric Feng
 * @version March 26 2025
 */
public class StopLight {
	
	//Encapsulated Data members
	private int x, y;
	private Graphics g;
	
	/**
	 * Constructor method
	 * @param x position
	 * @param y position
	 * @param graphics object
	 */
	public StopLight(int x, int y, Graphics g) {
		this.x = x; this.y = y; this.g = g;
		this.drawStopLight();
	}
	
	/**
	 * testing a static method
	 */
	public static void test() {
		System.out.println("test class method");
	}
	
	/**
	 * Draws a defualt stoplight on a separate window
	 */
	public void drawStopLight() {
		g.setColor(Color.DARK_GRAY);
		g.fillOval(x, y, 100, 100);
		g.fillOval(x, y+150, 100, 100);
		g.fillOval(x, y+300, 100, 100);
	}
	
	/**
	 * Turns on the green light
	 */
	public void goGreen() {
		g.setColor(Color.green);
		g.fillOval(x, y, 100, 100);
	}
	
	/**
	 * Turns on the yellow light
	 */
	public void goYellow() {
		g.setColor(Color.yellow);
		g.fillOval(x, y+150, 100, 100);
	}
	
	/**
	 * Turns on the Red light
	 */
	public void goRed() {
		g.setColor(Color.red);
		g.fillOval(x, y+300, 100, 100);
	}
}
