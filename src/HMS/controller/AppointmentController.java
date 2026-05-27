package HMS.controller;

import java.time.LocalDateTime;
import java.util.List;

import HMS.Entity.appointments;
import HMS.View.AppointmentView;
import HMS.dao.AppointmentDAO;

public class AppointmentController {

	private AppointmentDAO dao;
	private AppointmentView view;

	public AppointmentController(AppointmentDAO dao, AppointmentView view) {

		this.dao = dao;
		this.view = view;
	}

	public void run() {

		while (true) {

			int choice = view.showMenu();

			switch (choice) {

			// ADD
			case 1: {

				int patientId = view.getPatientId();

				int doctorId = view.getDoctorId();

				LocalDateTime date = view.getAppointmentDate();

				String status = view.getStatus();

				String reason = view.getReason();

				appointments a = new appointments(patientId, doctorId, date, status, reason);

                 boolean check = dao.addAppointment(a);
				if (check) {

					System.out.println("Appointment Added Successfully");
				}

				else {

					System.out.println("Appointment Not Added");
				}

				break;
			}

			// UPDATE
			case 2: {

				int appointmentId = view.getAppointmentId();

				int patientId = view.getPatientId();

				int doctorId = view.getDoctorId();

				LocalDateTime date = view.getAppointmentDate();

				String status = view.getStatus();

				String reason = view.getReason();

				appointments a = new appointments(patientId, doctorId, date, status, reason);

				a.setAppointmentId(appointmentId);

				boolean check = dao.updateAppointment(a);

				if (check) {

					System.out.println("Appointment Updated Successfully");
				}

				else {

					System.out.println("Appointment Not Updated");
				}

				break;
			}

			// DELETE
			case 3: {

				int id = view.getAppointmentId();

				boolean check = dao.deleteAppointment(id);

				if (check) {

					System.out.println("Appointment Deleted Successfully");
				}

				else {

					System.out.println("Appointment Not Deleted");
				}

				break;
			}

			// READ ALL
			case 4: {

				List<appointments> list = dao.readAll();

				for (appointments a : list) {

					System.out.println(a);
				}

				break;
			}

			// EXIT
			case 5: {

				System.out.println("Thank You");
				return ;
			}

			default:

				System.out.println("Invalid Choice");
			}
		}
	}
}