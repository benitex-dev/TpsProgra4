<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>



<div>

<form action="servletUsuario" method="post">

	<p>Ingrese nombre de usuario</p> <input type="text" name="txtUsuario" placeholder="nombre de usuario">
	<p>Ingrese su contraseña</p> <input type="text" name="txtPass">
	
	<input type="submit" value="Ingresar" name="btnIngresar">
	
</form>

</div>



</body>
</html>