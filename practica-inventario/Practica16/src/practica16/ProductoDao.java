/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Jesús
 */
public class ProductoDao {
    private ConexionBaseDatos conexion;
    
    public ProductoDao(){
        conexion = new ConexionBaseDatos();
    }
    
    /**
     * establece conexion con la base de datos, crea una sentencia SQL 
     * con la info del producto a introducir y ejecuta el UPDATE mandando esta
     * tras esto, se desconecta
     * @param p
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void añadirProducto(Producto p) 
           throws ClassNotFoundException, SQLException{
        //establece conexion
       Connection conn = conexion.conectarBD();
       
       String sql = "INSERT INTO producto (nombre, cantidad, comentario, " + 
               "fecha, precio, tipoid) VALUES(?, ?, ?, ?, ?, ?)";
       PreparedStatement st = conn.prepareStatement(sql);
       //establezco los comodines
       st.setString(1, p.getNombre());
       st.setInt(2, p.getCantidad());
       st.setString(3, p.getComentario());
       st.setString(4, p.getFecha());
       st.setInt(5, p.getPrecio());
       st.setString(6, p.getTipoProducto());
       
       //ejecuta la sentencia sql
       st.executeUpdate();
       
       //cierra conexion con la bd
       conexion.desconectarBD(st, conn);
       
       System.out.println(p.getNombre() + " guardado");
    }
    
    /**
     * hace una consulta a la base de datos para recoger todos los productos
     * crea un objeto java Producto para poder añadirlo a una lista y mandarlo
     * al usuario 
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Collection<Producto> mostrarTodosProductos() 
            throws ClassNotFoundException, SQLException{
        Connection conn = conexion.conectarBD();
        String sql = "SELECT nombre, cantidad, comentario, fecha, precio, descripcion \n" +
                        "FROM producto p\n" +
                        "INNER JOIN tipoproducto t ON p.tipoid = t.id";
        PreparedStatement st = conn.prepareStatement(sql);
        
        //ejecuto la consulta a la base de datos
        ResultSet rs = st.executeQuery();
        
//        Collection<Producto> lista = new ArrayList();
//        Producto p;
//        //tengo que recorrer el resultado de la consulta
//        while (rs.next()) {
//            p = new Producto(rs.getInt("id"), rs.getString("nombre"), 
//                rs.getInt("cantidad"), rs.getString("comentario"),
//                rs.getString("fecha"), rs.getInt("precio"), 
//                rs.getInt("tipoid"));
//            
//            /*p.setId(rs.getInt("id"));
//            p.setNombre(rs.getString("nombre"));
//            p.setCantidad(rs.getInt("cantidad"));
//            p.setComentario(rs.getString("comentario"));
//            p.setFecha(rs.getString("fecha"));
//            p.setPrecio(rs.getInt("precio"));
//            */
//            
//            lista.add(p);
//        }
        //resultadoAProducto para transformar ResultSet a Collection
        Collection<Producto> lista = this.resultadoAProducto(rs);
        conexion.desconectarBD(st, conn);
        
        return lista;
    }
    
    /**
     * conecta con la bd, hace una consulta para la columna nombre donde esté la 
     * cadena pasadas como argumento,
     * @param nombre
     * @return coleccion con los Productos encontrados para la condicion 
     * establecida
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Collection<Producto> buscarProducto(String nombre) 
        throws ClassNotFoundException, SQLException{
        Connection conn = conexion.conectarBD();
        String sql = "SELECT nombre, cantidad, comentario, fecha, precio, descripcion" +
                        " FROM producto p " +
                        " INNER JOIN tipoproducto t ON p.tipoid = t.id " +
                        " WHERE nombre LIKE ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, "%" + nombre + "%");
        
        ResultSet rs = st.executeQuery();
        
        //resultadoAProducto para transformar ResultSet a Collection
        Collection<Producto> lista = this.resultadoAProducto(rs);
        
        conexion.desconectarBD(st, conn);
        
        return lista;
        
    }
    
    /**
     * Creamos una coleccion y declaramos la variable p de tipo Producto;
     * en el bucle para cada iteración del ResultSet, se crea una instancia 
     * de Producto con los campos de ese obtenidos del registro y se añaden a 
     * la coleccion.
     * @param rs ResultSet recibido de la consulta
     * @return Coleccion con los Productos creados con el ResultSet
     * @throws SQLException 
     */
    public Collection<Producto> resultadoAProducto(ResultSet rs)
            throws SQLException {
        Collection<Producto> lista = new ArrayList();
        Producto p;
        //tengo que recorrer el resultado de la consulta
        while (rs.next()) {
            p = new Producto(rs.getString("nombre"), 
                rs.getInt("cantidad"), rs.getString("comentario"),
                rs.getString("fecha"), rs.getInt("precio"), 
                rs.getString("descripcion"));
            
            lista.add(p);
        }
        return lista;
    }
    
;}
