package com.emergentes.dao;

import com.emergentes.modelo.Clinica;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClinicaDAOimpl extends ConexionDB implements ClinicaDAO{

    @Override
    public void insert(Clinica cli) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Clinica cli) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Clinica getById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Clinica> getAll() throws Exception {
        List<Clinica> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from clinica;");

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Clinica>();

            while (rs.next()) {
                Clinica cli = new Clinica();

                cli.setId(rs.getInt("id"));
                cli.setRazon_social(rs.getString("razon_social"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setTelefono(rs.getString("telefono"));
                cli.setNit(rs.getString("nit"));

                lista.add(cli);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
