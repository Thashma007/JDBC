package com.xworkz.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xworkz.jdbc.dto.CityDTO;
import com.xworkz.jdbc.utils.DBUtil;

public class CityDAO {
	public boolean save(CityDTO dto)
	{
		Connection mysql=null;
		try {
			mysql=DBUtil.createConnection();
			
			
			mysql=DriverManager.getConnection(LibraryConstants.URL,LibraryConstants.USERNAME,LibraryConstants.PASSWORD);
			String sql="insert into City_details values("+dto.getCid()+",'"+dto.getcName()+"',"+dto.getcPoupulation()+",'"+dto.getcFamousFor()+"')";
			java.sql.Statement stat=mysql.createStatement();
			int rowsAffected=stat.executeUpdate(sql);
			String sql="insert into City_details values(?,?,?,?)";
			PreparedStatement stat=mysql.prepareStatement(sql);
			stat.setObject(1, dto.getCid());
			stat.setObject(2, dto.getcName());
			stat.setObject(3, dto.getcPoupulation());
			stat.setObject(4, dto.getcFamousFor());
			int rowsAffected=stat.executeUpdate();
			System.out.println(sql);
			System.out.println("Formatted output : "+rowsAffected);
			if(rowsAffected==1) {
				return true;
			}


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

		}  catch (SQLException e) {
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
			DBUtil.closeConnection(mysql);
		}

		return false;
	}

	public boolean deleteOperation(int id)
	{
		Connection mysql=null;
           
		try {
			
			mysql=DBUtil.createConnection();

			mysql=DriverManager.getConnection(LibraryConstants.URL,LibraryConstants.USERNAME,LibraryConstants.PASSWORD);
			String sql="delete from City where cid="+id;
			java.sql.Statement stat=mysql.createStatement();
			int rowsAffected=stat.executeUpdate(sql);

			String sql1="delete from city where cid=?";
			PreparedStatement stat1=mysql.prepareStatement(sql1);
			stat1.setObject(1, id);
			int rowsAffected1=stat1.executeUpdate();
			System.out.println("Formatted output : "+rowsAffected1);
			if(rowsAffected1==1) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
		}
		
		finally {
			if(mysql!=null)
			try {

					mysql.close();
					System.out.println("Closed the resource");
			DBUtil.closeConnection(mysql);
		}

		return false;
	}

	public void readOperationById(int id)
	{
		mysql=DBUtil.createConnection();

		try {


			String sql="select * from city where cid=?";
			PreparedStatement stat=mysql.prepareStatement(sql);
			stat.setObject(1, id);
			ResultSet result=stat.executeQuery();
			while(result.next())
			{
				Object city_id=result.getObject(1);
				System.out.println("City_id- "+city_id);
				Object city_name=result.getObject(2);
				System.out.println("City_Name - "+city_name);
				Object city_population=result.getObject(3);
				System.out.println("City_Population - "+city_population);
				Object city_famousFor=result.getObject(4);
				System.out.println("City_FamousFor -"+city_famousFor);

			}
			catch (SQLException e) {

				e.printStackTrace();
		}  
		finally {
			DBUtil.closeConnection(mysql);
		}


	}

	public void displayAll()
	{
		mysql=DBUtil.createConnection();

		try {


			String sql="select * from City";
			PreparedStatement stat=mysql.prepareStatement(sql);
			ResultSet result=stat.executeQuery();
			while(result.next())
			{
				Object city_id=result.getObject(1);
				Object city_name=result.getObject(2);
				Object city_population=result.getObject(3);
				Object city_famousFor=result.getObject(4);
				System.out.println("Cityy_id- "+city_id+" "+"City_Name- "+city_name+" "+"City_population- "+city_population+" "+"city_FamousFor- "+city_famousFor);
			}
			

		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection(mysql);
		}

		return false;


	}

	public void displayTotalRows()
	{
       mysql=DBUtil.createConnection();

		try {


			String sql="select count(*) from City_details";
			PreparedStatement stat=mysql.prepareStatement(sql);
			ResultSet result=stat.executeQuery();
			result.next();
			int count=result.getInt(1);
			System.out.println("No of rows in City table - "+count);


		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection(mysql);
		}


	}


}