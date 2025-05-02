package unit_3_recurSort;
import java.awt.*;
import javax.swing.JFrame;

/**
 * JFrame that draws cantor's set
 * @author 14eri
 *
 */
public class A1E7 extends Canvas{
	
	//the amount of space between each rectangle, and the height of each rectangle
	final private int heightDiff = 40, height = 20;
	
	/**
	 * Recursive draw method that draws 
	 * @param x x is the x coord of the top left corner of the current rectangle
	 * @param y y is the y coord of the top left corner of the current rect
	 * @param len len is the side length of the rect
	 * @param g g is the graphics object to be drawn
	 */
	public void draw(int x, int y, int len, Graphics g) {
		if (len <= 3) {
			return;
		}
		
		//Main action: draw the two rectangles
		g.fillRect(x, y, len, height);
		//Recursive case: keep drawing the pairs of rectangles
		this.draw(x, y + heightDiff, len/3, g);
		this.draw(x + 2*len/3, y + heightDiff, len/3, g);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("A1E7 - Cantor's set");
		Canvas canvas = new A1E7();
		canvas.setSize(1280, 720);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		this.setBackground(Color.cyan);
		this.draw(140, 20, 1000, g);
	}
	
}
