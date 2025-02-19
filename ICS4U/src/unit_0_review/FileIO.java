package unit_0_review;
import java.util.*;
import java.io.*;

public class FileIO {

	public static void main(String[] args) {
		try {
			Scanner fileInput = new Scanner(new File("info.txt"));
			while (fileInput.hasNext()) {
				int val = fileInput.nextInt();
				System.out.println(val);
			}
		}
		catch (FileNotFoundException ex) {
			System.out.println("oops, can't find the file");
		}
		System.out.println("still running");
	}

}
