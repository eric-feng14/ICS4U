package unit_3_recurSort.sorting;
import java.util.*;

public class FengVowels {
	
	private static int countVowels(String word) {
		word = word.toLowerCase();
		char[] vowels = {'a','e','i','o','u'};
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			for (char v: vowels) {
				if (word.charAt(i) == v) {
					count++; 
					break;
				}
			}
		}
		return count;
	}
	
	private static void swap(String[] words, int i, int j) {
		//Swap the words in the array
		String tmp = words[i];
		words[i] = words[j];
		words[j] = tmp;
	}
	
	private static void sortAlphabetically(String[] words, int start, int end) {
		for (int i = start; i < end-1; i++) {
			for (int j = i+1; j < end; j++) {
				if (words[j].compareTo(words[i]) < 0) {
					swap(words, i, j);
				}
			}
		}
	}
	
	public static void sort(String[] words) {
		//Group words by number of vowels
		for (int i = 0; i < words.length-1; i++) {
			for (int j = i+1; j < words.length; j++) {
				if (countVowels(words[j]) < countVowels(words[i])) {
					swap(words, i, j);
				}
			}
		}
		
		//Sort words alphabetically
		int i = 0;
		while (i < words.length - 1) {
			int j = i + 1;
			while (j < words.length && countVowels(words[j]) == countVowels(words[i])) {
				j++;
			}
			sortAlphabetically(words, i, j);
			i = j;
		}
		
		int med1 = countVowels(words[words.length/2]), med2 = countVowels(words[words.length / 2 - 1]);
		for (i = 0; i < words.length; i++) {
			System.out.print(words[i]+" ");
		}
		System.out.println();
		if (words.length % 2 == 1) {
			for (i = 0; i < words.length; i++) {
				if (countVowels(words[i]) == med1) {
					System.out.print(words[i] + " ");
				}
			}
		} else {
			for (i = 0; i < words.length; i++) {
				int currVowels = countVowels(words[i]);
				if (currVowels == med1 || currVowels == med2) {
					System.out.print(words[i] + " ");
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] words = {"a", "dog", "chased", "after", "my", "pet", "rabbit", "doggo"};
		sort(words);
		
	}

}
