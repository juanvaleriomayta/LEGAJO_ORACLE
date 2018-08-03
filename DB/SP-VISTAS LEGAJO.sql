/*EMPLEADOS CESANTES*/
CREATE VIEW vw_EmpleadosCesante
AS
    SELECT idEmpl, UPPER(DNI) AS DNI, UPPER(Nom) AS Nom, UPPER(ApelPate) AS ApelPate, UPPER(ApelMate) AS ApelMate, RUC, Email, Telf, Cel,
        FORMAT(CONVERT(date,FecNac,103),'dd/MM/yyyy','en-gb') AS FecNac, UPPER(GrupSang) AS GrupSang, UPPER(EstCiv) AS EstCiv, UPPER(ConLab) AS ConLab, CarnAseg, UPPER(Refe) AS Refe, UPPER(Leye) AS Leye,
        FORMAT(CONVERT(date,FecIng,103),'dd/MM/yyyy','en-gb') AS FecIng,
        FORMAT(CONVERT(date,FecNom,103),'dd/MM/yyyy','en-gb') AS FecNom,
        UPPER(DatCony) AS DatCony, UPPER(UbigActu) AS 'Direccion', UPPER(Est) AS Est, UPPER(Origen) AS 'Lugar de Nacimiento'
    from Empleado
    WHERE Empleado.Est like 'A' and ConLab like 'Cesante'
GO
/*EMPLEADOS NOMBRADOS*/
CREATE VIEW vw_EmpleadosNombrados
AS
    SELECT idEmpl, UPPER(DNI) AS DNI, UPPER(Nom) AS Nom, UPPER(ApelPate) AS ApelPate, UPPER(ApelMate) AS ApelMate, RUC, Email, Telf, Cel,
        FORMAT(CONVERT(date,FecNac,103),'dd/MM/yyyy','en-gb') AS FecNac, UPPER(GrupSang) AS GrupSang, UPPER(EstCiv) AS EstCiv, UPPER(ConLab) AS ConLab, CarnAseg, UPPER(Refe) AS Refe, UPPER(Leye) AS Leye,
        FORMAT(CONVERT(date,FecIng,103),'dd/MM/yyyy','en-gb') AS FecIng,
        FORMAT(CONVERT(date,FecNom,103),'dd/MM/yyyy','en-gb') AS FecNom,
        UPPER(DatCony) AS DatCony, UPPER(UbigActu) AS 'Direccion', UPPER(Est) AS Est, UPPER(Origen) AS 'Lugar de Nacimiento'
    from Empleado
    WHERE Empleado.Est like 'A' and ConLab like 'Nombrado'
GO
/* EMPLADOS CAS */
CREATE VIEW vw_EmpleadosCas
AS
    SELECT idEmpl, UPPER(DNI) AS DNI, UPPER(Nom) AS Nom, UPPER(ApelPate) AS ApelPate, UPPER(ApelMate) AS ApelMate, RUC, Email, Telf, Cel,
        FORMAT(CONVERT(date,FecNac,103),'dd/MM/yyyy','en-gb') AS FecNac, UPPER(GrupSang) AS GrupSang, UPPER(EstCiv) AS EstCiv, UPPER(ConLab) AS ConLab, CarnAseg, UPPER(Refe) AS Refe, UPPER(Leye) AS Leye,
        FORMAT(CONVERT(date,FecIng,103),'dd/MM/yyyy','en-gb') AS FecIng,
        FORMAT(CONVERT(date,FecNom,103),'dd/MM/yyyy','en-gb') AS FecNom,
        UPPER(DatCony) AS DatCony, UPPER(UbigActu) AS 'Direccion', UPPER(Est) AS Est, UPPER(Origen) AS 'Lugar de Nacimiento'
    from Empleado
    WHERE Empleado.Est like 'A' and ConLab like 'Cas'
GO
/*EMPLEADOS INACTIVOS*/
CREATE VIEW vw_EmpleadosInac
AS
    SELECT idEmpl, UPPER(DNI) AS DNI, UPPER(Nom) AS Nom, UPPER(ApelPate) AS ApelPate, UPPER(ApelMate) AS ApelMate, RUC, Email, Telf, Cel,
        FORMAT(CONVERT(date,FecNac,103),'dd/MM/yyyy','en-gb') AS FecNac, UPPER(GrupSang) AS GrupSang, UPPER(EstCiv) AS EstCiv, UPPER(ConLab) AS ConLab, CarnAseg, UPPER(Refe) AS Refe, UPPER(Leye) AS Leye,
        FORMAT(CONVERT(date,FecIng,103),'dd/MM/yyyy','en-gb') AS FecIng,
        FORMAT(CONVERT(date,FecNom,103),'dd/MM/yyyy','en-gb') AS FecNom,
        UPPER(DatCony) AS DatCony, UPPER(UbigActu) AS 'Direccion', UPPER(Est) AS Est, UPPER(Origen) AS 'Lugar de Nacimiento'
    from Empleado
    WHERE Empleado.Est like 'I' 
