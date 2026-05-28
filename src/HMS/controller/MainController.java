package HMS.controller;

import java.util.Scanner;

import HMS.View.AppointmentView;
import HMS.View.BillView;
import HMS.View.DepartmentView;
import HMS.View.DoctorView;
import HMS.View.PatientView;
import HMS.dao.AppointmentDAO;
import HMS.dao.BillDAO;
import HMS.dao.DepartmentDAO;
import HMS.dao.DoctorDAO;
import HMS.dao.PatientDAO;

public class MainController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");

			System.out.println("Enter 1 for Department");
			System.out.println("Enter 2 for Doctor");
			System.out.println("Enter 3 for Patient");
			System.out.println("Enter 4 for Appointment");
			System.out.println("Enter 5 for Bill");
			System.out.println("Enter 6 for Exit");

			System.out.print("Enter Choice : ");

			int choice = sc.nextInt();

			switch (choice) {

			// DEPARTMENT
			case 1: {

				DepartmentDAO dao = new DepartmentDAO();

				DepartmentView view = new DepartmentView();

				DepartmentController controller = new DepartmentController(dao, view);

				controller.run();

				break;
			}

			// DOCTOR
			case 2: {

				DoctorDAO dao = new DoctorDAO();

				DoctorView view = new DoctorView();

				DoctorController controller = new DoctorController(dao, view);

				controller.run();

				break;
			}

			// PATIENT
			case 3: {

				PatientDAO dao = new PatientDAO();

				PatientView view = new PatientView();

				PatientController controller = new PatientController(dao, view);

				controller.run();

				break;
			}

			// APPOINTMENT
			case 4: {

				AppointmentDAO dao = new AppointmentDAO();

				AppointmentView view = new AppointmentView();

				AppointmentController controller = new AppointmentController(dao,view);
				controller.run();

				break;
			
			}

			// BILL
			case 5: {

				BillDAO dao = new BillDAO();

				BillView view = new BillView();

				BillController controller = new BillController(dao, view);

				controller.run();

				break;
			}

			// EXIT
			case 6: {

				System.out.println("Thank You");

				System.exit(0);
			}

			default:

				System.out.println("Invalid Choice");
			}
		}
	}
}