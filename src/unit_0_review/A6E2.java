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
			// Declare variables and collect input
			String upperLetters = "QWERTYUIOPASDFGHJKLZXCVBNM";
			String sentenceEndings = ".?!";
			String sentenceConnectors  = ",:";
			Scanner input = new Scanner(new File("data2.txt"));
			
			// Collect each line from the file as input
			while (input.hasNextLine()) {
				String line = input.nextLine() + " "; // space for end of line
				String currentWord = "", newLine = "";
				
				// Get each character of the line
				for (int i = 0; i < line.length(); i++) {
					String currentCharacter = line.substring(i,i+1);
					
					// Separate the words by checking for spaces
					if (currentCharacter.equals(" ")) {
						int currentWordLength = currentWord.length();
						String firstLetter = currentWord.substring(0,1);
						String endingCharacter = currentWord.substring(currentWordLength-1);
						String addedEnding = "";
						
						
						// Check if the first letter of the word is a capital
						for (int j = 0; j<upperLetters.length(); j++) {
							String currentCapital = upperLetters.substring(j,j+1);
							if (firstLetter.equals(currentCapital)) {
								String secondLetter = currentWord.substring(1,2);
								addedEnding += firstLetter.toLowerCase();
								currentWord = secondLetter.toUpperCase() + currentWord.substring(2);
								break;
							}
						}
						
						// Added "ay" ending before puncutation and after capital modification
						addedEnding += "ay";
						
						// Check if the current word ends with a connector
						for (int k = 0; k < sentenceConnectors.length(); k++) {
							String currentConnector = sentenceConnectors.substring(k,k+1);
							if (currentConnector.equals(endingCharacter)) { 
								addedEnding += currentConnector;
								currentWord = currentWord.substring(0,currentWord.length()-1);
								break;
							}
						}
						
						// Check if the current word ends with an ending
						for (int l = 0; l < sentenceEndings.length(); l ++) {
							String currentEnding = sentenceEndings.substring(l,l+1);
							if (currentEnding.equals(endingCharacter)) {
								addedEnding += currentEnding;
								currentWord = currentWord.substring(0,currentWord.length()-1);
								break;
							}
						}
						
						// Add new word to resulting line and reset the word
						newLine += currentWord + addedEnding + " ";
						currentWord = "";
						
					//Current character is NOT a space, must be part of the word
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