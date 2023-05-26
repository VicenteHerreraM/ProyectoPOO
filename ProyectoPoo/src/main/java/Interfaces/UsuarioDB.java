package Interfaces;

import proyectopoo.Usuario;

import java.sql.Connection;
import java.util.ArrayList;
public interface UsuarioDB {
        ArrayList<Usuario>ListaUsuario=new ArrayList<>();
        public boolean Crear(Connection link, Usuario user);
        public void Actualizar();
        public void Eliminar();
        public ArrayList<Usuario> Leer(Connection link);
        public Usuario Buscar(Connection link, String rut);
}
