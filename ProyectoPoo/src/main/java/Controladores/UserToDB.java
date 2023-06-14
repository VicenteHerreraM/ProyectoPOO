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
            PreparedStatement ps = link.prepareStatement("INSERT INTO cliente(RUT,Nombre,Apellido,Altura,Peso,Contraseña,Correo,FechaNac,dietaCliente,rutinaCliente) VALUES (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, user.getRut());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLastName());
            ps.setFloat(4, user.getHeight());
            ps.setFloat(5, user.getWeight());
            ps.setString(6, user.getPassword());
            ps.setString(7,  user.getMail());
            ps.setDate(8, (Date) user.getBirthdate());
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
    public void UpdateUser(Connection link, Usuario user , String rutUpdate) {
        try{
            PreparedStatement ps = link.prepareStatement("UPDATE cliente SET(RUT = ?,Nombre = ?,Apellido = ?,Altura = ?,Peso = ?,Contraseña = ?,Correo = ?,FechaNac = ?,dietaCliente = ?,rutinaCliente = ?) WHERE rutUpdate = ?");
            ps.setString(1, user.getRut());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLastName());
            ps.setFloat(4, user.getHeight());
            ps.setFloat(5, user.getWeight());
            ps.setString(6, user.getPassword());
            ps.setString(7,  user.getMail());
            ps.setDate(8, (Date) user.getBirthdate());
            ps.setInt(9, user.getTypeDiet());
            ps.setInt(10, user.getTypeRoutine());
            ps.execute();

        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }
    }

    @Override
    public void DeleteUser(Connection link, Usuario user , String rutDelete) {
        try{
            PreparedStatement ps = link.prepareStatement("DELETE cliente FROM rutDelete= ?");
            ps.setString(1, rutDelete);
            ps.execute();

        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }
    }

    @Override
    public ArrayList<Usuario> PrintUsers(Connection link) {
        Usuario user=new Usuario();
        try {

            // CREAMOS CONEXIÓN A LA BASE DE DATOS
            Statement state = link.createStatement();

            // LE DECIMOS QUÉ QUEREMOS LEER (TABLA CLIENTE)
            query = "SELECT * FROM cliente";

            //GUARDAMOS EL RESULADO DE LA CONSULTA EN "RESULTSELECT"
            ResultSet resultSelect = state.executeQuery(query);

            // LEEMOS HASTA QUE ENCONTREMOS UN NULL EN LA FILA
            while (resultSelect.next()) {

                // VAMOS ASIGNANDOLES VALORES A NUESTRO CLIENTE DEL PROGRAMA (PROVIENE DE LA DB(
                user.setRut(resultSelect.getString("RUT"));
                user.setName(resultSelect.getString("Nombre"));
                user.setLastName(resultSelect.getString("Apellido"));
                user.setHeight(resultSelect.getInt("Altura"));
                user.setWeight(resultSelect.getFloat("Peso"));
                user.setPassword(resultSelect.getString("Contraseña"));
                user.setMail(resultSelect.getString("Correo"));
                user.setBirthdate(resultSelect.getDate("FechaNac"));
                user.setTypeDiet(resultSelect.getInt("dietaCliente"));
                user.setTypeRoutine(resultSelect.getInt("rutinaCliente"));

                // AGREGAMOS A NUESTRO ARREGLO DE USUARIOS EL CLIENTE SACADO DEL DB
                users.add(user);

            }

            // RETORNAMOS LA LISTA DE USUARIOS QUE SE GENERÓ
            return users;
        }catch (SQLException sqlError){
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlError);
            return null;
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
                user.setPassword(resultSets.getString("Contraseña"));
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
            query="SELECT * FROM cliente WHERE RUT='"+txtUser+"' AND Contraseña='"+txtPass+"'";
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
