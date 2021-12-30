package com.xworkz.jdbc.dao;

import com.xworkz.jdbc.dto.StateDTO;

public class StateRunner {

	public static void main(String[] args) {
		StateDTO dto=new StateDTO(12,"Madhyapradesh",22,"Bhopal");
		StateDTO dto1=new StateDTO(13,"Maharastra",25,"Mumbai");
		StateDTO dto2=new StateDTO(14,"Karnataka",18,"Banglore");
		StateDTO dto3=new StateDTO(15,"Assam",20,"Dispur");
		StateDTO dto4=new StateDTO(16,"Kerala",07,"Thiruvananthapuram");
		StateDTO dto5=new StateDTO(17,"Goa",30,"Panaji");
		StateDTO dto6=new StateDTO(18,"TamilNadu",02,"Chennai");
		
		StateDAO dao=new StateDAO();
		dao.save(dto);
		dao.save(dto1);
		dao.save(dto2);
		dao.save(dto3);
		dao.save(dto4);
		dao.save(dto5);
		dao.save(dto6);

        dao.readOperationById(14);

		dao.deleteOperation(15);
		dao.displayAll();

		dao.displayTotalRows();
	}

}
