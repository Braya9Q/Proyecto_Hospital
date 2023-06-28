package com.emergentes.dao;

import com.emergentes.modelo.Cita_medica;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Cita_medicaDAOimpl extends ConexionDB implements Cita_medicaDAO {

    @Override
    public void insert(Cita_medica ctm) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO cita_medica(id_doctor,id_paciente,cita,fecha_cita,hora) VALUES(?,?,?,?,?)");
            ps.setInt(1, ctm.getId_doctor());
            ps.setInt(2, ctm.getId_paciente());
            ps.setString(3, ctm.getCita());
            ps.setDate(4, ctm.getFecha_cita());
            ps.setTime(5, ctm.getHora());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Cita_medica ctm) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE cita_medica SET id_doctor=?, id_paciente=?, cita=?, fecha_cita=?, hora=? WHERE id=?");
            ps.setInt(1, ctm.getId_doctor());
            ps.setInt(2, ctm.getId_paciente());
            ps.setString(3, ctm.getCita());
            ps.setDate(4, ctm.getFecha_cita());
            ps.setTime(5, ctm.getHora());
            ps.setInt(6, ctm.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM cita_medica WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Cita_medica getById(int id) throws Exception {
        Cita_medica ctm = new Cita_medica();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM cita_medica WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ctm.setId(rs.getInt("id"));
                ctm.setId_doctor(rs.getInt("id_doctor"));
                ctm.setId_paciente(rs.getInt("id_paciente"));
                ctm.setCita(rs.getString("cita"));
                ctm.setFecha_cita(rs.getDate("fecha_cita"));
                ctm.setHora(rs.getTime("hora"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return ctm;
    }

    @Override
    public List<Cita_medica> getAll() throws Exception {
        List<Cita_medica> lista = null;
        try {
            this.conectar();
            String sql = "select c.*,concat(u.nombres,' ',u.paterno,' ',u.materno) as nombresd,";
            sql += "concat(p.nombres,' ',p.paterno,' ',p.materno) as nombres from cita_medica c ";
            sql += "join usuario u on c.id_doctor = u.id join paciente p on p.id = c.id_paciente;";

            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Cita_medica>();

            while (rs.next()) {
                Cita_medica ctm = new Cita_medica();

                ctm.setId(rs.getInt("id"));
                ctm.setId_doctor(rs.getInt("id_doctor"));
                ctm.setId_paciente(rs.getInt("id_paciente"));
                ctm.setCita(rs.getString("cita"));
                ctm.setFecha_cita(rs.getDate("fecha_cita"));
                ctm.setHora(rs.getTime("hora"));
                ctm.setNombresd(rs.getString("nombresd"));
                ctm.setNombres(rs.getString("nombres"));

                lista.add(ctm);
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
    public List<Cita_medica> buscar(String texto) throws Exception {
        List<Cita_medica> lista = new ArrayList<>();
        String sql = "select * from usuario where id like '%"+texto+"%' or id_doctor like '%"+texto+"%' or id_paciente like '%"+texto+"%' or cita like '%"+texto+"%' or fecha_cita like '%"+texto+"%' or hora like '%"+texto+"%' ";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Cita_medica ctm = new Cita_medica();

                ctm.setId(rs.getInt("id"));
                ctm.setId_doctor(rs.getInt("id_doctor"));
                ctm.setId_paciente(rs.getInt("id_paciente"));
                ctm.setCita(rs.getString("cita"));
                ctm.setFecha_cita(rs.getDate("fecha_cita"));
                ctm.setHora(rs.getTime("hora"));
                ctm.setNombresd(rs.getString("nombresd"));
                ctm.setNombres(rs.getString("nombres"));

                lista.add(ctm);
            }
        }catch(Exception e){
        }
        return lista;
    }

}
