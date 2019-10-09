package mensajeria;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import daos.DaoVentas;
import model.Venta;


@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
				@ActivationConfigProperty(
				propertyName = "destinationLookup", propertyValue = "javax:/jms/colaventas") //esta configuración ha sido añadida, es la cola
		})
public class GestorVentas implements MessageListener {

	@EJB
	DaoVentas daoVentas;
    public void onMessage(Message message) {
    	ObjectMessage obj=(ObjectMessage)message;
    	Venta venta;
    	try {
			venta=(Venta)obj.getObject();
			daoVentas.registrarVentas(venta);
		} catch (JMSException e) {
			e.printStackTrace();
		}
    }

}
