CREATE DATABASE Legajo
GO
USE Legajo
GO
CREATE TABLE Datos (
    IdLegajo int identity(1,1) ,
    Con varchar(50)  ,
    ApreCali varchar(50)  ,
    SerPre varchar(50)  ,
    IntProCapPerf varchar(50)  ,
    RefPer varchar(50)  ,
    BonPer varchar(50)  ,
    ComInfTper varchar(50)  ,
    BonFam varchar(50)  ,
    Estado varchar(50)  ,
    Empleado_idEmpl int  ,
    CONSTRAINT Datos_pk PRIMARY KEY  (IdLegajo)
);

-- Table: DetalleDialecto
CREATE TABLE DetalleDialecto (
    idDetDial int identity(1,1) ,
    Lee varchar(50)  ,
    Habla varchar(50)  ,
    Escribe varchar(50)  ,
    Estado varchar(50)  ,
    Dialecto_IdDial int  ,
    Empleado_idEmpl int  ,
    CONSTRAINT DetalleDialecto_pk PRIMARY KEY  (idDetDial)
);

-- Table: Dialecto
CREATE TABLE Dialecto (
    IdDial int identity(1,1) ,
    NomDial varchar(50)  ,
    CONSTRAINT Dialecto_pk PRIMARY KEY  (IdDial)
);

-- Table: Emergencia
CREATE TABLE Emergencia (
    IdEmerg int identity(1,1) ,
    NomEmer varchar(50)  ,
    ApeEmer varchar(50)  ,
    ParenEmer varchar(50)  ,
    TelEmer char(7)  ,
    CelularEmer char(50)  ,
    EstadoEmer varchar(50)  ,
    Empleado_idEmpl int  ,
    CONSTRAINT Emergencia_pk PRIMARY KEY  (IdEmerg)
);

-- Table: Empleado
CREATE TABLE Empleado (
    idEmpl int identity(1,1) ,
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
    Est varchar(50)  ,
    Origen varchar(50)  ,
    Ubigeo_CodUbi int  ,
    Dialecto_IdDial int  ,
    Datos_IdLegajo int  ,
    EstudioBasicos_IdEstuBasi int  ,
    EstudiosSuperior_IdEstusuper int  ,
    DetalleDialecto_idDetDial int  ,
    Familiares_IdFami int  ,
    Emergencia_IdEmerg int  ,
    CONSTRAINT Empleado_pk PRIMARY KEY  (idEmpl)
);

-- Table: EstudioBasicos
CREATE TABLE EstudioBasicos (
    IdEstuBasi int identity(1,1) ,
    EducBasi varchar(50)  ,
    CulmiBasi varchar(50)  ,
    CentrEstuBasi varchar(50)  ,
    DesdBasi date  ,
    HasBasi date  ,
    EstadoBasi varchar(50)  ,
    Empleado_idEmpl int  ,
    CONSTRAINT EstudioBasicos_pk PRIMARY KEY  (IdEstuBasi)
);

-- Table: EstudiosSuperior
CREATE TABLE EstudiosSuperior (
    IdEstusuper int identity(1,1) ,
    EduSuper varchar(50)  ,
    EspeSuper varchar(50)  ,
    CentrEstuSuper varchar(50)  ,
    DesdSuper date  ,
    HastSuper date  ,
    CulmiSuper varchar(50)  ,
    GradAcadObte varchar(50)  ,
    EstadoSuper varchar(50)  ,
    Empleado_idEmpl int  ,
    CONSTRAINT EstudiosSuperior_pk PRIMARY KEY  (IdEstusuper)
);

-- Table: Familiares
CREATE TABLE Familiares (
    IdFami int identity(1,1) ,
    NomFami varchar(100)  ,
    ApelFami varchar(100)  ,
    ParFami varchar(50)  ,
    OcuFami varchar(50)  ,
    FecNacFami date  ,
    TelfFami varchar(7)  ,
    CelularFami varchar(9)  ,
    EstCivFami varchar(50)  ,
    viveFami varchar(50)  ,
    EstadoFami varchar(50)  ,
    Empleado_idEmpl int  ,
    CONSTRAINT Familiares_pk PRIMARY KEY  (IdFami)
);

