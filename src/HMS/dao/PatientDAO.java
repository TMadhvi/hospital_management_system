		package HMS.dao;

	import java.sql.Connection;
	import java.sql.Date;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import HMS.Entity.patients;
	import HMS.dbconnect.DBUtil;

	public class PatientDAO {

	    // INSERT
	    public boolean addPatient(patients patient) {
	    	
	    	 // PHONE VALIDATION
	        String phone = patient.getPhone();

	        if(phone == null || phone.trim().isEmpty()) {

	            System.out.println("Invalid Phone Number");
	            return false;
	        }
	    	

	        String sql = "insert into patients(first_name,last_name,gender,date_of_birth,phone,email,address,blood_group,registration_date) values(?,?,?,?,?,?,?,?,?)";

	        try(Connection con = DBUtil.makeConnection();
	            PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, patient.getFirstName());
	            ps.setString(2, patient.getLastName());
	            ps.setString(3, patient.getGender());

	            ps.setDate(4,
	                    Date.valueOf(patient.getDateOfBirth()));

	            ps.setString(5, patient.getPhone());
	            ps.setString(6, patient.getEmail());
	            ps.setString(7, patient.getAddress());
	            ps.setString(8, patient.getBloodGroup());
	            ps.setDate(9, Date.valueOf(patient.getRegistrationDate()));



	            return ps.executeUpdate() > 0;

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }

	        return false;
	    }

	    // READ
	    public List<patients> readAll() {

	        List<patients> list = new ArrayList<>();

	        String sql = "select * from patients";

	        try(Connection con = DBUtil.makeConnection();
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery()) {

	            while(rs.next()) {

	                patients p = new patients();

	                p.setPatientId(rs.getInt("patient_id"));
	                p.setFirstName(rs.getString("first_name"));
	                p.setLastName(rs.getString("last_name"));
	                p.setGender(rs.getString("gender"));

	                p.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());

	                p.setPhone(rs.getString("phone"));
	                p.setEmail(rs.getString("email"));
	                p.setAddress(rs.getString("address"));
	                p.setBloodGroup(rs.getString("blood_group"));
	                p.setDateOfBirth(rs.getDate("registration_date").toLocalDate());

	                

	                list.add(p);
	            }

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	    // UPDATE
	    public boolean updatePatient(patients patient) {

	        String sql = "update patients set registration_date =? where patient_id=?";

	        try(Connection con = DBUtil.makeConnection();
	            PreparedStatement ps = con.prepareStatement(sql)) {

	           
	            ps.setDate(1,Date.valueOf(patient.getRegistrationDate()));
	            ps.setInt(2,patient.getPatientId() );

	            
	            return ps.executeUpdate() > 0;

	        } catch(SQLException e) {
	            e.printStackTrace();
	        }

	        return false;
	    }

	    // DELETE
	    public boolean deletePatient(int id) {

	        String sql = "delete from patients where patient_id=?";

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


