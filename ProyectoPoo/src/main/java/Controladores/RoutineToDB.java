package Controladores;

import Modelos.Routine;
import Modelos.RoutineDB;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoutineToDB implements RoutineDB {
    // QUERY ES LA FUNCIÓN CON LA QUE HACEMOS CONSULTA A LA BASE DE DATOS
    public String query;

    @Override
    public boolean CreateRoutine(Connection link, Routine routine) {
        try{
            Gson gson = new Gson();
            Statement state = link.createStatement();
            String json = gson.toJson(routine.getTypeRoutine());
            query="INSERT INTO rutina(ID_Rutina,Nombre_Rutina,Ejercicio)values(NULL, "+routine.getNameRoutines()+"','"+json+"')";
            state.executeUpdate(query);
            return true;
        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }
        return false;
    }

    @Override
    public void UpdateRoutine() {

    }

    @Override
    public void DeleteRoutine() {

    }

    @Override
    public ArrayList<Routine> ReadRoutines(Connection link) {
        Routine routine=new Routine();
        Gson gson=new Gson();
        try {
            Type type = new TypeToken<ArrayList<String>>() {}.getType();

            // CREAMOS CONEXIÓN A LA BASE DE DATOS
            Statement state = link.createStatement();

            // LE DECIMOS QUÉ QUEREMOS LEER (TABLA DIETA)
            query = "select * from rutina";

            //GUARDAMOS EL RESULADO DE LA CONSULTA EN "RESULTSELECT"
            ResultSet resultSelect = state.executeQuery(query);

            // LEEMOS HASTA QUE ENCONTREMOS UN NULL EN LA FILA
            while (resultSelect.next()) {

                // VAMOS ASIGNANDOLES VALORES A NUESTRA DIETA DEL PROGRAMA (PROVIENE DE LA DB(
                routine.setIdRoutines(resultSelect.getInt("ID_Rutina"));
                routine.setNameRoutines(resultSelect.getString("Nombre_Rutina"));
                routine.setTypeRoutine(gson.fromJson(resultSelect.getString("Ejercicio"), type));

                // AGREGAMOS A NUESTRO ARREGLO DE USUARIOS EL CLIENTE SACADO DEL DB
                ListRoutines.add(routine);

            }

            // RETORNAMOS LA LISTA DE DIETAS QUE SE GENERÓ
            return ListRoutines;
        }catch (SQLException sqlError){
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlError);
            return null;
        }
    }

    @Override
    public Routine FoundRoutine(Connection link, String nombre) {
        Routine routine=new Routine();
        try {
            Type type = new TypeToken<ArrayList<String>>() {}.getType();
            Gson gson=new Gson();
            // SE HACE LA CONEXIÓN A LA BASE DE DATOS
            Statement state = link.createStatement();
            // HACEMOS LA CONSULTA A LA BASE DE DATOS
            query="select * from rutina where Nombre='"+nombre+"'";
            ResultSet resultSets=state.executeQuery(query);
            // RESULTADOS
            while (resultSets.next()){
                // VAMOS ASIGNANDOLES VALORES A NUESTRO CLIENTE DEL PROGRAMA (PROVIENE DE LA DB(
                routine.setIdRoutines(resultSets.getInt("ID_Dieta"));
                routine.setNameRoutines(resultSets.getString("Nombre"));
                routine.setTypeRoutine(gson.fromJson(resultSets.getString("Comida"), type));
            }
            return routine;
        } catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }

        return null;
    }
}
