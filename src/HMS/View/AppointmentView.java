package HMS.View;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AppointmentView {
	
	private Scanner sc = new Scanner (System.in);

	public int showMenu() {
		System.out.println("Enter 1 for add Appointment : ");
		System.out.println("Enter 2 for update Appointment : ");
		System.out.println("Enter 3 for delete Appointment : ");
		System.out.println("Enter 4 for read all");
		System.out.println("Enter 5 for Exit.....");
		return sc.nextInt();
		
	}
	
	public int getAppointmentId() {

        System.out.println("Enter Appointment Id : ");
        return sc.nextInt();
    }

    public int getPatientId() {

        System.out.println("Enter Patient Id : ");
        return sc.nextInt();
    }

    public int getDoctorId() {

        System.out.println("Enter Doctor Id : ");
        return sc.nextInt();
    }

    public LocalDateTime getAppointmentDate() {

        System.out.println("Enter Date : ");
        int dt = sc.nextInt();

        System.out.println("Enter Month : ");
        int month = sc.nextInt();

        System.out.println("Enter Year : ");
        int year = sc.nextInt();

        System.out.println("Enter Hour : ");
        int hour = sc.nextInt();

        System.out.println("Enter Minute : ");
        int minute = sc.nextInt();

        return LocalDateTime.of(year, month, dt, hour, minute);
    }

    public String getStatus() {

        sc.nextLine();

        System.out.println("Enter Status : ");
        return sc.nextLine();
    }

    public String getReason() {
    	sc.nextLine();

        System.out.println("Enter Reason : ");
        return sc.nextLine();
    }
}







