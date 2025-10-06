<%
    if (session.getAttribute("usuario") == null) {
        request.setAttribute("errorLogin", "Debes iniciar sesión para acceder al sistema.");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
        return;
    }
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Alta Cliente</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

</head>
<body class="">
<nav class="nav text-black">
  
 
</nav>
    <div class="container mt-5">
    <h2>Formulario de Cliente</h2>
    <form action="ServletCliente"  method="post">
    <div class="row mb-3">
        <div class="col-md-6">
          <label for="dni" class="form-label">DNI</label>
          <input type="text" class="form-control" name="txtDni" placeholder="Ej: 12345678">
          <small class="text-muted">Sólo números. 8 dígitos.</small>
        </div>
        <div class="col-md-6">
          <label for="cuil" class="form-label">CUIL</label>
          <input type="text" class="form-control" name="txtCuil" placeholder="Ej: 20334445551">
          <small class="text-muted">Formato: 11 dígitos.</small>
        </div>
      </div>

    <div class="row mb-3">
        <div class="col-md-6">
          <label for="nombre" class="form-label">Nombre</label>
          <input type="text" class="form-control" name="txtNombre">
        </div>
        <div class="col-md-6">
          <label for="apellido" class="form-label">Apellido</label>
          <input type="text" class="form-control" name="txtApellido">
        </div>
      </div>

     <div class="row mb-3">
        <div class="col-md-6">
          <label for="sexo" class="form-label">Sexo</label>
          <select class="form-select" name="txtSexo">
            <option selected>Seleccione</option>
            <option value="M">Masculino</option>
            <option value="F">Femenino</option>
            <option value="O">Otro</option>
          </select>
        </div>
        <div class="col-md-6">
          <label for="nacionalidad" class="form-label">Nacionalidad</label>
          <input type="text" class="form-control" name="txtNacionalidad">
        </div>
      </div>
    <div class="mb-3">
        <label for="fechaNacimiento" class="form-label">Fecha de nacimiento</label>
        <input type="text" class="form-control" name="txtFechaNacimiento" placeholder="dd/mm/aaaa">
      </div>

      <div class="mb-3">
        <label for="direccion" class="form-label">Dirección</label>
        <input type="text" class="form-control" name="txtDireccion">
      </div>

      <div class="row mb-3">
        <div class="col-md-6">
          <label for="localidad" class="form-label">Localidad</label>
          <input type="text" class="form-control" name="txtLocalidad">
        </div>
        <div class="col-md-6">
          <label for="provincia" class="form-label">Provincia</label>
          <input type="text" class="form-control" name="txtProvincia">
        </div>
      </div>
    <div class="row mb-3">
        <div class="col-md-6">
          <label for="email" class="form-label">Correo electrónico</label>
          <input type="email" class="form-control" name="txtCorreo" placeholder="Ej: nombre@dominio.com">
        </div>
        <div class="col-md-6">
          <label for="telefono" class="form-label">Teléfono</label>
          <input type="text" class="form-control" name="txtTelefono">
        </div>
      </div>

      <div class="text-center">
        <button type="submit" class="btn btn-primary float-end mb-5" name="btnAgregar">Guardar Cliente</button>
      </div>
    
    </form>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

</body>
</html>