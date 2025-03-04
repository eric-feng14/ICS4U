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
				String line = input.nextLine() + " ";
				String currentWord = "", newLine = "";
				for (int i = 0; i < line.length(); i++) {
					String currentCharacter = line.substring(i,i+1);
					if (currentCharacter.equals(" ")) {
						String firstLetter = currentWord.substring(0,1);
						boolean isUpper = false, hasPeriod = false;
						
						// Check if the first letter of the word is a capital
						for (int j = 0; j<upperLetters.length();j++) {
							String currentCapital = upperLetters.substring(j,j+1);
							if (firstLetter.equals(currentCapital)) {
								isUpper = true;
								break;
							}
						}
						if (currentWord.endsWith(".")) {
							currentWord = currentWord.substring(0, currentWord.length()-1);
							hasPeriod = true;
						}
						
						if (isUpper) {
							firstLetter = firstLetter.toLowerCase();
							String secondLetter = currentWord.substring(1,2).toUpperCase();
							currentWord = secondLetter + currentWord.substring(2) + firstLetter + "ay";
						} else {
							currentWord = currentWord.substring(1) + firstLetter + "ay";
						}
						
						if (hasPeriod) {
							currentWord += ".";
						}
						
						// Add new word to resulting line and reset the word
						newLine += currentWord + " ";
						currentWord = "";
					} else { 
						currentWord += currentCharacter;
					}
				}
				//Print out resulting line
				System.out.println(newLine);
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