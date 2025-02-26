package unit_0_review;
import java.util.*;
import java.io.*;

/**
 * Calculates the average length of words from a text file
 * @author Eric Feng
 * @version Feb 26 2025
 */
public class A6E1 {

	public static void main(String[] args) {
		// Declare variables
		int wordCount = 0, totalWordLength = 0;
		
		// Collect input
		try {
			Scanner input = new Scanner(new File("info.txt"));
			while (input.hasNext()) {
				String word = input.next();
//				if word.endsWith(".") {
//					
//				}
				totalWordLength += word.length();
				wordCount++;
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File not found!");
			System.exit(0);
		} catch (InputMismatchException ex) {
			System.out.println("Only put words in the file. ");
			System.exit(0);
		}
		

		}

	}
