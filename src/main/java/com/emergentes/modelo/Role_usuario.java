package com.emergentes.modelo;

import java.text.DateFormat;

public class Role_usuario {
    private int id;
    private int id_usuario;
    private int id_role;
    private DateFormat fecha_registro;
    private DateFormat fecha_actualizacion;
    private String nombre;
    private String role;

    public Role_usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role_usuario{" + "id=" + id + ", id_usuario=" + id_usuario + ", id_role=" + id_role + ", fecha_registro=" + fecha_registro + ", fecha_actualizacion=" + fecha_actualizacion + ", nombre=" + nombre + ", role=" + role + '}';
    }

    
    
    
}
