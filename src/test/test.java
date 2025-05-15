package test;
import java.util.*;

public class test {
	
	public static void q1() {
		String string1 = "tea";
		String string2 = "eat";
		for (int i = 0; i < string1.length(); i++) {
			boolean found = false;
			for (int j = 0; j < string2.length(); j++) {
				if (string2.charAt(j) == string1.charAt(i)) {
					found = true; 
					string2 = string2.substring(0, j) + string2.substring(j+1);
					break;
				}
			}
			if (! found) {
				System.out.println("impossible");
				System.exit(0);
			}
		}
		System.out.println("possible");	
	}
	
	public static void q2() {
		final int SIZE = 52;
		String string1 = "tea";
		String string2 = "eat";
		if (string1.length() != string2.length()) {
			System.out.println("Not equal length strings! ");
			System.exit(0);
		}
		
		//Assuming only letters from the alphabet, e.g. a-z, A-Z, the size can be adjusted as necessary
		int[] freq1 = new int[SIZE];
		int[] freq2 = new int[SIZE];
		
		for (int i = 0; i < string1.length(); i++) {
			freq1[string1.charAt(i) - 'a']++;
			freq2[string2.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < freq1.length; i++) {
			if (freq1[i] != freq2[i]) {
				System.out.println("impossible");
				System.exit(0);
			}
		}
		System.out.println("possible");
		
	}
	
	public static void main(String[] args) {
		q1();
//		q2();
	}
}