package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Validate extends ConexionDB{
    Connection conn = this.conectar();
    PreparedStatement pr;
    public boolean ckeckUser(String usuario, String clave)
    {
        boolean resultado = false;
        try {
            String sql = "SELECT * FROM usuario WHERE usuario = ? AND clave = ?";
            
            pr = conn.prepareStatement(sql);
            pr.setString(1, usuario);
            pr.setString(2, clave);
            ResultSet rs = pr.executeQuery();
            resultado = rs.next();
            
        } catch (SQLException ex) {
            System.out.println(""
                    + "Error al autenticar");
        }
        return resultado;
    }
}
