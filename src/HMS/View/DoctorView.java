package HMS.View;

import java.time.LocalDate;
import java.util.Scanner;

public class DoctorView {
	private Scanner sc = new Scanner (System.in);

	public int showMenu() {
		System.out.println("Enter 1 for add doctor");
		System.out.println("Enter 2 for update doctor");
		System.out.println("Enter 3 for delete doctor");
		System.out.println("Enter 4 for read all");
		System.out.println("Enter 5 for Exit.....");
		return sc.nextInt();
		
	}
	public int getDoctorId() {
		System.out.println("Enter doctor id : ");
		return sc.nextInt();
	}
	public String getDotcorFirstName() {
		sc.nextLine();
		System.out.println("Enter doctor First Name : ");
		return sc.nextLine();
	}
	public String getDoctorLastName() {
		System.out.println("Enter doctor Last Name : ");
		return sc.nextLine();
	}
	public String getDoctorPhone() {
		System.out.println("Enter doctor Phone : ");
		return sc.nextLine();
	}
	public String getDoctorEmail() {
		System.out.println("Enter doctor Email : ");
		return sc.nextLine();
	}
	public String getDoctorSpecialization() {
		System.out.println("Enter doctor Specialization : ");
		return sc.nextLine();
	}
	public LocalDate getDoctorHireDate() {
		System.out.println("Enter Date : ");
		int dt = sc.nextInt();
		System.out.println("Enter Month Number :");
		int month = sc.nextInt();
		System.out.println("Enter year :");
		int year = sc.nextInt();
		return LocalDate.of(year, month, dt);
	}
	public int getDepartmentId() {
		System.out.println("Enter Department Id");
		return sc.nextInt();
	}
	
	
}
