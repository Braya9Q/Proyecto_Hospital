package com.emergentes.dao;

import com.emergentes.modelo.Role;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOimpl extends ConexionDB implements RoleDAO{

    @Override
    public void insert(Role r) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Role r) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Role getById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Role> getAll() throws Exception {
        List<Role> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM role");

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Role>();

            while (rs.next()) {
                Role e = new Role();

                e.setId(rs.getInt("id"));
                e.setRole(rs.getString("role"));

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
