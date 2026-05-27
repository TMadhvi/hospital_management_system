package HMS.View;

import java.time.LocalDate;
import java.util.Scanner;

public class PatientView {
	private Scanner sc = new Scanner (System.in);

	public int showMenu() {
		System.out.println("Enter 1 for add Patient");
		System.out.println("Enter 2 for update Patient");
		System.out.println("Enter 3 for delete Patient");
		System.out.println("Enter 4 for read all");
		System.out.println("Enter 5 for Exit.....");
		return sc.nextInt();
		
	}
	public int getPatientId() {
		System.out.println("Enter Patient id : ");
		return sc.nextInt();
	}
	public String getPatientFirstName() {
		sc.nextLine();
		System.out.println("Enter Patient First Name : ");
		return sc.nextLine();
	}
	public String getPatientLastName() {
		System.out.println("Enter patient Last Name : ");
		return sc.nextLine();
	}
	public String getPatientGender() {
		System.out.println("Enter Patient Gender : ");
		return sc.nextLine();
	}
	
	public LocalDate getPatientDateOfBirth() {
		System.out.println("Enter dob Date : ");
		int dt = sc.nextInt();
		System.out.println("Enter Month Number :");
		int month = sc.nextInt();
		System.out.println("Enter year :");
		int year = sc.nextInt();
		return LocalDate.of(year, month, dt);
	}
	public String getPatientPhone() {
		sc.nextLine();
		System.out.println("Enter Patient Phone : ");
		return sc.nextLine();
		
	}
	public String getPatientEmail() {
		sc.nextLine();
		System.out.println("Enter Patient Email : ");
		return sc.nextLine();
	}
	public String getPatientBloodGroup() {
		sc.nextLine();
		System.out.println("Enter Patient Blood Group : ");
		return sc.nextLine();
	}
	public String getPatientAddress() {
		System.out.println("Enter Patient Address : ");
		return sc.nextLine();
	}
	public LocalDate getregistrationDate() {
		System.out.println("Enter  registrationDate : ");
		int dt = sc.nextInt();
		System.out.println("Enter Month Number :");
		int month = sc.nextInt();
		System.out.println("Enter year :");
		int year = sc.nextInt();
		return LocalDate.of(year, month, dt);
	}

}
