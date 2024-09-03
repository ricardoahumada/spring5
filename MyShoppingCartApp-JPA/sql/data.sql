
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: productos
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `almacen`
--

# LOCK TABLES `almacen` WRITE;
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
INSERT INTO `almacen` VALUES (1,1,4),
(2,2,7),
(3,3,10),
(4,4,6),
(5,5,7),
(6,6,9),
(7,7,9),
(8,8,7),
(10,10,8);
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;
# UNLOCK TABLES;

--
-- Dumping data for table `compra`
--

# LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,5,3,4,'2017-06-11 22:00:00'),
(2,8,5,1,'2017-06-11 22:00:00'),
(3,9,5,2,'2017-06-11 22:00:00'),
(4,8,6,2,'2017-06-11 22:00:00'),
(5,5,6,1,'2017-06-11 22:00:00'),
(6,3,7,1,'2017-06-11 22:00:00'),
(7,3,4,2,'2017-06-11 22:00:00'),
(8,3,4,4,'2017-06-11 22:00:00'),
(9,3,2,4,'2017-06-11 22:00:00'),
(10,1,8,3,'2017-06-11 22:00:00'),
(11,9,3,3,'2017-06-11 22:00:00'),
(12,8,1,1,'2017-06-11 22:00:00'),
(13,6,3,5,'2017-06-11 22:00:00'),
(14,7,6,1,'2017-06-11 22:00:00'),
(15,10,4,2,'2017-06-11 22:00:00'),
(16,10,5,1,'2017-06-11 22:00:00'),
(17,5,1,1,'2017-06-11 22:00:00'),
(18,10,6,2,'2017-06-11 22:00:00'),
(19,2,8,4,'2017-06-11 22:00:00'),
(20,7,7,5,'2017-06-11 22:00:00'),
(21,8,2,3,'2017-06-11 22:00:00'),
(22,8,5,4,'2017-06-11 22:00:00'),
(23,8,1,3,'2017-06-11 22:00:00'),
(24,1,4,4,'2017-06-11 22:00:00'),
(25,7,4,1,'2017-06-11 22:00:00'),
(26,9,4,3,'2017-06-11 22:00:00'),
(27,10,2,5,'2017-06-11 22:00:00'),
(28,10,6,3,'2017-06-11 22:00:00'),
(29,3,7,5,'2017-06-11 22:00:00'),
(30,1,2,1,'2017-06-14 22:00:00'),
(31,1,2,1,'2017-06-14 22:00:00'),
(32,1,1,4,'2017-06-14 22:00:00');
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
# UNLOCK TABLES;

--
-- Dumping data for table `producto`
--

# LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,6639,'Oriflame','India skin care','piel',5.45,30),
(2,4765,'Elizabeth Arden','Visible difference','cara',14.65,23),
(3,5836,'Elizabeth Arden','Green tea','cara',19.99,16),
(4,12834,'Estee Lauder','Double wear','perfume',29,56),
(5,9087,'MAC Cosmetics','Extra dimension','ojos',31.95,2),
(6,4207,'L\'Oreal','Men Expert','cara',9.95,19),
(7,8000,'MAC Cosmetics','Lipstick Matte','labios',19.95,25),
(8,5267,'Oriflame','Day Cream','piel',3.45,1),
(10,11784,'L\'Oreal','Absolut repair','pelo',16.95,90);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
# UNLOCK TABLES;

--
-- Dumping data for table `usuario`
--

# LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Juana','Juanason','juana@e.com',2,20,'juanason_1','2001-03-05 00:00:00',1),
(2,'Luisa','Luisason','luisa@e.com',4,74,'luisason_2','1996-04-06 00:00:00',1),
(3,'Diana','Dianason','diana@e.com',8,13,'dianason_3','2010-03-06 00:00:00',1),
(4,'Pedro','Pedroson','pedro@e.com',5,25,'pedroson_4','2000-12-31 00:00:00',1),
(5,'Marco','Marcoson','marco@e.com',6,4,'marcoson_5','1980-02-13 00:00:00',1),
(6,'Ricardo','Ricardoson','ricardo@e.com',7,8,'ricardoson_6','1999-07-25 00:00:00',1),
(7,'Nora','Norason','nora@e.com',1,16,'norason_7','1995-03-06 00:00:00',1),
(8,'Edwin','Edwinson','edwin@e.com',9,20,'edwinson_8','1992-11-04 00:00:00',1),
(9,'Marta','Martason','marta@e.com',6,36,'martason_9','1960-04-05 00:00:00',1),
(10,'Eduardo','Eduardoson','eduardo@e.com',4,23,'eduardoson_10','1999-10-08 00:00:00',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
# UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-16 14:46:36
