package unit_3_recurSort.sorting;
import java.util.*;

public class FengDiagonals {
	
	public static int diagonal(int sides) {
		//base case
		if (sides == 4) return 2;
		return diagonal(sides-1) + sides-2;
	}
	
	
	/**
	 * Testing method -> Do not grade
	 * @param n
	 * @return
	 */
	public static int diagonalFormula(int n) {
		return n * (n-3) / 2;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the number of sides in the polygon ==> ");
		int sides = input.nextInt();
		int diagonals = diagonal(sides);
		System.out.format("There are %d diagonals.\n", diagonals);
		
		
		
//		for (int i = 4; i < 400; i++) { 
//			int v1 = diagonal(i), v2 = diagonalFormula(i);
//			if (v1 != v2) {
//				System.out.println("issue! ");
//				System.exit(0);
//			}
//		}
//		
//		System.out.println("success");
	}

}
