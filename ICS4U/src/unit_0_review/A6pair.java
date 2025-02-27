package unit_0_review;
import java.util.*;
import java.io.*;

public class A6pair {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("data3.txt"));
			String vowels = "aeiouAEIOU";
			while (input.hasNextLine()) {
				String newLine = "";
				String line = input.nextLine();
				for (int i = 0; i< line.length(); i++) {
					String currentCharacter = line.substring(i, i+1);
					boolean isVowel = false;
					for (int j = 0; j < vowels.length(); j++) {
						String currentVowel = vowels.substring(j, j+1);
						if (currentCharacter.equals(currentVowel)) {
							isVowel = true;
							break;
						}
					}

					if (! isVowel) {
						newLine += currentCharacter;
					}
				}
				System.out.println(newLine);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
			System.exit(0);
		}
	}

}
