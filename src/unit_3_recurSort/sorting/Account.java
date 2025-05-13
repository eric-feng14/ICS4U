package unit_3_recurSort.sorting;
import java.util.*;

/**
 * Template class for creating a bank account
 * @author Eric Feng
 * @version May 12 2025
 */
public class Account {
	private double balance;
	private String name;
	private int accountNum;
	
	/**
	 * Default constructor
	 * @param acctNum acctNum is the account Number of the current account
	 * @param clientName clientName is the name of who owns the current account
	 * @param initialBal initialBal is the amount of money the user has when they create their account
	 */
	public Account(int acctNum, String clientName, double initialBal) {
		this.accountNum = acctNum;
		this.name = clientName;
		this.balance = initialBal;
	}
	
	/**
	 * overloaded constructor
	 * @param fileInput fileInput is a scanner that input is read from
	 */
	public Account(Scanner fileInput) {
		this.accountNum = fileInput.nextInt();
		this.balance = fileInput.nextDouble();
		this.name = fileInput.next() + " " + fileInput.next(); //first name and last name 
	}
	
	/**
	 * Allows a user to deposit a specific amount to their bank balance
	 * @param amount amount is how much they want to deposit
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	/**
	 * Allows a user to withdraw a specific amount from their bank balance
	 * @param amount amount is how much they want to withdraw
	 */
	public void withdraw(double amount) {
		this.balance -= amount;
	}
	
	/**
	 * accessor method that returns the balance of the current account
	 * @return returns the current account's balance
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * accessor method that returns the name of the current account
	 * @return returns the current account's name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * accessor method that returns the current account number
	 * @return returns the current account number
	 */
	public int getAccountNum() {
		return this.accountNum;
	}
	
	/**
	 * Overridden method inherited from superclass "Object"
	 */
	public String toString() {
		return "Balance: " + this.balance + ", Name: " + this.name + ", accountNum: " + this.accountNum;
	}
}
