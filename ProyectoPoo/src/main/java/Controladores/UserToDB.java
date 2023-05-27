package Controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.UsuarioDB;
import Modelos.Usuario;
import java.util.ArrayList;

public class UserToDB implements UsuarioDB{
    // QUERY ES LA FUNCIÓN CON LA QUE HACEMOS CONSULTA A LA BASE DE DATOS
    public String query;

    @Override
    public boolean CreateUser(Connection link, Usuario user) {
        try{
            Statement state = link.createStatement();
            query="insert into cliente(RUT,Nombre,Apellido,Altura,Peso,Contraseña,Correo,FechaNac,dietaCliente,rutinaCliente)values" +
                    "('"+user.getRut()+"','"+user.getName()+"','"+user.getLastName()+"','"+user.getHeight()+"','"+user.getWeight()+
                    "','"+user.getPassword()+"','"+user.getMail()+"','"+user.getBirthdate()+"','"+user.getTypeDiet()+"','"+user.getTypeRoutine()+"')";
            state.executeUpdate(query);
            return true;

        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }
        return false;
    }

    @Override
    public void UpdateUser() {

    }

    @Override
    public void DeleteUser() {

    }

    @Override
    public ArrayList<Usuario> ReadUsers(Connection link) {
        Usuario user=new Usuario();
        try {

            // CREAMOS CONEXIÓN A LA BASE DE DATOS
            Statement state = link.createStatement();

            // LE DECIMOS QUÉ QUEREMOS LEER (TABLA CLIENTE)
            query = "select * from cliente";

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
            query="select * from cliente where RUT='"+rut+"'";
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
}
