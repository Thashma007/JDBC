package com.xworkz.jdbc.dto;

import java.io.Serializable;

public class FestivalDTO implements Serializable{
    private int  fid;
    private String  fname;
    private int fdate;
    private String fdste;
    
	public FestivalDTO(int fid, String fname, int fdate, String fdste) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.fdate = fdate;
		this.fdste = fdste;
	}

	@Override
	public String toString() {
		return "FestivalDTO [fid=" + fid + ", fname=" + fname + ", fdate=" + fdate + ", fdste=" + fdste + "]";
	}

	public int getFid() {
		return fid;
	}

	public String getFname() {
		return fname;
	}

	public int getFdate() {
		return fdate;
	}

	public String getFdste() {
		return fdste;
	}
    
   
    
}

