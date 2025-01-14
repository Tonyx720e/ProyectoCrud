<%-- 
    Document   : guardarUsuarios
    Created on : 3 ene 2025, 10:35:06
    Author     : tonym
--%>

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

        <form action="">
            <p><label for="">Nombres:</label> <input type="text" name="name"></p>
            <p><label for="">ApPaterno:</label> <input type="text" name="appaterno"></p>
            <p><label for="">ApMaterno:</label> <input type="text" name="apmaterno"></p>
            <p><label for="">Edad:</label> <input type="text" name="edad"></p>

            <button type="submit">Guardar</button>

        </form>
        <h3>Lista de usuarios</h3>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>ApPaterno</th>
                <th>ApMaterno</th>
                <th>Edad</th>
            </tr>

            <% 
            
            %>
            <tr>
                <td>Cell</td>
                <td>Cell</td>
                <td>Cell</td>
                <td>Cell</td>
                <td>Cell</td>
            </tr>

        </table>
    </body>
</html>
