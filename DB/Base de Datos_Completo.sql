CREATE DATABASE Legajo
GO
use Legajo
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
    IdEmerg int  identity(1,1),
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
    idEmpl int  identity(1,1),
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
    Usuario_IdUsuario int  ,
    Dialecto_IdDial int  ,
    Datos_IdLegajo int  ,
    EstudioBasicos_IdEstuBasi int  ,
    EstudiosSuperior_IdEstusuper int  ,
    DetalleDialecto_idDetDial int  ,
    Familiares_idFami int  ,
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
    idFami int  identity(1,1),
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
    CONSTRAINT Familiares_pk PRIMARY KEY  (idFami)
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
    Estado varchar(100),
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
    FOREIGN KEY (Familiares_idFami)
    REFERENCES Familiares (idFami);

-- Reference: Empleado_Ubigeo (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Ubigeo
    FOREIGN KEY (Ubigeo_CodUbi)
    REFERENCES Ubigeo (CodUbi);

-- Reference: Empleado_Usuario (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_Usuario
    FOREIGN KEY (Usuario_IdUsuario)
    REFERENCES Usuario (IdUsuario);

-- Reference: EstudioBasicos_Empleado (table: EstudioBasicos)
ALTER TABLE EstudioBasicos ADD CONSTRAINT EstudioBasicos_Empleado
    FOREIGN KEY (Empleado_idEmpl)
    REFERENCES Empleado (idEmpl);

-- Reference: EstudioSuperior_Empleado (table: EstudiosSuperior)
ALTER TABLE EstudiosSuperior ADD CONSTRAINT EstudioSuperior_Empleado
    FOREIGN KEY (Empleado_idEmpl)
    REFERENCES Empleado (idEmpl);
GO
-- End of file.



/*ESTE SP_DATOS_ADD PERMITE INGRESAR LOS NOMBRES DE LAS CAPAS CON SU EMPLEADO CORRESPONDIENTE*/
CREATE PROCEDURE SP_DATOS_ADD
    @CON VARCHAR(50),
    @APRECALI VARCHAR(50),
    @SERPRE VARCHAR(50),
    @INTPROCAPPERF VARCHAR(50),
    @REFPER VARCHAR(50),
    @BONPER VARCHAR(50),
    @COMINFTPER VARCHAR(50),
    @BONFAM VARCHAR(50),
    @EMPLEADO_IDEMPL INT,
    @ESTADO VARCHAR (50)
AS
BEGIN
    INSERT INTO Datos
        (Con,ApreCali,SerPre,IntProCapPerf,RefPer,BonPer,ComInfTper,BonFam,Empleado_idEmpl,Estado)
    VALUES
        (UPPER(@CON), UPPER(@APRECALI), UPPER(@SERPRE), UPPER(@INTPROCAPPERF), UPPER(@REFPER), UPPER(@BONPER), UPPER(@COMINFTPER),
            UPPER(@BONFAM), UPPER(@EMPLEADO_IDEMPL), UPPER(@ESTADO))
END
GO

/*ESTE SP_DATOS_ADD PERMITE MODIFICAR O ACTUALIZAR LOS NOMBRES DE LAS CAPAS CON SU EMPLEADO CORRESPONDIENTE*/
CREATE PROCEDURE SP_DATOS_UPDATE
    @IDLEGAJO INT,
    @CON VARCHAR(50),
    @APRECALI VARCHAR(50),
    @SERPRE VARCHAR(50),
    @INTPROCAPPERF VARCHAR(50),
    @REFPER VARCHAR(50),
    @BONPER VARCHAR(50),
    @COMINFTPER VARCHAR(50),
    @BONFAM VARCHAR(50),
    @ESTADO VARCHAR (50),
    @EMPLEADO_IDEMPL INT
AS
BEGIN
    UPDATE Datos
    SET Con = @CON,
        ApreCali = @APRECALI,
        SerPre = @SERPRE,
        IntProCapPerf = @INTPROCAPPERF,
        RefPer = @REFPER,
        BonPer = @BONPER,
        ComInfTper = @COMINFTPER,
        BonFam = @BONFAM,
        Estado  =@ESTADO,
        Empleado_idEmpl = @EMPLEADO_IDEMPL
        WHERE IdLegajo = @IDLEGAJO
END
GO
/*ESTE SP_DETALLEDIALECTO PERMITE INGRESAR LOS DATOS DETALLEDIALECTO CON SUS RESPECTIVOS EMPLEADOS Y SU DIALECTO O IDIOMA CORRESPONDIENTE*/
CREATE PROCEDURE SP_DETALLEDIALECTO
    @LEE VARCHAR(50),
    @HABLA VARCHAR(50),
    @ESCRIBE VARCHAR(50),
    @ESTADO VARCHAR(50),
    @EMPLEADO_IDEMPL INT,
    @DIALECTO_IDDIAL INT
AS
BEGIN
    INSERT INTO DetalleDialecto
        (Lee,Habla,Escribe,Estado,Empleado_idEmpl,Dialecto_IdDial)
    VALUES
        (UPPER(@LEE), UPPER(@HABLA), UPPER(@ESCRIBE), UPPER(@ESTADO), UPPER(@EMPLEADO_IDEMPL), UPPER(@DIALECTO_IDDIAL))
END
GO
/*ESTE SP_DETALLEDIALECTOUPDATE PERMITE MODIFICAR O ACTUALIZAR LOS DATOS DETALLEDIALECTO CON SUS RESPECTIVOS EMPLEADOS Y SU DIALECTO O IDIOMA CORRESPONDIENTE*/
CREATE PROCEDURE SP_DetalleDialectoUpdate
    @idDetDial int,
    @Lee varchar(50),
    @Habla varchar(50),
    @Escribe varchar(50),
    @Estado VARCHAR(50),
    @Empleado_idEmpl INT,
    @Dialecto_IdDial INT
AS
BEGIN
    UPDATE DetalleDialecto
SET  Lee = @Lee,
     Habla = @Habla, 
     Escribe = @Escribe,
     Estado = @Estado,
     Empleado_idEmpl = @Empleado_idEmpl,
     Dialecto_IdDial = @Dialecto_IdDial
    WHERE  idDetDial = @idDetDial
END
GO
/*ESTE SP_EMERGENCIA PERMITE INGRESAR LOS DATOS DE EMRGENCIA CON SUS RESPECTIVOS EMPLEADOS*/
CREATE PROCEDURE SP_EMERGENCIA
    @NOMEMER VARCHAR (50),
    @APEEMER VARCHAR(50),
    @PARENEMER VARCHAR(50),
    @TELEMER CHAR(7),
    @CELULAREMER CHAR(9),
    @ESTADOEMER VARCHAR(50),
    @EMPLEADO_IDEMPL INT
AS
BEGIN
    INSERT INTO Emergencia
        (NomEmer,ApeEmer,ParenEmer,TelEmer,CelularEmer,EstadoEmer,Empleado_idEmpl)
    VALUES
        (UPPER(@NOMEMER), UPPER(@APEEMER), UPPER(@PARENEMER), @TELEMER, @CELULAREMER,
            UPPER(@ESTADOEMER), UPPER(@EMPLEADO_IDEMPL))
END
GO
/*ESTE SP_EMERGENCIA_UPDATE PERMITE MODIFICAR O ACTUALIZAR LOS DATOS DE EMRGENCIA CON SUS RESPECTIVOS EMPLEADOS*/
CREATE PROCEDURE SP_EMERGENCIA_UPDATE
    @IDEMERG INT,
    @NOMEMER VARCHAR(50),
    @APEEMER VARCHAR(50),
    @PARENEMER VARCHAR(50),
    @TELEMER CHAR(7),
    @CELULAREMER CHAR(9),
    @ESTADOEMER VARCHAR(50),
    @EMPLEADO_IDEMPL INT
AS
BEGIN
    UPDATE Emergencia
SET NomEmer = @NOMEMER,
    ApeEmer = @APEEMER,
    ParenEmer = @PARENEMER,
    TelEmer = @TELEMER,
    CelularEmer = @CELULAREMER,
    EstadoEmer = @ESTADOEMER,
    Empleado_idEmpl = @EMPLEADO_IDEMPL
    WHERE IdEmerg = @IDEMERG
END 
GO
/*ESTE SP SP_EMPLEADO_UPDATE PERMITE MODIFICAR O ACTUALIZAR LOS DATOS DEL EMPLEADO*/
CREATE PROCEDURE SP_EMPLEADO_UPDATE
    @IDEMPL INT,
    @DNI CHAR(8),
    @NOM VARCHAR(50),
    @APELPATE VARCHAR(50),
    @APELMATE CHAR(10),
    @RUC CHAR (10),
    @EMAIL VARCHAR(50),
    @TELF CHAR(7),
    @CEL CHAR(9),
    @FECNAC CHAR(10),
    @GRUPSANG VARCHAR(100),
    @ESTCIV VARCHAR(45),
    @CONLAB VARCHAR(100),
    @CARNASEG CHAR(50),
    @REFE VARCHAR(100),
    @LEYE VARCHAR(20),
    @FECING CHAR(10),
    @FECNOM CHAR(10),
    @DATCONY VARCHAR(50),
    @UBIGACTU VARCHAR(50),
    @EST VARCHAR(50),
    @ORIGEN VARCHAR(50)
AS
BEGIN
    UPDATE Empleado
    SET  DNI = @DNI,
         Nom= @NOM,
         ApelPate = @APELPATE,
         ApelMate = @APELMATE,
         RUC = @RUC,
         Email = @EMAIL,
         Telf = @TELF,
         Cel = @CEL,
         FecNac = CONVERT(date,@FECNAC,103),
         GrupSang = @GRUPSANG,
         EstCiv = @ESTCIV,
         ConLab = @CONLAB,
         CarnAseg = @CARNASEG,
         Refe = @REFE,
         Leye = @LEYE,
         FecIng = CONVERT(date,@FECING,103),
         FecNom = CONVERT(date,@FECNOM,103),
         DatCony = @DATCONY,
         UbigActu = @UBIGACTU,
         Est = @EST,
         Origen = @ORIGEN
         WHERE idEmpl = @IDEMPL
END
GO
/* ESTE SP TE PERMITE INGRESAR DATOS A LA TABLA EMPLEADO*/
CREATE PROCEDURE sp_Empleados
    @DNI CHAR(8),
    @Nom VARCHAR (50),
    @ApelPate VARCHAR(50),
    @ApelMate VARCHAR(50),
    @RUC CHAR(11),
    @Email VARCHAR(50),
    @Telf CHAR(7),
    @Cel CHAR(9),
    @FecNac CHAR(10),
    @GrupSang VARCHAR(100),
    @EstCiv VARCHAR(45),
    @ConLab VARCHAR(100),
    @CarnAseg VARCHAR(50),
    @Refe VARCHAR (100),
    @Leye VARCHAR(20),
    @FecIng CHAR(10),
    @FecNom CHAR(10),
    @DatCony VARCHAR(50),
    @UbigActu VARCHAR(50),
    @Est VARCHAR(50),
    @Origen VARCHAR (50)
AS
BEGIN
    INSERT INTO Empleado
        (DNi,Nom,ApelPate,ApelMate,RUC,Email,Telf,Cel,FecNac,GrupSang,EstCiv,ConLab,CarnAseg,Refe,Leye,FecIng,FecNom,DatCony,
        UbigActu,Est,Origen)
    VALUES
        (@DNI, UPPER(@Nom), UPPER(@ApelPate), UPPER(@ApelMate), @RUC, @Email, @Telf, @Cel, FORMAT(CONVERT(date,@FecNac,103),'dd/MM/yyyy','en-gb'), @GrupSang, UPPER(@EstCiv),
            @ConLab, @CarnAseg, UPPER(@Refe), @Leye, FORMAT(CONVERT(date,@FecIng,103),'dd/MM/yyyy','en-gb'), FORMAT(CONVERT(date,@FecNom,103),'dd/MM/yyyy','en-gb'),
            UPPER(@DatCony), UPPER(@UbigActu), @Est, UPPER(@Origen))
END
GO
/*ESTE SP_ESTUDIOS_SUPER_UPDATE PERMITE MODIFICR O ACTUALIZAR LOS ESTUDIOS SUPERIORES DEL EMPLEADO*/
CREATE PROCEDURE SP_ESTUDIOS_SUPER_UPDATE
    @IDESTUSUPER INT,
    @EDUSUPER VARCHAR(50),
    @ESPESUPER VARCHAR(50),
    @CENTRESTUSUPER VARCHAR(50),
    @DESDSUPER CHAR(10),
    @HASTSUPER CHAR(10),
    @CULMISUPER VARCHAR(50),
    @GRADOACADEMICO VARCHAR(50),
    @ESTADOSUPER VARCHAR(50),
    @EMPLEADO_IDEMPL INT
AS
BEGIN
    UPDATE EstudiosSuperior
    SET EduSuper = @EDUSUPER,
        EspeSuper = @ESPESUPER,
        CentrEstuSuper = @CENTRESTUSUPER,
        DesdSuper = CONVERT(date,@DESDSUPER,103),
        HastSuper = CONVERT(date,@HASTSUPER,103),
        CulmiSuper = @CULMISUPER,
        GradAcadObte = @GRADOACADEMICO,
        EstadoSuper = @ESTADOSUPER,
        Empleado_idEmpl = @EMPLEADO_IDEMPL
        WHERE IdEstusuper = @IDESTUSUPER
END
GO
/*ESTE sp_EstudiosBasicos PERMITE INGRESAR LOS DATOS DE ESTUDIOS BASICOS DEL EMPLEADO*/
CREATE PROCEDURE sp_EstudiosBasicos
    @Educacion VARCHAR(50),
    @Culminacion VARCHAR(50),
    @CentroEstudios VARCHAR(50),
    @Desde CHAR(10),
    @Hasta CHAR(10),
    @Estado VARCHAR(50),
    @Empleado_idEmpl INT
AS
BEGIN
    INSERT INTO EstudioBasicos
        (EducBasi,CulmiBasi,CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi,Empleado_idEmpl)
    VALUES
        (UPPER(@Educacion), UPPER(@Culminacion), UPPER(@CentroEstudios), FORMAT(CONVERT(date,@Desde,105),'dd/MM/yyyy','en-gb'),
            FORMAT(CONVERT(date,@Hasta,105),'dd/MM/yyyy','en-gb'), UPPER(@Estado), UPPER(@Empleado_idEmpl))
END
GO
/* ESTE SP TE PERMITE MODIFICAR LOS DATOS DE LA TABLA ESTUDIOS BASICOS*/
CREATE PROCEDURE SP_EstudiosBasicosUpdate
    @IdEstuBasi INT,
    @EducBasi VARCHAR(50),
    @CulmiBasi VARCHAR(50),
    @CentrEstuBasi VARCHAR(50),
    @DesdBasi CHAR(10),
    @HasBasi CHAR (10),
    @EstadoBasi VARCHAR(50),
    @Empleado_idEmpl INT
AS
BEGIN
    UPDATE EstudioBasicos
    SET  EducBasi = @EducBasi,
         CulmiBasi= @CulmiBasi,
         CentrEstuBasi = @CentrEstuBasi,
         DesdBasi = CONVERT(date,@DesdBasi,103),
         HasBasi = CONVERT(date,@HasBasi,103),
         EstadoBasi = @EstadoBasi,
         Empleado_idEmpl = @Empleado_idEmpl
         WHERE IdEstuBasi = @IdEstuBasi
END
GO
/* ESTE SP TE PERMITE INGRESAR DATOS A LA TABLA ESTUDIOS SUPERIORES*/
CREATE PROCEDURE SP_ESTUDIOSUPER
    @EDU_SUPER VARCHAR(50),
    @ESPE_SUPER VARCHAR(50),
    @CENTRESTU_SUPER VARCHAR(50),
    @DESDE_SUPER CHAR(10),
    @HASTA_SUPER CHAR(10),
    @CULMINACION_SUPER VARCHAR(50),
    @GRADOACADEMICO_SUPER VARCHAR(50),
    @ESTADO_SUPER VARCHAR(50),
    @EMPLEADO_IDEMPL INT
AS
BEGIN
    INSERT INTO EstudiosSuperior
        (EduSuper,EspeSuper,CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper,Empleado_idEmpl)
    VALUES
        (UPPER(@EDU_SUPER), UPPER(@ESPE_SUPER), UPPER(@CENTRESTU_SUPER), FORMAT(CONVERT(date,@DESDE_SUPER,105),'dd/MM/yyyy','en-gb'),
            FORMAT(CONVERT(date,@HASTA_SUPER,105),'dd/MM/yyyy','en-gb'), UPPER(@CULMINACION_SUPER), UPPER(@GRADOACADEMICO_SUPER),
            UPPER(@ESTADO_SUPER), UPPER(@EMPLEADO_IDEMPL))
END
GO
/*ESTE SP_FAMILIARES PERMITE INGRESAR LOS DATOS DE FAMILIARES CON SUS RESPECTIVOS EMPLEADOS*/
CREATE PROCEDURE SP_FAMILIARES
    @NOMFAMI VARCHAR (100),
    @APELFAMI VARCHAR(100),
    @PARFAMI VARCHAR(50),
    @OCUFAMI VARCHAR(50),
    @FECNACFAMI CHAR(10),
    @TELFFAMI CHAR(7),
    @CELULARFAMI CHAR(9),
    @ESTCIVFAMI VARCHAR(50),
    @VIVEFAMI VARCHAR(50),
    @ESTADOFAMI VARCHAR(50),
    @EMPLEADO_IDEMPL INT
AS
BEGIN
    INSERT INTO Familiares
        (NomFami,ApelFami,ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami,Empleado_idEmpl)
    VALUES
        (UPPER(@NOMFAMI), UPPER(@APELFAMI), UPPER(@PARFAMI), UPPER(@OCUFAMI), FORMAT(CONVERT(date,@FECNACFAMI,103),'dd/MM/yyyy','en-gb'),
            @TELFFAMI, @CELULARFAMI, UPPER(@ESTCIVFAMI), UPPER(@VIVEFAMI), UPPER(@ESTADOFAMI), UPPER(@EMPLEADO_IDEMPL))
END
GO
/*ESTE SP_FAMILIARES_UPDATE PERMITE MODIFICAR O ACTUALIZAR FAMILIARES DEL EMPLEADO*/
CREATE PROCEDURE SP_FAMILIARES_UPDATE
    @IDFAMI INT,
    @NOMFAMI VARCHAR(100),
    @APELFAMI VARCHAR(100),
    @PARFAMI VARCHAR(50),
    @OCUFAMI VARCHAR(50),
    @FECNACFAMI CHAR(10),
    @TELFFAMI CHAR(7),
    @CELULARFAMI CHAR(9),
    @ESTCIVFAMI VARCHAR(50),
    @VIVEFAMI VARCHAR(50),
    @ESTADOFAMI VARCHAR (50),
    @EMPLEADO_IDEMPL INT
AS
BEGIN
    UPDATE Familiares
SET NomFami = @NOMFAMI,
    ApelFami = @APELFAMI,
    ParFami = @PARFAMI,
    OcuFami = @OCUFAMI,
    FecNacFami = CONVERT(date,@FECNACFAMI,103),
    TelfFami = @TELFFAMI,
    CelularFami = @CELULARFAMI,
    EstCivFami = @ESTCIVFAMI,
    viveFami = @VIVEFAMI,
    EstadoFami = @ESTADOFAMI,
    Empleado_idEmpl = @EMPLEADO_IDEMPL
    WHERE idFami = @IDFAMI
END 
GO




/* VISTA QUE MUESTRA LOS DATOS DE LA TABLA DETALLE DIALECTO CON RELACION A EMPLEADO Y DIALECTO */
CREATE VIEW vw_DetaEmplActi
AS
    SELECT idDetDial, Lee, Habla, Escribe, Estado,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado',
        UPPER(Dialecto.NomDial) AS 'Dialecto'
    FROM DetalleDialecto
        INNER JOIN Empleado ON DetalleDialecto.Empleado_idEmpl = Empleado.idEmpl
        INNER JOIN Dialecto ON DetalleDialecto.Dialecto_IdDial = Dialecto.IdDial
    WHERE Estado like 'A'
GO
/* VISTA DONDE TE MUESTRA LOS DATOS DE LA TABLA DETALLE DIALECTO EN ESTADO INACTIVO RELACIONADO CON EMPLEADO Y DIALECTO */
CREATE VIEW vw_DetaEmplInac
AS
    SELECT idDetDial, Lee, Habla, Escribe, Estado,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado',
        Dialecto.NomDial AS 'Dialecto'
    FROM DetalleDialecto
        LEFT OUTER JOIN Empleado ON DetalleDialecto.Empleado_idEmpl = Empleado.idEmpl
        LEFT OUTER JOIN Dialecto ON DetalleDialecto.Dialecto_IdDial = Dialecto.IdDial
    WHERE Estado like 'I'
GO
/* VISTA DONDE SE MUESTRA LA INFORMACION DE LA TABLA EMERGENCIA RELACIONADA CON EMPLEADO EN ESTADO ACTIVO */
CREATE VIEW vw_EmerEmplActi
AS
    SELECT IdEmerg, NomEmer, ApeEmer, ParenEmer, TelEmer, CelularEmer, EstadoEmer,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'
    FROM Emergencia
        LEFT OUTER JOIN Empleado ON Emergencia.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoEmer like 'A'
GO
/* VISTA DONDE SE MUESTRA LA INFORMACION DE LA TABLA EMERGENCIA RELACIONADA CON EMPLEADO  EN ESTADO INACTIVO*/
CREATE VIEW vw_EmerEmplInac
AS
    SELECT IdEmerg, NomEmer, ApeEmer, ParenEmer, TelEmer, CelularEmer, EstadoEmer,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'
    FROM Emergencia
        LEFT OUTER JOIN Empleado ON Emergencia.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoEmer like 'I'
GO
/* VISTA DONDE SE MUESTRA TODOS LOS EMPLEADOS*/
CREATE VIEW vw_Empleados
AS
    SELECT idEmpl, UPPER(DNI) AS DNI, UPPER(Nom) AS Nom, UPPER(ApelPate) AS ApelPate, UPPER(ApelMate) AS ApelMate, RUC, Email, Telf, Cel,
        FORMAT(CONVERT(date,FecNac,103),'dd/MM/yyyy','en-gb') AS FecNac, UPPER(GrupSang) AS GrupSang, UPPER(EstCiv) AS EstCiv, UPPER(ConLab) AS ConLab, CarnAseg, UPPER(Refe) AS Refe, UPPER(Leye) AS Leye,
        FORMAT(CONVERT(date,FecIng,103),'dd/MM/yyyy','en-gb') AS FecIng,
        FORMAT(CONVERT(date,FecNom,103),'dd/MM/yyyy','en-gb') AS FecNom,
        UPPER(DatCony) AS DatCony, UPPER(UbigActu) AS 'Direccion', UPPER(Est) AS Est, UPPER(Origen) AS 'Lugar de Nacimiento'
    from Empleado
    WHERE Empleado.Est like 'A'
GO
/* VISTA DONDE SE MUESTRA LA INFORMACION DE LA TABLA EMPLEADOS EN ESTADO INACTIVO*/
CREATE VIEW vw_EmpleadosInac
AS
    SELECT idEmpl, DNI, Nom, ApelPate, ApelMate, RUC, Email, Telf, Cel,
        FORMAT(CONVERT(date,FecNac,103),'dd/MM/yyyy','en-gb') AS FecNac, GrupSang, EstCiv, ConLab, CarnAseg, Refe, Leye,
        FORMAT(CONVERT(date,FecIng,103),'dd/MM/yyyy','en-gb') AS FecIng,
        FORMAT(CONVERT(date,FecNom,103),'dd/MM/yyyy','en-gb') AS FecNom,
        DatCony, UbigActu AS 'Direccion', Est, Origen AS 'Lugar de Nacimiento'
    from Empleado
    WHERE Empleado.Est like 'I'
GO
/* VISTA DONDE SE MUESTRA LA INFORMACION DE LA TABLA ESTUDIOS BASICOS EN ESTADO ACTIVO */
CREATE VIEW vw_EstuBasiEmpl
AS
    SELECT IdEstuBasi, EducBasi, CulmiBasi, CentrEstuBasi,
        FORMAT(CONVERT(date,DesdBasi,103),'dd/MM/yyyy','en-gb') AS DesdBasi,
        FORMAT(CONVERT(date,HasBasi,103),'dd/MM/yyyy','en-gb') AS HasBasi, EstadoBasi,
        UPPER(CONCAT (Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'
    FROM EstudioBasicos
        LEFT OUTER JOIN Empleado ON EstudioBasicos.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoBasi like 'A'
GO
/* VISTA DONDE MUESTRA LOS DATOS DE LA TABLA ESTUDIOS BASICOS CON RELACION A LA TABLA EMPLEADO EN ESTADO INACTIVO*/
CREATE VIEW vw_EstuBasiEmplInac
AS
    SELECT IdEstuBasi, EducBasi, CulmiBasi, CentrEstuBasi,
        FORMAT(CONVERT(date,DesdBasi,103),'dd/MM/yyyy','en-gb') AS DesdBasi,
        FORMAT(CONVERT(date,HasBasi,103),'dd/MM/yyyy','en-gb') AS HasBasi, EstadoBasi,
        UPPER(CONCAT (Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'
    FROM EstudioBasicos
        LEFT OUTER JOIN Empleado ON EstudioBasicos.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoBasi like 'I'
GO
/* VISTA DONDE TE MUESTRA LA INFORMACION DE LA TABLA ESTUDIOS SUPERIORES RELACIONADO CON EMPLEADO Y EN ESTADO ACTIVO */
CREATE VIEW  vw_EstuSuperEmpl
AS
    SELECT IdEstusuper, EduSuper, EspeSuper, CentrEstuSuper,
        FORMAT(CONVERT(date,DesdSuper,103),'dd/MM/yyyy','en-gb') AS DesdSuper,
        FORMAT(CONVERT(date,HastSuper,103),'dd/MM/yyyy','en-gb') AS HastSuper, CulmiSuper, GradAcadObte, EstadoSuper,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'
    FROM EstudiosSuperior
        LEFT OUTER JOIN Empleado ON  EstudiosSuperior.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoSuper like 'A'
GO
/* VISTA DONDE TE MUESTRA LA INFORMACION DE LA TABLA ESTUDIOS SUPERIORES RELACIONADO CON EMPLEADO Y EN ESTADO INACTIVO */
CREATE VIEW vw_EstuSuperEmplInac
AS
    SELECT IdEstusuper, EduSuper, EspeSuper, CentrEstuSuper,
        FORMAT(CONVERT(date,DesdSuper,103),'dd/MM/yyyy','en-gb') AS DesdSuper,
        FORMAT(CONVERT(date,HastSuper,103),'dd/MM/yyyy','en-gb') AS HastSuper, CulmiSuper, GradAcadObte, EstadoSuper,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'
    FROM EstudiosSuperior
        LEFT OUTER JOIN Empleado ON  EstudiosSuperior.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoSuper like 'I'
GO
/* VISTA DONDE SE MUESTRA LA INFORMACION LA TABLA FAMILIARES EN ESTADO ACTIVO RELACIONADO CON EMPLEADO */
CREATE VIEW vw_FamiEmplActi
AS
    SELECT idFami, NomFami, ApelFami, ParFami, OcuFami,
        format(convert(date,FecNacFami,103),'dd/MM/yyyy','en-gb') as FecNacFami, TelfFami, CelularFami, EstCivFami, viveFami, EstadoFami,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',', Empleado.ApelMate)) AS 'Empleado'
    FROM Familiares
        LEFT OUTER JOIN Empleado ON Familiares.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoFami like 'A'
GO
/* VISTA DONDE SE MUESTRA LA INFORMACION LA TABLA FAMILIARES EN ESTADO INACTIVO RELACIONADO CON EMPLEADO */
CREATE VIEW vw_FamiEmplInac
AS
    SELECT idFami, NomFami, ApelFami, ParFami, OcuFami,
        format(convert(date,FecNacFami,103),'dd/MM/yyyy','en-gb') as FecNacFami, TelfFami, CelularFami, EstCivFami, viveFami, EstadoFami,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',', Empleado.ApelMate)) AS 'Empleado'
    FROM Familiares
        LEFT OUTER JOIN Empleado ON Familiares.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoFami like 'I'
GO
/*VISTA DONDE TE MUESTRA LA INFORMACION DE LA TABLA DATOS EN ESTADO ACTIVO RELACIONADO CON EMPLEADO*/
CREATE VIEW VW_LISTAR_DATOS
AS
    SELECT IdLegajo, Con, ApreCali, SerPre, IntProCapPerf, RefPer, BonPer, ComInfTper, BonFam,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelPate)) AS 'Empleado', Estado
    FROM Datos
        LEFT OUTER JOIN Empleado ON Datos.Empleado_idEmpl = Empleado.idEmpl
    WHERE Estado like 'A'
