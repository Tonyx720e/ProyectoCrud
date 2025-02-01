<%-- 
    Document   : mostrarUsuarios
    Created on : 3 ene 2025, 10:17:19
    Author     : tonym
--%>

<%@page import="java.util.List"%>
<%@page import="entidades.EntidadUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla de usuarios</h1>
        <a href="index.jsp">Regresar al menú</a>

        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>ApPaterno</th>
                <th>ApMaterno</th>
                <th>Edad</th>
            </tr>

            <%
                List<EntidadUsuario> usuarios = (List<EntidadUsuario>) request.getAttribute("listausuarios");
                for (EntidadUsuario usuario: usuarios) {
                    

            %>
            <tr>
                <td><%= usuario.getId() %></td>
                <td><%= usuario.getNombre() %></td>
                <td><%= usuario.getApPaterno() %></td>
                <td><%= usuario.getApMaterno() %></td>
                <td><%= usuario.getEdad() %></td>
            </tr>
            <%                }
            %>
        </table>

    </body>
</html>
