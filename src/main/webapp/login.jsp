<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/login.css">
        <title>Login</title>
        <style>
            body {
                height: 100vh;
                display: flex;
                background-attachment: fixed;
                align-items: center;
                justify-content: center;
                background-image: url(img/slider-image1.jpg);
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                color: white;
            }
        </style>
    </head>

    <body>
        <div class="container-form sign-up">

            <form action="LoginControlador" method="post" class="formulario">
                <h2 class="create-account">Iniciar Sesion</h2>
                <p class="cuenta-gratis">Ingrese sus Datos</p>
                <input type="text" name="usuario" placeholder="Usuario">
                <input type="password" name="clave" placeholder="Contraseña">

                <button class="button" type="submit">Ingresar</button>
            </form>
        </div>
    </body>

</html>
