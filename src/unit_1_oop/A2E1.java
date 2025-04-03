package unit_1_oop;

import java.awt.*;
import javax.swing.JFrame;

/**
 * work
 * @author Eric Feng
 * @version March 17 2025
 */
public class A2E1 extends Canvas {

	public static void main(String[] args) {
		JFrame frame = new JFrame("A2E1");
		Canvas canvas = new A2E1();
		canvas.setSize(200, 500);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * special paint method
	 * draws a template traffic light
	 */
	public void paint(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(25, 25, 150, 450);
		g.setColor(Color.DARK_GRAY);
		g.fillOval(50, 50, 100, 100);
		g.drawRect(50, 50, 100, 100);
		g.fillOval(50, 200, 100, 100);
		g.drawRect(50, 200, 100, 100);
		g.fillOval(50, 350, 100, 100);
		g.drawRect(50, 350, 100, 100);
	}
}
