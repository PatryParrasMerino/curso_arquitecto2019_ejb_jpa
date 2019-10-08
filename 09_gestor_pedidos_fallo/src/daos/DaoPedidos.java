package daos;

import java.util.List;

import javax.ejb.Local;

import model.Pedido;


@Local
public interface DaoPedidos {
	void eliminarPedido(int idPedido);
	
	List<Pedido> recuperarPedidos();
	
	void altaPedido(Pedido pedido);
	
	Pedido recuperarPedidoPorId(int id);
	
	void actualizarPedido(Pedido pedido);
}
