/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16.Test;

import java.sql.SQLException;
import java.util.Collection;
import practica16.Pojo.Producto;
import practica16.Dao.ProductoDaoImplem;
import practica16.Pojo.TipoProducto.Ropa;

/**
 *
 * @author Jesús
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto p = new Producto("Cartera", 40, "Cuero", 
                "2019-03-01 12:00:00", 30, 3);
        
        ProductoDaoImplem dao = new ProductoDaoImplem();
        
        try {
            dao.añadirProducto(p);
            for (Producto caca : dao.mostrarTodosProductos()) {
                System.out.println(caca);
                System.out.println("====================================");
                Thread.sleep(1000);
            }
                    
        } catch (SQLException ex) {
            System.err.println("Error conexion base datos");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("Error cargar driver");
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            System.err.println("Error cargar driver");
            ex.printStackTrace();
        }
    }
    
}
