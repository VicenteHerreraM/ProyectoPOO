package Modelos;

import java.sql.Connection;
import java.util.ArrayList;
public interface UsuarioDB {
        ArrayList<Usuario>users=new ArrayList<Usuario>();
        public boolean CreateUser(Connection link, Usuario user);
        public boolean UpdateUser(Connection link, Usuario user);
        public void DeleteUser(Connection link, Usuario user);
        public ArrayList<Usuario> PrintUsers(Connection link);
        public Usuario FoundUser(Connection link, String rut);
        public boolean ReadUser(Connection link, String txtUser, String txtPass);
}
