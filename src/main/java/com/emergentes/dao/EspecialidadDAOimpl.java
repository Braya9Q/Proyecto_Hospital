package com.emergentes.dao;

import com.emergentes.modelo.Especialidad;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadDAOimpl extends ConexionDB implements EspecialidadDAO{

    @Override
    public void insert(Especialidad e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Especialidad e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Especialidad getById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Especialidad> getAll() throws Exception {
        List<Especialidad> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM especialidad");

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Especialidad>();

            while (rs.next()) {
                Especialidad e = new Especialidad();

                e.setId(rs.getInt("id"));
                e.setEspecialidad(rs.getString("especialidad"));

                lista.add(e);
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
