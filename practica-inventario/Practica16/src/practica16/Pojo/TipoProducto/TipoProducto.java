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
public class TipoProducto {
    private int tipoId;
    private String descripcion;
    
    public TipoProducto(int tipoId) {
        this.tipoId = tipoId;
        switch(this.tipoId){
            case 1:
                this.descripcion = "Calzado";
                break;
            case 2:
                this.descripcion = "Ropa";
                break;
            case 3:
                this.descripcion = "Complementos";
                break;
        }
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

} 

