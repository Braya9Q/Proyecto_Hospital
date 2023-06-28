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

        <title>Formulario de Especialidad de Usuarios</title>
    </head>
    <body style="background-image: url(img/form.jpg)">
        <div class="contenedor">
            <br>
            <form action="Especialidad_usuarioControlador" method="post" class="form">
                <input type="hidden" name="action" value="${action}"/>
                <input type="hidden" name="id" value="${especialidad_usuario.id}">
                <div class="form-header">
                    <h1 class="form-title">Formulari de Especialidades de usuarios</h1>
                </div>

                <label for="exampleInputEmail1" class="form-label">Nombre del usuario</label>                   
                <select name="id_usuario" class="form-input">
                    <option value="">--Seleccione--</option>
                    <c:forEach var="item" items="${lista_usuarios}">
                        <option value="${item.id}" 
                                <c:if test="${especialidad_usuario.id_usuario == item.id}">
                                    selected
                                </c:if>
                                >${item.nombres} ${item.paterno} ${item.materno}</option>
                    </c:forEach>
                </select>

                <label for="exampleInputEmail1" class="form-label">Nombre de la especialidad</label>                   
                <select name="id_especialidad" class="form-input">
                    <option value="">--Seleccione--</option>
                    <c:forEach var="item" items="${lista_especialidad}">
                        <option value="${item.id}" 
                                <c:if test="${especialidad_usuario.id_especialidad == item.id}">
                                    selected
                                </c:if>
                                >${item.especialidad}</option>
                    </c:forEach>
                </select>
                <table>
                    <th width="100%"><input type="submit" class="btn save" value="Guardar"></th>
                    <th><input type="button" onclick="history.back()" class="btn cancel" name="Cancelar" value="Cancelar"></th>
                </table>
            </form>
        </div>

    </body>
</html>
