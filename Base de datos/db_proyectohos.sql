-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-06-2023 a las 17:21:20
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_proyectohos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_medica`
--

CREATE TABLE `cita_medica` (
  `id` int(11) NOT NULL,
  `id_doctor` int(11) DEFAULT NULL,
  `id_paciente` int(11) DEFAULT NULL,
  `cita` text DEFAULT NULL,
  `fecha_cita` date NOT NULL,
  `hora` time DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `fecha_actualizacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cita_medica`
--

INSERT INTO `cita_medica` (`id`, `id_doctor`, `id_paciente`, `cita`, `fecha_cita`, `hora`, `fecha_registro`, `fecha_actualizacion`) VALUES
(1, 1, 2, 'Revision de muelas', '2023-06-29', '03:03:58', '2023-06-21 22:23:50', '2023-06-21 22:23:50'),
(2, 3, 1, 'Revision general', '2023-06-30', NULL, '2023-06-27 01:24:48', '2023-06-27 01:24:48'),
(3, 5, 3, 'Revision general', '2023-06-30', NULL, '2023-06-28 14:43:53', '2023-06-28 14:43:53'),
(4, 7, 3, 'Revision general', '2023-06-30', NULL, '2023-06-28 14:52:07', '2023-06-28 14:52:07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clinica`
--

CREATE TABLE `clinica` (
  `id` int(11) NOT NULL,
  `razon_social` varchar(50) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `nit` varchar(30) DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `fecha_actualizacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `clinica`
--

INSERT INTO `clinica` (`id`, `razon_social`, `direccion`, `telefono`, `nit`, `fecha_registro`, `fecha_actualizacion`) VALUES
(1, 'Clinica del Sur', 'Achumani', '63022382', '32432542', '2023-06-21 22:18:45', '2023-06-21 22:18:45');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id` int(11) NOT NULL,
  `especialidad` varchar(40) DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `fecha_actualizacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id`, `especialidad`, `fecha_registro`, `fecha_actualizacion`) VALUES
(1, 'Odontología', '2023-06-21 22:26:19', '2023-06-21 22:26:19'),
(2, 'Neurología', '2023-06-27 01:14:39', '2023-06-27 01:14:39'),
(3, 'Nutrición', '2023-06-27 01:14:39', '2023-06-27 01:14:39'),
(4, 'Ecografía', '2023-06-27 01:15:45', '2023-06-27 01:15:45'),
(5, 'Medicina Interna', '2023-06-27 01:15:45', '2023-06-27 01:15:45');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad_usuario`
--

CREATE TABLE `especialidad_usuario` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_especialidad` int(11) DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `fecha_actualizacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `especialidad_usuario`
--

INSERT INTO `especialidad_usuario` (`id`, `id_usuario`, `id_especialidad`, `fecha_registro`, `fecha_actualizacion`) VALUES
(1, 2, 1, '2023-06-21 22:26:32', '2023-06-21 22:26:32'),
(2, 1, 5, '2023-06-27 01:22:40', '2023-06-27 01:22:40'),
(3, 3, 2, '2023-06-27 01:22:47', '2023-06-27 01:22:47'),
(4, 4, 3, '2023-06-27 01:22:55', '2023-06-27 01:22:55'),
(5, 5, 4, '2023-06-28 14:41:15', '2023-06-28 14:41:15'),
(6, 6, 2, '2023-06-28 14:48:02', '2023-06-28 14:48:02'),
(7, 7, 3, '2023-06-28 14:51:12', '2023-06-28 14:51:12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historia_clinica`
--

