package Modelos;

import java.sql.Connection;
import java.util.ArrayList;

public interface RoutineDB {
        ArrayList<Routine> ListRoutines=new ArrayList<>();
        public boolean CreateRoutine(Connection link, Routine rutina);
        public void UpdateRoutine(Connection link);
        public void DeleteRoutine(Connection link);
        public ArrayList<Routine> ReadRoutines(Connection link);
        public Routine FoundRoutine(Connection link, String nombre);
}
