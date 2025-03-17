package unit_1_oop;

/**
 * method lesson
 * @author Eric Feng
 * @version Feb 6 2025
 */
public class MethodLesson {

	/**
	 * Calculates the HST amount on an item
	 * @param price - The original price of the item
	 * @return - Only the tax based on HST
	 */
	public static double calcTax(double price) {
		return price*0.13;
	}

	/**
	 * Draws a happy face from the 1980s
	 */
	public static void drawHappyFace() {
		System.out.println(":)");
	}
	
	public static void main(String[] args) { //This is a method (main method)
		System.out.println("Hello World!");
		drawHappyFace();
		drawSadFace();
		double price = 1.00;
		System.out.println(calcTax(100));
	}
	
	public static void drawSadFace() {
		System.out.println(":(");
	}

}
