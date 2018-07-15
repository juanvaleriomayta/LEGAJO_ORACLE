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


/* VISTA DONDE TE MUESTRA LOS DATOS DE LA TABLA DETALLE DIALECTO EN ESTADO ACTIVO RELACIONADO CON EMPLEADO Y DIALECTO */
CREATE VIEW vw_DetaEmplActi
AS
    SELECT idDetDial, Lee, Habla, Escribe, Estado,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado',
        Dialecto.NomDial AS 'Dialecto'
    FROM DetalleDialecto
        LEFT OUTER JOIN Empleado ON DetalleDialecto.Empleado_idEmpl = Empleado_idEmpl
        LEFT OUTER JOIN Dialecto ON DetalleDialecto.Dialecto_IdDial = Dialecto.IdDial
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

/* VISTA DONDE MUESTRA TODOS LOS DIALECTOS */
CREATE VIEW VW_LISTAR_DIALECTO
AS
    SELECT IdDial, NomDial
    FROM Dialecto
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

/* VISTA DONDE SE MUESTRA LA INFORMACION DE LA TABLA EMPLEADOS EN ESTADO ACTIVO */
CREATE VIEW vw_Empleados
AS
    SELECT idEmpl, DNI, Nom, ApelPate, ApelMate, RUC, Email, Telf, Cel,
        FORMAT(CONVERT(date,FecNac,103),'dd/MM/yyyy','en-gb') AS FecNac, GrupSang, EstCiv, ConLab, CarnAseg, Refe, Leye,
        FORMAT(CONVERT(date,FecIng,103),'dd/MM/yyyy','en-gb') AS FecIng,
        FORMAT(CONVERT(date,FecNom,103),'dd/MM/yyyy','en-gb') AS FecNom,
        DatCony, UbigActu AS 'Direccion', Est, Origen AS 'Lugar de Nacimiento'
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

/* VISTA DONDE SE MUESTRA LA INFORMACION DE LA TABLA ESTUDIOS BASICOS EN ESTADO INACTIVO */
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
    SELECT CodContEmp, NomFami, ApelFami, ParFami, OcuFami,
    format(convert(date,FecNacFami,103),'dd/MM/yyyy','en-gb') as FecNacFami, TelfFami, CelularFami, EstCivFami, viveFami, EstadoFami,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',', Empleado.ApelMate)) AS 'Empleado'
    FROM Familiares
        LEFT OUTER JOIN Empleado ON Familiares.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoFami like 'A'
GO

/* VISTA DONDE SE MUESTRA LA INFORMACION LA TABLA FAMILIARES EN ESTADO INACTIVO RELACIONADO CON EMPLEADO */
CREATE VIEW vw_FamiEmplInac
AS
    SELECT CodContEmp, NomFami, ApelFami, ParFami, OcuFami,
    format(convert(date,FecNacFami,103),'dd/MM/yyyy','en-gb') as FecNacFami, TelfFami, CelularFami, EstCivFami, viveFami, EstadoFami,
        UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',', Empleado.ApelMate)) AS 'Empleado'
    FROM Familiares
        LEFT OUTER JOIN Empleado ON Familiares.Empleado_idEmpl = Empleado.idEmpl
    WHERE EstadoFami like 'I'
GO

/* VISTA DONDE TE MUESTRA EL LISTADO DEL UBIGEO */
CREATE VIEW VW_UBIGEO
AS
    SELECT CodUbi, Dep, Pro, Dis
    FROM Ubigeo
GO

/* VISTA DONDE ESTAN RELACIONADAS TODAS LAS TABLAS EN ESTADO ACTIVO */
CREATE VIEW vw_EmpleadoReport
AS
SELECT DNI,Nom,ApelPate,ApelMate,RUC,Email,Telf,Cel,FecNac, GrupSang,EstCiv,ConLab,CarnAseg,Refe,Leye,FecIng,FecNom,DatCony,UbigActu AS 'Direccion',Est,
CONCAT(Ubigeo.Dep,',',Ubigeo.Pro,',',Ubigeo.Dis) AS 'Lugar de Nacimiento',
Familiares.NomFami,Familiares.ApelFami,Familiares.CelularFami,Familiares.FecNacFami,Familiares.EstadoFami,Familiares.EstCivFami,Familiares.OcuFami,Familiares.ParFami,
Emergencia.NomEmer,Emergencia.ApeEmer,Emergencia.CelularEmer,Emergencia.EstadoEmer,Emergencia.ParenEmer,Emergencia.TelEmer,
EstudioBasicos.CentrEstuBasi,EstudioBasicos.CulmiBasi,EstudioBasicos.DesdBasi,EstudioBasicos.EducBasi,EstudioBasicos.EstadoBasi,EstudioBasicos.HasBasi,
EstudiosSuperior.CentrEstuSuper,EstudiosSuperior.CulmiSuper,EstudiosSuperior.DesdSuper,EstudiosSuperior.EduSuper,EstudiosSuperior.EspeSuper,EstudiosSuperior.EstadoSuper,EstudiosSuperior.GradAcadObte,EstudiosSuperior.HastSuper,
Empleado.Pass, DetalleDialecto.Lee,DetalleDialecto.Habla,DetalleDialecto.Escribe,DetalleDialecto.Estado
FROM Empleado
LEFT OUTER JOIN Familiares ON Empleado.Familiares_CodContEmp = Familiares.CodContEmp
LEFT OUTER JOIN Emergencia ON Empleado.Emergencia_IdEmerg = Emergencia.IdEmerg
LEFT OUTER JOIN EstudioBasicos ON Empleado.EstudioBasicos_IdEstuBasi = EstudioBasicos.IdEstuBasi
LEFT OUTER JOIN EstudiosSuperior ON Empleado.EstudiosSuperior_IdEstusuper = EstudiosSuperior.IdEstusuper
LEFT OUTER JOIN Ubigeo ON Empleado.Ubigeo_CodUbi = Ubigeo.CodUbi
LEFT OUTER JOIN DetalleDialecto ON Empleado.DetalleDialecto_idDetDial = DetalleDialecto.idDetDial
WHERE Empleado.Est like 'A' AND Familiares.EstadoFami like 'A' AND Emergencia.EstadoEmer like 'A'
AND EstudioBasicos.EstadoBasi like 'A' AND EstudiosSuperior.EstadoSuper like 'A' AND DetalleDialecto.Estado like 'A'
GO


