package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlFinal="inicio.html";
		String op=request.getParameter("op");
		switch (op) {				
			case "doGuardar":
				request.getRequestDispatcher("GuardarAction").include(request, response);
				urlFinal="inicio.html";
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarAction").include(request, response); 
			case "doConsultar":
				request.getRequestDispatcher("ConsultarAction").include(request, response);
				urlFinal="pedidos.jsp";
				break;
			case "doEditar":
				request.getRequestDispatcher("EditarAction").include(request, response);
				urlFinal="pedidos.jsp";
				break;
			case "toModificar":
				urlFinal="modificar.jsp";
				break;
			case "toVolver":
				urlFinal="inicio.html";
				break;
			case "toGuardar":
				urlFinal="guardar.jsp";
				break;
		} 
		request.getRequestDispatcher(urlFinal).forward(request, response);
	}

}
