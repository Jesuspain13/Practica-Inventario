/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jesús
 */
public class FactoriaConexion {

    private String url;
    private String user;
    private String password;

    public FactoriaConexion() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.url = "jdbc:mysql://localhost/inventario";
        this.user = "root";
        this.password = "root";
    }

    /**
     * metodo para conectar con la base de datos
     *
     * @return devueltve la variable con la conexion
     * @throws ClassNotFoundException Excepcion producida al cargar el driver
     * @throws SQLException Excepcion producida por la base de datos
     */
    public Connection conectarBD() throws ClassNotFoundException, SQLException {
        //cargar driver
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * metodo para cerrar las conexiones con la base de datos
     *
     * @param st objeto PreparementStatement para comunicarnos con base de datos
     * @param conn Objeto Connection, es la conexion establecida con la bd
     * @throws SQLException
     */
    public void desconectarBD(PreparedStatement st, Connection conn)
            throws SQLException {
        st.close();
        conn.close();
    }
}
