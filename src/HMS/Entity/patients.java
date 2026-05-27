package HMS.Entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class patients {

	private int patientId;
	private String firstName;
	private String lastName;
	private String gender;
	private LocalDate dateOfBirth;
	private String phone;
	private String email;
	private String address;
	private String bloodGroup;
	private LocalDate registrationDate;

	public patients(String firstName, String lastName, String gender, LocalDate dateOfBirth, String phone, String email,
			String address, String bloodGroup, LocalDate registrationDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.bloodGroup = bloodGroup;
		this.registrationDate = registrationDate;
	}

	public patients(int patientId, LocalDate registrationDate) {
		super();
		this.patientId = patientId;
		this.registrationDate = registrationDate;
	}

	
}
