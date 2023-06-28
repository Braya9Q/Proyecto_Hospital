package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO{

    @Override
    public void insert(Usuario usr) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO usuario(id_clinica,usuario,clave,nombres,paterno,materno,ci,expedido,telefono,direccion,correo) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, usr.getId_clinica());
            ps.setString(2, usr.getUsuario());
            ps.setString(3, usr.getClave());
            ps.setString(4, usr.getNombres());
            ps.setString(5, usr.getPaterno());
            ps.setString(6, usr.getMaterno());
            ps.setString(7, usr.getCi());
            ps.setString(8, usr.getExpedido());
            ps.setString(9, usr.getTelefono());
            ps.setString(10, usr.getDireccion());
            ps.setString(11, usr.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Usuario usr) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE usuario SET id_clinica=?, usuario=?, clave=?, nombres=?, paterno=?, materno=?, ci=?, expedido=?, telefono=?, direccion=?, correo=?, fecha_actualizacion=? WHERE id=?");
            ps.setInt(1, usr.getId_clinica());
            ps.setString(2, usr.getUsuario());
            ps.setString(3, usr.getClave());
            ps.setString(4, usr.getNombres());
            ps.setString(5, usr.getPaterno());
            ps.setString(6, usr.getMaterno());
            ps.setString(7, usr.getCi());
            ps.setString(8, usr.getExpedido());
            ps.setString(9, usr.getTelefono());
            ps.setString(10, usr.getDireccion());
            ps.setString(11, usr.getCorreo());
            ps.setInt(13, usr.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM usuario WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Usuario getById(int id) throws Exception {
        Usuario usr = new Usuario();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM usuario WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usr.setId(rs.getInt("id"));
                usr.setId_clinica(rs.getInt("id_clinica"));
                usr.setUsuario(rs.getString("usuario"));
                usr.setClave(rs.getString("clave"));
                usr.setNombres(rs.getString("nombres"));
                usr.setPaterno(rs.getString("paterno"));
                usr.setMaterno(rs.getString("materno"));
                usr.setCi(rs.getString("ci"));
                usr.setExpedido(rs.getString("expedido"));
                usr.setTelefono(rs.getString("telefono"));
                usr.setDireccion(rs.getString("direccion"));
                usr.setCorreo(rs.getString("correo"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return usr;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select u.*,c.razon_social as razon_social from usuario u join clinica c on u.id_clinica = c.id;");

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Usuario>();

            while (rs.next()) {
                Usuario usr = new Usuario();

                usr.setId(rs.getInt("id"));
                usr.setId_clinica(rs.getInt("id_clinica"));
                usr.setUsuario(rs.getString("usuario"));
                usr.setClave(rs.getString("clave"));
                usr.setNombres(rs.getString("nombres"));
                usr.setPaterno(rs.getString("paterno"));
                usr.setMaterno(rs.getString("materno"));
                usr.setCi(rs.getString("ci"));
                usr.setExpedido(rs.getString("expedido"));
                usr.setTelefono(rs.getString("telefono"));
                usr.setDireccion(rs.getString("direccion"));
                usr.setCorreo(rs.getString("correo"));
                usr.setRazon_social(rs.getString("razon_social"));

                lista.add(usr);
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
    public List<Usuario> buscar(String texto) throws Exception {
        List<Usuario> lista = new ArrayList<>();
        String sql = "select * from usuario where id like '%"+texto+"%' or id_clinica like '%"+texto+"%' or usuario like '%"+texto+"%' or clave like '%"+texto+"%' or nombres like '%"+texto+"%' or paterno like '%"+texto+"%' or materno like '%"+texto+"%' or ci like '%"+texto+"%' or expedido like '%"+texto+"%' or telefono like '%"+texto+"%' or direccion like '%"+texto+"%' or correo like '%"+texto+"%' ";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario usr = new Usuario();

                usr.setId(rs.getInt("id"));
                usr.setId_clinica(rs.getInt("id_clinica"));
                usr.setUsuario(rs.getString("usuario"));
                usr.setClave(rs.getString("clave"));
                usr.setNombres(rs.getString("nombres"));
                usr.setPaterno(rs.getString("paterno"));
                usr.setMaterno(rs.getString("materno"));
                usr.setCi(rs.getString("ci"));
                usr.setExpedido(rs.getString("expedido"));
                usr.setTelefono(rs.getString("telefono"));
                usr.setDireccion(rs.getString("direccion"));
                usr.setCorreo(rs.getString("correo"));
                lista.add(usr);
            }
        }catch(Exception e){
        }
        return lista;
    }
    
   
}
