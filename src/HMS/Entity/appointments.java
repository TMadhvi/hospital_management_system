package HMS.Entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class appointments {

    private int appointmentId;

    private patients patient = new patients();

    private doctors doctor = new doctors();

    private LocalDateTime appointmentDate;

    private String status;

    private String reason;

    // custom constructor
    public appointments(int patientId, int doctorId,LocalDateTime appointmentDate, String status, String reason) {

        this.patient.setPatientId(patientId);

        this.doctor.setDoctorId(doctorId);

        this.appointmentDate = appointmentDate;
        this.status = status;
        this.reason = reason;
    }
}