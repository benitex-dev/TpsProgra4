package servlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoCliente;
import entidades.Cliente;
import interfaces.IDaoCliente;


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
    	IDaoCliente dao = new DaoCliente();
      	ArrayList<Cliente> listaClientes = dao.listar();	    	   
      	request.setAttribute("listaClientes", listaClientes);
      	RequestDispatcher rd = request.getRequestDispatcher("/ListaClientes.jsp");
      	rd.forward(request, response);    
          }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		int filas=0;
				
         if(request.getParameter("btnAgregar")!=null) {		
			 
        	 ArrayList<String> errores = new ArrayList<>();     	 
        	 
        	 
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
			
				//CAMPOS VACIOS
				if (dni == null || dni.trim().isEmpty())
				    errores.add("El DNI es obligatorio.");
				if (cuil == null || cuil.trim().isEmpty())
				    errores.add("El CUIL es obligatorio.");
				if (nombre == null || nombre.trim().isEmpty())
				    errores.add("El nombre es obligatorio.");
				if (apellido == null || apellido.trim().isEmpty())
				    errores.add("El apellido es obligatorio.");
				if (sexo == null || sexo.trim().isEmpty())
				    errores.add("Debe seleccionar un sexo.");
				if (fecha_nacimiento == null || fecha_nacimiento.trim().isEmpty())
				    errores.add("La fecha de nacimiento es obligatoria.");
				if (direccion == null || direccion.trim().isEmpty())
				    errores.add("La dirección es obligatoria.");
				if (nacionalidad == null || nacionalidad.trim().isEmpty())
				    errores.add("La nacionalidad es obligatoria.");
				if (localidad == null || localidad.trim().isEmpty())
				    errores.add("La localidad es obligatoria.");
				if (provincia == null || provincia.trim().isEmpty())
				    errores.add("La provincia es obligatoria.");
				if (correo_electronico == null || correo_electronico.trim().isEmpty())
				    errores.add("El correo es obligatorio.");
				if (telefono == null || telefono.trim().isEmpty())
				    errores.add("El teléfono es obligatorio.");
				
				if (!errores.isEmpty()) {
				    errores.add("Debe ingresar todos los campos para poder continuar.");
				    
				    request.setAttribute("dni", dni);
		            request.setAttribute("cuil", cuil);
		            request.setAttribute("nombre", nombre);
		            request.setAttribute("apellido", apellido);
		            request.setAttribute("sexo", sexo);
		            request.setAttribute("fecha_nacimiento", fecha_nacimiento);
		            request.setAttribute("direccion", direccion);
		            request.setAttribute("nacionalidad", nacionalidad);
		            request.setAttribute("localidad", localidad);
		            request.setAttribute("provincia", provincia);
		            request.setAttribute("correo_electronico", correo_electronico);
		            request.setAttribute("telefono", telefono);

		            request.setAttribute("errores", errores);
		            request.getRequestDispatcher("/AltaClientes.jsp").forward(request, response);
		            return;
				}
			
				//VALIDACIONES
				if (dni == null || !dni.matches("\\d{6,8}"))
	                errores.add("DNI debe ser numérico de 6 a 8 dígitos.");
	            if (cuil == null || !cuil.matches("\\d{11}"))
	                errores.add("CUIL debe ser numérico de 11 dígitos.");
	            if (nombre == null || !nombre.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+"))
	                errores.add("Nombre solo puede tener letras.");
	            if (apellido == null || !apellido.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+"))
	                errores.add("Apellido solo puede tener letras.");
	            if (sexo == null || !(sexo.equals("M") || sexo.equals("F") || sexo.equals("Otro")))
	                errores.add("Sexo inválido.");
	            
	            //FALTA FECHA!!
	            
	            if (direccion == null || direccion.trim().isEmpty())
	                errores.add("La dirección es obligatoria.");
	            if (nacionalidad == null || !nacionalidad.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+"))
	                errores.add("Nacionalidad solo puede tener letras.");
	            if (localidad == null || !localidad.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+"))
	                errores.add("Localidad solo puede tener letras.");
	            if (provincia == null || !provincia.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+"))
	                errores.add("Provincia solo puede tener letras.");
	            if (correo_electronico == null || !correo_electronico.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$"))
	                errores.add("Correo electrónico inválido.");
	            if (telefono == null || !telefono.matches("\\d{10}"))
	                errores.add("Teléfono debe ser numérico de 10 dígitos.");
	            
	            if (!errores.isEmpty()) {
	                System.out.println("[ServletCliente] Errores (formato): " + String.join(" | ", errores));
	                System.out.println("[ServletCliente] Volviendo a AltaClientes.jsp por errores de formato");

	                request.setAttribute("errores", errores);
	                request.getRequestDispatcher("/AltaClientes.jsp").forward(request, response);
	                return;
	            }
		    
			//Creamos una instancia de Cliente y le seteamos los valores que obtenemos del formulario
			Cliente cliente = new Cliente();
			cliente.setDni(dni);
			cliente.setCuil(cuil);
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setSexo(sexo);
			cliente.setFecha_nacimiento(fecha_nacimiento);
			cliente.setDireccion(direccion);
			cliente.setNacionalidad(nacionalidad);
			cliente.setLocalidad(localidad);
			cliente.setProvincia(provincia);
			cliente.setCorreo_electronico(correo_electronico);
			cliente.setTelefono(telefono);
			 
			IDaoCliente daoCliente = new DaoCliente();
			filas=daoCliente.agregarCliente(cliente);
			
			request.setAttribute("cantFilas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/Inicio.jsp");   
	        rd.forward(request, response);  
	        return;
		}
		doGet(request, response);
	}

}
