package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Cliente;
import interfaces.IDaoCliente;

public class DaoCliente implements IDaoCliente {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "sistema_clientes";
	
	public ArrayList<Cliente> listar(){
		ArrayList<Cliente> listaCli = new ArrayList<Cliente>();
		String query = "select id_cliente, dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, nacionalidad, localidad, provincia, correo_electronico, telefono from clientes";
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Cliente cli = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12),rs.getString(13));
				listaCli.add(cli);
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return listaCli;
	}

	@Override
	public int agregarCliente(Cliente cliente) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query 
			= "Insert into clientes(dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, nacionalidad, localidad, provincia, correo_electronico, telefono) values ('"+cliente.getDni()+"','"+cliente.getCuil()+"','"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+cliente.getSexo()+"','"+cliente.getFecha_nacimiento()+"','"+cliente.getDireccion()+"','"+cliente.getNacionalidad()+"','"+cliente.getLocalidad()+"','"+cliente.getProvincia()+"','"+cliente.getCorreo_electronico()+"','"+cliente.getTelefono()+"')";
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}


}
