package mensajeria;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import model.Pedido;


@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
				@ActivationConfigProperty(
				propertyName = "destinationLookup", propertyValue = "javax:/jms/colatest") //esta configuraci�n ha sido a�adida, es la cola
		})
public class ProcesaPedido implements MessageListener {

	//Seg�n lleg�n los mensajes van a este m�todo
    public void onMessage(Message message) {
        ObjectMessage obj=(ObjectMessage)message;
        Pedido pedido;
		try {
			pedido = (Pedido)obj.getObject();
			System.out.println("Producto: "+pedido.getProducto());
	        System.out.println("Precio: "+pedido.getPrecio());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
