package persistencia;

import java.util.List;
import logica.Rol;
import logica.Usuario;

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
    
}
