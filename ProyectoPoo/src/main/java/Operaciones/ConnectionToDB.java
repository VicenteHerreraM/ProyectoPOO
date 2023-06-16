package Operaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ConnectionToDB {
    private String dataBase;
    private String URL;
    private String userLog;
    private String passwordLog;
    private Connection link;

    public ConnectionToDB(){
        //NOMBRE DE NUESTRA BASE DE DATOS
        this.dataBase="cboom";
        // URL DE NUESTRA BASE DE DATOS
        this.URL = "jdbc:mysql://localhost/" + dataBase;
        // USUARIO CON EL QUE  ACCEDEMOS A LA BASE DE DATOS
        this.userLog="root";
        // NO EXISTE CONTRASEÑA PARA INGRESAR A LA BASE DE DATOS
        this.passwordLog="";
        // INSTANCIAMOS EL LINK QUE SE CONECTARÁ A LA BASE DE DATOS COMO NULL
        this.link=null;

    }

    /**
    *       F(X) CONNECT: NOS CONECTARÁ A LA  BASE DE DATOS
    */

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            link = DriverManager.getConnection(this.URL, this.userLog, this.passwordLog);
            System.out.println("""
                    .....................................................
                    :                                                   :
                    :   ¡ESTABLECIENDO CONEXION A LA BASE DE DATOS!     :
                    :                                                   :
                    .....................................................
                    """);

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception);
        }

        return link;
    }

    /**
     *
     * */
    public void closeConnection(){
        try{
            link.close();
        }catch (SQLException sqlExcept){
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }
    }
}
