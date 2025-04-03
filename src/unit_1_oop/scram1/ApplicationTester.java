package unit_1_oop.scram1;
import java.awt.*;
import javax.swing.JFrame;

public class ApplicationTester extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("Robot drawing");
		Canvas canvas = new ApplicationTester();
		canvas.setSize(500, 800);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
//		this.setBackground(Color.white);
		RobotHead thisHead = new RobotHead(200, 100, g);
		thisHead.drawHead();
		
		final int maxHorizontal = 500, maxVertical = 800, size = 15;
		for (int x = 0; x < maxHorizontal; x+=size) {
			for (int y = 700; y < maxVertical; y+=size) {
				Foreground.drawRock(x, y, g, size);
//				Foreground.drawBush(x, y, g, size);
			}
		}
	}

}
