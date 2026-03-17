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

    public List<Usuario> traerUsuarios() {    
        return controlPersis.traerUsuarios();
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String usuario, String contra, String rolSelec) {
    
        Usuario nuevoUser = new Usuario();
        nuevoUser.setNombreUsuario(usuario);
        nuevoUser.setContrasenia(contra);
        
        Rol rol = new Rol();
        rol = this.traerRol(rolSelec);
        if (rol != null) {
            nuevoUser.setUnRol(rol);
        }
        
        controlPersis.crearUsuario(nuevoUser);
    }

    private Rol traerRol(String rolSelec) {

        List<Rol> listaRoles = controlPersis.traerRoles();
        
        for(Rol rol : listaRoles) {
            if (rol.getNombreRol().equals(rolSelec)) {
                return rol;
            }
        }
        return null;
    }

    public void eliminarUsuario(int id_user) {

        controlPersis.eliminarUsuario(id_user);
    }

    public Usuario traerUsuario(int id_usuario) {
        
        return controlPersis.traerUsuario(id_usuario);
    }

    public void editarUsuario(Usuario user, String nombreUsuario, String contra, String rolSelec) {

        user.setNombreUsuario(nombreUsuario);
        user.setContrasenia(contra);
        
        Rol rol = new Rol();
        rol = this.traerRol(rolSelec);
        if (rol != null) {
            user.setUnRol(rol);
        }
        
        controlPersis.editarUsuario(user);
    }
}
