package unit_0_review;
import java.util.*;
import java.io.*;

/**
 * Converts text from a file into pig latin
 * @author Eric Feng
 * @version Feb 27 2025
 */
public class A6E2 {

	public static void main(String[] args) {
		// Collect input
		try {
			Scanner input = new Scanner(new File("data2.txt"));
			while (input.hasNext()) {
				String word = input.next();
				char firstLetter = word.charAt(0);
				word = word.substring(1) + firstLetter + "ay";
				System.out.println(word);
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