package unit_3_recurSort;
import java.awt.*;
import javax.swing.JFrame;

/**
 * JFrame that draws Sierpinski’s Triangle
 * @author Eric Feng
 * @version April 30 2025
 */
public class A1E8 extends Canvas{
	
	/**
	 * Recursive helper method to draw the Sierpinski’s Triangle
	 * @param centerX
	 * @param centerY
	 * @param side
	 * @param g
	 */
	private void drawTriangle(int centerX, int centerY, int side, Graphics g) {
		if (side <= 10) { //Draws a triangle centered at centerX, centerY
			return;
		}
		//Calculate height that changes for each triangle method call
		int height = (int) (side / 2 * Math.sqrt(3));
		
		int leftX = centerX - side / 2, leftY = centerY + height / 2;
		int rightX = centerX + side / 2, rightY = centerY + height / 2;
		int topX = centerX, topY = centerY - height / 2;
		
		g.drawLine(leftX, leftY, topX, topY);
		g.drawLine(leftX, leftY, rightX, rightY);
		g.drawLine(rightX, rightY, topX, topY);
		
		int newSide = side / 2;
		int newHeight = (int)(newSide / 2 * Math.sqrt(3));
		
		//Recursive case: triangles are drawn in this order: left, right, top
		drawTriangle(centerX - newSide / 2, centerY + newHeight / 2, newSide, g);
		drawTriangle(centerX + newSide / 2, centerY + newHeight / 2, newSide, g);
		drawTriangle(centerX, centerY - newHeight / 2, newSide, g);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("A1E8 - Sierpinski’s Triangle");
		Canvas canvas = new A1E8();
		canvas.setSize(1280, 720);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		this.setBackground(Color.cyan);
		this.drawTriangle(640, 360, 500, g);
	}
	
}
