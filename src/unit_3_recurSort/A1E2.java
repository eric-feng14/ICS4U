package unit_3_recurSort;

public class A1E2 {

	/**
	 * recursive fibonacci function
	 * @param n n represents the nth fibonacci number
	 * @return an integer representing the result of the nth fibonacci number
	 */
	public static int fib(int n) {
		//Base case
		if (n <= 1) {
			return n;
		}
		//Recursive case
		return fib(n-1) + fib(n-2);
	}
	
	public static void main(String[] args) {
		final int COUNT = 10;
		for (int i = 1; i <= COUNT; i++) {
			System.out.println("Fibonacci number " + i + " = " + fib(i));
		}
	}

}
