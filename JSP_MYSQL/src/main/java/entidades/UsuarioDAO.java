/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author tonym
 */
public class UsuarioDAO {
    public void insertarUsuario(String nombre, String appaterno, String apmaterno, int edad){
    Connection conn = null;
    
    PreparedStatement stmt = null;
        try {
            conn = conexionDAO.obtenerConexion(); 
            String sql = "insert into usuarios(nombres, appaterno, apmaterno, edad) values ($,$,$,$)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, appaterno);
            stmt.setString(3, apmaterno);
            stmt.setInt(4, edad);
            
            stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
        conexionDAO.cerrarConexion(conn);
            try {
                if(stmt != null){stmt.close();}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