CREATE TABLE `historia_clinica` (
  `id` int(11) NOT NULL,
  `id_doctor` int(11) DEFAULT NULL,
  `id_paciente` int(11) DEFAULT NULL,
  `historia` text DEFAULT NULL,
  `fecha_atencion` date NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `fecha_actualizacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `historia_clinica`
--

INSERT INTO `historia_clinica` (`id`, `id_doctor`, `id_paciente`, `historia`, `fecha_atencion`, `fecha_registro`, `fecha_actualizacion`) VALUES
(1, 1, 1, 'Se reviso la muela del paciente, tenia dolor en los molares por ingerir comidas duras.', '2023-06-29', '2023-06-21 22:25:19', '2023-06-21 22:25:19'),
(2, 7, 3, 'Consiste en tomar los alimentos y las sustancias necesarias para que el organismo funcione.', '2023-06-30', '2023-06-28 14:57:34', '2023-06-28 14:57:34');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `id` int(11) NOT NULL,
  `nombres` varchar(100) DEFAULT NULL,
  `paterno` varchar(60) DEFAULT NULL,
  `materno` varchar(60) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` varchar(20) DEFAULT NULL,
  `ci` varchar(20) DEFAULT NULL,
  `expedido` varchar(20) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `correo` varchar(60) DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `fecha_actualizacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`id`, `nombres`, `paterno`, `materno`, `fecha_nacimiento`, `sexo`, `ci`, `expedido`, `telefono`, `direccion`, `correo`, `fecha_registro`, `fecha_actualizacion`) VALUES
(1, 'Pedro', 'Perez', 'Mamani', '2003-06-19', 'Masculino', '24343545', 'El Alto', '60173899', 'Zona Ballivian', 'pedromap@mail.com', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(2, 'Maria', 'Sirpa', 'Lopez', '2014-01-07', 'Femenino', '10034567', 'El Alto', '60923466', 'Zona Bautista Saavedra', 'marial@mail.com', '2023-06-22 02:55:44', '2023-06-22 02:55:44'),
(3, 'Rudy', 'Quispe', 'Alanoca', '2018-02-01', 'Masculino', '108665332', 'El Alto', '76055332', 'Zona Bautista Saavedra', 'rquispe@mail.com', '2023-06-28 14:43:03', '2023-06-28 14:43:03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(1, 'Doctor'),
(2, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role_usuario`
--

CREATE TABLE `role_usuario` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_role` int(11) DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `fecha_actualizacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `role_usuario`
--

INSERT INTO `role_usuario` (`id`, `id_usuario`, `id_role`, `fecha_registro`, `fecha_actualizacion`) VALUES
(1, 1, 1, '2023-06-21 22:25:56', '2023-06-21 22:25:56'),
(2, 2, 1, '2023-06-27 01:04:58', '2023-06-27 01:04:58'),
(3, 3, 1, '2023-06-27 01:21:51', '2023-06-27 01:21:51'),
(4, 4, 1, '2023-06-27 01:22:18', '2023-06-27 01:22:18'),
(5, 5, 1, '2023-06-28 14:40:41', '2023-06-28 14:40:41'),
(6, 6, 1, '2023-06-28 14:47:36', '2023-06-28 14:47:36'),
(7, 7, 1, '2023-06-28 14:50:41', '2023-06-28 14:50:41');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `id_clinica` int(11) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  `nombres` varchar(100) DEFAULT NULL,
  `paterno` varchar(60) DEFAULT NULL,
  `materno` varchar(60) DEFAULT NULL,
  `ci` varchar(20) DEFAULT NULL,
  `expedido` varchar(20) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  `correo` varchar(60) DEFAULT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp(),
  `fecha_actualizacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `id_clinica`, `usuario`, `clave`, `nombres`, `paterno`, `materno`, `ci`, `expedido`, `telefono`, `direccion`, `correo`, `fecha_registro`, `fecha_actualizacion`) VALUES
(1, 1, 'bquispe', '123', 'Brayan', 'Quispe', 'Alanoca', '8427958', 'La Paz', '75860552', 'El Alto', 'brayanq@mail.com', '2023-06-21 22:19:38', '2023-06-21 22:19:38'),
(2, 1, 'wmiranda', '1234', 'Wimar', 'Miranda', 'Pusarico', '9343534', 'La Paz', '78934234', 'Zona Rio Seco', 'wmiranda@mail.com', '2023-06-22 02:16:31', '2023-06-22 02:16:31'),
(3, 1, 'xguarachi', '1234567', 'Ximena', 'Guarachi', 'Mita', '86542233', 'Oruro', '65423411', 'Zona Miraflores', 'xmita@mail.com', '2023-06-27 01:18:20', '2023-06-27 01:18:20'),
(4, 1, 'lalanoca', '1231', 'Laura', 'Alanoca', 'Mena', '9323439', 'Cochabamba', '70912455', 'Zona Villa Bolivar', 'lralanoca@mail.com', '2023-06-27 01:20:46', '2023-06-27 01:20:46'),
(5, 1, 'maria', '987', 'Maria', 'Mamani', 'Mamani', '97444323', 'La Paz', '79056432', 'Zona San Roque', 'mmaria@mail.com', '2023-06-28 14:40:13', '2023-06-28 14:40:13'),
(6, 1, 'danny', '987', 'Danny', 'Lopez', 'Ticona', '8734232', 'La Paz', '76859332', 'Zona Los Andes', 'dlopez@mail.com', '2023-06-28 14:47:10', '2023-06-28 14:47:10'),
(7, 1, 'nelly', '789', 'Nelly', 'Ticona', 'Mamani', '9534223', 'La Paz', '79023452', 'Zona Villa Dolores', 'nticona@mail.com', '2023-06-28 14:50:19', '2023-06-28 14:50:19');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cita_medica`
--
ALTER TABLE `cita_medica`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_doctor` (`id_doctor`),
  ADD KEY `id_paciente` (`id_paciente`);

--
-- Indices de la tabla `clinica`
--
ALTER TABLE `clinica`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `especialidad_usuario`
--
ALTER TABLE `especialidad_usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_especialidad` (`id_especialidad`);

--
-- Indices de la tabla `historia_clinica`
--
ALTER TABLE `historia_clinica`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_doctor` (`id_doctor`),
  ADD KEY `id_paciente` (`id_paciente`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `role_usuario`
--
ALTER TABLE `role_usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_role` (`id_role`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_clinica` (`id_clinica`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cita_medica`
--
ALTER TABLE `cita_medica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `clinica`
--
ALTER TABLE `clinica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `especialidad_usuario`
--
ALTER TABLE `especialidad_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `historia_clinica`
--
ALTER TABLE `historia_clinica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `role_usuario`
--
ALTER TABLE `role_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita_medica`
--
ALTER TABLE `cita_medica`
  ADD CONSTRAINT `cita_medica_ibfk_1` FOREIGN KEY (`id_doctor`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `cita_medica_ibfk_2` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`);

--
-- Filtros para la tabla `especialidad_usuario`
--
ALTER TABLE `especialidad_usuario`
  ADD CONSTRAINT `especialidad_usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `especialidad_usuario_ibfk_2` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidad` (`id`);

--
-- Filtros para la tabla `historia_clinica`
--
ALTER TABLE `historia_clinica`
  ADD CONSTRAINT `historia_clinica_ibfk_1` FOREIGN KEY (`id_doctor`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `historia_clinica_ibfk_2` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`);

--
-- Filtros para la tabla `role_usuario`
--
ALTER TABLE `role_usuario`
  ADD CONSTRAINT `role_usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `role_usuario_ibfk_2` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_clinica`) REFERENCES `clinica` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
