package unit_0_review;
import java.util.*;

/**
 * Create a program that generates 25 random integers between0and 99, fancy output format
 * @author Eric Feng
 * @vesion Feb 3 2025
 */
public class A7E2 {

	public static void main(String[] args) {
		// Assign constants
		final int num = 25, range = 99;
		
		// Variables
		ArrayList <Integer> evenArr = new ArrayList<Integer>();
		ArrayList <Integer> oddArr = new ArrayList<Integer>();
		Random gen = new Random();
		int currentNum;
		
		// Separate even and odd integers
		for (int i = 0; i < num; i++) {
			currentNum = gen.nextInt(range) + 1;
			if (currentNum % 2 == 0) { // even
				evenArr.add(currentNum);
			} else {
				oddArr.add(currentNum);
			}
		}
		
		System.out.println("ODD:");
		for (int i = 0; i < oddArr.size(); i++) {
			System.out.print(oddArr.get(i) + " ");
		}
		System.out.println("\nEVEN:");
		for (int i = 0; i < evenArr.size(); i++) {
			System.out.print(evenArr.get(i) + " ");
		}
	}

}
