-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-10-2020 a las 23:54:26
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_prueba (1)`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informe`
--

CREATE TABLE `informe` (
  `idInforme` int(11) NOT NULL,
  `idPartida` int(11) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `PorcentajeError` int(11) DEFAULT NULL,
  `ContrasteJugadas` int(11) DEFAULT NULL,
  `MovimientoInvalido` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informegeneral`
--

CREATE TABLE `informegeneral` (
  `idInformeGeneral` int(11) NOT NULL,
  `NumeroPartidas` int(11) DEFAULT NULL,
  `PromedioError` double DEFAULT NULL,
  `PromedioTiempo` time DEFAULT NULL,
  `idPersona` int(11) DEFAULT NULL,
  `PromedioDevoluciones` double DEFAULT NULL,
  `TotalMovimientosInvalidos` int(11) DEFAULT NULL,
  `PromedioRetirada` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modalidad`
--

CREATE TABLE `modalidad` (
  `idModalidad` int(11) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `Descripcion` varchar(200) DEFAULT NULL,
  `Documentacion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nivelmodalidad`
--

CREATE TABLE `nivelmodalidad` (
  `idNivelModalidad` int(11) NOT NULL,
  `idModalidad` int(11) DEFAULT NULL,
  `idNivelFichasNegras` int(11) DEFAULT NULL,
  `idNivelFichasBlancas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nivel_fichas_blancas`
--

CREATE TABLE `nivel_fichas_blancas` (
  `idNivelFichasBlancas` int(11) NOT NULL,
  `NumeroJugadas` int(11) DEFAULT NULL,
  `ReinaPosicion` varchar(3) DEFAULT NULL,
  `ReyPosicion` varchar(3) DEFAULT NULL,
  `Torre1Posicion` varchar(3) DEFAULT NULL,
  `Torre2Posicion` varchar(3) DEFAULT NULL,
  `Caballo1Posicion` varchar(3) DEFAULT NULL,
  `Caballo2Posicion` varchar(3) DEFAULT NULL,
  `Alfil1Posicion` varchar(3) DEFAULT NULL,
  `Peon1Posicion` varchar(3) DEFAULT NULL,
  `Peon2Posicion` varchar(3) DEFAULT NULL,
  `Peon3Posicion` varchar(3) DEFAULT NULL,
  `Peon4Posicion` varchar(3) DEFAULT NULL,
  `Peon5Posicion` varchar(3) DEFAULT NULL,
  `Peon6Posicion` varchar(3) DEFAULT NULL,
  `Peon7Posicion` varchar(3) DEFAULT NULL,
  `Peon8Posicion` varchar(3) DEFAULT NULL,
  `Tiempo` time DEFAULT NULL,
  `idNivelFichasNegras` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nivel_fichas_negras`
--

CREATE TABLE `nivel_fichas_negras` (
  `idNivelFichasNegras` int(11) NOT NULL,
  `NumeroJugadas` int(11) DEFAULT NULL,
  `ReinaPosicion` varchar(3) DEFAULT NULL,
  `ReyPosicion` varchar(3) DEFAULT NULL,
  `Torre1Posicion` varchar(3) DEFAULT NULL,
  `Torre2Posicion` varchar(3) DEFAULT NULL,
  `Caballo1Posicion` varchar(3) DEFAULT NULL,
  `Caballo2Posicion` varchar(3) DEFAULT NULL,
  `Alfil1Posicion` varchar(3) DEFAULT NULL,
  `Peon1Posicion` varchar(3) DEFAULT NULL,
  `Peon2Posicion` varchar(3) DEFAULT NULL,
  `Peon3Posicion` varchar(3) DEFAULT NULL,
  `Peon4Posicion` varchar(3) DEFAULT NULL,
  `Peon5Posicion` varchar(3) DEFAULT NULL,
  `Peon6Posicion` varchar(3) DEFAULT NULL,
  `Peon7Posicion` varchar(3) DEFAULT NULL,
  `Peon8Posicion` varchar(3) DEFAULT NULL,
  `Tiempo` time DEFAULT NULL,
  `idNivelFichasBlancas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `idPartida` int(11) NOT NULL,
  `idPersona` int(11) DEFAULT NULL,
  `idNivelModalidad` int(11) DEFAULT NULL,
  `TiempoTotal` time DEFAULT NULL,
  `JugadasRealizadas` int(11) DEFAULT NULL,
  `CantidadErrores` int(11) DEFAULT NULL,
  `CantidadPausas` int(11) DEFAULT NULL,
  `CantidadRetiradas` int(11) DEFAULT NULL,
  `TurnosDevueltos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `Nombre` varchar(20) DEFAULT NULL,
  `Apellido` varchar(20) DEFAULT NULL,
  `Edad` int(11) DEFAULT NULL,
  `Correo` varchar(40) DEFAULT NULL,
  `Contrasena` varchar(20) DEFAULT NULL,
  `Documento` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `Nombre`, `Apellido`, `Edad`, `Correo`, `Contrasena`, `Documento`) VALUES
(90, 'Ivan', 'Yesid', 2, 'ivann@gmail.com', '12345', 1024895280),
(99, 'Yesid', 'jose', 23, 'jj@gmail.com', '5678', 1025498720),
(100, 'juan', 'camilo', 23, 'ivan@gmail.com', '2345', 80549862),
(101, 'yesid', 'camilo', 23, '2@gmail.com', '12345', 1250078035),
(103, 'ivan', 'yesid', 286, 'ivan@', 'ivan', 101032190),
(105, 'fabio', 'andre', 25, 'a@gmail.com', '12345', 95874251),
(108, 'Ivan', 'Yesid', 2, 'a@gmail.com', '12345', 60995477),
(109, 'Ivan', 'Yesid', 2, 'aa@gmail.com', '12345', 50248672),
(110, 'flota flota', 'rodriguez', 25, 'ff@gmail.com', '12345', 1000356210),
(113, 'felipe', 'melo', 26, 'melo@.com', '123456789', 1025468231);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `names` varchar(40) NOT NULL,
  `user` varchar(20) NOT NULL,
  `pwd` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`names`, `user`, `pwd`) VALUES
('Ivan Espitia', 'ivan@gmail.com', '12345');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `informe`
--
ALTER TABLE `informe`
  ADD PRIMARY KEY (`idInforme`),
  ADD KEY `idPartida` (`idPartida`);

--
-- Indices de la tabla `informegeneral`
--
ALTER TABLE `informegeneral`
  ADD PRIMARY KEY (`idInformeGeneral`),
  ADD KEY `idPersona` (`idPersona`);

--
-- Indices de la tabla `modalidad`
--
ALTER TABLE `modalidad`
  ADD PRIMARY KEY (`idModalidad`);

--
-- Indices de la tabla `nivelmodalidad`
--
ALTER TABLE `nivelmodalidad`
  ADD PRIMARY KEY (`idNivelModalidad`),
  ADD KEY `idModalidad` (`idModalidad`),
  ADD KEY `idNivelFichasNegras` (`idNivelFichasNegras`),
  ADD KEY `idNivelFichasBlancas` (`idNivelFichasBlancas`);

--
-- Indices de la tabla `nivel_fichas_blancas`
--
ALTER TABLE `nivel_fichas_blancas`
  ADD PRIMARY KEY (`idNivelFichasBlancas`),
  ADD KEY `idNivelFichasNegras` (`idNivelFichasNegras`);

--
-- Indices de la tabla `nivel_fichas_negras`
--
ALTER TABLE `nivel_fichas_negras`
  ADD PRIMARY KEY (`idNivelFichasNegras`),
  ADD KEY `idNivelFichasBlancas` (`idNivelFichasBlancas`);

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`idPartida`),
  ADD KEY `idPersona` (`idPersona`),
  ADD KEY `idNivelModalidad` (`idNivelModalidad`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD UNIQUE KEY `user` (`user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `informe`
--
ALTER TABLE `informe`
  MODIFY `idInforme` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `informegeneral`
--
ALTER TABLE `informegeneral`
  MODIFY `idInformeGeneral` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `modalidad`
--
ALTER TABLE `modalidad`
  MODIFY `idModalidad` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `nivelmodalidad`
--
ALTER TABLE `nivelmodalidad`
  MODIFY `idNivelModalidad` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `nivel_fichas_blancas`
--
ALTER TABLE `nivel_fichas_blancas`
  MODIFY `idNivelFichasBlancas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `nivel_fichas_negras`
--
ALTER TABLE `nivel_fichas_negras`
  MODIFY `idNivelFichasNegras` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `idPartida` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `informegeneral`
--
ALTER TABLE `informegeneral`
  ADD CONSTRAINT `informegeneral_ibfk_1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `nivelmodalidad`
--
ALTER TABLE `nivelmodalidad`
  ADD CONSTRAINT `nivelmodalidad_ibfk_1` FOREIGN KEY (`idModalidad`) REFERENCES `modalidad` (`idModalidad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nivelmodalidad_ibfk_2` FOREIGN KEY (`idNivelFichasNegras`) REFERENCES `nivel_fichas_negras` (`idNivelFichasNegras`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nivelmodalidad_ibfk_3` FOREIGN KEY (`idNivelFichasBlancas`) REFERENCES `nivel_fichas_blancas` (`idNivelFichasBlancas`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `nivel_fichas_blancas`
--
ALTER TABLE `nivel_fichas_blancas`
  ADD CONSTRAINT `nivel_fichas_blancas_ibfk_1` FOREIGN KEY (`idNivelFichasNegras`) REFERENCES `nivel_fichas_negras` (`idNivelFichasNegras`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `nivel_fichas_negras`
--
ALTER TABLE `nivel_fichas_negras`
  ADD CONSTRAINT `nivel_fichas_negras_ibfk_1` FOREIGN KEY (`idNivelFichasBlancas`) REFERENCES `nivel_fichas_blancas` (`idNivelFichasBlancas`);

--
-- Filtros para la tabla `partida`
--
ALTER TABLE `partida`
  ADD CONSTRAINT `partida_ibfk_1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `partida_ibfk_2` FOREIGN KEY (`idPartida`) REFERENCES `informe` (`idPartida`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `partida_ibfk_3` FOREIGN KEY (`idNivelModalidad`) REFERENCES `nivelmodalidad` (`idNivelModalidad`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
