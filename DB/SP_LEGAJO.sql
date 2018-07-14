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


TRUNCATE TABLE datos
TRUNCATE TABLE Empleado