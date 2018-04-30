create database SistLegajo

use SistLegajo

CREATE TABLE ContactoEmpl (
    CodConEmp int identity(1,1),
    Nom varchar(100),
    Ape varchar(100),
    Telf char(7),
    Cel nchar(9),
    Empleado_DNI char(8),
    CONSTRAINT ContactoEmpl_pk PRIMARY KEY  (CodConEmp)
);

-- Table: DatosEst
CREATE TABLE DatosEst (
    CodDatEst int identity(1,1),
    Nivel varchar(50),
    EstEst varchar(150),
    Col varchar(100),
    Desd date,
    Has date,
    Empleado_DNI char(8),
    CONSTRAINT DatosEst_pk PRIMARY KEY  (CodDatEst)
);

-- Table: Empleado
CREATE TABLE Empleado (
	idEmpl int identity(1,1),
    DNI char(8),
    Nom varchar(50),
    Apel varchar(50),
    Telf char(7),
    GrupSang varchar(100),
    RUC char(11),
    FecNac date,
    Email varchar(50),
    LugNac varchar(150),
    Dir varchar(200),
    Cel varchar(9),
    EstCiv varchar(45),
    ConLab varchar(100),
    FecIng date,
    Desd date,
    Has date,
    Dialec varchar(50),
    Lee varchar(50),
    Habl varchar(50),
    Escr varchar(50),
    Est varchar(50),
    EstadoCiv_Cod int,
    Ubigeo_CodUbi int,
    CONSTRAINT Empleado_pk PRIMARY KEY  (DNI)
);

-- Table: EstadoCiv
CREATE TABLE EstadoCiv (
    Cod int identity(1,1),
    NomEstCiv varchar(50),
    CONSTRAINT EstadoCiv_pk PRIMARY KEY  (Cod)
);

-- Table: EstudioSup
CREATE TABLE EstudioSup (
    CodEstSup int identity(1,1),
    TipEst varchar(100),
    Esp varchar(100),
    CenEst varchar(100),
    Desd date,
    Has date,
    Est varchar(100),
    Grad varchar(100),
    Empleado_DNI char(8),
    CONSTRAINT EstudioSup_pk PRIMARY KEY  (CodEstSup)
);

-- Table: FamiliaresEmp
CREATE TABLE FamiliaresEmp (
    CodFamEmp int identity(1,1),
    Nom varchar(100),
    Ape varchar(100),
    FecNac date,
    Ocu varchar(100),
    EstCiv varchar(50),
    Viv varchar(100),
    Empleado_DNI char(8),
    CONSTRAINT FamiliaresEmp_pk PRIMARY KEY  (CodFamEmp)
);

-- Table: Ubigeo
CREATE TABLE Ubigeo (
    CodUbi int identity(1,1),
    Dep varchar(100),
    Pro varchar(100),
    Dis varchar(100),
    CONSTRAINT Ubigeo_pk PRIMARY KEY  (CodUbi)
);

-- foreign keys
-- Reference: ContactoEmpl_Empleado (table: ContactoEmpl)
ALTER TABLE ContactoEmpl ADD CONSTRAINT ContactoEmpl_Empleado
    FOREIGN KEY (Empleado_DNI)
    REFERENCES Empleado (DNI);

-- Reference: DatosEst_Empleado (table: DatosEst)
ALTER TABLE DatosEst ADD CONSTRAINT DatosEst_Empleado
    FOREIGN KEY (Empleado_DNI)
    REFERENCES Empleado (DNI);

-- Reference: Empleado_EstadoCiv (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_EstadoCiv
    FOREIGN KEY (EstadoCiv_Cod)
    REFERENCES EstadoCiv (Cod);

-- Reference: Empleado_Ubigeo (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Ubigeo
    FOREIGN KEY (Ubigeo_CodUbi)
    REFERENCES Ubigeo (CodUbi);

-- Reference: EstudioSup_Empleado (table: EstudioSup)
ALTER TABLE EstudioSup ADD CONSTRAINT EstudioSup_Empleado
    FOREIGN KEY (Empleado_DNI)
    REFERENCES Empleado (DNI);

-- Reference: FamiliaresEmp_Empleado (table: FamiliaresEmp)
ALTER TABLE FamiliaresEmp ADD CONSTRAINT FamiliaresEmp_Empleado
    FOREIGN KEY (Empleado_DNI)
    REFERENCES Empleado (DNI);

-- End of file.

