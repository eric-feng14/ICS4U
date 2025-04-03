package unit_1_oop.scram1;
import java.awt.*;

public class Foreground {
	
	public static void drawBush(int x, int y, Graphics g, int size) {
		g.setColor(new Color(34, 139, 34)); // Green foliage
        g.fillOval(x - size / 2, y - size / 2, size, size);
        g.fillOval(x - size / 3, y - size / 3, size, size);
        g.fillOval(x, y - size / 2, size, size);
        g.fillOval(x - size / 4, y - size / 3, size, size);
        g.fillOval(x - size / 6, y - size / 4, size, size);
	}
	
	public static void drawRock(int x, int y, Graphics g, int size) {
		g.setColor(new Color(112, 128, 144)); // Gray rock color
        g.fillOval(x - size / 2, y - size / 2, size, (int)(size / 1.5));
        g.fillOval(x - size / 3, y - size / 3, (int)(size * 0.8), (int)(size / 1.6));
        g.fillOval(x, y - size / 2, (int)(size * 0.7), (int)(size / 1.7));
	}
	
}
