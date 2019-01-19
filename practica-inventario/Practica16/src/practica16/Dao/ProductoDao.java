/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16.Dao;

import java.sql.SQLException;
import java.util.Collection;
import practica16.Pojo.Producto;

/**
 *
 * @author Jesús
 */
public interface ProductoDao {
    /**
     * establece conexion con la base de datos, crea una sentencia SQL 
     * con la info del producto y ejecuta el UPDATE mandando la sentencia,
     * despues se desconecta
     * @param p
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void añadirProducto(Producto p) 
            throws ClassNotFoundException, SQLException;
    
    /**
     * hace una consulta a la base de datos para recoger todos los productos,
     * crea un objeto java Producto por iteración, para poder añadirlo
     * a una lista y mandarla al usuario .
     * @return coleccion con los Productos encontrados
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Collection<Producto> mostrarTodosProductos() 
            throws ClassNotFoundException, SQLException;
    
    /**
     * conecta con la bd, hace una consulta para la columna nombre donde esté la 
     * cadena pasada como argumento, procesa el resultado, lo retorna y cierra 
     * la conexion.
     * @param nombre
     * @return coleccion con los Productos encontrados para la condicion 
     * establecida
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Collection<Producto> buscarPorNombre(String nombre) 
        throws ClassNotFoundException, SQLException;
    
}
