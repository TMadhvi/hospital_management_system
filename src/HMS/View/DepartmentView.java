package HMS.View;

import java.util.Scanner;

public class DepartmentView {

	private Scanner sc = new Scanner (System.in);

	public int showMenu() {
		System.out.println("Enter 1 for add Department");
		System.out.println("Enter 2 for update Department");
		System.out.println("Enter 3 for delete Department");
		System.out.println("Enter 4 for read all");
		System.out.println("Enter 5 for Exit.....");
		return sc.nextInt();
		
	}                    
   
	public int getdepartmentId() {
		System.out.println("Enter Department Id");
		return sc.nextInt();
	}
	
	public String getdepartmentName() {
		sc.nextLine();
		System.out.println("Enter Department Name");
		return sc.nextLine();
	}
	
	public String getdepartmentLocation() {
		System.out.println("Enter Department Location");
		return sc.nextLine();
	}
}







