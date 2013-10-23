/**
 * CREATE TABLES
 */

CREATE TABLE Location (
  ID   int         NOT NULL  IDENTITY(1,1),
  Name varchar(30) NOT NULL,
  CONSTRAINT pk_Location PRIMARY KEY (ID)
);

CREATE TABLE Employer (
  ID         int         NOT NULL  IDENTITY(1,1),
  Name       varchar(30) NOT NULL,
  LocationID int         NOT NULL,
  CONSTRAINT pk_Employer PRIMARY KEY (ID),
  CONSTRAINT fk_Employer_LocationID FOREIGN KEY (LocationID)
  REFERENCES Location (ID) ON DELETE NO ACTION
);

CREATE TABLE Student (
  ID        int          NOT NULL  IDENTITY(1,1),
  FirstName varchar(30)  NOT NULL,
  LastName  varchar(30)  NOT NULL,
  Address   varchar(100) NOT NULL,
  Phone     varchar(20)  NOT NULL,
  CONSTRAINT pk_Student PRIMARY KEY (ID)
);

CREATE TABLE StudentEmployed (
  ID        int          NOT NULL,
  FirstName varchar(30)  NOT NULL,
  LastName  varchar(30)  NOT NULL,
  Address   varchar(100) NOT NULL,
  Phone     varchar(20)  NOT NULL,
  CONSTRAINT pk_StudentEmployed PRIMARY KEY (ID)
);

CREATE TABLE Vacancy (
  ID          int          NOT NULL  IDENTITY(1,1),
  Description varchar(200) NOT NULL,
  EmployerID  int          NOT NULL,
  LocationID  int          NOT NULL,
  DateCreated datetime     NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  Type        tinyint      NOT NULL,
  StudentID   int          NULL,
  CONSTRAINT pk_Vacancy PRIMARY KEY (ID),
  CONSTRAINT fk_Vacancy_EmployerID FOREIGN KEY (EmployerID)
  REFERENCES Employer (ID) ON DELETE NO ACTION,
  CONSTRAINT fk_Vacancy_LocationID FOREIGN KEY (LocationID)
  REFERENCES Location (ID) ON DELETE NO ACTION,
  CONSTRAINT fk_Vacancy_StudentID FOREIGN KEY (StudentID)
  REFERENCES StudentEmployed (ID) ON DELETE SET NULL
);

CREATE TABLE Skill (
  ID   int         NOT NULL  IDENTITY(1,1),
  Name varchar(20) NOT NULL,
  CONSTRAINT pk_Skill PRIMARY KEY (ID)
);

CREATE TABLE StudentSkill (
  SkillID   int NOT NULL,
  StudentID int NOT NULL,
  CONSTRAINT pk_StudentSkill PRIMARY KEY (SkillID,StudentID),
  CONSTRAINT fk_StudentSkill_SkillID FOREIGN KEY (SkillID)
  REFERENCES Skill (ID) ON DELETE CASCADE,
  CONSTRAINT fk_StudentSkill_StudentID FOREIGN KEY (StudentID)
  REFERENCES Student (ID) ON DELETE CASCADE
);

CREATE TABLE VacancySkill (
  SkillID   int NOT NULL,
  VacancyID int NOT NULL,
  CONSTRAINT pk_VacancySkill PRIMARY KEY (SkillID,VacancyID),
  CONSTRAINT fk_VacancySkill_SkillID FOREIGN KEY (SkillID)
  REFERENCES Skill (ID) ON DELETE CASCADE,
  CONSTRAINT fk_VacancySkill_VacancyID FOREIGN KEY (VacancyID)
  REFERENCES Vacancy (ID) ON DELETE CASCADE
);

CREATE TABLE Applicant (
  StudentID   int      NOT NULL,
  VacancyID   int      NOT NULL,
  DateCreated datetime NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT pk_Applicant PRIMARY KEY (StudentID,VacancyID),
  CONSTRAINT fk_Applicant_StudentID FOREIGN KEY (StudentID)
  REFERENCES Student (ID) ON DELETE CASCADE,
  CONSTRAINT fk_Applicant_VacancyID FOREIGN KEY (VacancyID)
  REFERENCES Vacancy (ID) ON DELETE CASCADE
);

/**
 * INSERT DATA
 */

INSERT INTO Location (Name) VALUES ('Mars');
INSERT INTO Location (Name) VALUES ('Atlantis');
INSERT INTO Location (Name) VALUES ('Lynmore');
INSERT INTO Location (Name) VALUES ('Auckland');
INSERT INTO Location (Name) VALUES ('Rotorua');
INSERT INTO Location (Name) VALUES ('Titan');
INSERT INTO Location (Name) VALUES ('Jotunheim');
INSERT INTO Location (Name) VALUES ('Germany');
INSERT INTO Location (Name) VALUES ('Connecticut');
INSERT INTO Location (Name) VALUES ('Australia');

