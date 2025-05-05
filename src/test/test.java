package test;
//import javax.swing.*;
//import java.awt.*;
//
//public class test extends Canvas{
//	public static void main(String[] args) {
//		JFrame frame = new JFrame("Sample Frame");
//		Canvas canvas = new test();
//		canvas.setSize(650, 500);
//		frame.add(canvas);
//		frame.pack();
//		frame.setVisible(true);
//	}
//	
//	public void paint(Graphics g) {
//		
//	}
//
//}

import java.util.*;
import java.io.*;

public class test {
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("numbers2.txt"));
			int i = 0;
			while (input.hasNext()) {
				int n = input.nextInt();
				i++;
			}
			System.out.println(i);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(0);
		}
	}
}