package unit_0_review;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		switch (n) {
			case 0: System.out.println("Better luck next time.");
			case 1:
			case 2:
			case 3:
			case 4:
			case 5: System.out.println("Pretty good.");
			case 6:
			case 7:break;
			case 8:
			case 9:
			case 10: System.out.println("Great!");
			default:
				System.out.println("Default statement reachjed");
				break;
		}
	}
}
