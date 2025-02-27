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
			String upperLetters = "QWERTYUIOPASDFGHJKLZXCVBNM";
			Scanner input = new Scanner(new File("data2.txt"));
			while (input.hasNextLine()) {
				String resultLine = "";
				String line = input.nextLine();
				String firstLetter = line.substring(0,1);
				//Check if the first letter is uppercase, have to do it manually because there's no method
				boolean isUpper = false;
				for (int i = 0; i<upperLetters.length();i++) {
					String currentLetter = upperLetters.substring(i,i+1);
					if (firstLetter.equals(currentLetter)) {
						isUpper = true;
						break;
					}
				}
				line = line.substring(1) + firstLetter + "ay";
				System.out.println(line);
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