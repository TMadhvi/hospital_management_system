package HMS.Entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class bills {

    private int billId;

    private patients patient = new patients();

    private appointments appointment = new appointments();

    private double totalAmount;

    private String paymentStatus;

    private LocalDateTime billDate;

    // custom constructor
    public bills(int patientId,
                 int appointmentId,
                 double totalAmount,
                 String paymentStatus,
                 LocalDateTime billDate) {

        this.patient.setPatientId(patientId);

        this.appointment.setAppointmentId(appointmentId);

        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.billDate = billDate;
    }
}