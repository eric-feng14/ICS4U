package unit_0_review;
import java.io.*;
import java.util.*;

public class Test {

	public static void main(String[] args) {
//		final int LOW = 'A', HIGH = 'Z';
//		int[] letterCounts = new int[HIGH-LOW+1];
//		
//		Scanner input = new Scanner(System.in);
//		System.out.print("Enter a word: ");
//		String word = input.nextLine();
//		input.close();
//		
//		char [] wordLetters = word.toUpperCase().toCharArray();
////		for (int letter = 0; letter < wordLetters.length; letter++ ) {
////			int offset = wordLetters[letter] - LOW;
////			letterCounts[offset] += 1;
////		}
//		for (char i : wordLetters) {
//			int index = i - LOW;
//			letterCounts[index] += 1;
//		}
//		
//		for (int i = LOW; i <= HIGH; i++) {
//			System.out.println((char) i + ": " + letterCounts[i - LOW]);
//		}
//		System.out.print("a");
//		System.out.print("\n");
//		System.out.print("b");
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = input.nextLine().toUpperCase();
		char[] arr = new char[name.length()];
		for (int i = 0; i < name.length(); ++i) {
			char currentChar = name.charAt(i);
			arr[i] = currentChar;
			System.out.println(currentChar);
		}
	}
}
