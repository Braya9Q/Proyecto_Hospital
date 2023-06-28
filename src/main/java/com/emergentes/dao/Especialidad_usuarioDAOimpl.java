package com.emergentes.dao;

import com.emergentes.modelo.Especialidad_usuario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Especialidad_usuarioDAOimpl extends ConexionDB implements Especialidad_usuarioDAO{

    @Override
    public void insert(Especialidad_usuario esp) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO especialidad_usuario(id_usuario,id_especialidad) VALUES(?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, esp.getId_usuario());
            ps.setInt(2, esp.getId_especialidad());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Especialidad_usuario esp) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE especialidad_usuario SET id_usuario=?, id_especialidad=? WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, esp.getId_usuario());
            ps.setInt(2, esp.getId_especialidad());
            ps.setInt(3, esp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM especialidad_usuario WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Especialidad_usuario getById(int id) throws Exception {
        Especialidad_usuario esp = new Especialidad_usuario();
        try {
            this.conectar();
            String sql = "SELECT * FROM especialidad_usuario WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                esp.setId(rs.getInt("id"));
                esp.setId_usuario(rs.getInt("id_usuario"));
                esp.setId_especialidad(rs.getInt("id_especialidad"));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return esp;
    }

    @Override
    public List<Especialidad_usuario> getAll() throws Exception {
        List<Especialidad_usuario> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT e.id,e.id_usuario,e.id_especialidad,concat(u.nombres,' ',u.paterno,' ',u.materno) as nombre,es.especialidad as especialidad FROM especialidad_usuario e JOIN usuario u ON u.id = e.id_usuario JOIN especialidad es ON e.id_especialidad = es.id;");

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Especialidad_usuario>();

            while (rs.next()) {
                Especialidad_usuario esp = new Especialidad_usuario();

                esp.setId(rs.getInt("id"));
                esp.setId_usuario(rs.getInt("id_usuario"));
                esp.setId_especialidad(rs.getInt("id_especialidad"));
                esp.setNombre(rs.getString("nombre"));
                esp.setEspecialidad(rs.getString("especialidad"));

                lista.add(esp);
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

    @Override
    public List<Especialidad_usuario> buscar(String texto) throws Exception {
        List<Especialidad_usuario> lista = new ArrayList<>();
        String sql = "select * from usuario where id like '%"+texto+"%' or id_usuario like '%"+texto+"%' or id_especialidad like '%"+texto+"%' ";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Especialidad_usuario esp = new Especialidad_usuario();

                esp.setId(rs.getInt("id"));
                esp.setId_usuario(rs.getInt("id_usuario"));
                esp.setId_especialidad(rs.getInt("id_especialidad"));
                esp.setNombre(rs.getString("nombre"));
                esp.setEspecialidad(rs.getString("especialidad"));

                lista.add(esp);
            }
        }catch(Exception e){
        }
        return lista;
    }
    
}
