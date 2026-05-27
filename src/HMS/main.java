package HMS;

import HMS.View.AppointmentView;
import HMS.View.BillView;
import HMS.View.DepartmentView;
import HMS.View.DoctorView;
import HMS.View.PatientView;
import HMS.controller.AppointmentController;
import HMS.controller.BillController;
import HMS.controller.DepartmentController;
import HMS.controller.DoctorController;
import HMS.controller.PatientController;

import HMS.dao.AppointmentDAO;
import HMS.dao.BillDAO;
import HMS.dao.DepartmentDAO;
import HMS.dao.DoctorDAO;
import HMS.dao.PatientDAO;

import java.util.Scanner;

public class main {                // registration value null nd phone me primary key ki dikkat aa rhi 

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");

			System.out.println("1. Department");
			System.out.println("2. Doctor");
			System.out.println("3. Patient");
			System.out.println("4. Appointment");
			System.out.println("5. Bill");
			System.out.println("6. Exit");

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

				AppointmentController controller = new AppointmentController(dao, view);

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