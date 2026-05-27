package HMS.Entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class doctors {

    private int doctorId;
    private String firstName;
    private String lastName;
    private String specialization;
    private String phone;
    private String email;
    private LocalDate hireDate;

    private departments department = new departments();

    // custom constructor
    public doctors(String firstName,
                   String lastName,
                   String specialization,
                   String phone,
                   String email,
                   LocalDate hireDate,
                   int dpId) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
        this.hireDate = hireDate;

        // department object ke andar id set kar rahe
        this.department.setDepartmentId(dpId);
    }
}