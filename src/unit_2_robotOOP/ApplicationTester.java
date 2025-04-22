package unit_2_robotOOP;
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
		Character[] arr = new Character[1];
		arr[0] = new coolCharacter(10, 10, g);
		arr[0].draw();
	}

}
