/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;


import com.emergentes.dao.PacienteDAO;
import com.emergentes.dao.PacienteDAOimpl;
import com.emergentes.dao.Historia_clinicaDAO;
import com.emergentes.dao.Historia_clinicaDAOimpl;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Historia_clinica;
import com.emergentes.modelo.Paciente;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Historia_clinicaControlador", urlPatterns = {"/Historia_clinicaControlador"})
public class Historia_clinicaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Historia_clinica h = new Historia_clinica();
            Historia_clinicaDAO dao = new Historia_clinicaDAOimpl();
            int id;
            String dato;
            UsuarioDAO daousuario = new UsuarioDAOimpl();
            List<Usuario> lista_usuarios = null;
            PacienteDAO daoPaciente = new PacienteDAOimpl();
            List<Paciente> lista_pacientes = null;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_usuarios = daousuario.getAll();
                    lista_pacientes = daoPaciente.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("lista_pacientes", lista_pacientes);
                    request.setAttribute("historia_clinica", h);
                    request.getRequestDispatcher("frmhistoria_clinica.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    h = dao.getById(id);
                    lista_usuarios = daousuario.getAll();
                    lista_pacientes = daoPaciente.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("lista_pacientes", lista_pacientes);
                    request.setAttribute("historia_clinica", h);
                    request.getRequestDispatcher("frmhistoria_clinica.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Historia_clinicaControlador");
                    break;
                case "view":
                    //Obtener la lista de resgistros
                    List<Historia_clinica> lista = dao.getAll();
                    request.setAttribute("historia_clinicas", lista);
                    request.getRequestDispatcher("historia_clinicas.jsp").forward(request, response);
                    break;
                case "buscar":
                    dato = request.getParameter("txtBuscar");

                    List<Historia_clinica> list = dao.buscar(dato);

                    request.setAttribute("historia_clinicas", list);
                    request.getRequestDispatcher("historia_clinicas.jsp").forward(request, response);
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
        int id_doctor = Integer.parseInt(request.getParameter("id_doctor"));
        int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));
        String historia = request.getParameter("historia");
        String fecha_atencion = request.getParameter("fecha_atencion");

        Historia_clinica h = new Historia_clinica();

        h.setId(id);
        h.setId_doctor(id_doctor);
        h.setId_paciente(id_paciente);
        h.setHistoria(historia);
        h.setFecha_atencion(convierteFecha(fecha_atencion));

        Historia_clinicaDAO dao = new Historia_clinicaDAOimpl();

        if (id == 0) {
            try {
                //Nuevo registro
                dao.insert(h);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }

        } else {
            try {
                //Edicion de registro
                dao.update(h);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("Historia_clinicaControlador");
    }

    public Date convierteFecha(String fecha) {
        Date fecha_atencionBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fecha_atencionTMP;
        try {
            fecha_atencionTMP = formato.parse(fecha);
            fecha_atencionBD = new Date(fecha_atencionTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(PacienteControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha_atencionBD;
    }

}
