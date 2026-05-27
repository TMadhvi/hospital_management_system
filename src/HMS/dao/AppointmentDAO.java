package HMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import HMS.Entity.appointments;
import HMS.Entity.doctors;
import HMS.Entity.patients;
import HMS.dbconnect.DBUtil;

public class AppointmentDAO {

    // INSERT
    public boolean addAppointment(appointments appointment) {

        String sql = "insert into appointments(patient_id,doctor_id,appointment_date,status,reason) values(?,?,?,?,?)";

        try(Connection con = DBUtil.makeConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1,
                    appointment.getPatient().getPatientId());

            ps.setInt(2,
                    appointment.getDoctor().getDoctorId());

            ps.setTimestamp(3,
                    Timestamp.valueOf(
                            appointment.getAppointmentDate()));

            ps.setString(4, appointment.getStatus());
            ps.setString(5, appointment.getReason());

            return ps.executeUpdate() > 0;

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ
    public List<appointments> readAll() {

        List<appointments> list = new ArrayList<>();

        String sql = "select * from appointments";

        try(Connection con = DBUtil.makeConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {

                appointments a = new appointments();

                a.setAppointmentId(
                        rs.getInt("appointment_id"));

                patients p = new patients();
                p.setPatientId(rs.getInt("patient_id"));

                doctors d = new doctors();
                d.setDoctorId(rs.getInt("doctor_id"));

                a.setPatient(p);
                a.setDoctor(d);

                a.setAppointmentDate(
                        rs.getTimestamp("appointment_date")
                        .toLocalDateTime());

                a.setStatus(rs.getString("status"));
                a.setReason(rs.getString("reason"));

                list.add(a);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    public boolean updateAppointment(appointments appointment) {

        String sql = "update appointments set patient_id=?,doctor_id=?,appointment_date=?,status=?,reason=? where appointment_id=?";

        try(Connection con = DBUtil.makeConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1,
                    appointment.getPatient().getPatientId());

            ps.setInt(2,
                    appointment.getDoctor().getDoctorId());

            ps.setTimestamp(3,
                    Timestamp.valueOf(
                            appointment.getAppointmentDate()));

            ps.setString(4, appointment.getStatus());
            ps.setString(5, appointment.getReason());

            ps.setInt(6, appointment.getAppointmentId());

            return ps.executeUpdate() > 0;

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public boolean deleteAppointment(int id) {

        String sql = "delete from appointments where appointment_id=?";

        try(Connection con = DBUtil.makeConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



	


	
}