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
	 * Constructor method -> creates and draws a stoplight
	 * @param x position
	 * @param y position
	 * @param graphics object
	 */
	public StopLight(int x, int y, Graphics g) {
		this.x = x; this.y = y; this.g = g;
		this.drawStopLight();
	}
	
	/**
	 * Draws a default stoplight on a separate window
	 */
	private void drawStopLight() {
		g.setColor(Color.DARK_GRAY);
		g.drawRect(this.x-25, this.y-25, 150, 450);
		g.fillOval(this.x, this.y, 100, 100);
		g.fillOval(this.x, this.y+150, 100, 100);
		g.fillOval(this.x, this.y+300, 100, 100);
	}
	
	/**
	 * Turns on the green light
	 */
	public void goGreen() {
		g.setColor(Color.green);
		g.fillOval(this.x, this.y, 100, 100);
	}
	
	/**
	 * Turns on the yellow light
	 */
	public void goYellow() {
		g.setColor(Color.yellow);
		g.fillOval(this.x, this.y+150, 100, 100);
	}
	
	/**
	 * Turns on the Red light
	 */
	public void goRed() {
		g.setColor(Color.red);
		g.fillOval(this.x, this.y+300, 100, 100);
	}
}
