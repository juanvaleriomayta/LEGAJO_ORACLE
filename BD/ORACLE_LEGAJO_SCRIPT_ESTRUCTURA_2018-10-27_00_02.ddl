-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-10-27 05:00:23.029

-- tables
-- Table: AYUDA
CREATE TABLE AYUDA (
    CODAYU INT,
    NOMAYU varchar2(50),
    DESCAYU varchar2(100),
    CONSTRAINT AYUDA_pk PRIMARY KEY (CODAYU)
) ;

-- Table: DATOS
CREATE TABLE DATOS (
    CODDAT INT,
    CONDAT varchar2(50),
    APRECALIDAT varchar2(50),
    SERPREDAT varchar2(50),
    ENTPROCAPPERFDAT varchar2(50),
    REFDAT varchar2(50),
    BONPERDAT varchar2(50),
    COMINFTPERDAT varchar2(50),
    BONFAMDAT varchar2(50),
    ESTDAT varchar2(50),
    CODEMPL INT,
    CONSTRAINT DATOS_pk PRIMARY KEY (CODDAT)
) ;

-- Table: DETALLE_DIALECTO
CREATE TABLE DETALLE_DIALECTO (
    CODDETADIAL INT,
    LEEDETADIAL varchar2(50),
    HABLDETADIAL varchar2(50),
    ESCDETADIAL varchar2(50),
    ESTDETADIAL varchar2(50),
    CODEMPL INT,
    CODDIAL INT,
    CONSTRAINT DETALLE_DIALECTO_pk PRIMARY KEY (CODDETADIAL)
) ;

-- Table: DIALECTO
CREATE TABLE DIALECTO (
    CODDIAL INT,
    NOMDIAL varchar2(50),
    CONSTRAINT DIALECTO_pk PRIMARY KEY (CODDIAL)
) ;

-- Table: EMERGENCIA
CREATE TABLE EMERGENCIA (
    CODEMER INT,
    NOMEMER varchar2(50),
    APEEMER varchar2(50),
    PARENEMER varchar2(50),
    TELEMER char(7),
    CELEMER char(50),
    ESTEMER varchar2(50),
    CODEMPL INT,
    CONSTRAINT EMERGENCIA_pk PRIMARY KEY (CODEMER)
) ;

-- Table: EMPLEADO
CREATE TABLE EMPLEADO (
    CODEMPL INT,
    DNIEMPL char(8),
    NOMEMPL varchar2(50),
    APEPATEEMPL varchar2(50),
    APEMATEEMPL varchar2(50),
    RUCEMPL char(11),
    EMAILEMPL varchar2(50),
    TELEMPL char(7),
    CELEMPL varchar2(9),
    FECNACEMPL date,
    GRUPSANGEMPL varchar2(100),
    ESTCIVEMPL varchar2(45),
    CONLABEMPL varchar2(100),
    CARASEEMPL char(50),
    REFEEMPL varchar2(100),
    LEYEMPL varchar2(20),
    FEUNGEMPL date,
    FECNONEMPL date,
    DATCONYEMPL varchar2(50),
    UBIGEMPL varchar2(50),
    ESTEMPL varchar2(50),
    ORIEMPL varchar2(50),
    CODUBI INT,
    CODREN INT,
    CONSTRAINT EMPLEADO_pk PRIMARY KEY (CODEMPL)
) ;

-- Table: ESTUDIOS_BASICOS
CREATE TABLE ESTUDIOS_BASICOS (
    CODBASI INT,
    EDUCBASI varchar2(50),
    CULMIBASI varchar2(50),
    CENTESTBASI varchar2(50),
    DESBASI date,
    HASBASI date,
    ESTBASI varchar2(50),
    CODEMPL INT,
    CONSTRAINT ESTUDIOS_BASICOS_pk PRIMARY KEY (CODBASI)
) ;

-- Table: ESTUDIOS_SUPERIORES
CREATE TABLE ESTUDIOS_SUPERIORES (
    CODSUPER INT,
    EDUSUPER varchar2(50),
    ESPESUPER varchar2(50),
    CENTESTUSUPER varchar2(50),
    DESDSUPER date,
    HASTSUPER date,
    CULMSUPER varchar2(50),
    GRADACADSUPER varchar2(50),
    ESTSUPER varchar2(50),
    CODEMPL INT,
    CONSTRAINT ESTUDIOS_SUPERIORES_pk PRIMARY KEY (CODSUPER)
) ;

-- Table: FAMILIARES
CREATE TABLE FAMILIARES (
    CODFAMI INT,
    NOMFAMI varchar2(100),
    APEFAMI varchar2(100),
    PARFAMI varchar2(50),
    OCUFAMI varchar2(50),
    FECNACFAMI date,
    TELFAMI varchar2(7),
    CELFAMI varchar2(9),
    ESTCIVFAMI varchar2(50),
    VIVEFAMI varchar2(50),
    ESTFAMI varchar2(50),
    CODEMPL INT,
    CONSTRAINT FAMILIARES_pk PRIMARY KEY (CODFAMI)
) ;

