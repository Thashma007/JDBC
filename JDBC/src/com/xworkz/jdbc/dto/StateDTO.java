package com.xworkz.jdbc.dto;

import java.io.Serializable;

public class StateDTO  implements Serializable {

	private int sid;
	private String sname;
	private int scode;
	private String scontinent;
	
	@Override
	public String toString() {
		return "StateDTO [sid=" + sid + ", sname=" + sname + ", scode=" + scode + ", scontinent=" + scontinent + "]";
	}

	public StateDTO(int sid, String sname, int scode, String scontinent) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.scode = scode;
		this.scontinent = scontinent;
	}

	public int getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public int getScode() {
		return scode;
	}

	public String getScontinent() {
		return scontinent;
	}
	
	
	
	
	
}