GO
/* VISTA DONDE SE MUESTRA LA INFORMACION DE LA TABLA ESTUDIOS BASICOS EN ESTADO ACTIVO */
CREATE VIEW vw_EstuBasiEmpl
AS
    SELECT IdEstuBasi, UPPER(EducBasi) AS EducBasi, UPPER(CulmiBasi) AS CulmiBasi, UPPER(CentrEstuBasi) AS CentrEstuBasi,
        FORMAT(CONVERT(date,DesdBasi,103),'dd/MM/yyyy','en-gb') AS DesdBasi,
        FORMAT(CONVERT(date,HasBasi,103),'dd/MM/yyyy','en-gb') AS HasBasi, EstadoBasi,
        UPPER(CONCAT (Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'
    FROM EstudioBasicos
        LEFT OUTER JOIN Empleado ON EstudioBasicos.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoBasi like 'A'
GO
/*ESTUDIOS BASICOS INACTIVOS CON RELACION A EMPLEADOS*/
CREATE VIEW vw_EstuBasiEmplInac
AS
    SELECT IdEstuBasi, UPPER(EducBasi) AS EducBasi, UPPER(CulmiBasi) AS CulmiBasi, UPPER(CentrEstuBasi) AS CentrEstuBasi,
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
    SELECT IdEstusuper, UPPER(EduSuper) AS EduSuper, UPPER(EspeSuper) AS EspeSuper, UPPER(CentrEstuSuper) AS CentrEstuSuper,
        FORMAT(CONVERT(date,DesdSuper,103),'dd/MM/yyyy','en-gb') AS DesdSuper,
        FORMAT(CONVERT(date,HastSuper,103),'dd/MM/yyyy','en-gb') AS HastSuper, UPPER(CulmiSuper) AS CulmiSuper, UPPER(GradAcadObte) AS GradAcadObte, EstadoSuper,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'
    FROM EstudiosSuperior
        LEFT OUTER JOIN Empleado ON  EstudiosSuperior.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoSuper like 'A'
GO
/* ESTUDIOS SUPERIORE INACTIVOS RELACIONADOS CON EMPLEADO*/
CREATE VIEW  vw_EstuSuperEmplInac
AS
    SELECT IdEstusuper, UPPER(EduSuper) AS EduSuper, UPPER(EspeSuper) AS EspeSuper, UPPER(CentrEstuSuper) AS CentrEstuSuper,
        FORMAT(CONVERT(date,DesdSuper,103),'dd/MM/yyyy','en-gb') AS DesdSuper,
        FORMAT(CONVERT(date,HastSuper,103),'dd/MM/yyyy','en-gb') AS HastSuper, UPPER(CulmiSuper) AS CulmiSuper, UPPER(GradAcadObte) AS GradAcadObte, EstadoSuper,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'
    FROM EstudiosSuperior
        LEFT OUTER JOIN Empleado ON  EstudiosSuperior.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoSuper like 'I'
GO
/* VISTA DONDE SE MUESTRA LA INFORMACION LA TABLA FAMILIARES EN ESTADO ACTIVO RELACIONADO CON EMPLEADO */
CREATE VIEW vw_FamiEmplActi
AS
    SELECT idFami, UPPER(NomFami) AS NomFami, UPPER(ApelFami) AS ApelFami, UPPER(ParFami) AS ParFami, UPPER(OcuFami) AS OcuFami,
        format(convert(date,FecNacFami,103),'dd/MM/yyyy','en-gb') as FecNacFami, TelfFami, CelularFami, UPPER(EstCivFami) AS EstCivFami, UPPER(viveFami) AS viveFami, EstadoFami,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',', Empleado.ApelMate)) AS 'Empleado'
    FROM Familiares
        LEFT OUTER JOIN Empleado ON Familiares.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoFami like 'A'
GO
/*FAMILIARES INACTIVOS CON EMPLEADO*/
CREATE VIEW vw_FamiEmplInac
AS
    SELECT idFami, UPPER(NomFami) AS NomFami, UPPER(ApelFami) AS ApelFami, UPPER(ParFami) AS ParFami, UPPER(OcuFami) AS OcuFami,
        format(convert(date,FecNacFami,103),'dd/MM/yyyy','en-gb') as FecNacFami, TelfFami, CelularFami, UPPER(EstCivFami) AS EstCivFami, UPPER(viveFami) AS viveFami, EstadoFami,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',', Empleado.ApelMate)) AS 'Empleado'
    FROM Familiares
        LEFT OUTER JOIN Empleado ON Familiares.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoFami like 'I'
