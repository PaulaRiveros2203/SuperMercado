package com.example.papeleria.entities;

import java.io.Serializable;

public class DatosPersonales implements Serializable  {
    private String nombre, apellido, email, tipoDocumento,numeroDocumento, telefono, celular;

    private boolean acepto;

    public DatosPersonales() {
    }

    public DatosPersonales(String nombre, String apellido, String email, String tipoDocumento, String numeroDocumento, String telefono, String celular, boolean acepto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.celular = celular;
        this.acepto = acepto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isAcepto() {
        return acepto;
    }

    public void setAcepto(boolean acepto) {
        this.acepto = acepto;
    }
}

