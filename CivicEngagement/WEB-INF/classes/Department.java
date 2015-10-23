

	public class Department {

		private int departmentid;
		private String departmentname;
		private String departmenthead;	
		private int departmentcontactnumber;
                private String   departmentemail;
                private int  cityid;
                private String city;
		
                
                
                
                public String getDepartmentcity() {
			return city;
		}
		public void setDepartmentcity(String city) {
			this.city = city;
		}
                
		public int getDepartmentid() {
			return  departmentid;
		}
		public void setDepartmentid(int  departmentid) {
			this. departmentid =  departmentid;
		}
		public String getDepartmentname() {
			return departmentname;
		}
		public void setDepartmentname(String departmentname) {
			this.departmentname = departmentname;
		}
		public String getDepartmenthead() {
			return departmenthead;
		}
		public void setDepartmenthead(String departmenthead) {
			this.departmenthead= departmenthead;
		}
                
               
		
		
		public int getDepartmentcontactnumber() {
			return departmentcontactnumber ;
		}
		public void setDepartmentcontactnumber(int departmentcontactnumber) {
			this.departmentcontactnumber= departmentcontactnumber;
		}
                
                public String getDepartmentemail() {
			return departmentemail;
		}
		public void setDepartmentemail(String departmentemail) {
			this.departmentemail = departmentemail;
		}

                public int getCityid() {
			return  cityid;
		}
		public void setCityid(int  cityid) {
			this. cityid =  cityid;
		}

		@Override
		public String toString() {
			return "Department [departmentid=" + departmentid + ", departmentname=" +departmentname
					+ ",departmenthead=" + departmenthead + ", departmentcontactnumber="
					+ departmentcontactnumber + ", departmentemail="+departmentemail+ ",cityid="+cityid+" ]";
		}
		
		
	}

