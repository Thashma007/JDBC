package com.xworkz.jdbc.dao;

import com.xworkz.jdbc.dto.CountryDTO;

public class CountryRunner {

	public static void main(String[] args) {
		
	CountryDTO dto1=new CountryDTO(1,"INDIA",91,"Asia");
	CountryDTO dto2=new CountryDTO(2,"Algeria",213,"Africa");
	CountryDTO dto3=new CountryDTO(3,"Canada",1,"North America");
	CountryDTO dto4=new CountryDTO(4,"Brazil",55,"South America");
	CountryDTO dto5=new CountryDTO(5,"Vatican",379,"Europe");
	CountryDTO dto6=new CountryDTO(6,"Tasmania",3,"Australia");
	CountryDTO dto7=new CountryDTO(7,"China",86,"Asia");

	CountryDAO dao=new CountryDAO();
	dao.save(dto1);
	dao.save(dto2);
	dao.save(dto3);
	dao.save(dto4);
	dao.save(dto5);
	dao.save(dto6);
	dao.save(dto7);

	dao.deleteOperation(5);


	}


}
