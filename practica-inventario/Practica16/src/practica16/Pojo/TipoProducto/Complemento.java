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
public class Complemento extends TipoProducto {

    private static TipoProducto complementos;

    private Complemento() {
        super(3);
    }

    /**
     * comprueba si hay una instancia de calzado, si no la hay crea una y la
     * retorna
     *
     * @return
     */
    public static TipoProducto getTipoComplemento() {
        if (complementos == null) {
            Complemento.complementos = new Complemento();
        }
        return complementos;
    }
}
