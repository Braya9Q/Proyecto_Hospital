package com.emergentes.controlador;

import com.emergentes.dao.ClinicaDAO;
import com.emergentes.dao.ClinicaDAOimpl;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Clinica;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Usuario usr = new Usuario();
            UsuarioDAO dao = new UsuarioDAOimpl();
            int id;
            String dato;

            ClinicaDAO daoClinica = new ClinicaDAOimpl();
            List<Clinica> lista_clinica = null;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_clinica = daoClinica.getAll();
                    request.setAttribute("lista_clinica", lista_clinica);
                    request.setAttribute("usuario", usr);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    usr = dao.getById(id);
                    lista_clinica = daoClinica.getAll();
                    request.setAttribute("lista_clinica", lista_clinica);
                    request.setAttribute("usuario", usr);
                    request.getRequestDispatcher("frmusuario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("UsuarioControlador");
                    break;
                case "view":
                    //Obtener la lista de resgistros
                    List<Usuario> lista = dao.getAll();
                    request.setAttribute("usuarios", lista);
                    request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                    break;
                case "buscar":
                    dato = request.getParameter("txtBuscar");

                    List<Usuario> list = dao.buscar(dato);

                    request.setAttribute("usuarios", list);
                    request.getRequestDispatcher("usuarios.jsp").forward(request, response);
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
        int id_clinica = Integer.parseInt(request.getParameter("id_clinica"));
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        String nombres = request.getParameter("nombres");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String ci = request.getParameter("ci");
        String expedido = request.getParameter("expedido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");

        Usuario usr = new Usuario();

        usr.setId(id);
        usr.setId_clinica(id_clinica);
        usr.setUsuario(usuario);
        usr.setClave(clave);
        usr.setNombres(nombres);
        usr.setPaterno(paterno);
        usr.setMaterno(materno);
        usr.setCi(ci);
        usr.setExpedido(expedido);
        usr.setTelefono(telefono);
        usr.setDireccion(direccion);
        usr.setCorreo(correo);

        UsuarioDAO dao = new UsuarioDAOimpl();

        if (id == 0) {
            try {
                //Nuevo registro
                dao.insert(usr);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }

        } else {
            try {
                //Edicion de registro
                dao.update(usr);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("UsuarioControlador");
    }

}
