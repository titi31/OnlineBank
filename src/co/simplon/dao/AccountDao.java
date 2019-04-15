package co.simplon.dao;

import co.simplon.entities.Accounts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import co.simplon.entities.CompteCourant;
import co.simplon.entities.CompteEpargne;
public class AccountDao extends Dao<Accounts> {
	public Accounts afficheC(int id,String id2) {
		String strE = "select * from T_Accounts  inner join T_Users on T_Users.IdCust=T_Accounts.IdCust where NumCt=? and T_Users.nameUser=?";
		
		PreparedStatement ps;
		PreparedStatement ps1;
		Accounts Account = null;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(strE);
			ps.setInt(1,id);
			ps.setString(2, id2);
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()){
				if(resultSet.getString(4).contentEquals("epargne")) {
					Account= new CompteEpargne(resultSet.getInt(1),resultSet.getDate(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(7));	
					
			}else if(resultSet.getString(4).contentEquals("courant")) {
			
				
				Account= new CompteCourant(resultSet.getInt(1),resultSet.getDate(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(6));
			}
			}
		
		} catch (SQLException e) {
			System.out.println("not exist");
			//e.printStackTrace();
		}		
		return Account;
	}
	@Override
	public Accounts find(int id) {
		String strE = "select * from T_Accounts  inner join T_Users on T_Users.IdCust=T_Accounts.IdCust where NumCt=?";
		
		PreparedStatement ps;
		PreparedStatement ps1;
		Accounts Account = null;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(strE);
			ps.setInt(1,id);
			
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.next()){
				if(resultSet.getString(4).contentEquals("epargne")) {
				Account= new CompteEpargne(resultSet.getInt(1),resultSet.getDate(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(7));	
			}else if(resultSet.getString(4).contentEquals("courant")) {
			
				
				Account= new CompteCourant(resultSet.getInt(1),resultSet.getDate(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(6));
			}
			}
		
		} catch (SQLException e) {
			System.out.println("not exist");
			//e.printStackTrace();
		}		
		return Account;
	}

	@Override
	public boolean create(Accounts obj) {
		String str = "INSERT INTO T_Accounts (NumCt,Balance,IdCust) VALUES (?, ? ,? );";
		PreparedStatement ps;
		boolean ok = false;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getNumCt());
			ps.setDate(2, (java.sql.Date)obj.getDateCreation());
			ps.setDouble(2,obj.getBalance());
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
	public boolean update(Accounts obj) {		
		String str = " update T_Accounts set Balance=? where NumCt=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setDouble(1,obj.getBalance());
			ps.setInt(2,obj.getNumCt());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			System.out.println("not exist");
			//e.printStackTrace();
		}		
		return ok;
	}

	@Override
	public boolean delete(Accounts obj) {
		String str = "delete from T_Accounts where NumCpte=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try(Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword )) {
			ps = connection.prepareStatement(str);
			ps.setInt(1,obj.getNumCt());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			System.out.println("no exists");
			//	e.printStackTrace();
		}
		return ok;
	}
}