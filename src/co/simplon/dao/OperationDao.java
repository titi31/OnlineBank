package co.simplon.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.entities.Accounts;
import co.simplon.entities.Operations;
public class OperationDao extends Dao<Operations>{
	public Operations find(int id) {	
		String str = "select * from T_Operations where NumOp=?";
		PreparedStatement ps;
		Operations operation = null;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){				
				operation = new Operations(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getDate(4),resultSet.getInt(5));
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}		
		return operation;						
	}

	@Override
	public boolean create(Operations operation) {
		String str = "INSERT INTO T_Operations (type,Amount,NumCt) VALUES (?, ? ,?);";
		PreparedStatement ps;
		boolean ok = false;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setString(1, operation.getType());
			ps.setInt(2, operation.getAmount());
			//ps.setInt(3,operation.getAmount());
			ps.setInt(3,operation.getNumCt());
			ps.executeQuery();
			ok = true;

		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(Operations operation) {
		String str = " update T_Operations set Amount=? where NumOp=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setInt(1,operation.getAmount());
			ps.setInt(2,operation.getNumOp());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		return ok;
	}

	@Override
	public boolean delete(Operations operation) { 
		String str = "delete from T_Operations where NumOp=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setInt(1,operation.getNumOp());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
}
