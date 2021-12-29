package com.xworkz.jdbc.dto;


	import java.io.Serializable;

	public class CountryDTO implements Serializable {

		private int cid;
		private String cName;
		private int cCode;
		private String continent;

		public CountryDTO()
		{

		}

		public CountryDTO(int cid, String cName, int cCode, String continent) {
			super();
			this.cid = cid;
			this.cName = cName;
			this.cCode = cCode;
			this.continent = continent;
		}

		public int getCid() {
			return cid;
		}

		public String getcName() {
			return cName;
		}

		public int getcCode() {
			return cCode;
		}

		public String getContinent() {
			return continent;
		}

		@Override
		public String toString() {
			return "CountryDTO [cid=" + cid + ", cName=" + cName + ", cCode=" + cCode + ", continent=" + continent + "]";
		}


}
	
