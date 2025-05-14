package unit_3_recurSort.sorting;
import java.util.*;
import java.io.*;

/**
 * Application class for Sorting and Records assignment
 * @author Eric Feng
 * @version May 12 2025
 */
public class BranchApplication {
	
	/**
	 * swaps two bank accounts
	 * @param a1 a1 is account #1
	 * @param a2 a2 is account #2
	 */
	public static void swap(Account[] accounts, int i, int j) {
		Account tmp = accounts[i];
		accounts[i] = accounts[j];
		accounts[j] = tmp;
	}
	
	/**
	 * Sorts an array of account objects by name using selection sort algorithm
	 * @param accounts accounts is the array of account objects
	 */
	private static void selectionSort(Account[] accounts) {
		
		//Loop through the entire array
		for (int i = 0; i < accounts.length-1; i++) {
			//Pass "i" to find the min element through the rest of the array
			for (int j = i + 1; j < accounts.length; j++) {
				if (accounts[j].getName().compareTo(accounts[i].getName()) < 0) {
					swap(accounts, i, j);
				}
			}
		}

	}
	
	/**
	 * Sorts an array of account objects by account number (ID) using insertion sort algorithm
	 * @param accounts accounts is the array of account objects
	 */
	private static void insertionSort(Account[] accounts) {
		//Loop through all array elements
		for (int i = 1; i < accounts.length; i++) {
			Account currentAccount = accounts[i];
			int j = i;
			//Continue shifting elements until the desired position is found -> this could be optimized with binary search
			for (; j > 0 && currentAccount.getAccountNum() < accounts[j-1].getAccountNum(); j--) {
				accounts[j] = accounts[j-1];
			}
			accounts[j] = currentAccount;
		}
	}
	
	/**
	 * Sorts an array of account objects by account balance using bubble sort algorithm
	 * @param accounts accounts is the array of account objects
	 */
	private static void bubbleSort(Account[] accounts) {
		//Loop through the whole array
		for (int i = 0; i < accounts.length; i++) {
			boolean swapped = false; //check if we perform any swaps
			for (int j = 0; j < accounts.length - 1; j++) {
				//If the left element is greater than the right element, swap them
				if (accounts[j].getBalance() > accounts[j+1].getBalance()) {
					swap(accounts, j, j+1);
					swapped = true;
				}
			}
			//If we don't perform any swaps, the array is already sorted
			if (! swapped) {
				break;
			}
		}
	}
	
	/**
	 * prints all the elements in array assuming an overriden toString() method
	 * @param accounts accounts is the array of bank accounts
	 */
	private static Account searchArray(Account[] accounts, int accountNum) {
		for (Account a : accounts) {
			if (a.getAccountNum() == accountNum) {
				return a;
			}
		}
		return null;
	}
	
	/**
	 * prints out information about each account in the accounts array
	 * @param accounts accounts is the array holding the bank accounts
	 */
	public static void printArr(Account[] accounts) {
		for (Account a : accounts) {
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		final int SIZE = 14;
		Account[] accounts = new Account[SIZE];
		
		try {
			Scanner input = new Scanner(new File("accounts.txt"));
			for (int i = 0; input.hasNext(); i++) {
				accounts[i] = new Account(input);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the WOSS Bank!\n");
		while (true) {
			System.out.println("What would you like to do?");
			System.out.println("1. Access account");
			System.out.println("    1. View Balance");
			System.out.println("    2. Deposit");
			System.out.println("    3. Withdraw");
			System.out.println("2. Sort by amount using Bubble Sort");
			System.out.println("3. Sort by ID using Insertion Sort");
			System.out.println("4. Sort by names using Selection Sort");
			System.out.println("5. Exit\n");
			System.out.print("Enter selection: ");
			int n = input.nextInt();
			if (n == 1) {
				System.out.print("Which option do you choose? ");
				int option = input.nextInt();
				System.out.print("Enter the account number: ");
				int accountNum = input.nextInt(); double amount;
				Account thisAccount = searchArray(accounts, accountNum);
				if (thisAccount == null) {
				    System.out.println("Account not found.");
				    continue;
				}
				if (option == 1) { //view balance
					System.out.println(thisAccount.getBalance());
				} else if (option == 2) { //deposit
					System.out.print("How much would you like to deposit?" );
					amount = input.nextDouble();
					thisAccount.deposit(amount);
				} else if (option == 3) { //withdraw
					System.out.println("How much would you like to withdraw? ");
					amount = input.nextDouble();
					thisAccount.withdraw(amount);
				}
			} else if (n == 2) { //bubble sort
				bubbleSort(accounts);
				printArr(accounts);
			} else if (n == 3) { //insertion sort
				insertionSort(accounts);
				printArr(accounts);
			} else if (n == 4) { //selection sort
				selectionSort(accounts);
				printArr(accounts);
			} else if (n == 5) { 
				break;
			} else {
				System.out.println("Invalid input!");
			}
		}
	}
}
