package com.emergentes.controlador;

import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        action = (request.getParameter("action") == null) ? "view" : request.getParameter("action");
        
        if (action.equals("logout")){
            HttpSession ses = request.getSession();
            ses.invalidate();
        }
        
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String usuario = request.getParameter("usuario");
            String clave = request.getParameter("clave");

            String sql = "SELECT * FROM usuario WHERE usuario = ? AND clave = ?";
            ResultSet rs;
            ConexionDB canal = new ConexionDB();
            Connection cn = canal.conectar();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);

            rs = ps.executeQuery();

            if (rs.next()) {
                // Crear las variables de sesion para el uso en la aplicación
                HttpSession ses = request.getSession();
                ses.setAttribute("logueado", "OK");
                response.sendRedirect("UsuarioControlador");
            } else {
                response.sendRedirect("login.jsp");
            }

        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos " + ex.getMessage());
        };
    }

}