GO
/*VISTA DONDE TE MUESTRA LA INFORMACION DE LA TABLA DATOS EN ESTADO INACTIVO RELACIONADO CON EMPLEADO*/
CREATE VIEW VW_LISTAR_DATOS_INACTIVOS
AS
    SELECT IdLegajo, Con, ApreCali, SerPre, IntProCapPerf, RefPer, BonPer, ComInfTper, BonFam,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelPate)) AS 'Empleado', Estado
    FROM Datos
        LEFT OUTER JOIN Empleado ON Datos.Empleado_idEmpl = Empleado.idEmpl
    WHERE Estado like 'I'
GO
/* VISTA DONDE MUESTRA TODOS LOS DIALECTOS */
CREATE VIEW VW_LISTAR_DIALECTO
AS
    SELECT IdDial, NomDial
    FROM Dialecto
GO
/* VISTA DONDE TE MUESTRA EL LISTADO DEL UBIGEO */
CREATE VIEW VW_UBIGEO
AS
    SELECT CodUbi, Dep, Pro, Dis
    FROM Ubigeo
GO
/* VISTA QUE MUESTRA TODOS LOS DATOS DE TODAS LAS TABLAS */
CREATE VIEW vw_EmpleadoComplet
AS
    SELECT DNI, Nom, ApelPate, ApelMate, RUC, Email, Telf, Cel, FecNac, GrupSang, EstCiv, ConLab, CarnAseg, Refe, Leye, FecIng, FecNom, DatCony, UbigActu AS 'Direccion', Est,
        CONCAT(Ubigeo.Dep,',',Ubigeo.Pro,',',Ubigeo.Dis) AS 'Lugar de Nacimiento',
        Familiares.NomFami, Familiares.ApelFami, Familiares.CelularFami, Familiares.FecNacFami, Familiares.EstadoFami, Familiares.EstCivFami, Familiares.OcuFami, Familiares.ParFami, Familiares.viveFami,
        Emergencia.NomEmer, Emergencia.ApeEmer, Emergencia.CelularEmer, Emergencia.EstadoEmer, Emergencia.ParenEmer, Emergencia.TelEmer,
        EstudioBasicos.CentrEstuBasi, EstudioBasicos.CulmiBasi, EstudioBasicos.DesdBasi, EstudioBasicos.EducBasi, EstudioBasicos.EstadoBasi, EstudioBasicos.HasBasi,
        EstudiosSuperior.CentrEstuSuper, EstudiosSuperior.CulmiSuper, EstudiosSuperior.DesdSuper, EstudiosSuperior.EduSuper, EstudiosSuperior.EspeSuper, EstudiosSuperior.EstadoSuper, EstudiosSuperior.GradAcadObte, EstudiosSuperior.HastSuper,
        DetalleDialecto.Lee, DetalleDialecto.Habla, DetalleDialecto.Escribe, DetalleDialecto.Estado
    FROM Empleado
        RIGHT OUTER JOIN Familiares ON Empleado.Familiares_idFami= Familiares.idFami
        RIGHT OUTER JOIN Emergencia ON Empleado.Emergencia_IdEmerg = Emergencia.IdEmerg
        RIGHT OUTER JOIN EstudioBasicos ON Empleado.EstudioBasicos_IdEstuBasi = EstudioBasicos.IdEstuBasi
        RIGHT OUTER JOIN EstudiosSuperior ON Empleado.EstudiosSuperior_IdEstusuper = EstudiosSuperior.IdEstusuper
        RIGHT OUTER JOIN Ubigeo ON Empleado.Ubigeo_CodUbi = Ubigeo.CodUbi
        RIGHT OUTER JOIN DetalleDialecto ON Empleado.DetalleDialecto_idDetDial = DetalleDialecto.idDetDial
    WHERE Empleado.Est like 'A' AND Familiares.EstadoFami like 'A' AND Emergencia.EstadoEmer like 'A'
        AND EstudioBasicos.EstadoBasi like 'A' AND EstudiosSuperior.EstadoSuper like 'A' AND DetalleDialecto.Estado like 'A'
GO
