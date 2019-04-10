package co.simplon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.entities.Customers;

public class CustomersDao extends Dao<Customers> {

	@Override
	public Customers find(int id) {
		String str = "select * from T_Customers where CodeCli=?";
		PreparedStatement ps;
		Customers Customers = null;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){				
				Customers = new Customers (resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("customers not exists");
			//e.printStackTrace();
		}		
		return Customers;
	}

	@Override
	public boolean create(Customers obj) {
		String str = "INSERT INTO T_Customers (IdCust,Name, FirstName) VALUES (?, ? ,? );";
		PreparedStatement ps;
		boolean ok = false;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getIdCust());
			ps.setString(2,obj.getName());
			ps.setString(3,obj.getFirstName());
			ps.executeQuery();
			ok = true;

		} catch (SQLException e) {
			System.out.println("customers exist ");
			//e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(Customers obj) {		
		String str = " update T_Customers set Name=?,FirstName=? where IdCust=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )){
			ps = connection.prepareStatement(str);
			ps.setString(1,obj.getName());
			ps.setString(2,obj.getFirstName());
			ps.setInt(3,obj.getIdCust());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			System.out.println("IdCust not exists");
			//e.printStackTrace();
		}		
		return ok;
	}

	@Override
	public boolean delete(Customers obj) {
		String str = "delete from T_Customers where IdCust=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setInt(1,obj.getIdCust());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			System.out.println("not exist");
			//e.printStackTrace();
		}
		return ok;
	}

	
}