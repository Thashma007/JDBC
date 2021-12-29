package com.xworkz.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.xworkz.jdbc.dto.CityDTO;

public class CityDAO {
	public boolean save(CityDTO dto)
	{
		Connection mysql=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			mysql=DriverManager.getConnection(LibraryConstants.URL,LibraryConstants.USERNAME,LibraryConstants.PASSWORD);
			
			String sql="insert into City values("+dto.getCid()+",'"+dto.getcName()+"',"+dto.getcPoupulation()+",'"+dto.getcFamousFor()+"')";
			java.sql.Statement stat=mysql.createStatement();
			int rowsAffected=stat.executeUpdate(sql);
			System.out.println(sql);
			System.out.println("Formatted output : "+rowsAffected);
			if(rowsAffected==1) {
				return true;
			}


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(mysql!=null)
			try {

					mysql.close();
					System.out.println("Closed the resource");

			}
			catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return false;
	}

	public boolean deleteOperation(int id)
	{
		Connection mysql=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			mysql=DriverManager.getConnection(LibraryConstants.URL,LibraryConstants.USERNAME,LibraryConstants.PASSWORD);
			
			String sql="delete from City where cid="+id;
			java.sql.Statement stat=mysql.createStatement();
			int rowsAffected=stat.executeUpdate(sql);
			System.out.println("Formatted output : "+rowsAffected);
			if(rowsAffected==1) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			if(mysql!=null)
			try {

					mysql.close();
					System.out.println("Closed the resource");

			}
			catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return false;

		}



}

