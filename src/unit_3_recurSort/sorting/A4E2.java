package unit_3_recurSort.sorting;

/**
 * exercise 2 for the sorting exercises
 * @author Eric Feng
 * @version May 12 2025
 */
public class A4E2 {
	
	/**
	 * uses insertion sort to sort the integer marks from an array
	 * @param nums nums is the array storing the student's marks
	 */
	public static void sort(int[] nums) {
		//Loop through all array elements
		for (int i = 1; i < nums.length; i++) {
			int val = nums[i], j = i;
			//Continue shifting elements until the desired position is found -> this could be optimized with binary search
			for (; j > 0 && val < nums[j-1]; j--) {
				nums[j] = nums[j-1];
			}
			nums[j] = val;
		}
	}

	/**
	 * returns the median of a list of student marks
	 * 
	 */
	public static double median(int[] marks) {
		int n = marks.length;
		sort(marks);
		if (marks.length % 2 == 1) {
			return marks[n / 2];
		} else {
			return (marks[(n / 2) - 1] + marks[n / 2]) / 2.0;
		}
	}
	
	public static void main(String[] args) {
		int[] marks = {6,3,1,4,7,3};
		sort(marks);
		for (int e : marks) System.out.println(e);
		System.out.println(median(marks));
	}

}
