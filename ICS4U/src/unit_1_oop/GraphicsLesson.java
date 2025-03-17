package unit_1_oop;
import java.awt.*; //stands for abstract windowing toolkit
import javax.swing.JFrame;

public class GraphicsLesson extends Canvas{

	public static void main(String[] args) {
		JFrame frame = new JFrame("My First Drawing");
		Canvas canvas = new GraphicsLesson();
		canvas.setSize(500, 400);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		this.setBackground(Color.CYAN);
		g.setColor(Color.blue);
		g.drawOval(0,0,200,100);
		g.drawOval(100,100,20,20);
		g.setColor(new Color(23,255,54));
		g.drawLine(0, 0, 300, 200);
		g.fillRect(100, 100, 50, 50);
	}
	

}
