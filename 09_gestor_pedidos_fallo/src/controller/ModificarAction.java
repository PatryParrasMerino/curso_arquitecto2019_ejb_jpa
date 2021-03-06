package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoPedidos;
import model.Pedido;

/**
 * Servlet implementation class ModificarAction
 */
@WebServlet("/ModificarAction")
public class ModificarAction extends HttpServlet {
	@EJB
	DaoPedidos dao;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido=new Pedido(Integer.parseInt(request.getParameter("id")),
				request.getParameter("categoria"),
				Double.parseDouble(request.getParameter("precio")),
				request.getParameter("producto"));
		dao.actualizarPedido(pedido);
		request.getRequestDispatcher("ConsultarAction").include(request, response);
	}

}
