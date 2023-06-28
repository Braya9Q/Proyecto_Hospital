package com.emergentes.modelo;

public class Clinica {
    private int id;
    private String razon_social;
    private String direccion;
    private String telefono;
    private String nit;

    public Clinica() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "Clinica{" + "id=" + id + ", razon_social=" + razon_social + ", direccion=" + direccion + ", telefono=" + telefono + ", nit=" + nit + '}';
    }
    
    
    
    
    
}
