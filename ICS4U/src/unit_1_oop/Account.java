package unit_1_oop;

public class Account {

	// Encapsulated data members
	private double balance;
	private int accountNum;
	
	//Constructor method
	public Account(int accountNum) {
		this.accountNum = accountNum;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		if (this.balance - amount >= 0) {
			this.balance -= amount;
		}
	}
	
	public double getBalance() {
		return this.balance;
	}
	
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
		
	}

}
