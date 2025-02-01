package entidades;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author tonym
 */
@WebServlet(name = "servletUsuario", urlPatterns = {"/servletUsuario"})
public class servletUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="Métodos de HttpServlet. Haz clic en el signo + a la izquierda para editar el código.">
    /**
     * Maneja el método HTTP <code>GET</code>.
     *
     * @param request solicitud del servlet
     * @param response respuesta del servlet
     * @throws ServletException si ocurre un error específico del servlet
     * @throws IOException si ocurre un error de entrada/salida
     */
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("mostrar".equals(action)) {
            mostrarUsuario(request, response);
        } else if ("guardar".equals(action)) {
            mostrarUsuarioGuardar(request, response);
        } else if ("modificar".equals(action)) {
            mostrarUsuarioModificar(request, response);
        } else if("eliminar".equals(action)){
           mostrarUsuarioActualizado(request, response);
        } else {
            request.setAttribute("errorMessage", "Acción no reconocida.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * Maneja el método HTTP <code>POST</code>.
     *
     * @param request solicitud del servlet
     * @param response respuesta del servlet
     * @throws ServletException si ocurre un error específico del servlet
     * @throws IOException si ocurre un error de entrada/salida doPost es para
     * guardar, modificar y eliminar doGet es para solo consultar en el back
     * para mostrar
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("guardar".equals(action)) {
            guardarUsuario(request, response);
        } else if("modificar".equals(action)){
            modificarUsuario(request, response);
        } else if ("eliminar".equals(action)){
            eliminarUsuario(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public void guardarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombres = request.getParameter("nombres");
        String apPaterno = request.getParameter("appaterno");
        String apMaterno = request.getParameter("apmaterno");
        int edad = Integer.parseInt(request.getParameter("edad"));

        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        miUsuarioDAO.insertarUsuario(nombres, apPaterno, apMaterno, edad);
        mostrarUsuarioGuardar(request, response);
    }

    public void modificarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idP = request.getParameter("id");
        String nombres = request.getParameter("nombres");
        String appaterno = request.getParameter("appaterno");
        String apmaterno = request.getParameter("apmaterno");
        String edadP = request.getParameter("edad");

        // Validar que los parámetros no sean nulos o vacíos
        if (idP == null || idP.isEmpty()
                || nombres == null || nombres.isEmpty()
                || appaterno == null || apmaterno == null
                || edadP == null || edadP.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos los campos son obligatorios.");
            return;
        }

        try {
            int id = Integer.parseInt(idP);
            int edad = Integer.parseInt(edadP);

            UsuarioDAO miUsuarioDAO = new UsuarioDAO();
            miUsuarioDAO.modificarUsuario(id, nombres, appaterno, apmaterno, edad);

            mostrarUsuarioModificar(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID y edad deben ser números válidos.");
        }
    }
    
    public void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idP = request.getParameter("id");
       

        // Validar que los parámetros no sean nulos o vacíos
        if (idP == null || idP.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Todos los campos son obligatorios.");
            return;
        }

        try {
            int id = Integer.parseInt(idP);
            

            UsuarioDAO miUsuarioDAO = new UsuarioDAO();
            miUsuarioDAO.eliminarUsuario(id);

            mostrarUsuarioActualizado(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID y edad deben ser números válidos.");
        }
    }

    public void mostrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        List<EntidadUsuario> usuarios = miUsuarioDAO.obtenerUsuarios();
        request.setAttribute("listausuarios", usuarios);
        request.getRequestDispatcher("mostrarUsuarios.jsp").forward(request, response);
    }

    public void mostrarUsuarioModificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        List<EntidadUsuario> usuarios = miUsuarioDAO.obtenerUsuarios();
        request.setAttribute("listausuarios", usuarios);
        request.getRequestDispatcher("modificarUsuario.jsp").forward(request, response);
    }
    
    public void mostrarUsuarioActualizado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        List<EntidadUsuario> usuarios = miUsuarioDAO.obtenerUsuarios();
        request.setAttribute("listausuarios", usuarios);
        request.getRequestDispatcher("eliminarUsuarios.jsp").forward(request, response);
    }

    public void mostrarUsuarioGuardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO miUsuarioDAO = new UsuarioDAO();
        List<EntidadUsuario> usuarios = miUsuarioDAO.obtenerUsuarios();
        request.setAttribute("listausuarios", usuarios);
        request.getRequestDispatcher("guardarUsuarios.jsp").forward(request, response);
    }
}
