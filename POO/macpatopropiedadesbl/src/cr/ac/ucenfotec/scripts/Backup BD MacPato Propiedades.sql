CREATE DATABASE  IF NOT EXISTS `propiedades` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `propiedades`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: propiedades
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `hipoteca`
--

DROP TABLE IF EXISTS `hipoteca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hipoteca` (
  `numhipoteca` int NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `monto` decimal(5,2) DEFAULT NULL,
  `acredor` varchar(45) DEFAULT NULL,
  `numfinca` int DEFAULT NULL,
  PRIMARY KEY (`numhipoteca`),
  CONSTRAINT `numfinca` FOREIGN KEY (`numhipoteca`) REFERENCES `propiedad` (`numfinca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hipoteca`
--

LOCK TABLES `hipoteca` WRITE;
/*!40000 ALTER TABLE `hipoteca` DISABLE KEYS */;
/*!40000 ALTER TABLE `hipoteca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inquilino`
--

DROP TABLE IF EXISTS `inquilino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inquilino` (
  `cedula` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `profesion` varchar(45) DEFAULT NULL,
  `edad` varchar(45) DEFAULT NULL,
  `idresidencia` int DEFAULT NULL,
  PRIMARY KEY (`cedula`),
  KEY `idresidencia_idx` (`idresidencia`),
  CONSTRAINT `idresidencia` FOREIGN KEY (`idresidencia`) REFERENCES `residencia` (`idresidencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquilino`
--

LOCK TABLES `inquilino` WRITE;
/*!40000 ALTER TABLE `inquilino` DISABLE KEYS */;
INSERT INTO `inquilino` VALUES (123,'Juan','artista','28',1),(456,'María','Panadera','30',NULL),(789,'Pedro','bombero','40',NULL);
/*!40000 ALTER TABLE `inquilino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propiedad`
--

DROP TABLE IF EXISTS `propiedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propiedad` (
  `numfinca` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `cuartos` int DEFAULT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `costo` decimal(9,2) DEFAULT NULL,
  PRIMARY KEY (`numfinca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propiedad`
--

LOCK TABLES `propiedad` WRITE;
/*!40000 ALTER TABLE `propiedad` DISABLE KEYS */;
INSERT INTO `propiedad` VALUES (1001,'La amistad',4,'San José',175000.00),(1002,'Monte verde',2,'Heredia',200000.00);
/*!40000 ALTER TABLE `propiedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propiedad_inquilino`
--

DROP TABLE IF EXISTS `propiedad_inquilino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propiedad_inquilino` (
  `cedula` int NOT NULL,
  `numfinca` int NOT NULL,
  PRIMARY KEY (`cedula`,`numfinca`),
  KEY `numfinca_fk_idx` (`numfinca`),
  CONSTRAINT `cedula_fk` FOREIGN KEY (`cedula`) REFERENCES `inquilino` (`cedula`),
  CONSTRAINT `numfinca_fk` FOREIGN KEY (`numfinca`) REFERENCES `propiedad` (`numfinca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propiedad_inquilino`
--

LOCK TABLES `propiedad_inquilino` WRITE;
/*!40000 ALTER TABLE `propiedad_inquilino` DISABLE KEYS */;
INSERT INTO `propiedad_inquilino` VALUES (123,1001),(456,1001);
/*!40000 ALTER TABLE `propiedad_inquilino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residencia`
--

DROP TABLE IF EXISTS `residencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `residencia` (
  `idresidencia` int NOT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `canton` varchar(45) DEFAULT NULL,
  `distrito` varchar(45) DEFAULT NULL,
  `barrio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idresidencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residencia`
--

LOCK TABLES `residencia` WRITE;
/*!40000 ALTER TABLE `residencia` DISABLE KEYS */;
INSERT INTO `residencia` VALUES (1,'San José','San José','Catedral','Barrio chino');
/*!40000 ALTER TABLE `residencia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-10 21:28:34
