<%-- 
    Document   : index
    Created on : 30 dic 2024, 14:54:13
    Author     : tonym
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .botones-container{
                text-align: center;
            }
            .botones-container button{
                margin: 5px;
            }
        </style>
    </head>
    <body>
        <h1>CRUD JSP & MYSQL</h1>
        <h2>Menú principal</h2>

        <div class="botones-container"
             <form action="servletUsuario" method="get">
                <a href="servletUsuario?action=mostrar"><button>Mostrar Usuario </button></a>

                <a href="servletUsuario?action=modificar"><button>Modificar usuario </button></a>

                <a href="servletUsuario?action=guardar"><button>Guardar Usuario </button></a>
                <a href="servletUsuario?action=eliminar"><button>Eliminar Usuario </button></a>
               
            </form>



        </div>
    </body>
</html>
