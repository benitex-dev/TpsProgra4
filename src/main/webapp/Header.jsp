<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entidades.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
    Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario");
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">

    <a class="navbar-brand" href="Inicio.jsp"></a>

    <!-- Menú de navegación alineado a la izquierda -->
    <ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex flex-row">
      <li class="nav-item me-3">
        <a class="nav-link" href="Inicio.jsp">Inicio</a>
      </li>
      <li class="nav-item me-3">
        <a class="nav-link" href="AltaCliente.jsp">Alta de Cliente</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/ServletCliente">Listado de Clientes</a>
      </li>
    </ul>

    <!-- Usuario y botón cerrar sesión a la derecha -->
    <div class="d-flex align-items-center text-white">
        <i class="bi bi-person-circle me-2" style="font-size: 1.5rem;"></i>
        <% if (usuarioLogueado != null) { %>
            <span><%= usuarioLogueado.getUsuario() %></span>
        <% } %>
        <a href="Logout.jsp" class="btn btn-outline-light btn-sm ms-3">Cerrar sesión</a>
    </div>

  </div>
</nav>

<!-- Bootstrap Icons -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
</body>
</html>