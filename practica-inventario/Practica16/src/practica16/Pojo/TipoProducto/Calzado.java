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
public class Calzado extends TipoProducto {
    private static TipoProducto calzado;
    
    private Calzado(int tipoId) {
        super(tipoId);
    }

    /**
     * comprueba si hay una instancia de calzado, si no la hay crea una y la 
     * retorna
     * @return 
     */
    public static TipoProducto getTipoCalzado() {
        if (calzado == null) {
           Calzado.calzado = new Calzado(1);
        }
        return calzado;
    } 
}
