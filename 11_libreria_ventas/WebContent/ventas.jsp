<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Cliente,model.Venta,java.util.List"%>
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
<center>
	Compras de: <%Cliente cliente=(Cliente)request.getAttribute("Cliente"); %>
	
		<%
	List<Venta> listaVentas=(List<Venta>)request.getAttribute("ventas");
	%>
	<div class="container">
  <table class="table table-striped">
    <thead>
      <tr>
        <th>IDVenta</th>
        <th>IdCliente</th>
        <th>IdLibro</th>
        <th>fecha</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
	<%for(Venta venta:listaVentas){ %>
      <tr>
        <td><%=venta.getIdVEnta()%></td>
        <td><%=venta.getCliente()%></td>
        <td><%=venta.getLibro().getIsbn()%></td>
        <td><%=venta.getFecha()%></td>
      </tr>
      <%} %>
    </tbody>
  </table>
    <div class="col-sm-10">
		
		<a type="button" href='Controller?op=toVolver' class="btn btn-default">Volver</a>
	</div>
</div>

</center>

</body>
</html>