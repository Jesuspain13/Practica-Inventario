/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16.Pojo.TipoProducto;

import practica16.Pojo.TipoProducto.TipoProducto;

/**
 *
 * @author Jesús
 */
public class Ropa extends TipoProducto{
    private static TipoProducto ropa;
    
    private Ropa(int tipoId) {
        super(tipoId);
    }

    /**
     * comprueba si hay una instancia de calzado, si no la hay crea una y la 
     * retorna
     * @return 
     */
    public static TipoProducto getTipoRopa() {
        if (ropa == null) {
           Ropa.ropa = new Ropa(2);
        }
        return ropa;
    }

}
