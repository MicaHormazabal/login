package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Rol;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();

    public List<Usuario> traerUsuarios() {
    
        return usuarioJpa.findUsuarioEntities();
    }

    public List<Rol> traerRoles() {
    
        return rolJpa.findRolEntities();
    }

    public void crearUsuario(Usuario nuevoUser) {
    
        usuarioJpa.create(nuevoUser);
    }

    public void eliminarUsuario(int id_user) {

        try {
            usuarioJpa.destroy(id_user);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id_usuario) {
    
        return usuarioJpa.findUsuario(id_usuario);
    }

    public void editarUsuario(Usuario user) {

        try {
            usuarioJpa.edit(user);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
