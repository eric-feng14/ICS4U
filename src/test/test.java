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
        	ArrayList<Integer> arr = new ArrayList<Integer>();
        	while (input.hasNext()) arr.add(input.nextInt());
        	arr.sort(null);
        	for (int i : arr) System.out.println(i);
        	
        	
        } catch (FileNotFoundException e) {
        	System.out.println("file not found");
        	System.exit(0);
        }
    }
    
	public void paste() {
//		//Loop through all of the sorted numbers
//		for (int i = 0; i < sortedNums.length; i++) {
//			int currentElement = originalNums[i];
//			int j = i - 1;
//			
//			/*
//			 * Start from the element before currentElement and search to the left. If the value is greater than currentElement, 
//			 * it means that the value should be placed more to the left: continue searching. 
//			 * Only when you reach a value that is less than or equal to currentValue, you would stop searching. 
//			 * Then, we insert "currentElement" into the corresponding open position.
//			 * Notice that all subsequent elements would be shifted 1 space to the right.
//			 * This is basically the same thing as finding the index of the smallest element that is greater than currentElement.
//			 * You could also perform this loop starting from index 0, it wouldn't make a difference. 
//			 * The idea is to shift the elements and insert the current element to its corresponding position.
//			 */
//			while (j >= 0 && sortedNums[j] > currentElement) {
//				sortedNums[j+1] = sortedNums[j];
//				j--;
//			}
//			sortedNums[j+1] = currentElement;
//		}
	}
}
