package Modelos;

import java.sql.Connection;
import java.util.ArrayList;

public interface RoutineDB {
        ArrayList<Routine> ListRoutines=new ArrayList<>();
        public boolean CreateRoutine(Connection link, Routine rutina);
        public boolean UpdateRoutine(Connection link , Routine rutina);
        public boolean DeleteRoutine(Connection link,  Routine rutina);
        public ArrayList<Routine> ReadRoutines(Connection link);
        public Routine FoundRoutine(Connection link, String nombre);
}
