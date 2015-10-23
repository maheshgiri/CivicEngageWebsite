

	public class City {

		private int cityid;
		private String city;
		private String citystate;	
		private int citypopulation;
                

		
		public int getCityid() {
			return  cityid;
		}
		public void setCityid(int  cityid) {
			this. cityid =  cityid;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city= city;
		}
		public String getCitystate() {
			return citystate;
		}
		public void setCitystate(String citystate) {
			this.citystate= citystate;
		}
		
		
		public int getCitypopulation() {
			return citypopulation ;
		}
		public void setCitypopulation(int citypopulation) {
			this.citypopulation= citypopulation;
		}
                
                
		
		
		

		@Override
		public String toString() {
			return "City [cityid=" + cityid + ", city=" +city
					+ ",citystate=" + citystate+ ", citypopulation="
					+ citypopulation + " ]";
		}
		
		
	}

