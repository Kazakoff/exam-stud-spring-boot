drop database if exists `gr`;
CREATE DATABASE  `gr` ;
USE `gr`;


CREATE TABLE `gruppyi` (
  `Nazvanie` varchar(50) NOT NULL unique,
  `Shifr` int(11) NOT NULL auto_increment,
  `DataFormir` date NOT NULL,
  `KodPlana` int(11) NOT NULL,
 `Status` varchar(50), 
`StatusDate` date, 

  PRIMARY KEY (`Shifr`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;


CREATE TABLE `studentyi` (
  `ShifrGruppyi` int(11) NOT NULL,
  `NomerZachetki` bigint(20) NOT NULL,
  `Familiya` char(30) NOT NULL,
  `Imya` char(30) NOT NULL,
  `Otchestvo` char(30) NOT NULL,
  `Gorod` char(30) NOT NULL,
  `Adres` char(80) NOT NULL,
  `Tel` char(30) NOT NULL,
`Status` varchar(50), 
`StatusDate` date, 

  PRIMARY KEY (`NomerZachetki`),
  KEY `FK_Studentyi_Gruppyi_` (`ShifrGruppyi`),
  CONSTRAINT `FK_Studentyi_Gruppyi_` FOREIGN KEY (`ShifrGruppyi`) REFERENCES `gruppyi` (`Shifr`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COLLATE utf8_general_ci;

LOCK TABLES `gruppyi` WRITE;

INSERT INTO `gruppyi` VALUES 
('It-1',1,'2014-07-23',2,'created', now()),
('It-2',2,'2013-09-15',2,'created', now()),
('A-2',3,'2013-09-15',1,'created', now()),
('A-3',4,'2014-09-15',1,'created', now());


UNLOCK TABLES;

LOCK TABLES `studentyi` WRITE;

INSERT INTO `studentyi` VALUES 
(1,10122,'Petrov','Peter','Ivanich','Vitebsk','Moskow awe., 62, 2, 129','+375297451421','graduate', now()),
(1,10123,'Sidorov','Alex','Ivanich','Vitebsk','Moskow awe., 15, 19','+375297751421','enrolled', now()),
(3,10355,'Sharkov','Ted','Alexeevicj','Vitebsk','Moskow awe., 73, 2, 9','+375297451471','academic leave', now()),
(2,10356,'Sergeev','Boris','Ivanich','Minsk','Moskow awe., 12, 2, 19','+375297433421','academic leave', now()),
(3,10361,'Sherbakov','Dan','Sergeevich','Vitebsk','Pravdy st., 41, 19','+375297411421','enrolled', now()),
(4,10368,'Frolov','Dan','Sergeevich','Vitebsk','Stroiteley st., 41, 19','+375297411421','enrolled', now()),
(4,10369,'Firsov','Vlad','Petrovich','Minsk','Pravdy st., 41, 19','+375297411421','enrolled', now()),
(3,10362,'Ivanov','Andrew','Ivanich','Vitebsk','Pravdy st., 12, 1','+375297451199','graduate', now());
UNLOCK TABLES;


-- Dump completed on 2014-08-28 15:51:23

