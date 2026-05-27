package HMS.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class departments {
	 private int departmentId;
	    private String departmentName;
	    private String location;
		public departments(String departmentName, String location) {
			super();
			this.departmentName = departmentName;
			this.location = location;
		}
	    
	    


}
