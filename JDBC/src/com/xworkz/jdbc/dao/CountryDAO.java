package com.xworkz.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xworkz.jdbc.dto.CountryDTO;
import com.xworkz.jdbc.utils.DBUtil;

public class CountryDAO {
	
	Connection mysql=null;
	
	public boolean save(CountryDTO dto)
	{
		
		mysql=DBUtil.createConnection();
		try {
			/*Class.forName("com.mysql.cj.jdbc.Driver");
            
			int rowsAffected=stat.executeUpdate(sql);
			System.out.println(sql);
			System.out.println("Formatted output : "+rowsAffected);
			if(rowsAffected==1) {
				return true;*/
			mysql=DriverManager.getConnection(LibraryConstants.URL,LibraryConstants.USERNAME,LibraryConstants.PASSWORD);
			String sql="insert into Country values("+dto.getCid()+",'"+dto.getcName()+"',"+dto.getcCode()+",'"+dto.getContinent()+"')";
			java.sql.Statement stat=mysql.createStatement();
			String sql1="insert into Country values(?,?,?,?)";
			PreparedStatement stat1=mysql.prepareStatement(sql1);
			stat1.setObject(1, dto.getCid());
			stat1.setObject(2, dto.getcName());
			stat1.setObject(3, dto.getcCode());
			stat1.setObject(4, dto.getContinent());
			int rowsAffected=stat1.executeUpdate();
			System.out.println(sql1);
			System.out.println("Formatted output : "+rowsAffected);
			if(rowsAffected==1) {
				return true;
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

		/* EXCEPTIONS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
			
			String sql="delete from Country where cid="+id;
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

}*/

public boolean deleteOperation(int id)
{
	mysql=DBUtil.createConnection();
	
	try {
		

		String sql="delete from Country where cid=?";
		PreparedStatement stat=mysql.prepareStatement(sql);
		stat.setObject(1, id);
		int rowsAffected=stat.executeUpdate();
		System.out.println("Formatted output : "+rowsAffected);
		if(rowsAffected==1) {
			return true;
		}
	}  catch (SQLException e) {
		e.printStackTrace();
	}
	
	finally {
		DBUtil.closeConnection(mysql);
	}
		
	return false;
	
	}

public void readOperationById(int id)
{
	mysql=DBUtil.createConnection();
	
	try {
		
		
		String sql="select * from Country where cid=?";
		PreparedStatement stat=mysql.prepareStatement(sql);
		stat.setObject(1, id);
		ResultSet result=stat.executeQuery();
		while(result.next())
		{
			Object country_id=result.getObject(1);
			System.out.println("cid- "+country_id);
			Object country_name=result.getObject(2);
			System.out.println("cName - "+country_name);
			Object country_code=result.getObject(3);
			System.out.println("ccode - "+country_code);
			Object country_Continent=result.getObject(4);
			System.out.println("Continent -"+country_Continent);
			
		}
		
	}  catch (SQLException e) {
		
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
			
			
			String sql="select * from Country";
			PreparedStatement stat=mysql.prepareStatement(sql);
			ResultSet result=stat.executeQuery();
			while(result.next())
			{
				Object country_id=result.getObject(1);
				Object country_name=result.getObject(2);
				Object country_code=result.getObject(3);
				Object country_Continent=result.getObject(4);
				System.out.println("Country_id- "+country_id+" "+"Country_Name- "+country_name+" "+"Country_code- "+country_code+" "+"country_continent- "+country_Continent);
			}
			
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DBUtil.closeConnection(mysql);
		}

		
	}

	public void displayTotalRows()
	{
	mysql=DBUtil.createConnection();
		
		try {
			
	
			String sql="select count(*) from Country";
			PreparedStatement stat=mysql.prepareStatement(sql);
			ResultSet result=stat.executeQuery();
			result.next();
			int count=result.getInt(1);
			System.out.println("No of rows in Country table  "+count);
			
			
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DBUtil.closeConnection(mysql);
		}
			
		
	  }
	
	}
	
