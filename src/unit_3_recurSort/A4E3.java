package unit_3_recurSort;

public class A4E3 {

	/**
	 * recursive function that represents the nth number
	 * @param n the nth number to be multiplied
	 * @return returns n-1! * n
	 */
	public static int factorial(int n) {
		//Base case
		if (n == 1) {
			return 1;
		}
		//Recursive case
		return factorial(n-1) * n;
	}
	
	public static void main(String[] args) {
		int n = 5;
		String result = n + "! = ";
		for (int i = n; i > 0; i--) {
			result += i + " X ";
		}
		result += "= " + factorial(n);
		System.out.println(result);
	}

}
