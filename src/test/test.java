package test;
import java.util.*;
import java.io.*;
public class test {
	public static void main(String[] args) {
		
		try {
			Scanner input = new Scanner(new File("accounts.txt"));
			for (int i = 0; i < 3; i++) {
				int a; double b; String fName, lName;
				a = input.nextInt(); b = input.nextDouble();
				fName = input.next(); lName = input.next();
				System.out.print(a + " " + b + " " + fName+" "+lName+"\n");
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
	}
}