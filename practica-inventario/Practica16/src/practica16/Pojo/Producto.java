/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16.Pojo;

import java.util.Date;
import java.util.Objects;
import practica16.Pojo.TipoProducto.Ropa;
import practica16.Pojo.TipoProducto.Complemento;
import practica16.Pojo.TipoProducto.Calzado;
import practica16.Pojo.TipoProducto.TipoProducto;

/**
 *
 * @author Jesús
 */
public class Producto {

    private int id;
    private String nombre;
    private int cantidad;
    private String comentario;
    private Date fecha;
    private int precio;
    private int tipoId;
    private TipoProducto tipoProducto;

    public Producto() {

    }

    //constructor para los datos de la BD
    public Producto(int id, String nombre, int cant, String coment,
            int precio, int tipoId) {
        this(nombre, cant, coment, precio, tipoId);
        this.id = id;
    }

    //producto que se crea para guardar en la bd (no necesita id)
    public Producto(String nombre, int cant, String coment,
            int precio, int tipoId) {
        this.nombre = nombre;
        this.cantidad = cant;
        this.comentario = coment;
        this.fecha = new Date();
        this.precio = precio;
        this.tipoId = tipoId;
    }

    //Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public TipoProducto getTipoProducto() {
        if (this.tipoProducto == null) {
            TipoProducto tp = establecerTipoProducto();
        }
        return establecerTipoProducto();
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.setTipoId(tipoProducto.getTipoId());
        this.tipoProducto = establecerTipoProducto();
    }

    /**
     * comprueba el atributo tipoId y establece el atributo tipoProducto en
     * función del primero.
     *
     * @return Calzado/Ropa/Complemento
     */
    private TipoProducto establecerTipoProducto() {
        switch (this.tipoId) {
            case 1:
                this.tipoProducto = Calzado.getTipoCalzado();
                break;
            case 2:
                this.tipoProducto = Ropa.getTipoRopa();
                break;
            case 3:
                this.tipoProducto = Complemento.getTipoComplemento();
                break;
            default:
                break;
        }
        return tipoProducto;
    }

    @Override
    public String toString() {
        return "id: " + id + ",\n"
                + "nombre: " + nombre + ",\n"
                + "cantidad: " + cantidad + ",\n"
                + "comentario: " + comentario + ",\n"
                + "fecha: " + fecha + ",\n"
                + "precio: " + precio + ",\n"
                + "tipoid: " + tipoId + ",\n"
                + "descripcion: " + this.getTipoProducto().getDescripcion();
    }

    @Override
    public boolean equals(Object obj) {
        Producto p = (Producto) obj;
        return ((this.nombre.equals(p.getNombre())) && (this.id == p.getId()));
    }

}
