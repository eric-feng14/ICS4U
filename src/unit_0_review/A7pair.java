package unit_0_review;
import java.util.*;
import java.io.*;

/**
 * Determine if a 3x3 matrix is a magic square based on file input
 * @author Eric Feng
 * @version Feb 3 2025
 */
public class A7pair {

	public static void main(String[] args) {
		try {
			// Constants
			final int SIZE = 3;

			// Variables and input
			Scanner input = new Scanner(new File("data4.txt"));
			int row = 0, col = 0;
			int[][] grid = new int[SIZE][SIZE];
			int referenceSum = 0, rowSum, columnSum, diag1Sum = 0, diag2Sum = 0;
			boolean isMagic = true;

			while (input.hasNextLine()) {
				String line = input.nextLine() + " ";
				String currentChar, currentNum = "";
				col = 0;
				for (int i = 0; i < line.length();i++) {
					currentChar = line.substring(i,i+1);
					if (currentChar.equals(" ")) {
						grid[row][col] = Integer.parseInt(currentNum);
						currentNum = "";
						col++;
					} else {
						currentNum += currentChar;
					}
				}
				row++;
			}

			// Calculate reference sum
			for (int n : grid[0]) {
				referenceSum += n;
			}

			// Calculate row and column sums
			for (int i = 0; i < SIZE;i++) {
				rowSum = 0;
				columnSum = 0;

				// Loop through the columns 
				for (int j = 0; j< SIZE;j++) {
					rowSum += grid[i][j];
					columnSum += grid[j][i];
				}
				
				// Add diagonal sums
				diag1Sum += grid[i][i];
				diag2Sum += grid[i][SIZE-(i+1)];
				
				// Check row and column sums
				if (rowSum != referenceSum || columnSum != referenceSum) {
					isMagic = false;
				}
				
			}
			
			// Check diagonal sums
			if (diag1Sum != referenceSum || diag2Sum != referenceSum) {
				isMagic = false;
			}

			// Final output
			if (isMagic) {
				System.out.println("Is a magic square");
			} else {
				System.out.println("Is not a magic square");
			}
			
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
			System.exit(0);
		}
	}
}
