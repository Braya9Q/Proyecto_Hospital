package com.emergentes.modelo;

import java.text.DateFormat;

public class Especialidad_usuario {
    private int id;
    private int id_usuario;
    private int id_especialidad;
    private DateFormat fecha_registro;
    private DateFormat fecha_actualizacion;
    private String nombre;
    private String especialidad;

    public Especialidad_usuario() {
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

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Especialidad_usuario{" + "id=" + id + ", id_usuario=" + id_usuario + ", id_especialidad=" + id_especialidad + ", fecha_registro=" + fecha_registro + ", fecha_actualizacion=" + fecha_actualizacion + ", nombre=" + nombre + ", especialidad=" + especialidad + '}';
    }

     
}
