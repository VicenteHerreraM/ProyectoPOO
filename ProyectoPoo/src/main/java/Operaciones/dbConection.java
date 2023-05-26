package Operaciones;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbConection {
    private String dbURL = "jdbc:mysql://localhost:3306/cboom";
    private String username = "root";
    private String password = "root";
    private Connection dbconnection;
    public Connection connectionDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            dbconnection = DriverManager.getConnection(dbURL,username,password);
            if(dbconnection!=null){

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dbconnection;
    }
    public void closeConnectionDB(){
        try {
            dbconnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(dbConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
