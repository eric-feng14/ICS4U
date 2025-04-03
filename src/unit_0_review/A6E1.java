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
		int wordCount = 0, totalWordLength = 0, numberOfSentences = 0;
		double avgWordsPerSentence, avgWordLength;

		// Collect input
		try {
			// 
			String sentenceEndings = ".?!";
			String puncutation = ",:";
			Scanner input = new Scanner(new File("data1.txt"));
			
			// Collect each line of input
			while (input.hasNext()) {
				// collect each word
				String word = input.next();
				for (int i = 0; i < sentenceEndings.length(); i++) {
					String ending = sentenceEndings.substring(i,i+1);
					if (word.endsWith(ending)) {
						numberOfSentences++;
						totalWordLength -= 1;
					}
				}
				for (int i = 0; i < puncutation.length(); i++) {
					String ending = puncutation.substring(i,i+1);
					if (word.endsWith(ending)) {
						totalWordLength -= 1;
					}
				}
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

		// Perform calculations
		avgWordLength = (double)totalWordLength / wordCount;
		avgWordsPerSentence = (double)wordCount / numberOfSentences;
		//Output
		System.out.format("The average word length is: %.2f\n", avgWordLength);
		System.out.format("The average number of words per sentence is: %.2f", avgWordsPerSentence);
	}

}
