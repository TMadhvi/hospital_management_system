package HMS.controller;

import java.util.List;

import HMS.Entity.departments;
import HMS.View.DepartmentView;
import HMS.dao.DepartmentDAO;

public class DepartmentController {

    private DepartmentDAO dao;
    private DepartmentView view;

    public DepartmentController(
            DepartmentDAO dao,
            DepartmentView view) {

        this.dao = dao;
        this.view = view;
    }

    public void run() {

        while (true) {

            int choice = view.showMenu();

            switch (choice) {

            // ADD
            case 1: {

                String name =
                        view.getdepartmentName();

                String location =
                        view.getdepartmentLocation();

                departments d =
                        new departments(name, location);

                boolean check =
                        dao.addDepartment(d);

                if (check) {

                    System.out.println(
                            "Department Added Successfully");
                }

                else {

                    System.out.println(
                            "Department Not Added");
                }

                break;
            }

            // UPDATE
            case 2: {

                int id =
                        view.getdepartmentId();

                String name =
                        view.getdepartmentName();

                String location =
                        view.getdepartmentLocation();

                departments d =
                        new departments(id, name, location);

                boolean check =
                        dao.updateDepartment(d);

                if (check) {

                    System.out.println(
                            "Department Updated Successfully");
                }

                else {

                    System.out.println(
                            "Department Not Updated");
                }

                break;
            }

            // DELETE
            case 3: {

                int id =
                        view.getdepartmentId();

                boolean check =
                        dao.deleteDepartment(id);

                if (check) {

                    System.out.println(
                            "Department Deleted Successfully");
                }

                else {

                    System.out.println(
                            "Department Not Deleted");
                }

                break;
            }

            // READ ALL
            case 4: {

                List<departments> list =
                        dao.readAll();

                for (departments d : list) {

                    System.out.println(d);
                }

                break;
            }

            // EXIT
            case 5: {

                System.out.println("Thank You");
                return; 
            }

            default:

                System.out.println(
                        "Invalid Choice");
            }
        }
    }
}