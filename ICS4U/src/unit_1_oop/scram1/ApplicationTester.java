package unit_1_oop.scram1;
import java.awt.*;
import javax.swing.JFrame;

import unit_1_oop.GraphicsLesson;

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
		Foreground foreGround1 = new Foreground(g);
		foreGround1.drawBush(400, 700, 30);
	}

}
