package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCliente;
import entidades.Cliente;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		int filas=0;
		
         if(request.getParameter("btnAgregar")!=null) {		
			 
        	 
        	 System.out.println("dentro del if para agregar un cliente");
		    
        	 //capturamos todos los campos del formulario y los guardamos en variables
        	 String dni=request.getParameter("txtDni");
			 String cuil=request.getParameter("txtCuil");
			 String nombre=request.getParameter("txtNombre");;
			 String apellido=request.getParameter("txtApellido");;
			 String sexo=request.getParameter("txtSexo");;
			 String fecha_nacimiento=request.getParameter("txtFechaNacimiento");;
			 String direccion=request.getParameter("txtDireccion");;
			 String nacionalidad=request.getParameter("txtNacionalidad");;
			 String localidad=request.getParameter("txtLocalidad");;
			 String provincia=request.getParameter("txtProvincia");;
			 String correo_electronico=request.getParameter("txtCorreo");;
			 String telefono=request.getParameter("txtTelefono");;
				
			 //codigo para ver valores del formulario por consola
			    System.out.println("dni: "+dni);
				System.out.println("cuil: "+cuil);
				System.out.println("nombre: "+nombre);
				System.out.println("apellido: "+apellido);
				System.out.println("sexo: "+sexo);
				System.out.println("nacimiento: "+fecha_nacimiento);
				System.out.println("direccion: "+direccion);
				System.out.println("nacionalidad: "+nacionalidad);
				System.out.println("localidad: "+localidad);
				System.out.println("provincia: "+provincia);
				System.out.println("email: "+correo_electronico);
				System.out.println("telefono: "+telefono);
			
			
		    //Creamos una instancia de Cliente y le seteamos los valores que obtenemos del formulario
			Cliente cliente = new Cliente();
			cliente.setDni(dni);
			cliente.setCuil(cuil);
			cliente.setNombre(nombre);
			cliente.setApelldo(apellido);
			cliente.setSexo(sexo);
			cliente.setFecha_nacimiento(fecha_nacimiento);
			cliente.setDireccion(direccion);
			cliente.setNacionalidad(nacionalidad);
			cliente.setLocalidad(localidad);
			cliente.setProvincia(provincia);
			cliente.setCorreo_electronico(correo_electronico);
			cliente.setTelefono(telefono);
			 
			DaoCliente daoCliente = new DaoCliente();
			filas=daoCliente.agregarCliente(cliente);
			
			request.setAttribute("cantFilas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/Inicio.jsp");   
	        rd.forward(request, response);    
		}
		doGet(request, response);
	}

}
