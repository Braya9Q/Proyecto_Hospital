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

        <title>Formulario de Pacientes</title>
    </head>
    <body style="background-image: url(img/form.jpg)">
        <div class="contenedor">
            <br>
            <form action="PacienteControlador" method="post" class="form">
                <input type="hidden" name="action" value="${action}"/>
                <input type="hidden" name="id" value="${paciente.id}">
                <div class="form-header">
                    <h1 class="form-title">Formulario de Pacientes</h1>
                </div>

                <label for="exampleInputEmail1" class="form-label">Nombres</label>
                <input type="text" class="form-input" name="nombres" value="${paciente.nombres}" id="nombres" placeholder="Escriba su nombres">

                <label for="exampleInputEmail1" class="form-label">Apellido paterno</label>
                <input type="text" class="form-input" name="paterno" value="${paciente.paterno}" id="paterno" placeholder="Escriba su apellido paterno">

                <label for="exampleInputEmail1" class="form-label">Apellido materno</label>
                <input type="text" class="form-input" name="materno" value="${paciente.materno}" id="materno" placeholder="Escriba su apellido materno">

                <label for="exampleInputEmail1" class="form-label">Fecha_nacimiento</label>
                <input type="date" class="form-input" name="fecha_nacimiento" value="${paciente.fecha_nacimiento}" id="fecha_nacimiento" placeholder="Escriba la fecha de nacimiento">

                <label for="exampleInputEmail1" class="form-label">Sexo</label>
                <input type="text" class="form-input" name="sexo" value="${paciente.sexo}" id="sexo" placeholder="Escriba su sexo">

                <label for="exampleInputEmail1" class="form-label">Cedula de identidad</label>
                <input type="text" class="form-input" name="ci" value="${paciente.ci}" id="ci" placeholder="Escriba su cedula de identidad">

                <label for="exampleInputEmail1" class="form-label">Expedido</label>
                <input type="text" class="form-input" name="expedido" value="${paciente.expedido}" id="expedido" placeholder="Expedido en">

                <label for="exampleInputEmail1" class="form-label">Telefono / Celular</label>
                <input type="text" class="form-input" name="telefono" value="${paciente.telefono}" id="telefono" placeholder="Escriba su telefono">

                <label for="exampleInputEmail1" class="form-label">Direccion</label>
                <input type="text" class="form-input" name="direccion" value="${paciente.direccion}" id="direccion" placeholder="Escriba su dirección">

                <label for="exampleInputEmail1" class="form-label">Correo</label>
                <input type="email" class="form-input" name="correo" value="${paciente.correo}" id="correo" placeholder="Escriba su correo">
                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>

    </body>
</html>

