package com.emergentes.modelo;

import java.text.DateFormat;

public class Usuario {
    private int id;
    private int id_clinica;
    private String usuario;
    private String clave;
    private String nombres;
    private String paterno;
    private String materno;
    private String ci;
    private String expedido;
    private String telefono;
    private String direccion;
    private String correo;
    private DateFormat fecha_registro;
    private DateFormat fecha_actualizacion;
    private String razon_social;

    public Usuario() {
        this.id = 0;
        this.id_clinica = 0;
        this.usuario = "";
        this.clave = "";
        this.nombres = "";
        this.paterno = "";
        this.materno = "";
        this.ci = "";
        this.expedido = "";
        this.telefono = "";
        this.direccion = "";
        this.correo = "";
        this.razon_social="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_clinica() {
        return id_clinica;
    }

    public void setId_clinica(int id_clinica) {
        this.id_clinica = id_clinica;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getExpedido() {
        return expedido;
    }

    public void setExpedido(String expedido) {
        this.expedido = expedido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public DateFormat getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(DateFormat fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public DateFormat getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(DateFormat fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", id_clinica=" + id_clinica + ", usuario=" + usuario + ", clave=" + clave + ", nombres=" + nombres + ", paterno=" + paterno + ", materno=" + materno + ", ci=" + ci + ", expedido=" + expedido + ", telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + ", fecha_registro=" + fecha_registro + ", fecha_actualizacion=" + fecha_actualizacion + ", razon_social=" + razon_social + '}';
    }
    
    
    
    
    
}
