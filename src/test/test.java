package test;
import java.util.*;

public class test {
	private static int[] arr = {6,5,4,3,2,1};
	
	public static void q1() {
		String string1 = "tea";
		String string2 = "eat";
		for (int i = 0; i < string1.length(); i++) {
			boolean found = false;
			for (int j = 0; j < string2.length(); j++) {
				if (string2.charAt(j) == string1.charAt(i)) {
					found = true; 
					string2 = string2.substring(0, j) + string2.substring(j+1);
					break;
				}
			}
			if (! found) {
				System.out.println("impossible");
				System.exit(0);
			}
		}
		System.out.println("possible");	
	}
	
	public static void q2() {
		final int SIZE = 52;
		String string1 = "tea";
		String string2 = "eat";
		if (string1.length() != string2.length()) {
			System.out.println("Not equal length strings! ");
			System.exit(0);
		}
		
		//Assuming only letters from the alphabet, e.g. a-z, A-Z, the size can be adjusted as necessary
		int[] freq1 = new int[SIZE];
		int[] freq2 = new int[SIZE];
		
		for (int i = 0; i < string1.length(); i++) {
			freq1[string1.charAt(i) - 'a']++;
			freq2[string2.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < freq1.length; i++) {
			if (freq1[i] != freq2[i]) {
				System.out.println("impossible");
				System.exit(0);
			}
		}
		System.out.println("possible");
		
	}

	
	private static int binarySearch(int l, int r, int target) {
		if (l > r) return -1; //if number is not found
		int mid = (l + r) / 2;
		if (arr[mid] == target) return mid;
		if (arr[mid] > target) {
			return binarySearch(l, mid-1, target);
		}
		return binarySearch(mid+1, r, target);
	}
	
	private static void merge(int l, int m, int r) {
		int[] tmp = new int[r-l+1];
		int i = l, j = m+1, k = 0;
		while (i <= m && j <= r) {
			if (arr[i] < arr[j]) {
				tmp[k] = arr[i]; i++;
			} else {
				tmp[k] = arr[j]; j++;
			}
			k++;
		}
		while (i <= m) {
			tmp[k] = arr[i]; i++; k++;
		}
		while (j <= r) {
			tmp[k] = arr[j]; j++; k++;
		}
		//Copy the elements into the array
		for (int idx = l; idx <= r; idx++) {
			arr[idx] = tmp[idx-l];
		}
	}
	
	public static void mergeSort(int l, int r) {
		if (l >= r) return;
		int mid = (l + r) / 2;
		mergeSort(l, mid);
		mergeSort(mid+1, r);
		merge(l, mid, r);
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
	public static void bubbleSort() {
		for (int i =0; i < arr.length; i++) {
			boolean swapped = false;
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j+1] < arr[j]) {
					swap(arr, j, j+1);
					swapped = true;
				}
			}
			if (!swapped) break;
		}
		printArr(arr);
	}
	
	public static void selectionSort() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
		printArr(arr);
	}
	
	public static void insertionSort() {
		for (int i = 1; i < arr.length; i++) {
			int j = i, currentElem = arr[i];
			while (j > 0 && currentElem < arr[j-1]) {
				arr[j] = arr[j-1]; j--;
			}
			arr[j] = currentElem;
			
			//Alternative method
//			while (j > 0 && arr[j] < arr[j-1]) {
//				swap(arr, j, j-1); j--;
//			}
		}
		printArr(arr);
	}
	
	public static void main(String[] args) {
//		q1();
//		q2();
//		bubbleSort();
//		selectionSort();
//		insertionSort();
//		int idx = binarySearch(0, arr.length-1, 7);
//		System.out.println(idx);
		mergeSort(0, arr.length-1);
		printArr(arr);
	}
}