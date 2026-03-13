package persistencia;

import java.util.List;
import logica.Usuario;

public class ControladoraPersistencia {
    
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();

    public List<Usuario> traerUsuarios() {
    
        return usuarioJpa.findUsuarioEntities();
    }
    
}
