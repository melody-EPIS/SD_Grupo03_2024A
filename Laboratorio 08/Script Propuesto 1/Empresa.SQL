-- Table Departamento

CREATE TABLE `Departamento`
(
  `DepIde` INT NOT NULL,
  `DepNom` VARCHAR(60),
  `DepTel` VARCHAR(20),
  `DepFax` VARCHAR(20),
  PRIMARY KEY (`DepIde`)
);

-- Table Proyecto

CREATE TABLE `Proyecto`
(
  `ProIde` INT NOT NULL,
  `ProNom` VARCHAR(60),
  `ProFecIni` DATE,
  `ProFecFin` DATE,
  `ProDep` INT,
  PRIMARY KEY (`ProIde`),
  FOREIGN KEY (`ProDep`) REFERENCES `Departamento` (`DepIde`) ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- Table Ingeniero

CREATE TABLE `Ingeniero`
(
  `IngIde` INT NOT NULL,
  `IngEsp` VARCHAR(100),
  `IngCar` VARCHAR(100),
  `IngPro` INT,
  PRIMARY KEY (`IngIde`),
  FOREIGN KEY (`IngPro`) REFERENCES `Proyecto` (`ProIde`) ON DELETE RESTRICT ON UPDATE RESTRICT
);
