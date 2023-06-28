package com.emergentes.dao;

import com.emergentes.modelo.Cita_medica;
import java.util.List;

public interface Cita_medicaDAO {
    public void insert(Cita_medica ctm) throws Exception;
    public void update(Cita_medica ctm) throws Exception;
    public void delete(int id) throws Exception;
    public Cita_medica getById(int id) throws Exception;
    public List<Cita_medica> getAll() throws Exception;
    public List<Cita_medica> buscar (String texto) throws Exception;
}
