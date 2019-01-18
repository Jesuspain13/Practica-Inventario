/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16;

import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author Jesús
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto p = new Producto("Camison", 85, "Manga larga", 
                "2019-03-01 12:00:00", 45, "Camison");
        
        ProductoDao dao = new ProductoDao();
        
        try {
            Collection<Producto> lista = dao.buscarProducto("camis");
            for (Producto prod : lista) {
                System.out.println("nombre: " + prod.getNombre() + " tipo: " +
                        prod.getTipoProducto());
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
