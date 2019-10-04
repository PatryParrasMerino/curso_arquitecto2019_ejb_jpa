package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Pedido;

/**
 * Session Bean implementation class DaoPedidoImpl
 */
@Stateless
public class DaoPedidosImpl implements DaoPedidos {

	@PersistenceContext(unitName = "pedidosPU")
	EntityManager em;
	
	@Override
	public void eliminarPedido(int idPedido) {
		Pedido pedido=recuperarPedidoPorId(idPedido);
		if(pedido!=null) {
			em.remove(pedido);
		}		
	}

	@Override
	public List<Pedido> recuperarPedidos() {
		//String jpql="Select p From Pedido p";
		Query qr=em.createNamedQuery("Pedido.findAll");
		return (List<Pedido>)qr.getResultList();
	}

	@Override
	public void altaPedido(Pedido pedido) {
		em.persist(pedido);		
	}

	@Override
	public Pedido recuperarPedidoPorId(int id) {
		return em.find(Pedido.class, id);
	}

	@Override
	public void actualizarPedido(Pedido pedido) {
		em.merge(pedido);
	}



}
