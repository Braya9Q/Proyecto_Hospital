package com.emergentes.dao;

import com.emergentes.modelo.Especialidad;
import java.util.List;

public interface EspecialidadDAO {
    public void insert(Especialidad e) throws Exception;
    public void update(Especialidad e) throws Exception;
    public void delete(int id) throws Exception;
    public Especialidad getById(int id) throws Exception;
    public List<Especialidad> getAll() throws Exception;
}
