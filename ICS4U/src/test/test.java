package test;

class test {
	static int count = 0; // Shared among all instances

	public test() {
		count++; // Increment count for each new object
	}

	public static void main(String[] args) {
//        test obj1 = new test();
//        test obj2 = new test();
//        test obj3 = new test();
//        
//        System.out.println("Total objects created: " + test.count);
		int up = 100;
		int down = 9;
		down = 0;
//    	try {
//    		System.out.println("Up/down = " + up/down);	
//    	}catch(Exception e) {
//    		System.out.println("trap general exception");
//    	}
		try {
			testme(up, down);
		} catch (ArithmeticException e) {
			System.out.println("trap general exception");
		}

	}

	public static void testme(int up, int down) throws ArithmeticException {
		System.out.println("simulate throw new ArithmeticException");
		throw new ArithmeticException();
	}
}
