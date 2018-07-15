/*EMPLEADOS*/
/*Este SP permite ingresar los datos de Empleados*/

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
        (@DNI, @Nom, @ApelPate, @ApelMate, @RUC, @Email, @Telf, @Cel, FORMAT(CONVERT(date,@FecNac,103),'dd/MM/yyyy','en-gb'), @GrupSang, @EstCiv,
            @ConLab, @CarnAseg, @Refe, @Leye, FORMAT(CONVERT(date,@FecIng,103),'dd/MM/yyyy','en-gb'), FORMAT(CONVERT(date,@FecNom,103),'dd/MM/yyyy','en-gb'),
            @DatCony, @UbigActu, @Est,@Origen)
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


/*ESTUDIOS BASICOS*/
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
        (UPPER(@Educacion),UPPER(@Culminacion),UPPER(@CentroEstudios),FORMAT(CONVERT(date,@Desde,105),'dd/MM/yyyy','en-gb'),
        FORMAT(CONVERT(date,@Hasta,105),'dd/MM/yyyy','en-gb'),UPPER(@Estado),UPPER(@Empleado_idEmpl))
    END
GO

/*ESTE SP_EstudiosBasicosUpdate PERMITE MODIFICAR O ACTUALIZAR ESTUDIOS BASICOS DEL EMPLEADO*/
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


/*ESTUDIOS SUPERIORES*/
/*ESTE SP_ESTUDIOSUPER PERMITE INGRESAR LOS ESTUDIOS SUPERIORES DEL EMPLEADO*/

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
    (UPPER(@EDU_SUPER),UPPER(@ESPE_SUPER),UPPER(@CENTRESTU_SUPER),FORMAT(CONVERT(date,@DESDE_SUPER,105),'dd/MM/yyyy','en-gb'),
    FORMAT(CONVERT(date,@HASTA_SUPER,105),'dd/MM/yyyy','en-gb'),UPPER(@CULMINACION_SUPER),UPPER(@GRADOACADEMICO_SUPER),
    UPPER(@ESTADO_SUPER),UPPER(@EMPLEADO_IDEMPL))
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


/*FAMILIARES*/
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
(UPPER(@NOMFAMI),UPPER(@APELFAMI),UPPER(@PARFAMI),UPPER(@OCUFAMI),FORMAT(CONVERT(date,@FECNACFAMI,103),'dd/MM/yyyy','en-gb'),
@TELFFAMI,@CELULARFAMI,UPPER(@ESTCIVFAMI),UPPER(@VIVEFAMI),UPPER(@ESTADOFAMI),UPPER(@EMPLEADO_IDEMPL))
END
GO

/*ESTE SP_FAMILIARES_UPDATE PERMITE MODIFICAR O ACTUALIZAR FAMILIARES DEL EMPLEADO*/

CREATE PROCEDURE SP_FAMILIARES_UPDATE
    @CODIGOFAMI INT,
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
    WHERE CodContEmp = @CODIGOFAMI
END 
GO


/*EMERGENCIA*/
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
(UPPER(@NOMEMER),UPPER(@APEEMER),UPPER(@PARENEMER),@TELEMER,@CELULAREMER,
UPPER(@ESTADOEMER),UPPER(@EMPLEADO_IDEMPL))
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


/*SP_DETALLEDIALECTO*/
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
    (UPPER(@LEE),UPPER(@HABLA),UPPER(@ESCRIBE),UPPER(@ESTADO),UPPER(@EMPLEADO_IDEMPL),UPPER(@DIALECTO_IDDIAL))
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

/*DATOS*/
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
    (UPPER(@CON),UPPER(@APRECALI),UPPER(@SERPRE),UPPER(@INTPROCAPPERF),UPPER(@REFPER),UPPER(@BONPER),UPPER(@COMINFTPER),
    UPPER(@BONFAM),UPPER(@EMPLEADO_IDEMPL),UPPER(@ESTADO))
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

/*LISTAS*/
/*ESTE sp_Listas ME PERMITE LISTAR TODAS LAS VISTAS DE EMPLEADOS ACTIVOS E INACTIVOS, ESTUDIOS BASICOS ACTIVOS E INACTIVOS Y ESTUDIOS SUPERIORES ACTIVOS E INACTIVOS*/
CREATE PROCEDURE sp_Listas
AS
    BEGIN
    SELECT * FROM vw_DetaEmplActi,vw_EmerEmplActi,vw_EstuBasiEmpl,vw_EstuSuperEmpl,vw_FamiEmplActi  
    
    END
GO