/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16.Pojo.TipoProducto;

/**
 *
 * @author Jesús
 */
public class Calzado extends TipoProducto {

    private static TipoProducto calzado;

    private Calzado() {
        super(1);
    }

    /**
     * comprueba si hay una instancia de calzado, si no la hay crea una y la
     * retorna
     *
     * @return
     */
    public static TipoProducto getTipoCalzado() {
        if (calzado == null) {
            Calzado.calzado = new Calzado();
        }
        return calzado;
    }
}
