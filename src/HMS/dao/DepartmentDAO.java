package HMS.dao;
		
		import java.sql.Connection;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.util.ArrayList;
		import java.util.List;

		import HMS.Entity.departments;
		import HMS.dbconnect.DBUtil;

		public class DepartmentDAO {

		    // INSERT
		    public boolean addDepartment(departments dept) {

		      String sql = "insert into departments(department_name,location) values(?,?)";

		        try(Connection con = DBUtil.makeConnection();
		            PreparedStatement ps = con.prepareStatement(sql)) {

		            ps.setString(1, dept.getDepartmentName());
		            ps.setString(2, dept.getLocation());

		            return ps.executeUpdate() > 0;

		        } catch(SQLException e) {
		            e.printStackTrace();
		        }

		        return false;
		    }

		    // READ
		    public List<departments> readAll() {

		        List<departments> list = new ArrayList<>();

		        String sql = "select * from departments";

		        try(Connection con = DBUtil.makeConnection();
		            PreparedStatement ps = con.prepareStatement(sql);
		            ResultSet rs = ps.executeQuery()) {

		            while(rs.next()) {

		                departments d = new departments();

		                d.setDepartmentId(rs.getInt("department_id"));
		                d.setDepartmentName(rs.getString("department_name"));
		                d.setLocation(rs.getString("location"));

		                list.add(d);
		            }

		        } catch(SQLException e) {
		            e.printStackTrace();
		        }

		        return list;
		    }

		    // UPDATE
		    public boolean updateDepartment(departments dept) {

		        String sql = "update departments set department_name=?,location=? where department_id=?";

		        try(Connection con = DBUtil.makeConnection();
		            PreparedStatement ps = con.prepareStatement(sql)) {

		            ps.setString(1, dept.getDepartmentName());
		            ps.setString(2, dept.getLocation());
		            ps.setInt(3, dept.getDepartmentId());

		            return ps.executeUpdate() > 0;

		        } catch(SQLException e) {
		            e.printStackTrace();
		        }

		        return false;
		    }

		    // DELETE
		    public boolean deleteDepartment(int id) {

		        String sql = "delete from departments where department_id=?";

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
	   	


