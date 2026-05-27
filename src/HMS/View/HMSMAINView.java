package HMS.View;

import java.util.Scanner;

public class HMSMAINView {
	private Scanner sc = new Scanner (System.in);

	public int showMenu() {
		System.out.println("Enter 1 for Department");
		System.out.println("Enter 2 for  Doctor");
		System.out.println("Enter 3 for Patient");
		System.out.println("Enter 4 for Appointment");
		System.out.println("Enter 5 for Bill");
		System.out.println("Enter 6 for Exit....");

		return sc.nextInt();
		
	}

}
