package unit_1_oop.traffic;
import java.awt.*;
import javax.swing.JFrame;

/**
 * Client code/Application Class
 * @author Eric Feng
 * @version March 26 2025
 */
public class TrafficController extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("A3E1");
		Canvas canvas = new TrafficController();
		canvas.setSize(650, 500);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * special paint method
	 */
	public void paint(Graphics g) {
//		this.setBackground(Color.CYAN);
		StopLight trafalgarDundas = new StopLight(25, 25, g);
		trafalgarDundas.goGreen();
		
		StopLight trafalgarUppermiddle = new StopLight(225, 25, g);
		trafalgarUppermiddle.goRed();
		
		StopLight dundasNeyagawa = new StopLight(425, 25, g);
		dundasNeyagawa.goYellow();
		
	}
	
}
