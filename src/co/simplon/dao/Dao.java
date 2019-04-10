package co.simplon.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
import javax.servlet.ServletContext;

/** 
 * Application de gestion bancaire, partie DAO
 * @version 1.0
 * @author El babili
 */

public abstract class Dao<T> {
	protected static String dbURL;
	protected static String dbLogin;
	protected static String dbPassword;
	public static void init( ServletContext context ) {
		try {
			
			Class.forName( context.getInitParameter( "JDBC_DRIVER" ) );
			dbURL = context.getInitParameter( "JDBC_URL" );
			dbLogin = context.getInitParameter( "JDBC_LOGIN" );
			dbPassword = context.getInitParameter( "JDBC_PASSWORD" );
			
		} catch( Exception exception ) {
			
			exception.printStackTrace();
			
		}
	}

	//public Connection connection = BankConnection.getConnection();
	
	/**
	 * Permet de récupérer un objet via son ID
	 * @param id
	 * @return T
	 */
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 * @return boolean
	 */
	public  abstract T find(int id);
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean create(T obj);
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean update(T obj);
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 * @return boolean
	 */
	public abstract boolean delete(T obj);
}