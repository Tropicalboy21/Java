-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: localhost    Database: salvahogar
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alarma`
--

DROP TABLE IF EXISTS `alarma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alarma` (
  `direccion` varchar(45) NOT NULL,
  `identificacion` varchar(45) DEFAULT NULL,
  `encargado` varchar(45) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  KEY `encargado` (`encargado`),
  CONSTRAINT `alarma_ibfk_1` FOREIGN KEY (`encargado`) REFERENCES `vecino` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alarma`
--

LOCK TABLES `alarma` WRITE;
/*!40000 ALTER TABLE `alarma` DISABLE KEYS */;
INSERT INTO `alarma` VALUES ('Pavas','C124','Lucas','robo');
/*!40000 ALTER TABLE `alarma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casa`
--

DROP TABLE IF EXISTS `casa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `casa` (
  `direccion` varchar(45) NOT NULL,
  `identificacion` varchar(45) DEFAULT NULL,
  `encargado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casa`
--

LOCK TABLES `casa` WRITE;
/*!40000 ALTER TABLE `casa` DISABLE KEYS */;
INSERT INTO `casa` VALUES ('Heredia','T777','Juan'),('Pavas','C124','Lucas'),('Puntarenas','I345','Juan'),('Talamanca','T812','Juan');
/*!40000 ALTER TABLE `casa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casa_vecino`
--

DROP TABLE IF EXISTS `casa_vecino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `casa_vecino` (
  `direccion` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`direccion`,`nombre`),
  KEY `direccion_fk_idx` (`direccion`),
  KEY `nombre_fk` (`nombre`),
  CONSTRAINT `direccion_fk` FOREIGN KEY (`direccion`) REFERENCES `casa` (`direccion`),
  CONSTRAINT `nombre_fk` FOREIGN KEY (`nombre`) REFERENCES `vecino` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casa_vecino`
--

LOCK TABLES `casa_vecino` WRITE;
/*!40000 ALTER TABLE `casa_vecino` DISABLE KEYS */;
INSERT INTO `casa_vecino` VALUES ('Heredia','Lucas'),('Pavas','Juan'),('Puntarenas','Lucas');
/*!40000 ALTER TABLE `casa_vecino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vecino`
--

DROP TABLE IF EXISTS `vecino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vecino` (
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `identificacion` varchar(45) DEFAULT NULL,
  `fechanacimiento` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `encargado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vecino`
--

LOCK TABLES `vecino` WRITE;
/*!40000 ALTER TABLE `vecino` DISABLE KEYS */;
INSERT INTO `vecino` VALUES ('Juan','Mendez','43514156','2000-04-21',24,'Masculino','61016510','si'),('Lucas','Muller','545223514','2000-04-21',24,'Masculino','61012133','si');
/*!40000 ALTER TABLE `vecino` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-22 19:04:31



-- __________________________________________________________________________________________


CREATE DATABASE IF NOT EXISTS `bienFeliz` /*!40100
 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `salvahogar`;

-- Table structure for table `casa`
DROP TABLE IF EXISTS `casa`;
CREATE TABLE `casa`(
  `direccion` varchar(45) NOT NULL,
  `identificacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insert data into `casa`
INSERT INTO `casa` VALUES ('Pavas', 'C124');

-- Table structure for table `vecino`
DROP TABLE IF EXISTS `vecino`;
CREATE TABLE `vecino`(
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `fechanacimiento` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
