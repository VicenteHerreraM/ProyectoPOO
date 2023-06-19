package Modelos;

import java.sql.Connection;
import java.util.ArrayList;

public interface DietDB {
        public boolean CreateDiet(Connection link, Diet diet);
        public boolean UpdateDiet(Connection link  , Diet dieta);
        public boolean DeleteDiet(Connection link ,Diet dieta );
        public ArrayList<Diet> ReadDiets(Connection link);
        public Diet FoundDiet(Connection link, String nombre);
}
