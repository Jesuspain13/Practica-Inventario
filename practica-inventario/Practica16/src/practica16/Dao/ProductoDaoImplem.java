/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16.Dao;

import practica16.Dao.ProductoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import practica16.FactoriaConexion;
import practica16.Pojo.Producto;

/**
 *
 * @author Jesús
 */
public class ProductoDaoImplem implements ProductoDao {

    private FactoriaConexion conexion;

    public ProductoDaoImplem() {
        conexion = new FactoriaConexion();
    }

    @Override
    public void añadirProducto(Producto p)
            throws ClassNotFoundException, SQLException {
        String sql = this.crearSentencia(p);
        this.actualizarBD(sql);
        System.out.println(p.getNombre() + " guardado");
    }

    @Override
    public Collection<Producto> mostrarTodosProductos()
            throws ClassNotFoundException, SQLException {
        String sql = "SELECT id, nombre, cantidad, comentario, fecha,\n"
                + " precio, tipoid FROM producto";

        return this.consultaBD(sql);
    }

    @Override
    public Collection<Producto> buscarPorNombre(String nombre)
            throws ClassNotFoundException, SQLException {
        String sql = "SELECT nombre, cantidad, comentario, fecha,"
                + " precio, descripcion"
                + " FROM producto p "
                + " INNER JOIN tipoproducto t ON p.tipoid = t.id "
                + " WHERE nombre LIKE '%" + nombre + "%'";

        return this.consultaBD(sql);
    }

    /**
     * metodo que conecta a la BD, ejecuta la consulta sql
     * (INSERT/DELETE/UPDATE) y desconecta de la BD
     *
     * @param sql codigo de la consulta
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private void actualizarBD(String sql)
            throws ClassNotFoundException, SQLException {
        Connection conn = conexion.conectarBD();
        PreparedStatement st = conn.prepareStatement(sql);

        st.executeUpdate();
        conexion.desconectarBD(st, conn);
    }

    /**
     * metodo que conecta a la BD, ejecuta la consulta sql (SELECT), procesa el
     * resultado, desconecta de la BD.
     *
     * @param sql codigo de la consulta
     * @return lista con los productos dentro
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private Collection<Producto> consultaBD(String sql)
            throws SQLException, ClassNotFoundException {
        Connection conn = conexion.conectarBD();
        PreparedStatement st = conn.prepareStatement(sql);

        Collection<Producto> lista = this.procesarConsulta(st.executeQuery());
        conexion.desconectarBD(st, conn);
        return lista;
    }

    /**
     * metodo en el que iteramos sobre ResultSet para pasar campos de cada
     * registro a un objeto java y guardar los objetos en una lista para
     * retornarla.
     *
     * @param rs ResultSet recibido de la consulta
     * @return Coleccion con los Productos creados con el ResultSet
     * @throws SQLException
     */
    private Collection<Producto> procesarConsulta(ResultSet rs)
            throws SQLException {
        Collection<Producto> lista = new ArrayList();
        Producto p;
        //tengo que recorrer el resultado de la consulta
        while (rs.next()) {
            p = new Producto();

            p.setId(rs.getInt("id"));
            p.setNombre(rs.getString("nombre"));
            p.setCantidad(rs.getInt("cantidad"));
            p.setComentario(rs.getString("comentario"));
            p.setFecha(rs.getString("fecha"));
            p.setPrecio(rs.getInt("precio"));
            p.setTipoId(rs.getInt("tipoid"));

            lista.add(p);
        }
        return lista;
    }
    
    /**
     * crea una sentencia una sql con los valores de los atributos del 
     * Producto que recibe como argumento
     * @param p Producto a añadir
     * @return 
     */
    private String crearSentencia(Producto p) {
        String nombre = p.getNombre();
        int cantidad = p.getCantidad();
        String comentario = p.getComentario();
        String fecha = p.getFecha();
        int precio = p.getPrecio();
        int tipoId = p.getTipoId();
        
        String sql = "INSERT INTO producto (nombre, cantidad, comentario, " +
                "fecha, precio, tipoid) VALUES('" + nombre + "', '" + cantidad + 
                "', '" + comentario + "', '" + fecha + "', '" + precio + "', '" 
                + tipoId + "');";
        
        return sql;
    }

}
