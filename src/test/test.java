package test;

class test {
	static int count = 0; // Shared among all instances
	
	public test() {
		count++; // Increment count for each new object
	}

	public static void main(String[] args) {
		System.out.println(test.count);
		test thisObj = new test();
		test newObj = new test();
		System.out.println(test.count);
	}

	public static void testme(int up, int down) throws ArithmeticException {
		System.out.println("simulate throw new ArithmeticException");
		throw new ArithmeticException();
	}
}
