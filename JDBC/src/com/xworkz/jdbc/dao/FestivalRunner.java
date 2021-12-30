package com.xworkz.jdbc.dao;

import com.xworkz.jdbc.dto.FestivalDTO;


public class FestivalRunner {
	public static void main(String[] args) {
		FestivalDTO dto=new FestivalDTO(12,"Dasara",22,"Karnataka");
		FestivalDTO dto1=new FestivalDTO(13,"Ganesh chathurthi",25,"Maharastra");
		FestivalDTO dto2=new FestivalDTO(14,"Holi",18,"Uttarkhand");
		FestivalDTO dto3=new FestivalDTO(15,"Diwali",20,"Goa");
		FestivalDTO dto4=new FestivalDTO(16,"Navarathri",07,"Karnataka");
		FestivalDTO dto5=new FestivalDTO(17,"Vesak",30,"South East");
		FestivalDTO dto6=new FestivalDTO(18,"Shiv ratri",02,"Uttarkhand");
		
		FestivalDAO dao=new FestivalDAO();
		dao.save(dto);
		dao.save(dto1);
		dao.save(dto2);
		dao.save(dto3);
		dao.save(dto4);
		dao.save(dto5);
		dao.save(dto6);
		

        dao.readOperationById(14);

		dao.deleteOperation(5);
		dao.displayAll();

		dao.displayTotalRows();

	}
}
