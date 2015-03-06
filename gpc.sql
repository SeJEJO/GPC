-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-03-2015 a las 03:44:28
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gpc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gpc`
--

DROP TABLE IF EXISTS `gpc`;
CREATE TABLE IF NOT EXISTS `gpc` (
  `id_gpc` int(11) NOT NULL AUTO_INCREMENT,
  `sitio` varchar(50) NOT NULL,
  `tipo_sitio` varchar(25) NOT NULL,
  `usuario_sitio` varchar(30) NOT NULL,
  `pass_sitio` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `correo` varchar(50) NOT NULL,
  `notas` varchar(100) NOT NULL,
  `usuario` varchar(30) CHARACTER SET armscii8 NOT NULL,
  PRIMARY KEY (`id_gpc`),
  KEY `usuario` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `nombre_usu` varchar(30) CHARACTER SET armscii8 NOT NULL,
  `pass_usu` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `acceso` tinyint(1) NOT NULL DEFAULT '0',
  `intento` int(1) NOT NULL DEFAULT '3',
  PRIMARY KEY (`nombre_usu`),
  UNIQUE KEY `NOMBRE_USU` (`nombre_usu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='ACCESO Valores(S/N)';

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `gpc`
--
ALTER TABLE `gpc`
  ADD CONSTRAINT `fk_gpc_usu_nom` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`nombre_usu`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
