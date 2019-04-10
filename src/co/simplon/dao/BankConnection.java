package co.simplon.dao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.servlet.ServletContext;
public class BankConnection { 
    private static Connection connection = null;
    
    private BankConnection() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/config.properties")){
            props.load(fis);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String url = props.getProperty("db.url");
        String log = props.getProperty("db.username");
        String pwd = props.getProperty("db.password");

        try {
            Class.forName(props.getProperty("db.driver"));
            connection = DriverManager.getConnection(url, log, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public static Connection getConnection() {
        if(connection == null) {
            new BankConnection();
        }
        return connection;
    }
}