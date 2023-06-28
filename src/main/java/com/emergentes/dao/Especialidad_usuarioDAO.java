package com.emergentes.dao;

import com.emergentes.modelo.Especialidad_usuario;
import java.util.List;

public interface Especialidad_usuarioDAO {
    public void insert(Especialidad_usuario esp) throws Exception;
    public void update(Especialidad_usuario esp) throws Exception;
    public void delete(int id) throws Exception;
    public Especialidad_usuario getById(int id) throws Exception;
    public List<Especialidad_usuario> getAll() throws Exception;
    public List<Especialidad_usuario> buscar (String texto) throws Exception;
}
