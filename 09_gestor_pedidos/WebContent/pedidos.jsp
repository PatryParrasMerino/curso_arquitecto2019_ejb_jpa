<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Pedido,daos.DaoPedidos"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
	<%
	List<Pedido> listaPedidos=(List<Pedido>)request.getAttribute("pedidos");
	%>
<div class="container">
  <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Categoria</th>
        <th>Precio</th>
        <th>Producto</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
	<%for(Pedido pedido:listaPedidos){ %>
      <tr>
        <td><%=pedido.getIdPedido()%></td>
        <td><%=pedido.getCategoria()%></td>
        <td><%=pedido.getPrecio()%></td>
        <td><%=pedido.getProducto()%></td>
        <td><a href="Controller?op=doEliminar&id=<%=pedido.getIdPedido()%>">Eliminar</a></td>
        <td><a href="Controller?op=toModificar&id=<%=pedido.getIdPedido()%>">Editar</a></td>
      </tr>
      <%} %>
    </tbody>
  </table>
    <div class="col-sm-10">
		
		<a type="button" href='Controller?op=toVolver' class="btn btn-default">Volver</a>
	</div>
</div>

</body>
</html>