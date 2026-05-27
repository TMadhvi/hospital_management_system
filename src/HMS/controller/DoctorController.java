package HMS.controller;

import java.time.LocalDate;
import java.util.List;

import HMS.Entity.doctors;
import HMS.View.DoctorView;
import HMS.dao.DoctorDAO;

public class DoctorController {

    private DoctorDAO dao;
    private DoctorView view;

    public DoctorController(
            DoctorDAO dao,
            DoctorView view) {

        this.dao = dao;
        this.view = view;
    }

    public void run() {

        while (true) {

            int choice = view.showMenu();

            switch (choice) {

            // ADD
            case 1: {

                String firstName =
                        view.getDotcorFirstName();

                String lastName =
                        view.getDoctorLastName();

                String specialization =
                        view.getDoctorSpecialization();

                String phone =
                        view.getDoctorPhone();

                String email =
                        view.getDoctorEmail();

                LocalDate hireDate =
                        view.getDoctorHireDate();

                int departmentId =
                        view.getDepartmentId();

                doctors d = new doctors(
                        firstName,
                        lastName,
                        specialization,
                        phone,
                        email,
                        hireDate,
                        departmentId
                );

                boolean check =
                        dao.adddoctors(d);

                if (check) {

                    System.out.println(
                            "Doctor Added Successfully");
                }

                else {

                    System.out.println(
                            "Doctor Not Added");
                }

                break;
            }

            // UPDATE
            case 2: {

                int doctorId =
                        view.getDoctorId();

                String firstName =
                        view.getDotcorFirstName();

                String lastName =
                        view.getDoctorLastName();

                String specialization =
                        view.getDoctorSpecialization();

                String phone =
                        view.getDoctorPhone();

                String email =
                        view.getDoctorEmail();

                LocalDate hireDate =
                        view.getDoctorHireDate();

                int departmentId =
                        view.getDepartmentId();

                doctors d = new doctors(
                        firstName,
                        lastName,
                        specialization,
                        phone,
                        email,
                        hireDate,
                        departmentId
                );

                d.setDoctorId(doctorId);

                boolean check =
                        dao.updatedoctors(d);

                if (check) {

                    System.out.println(
                            "Doctor Updated Successfully");
                }

                else {

                    System.out.println(
                            "Doctor Not Updated");
                }

                break;
            }

            // DELETE
            case 3: {

                int id =
                        view.getDoctorId();

                boolean check =
                        dao.deletedoctors(id);

                if (check) {

                    System.out.println(
                            "Doctor Deleted Successfully");
                }

                else {

                    System.out.println(
                            "Doctor Not Deleted");
                }

                break;
            }

            // READ ALL
            case 4: {

                List<doctors> list =
                        dao.readAll();

                for (doctors d : list) {

                    System.out.println(d);
                }

                break;
            }

            // EXIT
            case 5:
            	return ;

            default:

                System.out.println(
                        "Invalid Choice");
            }
        }
    }
}