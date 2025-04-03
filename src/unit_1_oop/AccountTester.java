package unit_1_oop;

/**
 * tests the account template class
 * @author Eric Feng
 * @version April 3 2025
 */
public class AccountTester {

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
		EricFeng.withdraw(-9999);
		balance = EricFeng.getBalance();
		accountNum = EricFeng.getAccountNum();
		System.out.println(balance);
		System.out.println(accountNum);
		
		
//		//Testing static variables
//		System.out.println(Account.accountsCreated);
//		Account newAcc = new Account(2345);
//		System.out.println(Account.accountsCreated);
//		
//		//Objects also have access to static variables
//		System.out.println(newAcc.accountsCreated);

	}

}
