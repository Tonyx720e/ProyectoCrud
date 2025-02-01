<%-- 
    Document   : guardarUsuarios
    Created on : 3 ene 2025, 10:35:06
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
        <h1>Guardar usuarios</h1>
        <a href="index.jsp">Regresar al menú</a>

        <form action="servletUsuario" method="post">
            <p><label for="">Nombres:</label> <input type="text" name="nombres"></p>
            <p><label for="">ApPaterno:</label> <input type="text" name="appaterno"></p>
            <p><label for="">ApMaterno:</label> <input type="text" name="apmaterno"></p>
            <p><label for="">Edad:</label> <input type="text" name="edad"></p>

            <button type="submit" name="action" value="guardar">Guardar</button>

        </form>
        <h3>Lista de usuarios</h3>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombres</th>
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
