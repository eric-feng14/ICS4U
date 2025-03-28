package unit_1_oop;

public class Account {

	// Encapsulated data members
	private double balance;
	private int accountNum;
	public static int accountsCreated = 0;
	
	/**
	 * Contructor method
	 * @param accountNum -> stores the accountNumber input as a data member
	 */
	public Account(int accountNum) {
		this.accountNum = accountNum;
		accountsCreated++;
	}
	
	public static void test() {
		System.out.println("do nothing");
	}
	
	/**
	 * This function places "amount" of money in the current users bank account
	 * @param amount -> how much to deposit
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	/**
	 * This function withdraws "amount" of money from the current users bank account.
	 * @param amount -> how much to withdraw
	 */
	public void withdraw(double amount) {
		//Ensure no overdraws
		if (this.balance - amount >= 0) {
			this.balance -= amount;
		}
	}
	
	/**
	 * @return the current user's balance
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * @return the current user's account number
	 */
	public int getAccountNum() {
		return this.accountNum;
	}
	
	public static void main(String[] args) {
		double balance; int accountNum;
		
		//Normal Case
		Account EricFeng = new Account(1234);
		EricFeng.deposit(100);
		EricFeng.withdraw(50);
		balance = EricFeng.getBalance();
		accountNum = EricFeng.getAccountNum();
		System.out.println(balance);
		System.out.println(accountNum);
		
		//Overdraw
		EricFeng.withdraw(9999);
		balance = EricFeng.getBalance();
		accountNum = EricFeng.getAccountNum();
		System.out.println(balance);
		System.out.println(accountNum);
		
		System.out.println("\n\n\n");
		
		//Testing static variables
		System.out.println(Account.accountsCreated);
		Account newAcc = new Account(2345);
		System.out.println(Account.accountsCreated);
		
		//Objects also have access to static variables
		System.out.println(newAcc.accountsCreated);
		
		//Testing static methods
		newAcc.test();
		Account.test();
	}

}
