package HMS.controller;

import java.time.LocalDate;
import java.util.List;

import HMS.Entity.patients;
import HMS.View.PatientView;
import HMS.dao.PatientDAO;

public class PatientController {

	private PatientDAO dao;
	private PatientView view;

	public PatientController(PatientDAO dao, PatientView view) {

		this.dao = dao;
		this.view = view;
	}

	public void run() {

		while (true) {

			int choice = view.showMenu();

			switch (choice) {

			// ADD
			case 1: {

				String firstName = view.getPatientFirstName();

				String lastName = view.getPatientLastName();

				String gender = view.getPatientGender();

				LocalDate dob = view.getPatientDateOfBirth();

				String phone = view.getPatientPhone();
				System.out.println(phone);
				String email = view.getPatientEmail();

				String address = view.getPatientAddress();

				String bloodGroup = view.getPatientBloodGroup();
				LocalDate regdate = view.getregistrationDate();


				patients p = new patients(firstName, lastName, gender, dob, phone, email, address, bloodGroup,regdate);
				System.out.println(p);
				boolean check = dao.addPatient(p);

				if (check) {

					System.out.println("Patient Added Successfully");
				}

				else {

					System.out.println("Patient Not Added");
				}

				break;
			}

			// UPDATE
			case 2: {

				int patientId = view.getPatientId();

//				String firstName = view.getPatientFirstName();
//
//				String lastName = view.getPatientLastName();
//
//				String gender = view.getPatientGender();
//
//				LocalDate dob = view.getPatientDateOfBirth();
//
//				String phone = view.getPatientPhone();
//
//				String email = view.getPatientEmail();
//
//				String address = view.getPatientAddress();
//
//				String bloodGroup = view.getPatientBloodGroup();
				LocalDate regdate = view.getregistrationDate();

				patients p = new patients(patientId,regdate);
				
				//firstName, lastName, gender, dob, phone, email, address, bloodGroup,

				p.setPatientId(patientId);
				p.setRegistrationDate(regdate);

				boolean check = dao.updatePatient(p);

				if (check) {

					System.out.println("Patient Updated Successfully");
				}

				else {

					System.out.println("Patient Not Updated");
				}

				break;
			}

			// DELETE
			case 3: {

				int id = view.getPatientId();

				boolean check = dao.deletePatient(id);

				if (check) {

					System.out.println("Patient Deleted Successfully");
				}

				else {

					System.out.println("Patient Not Deleted");
				}

				break;
			}

			// READ ALL
			case 4: {

				List<patients> list = dao.readAll();

				for (patients p : list) {

					System.out.println(p);
				}

				break;
			}

			// EXIT
			case 5:System.out.println("exit...");
			return ;

			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}