package Interfaces;

import proyectopoo.Rutina;

import java.sql.Connection;
import java.util.ArrayList;

public interface RutinaDB {
        ArrayList<Rutina> ListaCliente=new ArrayList<>();
        public boolean Crear(Connection link, Rutina rutina);
        public void Actualizar();
        public void Eliminar();
        public ArrayList<Rutina> Leer(Connection link);
        public Rutina Buscar(Connection link, Integer ID_Rutina);
}
