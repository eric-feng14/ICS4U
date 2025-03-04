package unit_0_review;
import java.util.*;
import java.io.*;

/**
 * Converts text from a file into pig latin
 * @author Eric Feng
 * @version Feb 27 2025
 */
public class A6E2v2 {

	public static void main(String[] args) {
		// Collect input
		try {
			// Declare variables and collect input
			Scanner input = new Scanner(new File("data2.txt"));
			String[] upperLetters = {"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"}; //used a python program to format it lol
			String[] sentenceEndings = {".", "?", "!"};
			String[] sentenceConnectors = {",", ":"};
			String newLine = "";
			
			// Collect each word from the file as input
			while (input.hasNext()) {
				// Declare variables
				String word = input.next();
				String firstLetter = word.substring(0,1), addedEnding = "";
				boolean hasEnding = false, hasConnector = false;
				
				for (String c : upperLetters) {
					if (firstLetter.equals(c)) {
						String secondLetter = word.substring(1,2).toUpperCase();
						addedEnding += firstLetter.toLowerCase();
						word = secondLetter + word.substring(2);
						break;
					}
				}
				
				for (String c : sentenceEndings) {
					if (word.endsWith(c)) {
						addedEnding += c;
					}
				}
				
				for (String c : sentenceConnectors) {
					if (word.endsWith(c)) {
						addedEnding += c;
					}
				}
				
				word += addedEnding;
				
				if (word.endsWith("\n")) {
					System.out.println(newLine);
					newLine = "";
				} else {
					newLine += word + " ";
				}
				
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