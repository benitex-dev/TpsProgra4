<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import= "entidades.Usuario" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

</head>
<body class="bg-light">
  

<h1>Pagina de Inicio</h1>
 <%@ include file="Header.jsp" %>

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


 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>