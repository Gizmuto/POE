-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-11-2025 a las 01:02:24
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `horarios`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `Codigo` int(10) NOT NULL,
  `id_Docente` int(11) NOT NULL,
  `Grupo` varchar(3) NOT NULL,
  `Cupo` varchar(3) NOT NULL,
  `Docente_responsable` varchar(50) NOT NULL,
  `Horario` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`Codigo`, `id_Docente`, `Grupo`, `Cupo`, `Docente_responsable`, `Horario`) VALUES
(1, 1, '2', '1', 'awa', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `ID` int(11) NOT NULL,
  `Docente` varchar(50) NOT NULL,
  `CursoImpartible1` varchar(50) NOT NULL,
  `CursoImpartible2` varchar(50) NOT NULL,
  `CursoImpartible3` varchar(50) NOT NULL,
  `CursoImpartible4` varchar(50) NOT NULL,
  `HorariosDisponibles_dia` varchar(20) NOT NULL,
  `HorariosDisponibles_hola` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`ID`, `Docente`, `CursoImpartible1`, `CursoImpartible2`, `CursoImpartible3`, `CursoImpartible4`, `HorariosDisponibles_dia`, `HorariosDisponibles_hola`) VALUES
(1, 'awa', '', '', '', 'asfas', '', ''),
(3, 'awa', '', '', '', 'wad', '', ''),
(4, 'awa', 'coco', 'asd', 'asdw', 'cas', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salones`
--

CREATE TABLE `salones` (
  `ID` int(11) NOT NULL,
  `Proyector` varchar(20) NOT NULL,
  `Computadores` varchar(20) NOT NULL,
  `Tableros` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `salones`
--

INSERT INTO `salones` (`ID`, `Proyector`, `Computadores`, `Tableros`) VALUES
(2, 'SÍ', '1', '1'),
(4, 'SÍ', '1', '1'),
(90, 'NO', '6', '56');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `fk_profesor` (`id_Docente`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `salones`
--
ALTER TABLE `salones`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `salones`
--
ALTER TABLE `salones`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD CONSTRAINT `fk_profesor` FOREIGN KEY (`id_Docente`) REFERENCES `profesores` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
