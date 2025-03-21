package unit_1_oop;
import java.awt.*;
import javax.swing.JFrame;

public class TrafficController extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("A3E1");
		Canvas canvas = new TrafficController();
		canvas.setSize(500, 400);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		this.setBackground(Color.CYAN);
		
	}
	
}
