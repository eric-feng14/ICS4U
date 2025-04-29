package unit_3_recurSort;

public class RecurLesson {

	/**
	 * recursive triangle function
	 * @param num num of circles
	 * @return result of previous triangle + new circles
	 */
	public static int triangle(int num) {
		if (num == 1) {
			return 1;
		}
		return triangle(num-1) + num;
	}

	public static void main(String[] args) {
		System.out.println(triangle(10));
	}

}
