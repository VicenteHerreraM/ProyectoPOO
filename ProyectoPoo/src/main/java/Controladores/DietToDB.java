package Controladores;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.DietDB;
import Modelos.Diet;
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
            Statement state = link.createStatement();
            String json = gson.toJson(diet.getTypeRoutine());
            query="insert into dieta(ID_Dieta,Nombre,Comida)values(NULL, "+diet.getNameRoutines()+"','"+json+"')";
            state.executeUpdate(query);
            return true;
        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }
        return false;
    }

    @Override
    public void UpdateDiet() {

    }

    @Override
    public void DeleteDiet() {

    }

    @Override
    public ArrayList<Diet> ReadDiets(Connection link) {
        Diet diet=new Diet();
        Gson gson=new Gson();
        try {
            Type type = new TypeToken<ArrayList<String>>() {}.getType();

            // CREAMOS CONEXIÓN A LA BASE DE DATOS
            Statement state = link.createStatement();

            // LE DECIMOS QUÉ QUEREMOS LEER (TABLA DIETA)
            query = "select * from dieta";

            //GUARDAMOS EL RESULADO DE LA CONSULTA EN "RESULTSELECT"
            ResultSet resultSelect = state.executeQuery(query);

            // LEEMOS HASTA QUE ENCONTREMOS UN NULL EN LA FILA
            while (resultSelect.next()) {

                // VAMOS ASIGNANDOLES VALORES A NUESTRA DIETA DEL PROGRAMA (PROVIENE DE LA DB(
                diet.setIdRoutines(resultSelect.getInt("ID_Dieta"));
                diet.setNameRoutines(resultSelect.getString("Nombre"));
                diet.setTypeRoutine(gson.fromJson(resultSelect.getString("Comida"), type));

                // AGREGAMOS A NUESTRO ARREGLO DE USUARIOS EL CLIENTE SACADO DEL DB
                dietList.add(diet);

            }

            // RETORNAMOS LA LISTA DE DIETAS QUE SE GENERÓ
            return dietList;
        }catch (SQLException sqlError){
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlError);
            return null;
        }
    }

    @Override
    public Diet FoundDiet(Connection link, String nombre) {
        Diet diet=new Diet();
        try {
            Type type = new TypeToken<ArrayList<String>>() {}.getType();
            Gson gson=new Gson();
            // SE HACE LA CONEXIÓN A LA BASE DE DATOS
            Statement state = link.createStatement();
            // HACEMOS LA CONSULTA A LA BASE DE DATOS
            query="select * from dieta where Nombre='"+nombre+"'";
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