-- Table: RENAES
CREATE TABLE RENAES (
    CODREN INT,
    CODUNI char(8),
    CODUBIG char(6),
    CLASIF varchar2(200),
    NOMESTB varchar2(200),
    DEPART varchar2(100),
    DISTRI varchar2(100),
    PROVIN varchar2(100),
    CODEMPL INT,
    CONSTRAINT RENAES_pk PRIMARY KEY (CODREN)
) ;

-- Table: UBIGEO
CREATE TABLE UBIGEO (
    CODUBI INT,
    DEPUBI varchar2(100),
    PROUBI varchar2(100),
    DISUBI varchar2(100),
    CONSTRAINT UBIGEO_pk PRIMARY KEY (CODUBI)
) ;

-- Table: USUARIO
CREATE TABLE USUARIO (
    CODUSU INT,
    USUUSU varchar2(100),
    PWSUSU varchar2(100),
    NOMUSU varchar2(100),
    LEVUSU varchar2(10),
    ESTUSU char(1),
    CONSTRAINT USUARIO_pk PRIMARY KEY (CODUSU)
) ;

-- foreign keys
-- Reference: DIALECTO_DETDIALECTO_CODDIAL (table: DETALLE_DIALECTO)
ALTER TABLE DETALLE_DIALECTO ADD CONSTRAINT DIALECTO_DETDIALECTO_CODDIAL
    FOREIGN KEY (CODDIAL)
    REFERENCES DIALECTO (CODDIAL);

-- Reference: EMPLEADO_DATOS_CODEMPL (table: DATOS)
ALTER TABLE DATOS ADD CONSTRAINT EMPLEADO_DATOS_CODEMPL
    FOREIGN KEY (CODEMPL)
    REFERENCES EMPLEADO (CODEMPL);

-- Reference: EMPLEADO_DETDIALECTO_CODEMPL (table: DETALLE_DIALECTO)
ALTER TABLE DETALLE_DIALECTO ADD CONSTRAINT EMPLEADO_DETDIALECTO_CODEMPL
    FOREIGN KEY (CODEMPL)
    REFERENCES EMPLEADO (CODEMPL);

-- Reference: EMPLEADO_EMERGENCIA_CODEMPL (table: EMERGENCIA)
ALTER TABLE EMERGENCIA ADD CONSTRAINT EMPLEADO_EMERGENCIA_CODEMPL
    FOREIGN KEY (CODEMPL)
    REFERENCES EMPLEADO (CODEMPL);

-- Reference: EMPLEADO_ESTBASICOS_CODEMPL (table: ESTUDIOS_BASICOS)
ALTER TABLE ESTUDIOS_BASICOS ADD CONSTRAINT EMPLEADO_ESTBASICOS_CODEMPL
    FOREIGN KEY (CODEMPL)
    REFERENCES EMPLEADO (CODEMPL);

-- Reference: EMPLEADO_ESTSUPERIORES_CODEMPL (table: ESTUDIOS_SUPERIORES)
ALTER TABLE ESTUDIOS_SUPERIORES ADD CONSTRAINT EMPLEADO_ESTSUPERIORES_CODEMPL
    FOREIGN KEY (CODEMPL)
    REFERENCES EMPLEADO (CODEMPL);

-- Reference: EMPLEADO_FAMILIARES_CODEMPL (table: FAMILIARES)
ALTER TABLE FAMILIARES ADD CONSTRAINT EMPLEADO_FAMILIARES_CODEMPL
    FOREIGN KEY (CODEMPL)
    REFERENCES EMPLEADO (CODEMPL);

-- Reference: EMPLEADO_RENAES_CODEMPL (table: RENAES)
ALTER TABLE RENAES ADD CONSTRAINT EMPLEADO_RENAES_CODEMPL
    FOREIGN KEY (CODEMPL)
    REFERENCES EMPLEADO (CODEMPL);

-- Reference: RENAES_EMPLEADO_CODREN (table: EMPLEADO)
ALTER TABLE EMPLEADO ADD CONSTRAINT RENAES_EMPLEADO_CODREN
    FOREIGN KEY (CODREN)
    REFERENCES RENAES (CODREN);

-- Reference: UBIGEO_EMPLEADO_CODUBI (table: EMPLEADO)
ALTER TABLE EMPLEADO ADD CONSTRAINT UBIGEO_EMPLEADO_CODUBI
    FOREIGN KEY (CODUBI)
    REFERENCES UBIGEO (CODUBI);

-- End of file.
