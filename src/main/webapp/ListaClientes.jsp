<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Cliente" %>
<%@ page import="servlet.ServletCliente" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">    
        
        <h1>Listado de Clientes</h1>
        <hr>
        
        <%
            try {
                ArrayList<Cliente> lista = (ArrayList<Cliente>) request.getAttribute("listaClientes");

                if (lista != null && !lista.isEmpty()) {
        %>
                    <table id="tablaClientes" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                            <tr>
                                <th>DNI</th><th>CUIL</th><th>Nombre</th><th>Apellido</th><th>Email</th>
                                <th>Teléfono</th><th>Localidad</th><th>Provincia</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Cliente clientes : lista) { %>
                            <tr>
                                <td><%= clientes.getDni() %></td>
                                <td><%= clientes.getCuil() %></td>
                                <td><%= clientes.getNombre() %></td>                      
                                <td><%= clientes.getApellido() %></td>                  
                                <td><%= clientes.getCorreo_electronico() %></td>
                                <td><%= clientes.getTelefono() %></td>
                                <td><%= clientes.getLocalidad() %></td>
                                <td><%= clientes.getProvincia() %></td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
        <%
                } else {
        %>
                    <div class="alert alert-warning" role="alert">
                        No hay clientes guardados
                    </div>
        <%
                }
            } catch (Exception e) {
        %>
                <div class="alert alert-danger" role="alert">
                    Ocurrió un error al obtener los clientes: <%= e.getMessage() %>
                </div>
        <%
            }
        %>       

    </div>   
</body>
</html>
