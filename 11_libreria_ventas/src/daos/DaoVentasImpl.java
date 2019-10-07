package daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Venta;

/**
 * Session Bean implementation class DaoComprasImpl
 */
@Stateless
@LocalBean
public class DaoVentasImpl implements DaoVentas {
	
	@PersistenceContext(unitName = "librosPU")
	EntityManager em;

	@Override
	public List<Venta> recuperarVentas() {
		Query qr=em.createNamedQuery("Venta.findAll");
		return (List<Venta>)qr.getResultList();
	}

}
