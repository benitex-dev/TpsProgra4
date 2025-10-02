package entidades;

public class Usuario {
	   private int id_usuario;
	   private String  usuario; 
	   private String contrasena;
	   
	public Usuario() {
		super();
	}
	public Usuario(int id_usuario, String usuario, String contrasena) {
		super();
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", usuario=" + usuario + ", contrasena=" + contrasena + "]";
	}
	
	   
}
