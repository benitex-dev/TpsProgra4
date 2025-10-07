package interfaces;

import entidades.Usuario;

public interface IDaoUsuario {
	
	public Usuario obtenerUsuario(String nombreUsuario, String contrasena);

}
