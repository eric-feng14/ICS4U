package unit_3_recurSort;
import java.util.*;

public class A4E4 {

	public static String reversedWord(String word) {
		if (word.length() <= 1) {
			return word;
		}
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
