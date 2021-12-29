package com.xworkz.jdbc.dao;

import com.xworkz.jdbc.dto.IcecreamsDTO;

public class IcecreamsRunner {
	public static void main(String[] args) {
		IcecreamsDTO dto=new IcecreamsDTO(12,"Amul Ice cream","Mango",90);
		IcecreamsDTO dto1=new IcecreamsDTO(13,"Baskin Robbins","Butter Scotch",120);
		IcecreamsDTO dto2=new IcecreamsDTO(14,"Haagen-Dazs","Vanila",60);
		IcecreamsDTO dto3=new IcecreamsDTO(15,"Kulfi","Apple",80);
		IcecreamsDTO dto4=new IcecreamsDTO(16,"Vadilal ice cream","Apple",100);
		IcecreamsDTO dto5=new IcecreamsDTO(17,"Dinshaw's ice cream","Orange",160);
		IcecreamsDTO dto6=new IcecreamsDTO(18,"Nestle","Apple",150);
		
		IcecreamsDAO dao=new IcecreamsDAO();
		dao.save(dto);
		dao.save(dto1);
		dao.save(dto2);
		dao.save(dto3);
		dao.save(dto4);
		dao.save(dto5);
		dao.save(dto6);
		
		IcecreamsDAO dao1=new IcecreamsDAO();
        dao1.deleteById(18);

	}
}


