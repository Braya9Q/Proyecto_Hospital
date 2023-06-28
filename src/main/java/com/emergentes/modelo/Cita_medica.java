package com.emergentes.modelo;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;


public class Cita_medica {
    private int id;
    private int id_doctor;
    private int id_paciente;
    private String cita;
    private Date fecha_cita;
    private Time hora;
    private DateFormat fecha_registro;
    private DateFormat fecha_actualizacion;
    private String nombresd;
    private String nombres;

    public Cita_medica() {
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

    public String getCita() {
        return cita;
    }

    public void setCita(String cita) {
        this.cita = cita;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
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
        return "Cita_medica{" + "id=" + id + ", id_doctor=" + id_doctor + ", id_paciente=" + id_paciente + ", cita=" + cita + ", fecha_cita=" + fecha_cita + ", hora=" + hora + ", fecha_registro=" + fecha_registro + ", fecha_actualizacion=" + fecha_actualizacion + ", nombresd=" + nombresd + ", nombres=" + nombres + '}';
    }
    
    
    
}
