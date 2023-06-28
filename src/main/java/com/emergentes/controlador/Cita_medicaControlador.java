package com.emergentes.controlador;

import com.emergentes.dao.PacienteDAO;
import com.emergentes.dao.PacienteDAOimpl;
import com.emergentes.dao.Cita_medicaDAO;
import com.emergentes.dao.Cita_medicaDAOimpl;
import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Cita_medica;
import com.emergentes.modelo.Paciente;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
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

@WebServlet(name = "Cita_medicaControlador", urlPatterns = {"/Cita_medicaControlador"})
public class Cita_medicaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Cita_medica ctm = new Cita_medica();
            Cita_medicaDAO dao = new Cita_medicaDAOimpl();
            int id;
            String dato;
            UsuarioDAO daoUsuario = new UsuarioDAOimpl();
            List<Usuario> lista_usuarios = null;
            PacienteDAO daoPaciente = new PacienteDAOimpl();
            List<Paciente> lista_pacientes = null;

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    lista_usuarios = daoUsuario.getAll();
                    lista_pacientes = daoPaciente.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("lista_pacientes", lista_pacientes);
                    request.setAttribute("cita_medica", ctm);
                    request.getRequestDispatcher("frmcita_medica.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    ctm = dao.getById(id);
                    lista_usuarios = daoUsuario.getAll();
                    lista_pacientes = daoPaciente.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("lista_pacientes", lista_pacientes);
                    request.setAttribute("cita_medica", ctm);
                    request.getRequestDispatcher("frmcita_medica.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Cita_medicaControlador");
                    break;
                case "view":
                    //Obtener la lista de resgistros
                    List<Cita_medica> lista = dao.getAll();
                    request.setAttribute("cita_medicas", lista);
                    request.getRequestDispatcher("cita_medicas.jsp").forward(request, response);
                    break;
                case "buscar":
                    dato = request.getParameter("txtBuscar");

                    List<Cita_medica> list = dao.buscar(dato);

                    request.setAttribute("cita_medicas", list);
                    request.getRequestDispatcher("cita_medicas.jsp").forward(request, response);
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
        String cita = request.getParameter("cita");
        String fecha_cita = request.getParameter("fecha_cita");
        String hora = request.getParameter("hora");

        Cita_medica ctm = new Cita_medica();

        ctm.setId(id);
        ctm.setId_doctor(id_doctor);
        ctm.setId_paciente(id_paciente);
        ctm.setCita(cita);
        ctm.setFecha_cita(convierteFecha(fecha_cita));
        ctm.setHora(convierteHora(hora));

        Cita_medicaDAO dao = new Cita_medicaDAOimpl();

        if (id == 0) {
            try {
                //Nuevo registro
                dao.insert(ctm);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }

        } else {
            try {
                //Edicion de registro
                dao.update(ctm);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("Cita_medicaControlador");
    }

    public Date convierteFecha(String fecha) {
        Date fecha_citaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fecha_citaTMP;
        try {
            fecha_citaTMP = formato.parse(fecha);
            fecha_citaBD = new Date(fecha_citaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(PacienteControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha_citaBD;
    }

    public Time convierteHora(String hora) {
        Time horaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");

        java.util.Date horaTMP;
        try {
            horaTMP = formato.parse(hora);
            horaBD = new Time(horaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(PacienteControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return horaBD;
    }
}
