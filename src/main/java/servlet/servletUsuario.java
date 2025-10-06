package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuario;
import entidades.Usuario;


@WebServlet("/servletUsuario")
public class servletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public servletUsuario() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("btnIngresar")!= null)
		{
			DaoUsuario dao = new DaoUsuario();
			Usuario usuario = new Usuario();
			usuario =  dao.obtenerUsuario(request.getParameter("txtUsuario"), request.getParameter("txtPass"));
			
			if (usuario != null) {
			request.getSession().setAttribute("usuario", usuario);
			//request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("/Inicio.jsp").forward(request, response);
			}
			else {
				request.setAttribute("errorLogin", "Usuario o contraseña Inválidos");
				request.getRequestDispatcher("/Login.jsp").forward(request, response); 
			}
			}
		}
		
	}


