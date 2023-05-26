package Operaciones;
import java.sql.*;
public class dbConection {
    private String dbURL = "jdbc:mysql://localhost:3306/cboom";
    private String username = "root";
    private String password = "root";
    private Connection dbconnection;
    public dbConection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            dbconnection = DriverManager.getConnection(dbURL,username,password);
            if(dbconnection!=null){

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
