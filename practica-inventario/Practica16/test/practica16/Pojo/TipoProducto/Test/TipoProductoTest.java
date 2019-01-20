/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16.Pojo.TipoProducto.Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import practica16.Pojo.TipoProducto.Calzado;
import practica16.Pojo.TipoProducto.Complemento;
import practica16.Pojo.TipoProducto.Ropa;
import practica16.Pojo.TipoProducto.TipoProducto;
import static org.junit.Assert.*;

/**
 *
 * @author Jesus
 */
public class TipoProductoTest {

    public TipoProductoTest() {
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
     * Test of getTipoRopa method, of class Ropa.
     */
    @Test
    public void testGetTipoRopa() {
        System.out.println("getTipoRopa");
        TipoProducto tp = Ropa.getTipoRopa();
        assertNotNull(tp);
    }

    @Test
    public void testGetTipoCalzado() {
        System.out.println("getTipoCalzado");
        TipoProducto tp = Calzado.getTipoCalzado();
        assertNotNull(tp);
    }

    @Test
    public void testGetTipoComplemento() {
        System.out.println("getTipoComplemento");
        TipoProducto tp = Complemento.getTipoComplemento();
        assertNotNull(tp);
    }
}
