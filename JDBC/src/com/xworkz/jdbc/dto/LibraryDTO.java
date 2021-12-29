package com.xworkz.jdbc.dto;

import java.io.Serializable;

public class LibraryDTO implements Serializable{

	private int id;
	private String Bookname;
	private String Authorname;
	private float price;
	private int year;
	private String volume;
	
	
	
	public LibraryDTO(int id, String bookname, String authorname, float price, int year, String volume) {
		super();
		this.id = id;
		Bookname = bookname;
		Authorname = authorname;
		this.price = price;
		this.year = year;
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "LibraryDTO [id=" + id + ", Bookname=" + Bookname + ", Authorname=" + Authorname + ", price=" + price
				+ ", year=" + year + ", volume=" + volume + "]";
	}

	public int getId() {
		return id;
	}

	public String getBookname() {
		return Bookname;
	}

	public String getAuthorname() {
		return Authorname;
	}

	public float getPrice() {
		return price;
	}

	public int getYear() {
		return year;
	}

	public String getVolume() {
		return volume;
	}
	
	
	}







