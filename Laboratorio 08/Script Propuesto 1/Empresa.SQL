/*
Created: 18/06/2024
Modified: 18/06/2024
Model: MySQL 5.7
Database: MySQL 5.7
*/


-- Create tables section -------------------------------------------------

-- Table Departamento

CREATE TABLE `Departamento`
(
  `DepIde` Int NOT NULL,
  `DepNom` Varchar(60),
  `DepTel` Varchar(20),
  `DepFax` Varchar(20)
)
;

ALTER TABLE `Departamento` ADD PRIMARY KEY (`DepIde`)
;

ALTER TABLE `Departamento` ADD UNIQUE `DepIde` (`DepIde`)
;

-- Table Proyecto

CREATE TABLE `Proyecto`
(
  `ProIde` Int NOT NULL,
  `ProNom` Varchar(60),
  `ProFecIni` Date,
  `ProFecFin` Date,
  `ProDep` Int
)
;

CREATE INDEX `IX_Relationship2` ON `Proyecto` (`ProDep`)
;

ALTER TABLE `Proyecto` ADD PRIMARY KEY (`ProIde`)
;

ALTER TABLE `Proyecto` ADD UNIQUE `ProIde` (`ProIde`)
;

-- Table Ingeniero

CREATE TABLE `Ingeniero`
(
  `IngIde` Int NOT NULL,
  `IngEsp` Varchar(100),
  `IngCar` Varchar(100),
  `IngPro` Int
)
;

CREATE INDEX `IX_Relationship3` ON `Ingeniero` (`IngPro`)
;

ALTER TABLE `Ingeniero` ADD PRIMARY KEY (`IngIde`)
;

ALTER TABLE `Ingeniero` ADD UNIQUE `IngIde` (`IngIde`)
;

-- Create foreign keys (relationships) section ------------------------------------------------- 


ALTER TABLE `Proyecto` ADD CONSTRAINT `Int1_Departamento_Proyecto` FOREIGN KEY (`ProDep`) REFERENCES `Departamento` (`DepIde`) ON DELETE RESTRICT ON UPDATE RESTRICT
;


ALTER TABLE `Ingeniero` ADD CONSTRAINT `Int2_Proyecto_Ingeniero` FOREIGN KEY (`IngPro`) REFERENCES `Proyecto` (`ProIde`) ON DELETE RESTRICT ON UPDATE RESTRICT
;


