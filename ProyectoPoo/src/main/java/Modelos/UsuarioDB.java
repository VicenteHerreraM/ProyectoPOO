package Modelos;

import java.sql.Connection;
import java.util.ArrayList;
public interface UsuarioDB {
        ArrayList<Usuario>users=new ArrayList<Usuario>();
        public boolean CreateUser(Connection link, Usuario user);
        public void UpdateUser();
        public void DeleteUser();
        public ArrayList<Usuario> ReadUsers(Connection link);
        public Usuario FoundUser(Connection link, String rut);
}