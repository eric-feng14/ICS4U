package unit_1_oop;
import java.util.*;

/**
 * prints out 3 different images based on a random number
 * @author Eric Feng
 * @version Feb 7 2025
 */
public class A1E1 {

	/**
	 * draws the third pic
	 */
	public static void drawTrain() {
        System.out.println("     _____        _____        _____        _____        _____    ");
        System.out.println("    |     |      |     |      |     |      |     |      |     |   ");
        System.out.println(" ___|_____|______|_____|______|_____|______|_____|______|_____|___");
        System.out.println(" |  _    _   ||  _    _   ||  _    _   ||  _    _   ||  _    _   |");
        System.out.println(" | |_|  |_|  || |_|  |_|  || |_|  |_|  || |_|  |_|  || |_|  |_|  |");
        System.out.println(" |___________||___________||___________||___________||___________|");
        System.out.println("   O     O      O     O      O     O      O     O      O     O     ");
	}
	
	/**
	 * draws the second pic
	 */
	public static void drawTree() {
		System.out.println("                 ^");
        System.out.println("                ^^^");
        System.out.println("               ^^^^^");
        System.out.println("              ^^^^^^^");
        System.out.println("             ^^^^^^^^^");
        System.out.println("            ^^^^^^^^^^^");
        System.out.println("           ^^^^^^^^^^^^^");
        System.out.println("          ^^^^^^^^^^^^^^^");
        System.out.println("         ^^^^^^^^^^^^^^^^^");
        System.out.println("        ^^^^^^^^^^^^^^^^^^^");
        System.out.println("       ^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("      ^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("     ^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("    ^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("           |||||||||||||||");
        System.out.println("           |||||||||||||||");
        System.out.println("           |||||||||||||||");
        System.out.println("           |||||||||||||||");
        System.out.println("           |||||||||||||||");
        System.out.println("           |||||||||||||||");
        System.out.println("           |||||||||||||||");
	}
	
	/**
	 * draws the first pic
	 */
	public static void drawCar() {
        System.out.println("           _______");
        System.out.println("          /       \\");
        System.out.println("   ______/         \\______");
        System.out.println("  /                      |");
        System.out.println(" |   ____       ____     |");
        System.out.println(" |  |    |     |    |    |");
        System.out.println(" |  |____|     |____|    |");
        System.out.println(" |                      |");
        System.out.println("  \\_____________________/ ");
        System.out.println("        O             O");
	}
	
	/**
	 * @return prints out selected drawing
	 */
	public static void main(String[] args) {
		int choice;
		Random generator = new Random();
		choice = generator.nextInt(3) + 1;
		
		// condition block to generate choices
		if (choice == 1) {
			drawTrain();
		} else if (choice == 2) {
			drawTree();
		} else {
			drawCar();
		}

	}

}
