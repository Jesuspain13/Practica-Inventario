/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16.Pojo.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import practica16.Pojo.Producto;
import static org.junit.Assert.*;
import practica16.Pojo.TipoProducto.Calzado;
import practica16.Pojo.TipoProducto.Complemento;
import practica16.Pojo.TipoProducto.TipoProducto;

/**
 *
 * @author Jesus
 */
public class ProductoTest {

    public ProductoTest() {
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
     * Test of getId method, of class Producto.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);

        assertEquals(1, instance.getId());

    }

    /**
     * Test of setId method, of class Producto.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);

        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getNombre method, of class Producto.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);

        assertEquals("Cinturon", instance.getNombre());

    }

    /**
     * Test of setNombre method, of class Producto.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Correa";
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);

        instance.setNombre(nombre);
        assertEquals(nombre, instance.getNombre());
    }

    /**
     * Test of getCantidad method, of class Producto.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);

        assertEquals(1, instance.getCantidad());

    }

    /**
     * Test of setCantidad method, of class Producto.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        int cantidad = 0;
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);
        instance.setCantidad(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(cantidad, instance.getCantidad());
    }

    /**
     * Test of getPrecio method, of class Producto.
     */
    @Test
    public void testGetPrecio() {
        System.out.println("getPrecio");
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);

        assertEquals(1, instance.getPrecio());

    }

    /**
     * Test of setPrecio method, of class Producto.
     */
    @Test
    public void testSetPrecio() {
        System.out.println("setPrecio");
        int precio = 0;
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);
        instance.setPrecio(precio);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(precio, instance.getPrecio());
    }

    /**
     * Test of getComentario method, of class Producto.
     */
    @Test
    public void testGetComentario() {
        System.out.println("getComentario");
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);

        assertEquals("Cuero", instance.getComentario());

    }

    /**
     * Test of setComentario method, of class Producto.
     */
    @Test
    public void testSetComentario() {
        System.out.println("setComentario");
        String comentario = "Piel";
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);
        instance.setComentario(comentario);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(comentario, instance.getComentario());
    }

    /**
     * Test of getFecha method, of class Producto.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);

        Date ahora = new Date();
        assertEquals(ahora, instance.getFecha());
    }

    /**
     * Test of setFecha method, of class Producto.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = new Date();
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(fecha, instance.getFecha());
    }

    /**
     * Test of getTipoId method, of class Producto.
     */
    @Test
    public void testGetTipoId() {
        System.out.println("getTipoId");
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);

        assertEquals(3, instance.getTipoId());
    }

    /**
     * Test of setTipoId method, of class Producto.
     */
    @Test
    public void testSetTipoId() {
        System.out.println("setTipoId");
        int tipoId = 0;
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);
        instance.setTipoId(tipoId);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(tipoId, instance.getTipoId());
    }

    /**
     * Test of getTipoProducto method, of class Producto.
     */
    @Test
    public void testGetTipoProducto() {
        System.out.println("getTipoProducto");
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);

        TipoProducto c = Complemento.getTipoComplemento();

        assertEquals(c.getDescripcion(), instance.getTipoProducto().getDescripcion());
    }

    /**
     * Test of setTipoProducto method, of class Producto.
     */
    @Test
    public void testSetTipoProducto() {
        System.out.println("setTipoProducto");
        TipoProducto tipoProducto = Calzado.getTipoCalzado();
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);
        instance.setTipoProducto(tipoProducto);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(tipoProducto, instance.getTipoProducto());
    }

    /**
     * Test of toString method, of class Producto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Date ahora = new Date();
        Producto instance = new Producto(1, "Cinturon", 1, "Cuero", 1, 3);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String resultado = "id: 1,\n"
                + "nombre: Cinturon,\n"
                + "cantidad: 1,\n"
                + "comentario: Cuero,\n"
                + "fecha: " + ahora + ",\n"
                + "precio: 1,\n"
                + "tipoid: 3,\n"
                + "descripcion: Complemento";
        assertEquals(resultado, instance.toString());
    }

}
