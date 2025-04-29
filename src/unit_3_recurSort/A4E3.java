package unit_3_recurSort;

public class A4E3 {

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return factorial(n-1) * n;
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(3));
	}

}
