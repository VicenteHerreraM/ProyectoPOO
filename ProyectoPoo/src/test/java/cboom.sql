-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2023 a las 07:48:57
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cboom`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `RUT` varchar(10) NOT NULL,
  `Nombre` varchar(35) NOT NULL,
  `Apellido` varchar(35) NOT NULL,
  `Altura` int(3) NOT NULL,
  `Peso` decimal(6,2) NOT NULL,
  `Contrasenya` varchar(100) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `FechaNac` date NOT NULL,
  `dietaCliente` int(11) NOT NULL,
  `rutinaCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`RUT`, `Nombre`, `Apellido`, `Altura`, `Peso`, `Contrasenya`, `Correo`, `FechaNac`, `dietaCliente`, `rutinaCliente`) VALUES
('0000000-1', 'ISABEL', 'II', 174, 65.00, 'password', 'princesaMisifu@gmail.com', '1926-04-21', 3, 1),
('10936162-3', 'RICARDO', 'SOTO', 175, 76.00, 'R1ch4r$$$$$$', 'ricardosoto@gmail.com', '1970-06-29', 7, 6),
('11222333-1', 'DORIAN', 'CANALES', 180, 65.00, 'AAaa1122..,,', 'xXxdOrIaNxXx@yahoo.com', '2002-02-06', 2, 1),
('1249535-3', 'ADOLF', 'MALITO', 174, 72.00, 'PazyArmonia100%', 'adolfitoUwU@outlook.com', '1889-04-20', 3, 4),
('13395180-6', 'DANIEL', 'CARRASCO', 156, 60.00, '1234567890Aa#', 'dani@gmail.com', '2000-06-14', 1, 6),
('20483861-5', 'Vicente', 'Herrera', 175, 78.00, 'AAaa1122##$$', 'vicenteVicens1@hotmail.com', '2000-09-05', 7, 4),
('20484286-8', 'PPITO', 'LOPEZ', 175, 65.00, '1234567899Aa#', 'pepito@gmail.com', '2000-10-06', 5, 2),
('20963471-6', 'Dorian', 'Canales', 180, 70.00, 'AAaa1122##$$', 'doriancanales0602@gmail.com', '2002-02-06', 2, 1),
('22333444-2', 'IGNACIO', 'VILLALOBOS', 175, 70.00, 'C0l0-C0l0Campeon', 'nachoBnBellako@gmail.com', '2000-06-23', 6, 1),
('24834529-2', 'RAMIRO', 'RAMIREZ', 123, 676.00, '1234567890Aa#$', 'ramirito@gmail.com', '1990-10-17', 8, 4),
('33444555-3', 'VICENTE', 'HERRERA', 172, 75.00, 'Ser0noSer.', 'v1c3nt3cr4ck@hotmail.com', '2000-09-05', 5, 5),
('44555666-4', 'JESÚS', 'DE NAZARETH', 170, 70.00, 'DiosMiS4lv4dor!', 'jesusBnBellako@hotmail.com', '1893-01-01', 7, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `ID_Dieta` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Comida` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL CHECK (json_valid(`Comida`))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`ID_Dieta`, `Nombre`, `Comida`) VALUES
(1, 'Mediterránea', '[\"Ensalada Griega.\",\"Pescado a la parrilla con verduras\"]\r\n'),
(2, 'Vegetariana', '[\"Hamburguesa de lentejas\",\"Arroz con verduras al curry\"]'),
(3, 'Vegana', '[\"Hamburguesa de lentejas\", \"Arroz con verduras al curry\"]'),
(4, 'Baja en carbohidratos', '[\"Omelet con queso, espinaca y tocino\",\"Ensalada de atun con lechuga\"]'),
(5, 'Baja en grasas', '[\"Salmón al horno con arroz integral\",\"Tortilla de huevo con espinacas, cebolla y pimiento\"]'),
(6, 'Cetogénica', '[\"Huevos revueltos con aguacate y tocino\",\"Hamburguesa con queso cheddar, lechuga y aguacate\"]'),
(7, 'Paleo', '[\"Ensalada de pollo a la parrilla con aguacate, tomate y lechuga\",\"Tortilla de huevo con espinacas y champiñones\"]'),
(8, 'Estándar', '[\"Pan con queso\",\"Fideos con salsa de tomate y carne molida\"]');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutina`
--

CREATE TABLE `rutina` (
  `ID_Rutina` int(11) NOT NULL,
  `Nombre_Rutina` varchar(30) NOT NULL,
  `Ejercicio` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL CHECK (json_valid(`Ejercicio`))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rutina`
--

INSERT INTO `rutina` (`ID_Rutina`, `Nombre_Rutina`, `Ejercicio`) VALUES
(1, 'Full Body', '[\"Sentadilla 15x3\",\"Press de banca 12x4\",\"Crunch 20x5\"]'),
(2, 'Empuje-Jalón', '[\"Press de banca 12x4\",\"Paralelas 10x3\",\"Aperturas con polea 8x5\"]'),
(3, 'Torso-Pierna', '[\"Sentadillas 15x5\",\"Crunch 20x5\",\"Zancadas 20x4\"]'),
(4, 'HITT', '[\"Burpee 2 min\",\"Sentadilla 1 min 30 sec\",\"Crunch 2 min 30 sec\"]'),
(5, 'Cardio', '[\"Sentadilla 15x3\",\"Burpee 15x4\",\"Bicicleta Estática 10 min\"]'),
(6, 'Estándar', '[\"Flexiones 15x4\",\"Sentadillas 20x5\",\"Plancha 1 min\"]');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`RUT`),
  ADD KEY `idx_idRutina` (`rutinaCliente`),
  ADD KEY `idx_idDieta` (`dietaCliente`) USING BTREE;

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`ID_Dieta`);

--
-- Indices de la tabla `rutina`
--
ALTER TABLE `rutina`
  ADD PRIMARY KEY (`ID_Rutina`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `ID_Dieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_3` FOREIGN KEY (`rutinaCliente`) REFERENCES `rutina` (`ID_Rutina`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cliente_ibfk_4` FOREIGN KEY (`dietaCliente`) REFERENCES `dieta` (`ID_Dieta`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cliente_ibfk_5` FOREIGN KEY (`dietaCliente`) REFERENCES `dieta` (`ID_Dieta`),
  ADD CONSTRAINT `cliente_ibfk_6` FOREIGN KEY (`rutinaCliente`) REFERENCES `rutina` (`ID_Rutina`),
  ADD CONSTRAINT `cliente_ibfk_7` FOREIGN KEY (`dietaCliente`) REFERENCES `dieta` (`ID_Dieta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
