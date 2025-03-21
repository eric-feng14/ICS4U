package unit_1_oop;
import java.awt.*;

public class StopLight {
	
	//Data members
	private int x, y;
	private Graphics g;
	
	//Constructor
	public StopLight(int x, int y, Graphics g) {
		this.x = x; this.y = y; this.g = g;
	}
	
	public void drawStopLight() {
		g.setColor(Color.DARK_GRAY);
		g.fillOval(x, y, 100, 100);
		g.fillOval(x, y+150, 100, 100);
		g.fillOval(x, y+300, 100, 100);
	}
	
	public void goGreen() {
		g.setColor(Color.green);
		g.fillOval(x, y, 100, 100);
	}
	
	public void goYellow() {
		g.setColor(Color.yellow);
		g.fillOval(x, y+150, 100, 100);
	}
	
	public void goRed() {
		g.setColor(Color.red);
		g.fillOval(x, y+300, 100, 100);
	}
}
