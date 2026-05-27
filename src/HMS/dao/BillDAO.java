package HMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import HMS.Entity.appointments;
import HMS.Entity.bills;
import HMS.Entity.patients;
import HMS.dbconnect.DBUtil;

public class BillDAO {

    // INSERT
    public boolean addBill(bills bill) {

        String sql = "insert into bills(patient_id,appointment_id,total_amount,payment_status,bill_date) values(?,?,?,?,?)";

        try (Connection con = DBUtil.makeConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1,
                    bill.getPatient().getPatientId());

            ps.setInt(2,
                    bill.getAppointment().getAppointmentId());

            ps.setDouble(3,
                    bill.getTotalAmount());

            ps.setString(4,
                    bill.getPaymentStatus());

            ps.setTimestamp(5,
                    Timestamp.valueOf(
                            bill.getBillDate()));

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // READ ALL
    public List<bills> readAll() {

        List<bills> list = new ArrayList<>();

        String sql = "select * from bills";

        try (Connection con = DBUtil.makeConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                bills b = new bills();

                b.setBillId(
                        rs.getInt("bill_id"));

                patients p = new patients();

                p.setPatientId(
                        rs.getInt("patient_id"));

                appointments a = new appointments();

                a.setAppointmentId(
                        rs.getInt("appointment_id"));

                b.setPatient(p);

                b.setAppointment(a);

                b.setTotalAmount(
                        rs.getDouble("total_amount"));

                b.setPaymentStatus(
                        rs.getString("payment_status"));

                b.setBillDate(
                        rs.getTimestamp("bill_date")
                        .toLocalDateTime());

                list.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    public boolean updateBill(bills bill) {

        String sql = "update bills set patient_id=?,appointment_id=?,total_amount=?,payment_status=?,bill_date=? where bill_id=?";

        try (Connection con = DBUtil.makeConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1,
                    bill.getPatient().getPatientId());

            ps.setInt(2,
                    bill.getAppointment().getAppointmentId());

            ps.setDouble(3,
                    bill.getTotalAmount());

            ps.setString(4,
                    bill.getPaymentStatus());

            ps.setTimestamp(5,
                    Timestamp.valueOf(
                            bill.getBillDate()));

            ps.setInt(6,
                    bill.getBillId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public boolean deleteBill(int billId) {

        String sql = "delete from bills where bill_id=?";

        try (Connection con = DBUtil.makeConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, billId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}