package Modelos;

import java.sql.Connection;
import java.util.ArrayList;

public interface RoutineDB {
        ArrayList<Routine> ListRoutines=new ArrayList<>();
        public boolean CreateRoutine(Connection link, Routine rutina);
        public void UpdateRoutine(Connection link , Routine rutina , String idRutina);
        public void DeleteRoutine(Connection link,  Routine rutina , String idRutina);
        public ArrayList<Routine> ReadRoutines(Connection link);
        public Routine FoundRoutine(Connection link, String nombre);
}
