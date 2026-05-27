package HMS.View;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BillView {

    private Scanner sc = new Scanner(System.in);

    // MENU
    public int showMenu() {

        System.out.println("Enter 1 for add bill");
        System.out.println("Enter 2 for update bill");
        System.out.println("Enter 3 for delete bill");
        System.out.println("Enter 4 for read all bills");
        System.out.println("Enter 5 for Exit");

        return sc.nextInt();
    }

    // BILL ID
    public int getBillId() {

        System.out.println("Enter Bill Id : ");
        return sc.nextInt();
    }

    // PATIENT ID
    public int getPatientId() {

        System.out.println("Enter Patient Id : ");
        return sc.nextInt();
    }

    // APPOINTMENT ID
    public int getAppointmentId() {

        System.out.println("Enter Appointment Id : ");
        return sc.nextInt();
    }

    // TOTAL AMOUNT
    public double getTotalAmount() {

        System.out.println("Enter Total Amount : ");
        return sc.nextDouble();
    }

    // PAYMENT STATUS
    public String getPaymentStatus() {

        sc.nextLine();

        System.out.println("Enter Payment Status : ");
        return sc.nextLine();
    }

    // BILL DATE
    public LocalDateTime getBillDate() {

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
}