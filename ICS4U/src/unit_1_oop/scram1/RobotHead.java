package unit_1_oop.scram1;
import java.awt.*;

public class RobotHead {
	
	//Encapsulated data members
	private int x, y;
	private Graphics g;
	
	//Constructor method
	public RobotHead(int x, int y, Graphics g) {
		this.x = x; this.y = y; this.g = g;
	}
	
	public void drawHead() {
		//Draw the head shape
		g.setColor(Color.black);
		g.drawRect(this.x, this.y, 100, 100);
		
		//Draw the antenna
		g.drawLine(this.x+50, this.y, this.x+50, this.y-50);
		g.drawOval(this.x+45, this.y-60, 10, 10);
		
		//Draw the eyes
		g.setColor(Color.red);
		g.fillOval(this.x+25, this.y+15, 10, 10);
		g.fillOval(this.x+65, this.y+15, 10, 10);
		
		//Draw the mouth
		g.setColor(Color.green);
		g.drawRect(this.x+20, this.y+60, 60, 20);
		g.drawLine(this.x+20, this.y+70, this.x+80, this.y+70);
		g.drawLine(this.x+50, this.y+60, this.x+50, this.y+80);
		g.drawLine(this.x+35, this.y+60, this.x+35, this.y+80);
		g.drawLine(this.x+65, this.y+60, this.x+65, this.y+80);
	}
}
