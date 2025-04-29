package unit_3_recurSort;
import java.util.*;

public class A4E4 {

	/**
	 * recursive function that returns a reversed version of a word
	 * @param word the subsection of the string
	 * @return the reversed version of a string
	 */
	public static String reversedWord(String word) {
		//Base case
		if (word.length() <= 1) {
			return word;
		}
		//Recursive case - keeps putting last letter at the end
		return reversedWord(word.substring(1)) + word.charAt(0);
		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String word = input.next();
		String reversedWord = reversedWord(word);
		System.out.println(reversedWord);
		if (word.equals(reversedWord)) {
			System.out.println(word + " is a palindrome");
		} else {
			System.out.println(word + " is not a palindrome");
		}
	}

}
