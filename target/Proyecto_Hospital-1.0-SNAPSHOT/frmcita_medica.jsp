<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="css/estilo.css">

        <title>Formulario de Citas Medicas</title>
    </head>
    <body style="background-image: url(img/form.jpg)">
        <div class="contenedor">
            <br>
            <form action="Cita_medicaControlador" method="post" class="form">
                <input type="hidden" name="action" value="${action}"/>
                <input type="hidden" name="id" value="${cita_medica.id}">
                <div class="form-header">
                    <h1 class="form-title">Formulario de Citas medicas</h1>
                </div>

                <label for="exampleInputEmail1" class="form-label">Nombre del doctor</label>                   
                <select name="id_doctor" class="form-input">
                    <option value="">--Seleccione--</option>
                    <c:forEach var="item" items="${lista_usuarios}">
                        <option value="${item.id}" 
                                <c:if test="${cita_medica.id_doctor == item.id}">
                                    selected
                                </c:if>
                                >${item.nombres} ${item.paterno} ${item.materno}</option>
                    </c:forEach>
                </select>

                <label for="exampleInputEmail1" class="form-label">Nombre completo del paciente</label>                   
                <select name="id_paciente" class="form-input">
                    <option value="">--Seleccione--</option>
                    <c:forEach var="item" items="${lista_pacientes}">
                        <option value="${item.id}" 
                                <c:if test="${cita_medica.id_paciente == item.id}">
                                    selected
                                </c:if>
                                >${item.nombres} ${item.paterno} ${item.materno}</option>
                    </c:forEach>
                </select>
                
                <label for="exampleInputEmail1" class="form-label">Cita</label>
                <input type="text" class="form-input" name="cita" value="${cita_medica.cita}" id="cita" placeholder="Motivo de cita">
                
                <label for="exampleInputEmail1" class="form-label">Fecha cita</label>
                <input type="date" class="form-input" name="fecha_cita" value="${cita_medica.fecha_cita}" id="fecha_cita" placeholder="Fecha de cita">
                
                <label for="exampleInputEmail1" class="form-label">Hora</label>
                <input type="time" class="form-input" name="hora" value="${cita_medica.hora}" id="hora" placeholder="Hora de cita">
                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>

    </body>
</html>