GO
/* VISTA DONDE SE MUESTRA LA INFORMACION DE LA TABLA EMERGENCIA RELACIONADA CON EMPLEADO EN ESTADO ACTIVO */
CREATE VIEW vw_EmerEmplActi
AS
    SELECT IdEmerg, UPPER(NomEmer) AS NomEmer, UPPER(ApeEmer) AS ApeEmer, UPPER(ParenEmer) AS ParenEmer, TelEmer, CelularEmer, EstadoEmer,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'
    FROM Emergencia
        LEFT OUTER JOIN Empleado ON Emergencia.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoEmer like 'A'
GO
/* EMERGENCIA INACTIVOS CON EMPLEADO*/
CREATE VIEW vw_EmerEmplInac
AS
    SELECT IdEmerg, UPPER(NomEmer) AS NomEmer, UPPER(ApeEmer) AS ApeEmer, UPPER(ParenEmer) AS ParenEmer, TelEmer, CelularEmer, EstadoEmer,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'
    FROM Emergencia
        LEFT OUTER JOIN Empleado ON Emergencia.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoEmer like 'I'
GO
/*DEATLLE DIALECTO CON EMPLEADO Y DIALECTO*/
CREATE VIEW vw_DetaEmplActi
AS
    SELECT idDetDial, UPPER(Lee) AS Lee, UPPER(Habla) AS Habla, UPPER(Escribe) AS Escribe, Estado,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado',
        UPPER(Dialecto.NomDial) AS 'Dialecto'
    FROM DetalleDialecto
        INNER JOIN Empleado ON DetalleDialecto.Empleado_idEmpl = Empleado.idEmpl
        INNER JOIN Dialecto ON DetalleDialecto.Dialecto_IdDial = Dialecto.IdDial
    WHERE Estado like 'A'
GO
/*DETALLE DIALECTO INACTIVO CON EMPLEADO Y DIALECTO*/
CREATE VIEW vw_DetaEmplInac
AS
    SELECT idDetDial, UPPER(Lee) AS Lee, UPPER(Habla) AS Habla, UPPER(Escribe) AS Escribe, Estado,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado',
        UPPER(Dialecto.NomDial) AS 'Dialecto'
    FROM DetalleDialecto
        INNER JOIN Empleado ON DetalleDialecto.Empleado_idEmpl = Empleado.idEmpl
        INNER JOIN Dialecto ON DetalleDialecto.Dialecto_IdDial = Dialecto.IdDial
    WHERE Estado like 'I'
GO
/*VISTA DONDE TE MUESTRA LA INFORMACION DE LA TABLA DATOS EN ESTADO ACTIVO RELACIONADO CON EMPLEADO*/
CREATE VIEW VW_LISTAR_DATOS
AS
    SELECT IdLegajo, UPPER(Con) AS Con, UPPER(ApreCali) AS ApreCali, UPPER(SerPre) AS SerPre, UPPER(IntProCapPerf) AS IntProCapPerf,
        UPPER(RefPer) AS RefPer, UPPER(BonPer) AS BonPer, UPPER(ComInfTper) AS ComInfTper, UPPER(BonFam) AS BonFam,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelPate)) AS 'Empleado', Estado
    FROM Datos
        LEFT OUTER JOIN Empleado ON Datos.Empleado_idEmpl = Empleado.idEmpl
    WHERE Estado like 'A'
GO
/* DATOS CON EMPLEDAOS*/
CREATE VIEW VW_LISTAR_DATOS_INACTIVOS
AS
    SELECT IdLegajo, UPPER(Con) AS Con, UPPER(ApreCali) AS ApreCali, UPPER(SerPre) AS SerPre, UPPER(IntProCapPerf) AS IntProCapPerf,
        UPPER(RefPer) AS RefPer, UPPER(BonPer) AS BonPer, UPPER(ComInfTper) AS ComInfTper, UPPER(BonFam) AS BonFam,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelPate)) AS 'Empleado', Estado
    FROM Datos
        LEFT OUTER JOIN Empleado ON Datos.Empleado_idEmpl = Empleado.idEmpl
    WHERE Estado like 'I'
GO
/* USUARIOS */
CREATE VIEW VW_USUARIO
AS
    SELECT IdUsuario, Usuario, Pass, Nombre, Nivel, Estado
    FROM Usuario
    WHERE Estado like 'A'
GO
/* USUARIOS INACTIVOS */
CREATE VIEW VW_USUARIO_INACTIVOS
AS
    SELECT IdUsuario, Usuario, Pass, Nombre, Nivel, Estado
    FROM Usuario
    WHERE Estado like 'I'
GO

-----------SP--------------
/*INGRESAR EMPELADO*/
CREATE PROCEDURE [dbo].[sp_Empleados]
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
/* MODIFICAR ESTUDIOS BASICOS*/
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

/*REGISTRAR ESTUDIOS SUPERIORES*/
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
/*MODIFICAR ESTUDIOS SUPERIORES*/
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
CREATE PROCEDURE [dbo].[SP_FAMILIARES_UPDATE]
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
    WHERE IdFami = @CODIGOFAMI
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

