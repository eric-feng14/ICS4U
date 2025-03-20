package unit_0_review;
import java.util.*;
import java.io.*;

public class FengCompress {

	public static void main(String[] args) {
		String filePath = "text1.txt";
		try {
			Scanner input = new Scanner(new File(filePath));
			String word;
			/*
			 * Although array is more efficient, we use ArrayList because we don't know the number of words.
			 * Looping through the array twice, (once for counting the words and once for the program logic)
			 * would give us the number of words so we can use array, but looping twice would be inefficient. 
			 */
			ArrayList<String> uniqueWords = new ArrayList<String>();
			String punctuation = "?!.,'";
			while (input.hasNext()) {
				word = input.next().toLowerCase();
				String remaining = "";
				for (int i = 0; i < word.length(); ++i) {
					char currChar = word.charAt(i);
					for (int j = 0; j < punctuation.length(); ++j) {
						char currPunctuation = punctuation.charAt(j);
						if (currPunctuation == currChar) {
							remaining = word.substring(i);
							word = word.substring(0,i);
						}
					}
				}
				
				boolean wordExists = false;
				for (String elem : uniqueWords) {
					if (elem.equals(word)) { //Word already exists
						wordExists = true;
						break;
					}
				}
				
				if (! wordExists) {
					uniqueWords.add(word);
					System.out.print(word + remaining + " ");
				} else {
					System.out.print(uniqueWords.indexOf(word) + remaining + " ");
				}
			}
			
			System.out.println();
			
			for (int i = 0; i < uniqueWords.size(); ++i) {
				System.out.format("%d %s\n", i, uniqueWords.get(i));
			}

			
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
			System.exit(0);
		}
	}

}
