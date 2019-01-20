/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16.Dao.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import practica16.Dao.ProductoDao;
import practica16.Dao.ProductoDaoImplem;
import static org.junit.Assert.*;
import practica16.Pojo.Producto;

/**
 *
 * @author Jesus
 */
public class ProductoDaoTest {

    public ProductoDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of añadirProducto method, of class ProductoDao. creo un Producto, lo
     * incluyo en la BD, lo busco por nombre, proceso el resultado y lo guardo
     * en una coleccion, la recorro y asgino el id del resultado al Producto
     * creado antes. Finalmente compruebo si la lista contiene el Producto
     * inicial con el id añadido
     */
    @Test
    public void testIncluirProducto() {
        try {
            System.out.println("incluirProducto");
            Producto p = new Producto("Prueba", 1, "Prueba", 1, 3);
            ProductoDao dao = new ProductoDaoImplem();
            dao.incluirProducto(p);
            // TODO review the generated test code and remove the default call to fail.
            Collection<Producto> lista = dao.buscarPorNombre(p.getNombre());
            for (Producto productoBuscado : lista) {
                p.setId(productoBuscado.getId());
            }
            assertEquals(true, lista.contains(p));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Test of mostrarTodosProductos method, of class ProductoDao.
     */
    @Test
    public void testMostrarTodosProductos() {
        try {
            System.out.println("mostrarTodosProductos");
            ProductoDao instance = new ProductoDaoImplem();
            Collection<Producto> result = instance.mostrarTodosProductos();
            assertNotEquals(0, result.size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Test of buscarPorNombre method, of class ProductoDao.
     */
    @Test
    public void testBuscarPorNombre() {
        try {
            System.out.println("buscarPorNombre");
            String nombre = "Cinturon";
            ProductoDao instance = new ProductoDaoImplem();
            Collection<Producto> result = instance.buscarPorNombre(nombre);
            String nombreProducto = new String();
            for (Producto p : result) {
                nombreProducto = p.getNombre();
            }
            assertEquals(nombre, nombreProducto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
