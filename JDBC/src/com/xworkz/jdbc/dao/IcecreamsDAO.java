package com.xworkz.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.jdbc.utils.DBUtil;

public class IcecreamsDAO {
	public boolean save(com.xworkz.jdbc.dto.IcecreamsDTO IcecreamsDTO)
	{
		Connection mysql=null;
	
		try {
			mysql=DBUtil.createConnection();
			
			
			 mysql = DriverManager.getConnection(LibraryConstants.URL,LibraryConstants.USERNAME,LibraryConstants.PASSWORD);
				if(!mysql.isClosed()) {
					System.out.println("mqsql database is open");
					String sql="insert into Icecreams values("+IcecreamsDTO.getCreamId()+",'"+IcecreamsDTO.getCname()+"','"+IcecreamsDTO.getcFlavour()+"',"+IcecreamsDTO.getPrice()+")";
					Statement statement=mysql.createStatement();
					int rowsAffected=statement.executeUpdate(sql);
					String sql1="insert into Icecreams values(?,?,?,?)";
					PreparedStatement stat=mysql.prepareStatement(sql1);
					stat.setObject(1, IcecreamsDTO.getCreamId());
					stat.setObject(2, IcecreamsDTO.getcFlavour());
					stat.setObject(3, IcecreamsDTO.getCname());
					stat.setObject(4, IcecreamsDTO.getPrice());
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

			public boolean deleteOperation(int id)
			{
				Connection mysql=null;
				mysql=DBUtil.createConnection();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					mysql=DriverManager.getConnection(LiberaryConstant.URL,LiberaryConstant.USERNAME, LiberaryConstant.PASSWORD);
					
					String sql="delete from IceCreams where cream_id="+id;
					java.sql.Statement stat=mysql.createStatement();
					int rowsAffected=stat.executeUpdate(sql);

					String sql1="delete from IceCreams where cream_id=?";
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
			
				}  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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


					String sql="select * from IceCreams where id=?";
					PreparedStatement stat=mysql.prepareStatement(sql);
					stat.setObject(1, id);
					ResultSet result=stat.executeQuery();
					while(result.next())
					{
						Object cream_id=result.getObject(1);
						System.out.println("IceCream_id- "+cream_id);
						Object cream_flav=result.getObject(2);
						System.out.println("Icecream-flavour - "+cream_flav);
						Object Icecream_Name=result.getObject(3);
						System.out.println("Icecream_Name - "+Icecream_Name);
						Object price=result.getObject(4);
						System.out.println("Icecream_price -"+price);

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


					String sql="select * from IceCream_details";
					PreparedStatement stat=mysql.prepareStatement(sql);
					ResultSet result=stat.executeQuery();
					while(result.next())
					{
						Object id=result.getObject(1);
						Object flav=result.getObject(2);
						Object name=result.getObject(3);
						Object price=result.getObject(4);
						System.out.println("Icecream_id- "+id+" "+"IceCream_Flavour- "+flav+" "+"IceCream_Name- "+name+"  "+"Icecream_Price- "+price);
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


					String sql="select count(*) from IceCreams";
					PreparedStatement stat=mysql.prepareStatement(sql);
					ResultSet result=stat.executeQuery();
					result.next();
					int count=result.getInt(1);
					System.out.println("No of rows in IceCreams table - "+count);


				}  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				finally {
					DBUtil.closeConnection(mysql);
				}


			}


		}
			