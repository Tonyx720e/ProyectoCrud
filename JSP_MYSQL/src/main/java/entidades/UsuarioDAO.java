package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tonym
 */
public class UsuarioDAO {

    public void insertarUsuario(String nombres, String appaterno, String apmaterno, int edad) {
        Connection conn = null;

        PreparedStatement stmt = null;
        try {
            conn = conexionDAO.obtenerConexion();
            String sql = "insert into usuarios(nombres, appaterno, apmaterno, edad) values (?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombres);
            stmt.setString(2, appaterno);
            stmt.setString(3, apmaterno);
            stmt.setInt(4, edad);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionDAO.cerrarConexion(conn);
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void modificarUsuario(int id, String nombres, String appaterno, String apmaterno, int edad) {
        Connection conn = null;

        PreparedStatement stmt = null;
        try {
            conn = conexionDAO.obtenerConexion();
            String sql = "update usuarios set nombres = ?, appaterno = ?, apmaterno = ?, edad = ? WHERE id = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombres);
            stmt.setString(2, appaterno);
            stmt.setString(3, apmaterno);
            stmt.setInt(4, edad);
            stmt.setInt(5, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionDAO.cerrarConexion(conn);
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void eliminarUsuario(int id) {
        Connection conn = null;

        PreparedStatement stmt = null;
        try {
            conn = conexionDAO.obtenerConexion();
            String sql = "DELETE from usuarios WHERE id = ?;";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexionDAO.cerrarConexion(conn);
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public List<EntidadUsuario> obtenerUsuarios(){
        List<EntidadUsuario> usuarios = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement  stmt = null;
        ResultSet rs = null;
        
        try {
            conn = conexionDAO.obtenerConexion();
            String sql = "SELECT * FROM usuarios;";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
                 
                while(rs.next()){
                    EntidadUsuario usuario = new EntidadUsuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombres"));
                    usuario.setApPaterno(rs.getString("appaterno"));
                    usuario.setApMaterno(rs.getString("apmaterno"));
                    usuario.setEdad(rs.getInt("edad"));
                    usuarios.add(usuario);
                }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            conexionDAO.cerrarConexion(conn);
            try {
                if(stmt != null) stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if(rs != null) rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return usuarios;        
    }

}
