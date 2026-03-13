package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {
    ControladoraPersistencia controlPersis;
    
    public Controladora(){
        controlPersis = new ControladoraPersistencia();
    }

    public Usuario validarUsuario(String usuario, String contrasenia) {
    
        Usuario usuarioValidado = null;
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        
        for(Usuario usu : listaUsuarios){
            if (usu.getNombreUsuario().equals(usuario)) {
                if (usu.getContrasenia().equals(contrasenia)) {
                    
                    usuarioValidado = usu;
                    return usuarioValidado;
                
                } else {
                    return usuarioValidado;
                }
                
            }
        }
        
        return usuarioValidado;
    }
}
