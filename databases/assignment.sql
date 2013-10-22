/**
 * CREATE TABLES
 */

CREATE TABLE `Location` (
  `ID`   int(8)      NOT NULL  AUTO_INCREMENT,
  `Name` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `Employer` (
  `ID`         int(8)      NOT NULL  AUTO_INCREMENT,
  `Name`       varchar(30) NOT NULL,
  `LocationID` int(8)      NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Employer_LocationID` FOREIGN KEY (`LocationID`)
  REFERENCES `Location` (`ID`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `Vacancy` (
  `ID`          int(8)       NOT NULL  AUTO_INCREMENT,
  `Description` varchar(200) NOT NULL,
  `EmployerID`  int(8)       NOT NULL,
  `LocationID`  int(8)       NOT NULL,
  `DateCreated` timestamp    NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  `Type`        tinyint(1)   NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Vacancy_EmployerID` FOREIGN KEY (`EmployerID`)
  REFERENCES `Employer` (`ID`) ON DELETE NO ACTION,
  CONSTRAINT `fk_Vacancy_LocationID` FOREIGN KEY (`LocationID`)
  REFERENCES `Location` (`ID`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `Student` (
  `ID`        int(8)       NOT NULL  AUTO_INCREMENT,
  `FirstName` varchar(30)  NOT NULL,
  `LastName`  varchar(30)  NOT NULL,
  `Address`   varchar(100) NOT NULL,
  `Phone`     varchar(20)  NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `Skill` (
  `ID`   int(8)      NOT NULL  AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `StudentSkill` (
  `SkillID`   int(8) NOT NULL,
  `StudentID` int(8) NOT NULL,
  PRIMARY KEY (`SkillID`,`StudentID`),
  CONSTRAINT `fk_StudentSkill_SkillID` FOREIGN KEY (`SkillID`)
  REFERENCES `Skill` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `fk_StudentSkill_StudentID` FOREIGN KEY (`StudentID`)
  REFERENCES `Student` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `VacancySkill` (
  `SkillID`   int(8) NOT NULL,
  `VacancyID` int(8) NOT NULL,
  PRIMARY KEY (`SkillID`,`VacancyID`),
  CONSTRAINT `fk_VacancySkill_SkillID` FOREIGN KEY (`SkillID`)
  REFERENCES `Skill` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `fk_VacancySkill_VacancyID` FOREIGN KEY (`VacancyID`)
  REFERENCES `Vacancy` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Applicant` (
  `StudentID`   int(8)    NOT NULL,
  `VacancyID`   int(8)    NOT NULL,
  `DateCreated` timestamp NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`StudentID`,`VacancyID`),
  CONSTRAINT `fk_Applicant_StudentID` FOREIGN KEY (`StudentID`)
  REFERENCES `Student` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `fk_Applicant_VacancyID` FOREIGN KEY (`VacancyID`)
  REFERENCES `Vacancy` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/**
 * INSERT DATA
 */

INSERT INTO `Location` (`ID`, `Name`)
VALUES
  (1,'Mars'),
  (2,'Atlantis'),
  (3,'Lynmore'),
  (4,'Auckland'),
  (5,'Rotorua'),
  (6,'Titan'),
  (7,'Jotunheim'),
  (8,'Germany'),
  (9,'Connecticut'),
  (10,'Australia');

INSERT INTO `Employer` (`ID`, `Name`, `LocationID`)
VALUES
  (1,'Doctor Doom',1),
  (2,'Dark Phoenix',2),
  (3,'Thanos',3),
  (4,'Loki',4),
  (5,'Magneto',5),
  (6,'Norman Osborne',6),
  (7,'Red Skull',7),
  (8,'Galactus',8),
  (9,'Ultron',9),
  (10,'Doctor Octopus',10);

INSERT INTO `Vacancy` (`ID`, `Description`, `EmployerID`, `LocationID`, `DateCreated`, `Type`)
VALUES
  (1,'Reporter',1,1,'2013-10-22 18:45:00',1),
  (2,'Photographer',2,2,'2013-10-22 18:46:00',0),
  (3,'Police Officer',3,3,'2013-10-22 18:57:41',1),
  (4,'Forensic Scientist',4,4,'2013-10-22 19:37:49',1),
  (5,'Detective',5,5,'2013-10-22 19:38:03',5),
  (6,'Attorney',6,6,'2013-10-22 19:38:12',6),
  (7,'Scientist',7,7,'2013-10-22 19:38:42',7),
  (8,'Fire Fighter',8,8,'2013-10-22 19:39:32',8),
  (9,'Lawyer',9,9,'2013-10-22 19:41:42',9),
  (10,'Teacher',10,10,'2013-10-22 19:41:53',10);

INSERT INTO `Student` (`ID`, `FirstName`, `LastName`, `Address`, `Phone`)
VALUES
  (1,'Clark','Kent','Metropolis','12345'),
  (2,'Hal','Jordon','Coast city','51232'),
  (3,'Peter','Parker','New York','12354'),
  (4,'Wally','West','Keystone City','23422'),
  (5,'Bruce','Wayne','Gotham City','42352'),
  (6,'Bruce','Banner','New York','52313'),
  (7,'James','Howlett','Canada','12314'),
  (8,'Steven','Rogers','New York','12312'),
  (9,'Tony','Stark','New York','41231'),
  (10,'Wade','Wilson','Canada','12511');

INSERT INTO `Skill` (`ID`, `Name`)
VALUES
  (1,'Superhuman Strength'),
  (2,'Invulnerability'),
  (3,'Self Healing'),
  (4,'Flight'),
  (5,'Superhuman Speed'),
  (6,'X-Ray Vision'),
  (7,'Quantum Tunneling'),
  (8,'Wall Crawling'),
  (9,'Spider Sense'),
  (10,'Power Ring');

INSERT INTO `StudentSkill` (`SkillID`, `StudentID`)
VALUES
  (1,1),
  (2,2),
  (3,3),
  (4,4),
  (5,5),
  (6,6),
  (7,7),
  (8,8),
  (9,9),
  (10,10);

INSERT INTO `VacancySkill` (`SkillID`, `VacancyID`)
VALUES
  (1,1),
  (2,2),
  (3,3),
  (4,4),
  (5,5),
  (6,6),
  (7,7),
  (8,8),
  (9,9),
  (10,10);

INSERT INTO `Applicant` (`StudentID`, `VacancyID`, `DateCreated`)
VALUES
  (1,1,'2013-10-22 19:42:18'),
  (2,2,'2013-10-22 19:42:20'),
  (3,3,'2013-10-22 19:42:23'),
  (4,4,'2013-10-22 19:42:25'),
  (5,5,'2013-10-22 19:42:29'),
  (6,6,'2013-10-22 19:42:33'),
  (7,7,'2013-10-22 19:42:35'),
  (8,8,'2013-10-22 19:42:39'),
  (9,9,'2013-10-22 19:42:41'),
  (10,10,'2013-10-22 19:42:43');