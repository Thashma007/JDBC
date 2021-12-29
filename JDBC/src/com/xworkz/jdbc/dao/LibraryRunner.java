package com.xworkz.jdbc.dao;

import com.xworkz.jdbc.dto.LibraryDTO;

public class LibraryRunner {

	public static void main(String[] args) {
		LibraryDTO dto=new LibraryDTO(31,"Wings of flower","Abdul Kalam",964.98f,2002,"V6");
		
		//LibraryDAO dao=new LibraryDAO();
		//dao.save(dto);
		
		LibraryDAO dao1=new LibraryDAO();
       dao1.deleteById(41);

	}

}
