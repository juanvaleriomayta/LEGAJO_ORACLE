
drop database Legajo

create database Legajo
use Legajo

-- tables
-- Table: ContactoEmpl
CREATE TABLE ContactoEmpl (
    CodConEmp int  identity(1,1),
    Nom varchar(100)  ,
    Ape varchar(100)  ,
    Telf char(7)  ,
    Cel nchar(9)  ,
    Empleado_idEmpl int  ,
    CONSTRAINT ContactoEmpl_pk PRIMARY KEY  (CodConEmp)
);

-- Table: DatGenEmp
CREATE TABLE DatGenEmp (
    IdLegajo int  identity(1,1),
    Con varchar(50)  ,
    ApreCali varchar(50)  ,
    SerPre varchar(50)  ,
    IntProCapPerf varchar(50)  ,
    RefPer varchar(50)  ,
    BonPer varchar(50)  ,
    ComInfTper int  ,
    BonFam int  ,
    CONSTRAINT DatGenEmp_pk PRIMARY KEY  (IdLegajo)
);

-- Table: Empleado
CREATE TABLE Empleado (
    idEmpl int  identity(1,1),
    DNI char(8) not null ,
    Nom varchar(50)  ,
    Apel varchar(50)  ,
    Telf char(7)  ,
    GrupSang varchar(100)  ,
    RUC char(11)  ,
    FecNac date  ,
    Email varchar(50)  ,
    Cel varchar(9)  ,
    EstCiv varchar(45)  ,
    ConLab varchar(100)  ,
    FecIng date  ,
    Desd date  ,
    Has date  ,
    Dialec varchar(50)  ,
    Lee varchar(50)  ,
    Habl varchar(50)  ,
    Escr varchar(50)  ,
    Est varchar(50)  ,
    Ubigeo_CodUbi int  ,
    UbiDir_CodUbi int  ,
    EstuGenEmpl_IdEstuGenEmpl char(10)  ,
    DatGenEmp_IdLegajo int  ,
    CONSTRAINT Empleado_pk PRIMARY KEY  (idEmpl)
);

-- Table: EstuGenEmpl
CREATE TABLE EstuGenEmpl (
    IdEstuGenEmpl char(10),
    TipDeEst varchar(50)  ,
    Desd varchar(50)  ,
    Has varchar(50)  ,
    CONSTRAINT EstuGenEmpl_pk PRIMARY KEY  (IdEstuGenEmpl)
);

-- Table: FamiliaresEmp
CREATE TABLE FamiliaresEmp (
    CodFamEmp int identity(1,1),
    Nom varchar(100)  ,
    Ape varchar(100)  ,
    FecNac date  ,
    Ocu varchar(100)  ,
    EstCiv varchar(50)  ,
    Viv varchar(100)  ,
    Empleado_idEmpl int  ,
    CONSTRAINT FamiliaresEmp_pk PRIMARY KEY  (CodFamEmp)
);

-- Table: UbiDir
CREATE TABLE UbiDir (
    CodUbiDir int identity(1,1),
    Dep varchar(100)  ,
    Pro varchar(100)  ,
    Dis varchar(100)  ,
    CONSTRAINT UbiDir_pk PRIMARY KEY  (CodUbiDir)
);

-- Table: UbiLugNac
CREATE TABLE UbiLugNac (
    CodUbi int identity(1,1),
    Dep varchar(100)  ,
    Pro varchar(100)  ,
    Dis varchar(100)  ,
    CONSTRAINT UbiLugNac_pk PRIMARY KEY  (CodUbi)
);

-- foreign keys
-- Reference: ContactoEmpl_Empleado (table: ContactoEmpl)
ALTER TABLE ContactoEmpl ADD CONSTRAINT ContactoEmpl_Empleado
    FOREIGN KEY (Empleado_idEmpl)
    REFERENCES Empleado (idEmpl);

-- Reference: Empleado_DatGenEmp (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_DatGenEmp
    FOREIGN KEY (DatGenEmp_IdLegajo)
    REFERENCES DatGenEmp (IdLegajo);

-- Reference: Empleado_EstuGenEmpl (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_EstuGenEmpl
    FOREIGN KEY (EstuGenEmpl_IdEstuGenEmpl)
    REFERENCES EstuGenEmpl (IdEstuGenEmpl);

-- Reference: Empleado_UbiDir (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_UbiDir
    FOREIGN KEY (UbiDir_CodUbi)
    REFERENCES UbiDir (CodUbiDir);

-- Reference: Empleado_Ubigeo (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Ubigeo
    FOREIGN KEY (Ubigeo_CodUbi)
    REFERENCES UbiLugNac (CodUbi);

-- Reference: FamiliaresEmp_Empleado (table: FamiliaresEmp)
ALTER TABLE FamiliaresEmp ADD CONSTRAINT FamiliaresEmp_Empleado
    FOREIGN KEY (Empleado_idEmpl)
    REFERENCES Empleado (idEmpl);

-- End of file.

