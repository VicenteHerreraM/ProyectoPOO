package Interfaces;

import proyectopoo.Dieta;
import proyectopoo.Usuario;

import java.sql.Connection;
import java.util.ArrayList;

public interface DietaDB {
        ArrayList<Dieta> ListaDieta=new ArrayList<>();
        public boolean Crear(Connection link, Dieta dieta);
        public void Actualizar();
        public void Eliminar();
        public ArrayList<Dieta> Leer(Connection link);
        public Usuario Buscar(Connection link, Integer ID_Dieta);
}
