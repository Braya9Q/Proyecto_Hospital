package com.emergentes.dao;

import com.emergentes.modelo.Paciente;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOimpl extends ConexionDB implements PacienteDAO{

    @Override
    public void insert(Paciente pac) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO paciente(nombres,paterno,materno,fecha_nacimiento,sexo,ci,expedido,telefono,direccion,correo) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, pac.getNombres());
            ps.setString(2, pac.getPaterno());
            ps.setString(3, pac.getMaterno());
            ps.setDate(4, pac.getFecha_nacimiento());
            ps.setString(5, pac.getSexo());
            ps.setString(6, pac.getCi());
            ps.setString(7, pac.getExpedido());
            ps.setString(8, pac.getTelefono());
            ps.setString(9, pac.getDireccion());
            ps.setString(10, pac.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Paciente pac) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE paciente SET nombres=?, materno=?, paterno=?, fecha_nacimiento=?, sexo=?, ci=?, expedido=?, telefono=?, direccion=?, correo=? WHERE id=?");
            ps.setString(1, pac.getNombres());
            ps.setString(2, pac.getPaterno());
            ps.setString(3, pac.getMaterno());
            ps.setDate(4, pac.getFecha_nacimiento());
            ps.setString(5, pac.getSexo());
            ps.setString(6, pac.getCi());
            ps.setString(7, pac.getExpedido());
            ps.setString(8, pac.getTelefono());
            ps.setString(9, pac.getDireccion());
            ps.setString(10, pac.getCorreo());
            ps.setInt(11, pac.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM paciente WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Paciente getById(int id) throws Exception {
        Paciente pac = new Paciente();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM paciente WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pac.setId(rs.getInt("id"));
                pac.setNombres(rs.getString("nombres"));
                pac.setPaterno(rs.getString("paterno"));
                pac.setMaterno(rs.getString("materno"));
                pac.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                pac.setSexo(rs.getString("sexo"));
                pac.setCi(rs.getString("ci"));
                pac.setExpedido(rs.getString("expedido"));
                pac.setTelefono(rs.getString("telefono"));
                pac.setDireccion(rs.getString("direccion"));
                pac.setCorreo(rs.getString("correo"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return pac;
    }

    @Override
    public List<Paciente> getAll() throws Exception {
        List<Paciente> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM paciente");

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Paciente>();

            while (rs.next()) {
                Paciente pac = new Paciente();

                pac.setId(rs.getInt("id"));
                pac.setNombres(rs.getString("nombres"));
                pac.setPaterno(rs.getString("paterno"));
                pac.setMaterno(rs.getString("materno"));
                pac.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                pac.setSexo(rs.getString("sexo"));
                pac.setCi(rs.getString("ci"));
                pac.setExpedido(rs.getString("expedido"));
                pac.setTelefono(rs.getString("telefono"));
                pac.setDireccion(rs.getString("direccion"));
                pac.setCorreo(rs.getString("correo"));

                lista.add(pac);
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
    public List<Paciente> buscar(String texto) throws Exception {
        List<Paciente> lista = new ArrayList<>();
        String sql = "select * from paciente where id like '%"+texto+"%' or nombres like '%"+texto+"%' or paterno like '%"+texto+"%' or materno like '%"+texto+"%' or fecha_nacimiento like '%"+texto+"%' or sexo like '%"+texto+"%' or ci like '%"+texto+"%' or expedido like '%"+texto+"%' or telefono like '%"+texto+"%' or direccion like '%"+texto+"%' or correo like '%"+texto+"%' ";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Paciente pac = new Paciente();

                pac.setId(rs.getInt("id"));
                pac.setNombres(rs.getString("nombres"));
                pac.setPaterno(rs.getString("paterno"));
                pac.setMaterno(rs.getString("materno"));
                pac.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                pac.setSexo(rs.getString("sexo"));
                pac.setCi(rs.getString("ci"));
                pac.setExpedido(rs.getString("expedido"));
                pac.setTelefono(rs.getString("telefono"));
                pac.setDireccion(rs.getString("direccion"));
                pac.setCorreo(rs.getString("correo"));

                lista.add(pac);
            }
        }catch(Exception e){
        }
        return lista;
    }
    
}
