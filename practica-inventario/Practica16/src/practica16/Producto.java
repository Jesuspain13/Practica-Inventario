/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16;

/**
 *
 * @author Jesús
 */
public class Producto {
    private int id;
    private String nombre;
    private int cantidad;
    private String comentario;
    private String fecha;
    private int precio;
    private String tipoProducto;
    
    public Producto(){
        
    }
    
    //producto que se crea desde bd para mostrarlo
    public Producto(int id, String nombre, int cant, String coment,
            String fecha, int precio, String tipoProducto) {
        this(nombre, cant, coment, fecha, precio, tipoProducto);
        this.id = id;
    }
    
    //producto que se crea para guardar en la bd (no necesita id)
    public Producto(String nombre, int cant, String coment,
            String fecha, int precio, String tipoProducto) {
        this.nombre = nombre;
        this.cantidad = cant;
        this.comentario = coment;
        this.fecha = fecha;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    
}
