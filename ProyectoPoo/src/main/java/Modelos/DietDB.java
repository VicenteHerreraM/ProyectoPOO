package Modelos;

import java.sql.Connection;
import java.util.ArrayList;

public interface DietDB {
        ArrayList<Diet> dietList=new ArrayList<>();
        public boolean CreateDiet(Connection link, Diet diet);
        public void UpdateDiet();
        public void DeleteDiet();
        public ArrayList<Diet> ReadDiets(Connection link);
        public Diet FoundDiet(Connection link, String nombre);
}