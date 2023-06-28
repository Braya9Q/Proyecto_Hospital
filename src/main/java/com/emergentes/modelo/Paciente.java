package com.emergentes.modelo;

import java.sql.Date;
import java.text.DateFormat;


public class Paciente {
    private int id;
    private String nombres;
    private String paterno;
    private String materno;
    private Date fecha_nacimiento;
    private String sexo;
    private String ci;
    private String expedido;
    private String telefono;
    private String direccion;
    private String correo;
    private DateFormat fecha_registro;
    private DateFormat fecha_actualizacion;

    public Paciente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nombres=" + nombres + ", paterno=" + paterno + ", materno=" + materno + ", fecha_nacimiento=" + fecha_nacimiento + ", sexo=" + sexo + ", ci=" + ci + ", expedido=" + expedido + ", telefono=" + telefono + ", direccion=" + direccion + ", correo=" + correo + ", fecha_registro=" + fecha_registro + ", fecha_actualizacion=" + fecha_actualizacion + '}';
    }
    
    
    
}
