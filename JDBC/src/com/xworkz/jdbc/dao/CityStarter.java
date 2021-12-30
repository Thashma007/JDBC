package com.xworkz.jdbc.dao;

import com.xworkz.jdbc.dto.CityDTO;

public class CityStarter {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			CityDTO dto1=new CityDTO(1,"Jaipur",36789,"Pink city");
			CityDTO dto2=new CityDTO(2,"Udaipur",123456,"City of lakes");
			CityDTO dto3=new CityDTO(3,"Muzaffarpur",34567,"Lychees");
			CityDTO dto4=new CityDTO(4,"Kanpur",234567,"Leather");
			CityDTO dto5=new CityDTO(5,"Mumbai",124536,"Gateway of India");
			CityDTO dto6=new CityDTO(6,"Nagpur",52657,"Orange city");
			CityDTO dto7=new CityDTO(7,"Yavatmal",72376,"Cotton");

			CityDAO dao=new CityDAO();
			dao.save(dto1);
			dao.save(dto2);
			dao.save(dto3);
			dao.save(dto4);
			dao.save(dto5);
			dao.save(dto6);
			dao.save(dto7);

			dao.deleteOperation(4);
			dao.readOperationById(4);

			dao.deleteOperation(5);
			dao.displayAll();

			dao.displayTotalRows();

		}

	
}
	
