package com.emergentes.dao;

import com.emergentes.modelo.Historia_clinica;
import java.util.List;


public interface Historia_clinicaDAO {
    public void insert(Historia_clinica h) throws Exception;
    public void update(Historia_clinica h) throws Exception;
    public void delete(int id) throws Exception;
    public Historia_clinica getById(int id) throws Exception;
    public List<Historia_clinica> getAll() throws Exception;
    public List<Historia_clinica> buscar (String texto) throws Exception;
}
