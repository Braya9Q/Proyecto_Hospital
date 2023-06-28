package com.emergentes.controlador;

import com.emergentes.dao.EspecialidadDAO;
import com.emergentes.dao.EspecialidadDAOimpl;
import com.emergentes.dao.Especialidad_usuarioDAO;
import com.emergentes.dao.Especialidad_usuarioDAOimpl;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Especialidad;
import com.emergentes.modelo.Especialidad_usuario;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Especialidad_usuarioControlador", urlPatterns = {"/Especialidad_usuarioControlador"})
public class Especialidad_usuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Especialidad_usuario esp = new Especialidad_usuario();

            int id;
            String dato;
            
            Especialidad_usuarioDAO dao = new Especialidad_usuarioDAOimpl();
            UsuarioDAO daoUsuario = new UsuarioDAOimpl();
            EspecialidadDAO daoEspecialidad = new EspecialidadDAOimpl();
            List<Usuario> lista_usuarios = null;
            List<Especialidad> lista_especialidad = null;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_usuarios = daoUsuario.getAll();
                    lista_especialidad = daoEspecialidad.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("lista_especialidad", lista_especialidad);
                    request.setAttribute("especialidad_usuario", esp);
                    request.getRequestDispatcher("frmespecialidad_usuario.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    esp = dao.getById(id);
                    lista_usuarios = daoUsuario.getAll();
                    lista_especialidad = daoEspecialidad.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("lista_especialidad", lista_especialidad);
                    request.setAttribute("especialidad_usuario", esp);
                    request.getRequestDispatcher("frmespecialidad_usuario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Especialidad_usuarioControlador");
                    break;
                case "view":
                    //Obtener la lista de resgistros
                    List<Especialidad_usuario> lista = dao.getAll();
                    request.setAttribute("especialidad_usuarios", lista);
                    request.getRequestDispatcher("especialidad_usuarios.jsp").forward(request, response);
                    break;
                case "buscar":
                    dato = request.getParameter("txtBuscar");

                    List<Especialidad_usuario> list = dao.buscar(dato);

                    request.setAttribute("especialidad_usuarios", list);
                    request.getRequestDispatcher("especialidad_usuarios.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_especialidad = Integer.parseInt(request.getParameter("id_especialidad"));

        Especialidad_usuario esp = new Especialidad_usuario();

        esp.setId(id);
        esp.setId_usuario(id_usuario);
        esp.setId_especialidad(id_especialidad);

        Especialidad_usuarioDAO dao = new Especialidad_usuarioDAOimpl();

        if (id == 0) {
            try {
                //Nuevo registro
                dao.insert(esp);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }

        } else {
            try {
                //Edicion de registro
                dao.update(esp);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("Especialidad_usuarioControlador");
    }
}
