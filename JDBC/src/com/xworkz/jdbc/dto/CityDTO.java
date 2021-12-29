package com.xworkz.jdbc.dto;

import java.io.Serializable;

public class CityDTO implements Serializable{

	private int cid;
	private String cName;
	private int cPoupulation;
	private String cFamousFor;

	public CityDTO()
	{

	}

	public CityDTO(int cid, String cName, int cPoupulation, String cFamousFor) {
		super();
		this.cid = cid;
		this.cName = cName;
		this.cPoupulation = cPoupulation;
		this.cFamousFor = cFamousFor;
	}

	public int getCid() {
		return cid;
	}

	public String getcName() {
		return cName;
	}

	public int getcPoupulation() {
		return cPoupulation;
	}

	public String getcFamousFor() {
		return cFamousFor;
	}

	@Override
	public String toString() {
		return "CityDTO [cid=" + cid + ", cName=" + cName + ", cPoupulation=" + cPoupulation + ", cFamousFor="
				+ cFamousFor + "]";
	}

}
