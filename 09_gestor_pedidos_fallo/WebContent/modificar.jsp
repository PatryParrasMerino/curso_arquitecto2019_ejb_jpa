<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<form action="Controller?op=doModificar" method="post">
		Categoria<input type="text" name="categoria"/></br>
		Precio<input type="number" name="precio"/></br>
		Producto<input type="text" name="producto"/></br></br>
		<button type="submit">Guardar</button>
	</form>
</center>
</body>
</html>