package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import daos.DaoContactos;
import model.Contacto;

/**
 * Servlet implementation class ContactosAction
 */
@WebServlet("/ContactosAction")
public class ContactosAction extends HttpServlet {
	@EJB
	DaoContactos dao;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Contacto> contactos=dao.mostrarContactos();
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		System.out.println(contactos.size());
		out.println(convertirJson(contactos));
	}
	private String convertirJson(List<Contacto> contactos) {
		JSONArray array=new JSONArray();
		for(Contacto cont:contactos) {
			JSONObject obj=new JSONObject();
			obj.put("idContacto", cont.getIdContacto());
			obj.put("nombre", cont.getNombre());
			obj.put("email", cont.getEmail());
			obj.put("edad", cont.getEdad());
			array.add(obj);
		}
		return array.toJSONString();
	}

}
