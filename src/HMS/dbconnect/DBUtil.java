package HMS.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	 static Connection con;

	    public static Connection makeConnection() {

	        try {

	            Class.forName("com.mysql.cj.jdbc.Driver");

	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","madhvi1320" );

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return con;
	    }
}
