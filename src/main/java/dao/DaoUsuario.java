package dao;

import entidades.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoUsuario {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "sistema_clientes";
	
	
	public Usuario obtenerUsuario(String nombreUsuario, String contrasena) {
		
		Usuario usuario = null;
		Connection cn = null;
		
		try
		{
			 Class.forName("com.mysql.jdbc.Driver"); 
			String query = "SELECT id_usuario, usuario, contrasena FROM usuarios WHERE usuario = ? AND contrasena = ?";
			
			cn = DriverManager.getConnection(host+dbName, user, pass);
			PreparedStatement pst = cn.prepareStatement(query);
			pst.setString(1, nombreUsuario);
			pst.setString(2, contrasena);
			
			ResultSet rs = pst.executeQuery();
			
			
			if(rs.next())
			{
				usuario = new Usuario();
				usuario.setId_usuario(rs.getInt("id_usuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setContrasena(rs.getString("contrasena"));
				System.out.println("Usuario encontrado: " + usuario.getUsuario());
			}
			else {
			    System.out.println("No se encontró usuario en la BD");
			}
			
		}
		
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		
		
		return usuario;
		
		
	}
	

}
