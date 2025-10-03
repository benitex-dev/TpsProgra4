<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import= "entidades.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Holaa mundo</h1>
<h2>COMMIT PRUEBA JOHAN</h2>



<%
Usuario usuario = null;
if(request.getAttribute("usuario")!= null){
usuario = (Usuario)request.getAttribute("usuario");
	
%>

<p>funciona</p>

<p>Usuario: <%=usuario.getUsuario() %> </p>

<%
}
%>



</body>
</html>