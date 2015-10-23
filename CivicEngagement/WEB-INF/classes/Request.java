

	public class Request {

		private int requestid;
		private String requesttype;
		private String requestdate;	
		private String requestdescription;
                private String requestlocation;
                private String requeststatus;
                private int departmentid;

		private String city;
                private String department;
		public int getRequestid() {
			return requestid;
		}
		public void setRequestid(int requestid) {
			this.requestid = requestid;
		}
		public String getRequesttype() {
			return requesttype;
		}
		public void setRequesttype(String requesttype) {
			this.requesttype = requesttype;
		}
                
                public String getRequestdepartment() {
			return department;
		}
		public void setRequestdepartment(String department) {
			this.department = department;
		}
                
                public String getRequestcity() {
			return city;
		}
		public void setRequestcity(String city) {
			this.city = city;
		}
		public String getRequestdate() {
			return requestdate;
		}
		public void setRequestdate(String requestdate) {
			this.requestdate = requestdate;
		}
		
		
		public String getRequestdescription() {
			return requestdescription;
		}
		public void setRequestdescription(String requestdescription) {
			this.requestdescription = requestdescription;
		}
                
                public String getRequestlocation() {
			return requestlocation;
		}
		public void setRequestlocation(String requestlocation) {
			this.requestlocation = requestlocation;
		}

                 public String getRequeststatus() {
			return requeststatus;
		}
		public void setRequeststatus(String requeststatus) {
			this.requeststatus = requeststatus;
		}
                
                public int getDepartmentid() {
			return departmentid;
		}
		public void setDepartmentid(int departmentid) {
			this.departmentid = departmentid;
		}

		@Override
		public String toString() {
			return "Request [requestid=" + requestid + ", requesttype=" +requesttype
					+ ", requestdate=" + requestdate + ", requestdescription="
					+ requestdescription + ", requestlocation="+requestlocation+ ",requeststatus="+requeststatus+",departmentid="+departmentid+" ]";
		}
		
		
	}

