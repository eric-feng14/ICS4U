package unit_1_oop.scram1;
import java.awt.*;

public class Foreground {

	//Encapsulated data member
	private Graphics g;

	/**
	 * Constructor method: initializes the data members
	 */
	public Foreground(Graphics g) {
		this.g = g;
	}
	
	public void drawBush(int x, int y, int size) {
		this.g.setColor(new Color(34, 139, 34)); // Forest green
        
        this.g.fillOval((int) (x - size / 2),  (int) (y - size / 2), size, size);
        this.g.fillOval((int) (x - size / 3),  (int) (y - size / 1.5), size, size);
        this.g.fillOval((int) (x - size / 1.5),(int) (y - size / 1.5), size, size);
        
        this.g.setColor(new Color(139, 69, 19)); // Brown for trunk
        this.g.fillRect((int) (x - size / 10), (int) (y + size / 2 - 10), size / 5, 10);
	}
	
	public void drawRock() {
		
	}
	
}
