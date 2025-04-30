package test;
import javax.swing.*;
import java.awt.*;

public class test extends Canvas{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Sample Frame");
		Canvas canvas = new test();
		canvas.setSize(650, 500);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		
	}

}
