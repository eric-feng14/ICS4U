package unit_3_recurSort;
import java.awt.*;
import javax.swing.*;

public class fractal_tree extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("fractal tree");
		Canvas canvas = new fractal_tree();
		canvas.setSize(1280, 720);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Recursive draw method for the fractal tree
	 */
	public void draw(double x1, double y1, double angle, double length, Graphics g) {
        if (length < 5) return; // base case

        // Compute end point of the branch
        double x2 = x1 + Math.cos(angle) * length;
        double y2 = y1 + Math.sin(angle) * length;

        g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);

        // Recurse for left and right branches
        length *= 0.7;
        draw(x2, y2, angle - Math.toRadians(25), length, g); // left
        draw(x2, y2, angle + Math.toRadians(25), length, g); // right
	}

	/**
	 * special paint method
	 */
	public void paint(Graphics g) {
		draw(1280/2, 700, -Math.PI/2, 200, g);
	}
	

}
