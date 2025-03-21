package test;
import java.io.*;
import java.util.*;


public class Test {

	public void lol() {
		System.out.println("public static method");
	}
	
	private static void test() {
		System.out.println("private static method");
		
	}
	
	public static void main(String[] args) {
		System.out.println("main method");
		lol();
	}
}
