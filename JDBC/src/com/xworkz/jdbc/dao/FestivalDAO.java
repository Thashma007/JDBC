package com.xworkz.jdbc.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.jdbc.dto.CountryDTO;
import com.xworkz.jdbc.dto.FestivalDTO;
import com.xworkz.jdbc.utils.DBUtil;

public class FestivalDAO {
	
		Connection mysql=null;
		
		public boolean save(FestivalDTO FestivalDTO)
		{
			
			mysql=DBUtil.createConnection();
			try {
				mysql = DriverManager.getConnection(LibraryConstants.URL,LibraryConstants.USERNAME,LibraryConstants.PASSWORD);
				String sql="insert into Festival values("+FestivalDTO.getFid()+",'"+FestivalDTO.getFname()+"',"+FestivalDTO.getFdate()+",'"+FestivalDTO.getFdste()+"')";
				Statement statement=mysql.createStatement();
				int rowsAffected=statement.executeUpdate(sql);
				
				String sql1="insert into festival values(?,?,?,?)";
				PreparedStatement stat=mysql.prepareStatement(sql1);
				stat.setObject(1, FestivalDTO.getFid());
				stat.setObject(2, FestivalDTO.getFname());
				stat.setObject(3, FestivalDTO.getFdate());
				stat.setObject(4, FestivalDTO.getFdste());
				int rowsAffected1=stat.executeUpdate();
				System.out.println(sql1);
				System.out.println("Formatted output : "+rowsAffected1);
				if(rowsAffected1==1) {
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

		public boolean deleteOperation(int id) {
			
			mysql=DBUtil.createConnection();
			try {

				String sql="delete from festival_detailss where fid="+id;
				java.sql.Statement stat=mysql.createStatement();
				int rowsAffected=stat.executeUpdate(sql);
				String sql1="delete from festival_detailss where fid=?";
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


				String sql="select * from festival where fid=?";
				PreparedStatement stat=mysql.prepareStatement(sql);
				stat.setObject(1, id);
				ResultSet result=stat.executeQuery();
				while(result.next())
				{
					Object festival_id=result.getObject(1);
					System.out.println("Festival_id- "+festival_id);
					Object festival_name=result.getObject(2);
					System.out.println("Festival_Name - "+festival_name);
					Object festival_date=result.getObject(3);
					System.out.println("Festival_Date - "+festival_date);
					Object festival_state=result.getObject(4);
					System.out.println("Festival_state -"+festival_state);

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


				String sql="select * from festival";
				PreparedStatement stat=mysql.prepareStatement(sql);
				ResultSet result=stat.executeQuery();
				while(result.next())
				{
					Object festival_id=result.getObject(1);
					Object festival_name=result.getObject(2);
					Object festival_date=result.getObject(3);
					Object festival_state=result.getObject(4);
					System.out.println("Festival_id- "+festival_id+" "+"Festival_Name- "+festival_name+" "+"Festival_date- "+festival_date+"  "+"festival_State- "+festival_state);
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


				String sql="select count(*) from festival";
				PreparedStatement stat=mysql.prepareStatement(sql);
				ResultSet result=stat.executeQuery();
				result.next();
				int count=result.getInt(1);
				System.out.println("No of rows in festival table - "+count);


			}  catch (SQLException e) {
				e.printStackTrace();
			}

			finally {
				DBUtil.closeConnection(mysql);
			}


		}


	}
		
		