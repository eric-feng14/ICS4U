package unit_1_oop;

import java.awt.*;
import javax.swing.JFrame;

/**
 * work
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
	 * Fills the green light
	 */
	public void goGreen(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(50, 350,100,100);
	}
	
	/**
	 * Fills the red light 
	 */
	public void goRed(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(50,  50, 100, 100);
	}
	
	/**
	 * Fills the yellow light
	 */
	public void goYellow(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(50,  200,  100,  100);
	}

	public void paint(Graphics g) {
		this.setBackground(Color.cyan);
		g.setColor(Color.DARK_GRAY);
		g.fillOval(50, 50, 100, 100);
		g.fillOval(50, 200, 100, 100);
		g.fillOval(50, 350, 100, 100);
		goYellow(g);
		goRed(g);
		goGreen(g);
	}
}
