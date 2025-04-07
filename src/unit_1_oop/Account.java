package unit_1_oop;
/**
 * bank account practice
 * @author 14eri
 * @version April 3 2025
 */
public class Account {

	// Encapsulated data members
	private double balance;
	private int accountNum;
	public static int accountsCreated = 0;
	
	/**
	 * Contructor method
	 * @param accountNum accountNum stores the accountNumber input as a data member
	 */
	public Account(int accountNum) {
		this.accountNum = accountNum;
		accountsCreated++;
	}
	
	/**
	 * This function places "amount" of money in the current users bank account
	 * @param amount amount represents how much the user wants to deposit
	 */
	public void deposit(double amount) {
		//Ensure no negative deposits
		if (amount < 0) {
			System.out.println("No negative deposits");
			return;
		}
		this.balance += amount;
	}
	
	/**
	 * This function withdraws "amount" of money from the current users bank account.
	 * @param amount amount represents how much the user wants to withdraw
	 */
	public void withdraw(double amount) {
		//Ensure no negative draws
		if (amount < 0) {
			System.out.println("No negative withdrawals");
			return;
		}
		//Ensure no overdraws
		if (this.balance - amount >= 0) {
			this.balance -= amount;
		}
	}
	
	/**
	 * returns the current user's balance
	 * @return returns the current user's balance
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * returns the current user's account number
	 * @return returns the current user's account number
	 */
	public int getAccountNum() {
		return this.accountNum;
	}

}
