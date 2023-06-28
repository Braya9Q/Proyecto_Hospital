package com.emergentes.modelo;

import java.sql.Date;
import java.text.DateFormat;

public class Historia_clinica {
    private int id;
    private int id_doctor;
    private int id_paciente;
    private String historia;
    private Date fecha_atencion;
    private DateFormat fecha_registro;
    private DateFormat fecha_actualizacion;
    private String nombresd;
    private String nombres;

    public Historia_clinica() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Date getFecha_atencion() {
        return fecha_atencion;
    }

    public void setFecha_atencion(Date fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
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

    public String getNombresd() {
        return nombresd;
    }

    public void setNombresd(String nombresd) {
        this.nombresd = nombresd;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public String toString() {
        return "Historia_clinica{" + "id=" + id + ", id_doctor=" + id_doctor + ", id_paciente=" + id_paciente + ", historia=" + historia + ", fecha_atencion=" + fecha_atencion + ", fecha_registro=" + fecha_registro + ", fecha_actualizacion=" + fecha_actualizacion + ", nombresd=" + nombresd + ", nombres=" + nombres + '}';
    }
    
    
}