INSERT INTO Employer (Name, LocationID) VALUES ('Doctor Doom',1);
INSERT INTO Employer (Name, LocationID) VALUES ('Dark Phoenix',2);
INSERT INTO Employer (Name, LocationID) VALUES ('Thanos',3);
INSERT INTO Employer (Name, LocationID) VALUES ('Loki',4);
INSERT INTO Employer (Name, LocationID) VALUES ('Magneto',5);
INSERT INTO Employer (Name, LocationID) VALUES ('Norman Osborne',6);
INSERT INTO Employer (Name, LocationID) VALUES ('Red Skull',7);
INSERT INTO Employer (Name, LocationID) VALUES ('Galactus',8);
INSERT INTO Employer (Name, LocationID) VALUES ('Ultron',9);
INSERT INTO Employer (Name, LocationID) VALUES ('Doctor Octopus',10);

INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type) VALUES ('Reporter',1,1,'2013-10-22 18:45:00',1);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type) VALUES ('Photographer',2,2,'2013-10-22 18:46:00',0);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type) VALUES ('Police Officer',3,3,'2013-10-22 18:57:41',1);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type) VALUES ('Forensic Scientist',4,4,'2013-10-22 19:37:49',1);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type) VALUES ('Detective',5,5,'2013-10-22 19:38:03',5);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type) VALUES ('Attorney',6,6,'2013-10-22 19:38:12',6);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type) VALUES ('Scientist',7,7,'2013-10-22 19:38:42',7);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type) VALUES ('Fire Fighter',8,8,'2013-10-22 19:39:32',8);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type) VALUES ('Lawyer',9,9,'2013-10-22 19:41:42',9);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type) VALUES ('Teacher',10,10,'2013-10-22 19:41:53',10);

INSERT INTO Student (FirstName, LastName, Address, Phone) VALUES ('Clark','Kent','Metropolis','12345');
INSERT INTO Student (FirstName, LastName, Address, Phone) VALUES ('Hal','Jordon','Coast city','51232');
INSERT INTO Student (FirstName, LastName, Address, Phone) VALUES ('Peter','Parker','New York','12354');
INSERT INTO Student (FirstName, LastName, Address, Phone) VALUES ('Wally','West','Keystone City','23422');
INSERT INTO Student (FirstName, LastName, Address, Phone) VALUES ('Bruce','Wayne','Gotham City','42352');
INSERT INTO Student (FirstName, LastName, Address, Phone) VALUES ('Bruce','Banner','New York','52313');
INSERT INTO Student (FirstName, LastName, Address, Phone) VALUES ('James','Howlett','Canada','12314');
INSERT INTO Student (FirstName, LastName, Address, Phone) VALUES ('Steven','Rogers','New York','12312');
INSERT INTO Student (FirstName, LastName, Address, Phone) VALUES ('Tony','Stark','New York','41231');
INSERT INTO Student (FirstName, LastName, Address, Phone) VALUES ('Wade','Wilson','Canada','12511');

INSERT INTO StudentEmployed (FirstName, LastName, Address, Phone) VALUES ('Clark','Kent','Metropolis','12345');
INSERT INTO StudentEmployed (FirstName, LastName, Address, Phone) VALUES ('Hal','Jordon','Coast city','51232');
INSERT INTO StudentEmployed (FirstName, LastName, Address, Phone) VALUES ('Peter','Parker','New York','12354');
INSERT INTO StudentEmployed (FirstName, LastName, Address, Phone) VALUES ('Wally','West','Keystone City','23422');
INSERT INTO StudentEmployed (FirstName, LastName, Address, Phone) VALUES ('Bruce','Wayne','Gotham City','42352');
INSERT INTO StudentEmployed (FirstName, LastName, Address, Phone) VALUES ('Bruce','Banner','New York','52313');
INSERT INTO StudentEmployed (FirstName, LastName, Address, Phone) VALUES ('James','Howlett','Canada','12314');
INSERT INTO StudentEmployed (FirstName, LastName, Address, Phone) VALUES ('Steven','Rogers','New York','12312');
INSERT INTO StudentEmployed (FirstName, LastName, Address, Phone) VALUES ('Tony','Stark','New York','41231');
INSERT INTO StudentEmployed (FirstName, LastName, Address, Phone) VALUES ('Wade','Wilson','Canada','12511');

INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type, StudentID) VALUES ('Reporter',1,1,'2013-10-22 18:45:00',1, 1);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type, StudentID) VALUES ('Photographer',2,2,'2013-10-22 18:46:00',0, 2);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type, StudentID) VALUES ('Police Officer',3,3,'2013-10-22 18:57:41',1, 3);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type, StudentID) VALUES ('Forensic Scientist',4,4,'2013-10-22 19:37:49',1, 4);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type, StudentID) VALUES ('Detective',5,5,'2013-10-22 19:38:03',5, 5);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type, StudentID) VALUES ('Attorney',6,6,'2013-10-22 19:38:12',6, 6);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type, StudentID) VALUES ('Scientist',7,7,'2013-10-22 19:38:42',7, 7);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type, StudentID) VALUES ('Fire Fighter',8,8,'2013-10-22 19:39:32',8, 8);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type, StudentID) VALUES ('Lawyer',9,9,'2013-10-22 19:41:42',9, 9);
INSERT INTO Vacancy (Description, EmployerID, LocationID, DateCreated, Type, StudentID) VALUES ('Teacher',10,10,'2013-10-22 19:41:53',10, 10);

INSERT INTO Skill (Name) VALUES ('Superhuman Strength');
INSERT INTO Skill (Name) VALUES ('Invulnerability');
INSERT INTO Skill (Name) VALUES ('Self Healing');
INSERT INTO Skill (Name) VALUES ('Flight');
INSERT INTO Skill (Name) VALUES ('Superhuman Speed');
INSERT INTO Skill (Name) VALUES ('X-Ray Vision');
INSERT INTO Skill (Name) VALUES ('Quantum Tunneling');
INSERT INTO Skill (Name) VALUES ('Wall Crawling');
INSERT INTO Skill (Name) VALUES ('Spider Sense');
INSERT INTO Skill (Name) VALUES ('Power Ring');

INSERT INTO StudentSkill (SkillID, StudentID) VALUES (1,1);
INSERT INTO StudentSkill (SkillID, StudentID) VALUES (2,2);
INSERT INTO StudentSkill (SkillID, StudentID) VALUES (3,3);
INSERT INTO StudentSkill (SkillID, StudentID) VALUES (4,4);
INSERT INTO StudentSkill (SkillID, StudentID) VALUES (5,5);
INSERT INTO StudentSkill (SkillID, StudentID) VALUES (6,6);
INSERT INTO StudentSkill (SkillID, StudentID) VALUES (7,7);
INSERT INTO StudentSkill (SkillID, StudentID) VALUES (8,8);
INSERT INTO StudentSkill (SkillID, StudentID) VALUES (9,9);
INSERT INTO StudentSkill (SkillID, StudentID) VALUES (10,10);

INSERT INTO VacancySkill (SkillID, VacancyID) VALUES (1,1);
INSERT INTO VacancySkill (SkillID, VacancyID) VALUES (2,2);
INSERT INTO VacancySkill (SkillID, VacancyID) VALUES (3,3);
INSERT INTO VacancySkill (SkillID, VacancyID) VALUES (4,4);
INSERT INTO VacancySkill (SkillID, VacancyID) VALUES (5,5);
INSERT INTO VacancySkill (SkillID, VacancyID) VALUES (6,6);
INSERT INTO VacancySkill (SkillID, VacancyID) VALUES (7,7);
INSERT INTO VacancySkill (SkillID, VacancyID) VALUES (8,8);
INSERT INTO VacancySkill (SkillID, VacancyID) VALUES (9,9);
INSERT INTO VacancySkill (SkillID, VacancyID) VALUES (10,10);

INSERT INTO Applicant (StudentID, VacancyID, DateCreated) VALUES (1,1,'2013-10-22 19:42:18');
INSERT INTO Applicant (StudentID, VacancyID, DateCreated) VALUES (2,2,'2013-10-22 19:42:20');
INSERT INTO Applicant (StudentID, VacancyID, DateCreated) VALUES (3,3,'2013-10-22 19:42:23');
INSERT INTO Applicant (StudentID, VacancyID, DateCreated) VALUES (4,4,'2013-10-22 19:42:25');
INSERT INTO Applicant (StudentID, VacancyID, DateCreated) VALUES (5,5,'2013-10-22 19:42:29');
INSERT INTO Applicant (StudentID, VacancyID, DateCreated) VALUES (6,6,'2013-10-22 19:42:33');
INSERT INTO Applicant (StudentID, VacancyID, DateCreated) VALUES (7,7,'2013-10-22 19:42:35');
INSERT INTO Applicant (StudentID, VacancyID, DateCreated) VALUES (8,8,'2013-10-22 19:42:39');
INSERT INTO Applicant (StudentID, VacancyID, DateCreated) VALUES (9,9,'2013-10-22 19:42:41');
INSERT INTO Applicant (StudentID, VacancyID, DateCreated) VALUES (10,10,'2013-10-22 19:42:43');

