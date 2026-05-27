package HMS.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import HMS.Entity.departments;
import HMS.Entity.doctors;
import HMS.dbconnect.DBUtil;

public class DoctorDAO {
	// Insert 
	public boolean adddoctors(doctors doctors) {
		String sql = ("insert into doctors(first_name,last_name,specialization,phone,email,hire_date,department_id) values(?,?,?,?,?,?,?)");

		try(Connection con = DBUtil.makeConnection();PreparedStatement ps = con.prepareStatement(sql)){
		
			ps.setString(1, doctors.getFirstName());
			ps.setString(2, doctors.getLastName());
			ps.setString(3, doctors.getSpecialization());
			ps.setString(4, doctors.getPhone());
			ps.setString(5, doctors.getEmail());
			ps.setDate(6, Date.valueOf(doctors.getHireDate().toString()));
            
			ps.setInt(7, doctors.getDepartment().getDepartmentId());

			return ps.executeUpdate()> 0;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;

}
	
    // READ ALL
    public List<doctors> readAll() {

        List<doctors> list = new ArrayList<>();

        String sql = "select * from doctors";

        try (Connection con = DBUtil.makeConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                doctors d = new doctors();

                d.setDoctorId(rs.getInt("doctor_id"));
                d.setFirstName(rs.getString("first_name"));
                d.setLastName(rs.getString("last_name"));
                d.setSpecialization(rs.getString("specialization"));
                d.setPhone(rs.getString("phone"));
                d.setEmail(rs.getString("email"));

                d.setHireDate(
                        rs.getDate("hire_date").toLocalDate());

                departments dept = new departments();

                dept.setDepartmentId(rs.getInt("department_id"));

                d.setDepartment(dept);

                list.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    public boolean updatedoctors(doctors doctors) {

        String sql = "update doctors set first_name=?,last_name=?,specialization=?,phone=?,email=?,hire_date=?,department_id=? where doctor_id=?";

        try (Connection con = DBUtil.makeConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctors.getFirstName());
            ps.setString(2, doctors.getLastName());
            ps.setString(3, doctors.getSpecialization());
            ps.setString(4, doctors.getPhone());
            ps.setString(5, doctors.getEmail());

            ps.setDate(6, Date.valueOf(doctors.getHireDate()));

            ps.setInt(7, doctors.getDepartment().getDepartmentId());

            ps.setInt(8, doctors.getDoctorId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // DELETE
    public boolean deletedoctors(int doctorId) {

        String sql = "delete from doctors where doctor_id=?";

        try (Connection con = DBUtil.makeConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}


