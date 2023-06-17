package Controladores;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.DietDB;
import Modelos.Diet;
import Operaciones.ConnectionToDB;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class DietToDB implements DietDB {
    // QUERY ES LA FUNCIÓN CON LA QUE HACEMOS CONSULTA A LA BASE DE DATOS
    public String query;

    @Override
    public boolean CreateDiet(Connection link, Diet diet) {
        try{
            Gson gson = new Gson();
            String json = gson.toJson(diet.getTypeRoutine());
            PreparedStatement ps = link.prepareStatement("INSERT INTO dieta(Nombre, Comida) VALUES (?,?)");
            ps.setString(1, diet.getNameRoutines());
            ps.setString(2, json);
            ps.execute();
            return true;
        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }
        return false;
    }
    
    public int contarDietas(Connection link , String nombreDieta) throws SQLException{
        int cont = 0;
        
        Statement state = link.createStatement();

            // LE DECIMOS QUÉ QUEREMOS LEER (TABLA CLIENTE)
            query = "SELECT COUNT(*) FROM dieta WHERE Nombre = '"+nombreDieta+"' ";

            //GUARDAMOS EL RESULTADO DE LA CONSULTA EN "RESULTSELECT"
            ResultSet resultSelect = state.executeQuery(query);
        if (resultSelect.next()){
            cont = resultSelect.getInt(1);
            return cont;
        }
        
        
        

        return cont;
    }
    
    
    @Override    
    public boolean UpdateDiet(Connection link  , Diet dieta) {
        try{
            Gson gson = new Gson();
            String json = gson.toJson(dieta.getTypeRoutine());
            PreparedStatement ps = link.prepareStatement("UPDATE dieta SET Comida=? WHERE Nombre = ? ");
            ps.setString(1, json);
            ps.setString(2, dieta.getNameRoutines() ); //Quizas esta linea esta demás.
            ps.execute();
            return true;
        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
            return false;
        }
        
    }

    @Override
    public boolean DeleteDiet(Connection link ,Diet dieta) {
        try{
            PreparedStatement ps = link.prepareStatement("DELETE FROM dieta WHERE Nombre = ? ");
            ps.setString(1, dieta.getNameRoutines());
            ps.execute();
            return true;
        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
            return false;
        }
    }

    
    @Override
    public ArrayList<Diet> ReadDiets(Connection link) {
        Gson gson=new Gson();
        ArrayList <Diet> dietasLeer = new ArrayList<>();
        try {
            Type type = new TypeToken<ArrayList<String>>() {}.getType();

            // CREAMOS CONEXIÓN A LA BASE DE DATOS
            Statement state = link.createStatement();

            // LE DECIMOS QUÉ QUEREMOS LEER (TABLA DIETA)
            query = "SELECT * FROM dieta ORDER BY Nombre ASC";

            //GUARDAMOS EL RESULADO DE LA CONSULTA EN "RESULTSELECT"
            ResultSet resultSelect = state.executeQuery(query);

            // LEEMOS HASTA QUE ENCONTREMOS UN NULL EN LA FILA
            while (resultSelect.next()) {
                Diet diet=new Diet();
                // VAMOS ASIGNANDOLES VALORES A NUESTRA DIETA DEL PROGRAMA (PROVIENE DE LA DB(
                diet.setIdRoutines(resultSelect.getInt("ID_Dieta"));
                diet.setNameRoutines(resultSelect.getString("Nombre"));
                diet.setTypeRoutine(gson.fromJson(resultSelect.getString("Comida"), type));

                // AGREGAMOS A NUESTRO ARREGLO DE USUARIOS EL CLIENTE SACADO DEL DB
                dietasLeer.add(diet);

            }

            // RETORNAMOS LA LISTA DE DIETAS QUE SE GENERÓ
            return dietasLeer;
        }catch (SQLException sqlError){
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlError);
            return null;
        }
    }

    @Override
    public Diet FoundDiet(Connection link, String nombre) {
        try {
            Diet diet=new Diet();
            Type type = new TypeToken<ArrayList<String>>() {}.getType();
            Gson gson=new Gson();
            // SE HACE LA CONEXIÓN A LA BASE DE DATOS
            Statement state = link.createStatement();
            // HACEMOS LA CONSULTA A LA BASE DE DATOS
            query="SELECT * FROM dieta WHERE Nombre='"+nombre+"'";
            ResultSet resultSets=state.executeQuery(query);
            // RESULTADOS
            while (resultSets.next()){
                // VAMOS ASIGNANDOLES VALORES A NUESTRO CLIENTE DEL PROGRAMA (PROVIENE DE LA DB(
                diet.setIdRoutines(resultSets.getInt("ID_Dieta"));
                diet.setNameRoutines(resultSets.getString("Nombre"));
                diet.setTypeRoutine(gson.fromJson(resultSets.getString("Comida"), type));
            }
            return diet;
        } catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
            return null;

        }

    }

    public Diet FoundDietWithID(Connection link, int id) {
        Diet diet=new Diet();
        try {
            Type type = new TypeToken<ArrayList<String>>() {}.getType();
            Gson gson=new Gson();
            // SE HACE LA CONEXIÓN A LA BASE DE DATOS
            Statement state = link.createStatement();
            // HACEMOS LA CONSULTA A LA BASE DE DATOS
            query="SELECT * FROM dieta WHERE ID_Dieta='"+id+"'";
            ResultSet resultSets=state.executeQuery(query);
            // RESULTADOS
            while (resultSets.next()){
                // VAMOS ASIGNANDOLES VALORES A NUESTRO CLIENTE DEL PROGRAMA (PROVIENE DE LA DB(
                diet.setIdRoutines(resultSets.getInt("ID_Dieta"));
                diet.setNameRoutines(resultSets.getString("Nombre"));
                diet.setTypeRoutine(gson.fromJson(resultSets.getString("Comida"), type));
            }
            return diet;
        } catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }

        return null;
    }





}

