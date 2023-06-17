package Controladores;

import Modelos.Routine;
import Modelos.RoutineDB;
import Operaciones.ConnectionToDB;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.*;
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
            String json = gson.toJson(routine.getTypeRoutine());
            PreparedStatement ps = link.prepareStatement("INSERT INTO rutina(Nombre, Ejercicio) VALUES (?,?)");
            ps.setString(1, routine.getNameRoutines());
            ps.setString(2, json);
            ps.execute();
            return true;
        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }
        return false;
    }

    @Override
    public void UpdateRoutine(Connection link , Routine rutina, String idUpdate) {
        try{
            Gson gson = new Gson();
            String json = gson.toJson(rutina.getTypeRoutine());
            PreparedStatement ps = link.prepareStatement("UPDATE rutina SET(Nombre = ?, Ejercicio = ?) WHERE idUpdate = ?");
            ps.setString(1, rutina.getNameRoutines());
            ps.setString(2, json);
            ps.setString(3, idUpdate);
            
            ps.execute();
        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }
    }

    @Override
    public void DeleteRoutine(Connection link , Routine rutina , String idDelete) {
        try{
            PreparedStatement ps = link.prepareStatement("DELETE rutina FROM idDelete = ?");
            ps.setString(1, idDelete);
            ps.execute();
        }catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }
    }

    @Override
    public ArrayList<Routine> ReadRoutines(Connection link) {

        Gson gson=new Gson();
        try {
            Type type = new TypeToken<ArrayList<String>>() {}.getType();

            // CREAMOS CONEXIÓN A LA BASE DE DATOS
            Statement state = link.createStatement();

            // LE DECIMOS QUÉ QUEREMOS LEER (TABLA DIETA)
            query = "SELECT * FROM rutina ORDER BY Nombre_Rutina ASC";
            ListRoutines.clear();
            //GUARDAMOS EL RESULADO DE LA CONSULTA EN "RESULTSELECT"
            ResultSet resultSelect = state.executeQuery(query);

            // LEEMOS HASTA QUE ENCONTREMOS UN NULL EN LA FILA
            while (resultSelect.next()) {
                Routine routineRead = new Routine();
                // VAMOS ASIGNANDOLES VALORES A NUESTRA DIETA DEL PROGRAMA (PROVIENE DE LA DB(
                routineRead.setIdRoutines(resultSelect.getInt("ID_Rutina"));
                routineRead.setNameRoutines(resultSelect.getString("Nombre_Rutina"));
                routineRead.setTypeRoutine(gson.fromJson(resultSelect.getString("Ejercicio"), type));

                // AGREGAMOS A NUESTRO ARREGLO DE USUARIOS EL CLIENTE SACADO DEL DB
                ListRoutines.add(routineRead);

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
            query="SELECT * FROM rutina WHERE Nombre_Rutina='"+nombre+"'";
            ResultSet resultSets=state.executeQuery(query);
            // RESULTADOS
            while (resultSets.next()){

                // VAMOS ASIGNANDOLES VALORES A NUESTRO CLIENTE DEL PROGRAMA (PROVIENE DE LA DB(
                routine.setIdRoutines(resultSets.getInt("ID_Rutina"));
                routine.setNameRoutines(resultSets.getString("Nombre_Rutina"));
                routine.setTypeRoutine(gson.fromJson(resultSets.getString("Ejercicio"), type));
            }
            return routine;
        } catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }

        return null;
    }

    public Routine FoundRoutineWithID(Connection link, int ID) {
        Routine routine=new Routine();
        try {
            Type type = new TypeToken<ArrayList<String>>() {}.getType();
            Gson gson=new Gson();
            // SE HACE LA CONEXIÓN A LA BASE DE DATOS
            Statement state = link.createStatement();
            // HACEMOS LA CONSULTA A LA BASE DE DATOS
            query="SELECT * FROM rutina WHERE ID_Rutina='"+ID+"'";
            ResultSet resultSets=state.executeQuery(query);
            // RESULTADOS
            while (resultSets.next()){

                // VAMOS ASIGNANDOLES VALORES A NUESTRO CLIENTE DEL PROGRAMA (PROVIENE DE LA DB(
                routine.setIdRoutines(resultSets.getInt("ID_Rutina"));
                routine.setNameRoutines(resultSets.getString("Nombre_Rutina"));
                routine.setTypeRoutine(gson.fromJson(resultSets.getString("Ejercicio"), type));
            }
            return routine;
        } catch (SQLException sqlExcept) {
            Logger.getLogger(ConnectionToDB.class.getName()).log(Level.SEVERE, null, sqlExcept);
        }

        return null;
    }
}
