package com.xworkz.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.jdbc.utils.DBUtil;

public class StateDAO {
	Connection mysql=null;
	
	public boolean save(com.xworkz.jdbc.dto.StateDTO StateDTO)
	{
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			mysql=DriverManager.getConnection(LibraryConstants.URL,LibraryConstants.USERNAME,LibraryConstants.PASSWORD);
			String sql="insert into State values("+StateDTO.getSid()+",'"+StateDTO.getSname()+"',"+StateDTO.getScode()+",'"+StateDTO.getScontinent()+"')";
			java.sql.Statement stat=mysql.createStatement();
			int rowsAffected=stat.executeUpdate(sql);

			String sql1="insert into State_details values(?,?,?,?)";
			PreparedStatement stat1=mysql.prepareStatement(sql1);
			stat1.setObject(1, StateDTO.getSid());
			stat1.setObject(2, StateDTO.getSname());
			stat1.setObject(3, StateDTO.getScontinent());
			stat1.setObject(4, StateDTO.getScode());
			int rowsAffected1=stat1.executeUpdate();
			System.out.println(sql1);
			System.out.println("Formatted output : "+rowsAffected1);
			if(rowsAffected1==1) {
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
			
			String sql="delete from State_details where state_id="+id;
			java.sql.Statement stat=mysql.createStatement();
			int rowsAffected=stat.executeUpdate(sql);
			String sql1="delete from State_details where state_id=?";
			PreparedStatement stat1=mysql.prepareStatement(sql1);
			stat1.setObject(1, id);
			int rowsAffected1=stat1.executeUpdate();
			System.out.println("Formatted output : "+rowsAffected1);
			if(rowsAffected1==1) {
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


			String sql="select * from State where sid=?";
			PreparedStatement stat=mysql.prepareStatement(sql);
			stat.setObject(1, id);
			ResultSet result=stat.executeQuery();
			while(result.next())
			{
				Object sid=result.getObject(1);
				System.out.println("State_id- "+sid);
				Object name=result.getObject(2);
				System.out.println("State_Name - "+name);
				Object code=result.getObject(3);
				System.out.println("state_code - "+code);
				Object capital=result.getObject(4);
				System.out.println("State_Capital -"+capital);

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


			String sql="select * from State";
			PreparedStatement stat=mysql.prepareStatement(sql);
			ResultSet result=stat.executeQuery();
			while(result.next())
			{
				Object state_id=result.getObject(1);
				Object state_name=result.getObject(2);
				Object state_code=result.getObject(3);
				Object state_Capital=result.getObject(4);
				System.out.println("State_id- "+state_id+" "+"State_Name- "+state_name+" "+"State_code- "+state_code+" "+"State_capital- "+state_Capital);
			}
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
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


			String sql="select count(*) from State";
			PreparedStatement stat=mysql.prepareStatement(sql);
			ResultSet result=stat.executeQuery();
			result.next();
			int count=result.getInt(1);
			System.out.println("No of rows in State table - "+count);


		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			DBUtil.closeConnection(mysql);
		}


	}

}