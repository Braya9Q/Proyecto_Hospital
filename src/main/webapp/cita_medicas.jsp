<%
    if (session.getAttribute("logueado") != "OK") {
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html> 
<html lang="es">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="css/tabla.css">
        <link rel="stylesheet" href="css/menu.css">

        <title>Citas medicas</title>
    </head>

    <body style="background-image: url(img/imagen.jpg)">
        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="cita_medicas" />
        </jsp:include>
        <br>
        <h1 style="text-align: center; ">Citas<span> medicas</span></h1>
        <table class="container1">
            <tr>
                <th><a href="Cita_medicaControlador?action=add" class="btn fourth">Crear Nueva Cita Medica</a></th>
                <th><form class="d-flex " >
                        <input class="form-control me-2" type="search" placeholder="Buscar" name="txtBuscar" aria-label="Search">
                        <button class="btn btn-outline-success" accesskey="" name="action" value="buscar"  type="submit">Buscar</button>
                        <button class="btn btn-outline-success" name="action" value="view"  type="submit">ACTUALIZAR</button>
                    </form>
                </th>
            </tr>
        </table>
        <table class="container1" >
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre del doctor</th>
                    <th>Nombre completo de paciente</th>
                    <th>Cita</th>
                    <th>Fecha cita</th>
                    <th>Hora</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${cita_medicas}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nombresd}</td>
                        <td>${item.nombres}</td>
                        <td>${item.cita}</td>
                        <td>${item.fecha_cita}</td>
                        <td>${item.hora}</td>
                        <td><a href="Cita_medicaControlador?action=edit&id=${item.id}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                        <td><a href="Cita_medicaControlador?action=delete&id=${item.id}" onclick="return(confirm('Desea Eliminar'))"><i class="fa-solid fa-trash"></i></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </body>
</html>

