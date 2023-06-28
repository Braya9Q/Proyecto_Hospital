package com.emergentes.controlador;

import com.emergentes.dao.RoleDAO;
import com.emergentes.dao.RoleDAOimpl;
import com.emergentes.dao.Role_usuarioDAO;
import com.emergentes.dao.Role_usuarioDAOimpl;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Role;
import com.emergentes.modelo.Role_usuario;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Role_usuarioControlador", urlPatterns = {"/Role_usuarioControlador"})
public class Role_usuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Role_usuario rol = new Role_usuario();

            int id;
            String dato;
            Role_usuarioDAO dao = new Role_usuarioDAOimpl();
            UsuarioDAO daousuario = new UsuarioDAOimpl();
            RoleDAO daorole = new RoleDAOimpl();

            List<Usuario> lista_usuarios = null;
            List<Role> lista_roles = null;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_usuarios = daousuario.getAll();
                    lista_roles = daorole.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("lista_roles", lista_roles);
                    request.setAttribute("role_usuario", rol);
                    request.getRequestDispatcher("frmrole_usuario.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    rol = dao.getById(id);
                    lista_usuarios = daousuario.getAll();
                    lista_roles = daorole.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("lista_roles", lista_roles);
                    request.setAttribute("role_usuario", rol);
                    request.getRequestDispatcher("frmrole_usuario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Role_usuarioControlador");
                    break;
                case "view":
                    //Obtener la lista de resgistros
                    List<Role_usuario> lista = dao.getAll();
                    request.setAttribute("role_usuarios", lista);
                    request.getRequestDispatcher("role_usuarios.jsp").forward(request, response);
                    break;
                case "buscar":
                    dato = request.getParameter("txtBuscar");

                    List<Role_usuario> list = dao.buscar(dato);

                    request.setAttribute("role_usuarios", list);
                    request.getRequestDispatcher("role_usuarios.jsp").forward(request, response);
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
        int id_role = Integer.parseInt(request.getParameter("id_role"));

        Role_usuario rol = new Role_usuario();

        rol.setId(id);
        rol.setId_usuario(id_usuario);
        rol.setId_role(id_role);

        Role_usuarioDAO dao = new Role_usuarioDAOimpl();

        if (id == 0) {
            try {
                //Nuevo registro
                dao.insert(rol);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }

        } else {
            try {
                //Edicion de registro
                dao.update(rol);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("Role_usuarioControlador");
    }

}
