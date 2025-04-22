package unit_2_robotOOP;
import java.awt.*;

public class coolCharacter extends Character{
	final private int EYE_SIZE = 10;
	
	public coolCharacter(int x, int y, Graphics g) {
		this.x = x;
		this.y = y;
		this.g = g;
	}

	@Override
	public void draw() {
		this.g.setColor(Color.BLACK);
		this.g.drawOval(x, y, WIDTH, HEIGHT);
		
		//Draw the eyes
		this.g.setColor(Color.BLUE);
		this.g.fillOval(x+WIDTH*1/3, y+20, EYE_SIZE, EYE_SIZE);
		this.g.fillOval(x+WIDTH*2/3, y+20, EYE_SIZE, EYE_SIZE);
		
		
		this.g.drawOval(x+WIDTH*1/2-10, y+50, 20, 20);
		this.g.drawArc(x+WIDTH*1/3, y+80, x+WIDTH*1/3, 20, 0, -180);
	}
	
	

}
