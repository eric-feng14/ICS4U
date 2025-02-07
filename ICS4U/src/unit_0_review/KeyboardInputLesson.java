package unit_0_review;

import java.util.*;

/**
 * This program tests the abilities of java's built in scanner
 * @author 14eri
 * @version Feb 7 2025
 */
public class KeyboardInputLesson {

	public static void main(String[] args) {
		// setup (declare, initialize, assign)
		Scanner input = new Scanner(System.in);
		
		
		// getting user information
		System.out.print("Enter your name ");
//		String name = input.next(); //collects input until the next space
//		input.next(); // this line just collects input, doesn't do anything with it
		String name = input.nextLine(); //collects input until the end of the line
		System.out.print("Enter a number ");
		int num = input.nextInt();
		
		/* note: you cannot cast from int to string, but java will do it automatically 
		 * when there is a string being added/concatenated to*/
		String line = name + num;
		
		System.out.println("Your name is " + name);
		System.out.println("The number is " + (double)num); //casting num to a double. 
		System.out.println("line is " + line);

	}

}
