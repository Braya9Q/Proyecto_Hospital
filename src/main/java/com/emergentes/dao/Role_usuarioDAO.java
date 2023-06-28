package com.emergentes.dao;

import com.emergentes.modelo.Role_usuario;
import java.util.List;

public interface Role_usuarioDAO {
    public void insert(Role_usuario rol) throws Exception;
    public void update(Role_usuario rol) throws Exception;
    public void delete(int id) throws Exception;
    public Role_usuario getById(int id) throws Exception;
    public List<Role_usuario> getAll() throws Exception;
    public List<Role_usuario> buscar (String texto) throws Exception;
}
