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
	final private static int size = 100;
	
	/**
	 * Constructor method -> creates and draws a stoplight
	 * @param x x-coordinate of the top left corner
	 * @param y coordinate of the top left corner
	 * @param g The graphics object for drawing
	 */
	public StopLight(int x, int y, Graphics g) {
		this.x = x; this.y = y; this.g = g;
		this.drawStopLight();
	}
	
	/**
	 * Draws a default stoplight on a separate window
	 */
	private void drawStopLight() {
		//Main frame
		g.setColor(Color.ORANGE);
		g.fillRect(this.x, this.y, 150, 450);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(this.x, this.y, 150, 450);
		
		//Lights
		g.fillOval(this.x+25, this.y+25, size, size);
		g.drawRect(this.x+25, this.y+25, size, size);
		g.fillOval(this.x+25, this.y+175, size, size);
		g.drawRect(this.x+25, this.y+175, size, size);
		g.fillOval(this.x+25, this.y+325, size, size);
		g.drawRect(this.x+25, this.y+325, size, size);
	}
	
	/**
	 * Turns on the green light
	 */
	public void goGreen() {
		g.setColor(Color.green);
		g.fillOval(this.x+25, this.y+25, size, size);
	}
	
	/**
	 * Turns on the yellow light
	 */
	public void goYellow() {
		g.setColor(Color.yellow);
		g.fillOval(this.x+25, this.y+175, size, size);
	}
	
	/**
	 * Turns on the red light
	 */
	public void goRed() {
		g.setColor(Color.red);
		g.fillOval(this.x+25, this.y+325, size, size);
	}
}
