package unit_0_review;
import java.util.*;

public class Array {

	public static void main(String[] args) {
//		int[] num = {45,67,89};
//		for (int i=0; i<num.length;i++) {
//			System.out.println(num[i]);
//		}
//		double [] marks = new double[8];
//		System.out.println(marks.length);
		ArrayList <Integer> numbers = new ArrayList<Integer>();
		String name = new String("test");
		Integer num = 99;
		numbers.add(new Integer(99));
		numbers.add(23);
//		numbers.add(3.2);
//		numbers.add("sample");
		System.out.println(numbers);
		System.out.println(numbers.get(0));
		System.out.println(numbers.size());
		System.out.println(numbers.get(0) + numbers.get(1));
		numbers.remove(0);
		numbers.add(0, 100);
		System.out.println(numbers);
		
		
	}
}
