-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 25, 2023 at 12:46 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bananawhatsappdb`
--

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `activo`, `alta`, `email`, `nombre`) VALUES
(1, b'1', '2023-11-25', 'juana@j.com', 'Juana'),
(2, b'1', '2023-11-25', 'luis@l.com', 'Luis');

--
-- Dumping data for table `mensaje`
--

INSERT INTO `mensaje` (`id`, `cuerpo`, `fecha`, `from_user`, `to_user`) VALUES
(1, 'Hola, qué tal?', '2023-11-25', 1, 2),
(2, 'Muy bien! y tu?', '2023-11-25', 2, 1),
(3, 'Bien también...', '2023-11-25', 1, 2),
(4, 'Chachi!', '2023-11-25', 2, 1);


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
