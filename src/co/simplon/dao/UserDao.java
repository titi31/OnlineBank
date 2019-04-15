package co.simplon.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.entities.Accounts;
import co.simplon.entities.User;
public class UserDao extends Dao<User> {
	public User isValidLogin(String name,String pass ) {
		String str = "select * from T_Users where nameUser=? AND passwordUser=?";
		PreparedStatement ps;
		User user = null;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			//ps.setInt(1,id);
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				user= new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("not exist");
			//e.printStackTrace();
		}		
		return user;
	}
	@Override
	public User find(int id) {
		String str = "select * from T_Users where IdCust=?";
		PreparedStatement ps;
		User user = null;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			//ps.setString(1, user.getNameUser());
			//ps.setString(2, user.getPasswordUser());
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				user= new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("not exist");
			//e.printStackTrace();
		}		
		return user;
	}
	

	@Override
	public boolean create(User obj) {
		String str = "INSERT INTO T_Users (IdCust,nameUser,passwordUser) VALUES (?, ? ,? );";
		PreparedStatement ps;
		boolean ok = false;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getIdCust());
			ps.setString(2,obj.getNameUser());
			ps.setString(3,obj.getPasswordUser());
			ps.setInt(3,obj.getIdCust());
			ps.executeQuery();
			ok = true;
		} catch (SQLException e) {
			System.out.println("exist");
			//e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(User obj) {		
		String str = " update T_Users set passwordUser=? where IdCust=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setString(1,obj.getPasswordUser());
			ps.setInt(2,obj.getIdCust());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			System.out.println("not exist");
			//e.printStackTrace();
		}		
		return ok;
	}

	@Override
	public boolean delete(User obj) {
		String str = "delete from T_Users where IdCust=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setInt(1,obj.getIdCust());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			System.out.println("no exists");
			//	e.printStackTrace();
		}
		return ok;
	}

}
