package com.emergentes.controlador;

import com.emergentes.dao.PacienteDAO;
import com.emergentes.dao.PacienteDAOimpl;
import com.emergentes.modelo.Paciente;
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

@WebServlet(name = "PacienteControlador", urlPatterns = {"/PacienteControlador"})
public class PacienteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Paciente pac = new Paciente();
            int id;
            String dato;
            
            PacienteDAO dao = new PacienteDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("paciente", pac);
                    request.getRequestDispatcher("frmpaciente.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    pac = dao.getById(id);
                    request.setAttribute("paciente", pac);
                    request.getRequestDispatcher("frmpaciente.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("PacienteControlador");
                    break;
                case "view":
                    //Obtener la lista de resgistros
                    List<Paciente> lista = dao.getAll();
                    request.setAttribute("pacientes", lista);
                    request.getRequestDispatcher("pacientes.jsp").forward(request, response);
                    break;
                case "buscar":
                    dato = request.getParameter("txtBuscar");

                    List<Paciente> list = dao.buscar(dato);

                    request.setAttribute("pacientes", list);
                    request.getRequestDispatcher("pacientes.jsp").forward(request, response);
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
        String nombres = request.getParameter("nombres");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String fecha_nacimiento = request.getParameter("fecha_nacimiento");
        String sexo = request.getParameter("sexo");
        String ci = request.getParameter("ci");
        String expedido = request.getParameter("expedido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");

        Paciente pac = new Paciente();

        pac.setId(id);
        pac.setNombres(nombres);
        pac.setPaterno(paterno);
        pac.setMaterno(materno);
        pac.setFecha_nacimiento(convierteFecha(fecha_nacimiento));
        pac.setSexo(sexo);
        pac.setCi(ci);
        pac.setExpedido(expedido);
        pac.setTelefono(telefono);
        pac.setDireccion(direccion);
        pac.setCorreo(correo);

        PacienteDAO dao = new PacienteDAOimpl();

        if (id == 0) {
            try {
                //Nuevo registro
                dao.insert(pac);
            } catch (Exception ex) {
                System.out.println("Error al insertar " + ex.getMessage());
            }

        } else {
            try {
                //Edicion de registro
                dao.update(pac);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("PacienteControlador");
    }

    public Date convierteFecha(String fecha) {
        Date fecha_nacimientoBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date fecha_nacimientoTMP;
        try {
            fecha_nacimientoTMP = formato.parse(fecha);
            fecha_nacimientoBD = new Date(fecha_nacimientoTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(PacienteControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha_nacimientoBD;
    }

}
