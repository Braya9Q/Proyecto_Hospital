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

        <title>Formulario de Estudiantes</title>
    </head>
    <body style="background-image: url(img/form.jpg)">
        <div class="contenedor">
            <br>
            <form action="UsuarioControlador" method="post" class="form">
                <input type="hidden" name="action" value="${action}"/>
                <input type="hidden" name="id" value="${usuario.id}">
                <div class="form-header">
                    <h1 class="form-title">Formulario Usuarios</h1>
                </div>

                <label for="" class="form-label">Clinica:</label>
                <select name="id_clinica" class="form-input" required>
                    <option value="">--Seleccione--</option>
                    <c:forEach var="item" items="${lista_clinica}">
                        <option value="${item.id}" 
                                <c:if test="${usuario.id_clinica == item.id}">
                                    selected
                                </c:if>
                                >${item.razon_social}</option>
                    </c:forEach>
                </select>

                <label for="exampleInputEmail1" class="form-label">Usuario</label>
                <input type="text" class="form-input" name="usuario" value="${usuario.usuario}" id="usuario" placeholder="Escriba su nombre de usuario">

                <label for="exampleInputEmail1" class="form-label">Clave</label>
                <input type="text" class="form-input" name="clave" value="${usuario.clave}" id="clave" placeholder="Escriba su clave">

                <label for="exampleInputEmail1" class="form-label">Nombres</label>
                <input type="text" class="form-input" name="nombres" value="${usuario.nombres}" id="nombres" placeholder="Escriba su nombres">

                <label for="exampleInputEmail1" class="form-label">Apellido paterno</label>
                <input type="text" class="form-input" name="paterno" value="${usuario.paterno}" id="paterno" placeholder="Escriba su apellido paterno">

                <label for="exampleInputEmail1" class="form-label">Apellido materno</label>
                <input type="text" class="form-input" name="materno" value="${usuario.materno}" id="materno" placeholder="Escriba su apellido materno">

                <label for="exampleInputEmail1" class="form-label">Cedula de identidad</label>
                <input type="text" class="form-input" name="ci" value="${usuario.ci}" id="ci" placeholder="Escriba su cedula de identidad">

                <label for="exampleInputEmail1" class="form-label">Expedido</label>
                <input type="text" class="form-input" name="expedido" value="${usuario.expedido}" id="expedido" placeholder="Expedido en">

                <label for="exampleInputEmail1" class="form-label">Telefono / Celular</label>
                <input type="text" class="form-input" name="telefono" value="${usuario.telefono}" id="telefono" placeholder="Escriba su telefono">

                <label for="exampleInputEmail1" class="form-label">Direccion</label>
                <input type="text" class="form-input" name="direccion" value="${usuario.direccion}" id="direccion" placeholder="Escriba su dirección">

                <label for="exampleInputEmail1" class="form-label">Correo</label>
                <input type="email" class="form-input" name="correo" value="${usuario.correo}" id="correo" placeholder="Escriba su correo">
                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>

    </body>
</html>
