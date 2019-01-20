/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16.Test;

import java.sql.SQLException;
import java.text.ParseException;
import practica16.Pojo.Producto;
import practica16.Dao.ProductoDaoImplem;

/**
 *
 * @author Jesús
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // prueba de los 3 métodos de la práctica
            Producto p = new Producto("Pantalon", 25, "Vaquero", 75, 2);

            ProductoDaoImplem dao = new ProductoDaoImplem();

            System.out.println("Añadir Producto");
            dao.incluirProducto(p);
            System.out.println("====================================");

            System.out.println("Filtrar por nombre.");
            for (Producto producto : dao.buscarPorNombre(p.getNombre())) {
                System.out.println(producto);
                System.out.println("====================================");
                Thread.sleep(1000);
            }

            System.out.println("Mostrar todos los productos.");
            for (Producto producto : dao.mostrarTodosProductos()) {
                System.out.println(producto);
                System.out.println("====================================");
                Thread.sleep(1000);
            }

        } catch (SQLException ex) {
            System.err.println("Error conexion base datos."
                    + " Intentelo más tarde");
            //ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("Error al cargar el driver JDBC."
                    + " Intentelo más tarde");
            //ex.printStackTrace();
        } catch (InterruptedException ex) {
            System.err.println("Error en la interrupción del hilo.");
            //ex.printStackTrace();
        }
    }

}
