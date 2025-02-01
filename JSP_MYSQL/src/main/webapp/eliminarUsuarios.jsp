 <%@page import="java.util.List"%>
<%@page import="entidades.EntidadUsuario"%>
<%-- 
    Document   : eliminarUsuarios
    Created on : 3 ene 2025, 11:35:53
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
         <h1>Eliminar usuario</h1>
        <a href="index.jsp">Regresar al menú</a>

        <form action="servletUsuario" method="post">
            <p><label for="">Id:</label> <input type="text" name="id" id="idid" readonly=""></p>
            <p><label for="">Nombres:</label> <input type="text" name="nombres" id="idnombre"></p>
            <p><label for="">ApPaterno:</label> <input type="text" name="appaterno" id="idpaterno"></p>
            <p><label for="">ApMaterno:</label> <input type="text" name="apmaterno" id="idmaterno"></p>
            <p><label for="">Edad:</label> <input type="text" name="edad" id="idedad"></p>

            <button type="submit" name="action" value="eliminar">Eliminar</button>

        </form>
        <h3>Lista de usuarios</h3>
        <table border="1" id="mitabla">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>ApPaterno</th>
                <th>ApMaterno</th>
                <th>Edad</th>
                <th>Accion</th>
            </tr>

            <% 
            List<EntidadUsuario> usuarios = (List<EntidadUsuario>) request.getAttribute("listausuarios");
            for(EntidadUsuario usuario: usuarios){
            %>
            <tr>
                <td><%= usuario.getId() %></td>
                <td><%= usuario.getNombre() %></td>
                <td><%= usuario.getApPaterno() %></td>
                <td><%= usuario.getApMaterno() %></td>
                <td><%= usuario.getEdad() %></td>
                <td>
                <button type="submit" onClick= "Seleccionar()"> Seleccionar </buttton>
                </td>
            </tr>
            <% }
            %>

        </table>
    </body>
</html>

<script>
    function Seleccionar(){
    
        var table = document.getElementById("mitabla");
    
        for (var index = 1; index < table.rows.length; index++) {
            table.rows[index].onclick = function(){
                document.getElementById('idid').value = this.cells[0].innerHTML;
                document.getElementById('idnombre').value = this.cells[1].innerHTML;
                document.getElementById('idpaterno').value = this.cells[2].innerHTML;
                document.getElementById('idmaterno').value = this.cells[3].innerHTML;
                document.getElementById('idedad').value = this.cells[4].innerHTML;
                
    
            };
            
        }
    
    }
    
    </script>
