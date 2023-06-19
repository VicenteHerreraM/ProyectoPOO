package Controladores;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.UsuarioDB;
import Modelos.Usuario;
import Operaciones.ConnectionToDB;
import java.sql.Connection;

import java.util.ArrayList;

public class UserToDB implements UsuarioDB{
    // QUERY ES LA FUNCIÓN CON LA QUE HACEMOS CONSULTA A LA BASE DE DATOS
    public String query;

    @Override
    public boolean CreateUser(Connection link, Usuario user) {
        try{
            PreparedStatement ps = link.prepareStatement("INSERT INTO cliente(RUT,Nombre,Apellido,Altura,Peso,Contrasenya,Correo,FechaNac,dietaCliente,rutinaCliente) VALUES (?,UPPER(?),UPPER(?),?,?,?,?,?,?,?)");
            ps.setString(1, user.getRut());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLastName());
            ps.setInt(4, user.getHeight());
            ps.setDouble(5, user.getWeight());
            ps.setString(6, user.getPassword());
            ps.setString(7,  user.getMail());
            java.sql.Date sqlDate = new java.sql.Date (user.getBirthdate().getTime());
            ps.setDate(8, sqlDate);
            ps.setInt(9, user.getTypeDiet());
            ps.setInt(10, user.getTypeRoutine());
            ps.execute();
            return true;

        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }
        return false;
    }

 
    @Override
    public boolean UpdateUser(Connection link, Usuario user) {
        try{
            PreparedStatement ps = link.prepareStatement("UPDATE cliente SET Nombre = ?,Apellido = ?,Altura = ?,Peso = ?,Contrasenya = ?,Correo = ?,FechaNac = ?,dietaCliente = ?,rutinaCliente = ? WHERE RUT = '"+user.getRut()+"'");
            
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setInt(3, user.getHeight());
            ps.setDouble(4, user.getWeight());
            ps.setString(5, user.getPassword());
            ps.setString(6,  user.getMail());
            java.sql.Date sqlDate = new java.sql.Date (user.getBirthdate().getTime());
            ps.setDate(7, sqlDate);
            ps.setInt(8, user.getTypeDiet());
            ps.setInt(9, user.getTypeRoutine());
            ps.execute();
            return true;
        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
            return false;
        }
    }


    @Override
    public void DeleteUser(Connection link, Usuario user) {
        try{
            PreparedStatement ps = link.prepareStatement("DELETE FROM cliente WHERE RUT= ?");
            ps.setString(1, user.getRut());
            ps.execute();

        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }
    }

    @Override
    public ArrayList<Usuario> PrintUsers(Connection link) {
        ArrayList<Usuario>usuariosLeer = new ArrayList<>();

        try {

            // CREAMOS CONEXIÓN A LA BASE DE DATOS
            Statement state = link.createStatement();

            // LE DECIMOS QUÉ QUEREMOS LEER (TABLA CLIENTE)
            query = "SELECT * FROM `cliente`";

            //GUARDAMOS EL RESULTADO DE LA CONSULTA EN "RESULTSELECT"
            ResultSet resultSelect = state.executeQuery(query);

            // LEEMOS HASTA QUE ENCONTREMOS UN NULL EN LA FILA
            while (resultSelect.next()) {
                Usuario user=new Usuario();
                // VAMOS ASIGNANDOLES VALORES A NUESTRO CLIENTE DEL PROGRAMA (PROVIENE DE LA DB(
                user.setRut(resultSelect.getString("RUT"));
                user.setName(resultSelect.getString("Nombre"));
                user.setLastName(resultSelect.getString("Apellido"));
                user.setHeight(resultSelect.getInt("Altura"));
                user.setWeight(resultSelect.getDouble("Peso"));
                user.setPassword(resultSelect.getString("Contrasenya"));
                user.setMail(resultSelect.getString("Correo"));
                user.setBirthdate(resultSelect.getDate("FechaNac"));
                user.setTypeDiet(resultSelect.getInt("dietaCliente"));
                user.setTypeRoutine(resultSelect.getInt("rutinaCliente"));

                // AGREGAMOS A NUESTRO ARREGLO DE USUARIOS EL CLIENTE SACADO DEL DB
                usuariosLeer.add(user);
            }

            // RETORNAMOS LA LISTA DE USUARIOS QUE SE GENERÓ
            return usuariosLeer;
        }catch (SQLException sqlError){
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlError);
            return usuariosLeer;
        }
    }

    @Override
    public Usuario FoundUser(Connection link, String rut) {
        Usuario user=new Usuario();
        try {
            Statement state = link.createStatement();
            query="SELECT * FROM cliente WHERE RUT='"+rut+"'";
            ResultSet resultSets=state.executeQuery(query);



            while (resultSets.next()){
                // VAMOS ASIGNANDOLES VALORES A NUESTRO CLIENTE DEL PROGRAMA (PROVIENE DE LA DB(
                user.setRut(resultSets.getString("RUT"));
                user.setName(resultSets.getString("Nombre"));
                user.setLastName(resultSets.getString("Apellido"));
                user.setHeight(resultSets.getInt("Altura"));
                user.setWeight(resultSets.getFloat("Peso"));
                user.setPassword(resultSets.getString("Contrasenya"));
                user.setMail(resultSets.getString("Correo"));
                user.setBirthdate(resultSets.getDate("FechaNac"));
                user.setTypeDiet(resultSets.getInt("dietaCliente"));
                user.setTypeRoutine(resultSets.getInt("rutinaCliente"));
            }
            return user;
        } catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }

        return null;
    }
    
    @Override
    public boolean ReadUser(Connection link, String txtUser, String txtPass){
        int count=0;
        try {
            Statement s = link.createStatement();
            query="SELECT * FROM cliente WHERE RUT='"+txtUser+"' AND Contrasenya='"+txtPass+"'";
            ResultSet rs=s.executeQuery(query);
  
            while (rs.next()){
                count++;
            }
            if(count>0) return true;
  
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
