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
        	Scanner input = new Scanner(new File("numbers.txt"));
        	int idx = 0;
        	ArrayList<Integer> arr = new ArrayList<Integer>();
        	while (input.hasNext()) arr.add(input.nextInt());
        	arr.sort(null);
        	for (int i : arr) {
        		System.out.println(i);
        	}
        	
        	
        } catch (FileNotFoundException e) {
        	System.out.println("file not found");
        	System.exit(0);
        }
    }
}