-- Table: Ubigeo
CREATE TABLE Ubigeo (
    CodUbi int identity(1,1) ,
    Dep varchar(100)  ,
    Pro varchar(100)  ,
    Dis varchar(100)  ,
    CONSTRAINT Ubigeo_pk PRIMARY KEY  (CodUbi)
);

-- Table: Usuario
CREATE TABLE Usuario (
    IdUsuario int identity(1,1) ,
    Usuario varchar(100)  ,
    Pass varchar(100)  ,
    Nombre varchar(100)  ,
    Nivel varchar(10)  ,
    Estado varchar(10),
    CONSTRAINT Usuario_pk PRIMARY KEY  (IdUsuario)
);

-- foreign keys
-- Reference: Contactos_Empleado (table: Familiares)
ALTER TABLE Familiares ADD CONSTRAINT Contactos_Empleado
    FOREIGN KEY (Empleado_idEmpl)
    REFERENCES Empleado (idEmpl);

-- Reference: Datos_Empleado (table: Datos)
ALTER TABLE Datos ADD CONSTRAINT Datos_Empleado
    FOREIGN KEY (Empleado_idEmpl)
    REFERENCES Empleado (idEmpl);

-- Reference: DetalleDialecto_Dialecto (table: DetalleDialecto)
ALTER TABLE DetalleDialecto ADD CONSTRAINT DetalleDialecto_Dialecto
    FOREIGN KEY (Dialecto_IdDial)
    REFERENCES Dialecto (IdDial);

-- Reference: DetalleDialecto_Empleado (table: DetalleDialecto)
ALTER TABLE DetalleDialecto ADD CONSTRAINT DetalleDialecto_Empleado
    FOREIGN KEY (Empleado_idEmpl)
    REFERENCES Empleado (idEmpl);

-- Reference: Emergencia_Empleado (table: Emergencia)
ALTER TABLE Emergencia ADD CONSTRAINT Emergencia_Empleado
    FOREIGN KEY (Empleado_idEmpl)
    REFERENCES Empleado (idEmpl);

-- Reference: Empleado_Datos (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Datos
    FOREIGN KEY (Datos_IdLegajo)
    REFERENCES Datos (IdLegajo);

-- Reference: Empleado_DetalleDialecto (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_DetalleDialecto
    FOREIGN KEY (DetalleDialecto_idDetDial)
    REFERENCES DetalleDialecto (idDetDial);

-- Reference: Empleado_Dialecto (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Dialecto
    FOREIGN KEY (Dialecto_IdDial)
    REFERENCES Dialecto (IdDial);

-- Reference: Empleado_Emergencia (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Emergencia
    FOREIGN KEY (Emergencia_IdEmerg)
    REFERENCES Emergencia (IdEmerg);

-- Reference: Empleado_EstudioBasicos (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_EstudioBasicos
    FOREIGN KEY (EstudioBasicos_IdEstuBasi)
    REFERENCES EstudioBasicos (IdEstuBasi);

-- Reference: Empleado_EstudiosSuperior (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_EstudiosSuperior
    FOREIGN KEY (EstudiosSuperior_IdEstusuper)
    REFERENCES EstudiosSuperior (IdEstusuper);

-- Reference: Empleado_Familiares (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Familiares
    FOREIGN KEY (Familiares_IdFami)
    REFERENCES Familiares (IdFami);

-- Reference: Empleado_Ubigeo (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Ubigeo
    FOREIGN KEY (Ubigeo_CodUbi)
    REFERENCES Ubigeo (CodUbi);

-- Reference: EstudioBasicos_Empleado (table: EstudioBasicos)
ALTER TABLE EstudioBasicos ADD CONSTRAINT EstudioBasicos_Empleado
    FOREIGN KEY (Empleado_idEmpl)
    REFERENCES Empleado (idEmpl);

-- Reference: EstudioSuperior_Empleado (table: EstudiosSuperior)
ALTER TABLE EstudiosSuperior ADD CONSTRAINT EstudioSuperior_Empleado
    FOREIGN KEY (Empleado_idEmpl)
    REFERENCES Empleado (idEmpl);

-- End of file.

