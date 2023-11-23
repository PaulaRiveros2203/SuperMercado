package app.inventario.papeleria.entities;

import java.io.Serializable;

public class Registrarse implements Serializable {
    private String nombre, descripcion ;

    public Registrarse() {
    }

    public Registrarse(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
