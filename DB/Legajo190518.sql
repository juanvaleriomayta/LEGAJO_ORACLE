
-- tables
-- Table: Contactos
CREATE TABLE Contactos (
    CodConEmp int identity (1,1),
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
    CONSTRAINT Contactos_pk PRIMARY KEY  (CodConEmp)
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
CREATE TABLE DetDial (
    idDetDial int identity (1,1) ,
    Lee varchar(50)  ,
    Hab varchar(50)  ,
    Escri varchar(50)  ,
    Empleado_idEmpl int  ,
    CONSTRAINT DetDial_pk PRIMARY KEY  (idDetDial)
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
    Contactos_CodConEmp int  ,
    Datos_IdLegajo int  ,
    Estudios_IdEstuGenEmpl int  ,
    Ubigeo_CodUbi int  ,
    CONSTRAINT Empleado_pk PRIMARY KEY  (idEmpl)
);

-- Table: Estudios
CREATE TABLE Estudios (
    IdEstuGenEmpl int identity (1,1),
    DatSuper varchar(50)  ,
    tipGraAca varchar(50)  ,
    Desd varchar(50)  ,
    Has varchar(50)  ,
    Carre varchar(50)  ,
    CONSTRAINT Estudios_pk PRIMARY KEY  (IdEstuGenEmpl)
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
ALTER TABLE Dialecto ADD CONSTRAINT Dialecto_DetDial
    FOREIGN KEY (DetDial_idDetDial)
    REFERENCES DetDial (idDetDial);

-- Reference: Empleado_Contactos (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Contactos
    FOREIGN KEY (Contactos_CodConEmp)
    REFERENCES Contactos (CodConEmp);

-- Reference: Empleado_Datos (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Datos
    FOREIGN KEY (Datos_IdLegajo)
    REFERENCES Datos (IdLegajo);

-- Reference: Empleado_Estudios (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Estudios
    FOREIGN KEY (Estudios_IdEstuGenEmpl)
    REFERENCES Estudios (IdEstuGenEmpl);

-- Reference: Empleado_Ubigeo (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Ubigeo
    FOREIGN KEY (Ubigeo_CodUbi)
    REFERENCES Ubigeo (CodUbi);

-- End of file.

