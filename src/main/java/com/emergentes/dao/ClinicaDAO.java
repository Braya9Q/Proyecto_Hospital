package com.emergentes.dao;

import com.emergentes.modelo.Clinica;
import java.util.List;

public interface ClinicaDAO {
    public void insert(Clinica cli) throws Exception;
    public void update(Clinica cli) throws Exception;
    public void delete(int id) throws Exception;
    public Clinica getById(int id) throws Exception;
    public List<Clinica> getAll() throws Exception;
}
