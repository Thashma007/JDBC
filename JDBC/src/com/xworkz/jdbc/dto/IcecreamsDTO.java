package com.xworkz.jdbc.dto;

import java.io.Serializable;

public class IcecreamsDTO implements Serializable{
  private int creamId;
  private String cname;
  private String cFlavour;
  private int price;
  
public IcecreamsDTO(int creamId, String cname, String cFlavour, int price) {
	super();
	this.creamId = creamId;
	this.cname = cname;
	this.cFlavour = cFlavour;
	this.price = price;
}

@Override
public String toString() {
	return "IcecreamsDTO [creamId=" + creamId + ", cname=" + cname + ", cFlavour=" + cFlavour + ", price=" + price
			+ "]";
}

public int getCreamId() {
	return creamId;
}

public String getCname() {
	return cname;
}

public String getcFlavour() {
	return cFlavour;
}

public int getPrice() {
	return price;
}

  
  
}
