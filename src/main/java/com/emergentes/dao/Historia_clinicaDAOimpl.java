package com.emergentes.dao;

import com.emergentes.modelo.Historia_clinica;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Historia_clinicaDAOimpl extends ConexionDB implements Historia_clinicaDAO {

    @Override
    public void insert(Historia_clinica h) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO historia_clinica(id_doctor,id_paciente,historia,fecha_atencion) VALUES(?,?,?,?)");
            ps.setInt(1, h.getId_doctor());
            ps.setInt(2, h.getId_paciente());
            ps.setString(3, h.getHistoria());
            ps.setDate(4, h.getFecha_atencion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Historia_clinica h) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE historia_clinica SET id_doctor=?, id_paciente=?, historia=?, fecha_atencion=? WHERE id=?");
            ps.setInt(1, h.getId_doctor());
            ps.setInt(2, h.getId_paciente());
            ps.setString(3, h.getHistoria());
            ps.setDate(4, h.getFecha_atencion());
            ps.setInt(5, h.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM historia_clinica WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Historia_clinica getById(int id) throws Exception {
        Historia_clinica h = new Historia_clinica();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM historia_clinica WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                h.setId(rs.getInt("id"));
                h.setId_doctor(rs.getInt("id_doctor"));
                h.setId_paciente(rs.getInt("id_paciente"));
                h.setHistoria(rs.getString("historia"));
                h.setFecha_atencion(rs.getDate("fecha_atencion"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return h;
    }

    @Override
    public List<Historia_clinica> getAll() throws Exception {
        List<Historia_clinica> lista = null;
        try {
            this.conectar();
            String sql = "select h.*,concat(u.nombres,' ',u.paterno,' ',u.materno) ";
            sql += "as nombresd,concat(p.nombres,' ',p.paterno,' ',p.materno) as nombres ";
            sql += "from historia_clinica h join usuario u on h.id_doctor = u.id ";
            sql += "join paciente p on p.id = h.id_paciente;";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Historia_clinica>();

            while (rs.next()) {
                Historia_clinica h = new Historia_clinica();

                h.setId(rs.getInt("id"));
                h.setId_doctor(rs.getInt("id_doctor"));
                h.setId_paciente(rs.getInt("id_paciente"));
                h.setHistoria(rs.getString("historia"));
                h.setFecha_atencion(rs.getDate("fecha_atencion"));
                h.setNombresd(rs.getString("nombresd"));
                h.setNombres(rs.getString("nombres"));

                lista.add(h);
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
    public List<Historia_clinica> buscar(String texto) throws Exception {
        List<Historia_clinica> lista = new ArrayList<>();
        String sql = "select * from historia_clinica where id like '%"+texto+"%' or id_doctor like '%"+texto+"%' or id_paciente like '%"+texto+"%' or historia like '%"+texto+"%' or fecha_atencion like '%"+texto+"%' ";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Historia_clinica h = new Historia_clinica();

                h.setId(rs.getInt("id"));
                h.setId_doctor(rs.getInt("id_doctor"));
                h.setId_paciente(rs.getInt("id_paciente"));
                h.setHistoria(rs.getString("historia"));
                h.setFecha_atencion(rs.getDate("fecha_atencion"));
                h.setNombresd(rs.getString("nombresd"));
                h.setNombres(rs.getString("nombres"));

                lista.add(h);
            }
        }catch(Exception e){
        }
        return lista;
    }

}
