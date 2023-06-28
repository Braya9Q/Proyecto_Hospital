package com.emergentes.modelo;

import java.text.DateFormat;

public class Especialidad {
    private int id;
    private String especialidad;
    private DateFormat fecha_registro;
    private DateFormat fecha_actualizacion;

    public Especialidad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    @Override
    public String toString() {
        return "Especialidad{" + "id=" + id + ", especialidad=" + especialidad + ", fecha_registro=" + fecha_registro + ", fecha_actualizacion=" + fecha_actualizacion + '}';
    }
    
    
}
