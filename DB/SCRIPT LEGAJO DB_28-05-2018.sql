-- tables
-- Table: Contactos
CREATE TABLE Familiares(
    CodFami int identity (1,1),
    TipDeFami varchar(50)  ,
    Nom varchar(100)  ,
    Ape varchar(100)  ,
    Par varchar(50)  ,
    Ocu varchar(50)  ,
    FecNac date  ,
    Tel varchar(7)  ,
    Cel varchar(9)  ,
    EstCiv varchar(50)  ,
    vive varchar(50)  ,
    CONSTRAINT Familiares_pk PRIMARY KEY  (CodFami)
);

-- Tabla: Contactos
CREATE TABLE Emergencia(
	IdEmerg int identity (1,1),
	Nom varchar(50),
	Ape varchar(50),
	Paren varchar(50),
	Tel varchar(50),
	Cel varchar(50),
	CONSTRAINT Emergencia_PK PRIMARY KEY (IdEmerg)
	);

-- Table: Datos
CREATE TABLE Datos (
    IdLegajo int identity (1,1),
    Con varchar(50)  ,
    ApreCali varchar(50)  ,
    SerPre varchar(50)  ,
    IntProCapPerf varchar(50)  ,
    RefPer varchar(50)  ,
    BonPer varchar(50)  ,
    ComInfTper varchar(50) ,
    BonFam varchar(50) ,
    CONSTRAINT Datos_pk PRIMARY KEY  (IdLegajo)
);

-- Table: DetDial
CREATE TABLE DetalleDialecto (
    idDetDial int identity (1,1) ,
    Lee varchar(50)  ,
    Hab varchar(50)  ,
    Escri varchar(50)  ,
    Empleado_idEmpl int  ,
    CONSTRAINT DetelleDialecto_pk PRIMARY KEY  (idDetDial)
);

-- Table: Dialecto
CREATE TABLE Dialecto (
    IdDial int identity (1,1),
    NomDial varchar(50)  ,
    DetDial_idDetDial int  ,
    CONSTRAINT Dialecto_pk PRIMARY KEY  (IdDial)
);

-- Table: Empleado
CREATE TABLE Empleado (
    idEmpl int identity (1,1),
    DNI char(8)  ,
    Nom varchar(50)  ,
    ApelPate varchar(50)  ,
    ApelMate varchar(50)  ,
    RUC char(11)  ,
    Email varchar(50)  ,
    Telf char(7)  ,
    Cel varchar(9)  ,
    FecNac date  ,
    GrupSang varchar(100)  ,
    EstCiv varchar(45)  ,
    ConLab varchar(100)  ,
    CarnAseg char(50)  ,
    Refe varchar(100)  ,
    Leye varchar(20)  ,
    FecIng date  ,
    FecNom date  ,
    DatCony varchar(50)  ,
    UbigActu varchar(50)  ,
    UbigOrig varchar(100)  ,
    Est varchar(50)  ,
    Familiares_CodFami int  ,
    Datos_IdLegajo int  ,
    EstudiosBasicos_IdEstuBasi int  ,
    Ubigeo_CodUbi int  ,
	EstudiosSuperiores_IdEstusuper int,
	Emergencia_IdEmerg int,

    CONSTRAINT Empleado_pk PRIMARY KEY  (idEmpl)
);

-- Table: Estudios Basicos
CREATE TABLE EstudiosBasicos (
    IdEstuBasi int identity (1,1),
    Educ varchar(50)  ,
    Culmi varchar(50)  ,
	CentrEstu varchar(50),
    Desd date  ,
    Has date  ,
    CONSTRAINT EstudiosBasicos_pk PRIMARY KEY  (IdEstuBasi)
);

--Tabla Estudios Superiores
CREATE TABLE EstudiosSuperiores(
IdEstusuper int identity (1,1),
EduSuper varchar(50),
Espe varchar(50),
CentrEstu varchar(50),
Desd date,
Hast date,
Culmi varchar(50),
GradAcadObte varchar(50),
CONSTRAINT EstudiosSuperiores_PK PRIMARY KEY(IdEstusuper)
);

-- Table: Ubigeo
CREATE TABLE Ubigeo (
    CodUbi int identity (1,1),
    Dep varchar(100)  ,
    Pro varchar(100)  ,
    Dis varchar(100)  ,
    CONSTRAINT Ubigeo_pk PRIMARY KEY  (CodUbi)
);

-- foreign keys
-- Reference: DetDial_Empleado (table: DetDial)
ALTER TABLE DetDial ADD CONSTRAINT DetDial_Empleado
    FOREIGN KEY (Empleado_idEmpl)
    REFERENCES Empleado (idEmpl);

-- Reference: Dialecto_DetDial (table: Dialecto)
ALTER TABLE Dialecto ADD CONSTRAINT Dialecto_DetalleDialecto
    FOREIGN KEY (DetDial_idDetDial)
    REFERENCES DetDial (idDetDial);

-- Reference: Empleado_Familiares (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Familiares
    FOREIGN KEY (Familiares_CodFami)
    REFERENCES Familiares (CodFami);

-- Reference: Empleado_Emergencia (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Emergencia
    FOREIGN KEY (Emergencia_IdEmerg)
    REFERENCES Emergencia (IdEmerg);

-- Reference: Empleado_Datos (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Datos
    FOREIGN KEY (Datos_IdLegajo)
    REFERENCES Datos (IdLegajo);

-- Reference: Empleado_EstudiosBasicos (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_EstudiosBasicos
    FOREIGN KEY (EstudiosBasicos_IdEstuBasi)
    REFERENCES EstudiosBasicos (IdEstuBasi);

-- Reference: Empleado_EstudiosSuperiores (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_EstudiosSuperiores
	FOREIGN KEY (EstudiosSuperiores_IdEstusuper)
	REFERENCES EstudiosSuperioreS (IdEstusuper);

-- Reference: Empleado_Ubigeo (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Ubigeo
    FOREIGN KEY (Ubigeo_CodUbi)
    REFERENCES Ubigeo (CodUbi);

-- End of file.
