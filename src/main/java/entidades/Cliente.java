package entidades;

public class Cliente {

	private int id_cliente;
	private String dni;
	private String cuil;
	private String nombre;
	private String apelldo;
	private String sexo;
	private String fecha_nacimiento;
	private String direccion;
	private String nacionalidad;
	private String localidad;
	private String provincia;
	private String correo_electronico;
	private String telefono;
	
	public Cliente () {}
	
	public Cliente (int id_cliente, String dni, String cuil, String nombre, String apellido, String sexo, String fecha_nacimiento, String direccion, String nacionalidad, String localidad, String provincia, String correo_electronico, String telefono) {
		this.id_cliente = id_cliente;
		this.dni = dni;
		this.cuil = cuil;
		this.nombre = nombre;
		this.apelldo = apellido;
		this.sexo = sexo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
		this.localidad = localidad;
		this.provincia = provincia;
		this.correo_electronico = correo_electronico;
		this.telefono = telefono;
	}
	
}
