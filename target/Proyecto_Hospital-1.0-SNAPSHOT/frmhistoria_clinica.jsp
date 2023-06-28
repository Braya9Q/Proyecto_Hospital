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

        <title>Formulario de Historia clinica</title>
    </head>
    <body style="background-image: url(img/form.jpg)">
        <div class="contenedor">
            <br>
            <form action="Historia_clinicaControlador" method="post" class="form">
                <input type="hidden" name="action" value="${action}"/>
                <input type="hidden" name="id" value="${historia_clinica.id}">
                <div class="form-header">
                    <h1 class="form-title">Formulario de Historia clinica</h1>
                </div>

                <label for="exampleInputEmail1" class="form-label">Nombre del doctor</label>                   
                <select name="id_doctor" class="form-input">
                    <option value="">--Seleccione--</option>
                    <c:forEach var="item" items="${lista_usuarios}">
                        <option value="${item.id}" 
                                <c:if test="${historia_clinica.id_doctor == item.id}">
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
                                <c:if test="${historia_clinica.id_paciente == item.id}">
                                    selected
                                </c:if>
                                >${item.nombres} ${item.paterno} ${item.materno}</option>
                    </c:forEach>
                </select>

                <label for="exampleInputEmail1" class="form-label">Historia</label>
                <input type="text" class="form-input" name="historia" value="${historia_clinica.historia}" id="historia" placeholder="Escriba su historia">

                <label for="exampleInputEmail1" class="form-label">Fecha atención</label>
                <input type="date" class="form-input" name="fecha_atencion" value="${historia_clinica.fecha_atencion}" id="fecha_atencion" placeholder="Fecha de atención">

                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>

    </body>
</html>
