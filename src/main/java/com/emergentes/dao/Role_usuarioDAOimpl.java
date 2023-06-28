package com.emergentes.dao;

import com.emergentes.modelo.Role_usuario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Role_usuarioDAOimpl extends ConexionDB implements Role_usuarioDAO{

    @Override
    public void insert(Role_usuario rol) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO role_usuario(id_usuario,id_role) VALUES(?,?)");
            ps.setInt(1, rol.getId_usuario());
            ps.setInt(2, rol.getId_role());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Role_usuario rol) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE role_usuario SET id_usuario=?, id_role=? WHERE id=?");
            ps.setInt(1, rol.getId_usuario());
            ps.setInt(2, rol.getId_role());
            ps.setInt(3, rol.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM role_usuario WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Role_usuario getById(int id) throws Exception {
        Role_usuario rol = new Role_usuario();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM role_usuario WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rol.setId(rs.getInt("id"));
                rol.setId_usuario(rs.getInt("id_usuario"));
                rol.setId_role(rs.getInt("id_role"));           
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return rol;
    }

    @Override
    public List<Role_usuario> getAll() throws Exception {
        List<Role_usuario> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT r.id,r.id_usuario,r.id_role,concat(u.nombres,' ',u.paterno,' ',u.materno) as nombre,ro.role as role FROM role_usuario r JOIN usuario u ON u.id = r.id_usuario JOIN role ro ON r.id_role = ro.id;");

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Role_usuario>();

            while (rs.next()) {
                Role_usuario rol = new Role_usuario();

                rol.setId(rs.getInt("id"));
                rol.setId_usuario(rs.getInt("id_usuario"));
                rol.setId_role(rs.getInt("id_role"));
                rol.setNombre(rs.getString("nombre"));
                rol.setRole(rs.getString("role"));

                lista.add(rol);
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
    public List<Role_usuario> buscar(String texto) throws Exception {
        List<Role_usuario> lista = new ArrayList<>();
        String sql = "select * from role_usuario where id like '%"+texto+"%' or id_usuario like '%"+texto+"%' or id_role like '%"+texto+"%' ";
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
                Role_usuario rol = new Role_usuario();

                rol.setId(rs.getInt("id"));
                rol.setId_usuario(rs.getInt("id_usuario"));
                rol.setId_role(rs.getInt("id_role"));
                rol.setNombre(rs.getString("nombre"));
                rol.setRole(rs.getString("role"));

                lista.add(rol);
            }
        }catch(Exception e){
        }
        return lista;
    }
    
}
