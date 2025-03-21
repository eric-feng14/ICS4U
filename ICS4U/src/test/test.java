package test;
class test {
    static int count = 0; // Shared among all instances

    public test() {
        count++; // Increment count for each new object
    }

    public static void main(String[] args) {
        test obj1 = new test();
        test obj2 = new test();
        test obj3 = new test();
        
        System.out.println("Total objects created: " + test.count);
    }
}
