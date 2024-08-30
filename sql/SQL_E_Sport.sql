-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: esport
-- ------------------------------------------------------
-- Server version	11.4.2-MariaDB-ubu2404

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `id_game` int(11) NOT NULL AUTO_INCREMENT,
  `name_game` varchar(30) NOT NULL,
  `banner_game` varchar(150) NOT NULL,
  `img_game` varchar(150) NOT NULL,
  `pegi_game` int(11) NOT NULL,
  `year_game` int(11) NOT NULL,
  PRIMARY KEY (`id_game`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (1,'game1','http://banner1.fr','http://img1.fr',18,2024),(2,'game1','http://banner1.fr','http://img1.fr',18,2024),(3,'game1','http://banner1.fr','http://img1.fr',18,2024);
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `games_has_styles`
--

DROP TABLE IF EXISTS `games_has_styles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games_has_styles` (
  `id_style` int(11) NOT NULL,
  `id_game` int(11) NOT NULL,
  PRIMARY KEY (`id_style`,`id_game`),
  KEY `caracterise_games0_FK` (`id_game`),
  CONSTRAINT `caracterise_games0_FK` FOREIGN KEY (`id_game`) REFERENCES `games` (`id_game`),
  CONSTRAINT `caracterise_styles_FK` FOREIGN KEY (`id_style`) REFERENCES `styles` (`id_style`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games_has_styles`
--

LOCK TABLES `games_has_styles` WRITE;
/*!40000 ALTER TABLE `games_has_styles` DISABLE KEYS */;
INSERT INTO `games_has_styles` VALUES (1,1),(1,2),(1,3);
/*!40000 ALTER TABLE `games_has_styles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members` (
  `id_member` int(11) NOT NULL AUTO_INCREMENT,
  `firstname_member` varchar(30) NOT NULL,
  `lastname_member` varchar(30) NOT NULL,
  `nickname_member` varchar(30) NOT NULL,
  `photo_member` varchar(150) NOT NULL,
  `country_member` varchar(30) NOT NULL,
  PRIMARY KEY (`id_member`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (1,'firstname1','lastname1','nickname1','http://photo1.fr','country1'),(2,'firstname1','lastname1','nickname1','http://photo1.fr','country1'),(3,'firstname1','lastname1','nickname1','http://photo1.fr','country1');
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members_has_roles`
--

DROP TABLE IF EXISTS `members_has_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members_has_roles` (
  `id_member` int(11) NOT NULL,
  `id_team` int(11) NOT NULL,
  `id_role` int(11) NOT NULL,
  PRIMARY KEY (`id_member`,`id_team`),
  KEY `definit_teams1_FK` (`id_team`),
  KEY `fk_definit_role1_idx` (`id_role`),
  CONSTRAINT `definit_members_FK` FOREIGN KEY (`id_member`) REFERENCES `members` (`id_member`),
  CONSTRAINT `definit_teams1_FK` FOREIGN KEY (`id_team`) REFERENCES `teams` (`id_team`),
  CONSTRAINT `fk_definit_role1` FOREIGN KEY (`id_role`) REFERENCES `roles` (`id_role`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members_has_roles`
--

LOCK TABLES `members_has_roles` WRITE;
/*!40000 ALTER TABLE `members_has_roles` DISABLE KEYS */;
INSERT INTO `members_has_roles` VALUES (1,1,1),(2,2,1),(3,2,3);
/*!40000 ALTER TABLE `members_has_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `task_role` varchar(30) NOT NULL,
  `type_role` int(11) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'task1',1),(2,'task1',1),(3,'task1',1);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `styles`
--

DROP TABLE IF EXISTS `styles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `styles` (
  `id_style` int(11) NOT NULL AUTO_INCREMENT,
  `name_style` varchar(30) NOT NULL,
  PRIMARY KEY (`id_style`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `styles`
--

LOCK TABLES `styles` WRITE;
/*!40000 ALTER TABLE `styles` DISABLE KEYS */;
INSERT INTO `styles` VALUES (1,'style1'),(2,'style1'),(3,'style1');
/*!40000 ALTER TABLE `styles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teams` (
  `id_team` int(11) NOT NULL AUTO_INCREMENT,
  `name_team` varchar(30) NOT NULL,
  `maxplayers_team` int(11) NOT NULL,
  `logo_team` varchar(150) NOT NULL,
  `id_game` int(11) NOT NULL,
  PRIMARY KEY (`id_team`),
  KEY `teams_games_FK` (`id_game`),
  CONSTRAINT `teams_games_FK` FOREIGN KEY (`id_game`) REFERENCES `games` (`id_game`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'team1',8,'http://logo1.fr',1),(2,'team1',8,'http://logo1.fr',1),(3,'team1',8,'http://logo1.fr',1);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'esport'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-20 18:21:52
