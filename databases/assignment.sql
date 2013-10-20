CREATE TABLE `Location` (
  `ID`   INT(8)      NOT NULL  AUTO_INCREMENT,
  `Name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE `Employer` (
  `ID`         INT(8)      NOT NULL  AUTO_INCREMENT,
  `Name`       VARCHAR(30) NOT NULL,
  `EmployerID` INT(8)      NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE `Vacancy` (
  `ID`          INT(8)       NOT NULL  AUTO_INCREMENT,
  `Description` VARCHAR(200) NOT NULL,
  `EmployerID`  INT(8)       NOT NULL,
  `LocationID`  INT(8)       NOT NULL,
  `DateCreated` TIMESTAMP    NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  `Type`        BOOLEAN      NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE `Student` (
  `ID`        INT(8)       NOT NULL  AUTO_INCREMENT,
  `FirstName` VARCHAR(30)  NOT NULL,
  `LastName`  VARCHAR(30)  NOT NULL,
  `Address`   VARCHAR(100) NOT NULL,
  `Phone`     VARCHAR(20)  NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE `Applicant` (
  `StudentID`   INT(8)    NOT NULL,
  `VacancyID`   INT(8)    NOT NULL,
  `DateCreated` TIMESTAMP NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`StudentID`),
  PRIMARY KEY (`VacancyID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Skill` (
  `ID`   INT(8)      NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(20) NOT NULL
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `VacancySkill` (
  `SkillID`   INT(8) NOT NULL,
  `VacancyID` INT(8) NOT NULL
  PRIMARY KEY (`SkillID`),
  PRIMARY KEY (`VacancyID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `VacancySkill` (
  `SkillID`   INT(8) NOT NULL,
  `StudentID` INT(8) NOT NULL
  PRIMARY KEY (`SkillID`),
  PRIMARY KEY (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;