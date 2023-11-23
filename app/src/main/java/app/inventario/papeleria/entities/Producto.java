package app.inventario.papeleria.entities;

import java.io.Serializable;

public class Producto implements Serializable {

    private String nombre;
    private String tipo;
    private int cantidad;
    private double precio;
    private double venta;


    public Producto() {
    }

    public Producto(String nombre, String tipo, int cantidad, double precio, double venta   ) {
        this.nombre= nombre;
        this.tipo= tipo;
        this.cantidad=cantidad;
        this.precio=precio;
        this.venta= venta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getVenta() {
        return venta;
    }

    public void setVenta(double venta) {
        this.venta = venta;
    }
}
