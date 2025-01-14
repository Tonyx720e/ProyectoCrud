/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tonym
 */
public class conexionDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost";
    private static final String DATABASE = "dbusur";
    private static final String USER = System.getenv("DB_USER_PRUEBA");
    private static final String PASS = System.getenv("DB_PASS_PRUEBA");
    private static final String URLFINAL = JDBC_URL + "/" + DATABASE + "?useSSL=false&allowPublicKeyRetrieval=true";
    
    public static Connection obtenerConexion(){
        Connection conn = null;
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection(URLFINAL,USER,PASS);
           
        } catch (Exception e) {
            System.out.println("Error al conectarnos"+ e.toString());
        }
        return  conn;
    }
    public static void cerrarConexion(Connection conn){
        try {
            if(conn != null){
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Error de conexion"+ e.toString());
        }
    }
}
