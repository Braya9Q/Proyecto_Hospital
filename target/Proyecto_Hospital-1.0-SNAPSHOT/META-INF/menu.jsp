<%
    String opcion = request.getParameter("opcion");
%>

<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center ">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="" class="nav-link px-2 text-white" id="logo">SISTEMA DE <span>GESTION HOSPITALARIA</span></a></li>
                <li><a href="UsuarioControlador" class="nav-link px-2 text-white <%=(opcion.equals("usuarios") ? "active" : "")%>">Usuarios</a></li>               
                <li><a href="Role_usuarioControlador" class="nav-link px-2 text-white <%=(opcion.equals("role_usuarios") ? "active" : "")%>">Roles de usuarios</a></li>
                <li><a href="Especialidad_usuarioControlador" class="nav-link px-2 text-white <%=(opcion.equals("especialidad_usuarios") ? "active" : "")%>"">Especialidades</a></li>
                <li><a href="PacienteControlador" class="nav-link px-2 text-white <%=(opcion.equals("pacientes") ? "active" : "")%>">Pacientes</a></li>
                <li><a href="Cita_medicaControlador" class="nav-link px-2 text-white <%=(opcion.equals("cita_medicas") ? "active" : "")%>">Citas Medicas</a></li>
                <li><a href="Historia_clinicaControlador" class="nav-link px-2 text-white <%=(opcion.equals("historia_clinicas") ? "active" : "")%>">Historial clinico</a></li>         
            </ul>
            <br>
            
            <div class="dropdown text-end">
                <a href="#" class="d-block text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="img/grid-img3.png" class="rounded-circle" width="45" height="40" >
                </a>
                <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">

                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="Logout">Cerrar Sesion</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>