package unit_1_oop;
import java.awt.*;
import javax.swing.JFrame;

public class TrafficController extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("A3E1");
		Canvas canvas = new TrafficController();
		canvas.setSize(500, 500);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		this.setBackground(Color.CYAN);
		StopLight trafalgarDundas = new StopLight(50, 50,g);
		trafalgarDundas.drawStopLight();
		trafalgarDundas.goGreen();
		
		StopLight trafalgarUppermiddle = new StopLight(250, 50, g);
		trafalgarUppermiddle.drawStopLight();
		trafalgarUppermiddle.goRed();
	}
	
}
