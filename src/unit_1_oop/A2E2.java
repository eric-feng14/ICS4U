package unit_1_oop;

import java.awt.*;
import javax.swing.JFrame;

/**
 * draws a traffic light with colors
 * @author Eric Feng
 * @version March 17 2025
 */
public class A2E2 extends Canvas {

	public static void main(String[] args) {
		JFrame frame = new JFrame("A2E2");
		Canvas canvas = new A2E2();
		canvas.setSize(200, 500);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Fills in the green light
	 * @param x x-coordinate of the top left corner of the shape
	 * @param y y-coordinate of the top left corner of the shape
	 * @param size size of the shape (length and width)
	 * @param g graphics object used to draw things
	 */
	public void goGreen(int x, int y, int size, Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x,y,size,size);
	}
	
	/**
	 * Fills in the red light
	 * @param x x-coordinate of the top left corner of the shape
	 * @param y y-coordinate of the top left corner of the shape
	 * @param size size of the shape (length and width)
	 * @param g graphics object used to draw things
	 */
	public void goRed(int x, int y, int size, Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x,y,size,size);
	}
	
	/**
	 * Fills in the yellow light
	 * @param x x-coordinate of the top left corner of the shape
	 * @param y y-coordinate of the top left corner of the shape
	 * @param size size of the shape (length and width)
	 * @param g graphics object used to draw things
	 */
	public void goYellow(int x, int y, int size, Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(x,y,size,size);
	}

	public void drawStopLight(Graphics g, int x, int y) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 150, 450);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(x, y, 150, 450);
		g.fillOval(x+25, y+25, 100, 100);
		g.drawRect(x+25, y+25, 100, 100);
		g.fillOval(x+25, y+175, 100, 100);
		g.drawRect(x+25, y+175, 100, 100);
		g.fillOval(x+25, y+325, 100, 100);
		g.drawRect(x+25, y+325, 100, 100);
		goRed(50,50,100,g);
		goYellow(50,200,100,g);
		goGreen(50,350,100,g);
	}
	/**
	 * Special paint method
	 */
	public void paint(Graphics g) {
		drawStopLight(g,25,25);	
	}
}
