package com.emergentes.dao;

import com.emergentes.modelo.Role;
import java.util.List;

public interface RoleDAO {
    public void insert(Role r) throws Exception;
    public void update(Role r) throws Exception;
    public void delete(int id) throws Exception;
    public Role getById(int id) throws Exception;
    public List<Role> getAll() throws Exception;
}
