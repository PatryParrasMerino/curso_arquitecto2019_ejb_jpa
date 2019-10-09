package service;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import model.Venta;

/**
 * Session Bean implementation class ProductorVentasImpl
 */
@Stateless
@LocalBean
public class ProductorVentasImpl implements ProductorVentas {
	@Resource(type=ConnectionFactory.class, lookup = "java:/jms/factoryventas")
	ConnectionFactory factory;
	@Resource(type=Queue.class, lookup = "java:/jms/colaventas")
	Queue cola;

	@Override
	public void enviarVenta(Venta venta) {		
		try(Connection cn=factory.createConnection();Session ses=cn.createSession();) { //aquí abrimos conexion y sesión y las cerramos en orden inverso			
			//creamos productor mensajes
			MessageProducer productor=ses.createProducer(cola);
			//creamos mensaje
			ObjectMessage obj=ses.createObjectMessage(venta);
			//enviamos el mensaje
			productor.send(obj);
		} catch (JMSException ex) {
			ex.printStackTrace();
		}
		
	}

}
