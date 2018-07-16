CREATE DATABASE Legajo1
USE Legajo1

-- Table: Datos
CREATE TABLE Datos (
    IdLegajo int IDENTITY(1,1),
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
    idDetDial int IDENTITY(1,1),
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
    IdDial int IDENTITY(1,1),
    NomDial varchar(50)  ,
    CONSTRAINT Dialecto_pk PRIMARY KEY  (IdDial)
);

-- Table: Emergencia
CREATE TABLE Emergencia (
    IdEmerg int IDENTITY(1,1),
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
    idEmpl int IDENTITY(1,1),
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
    Pass varchar(50)  ,
    Ubigeo_CodUbi int  ,
    Familiares_CodContEmp int  ,
    Emergencia_IdEmerg int  ,
    EstudioBasicos_IdEstuBasi int  ,
    EstudiosSuperior_IdEstusuper int  ,
    DetalleDialecto_idDetDial int  ,
    CONSTRAINT Empleado_pk PRIMARY KEY  (idEmpl)
);

-- Table: EstudioBasicos
CREATE TABLE EstudioBasicos (
    IdEstuBasi int IDENTITY(1,1),
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
    IdEstusuper int IDENTITY(1,1),
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
    CodContEmp int IDENTITY(1,1),
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
    CONSTRAINT Familiares_pk PRIMARY KEY  (CodContEmp)
);

-- Table: Ubigeo
CREATE TABLE Ubigeo (
    CodUbi int IDENTITY(1,1),
    Dep varchar(100)  ,
    Pro varchar(100)  ,
    Dis varchar(100)  ,
    CONSTRAINT Ubigeo_pk PRIMARY KEY  (CodUbi)
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

-- Reference: Empleado_DetalleDialecto (table: Empleado)
ALTER TABLE Empleado ADD CONSTRAINT Empleado_DetalleDialecto
    FOREIGN KEY (DetalleDialecto_idDetDial)
    REFERENCES DetalleDialecto (idDetDial);

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
    FOREIGN KEY (Familiares_CodContEmp)
    REFERENCES Familiares (CodContEmp);

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



/*Insercion de datos DetalleDialecto*/
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'SIN FACILIDAD', 'CON FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'SIN FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('SIN FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('SIN FACILIDAD', 'CON FACILIDAD', 'CON FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'CON FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('SIN FACILIDAD', 'SIN FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('SIN FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('SIN FACILIDAD', 'CON FACILIDAD', 'CON FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('SIN FACILIDAD', 'SIN FACILIDAD', 'CON FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'SIN FACILIDAD', 'SIN FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'SIN FACILIDAD', 'CON FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'SIN FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('SIN FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('SIN FACILIDAD', 'CON FACILIDAD', 'CON FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'CON FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('SIN FACILIDAD', 'SIN FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('SIN FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('SIN FACILIDAD', 'CON FACILIDAD', 'CON FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'A');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('SIN FACILIDAD', 'SIN FACILIDAD', 'CON FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'CON FACILIDAD', 'SIN FACILIDAD', 'I');
INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado) VALUES ('CON FACILIDAD', 'SIN FACILIDAD', 'SIN FACILIDAD', 'I');




/*Insercion de dataos Dialecto*/
insert into Dialecto(NomDial) values ('Español');
insert into Dialecto(NomDial) values ('Inglés');
insert into Dialecto(NomDial) values ('Chino mandarín');
insert into Dialecto(NomDial) values ('Francés');
insert into Dialecto(NomDial) values ('Italiano');
insert into Dialecto(NomDial) values ('Portugués');
insert into Dialecto(NomDial) values ('Ruso');
insert into Dialecto(NomDial) values ('Alemán');
insert into Dialecto(NomDial) values ('Japonés');
insert into Dialecto(NomDial) values ('Griego');
insert into Dialecto(NomDial) values ('Coreano');
insert into Dialecto(NomDial) values ('Árabe');
insert into Dialecto(NomDial) values ('Rumano');
insert into Dialecto(NomDial) values ('Hindi-Urdú');
insert into Dialecto(NomDial) values ('Sueco');
insert into Dialecto(NomDial) values ('Neerlandés');
insert into Dialecto(NomDial) values ('Polaco');
insert into Dialecto(NomDial) values ('Servo-Croata');
insert into Dialecto(NomDial) values ('Húngaro');
insert into Dialecto(NomDial) values ('Checo');
insert into Dialecto(NomDial) values ('Búlgaro');
insert into Dialecto(NomDial) values ('Ucraniano');
insert into Dialecto(NomDial) values ('Zulú');
insert into Dialecto(NomDial) values ('Vietnamita');
insert into Dialecto(NomDial) values ('Arabe Saidi');
insert into Dialecto(NomDial) values ('Farsi o Persa');
insert into Dialecto(NomDial) values ('Chino Zhuang');
insert into Dialecto(NomDial) values ('Lombardo');
insert into Dialecto(NomDial) values ('Bengalí');
insert into Dialecto(NomDial) values ('Malayo');
insert into Dialecto(NomDial) values ('Chino Harka');
insert into Dialecto(NomDial) values ('Yoruba');
insert into Dialecto(NomDial) values ('Arabe marroquí');
insert into Dialecto(NomDial) values ('Oromo');
insert into Dialecto(NomDial) values ('Thai');
insert into Dialecto(NomDial) values ('Akan');
insert into Dialecto(NomDial) values ('Arabe mesopotámico');
insert into Dialecto(NomDial) values ('Arabe sanaani');
insert into Dialecto(NomDial) values ('Tagalo');
insert into Dialecto(NomDial) values ('Chino Cantonés-Yue');
insert into Dialecto(NomDial) values ('Haitiano Criollo Francés');
insert into Dialecto(NomDial) values ('Igbo');
insert into Dialecto(NomDial) values ('Chino Gan');
insert into Dialecto(NomDial) values ('Nepalí');
insert into Dialecto(NomDial) values ('Arabe sirio');
insert into Dialecto(NomDial) values ('Arabe egipcio');
insert into Dialecto(NomDial) values ('Tamil');
insert into Dialecto(NomDial) values ('Amharic');
insert into Dialecto(NomDial) values ('Chittaginiano');
insert into Dialecto(NomDial) values ('Belarusano');
insert into Dialecto(NomDial) values ('Rwandés');
insert into Dialecto(NomDial) values ('Arabe sudanés');
insert into Dialecto(NomDial) values ('Malayo-Indonesio');
insert into Dialecto(NomDial) values ('Azerbaiyano');
insert into Dialecto(NomDial) values ('Azerí o Azerbaiyano');
insert into Dialecto(NomDial) values ('Mahahi');
insert into Dialecto(NomDial) values ('Chino Wu');
insert into Dialecto(NomDial) values ('Canarés o Kannada');
insert into Dialecto(NomDial) values ('Javanés');
insert into Dialecto(NomDial) values ('Haryanvi');
insert into Dialecto(NomDial) values ('Telugu');
insert into Dialecto(NomDial) values ('Madura');
insert into Dialecto(NomDial) values ('Kauki');
insert into Dialecto(NomDial) values ('Quechua');
insert into Dialecto(NomDial) values ('Jakaru');




/*Insercion de Datos Emergencias*/
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('JUAN','VALERIO','TIO','0125685','969602596','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('JOSE','ERIO','PRIMO','0125666','965111596','I');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('CLARA','CAMPOS','MAMA','0120685','966202596','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('ANITA','REYES','MAMA','0122285','965292096','I');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('JUAN','VALENZUELA','PRIMO','0965685','953212596','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('MISHEL','VALERIANO','TIA','0100685','960002596','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('DAVID','DE GEA','PRIMO','0125005','965225096','I');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('JUAN','MATA','TIO','0125656','965960596','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('SARA','MAYTA','SOBRINA','0895685','965444596','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('CESAR','ALVAREZ','TIO','0130685','961112596','I');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('JUAN','JESUSI','TIO','0125005','965333596','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('ARIEL','CAHUA','HERMANO','0195685','960002596','I');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('CELESTE','GONZALES','PRIMA','0725685','969852596','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('ROSA','SOTO','SOBRINA','0125695','965298096','I');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('ROMERO','HUAMAN','PRIMO','0128285','965478596','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('MOISES','FERNANDEZ','PRIMO','0133685','969522596','I');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('JOSUE','DE LA CRUZ','HERMANO','0130685','950012596','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('JULIO','SATURNO','HERMANO','0125650','965777596','I');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('KEYLOR','NAVAS','TIO','0125699','965277796','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('LUIS','DE ARAUJO','TIO','0124985','965255596','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('LAR','DE LA RAMA','PRIMO','0129485','960022596','A');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('FLOR','EZIO','HERMANA','0125095','965090596','I');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('CARLOS','SOTOMAYOR','PAPA','0146085','965750596','I');
INSERT INTO Emergencia ( NomEmer, ApeEmer, ParenEmer,TelEmer,CelularEmer,EstadoEmer) VALUES  ('DANES','BALTON','PAPA','0125000','965302596','I');




/*Insercion de Datos Ubigeo*/

INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','ASUNCION');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','BALSAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','CHETO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','CHILIQUIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','CHUQUIBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','GRANADA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','HUANCAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','LA JALCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','LEIMEBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','LEVANTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','MAGDALENA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','MARISCAL CASTILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','MOLINOPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','MONTEVIDEO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','OLLEROS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','QUINJALCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','SAN FRANCISCO DE DAGUAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','SAN ISIDRO DE MAINO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','SOLOCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CHACHAPOYAS','SONCHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BAGUA','LA PECA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BAGUA','ARAMANGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BAGUA','COPALLIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BAGUA','EL PARCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BAGUA','IMAZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BAGUA','BAGUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BONGARA','JUMBILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BONGARA','CHISQUILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BONGARA','CHURUJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BONGARA','COROSHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BONGARA','CUISPES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BONGARA','FLORIDA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BONGARA','JAZAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BONGARA','RECTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BONGARA','SAN CARLOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BONGARA','SHIPASBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BONGARA','VALERA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','BONGARA','YAMBRASBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CONDORCANQUI','NIEVA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CONDORCANQUI','EL CENEPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','CONDORCANQUI','RIO SANTIAGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','LAMUD');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','CAMPORREDONDO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','COCABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','COLCAMAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','CONILA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','INGUILPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','LONGUITA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','LONYA CHICO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','LUYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','LUYA VIEJO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','MARIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','OCALLI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','OCUMAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','PISUQUIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','proIDENCIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','SAN CRISTOBAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','SAN FRANCISCO DEL YESO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','SAN JERONIMO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','SAN JUAN DE LOPECANCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','SANTA CATALINA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','SANTO TOMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','TINGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','LUYA','TRITA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','RODRIGUEZ DE MENDOZA','SAN NICOLAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','RODRIGUEZ DE MENDOZA','CHIRIMOTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','RODRIGUEZ DE MENDOZA','COCHAMAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','RODRIGUEZ DE MENDOZA','HUAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','RODRIGUEZ DE MENDOZA','LIMABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','RODRIGUEZ DE MENDOZA','LONGAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','RODRIGUEZ DE MENDOZA','MARISCAL BENAVIDES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','RODRIGUEZ DE MENDOZA','MILPUC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','RODRIGUEZ DE MENDOZA','OMIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','RODRIGUEZ DE MENDOZA','SANTA ROSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','RODRIGUEZ DE MENDOZA','TOTORA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','RODRIGUEZ DE MENDOZA','VISTA ALEGRE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','UTCUBAMBA','BAGUA GRANDE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','UTCUBAMBA','CAJARURO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','UTCUBAMBA','CUMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','UTCUBAMBA','EL MILAGRO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','UTCUBAMBA','JAMALCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','UTCUBAMBA','LONYA GRANDE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AMAZONAS','UTCUBAMBA','YAMON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARAZ','HUARAZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARAZ','COCHABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARAZ','COLCABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARAZ','HUANCHAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARAZ','INdepENDENCIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARAZ','JANGAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARAZ','LA LIBERTAD');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARAZ','OLLEROS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARAZ','PAMPAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARAZ','PARIACOTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARAZ','PIRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARAZ','TARICA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','AIJA','AIJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','AIJA','CORIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','AIJA','HUACLLAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','AIJA','LA MERCED');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','AIJA','SUCCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','ANTONIO RAYMONDI','LLAMELLIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','ANTONIO RAYMONDI','ACZO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','ANTONIO RAYMONDI','CHACCHO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','ANTONIO RAYMONDI','CHINGAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','ANTONIO RAYMONDI','MIRGAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','ANTONIO RAYMONDI','SAN JUAN DE RONTOY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','ASUNCION','CHACAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','ASUNCION','ACOCHACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','CHIQUIAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','ABELARDO PARDO LEZAMETA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','ANTONIO RAYMONDI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','AQUIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','CAJACAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','CANIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','COLQUIOC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','HUALLANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','HUASTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','HUAYLLACAYAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','LA PRIMAVERA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','MANGAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','PACLLON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','SAN MIGUEL DE CORPANQUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','BOLOGNESI','TICLLOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARHUAZ','CARHUAZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARHUAZ','ACOPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARHUAZ','AMASHCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARHUAZ','ANTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARHUAZ','ATAQUERO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARHUAZ','MARCARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARHUAZ','PARIAHUANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARHUAZ','SAN MIGUEL DE ACO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARHUAZ','SHILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARHUAZ','TINCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARHUAZ','YUNGAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARLOS FERMIN FITZCARRALD','SAN LUIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARLOS FERMIN FITZCARRALD','SAN NICOLAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CARLOS FERMIN FITZCARRALD','YAUYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CASMA','CASMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CASMA','BUENA VISTA ALTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CASMA','COMANDANTE NOEL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CASMA','YAUTAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CORONGO','CORONGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CORONGO','ACO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CORONGO','BAMBAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CORONGO','CUSCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CORONGO','LA PAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CORONGO','YANAC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','CORONGO','YUPAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','HUARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','ANRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','CAJAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','CHAVIN DE HUANTAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','HUACACHI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','HUACCHIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','HUACHIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','HUANTAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','MASIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','PAUCAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','PONTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','RAHUAPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','RAPAYAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','SAN MARCOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','SAN PEDRO DE CHANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARI','UCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARMEY','HUARMEY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARMEY','COCHAPETI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARMEY','CULEBRAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARMEY','HUAYAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUARMEY','MALVAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUAYLAS','CARAZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUAYLAS','HUALLANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUAYLAS','HUATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUAYLAS','HUAYLAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUAYLAS','MATO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUAYLAS','PAMPAROMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUAYLAS','PUEBLO LIBRE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUAYLAS','SANTA CRUZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUAYLAS','SANTO TORIBIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','HUAYLAS','YURACMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','MARISCAL LUZURIAGA','PISCOBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','MARISCAL LUZURIAGA','CASCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','MARISCAL LUZURIAGA','ELEAZAR GUZMAN BARRON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','MARISCAL LUZURIAGA','FIDEL OLIVAS ESCUDERO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','MARISCAL LUZURIAGA','LLAMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','MARISCAL LUZURIAGA','LLUMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','MARISCAL LUZURIAGA','LUCMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','MARISCAL LUZURIAGA','MUSGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','OCROS','OCROS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','OCROS','ACAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','OCROS','CAJAMARQUILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','OCROS','CARHUAPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','OCROS','COCHAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','OCROS','CONGAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','OCROS','LLIPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','OCROS','SAN CRISTOBAL DE RAJAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','OCROS','SAN PEDRO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','OCROS','SANTIAGO DE CHILCAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','PALLASCA','CABANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','PALLASCA','BOLOGNESI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','PALLASCA','CONCHUCOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','PALLASCA','HUACASCHUQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','PALLASCA','HUANDOVAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','PALLASCA','LACABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','PALLASCA','LLAPO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','PALLASCA','PALLASCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','PALLASCA','PAMPAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','PALLASCA','SANTA ROSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','PALLASCA','TAUCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','POMABAMBA','POMABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','POMABAMBA','HUAYLLAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','POMABAMBA','PAROBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','POMABAMBA','QUINUABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','RECUAY','RECUAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','RECUAY','CATAC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','RECUAY','COTAPARACO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','RECUAY','HUAYLLAPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','RECUAY','LLACLLIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','RECUAY','MARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','RECUAY','PAMPAS CHICO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','RECUAY','PARARIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','RECUAY','TAPACOCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','RECUAY','TICAPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SANTA','CHIMBOTE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SANTA','CACERES DEL PERU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SANTA','COISHCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SANTA','MACATE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SANTA','MORO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SANTA','NEPEŅA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SANTA','SAMANCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SANTA','SANTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SANTA','NUEVO CHIMBOTE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SIHUAS','SIHUAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SIHUAS','ACOBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SIHUAS','ALFONSO UGARTE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SIHUAS','CASHAPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SIHUAS','CHINGALPO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SIHUAS','HUAYLLABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SIHUAS','QUICHES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SIHUAS','RAGASH');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SIHUAS','SAN JUAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','SIHUAS','SICSIBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','YUNGAY','YUNGAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','YUNGAY','CASCAPARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','YUNGAY','MANCOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','YUNGAY','MATACOTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','YUNGAY','QUILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','YUNGAY','RANRAHIRCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','YUNGAY','SHUPLUY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ANCASH','YUNGAY','YANAMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ABANCAY','ABANCAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ABANCAY','CHACOCHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ABANCAY','CIRCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ABANCAY','CURAHUASI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ABANCAY','HUANIPACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ABANCAY','LAMBRAMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ABANCAY','PICHIRHUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ABANCAY','SAN PEDRO DE CACHORA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ABANCAY','TAMBURCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','ANDAHUAYLAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','ANDARAPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','CHIARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','HUANCARAMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','HUANCARAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','HUAYANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','KISHUARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','PACOBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','PACUCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','PAMPACHIRI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','POMACOCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','SAN ANTONIO DE CACHI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','SAN JERONIMO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','SAN MIGUEL DE CHACCRAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','SANTA MARIA DE CHICMO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','TALAVERA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','TUMAY HUARACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','TURPO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANDAHUAYLAS','KAQUIABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANTABAMBA','ANTABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANTABAMBA','EL ORO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANTABAMBA','HUAQUIRCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANTABAMBA','JUAN ESPINOZA MEDRANO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANTABAMBA','OROPESA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANTABAMBA','PACHACONAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','ANTABAMBA','SABAINO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','CHALHUANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','CAPAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','CARAYBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','CHAPIMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','COLCABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','COTARUSE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','HUAYLLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','JUSTO APU SAHUARAURA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','LUCRE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','POCOHUANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','SAN JUAN DE CHACŅA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','SAŅAYCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','SORAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','TAPAIRIHUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','TINTAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','TORAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','AYMARAES','YANACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','COTABAMBAS','TAMBOBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','COTABAMBAS','COTABAMBAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','COTABAMBAS','COYLLURQUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','COTABAMBAS','HAQUIRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','COTABAMBAS','MARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','COTABAMBAS','CHALLHUAHUACHO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','CHINCHEROS','CHINCHEROS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','CHINCHEROS','ANCO_HUALLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','CHINCHEROS','COCHARCAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','CHINCHEROS','HUACCANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','CHINCHEROS','OCOBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','CHINCHEROS','ONGOY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','CHINCHEROS','URANMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','CHINCHEROS','RANRACANCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','CHUQUIBAMBILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','CURPAHUASI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','GAMARRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','HUAYLLATI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','MAMARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','MICAELA BASTIDAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','PATAYPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','proGRESO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','SAN ANTONIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','SANTA ROSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','TURPAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','VILCABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','VIRUNDO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('APURIMAC','GRAU','CURASCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','AREQUIPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','ALTO SELVA ALEGRE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','CAYMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','CERRO COLORADO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','CHARACATO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','CHIGUATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','JACOBO HUNTER');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','LA JOYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','MARIANO MELGAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','MIRAFLORES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','MOLLEBAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','PAUCARPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','POCSI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','POLOBAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','QUEQUEŅA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','SABANDIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','SACHACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','SAN JUAN DE SIGUAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','SAN JUAN DE TARUCANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','SANTA ISABEL DE SIGUAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','SANTA RITA DE SIGUAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','SOCABAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','TIABAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','UCHUMAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','VITOR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','YANAHUARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','YARABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','YURA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','AREQUIPA','JOSE LUIS BUSTAMANTE Y RIVERO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAMANA','CAMANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAMANA','JOSE MARIA QUIMPER');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAMANA','MARIANO NICOLAS VALCARCEL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAMANA','MARISCAL CACERES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAMANA','NICOLAS DE PIEROLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAMANA','OCOŅA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAMANA','QUILCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAMANA','SAMUEL PASTOR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','CARAVELI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','ACARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','ATICO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','ATIQUIPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','BELLA UNION');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','CAHUACHO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','CHALA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','CHAPARRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','HUANUHUANU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','JAQUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','LOMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','QUICACHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CARAVELI','YAUCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','APLAO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','ANDAGUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','AYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','CHACHAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','CHILCAYMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','CHOCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','HUANCARQUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','MACHAGUAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','ORCOPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','PAMPACOLCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','TIPAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','UŅON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','URACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CASTILLA','VIRACO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','CHIVAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','ACHOMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','CABANACONDE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','CALLALLI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','CAYLLOMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','COPORAQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','HUAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','HUANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','ICHUPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','LARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','LLUTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','MACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','MADRIGAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','SAN ANTONIO DE CHUCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','SIBAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','TAPAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','TISCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','TUTI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','YANQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CAYLLOMA','MAJES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CONDESUYOS','CHUQUIBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CONDESUYOS','ANDARAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CONDESUYOS','CAYARANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CONDESUYOS','CHICHAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CONDESUYOS','IRAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CONDESUYOS','RIO GRANDE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CONDESUYOS','SALAMANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','CONDESUYOS','YANAQUIHUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','ISLAY','MOLLENDO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','ISLAY','COCACHACRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','ISLAY','DEAN VALDIVIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','ISLAY','ISLAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','ISLAY','MEJIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','ISLAY','PUNTA DE BOMBON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','LA UNION','COTAHUASI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','LA UNION','ALCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','LA UNION','CHARCANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','LA UNION','HUAYNACOTAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','LA UNION','PAMPAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','LA UNION','PUYCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','LA UNION','QUECHUALLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','LA UNION','SAYLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','LA UNION','TAURIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','LA UNION','TOMEPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AREQUIPA','LA UNION','TORO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','AYACUCHO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','ACOCRO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','ACOS VINCHOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','CARMEN ALTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','CHIARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','OCROS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','PACAYCASA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','QUINUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','SAN JOSE DE TICLLAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','SAN JUAN BAUTISTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','SANTIAGO DE PISCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','SOCOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','TAMBILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','VINCHOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUAMANGA','JESUS NAZARENO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','CANGALLO','CANGALLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','CANGALLO','CHUSCHI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','CANGALLO','LOS MOROCHUCOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','CANGALLO','MARIA PARADO DE BELLIDO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','CANGALLO','PARAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','CANGALLO','TOTOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUANCA SANCOS','SANCOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUANCA SANCOS','CARAPO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUANCA SANCOS','SACSAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUANCA SANCOS','SANTIAGO DE LUCANAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUANTA','HUANTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUANTA','AYAHUANCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUANTA','HUAMANGUILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUANTA','IGUAIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUANTA','LURICOCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUANTA','SANTILLANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUANTA','SIVIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','HUANTA','LLOCHEGUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LA MAR','SAN MIGUEL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LA MAR','ANCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LA MAR','AYNA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LA MAR','CHILCAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LA MAR','CHUNGUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LA MAR','LUIS CARRANZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LA MAR','SANTA ROSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LA MAR','TAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','PUQUIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','AUCARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','CABANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','CARMEN SALCEDO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','CHAVIŅA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','CHIPAO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','HUAC-HUAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','LARAMATE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','LEONCIO PRADO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','LLAUTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','LUCANAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','OCAŅA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','OTOCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','SAISA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','SAN CRISTOBAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','SAN JUAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','SAN PEDRO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','SAN PEDRO DE PALCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','SANCOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','SANTA ANA DE HUAYCAHUACHO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','LUCANAS','SANTA LUCIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PARINACOCHAS','CORACORA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PARINACOCHAS','CHUMPI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PARINACOCHAS','CORONEL CASTAŅEDA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PARINACOCHAS','PACAPAUSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PARINACOCHAS','PULLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PARINACOCHAS','PUYUSCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PARINACOCHAS','SAN FRANCISCO DE RAVACAYCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PARINACOCHAS','UPAHUACHO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PAUCAR DEL SARA SARA','PAUSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PAUCAR DEL SARA SARA','COLTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PAUCAR DEL SARA SARA','CORCULLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PAUCAR DEL SARA SARA','LAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PAUCAR DEL SARA SARA','MARCABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PAUCAR DEL SARA SARA','OYOLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PAUCAR DEL SARA SARA','PARARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PAUCAR DEL SARA SARA','SAN JAVIER DE ALPABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PAUCAR DEL SARA SARA','SAN JOSE DE USHUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','PAUCAR DEL SARA SARA','SARA SARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','SUCRE','QUEROBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','SUCRE','BELEN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','SUCRE','CHALCOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','SUCRE','CHILCAYOC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','SUCRE','HUACAŅA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','SUCRE','MORCOLLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','SUCRE','PAICO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','SUCRE','SAN PEDRO DE LARCAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','SUCRE','SAN SALVADOR DE QUIJE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','SUCRE','SANTIAGO DE PAUCARAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','SUCRE','SORAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VICTOR FAJARDO','HUANCAPI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VICTOR FAJARDO','ALCAMENCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VICTOR FAJARDO','APONGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VICTOR FAJARDO','ASQUIPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VICTOR FAFARDO','CANARIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VICTOR FAJARDO','CAYARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VICTOR FAJARDO','COLCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VICTOR FAJARDO','HUAMANQUIQUIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VICTOR FAJARDO','HUANCARAYLLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VICTOR FAJARDO','HUAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VICTOR FAJARDO','SARHUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VICTOR FAJARDO','VILCANCHOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VILCAS HUAMAN','VILCAS HUAMAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VILCAS HUAMAN','ACCOMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VILCAS HUAMAN','CARHUANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VILCAS HUAMAN','CONCEPCION');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VILCAS HUAMAN','HUAMBALPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VILCAS HUAMAN','INdepENDENCIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VILCAS HUAMAN','SAURAMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('AYACUCHO','VILCAS HUAMAN','VISCHONGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJAMARCA','CAJAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJAMARCA','ASUNCION');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJAMARCA','CHETILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJAMARCA','COSPAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJAMARCA','ENCAŅADA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJAMARCA','JESUS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJAMARCA','LLACANORA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJAMARCA','LOS BAŅOS DEL INCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJAMARCA','MAGDALENA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJAMARCA','MATARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJAMARCA','NAMORA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJAMARCA','SAN JUAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJABAMBA','CAJABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJABAMBA','CACHACHI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJABAMBA','CONDEBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CAJABAMBA','SITACOCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CELENDIN','CELENDIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CELENDIN','CHUMUCH');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CELENDIN','CORTEGANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CELENDIN','HUASMIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CELENDIN','JORGE CHAVEZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CELENDIN','JOSE GALVEZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CELENDIN','MIGUEL IGLESIAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CELENDIN','OXAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CELENDIN','SOROCHUCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CELENDIN','SUCRE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CELENDIN','UTCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CELENDIN','LA LIBERTAD DE PALLAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','CHOTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','ANGUIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','CHADIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','CHIGUIRIP');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','CHIMBAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','CHOROPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','COCHABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','CONCHAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','HUAMBOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','LAJAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','LLAMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','MIRACOSTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','PACCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','PION');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','QUEROCOTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','SAN JUAN DE LICUPIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','TACABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','TOCMOCHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CHOTA','CHALAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CONTUMAZA','CONTUMAZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CONTUMAZA','CHILETE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CONTUMAZA','CUPISNIQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CONTUMAZA','GUZMANGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CONTUMAZA','SAN BENITO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CONTUMAZA','SANTA CRUZ DE TOLED');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CONTUMAZA','TANTARICA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CONTUMAZA','YONAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','CUTERVO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','CALLAYUC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','CHOROS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','CUJILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','LA RAMADA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','PIMPINGOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','QUEROCOTILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','SAN ANDRES DE CUTERVO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','SAN JUAN DE CUTERVO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','SAN LUIS DE LUCMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','SANTA CRUZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','SANTO DOMINGO DE LA CAPILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','SANTO TOMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','SOCOTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','CUTERVO','TORIBIO CASANOVA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','HUALGAYOC','BAMBAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','HUALGAYOC','CHUGUR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','HUALGAYOC','HUALGAYOC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','JAEN','JAEN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','JAEN','BELLAVISTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','JAEN','CHONTALI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','JAEN','COLASAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','JAEN','HUABAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','JAEN','LAS PIRIAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','JAEN','POMAHUACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','JAEN','PUCARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','JAEN','SALLIQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','JAEN','SAN FELIPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','JAEN','SAN JOSE DEL ALTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','JAEN','SANTA ROSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN IGNACIO','SAN IGNACIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN IGNACIO','CHIRINOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN IGNACIO','HUARANGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN IGNACIO','LA COIPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN IGNACIO','NAMBALLE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN IGNACIO','SAN JOSE DE LOURDES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN IGNACIO','TABACONAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MARCOS','PEDRO GALVEZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MARCOS','CHANCAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MARCOS','EDUARDO VILLANUEVA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MARCOS','GREGORIO PITA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MARCOS','ICHOCAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MARCOS','JOSE MANUEL QUIROZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MARCOS','JOSE SABOGAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','SAN MIGUEL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','BOLIVAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','CALQUIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','CATILLUC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','EL PRADO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','LA FLORIDA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','LLAPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','NANCHOC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','NIEPOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','SAN GREGORIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','SAN SILVESTRE DE COCHAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','TONGOD');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN MIGUEL','UNION AGUA BLANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN PABLO','SAN PABLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN PABLO','SAN BERNARDINO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN PABLO','SAN LUIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SAN PABLO','TUMBADEN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SANTA CRUZ','SANTA CRUZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SANTA CRUZ','ANDABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SANTA CRUZ','CATACHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SANTA CRUZ','CHANCAYBAŅOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SANTA CRUZ','LA ESPERANZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SANTA CRUZ','NINABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SANTA CRUZ','PULAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SANTA CRUZ','SAUCEPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SANTA CRUZ','SEXI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SANTA CRUZ','UTICYACU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CAJAMARCA','SANTA CRUZ','YAUYUCAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CALLAO','CALLAO','CALLAO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CALLAO','CALLAO','BELLAVISTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CALLAO','CALLAO','CARMEN DE LA LEGUA REYNOSO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CALLAO','CALLAO','LA PERLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CALLAO','CALLAO','LA PUNTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CALLAO','CALLAO','VENTANILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CUSCO','CUSCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CUSCO','CCORCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CUSCO','POROY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CUSCO','SAN JERONIMO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CUSCO','SAN SEBASTIAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CUSCO','SANTIAGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CUSCO','SAYLLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CUSCO','WANCHAQ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ACOMAYO','ACOMAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ACOMAYO','ACOPIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ACOMAYO','ACOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ACOMAYO','MOSOC LLACTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ACOMAYO','POMACANCHI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ACOMAYO','RONDOCAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ACOMAYO','SANGARARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ANTA','ANTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ANTA','ANCAHUASI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ANTA','CACHIMAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ANTA','CHINCHAYPUJIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ANTA','HUAROCONDO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ANTA','LIMATAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ANTA','MOLLEPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ANTA','PUCYURA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ANTA','ZURITE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CALCA','CALCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CALCA','COYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CALCA','LAMAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CALCA','LARES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CALCA','PISAC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CALCA','SAN SALVADOR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CALCA','TARAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CALCA','YANATILE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANAS','YANAOCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANAS','CHECCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANAS','KUNTURKANKI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANAS','LANGUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANAS','LAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANAS','PAMPAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANAS','QUEHUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANAS','TUPAC AMARU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANCHIS','SICUANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANCHIS','CHECACUPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANCHIS','COMBAPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANCHIS','MARANGANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANCHIS','PITUMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANCHIS','SAN PABLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANCHIS','SAN PEDRO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CANCHIS','TINTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CHUMBIVILCAS','SANTO TOMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CHUMBIVILCAS','CAPACMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CHUMBIVILCAS','CHAMACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CHUMBIVILCAS','COLQUEMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CHUMBIVILCAS','LIVITACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CHUMBIVILCAS','LLUSCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CHUMBIVILCAS','QUIŅOTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','CHUMBIVILCAS','VELILLE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ESPINAR','ESPINAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ESPINAR','CONDOROMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ESPINAR','COPORAQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ESPINAR','OCORURO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ESPINAR','PALLPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ESPINAR','PICHIGUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ESPINAR','SUYCKUTAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','ESPINAR','ALTO PICHIGUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','LA CONVENCION','SANTA ANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','LA CONVENCION','ECHARATE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','LA CONVENCION','HUAYOPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','LA CONVENCION','MARANURA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','LA CONVENCION','OCOBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','LA CONVENCION','QUELLOUNO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','LA CONVENCION','KIMBIRI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','LA CONVENCION','SANTA TERESA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','LA CONVENCION','VILCABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','LA CONVENCION','PICHARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PARURO','PARURO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PARURO','ACCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PARURO','CCAPI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PARURO','COLCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PARURO','HUANOQUITE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PARURO','OMACHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PARURO','PACCARITAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PARURO','PILLPINTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PARURO','YAURISQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PAUCARTAMBO','PAUCARTAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PAUCARTAMBO','CAICAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PAUCARTAMBO','CHALLABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PAUCARTAMBO','COLQUEPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PAUCARTAMBO','HUANCARANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','PAUCARTAMBO','KOSŅIPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','QUISPICANCHI','URCOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','QUISPICANCHI','ANDAHUAYLILLAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','QUISPICANCHI','CAMANTI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','QUISPICANCHI','CCARHUAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','QUISPICANCHI','CCATCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','QUISPICANCHI','CUSIPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','QUISPICANCHI','HUARO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','QUISPICANCHI','LUCRE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','QUISPICANCHI','MARCAPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','QUISPICANCHI','OCONGATE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','QUISPICANCHI','OROPESA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','QUISPICANCHI','QUIQUIJANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','URUBAMBA','URUBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','URUBAMBA','CHINCHERO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','URUBAMBA','HUAYLLABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','URUBAMBA','MACHUPICCHU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','URUBAMBA','MARAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','URUBAMBA','OLLANTAYTAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('CUSCO','URUBAMBA','YUCAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','HUANCAVELICA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','ACOBAMBILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','ACORIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','CONAYCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','CUENCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','HUACHOCOLPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','HUAYLLAHUARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','IZCUCHACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','LARIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','MANTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','MARISCAL CACERES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','MOYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','NUEVO OCCORO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','PALCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','PILCHACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','VILCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','YAULI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','ASCENSION');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUANCAVELICA','HUANDO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ACOBAMBA','ACOBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ACOBAMBA','ANDABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ACOBAMBA','ANTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ACOBAMBA','CAJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ACOBAMBA','MARCAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ACOBAMBA','PAUCARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ACOBAMBA','POMACOCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ACOBAMBA','ROSARIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ANGARAES','LIRCAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ANGARAES','ANCHONGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ANGARAES','CALLANMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ANGARAES','CCOCHACCASA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ANGARAES','CHINCHO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ANGARAES','CONGALLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ANGARAES','HUANCA-HUANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ANGARAES','HUAYLLAY GRANDE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ANGARAES','JULCAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ANGARAES','SAN ANTONIO DE ANTAPARCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ANGARAES','SANTO TOMAS DE PATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','ANGARAES','SECCLLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','CASTROVIRREYNA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','ARMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','AURAHUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','CAPILLAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','CHUPAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','COCAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','HUACHOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','HUAMATAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','MOLLEPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','SAN JUAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','SANTA ANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','TANTARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CASTROVIRREYNA','TICRAPO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CHURCAMPA','CHURCAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CHURCAMPA','ANCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CHURCAMPA','CHINCHIHUASI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CHURCAMPA','EL CARMEN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CHURCAMPA','LA MERCED');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CHURCAMPA','LOCROJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CHURCAMPA','PAUCARBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CHURCAMPA','SAN MIGUEL DE MAYOCC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CHURCAMPA','SAN PEDRO DE CORIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','CHURCAMPA','PACHAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','HUAYTARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','AYAVI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','CORDOVA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','HUAYACUNDO ARMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','LARAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','OCOYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','PILPICHACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','QUERCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','QUITO-ARMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','SAN ANTONIO DE CUSICANCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','SAN FRANCISCO DE SANGAYAICO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','SAN ISIDRO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','SANTIAGO DE CHOCORVOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','SANTIAGO DE QUIRAHUARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','SANTO DOMINGO DE CAPILLAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','HUAYTARA','TAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','PAMPAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','ACOSTAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','ACRAQUIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','AHUAYCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','COLCABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','DANIEL HERNANDEZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','HUACHOCOLPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','HUARIBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','ŅAHUIMPUQUIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','PAZOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','QUISHUAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','SALCABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','SALCAHUASI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','SAN MARCOS DE ROCCHAC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','SURCUBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANCAVELICA','TAYACAJA','TINTAY PUNCU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUANUCO','HUANUCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUANUCO','AMARILIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUANUCO','CHINCHAO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUANUCO','CHURUBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUANUCO','MARGOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUANUCO','QUISQUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUANUCO','SAN FRANCISCO DE CAYRAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUANUCO','SAN PEDRO DE CHAULAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUANUCO','SANTA MARIA DEL VALLE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUANUCO','YARUMAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUANUCO','PILLCO MARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','AMBO','AMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','AMBO','CAYNA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','AMBO','COLPAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','AMBO','CONCHAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','AMBO','HUACAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','AMBO','SAN FRANCISCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','AMBO','SAN RAFAEL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','AMBO','TOMAY KICHWA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','DOS DE MAYO','LA UNION');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','DOS DE MAYO','CHUQUIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','DOS DE MAYO','MARIAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','DOS DE MAYO','PACHAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','DOS DE MAYO','QUIVILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','DOS DE MAYO','RIPAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','DOS DE MAYO','SHUNQUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','DOS DE MAYO','SILLAPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','DOS DE MAYO','YANAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUACAYBAMBA','HUACAYBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUACAYBAMBA','CANCHABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUACAYBAMBA','COCHABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUACAYBAMBA','PINRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUAMALIES','LLATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUAMALIES','ARANCAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUAMALIES','CHAVIN DE PARIARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUAMALIES','JACAS GRANDE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUAMALIES','JIRCAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUAMALIES','MIRAFLORES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUAMALIES','MONZON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUAMALIES','PUNCHAO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUAMALIES','PUŅOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUAMALIES','SINGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','HUAMALIES','TANTAMAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LEONCIO PRADO','RUPA-RUPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LEONCIO PRADO','DANIEL ALOMIAS ROBLES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LEONCIO PRADO','HERMILIO VALDIZAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LEONCIO PRADO','JOSE CRESPO Y CASTILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LEONCIO PRADO','LUYANDO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LEONCIO PRADO','MARIANO DAMASO BERAUN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','MARAŅON','HUACRACHUCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','MARAŅON','CHOLON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','MARAŅON','SAN BUENAVENTURA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','PACHITEA','PANAO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','PACHITEA','CHAGLLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','PACHITEA','MOLINO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','PACHITEA','UMARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','PUERTO INCA','PUERTO INCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','PUERTO INCA','CODO DEL POZUZO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','PUERTO INCA','HONORIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','PUERTO INCA','TOURNAVISTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','PUERTO INCA','YUYAPICHIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LAURICOCHA','JESUS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LAURICOCHA','BAŅOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LAURICOCHA','JIVIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LAURICOCHA','QUEROPALCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LAURICOCHA','RONDOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LAURICOCHA','SAN FRANCISCO DE ASIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','LAURICOCHA','SAN MIGUEL DE CAURI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','YAROWILCA','CHAVINILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','YAROWILCA','CAHUAC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','YAROWILCA','CHACABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','YAROWILCA','APARICIO POMARES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','YAROWILCA','JACAS CHICO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','YAROWILCA','OBAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','YAROWILCA','PAMPAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('HUANUCO','YAROWILCA','CHORAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','ICA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','LA TINGUIŅA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','LOS AQUIJES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','OCUCAJE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','PACHACUTEC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','PARCONA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','PUEBLO NUEVO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','SALAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','SAN JOSE DE LOS MOLINOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','SAN JUAN BAUTISTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','SANTIAGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','SUBTANJALLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','TATE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','ICA','YAUCA DEL ROSARIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','CHINCHA','CHINCHA ALTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','CHINCHA','ALTO LARAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','CHINCHA','CHAVIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','CHINCHA','CHINCHA BAJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','CHINCHA','EL CARMEN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','CHINCHA','GROCIO PRADO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','CHINCHA','PUEBLO NUEVO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','CHINCHA','SAN JUAN DE YANAC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','CHINCHA','SAN PEDRO DE HUACARPANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','CHINCHA','SUNAMPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','CHINCHA','TAMBO DE MORA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','NAZCA','NAZCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','NAZCA','CHANGUILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','NAZCA','EL INGENIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','NAZCA','MARCONA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','NAZCA','VISTA ALEGRE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PALPA','PALPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PALPA','LLIPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PALPA','RIO GRANDE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PALPA','SANTA CRUZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PALPA','TIBILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PISCO','PISCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PISCO','HUANCANO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PISCO','HUMAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PISCO','INdepENDENCIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PISCO','PARACAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PISCO','SAN ANDRES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PISCO','SAN CLEMENTE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('ICA','PISCO','TUPAC AMARU INCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','HUANCAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','CARHUACALLANGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','CHACAPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','CHICCHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','CHILCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','CHONGOS ALTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','CHUPURO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','COLCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','CULLHUAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','EL TAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','HUACRAPUQUIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','HUALHUAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','HUANCAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','HUASICANCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','HUAYUCACHI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','INGENIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','PARIAHUANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','PILCOMAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','PUCARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','QUICHUAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','QUILCAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','SAN AGUSTIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','SAN JERONIMO DE TUNAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','SAŅO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','SAPALLANGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','SICAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','SANTO DOMINGO DE ACOBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','HUANCAYO','VIQUES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','CONCEPCION');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','ACO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','ANDAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','CHAMBARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','COCHAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','COMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','HEROINAS TOLEDO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','MANZANARES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','MARISCAL CASTILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','MATAHUASI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','MITO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','NUEVE DE JULIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','ORCOTUNA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','SAN JOSE DE QUERO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CONCEPCION','SANTA ROSA DE OCOPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHANCHAMAYO','CHANCHAMAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHANCHAMAYO','PERENE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHANCHAMAYO','PICHANAQUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHANCHAMAYO','SAN LUIS DE SHUARO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHANCHAMAYO','SAN RAMON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHANCHAMAYO','VITOC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','JAUJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','ACOLLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','APATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','ATAURA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','CANCHAYLLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','CURICACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','EL MANTARO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','HUAMALI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','HUARIPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','HUERTAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','JANJAILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','JULCAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','LEONOR ORDOŅEZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','LLOCLLAPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','MARCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','MASMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','MASMA CHICCHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','MOLINOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','MONOBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','MUQUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','MUQUIYAUYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','PACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','PACCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','PANCAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','PARCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','POMACANCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','RICRAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','SAN LORENZO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','SAN PEDRO DE CHUNAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','SAUSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','SINCOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','TUNAN MARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','YAULI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JAUJA','YAUYOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JUNIN','JUNIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JUNIN','CARHUAMAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JUNIN','ONDORES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','JUNIN','ULCUMAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','SATIPO','SATIPO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','SATIPO','COVIRIALI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','SATIPO','LLAYLLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','SATIPO','MAZAMARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','SATIPO','PAMPA HERMOSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','SATIPO','PANGOA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','SATIPO','RIO NEGRO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','SATIPO','RIO TAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','TARMA','TARMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','TARMA','ACOBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','TARMA','HUARICOLCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','TARMA','HUASAHUASI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','TARMA','LA UNION');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','TARMA','PALCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','TARMA','PALCAMAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','TARMA','SAN PEDRO DE CAJAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','TARMA','TAPO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','YAULI','LA OROYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','YAULI','CHACAPALPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','YAULI','HUAY-HUAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','YAULI','MARCAPOMACOCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','YAULI','MOROCOCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','YAULI','PACCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','YAULI','SANTA BARBARA DE CARHUACAYAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','YAULI','SANTA ROSA DE SACCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','YAULI','SUITUCANCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','YAULI','YAULI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHUPACA','CHUPACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHUPACA','AHUAC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHUPACA','CHONGOS BAJO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHUPACA','HUACHAC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHUPACA','HUAMANCACA CHICO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHUPACA','SAN JUAN DE YSCOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHUPACA','SAN JUAN DE JARPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHUPACA','TRES DE DICIEMBRE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('JUNIN','CHUPACA','YANACANCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','TRUJILLO','TRUJILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','TRUJILLO','EL PORVENIR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','TRUJILLO','FLORENCIA DE MORA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','TRUJILLO','HUANCHACO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','TRUJILLO','LA ESPERANZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','TRUJILLO','LAREDO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','TRUJILLO','MOCHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','TRUJILLO','POROTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','TRUJILLO','SALAVERRY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','TRUJILLO','SIMBAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','TRUJILLO','VICTOR LARCO HERRERA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','ASCOPE','ASCOPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','ASCOPE','CHICAMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','ASCOPE','CHOCOPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','ASCOPE','MAGDALENA DE CAO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','ASCOPE','PAIJAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','ASCOPE','RAZURI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','ASCOPE','SANTIAGO DE CAO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','ASCOPE','CASA GRANDE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','BOLIVAR','BOLIVAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','BOLIVAR','BAMBAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','BOLIVAR','CONDORMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','BOLIVAR','LONGOTEA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','BOLIVAR','UCHUMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','BOLIVAR','UCUNCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','CHEPEN','CHEPEN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','CHEPEN','PACANGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','CHEPEN','PUEBLO NUEVO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','JULCAN','JULCAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','JULCAN','CALAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','JULCAN','CARABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','JULCAN','HUASO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','OTUZCO','OTUZCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','OTUZCO','AGALLPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','OTUZCO','CHARAT');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','OTUZCO','HUARANCHAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','OTUZCO','LA CUESTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','OTUZCO','MACHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','OTUZCO','PARANDAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','OTUZCO','SALPO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','OTUZCO','SINSICAP');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','OTUZCO','USQUIL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PACASMAYO','SAN PEDRO DE LLOC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PACASMAYO','GUADALUPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PACASMAYO','JEQUETEPEQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PACASMAYO','PACASMAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PACASMAYO','SAN JOSE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','TAYABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','BULDIBUYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','CHILLIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','HUANCASPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','HUAYLILLAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','HUAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','ONGON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','PARCOY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','PATAZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','PIAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','SANTIAGO DE CHALLAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','TAURIJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','PATAZ','URPAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANCHEZ CARRION','HUAMACHUCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANCHEZ CARRION','CHUGAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANCHEZ CARRION','COCHORCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANCHEZ CARRION','CURGOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANCHEZ CARRION','MARCABAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANCHEZ CARRION','SANAGORAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANCHEZ CARRION','SARIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANCHEZ CARRION','SARTIMBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANTIAGO DE CHUCO','SANTIAGO DE CHUCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANTIAGO DE CHUCO','ANGASMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANTIAGO DE CHUCO','CACHICADAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANTIAGO DE CHUCO','MOLLEBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANTIAGO DE CHUCO','MOLLEPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANTIAGO DE CHUCO','QUIRUVILCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANTIAGO DE CHUCO','SANTA CRUZ DE CHUCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','SANTIAGO DE CHUCO','SITABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','GRAN CHIMU','CASCAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','GRAN CHIMU','LUCMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','GRAN CHIMU','COMPIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','GRAN CHIMU','SAYAPULLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','VIRU','VIRU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','VIRU','CHAO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LA LIBERTAD','VIRU','GUADALUPITO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','CHICLAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','CHONGOYAPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','ETEN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','ETEN PUERTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','JOSE LEONARDO ORTIZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','LA VICTORIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','LAGUNAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','MONSEFU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','NUEVA ARICA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','OYOTUN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','PICSI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','PIMENTEL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','REQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','SANTA ROSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','SAŅA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','CAYALTI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','PATAPO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','POMALCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','PUCALA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','CHICLAYO','TUMAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','FERREŅAFE','FERREŅAFE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','FERREŅAFE','CAŅARIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','FERREŅAFE','INCAHUASI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','FERREŅAFE','MANUEL ANTONIO MESONES MURO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','FERREŅAFE','PITIPO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','FERREŅAFE','PUEBLO NUEVO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','LAMBAYEQUE','LAMBAYEQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','LAMBAYEQUE','CHOCHOPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','LAMBAYEQUE','ILLIMO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','LAMBAYEQUE','JAYANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','LAMBAYEQUE','MOCHUMI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','LAMBAYEQUE','MORROPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','LAMBAYEQUE','MOTUPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','LAMBAYEQUE','OLMOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','LAMBAYEQUE','PACORA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','LAMBAYEQUE','SALAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','LAMBAYEQUE','SAN JOSE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LAMBAYEQUE','LAMBAYEQUE','TUCUME');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','LIMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','ANCON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','ATE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','BARRANCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','BREŅA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','CARABAYLLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','CHACLACAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','CHORRILLOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','CIENEGUILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','COMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','EL AGUSTINO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','INdepENDENCIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','JESUS MARIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','LA MOLINA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','LA VICTORIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','LINCE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','LOS OLIVOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','LURIGANCHO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','LURIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','MAGDALENA DEL MAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','MAGDALENA VIEJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','MIRAFLORES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','PACHACAMAC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','PUCUSANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','PUENTE PIEDRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','PUNTA HERMOSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','PUNTA NEGRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','RIMAC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SAN BARTOLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SAN BORJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SAN ISIDRO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SAN JUAN DE LURIGANCHO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SAN JUAN DE MIRAFLORES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SAN LUIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SAN MARTIN DE PORRES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SAN MIGUEL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SANTA ANITA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SANTA MARIA DEL MAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SANTA ROSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SANTIAGO DE SURCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','SURQUILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','VILLA EL SALVADOR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','LIMA','VILLA MARIA DEL TRIUNFO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','BARRANCA','BARRANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','BARRANCA','PARAMONGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','BARRANCA','PATIVILCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','BARRANCA','SUPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','BARRANCA','SUPE PUERTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAJATAMBO','CAJATAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAJATAMBO','COPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAJATAMBO','GORGOR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAJATAMBO','HUANCAPON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAJATAMBO','MANAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CANTA','CANTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CANTA','ARAHUAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CANTA','HUAMANTANGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CANTA','HUAROS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CANTA','LACHAQUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CANTA','SAN BUENAVENTURA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CANTA','SANTA ROSA DE QUIVES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','SAN VICENTE DE CAŅETE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','ASIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','CALANGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','CERRO AZUL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','CHILCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','COAYLLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','IMPERIAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','LUNAHUANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','MALA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','NUEVO IMPERIAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','PACARAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','QUILMANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','SAN ANTONIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','SAN LUIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','SANTA CRUZ DE FLORES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','CAŅETE','ZUŅIGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUARAL','HUARAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUARAL','ATAVILLOS ALTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUARAL','ATAVILLOS BAJO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUARAL','AUCALLAMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUARAL','CHANCAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUARAL','IHUARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUARAL','LAMPIAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUARAL','PACARAOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUARAL','SAN MIGUEL DE ACOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUARAL','SANTA CRUZ DE ANDAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUARAL','SUMBILCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUARAL','VEINTISIETE DE NOVIEMBRE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','MATUCANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','ANTIOQUIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','CALLAHUANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','CARAMPOMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','CHICLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','CUENCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','HUACHUPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','HUANZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','HUAROCHIRI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','LAHUAYTAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','LANGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','LARAOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','MARIATANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','RICARDO PALMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SAN ANDRES DE TUPICOCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SAN ANTONIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SAN BARTOLOME');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SAN DAMIAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SAN JUAN DE IRIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SAN JUAN DE TANTARANCHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SAN LORENZO DE QUINTI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SAN MATEO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SAN MATEO DE OTAO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SAN PEDRO DE CASTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SAN PEDRO DE HUANCAYRE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SANGALLAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SANTA CRUZ DE COCACHACRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SANTA EULALIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SANTIAGO DE ANCHUCAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SANTIAGO DE TUNA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SANTO DOMINGO DE LOS OLLEROS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAROCHIRI','SURCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAURA','HUACHO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAURA','AMBAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAURA','CALETA DE CARQUIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAURA','CHECRAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAURA','HUALMAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAURA','HUAURA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAURA','LEONCIO PRADO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAURA','PACCHO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAURA','SANTA LEONOR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAURA','SANTA MARIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAURA','SAYAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','HUAURA','VEGUETA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','OYON','OYON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','OYON','ANDAJES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','OYON','CAUJUL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','OYON','COCHAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','OYON','NAVAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','OYON','PACHANGARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','YAUYOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','ALIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','AYAUCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','AYAVIRI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','AZANGARO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','CACRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','CARANIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','CATAHUASI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','CHOCOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','COCHAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','COLONIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','HONGOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','HUAMPARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','HUANCAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','HUANGASCAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','HUANTAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','HUAŅEC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','LARAOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','LINCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','MADEAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','MIRAFLORES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','OMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','PUTINZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','QUINCHES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','QUINOCAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','SAN JOAQUIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','SAN PEDRO DE PILAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','TANTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','TAURIPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','TOMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','TUPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','VIŅAC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LIMA','YAUYOS','VITIS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','IQUITOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','ALTO NANAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','FERNANDO LORES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','INDIANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','LAS AMAZONAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','MAZAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','NAPO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','PUNCHANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','PUTUMAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','TORRES CAUSANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','BELEN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','SAN JUAN BAUTISTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MAYNAS','TENIENTE MANUEL CLAVERO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','ALTO AMAZONAS','YURIMAGUAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','ALTO AMAZONAS','BALSAPUERTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','ALTO AMAZONAS','JEBEROS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','ALTO AMAZONAS','LAGUNAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','ALTO AMAZONAS','SANTA CRUZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','ALTO AMAZONAS','TENIENTE CESAR LOPEZ ROJAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','LORETO','NAUTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','LORETO','PARINARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','LORETO','TIGRE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','LORETO','TROMPETEROS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','LORETO','URARINAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MARISCAL RAMON CASTILLA','RAMON CASTILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MARISCAL RAMON CASTILLA','PEBAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MARISCAL RAMON CASTILLA','YAVARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','MARISCAL RAMON CASTILLA','SAN PABLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','REQUENA','REQUENA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','REQUENA','ALTO TAPICHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','REQUENA','CAPELO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','REQUENA','EMILIO SAN MARTIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','REQUENA','MAQUIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','REQUENA','PUINAHUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','REQUENA','SAQUENA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','REQUENA','SOPLIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','REQUENA','TAPICHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','REQUENA','JENARO HERRERA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','REQUENA','YAQUERANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','UCAYALI','CONTAMANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','UCAYALI','INAHUAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','UCAYALI','PADRE MARQUEZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','UCAYALI','PAMPA HERMOSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','UCAYALI','SARAYACU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','UCAYALI','VARGAS GUERRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','DATEM DEL MARAŅON','BARRANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','DATEM DEL MARAŅON','CAHUAPANAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','DATEM DEL MARAŅON','MANSERICHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','DATEM DEL MARAŅON','MORONA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','DATEM DEL MARAŅON','PASTAZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('LORETO','DATEM DEL MARAŅON','ANDOAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MADRE DE DIOS','TAMBOPATA','TAMBOPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MADRE DE DIOS','TAMBOPATA','INAMBARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MADRE DE DIOS','TAMBOPATA','LAS PIEDRAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MADRE DE DIOS','TAMBOPATA','LABERINTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MADRE DE DIOS','MANU','MANU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MADRE DE DIOS','MANU','FITZCARRALD');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MADRE DE DIOS','MANU','MADRE DE DIOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MADRE DE DIOS','MANU','HUEPETUHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MADRE DE DIOS','TAHUAMANU','IŅAPARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MADRE DE DIOS','TAHUAMANU','IBERIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MADRE DE DIOS','TAHUAMANU','TAHUAMANU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','MARISCAL NIETO','MOQUEGUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','MARISCAL NIETO','CARUMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','MARISCAL NIETO','CUCHUMBAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','MARISCAL NIETO','SAMEGUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','MARISCAL NIETO','SAN CRISTOBAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','MARISCAL NIETO','TORATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','GENERAL SANCHEZ CERRO','OMATE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','GENERAL SANCHEZ CERRO','CHOJATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','GENERAL SANCHEZ CERRO','COALAQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','GENERAL SANCHEZ CERRO','ICHUŅA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','GENERAL SANCHEZ CERRO','LA CAPILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','GENERAL SANCHEZ CERRO','LLOQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','GENERAL SANCHEZ CERRO','MATALAQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','GENERAL SANCHEZ CERRO','PUQUINA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','GENERAL SANCHEZ CERRO','QUINISTAQUILLAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','GENERAL SANCHEZ CERRO','UBINAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','GENERAL SANCHEZ CERRO','YUNGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','ILO','ILO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','ILO','EL ALGARROBAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('MOQUEGUA','ILO','PACOCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','CHAUPIMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','HUACHON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','HUARIACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','HUAYLLAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','NINACACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','PALLANCHACRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','PAUCARTAMBO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','SAN FRANCISCO DE ASIS DE YARUSYACAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','SIMON BOLIVAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','TICLACAYAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','TINYAHUARCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','VICCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','PASCO','YANACANCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','DANIEL ALCIDES CARRION','YANAHUANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','DANIEL ALCIDES CARRION','CHACAYAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','DANIEL ALCIDES CARRION','GOYLLARISQUIZGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','DANIEL ALCIDES CARRION','PAUCAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','DANIEL ALCIDES CARRION','SAN PEDRO DE PILLAO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','DANIEL ALCIDES CARRION','SANTA ANA DE TUSI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','DANIEL ALCIDES CARRION','TAPUC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','DANIEL ALCIDES CARRION','VILCABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','OXAPAMPA','OXAPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','OXAPAMPA','CHONTABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','OXAPAMPA','HUANCABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','OXAPAMPA','PALCAZU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','OXAPAMPA','POZUZO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','OXAPAMPA','PUERTO BERMUDEZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PASCO','OXAPAMPA','VILLA RICA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PIURA','PIURA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PIURA','CASTILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PIURA','CATACAOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PIURA','CURA MORI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PIURA','EL TALLAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PIURA','LA ARENA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PUIRA','LA UNION');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PIURA','LAS LOMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PIURA','TAMBO GRANDE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','AYABACA','AYABACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','AYABACA','FRIAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','AYABACA','JILILI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','AYABACA','LAGUNAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','AYABACA','MONTERO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','AYABACA','PACAIPAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','AYABACA','PAIMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','AYABACA','SAPILLICA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','AYABACA','SICCHEZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','AYABACA','SUYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','HUANCABAMBA','HUANCABAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','HUANCABAMBA','CANCHAQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','HUANCABAMBA','EL CARMEN DE LA FRONTERA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','HUANCABAMBA','HUARMACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','HUANCABAMBA','LALAQUIZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','HUANCABAMBA','SAN MIGUEL DE EL FAIQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','HUANCABAMBA','SONDOR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','HUANCABAMBA','SONDORILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','MORROPON','CHULUCANAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','MORROPON','BUENOS AIRES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','MORROPON','CHALACO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','MORROPON','LA MATANZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','MORROPON','MORROPON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','MORROPON','SALITRAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','MORROPON','SAN JUAN DE BIGOTE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','MORROPON','SANTA CATALINA DE MOSSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','MORROPON','SANTO DOMINGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','MORROPON','YAMANGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PAITA','PAITA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PAITA','AMOTAPE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PAITA','ARENAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PAITA','COLAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PAITA','LA HUACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PAITA','TAMARINDO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','PAITA','VICHAYAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SULLANA','SULLANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SULLANA','BELLAVISTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SULLANA','IGNACIO ESCUDERO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SULLANA','LANCONES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SULLANA','MARCAVELICA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SULLANA','MIGUEL CHECA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SULLANA','QUERECOTILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SULLANA','SALITRAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','TALARA','PARIŅAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','TALARA','EL ALTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','TALARA','LA BREA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','TALARA','LOBITOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','TALARA','LOS ORGANOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','TALARA','MANCORA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SECHURA','SECHURA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SECHURA','BELLAVISTA DE LA UNION');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SECHURA','BERNAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SECHURA','CRISTO NOS VALGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SECHURA','VICE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PIURA','SECHURA','RINCONADA LLICUAR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','PUNO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','ACORA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','AMANTANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','ATUNCOLLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','CAPACHICA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','CHUCUITO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','COATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','HUATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','MAŅAZO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','PAUCARCOLLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','PICHACANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','PLATERIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','SAN ANTONIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','TIQUILLACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','PUNO','VILQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','AZANGARO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','ACHAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','ARAPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','ASILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','CAMINACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','CHUPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','JOSE DOMINGO CHOQUEHUANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','MUŅANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','POTONI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','SAMAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','SAN ANTON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','SAN JOSE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','SAN JUAN DE SALINAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','SANTIAGO DE PUPUJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','AZANGARO','TIRAPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CARABAYA','MACUSANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CARABAYA','AJOYANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CARABAYA','AYAPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CARABAYA','COASA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CARABAYA','CORANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CARABAYA','CRUCERO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CARABAYA','ITUATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CARABAYA','OLLACHEA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CARABAYA','SAN GABAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CARABAYA','USICAYOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CHUCUITO','JULI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CHUCUITO','DESAGUADERO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CHUCUITO','HUACULLANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CHUCUITO','KELLUYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CHUCUITO','PISACOMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CHUCUITO','POMATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','CHUCUITO','ZEPITA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','EL COLLAO','ILAVE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','EL COLLAO','CAPAZO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','EL COLLAO','PILCUYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','EL COLLAO','SANTA ROSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','EL COLLAO','CONDURIRI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','HUANCANE','HUANCANE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','HUANCANE','COJATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','HUANCANE','HUATASANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','HUANCANE','INCHUPALLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','HUANCANE','PUSI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','HUANCANE','ROSASPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','HUANCANE','TARACO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','HUANCANE','VILQUE CHICO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','LAMPA','LAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','LAMPA','CABANILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','LAMPA','CALAPUJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','LAMPA','NICASIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','LAMPA','OCUVIRI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','LAMPA','PALCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','LAMPA','PARATIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','LAMPA','PUCARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','LAMPA','SANTA LUCIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','LAMPA','VILAVILA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MELGAR','AYAVIRI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MELGAR','ANTAUTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MELGAR','CUPI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MELGAR','LLALLI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MELGAR','MACARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MELGAR','NUŅOA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MELGAR','ORURILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MELGAR','SANTA ROSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MELGAR','UMACHIRI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MOHO','MOHO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MOHO','CONIMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MOHO','HUAYRAPATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','MOHO','TILALI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SAN ANTONIO DE PUTINA','PUTINA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SAN ANTONIO DE PUTINA','ANANEA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SAN ANTONIO DE PUTINA','PEDRO VILCA APAZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SAN ANTONIO DE PUTINA','QUILCAPUNCU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SAN ANTONIO DE PUTINA','SINA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SAN ROMAN','JULIACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SAN ROMAN','CABANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SAN ROMAN','CABANILLAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SAN ROMAN','CARACOTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SANDIA','SANDIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SANDIA','CUYOCUYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SANDIA','LIMBANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SANDIA','PATAMBUCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SANDIA','PHARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SANDIA','QUIACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SANDIA','SAN JUAN DEL ORO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SANDIA','YANAHUAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SANDIA','ALTO INAMBARI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','SANDIA','SAN PEDRO DE PUTINA PUNCO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','YUNGUYO','YUNGUYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','YUNGUYO','ANAPIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','YUNGUYO','COPANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','YUNGUYO','CUTURAPI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','YUNGUYO','OLLARAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','YUNGUYO','TINICACHI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('PUNO','YUNGUYO','UNICACHI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','MOYOBAMBA','MOYOBAMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','MOYOBAMBA','CALZADA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','MOYOBAMBA','HABANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','MOYOBAMBA','JEPELACIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','MOYOBAMBA','SORITOR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','MOYOBAMBA','YANTALO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','BELLAVISTA','BELLAVISTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','BELLAVISTA','ALTO BIAVO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','BELLAVISTA','BAJO BIAVO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','BELLAVISTA','HUALLAGA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','BELLAVISTA','SAN PABLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','BELLAVISTA','SAN RAFAEL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','EL DORADO','SAN JOSE DE SISA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','EL DORADO','AGUA BLANCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','EL DORADO','SAN MARTIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','EL DORADO','SANTA ROSA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','EL DORADO','SHATOJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','HUALLAGA','SAPOSOA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','HUALLAGA','ALTO SAPOSOA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','HUALLAGA','EL ESLABON');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','HUALLAGA','PISCOYACU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','HUALLAGA','SACANCHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','HUALLAGA','TINGO DE SAPOSOA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','LAMAS','LAMAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','LAMAS','ALONSO DE ALVARADO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','LAMAS','BARRANQUITA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','LAMAS','CAYNARACHI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','LAMAS','CUŅUMBUQUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','LAMAS','PINTO RECODO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','LAMAS','RUMISAPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','LAMAS','SAN ROQUE DE CUMBAZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','LAMAS','SHANAO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','LAMAS','TABALOSOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','LAMAS','ZAPATERO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','MARISCAL CACERES','JUANJUI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','MARISCAL CACERES','CAMPANILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','MARISCAL CACERES','HUICUNGO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','MARISCAL CACERES','PACHIZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','MARISCAL CACERES','PAJARILLO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','PICOTA','PICOTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','PICOTA','BUENOS AIRES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','PICOTA','CASPISAPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','PICOTA','PILLUANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','PICOTA','PUCACACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','PICOTA','SAN CRISTOBAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','PICOTA','SAN HILARION');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','PICOTA','SHAMBOYACU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','PICOTA','TINGO DE PONASA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','PICOTA','TRES UNIDOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','RIOJA','RIOJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','RIOJA','AWAJUN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','RIOJA','ELIAS SOPLIN VARGAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','RIOJA','NUEVA CAJAMARCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','RIOJA','PARDO MIGUEL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','RIOJA','POSIC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','RIOJA','SAN FERNANDO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','RIOJA','YORONGOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','RIOJA','YURACYACU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','TARAPOTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','ALBERTO LEVEAU');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','CACATACHI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','CHAZUTA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','CHIPURANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','EL PORVENIR');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','HUIMBAYOC');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','JUAN GUERRA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','LA BANDA DE SHILCAYO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','MORALES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','PAPAPLAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','SAN ANTONIO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','SAUCE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','SAN MARTIN','SHAPAJA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','TOCACHE','TOCACHE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','TOCACHE','NUEVO proGRESO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','TOCACHE','POLVORA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','TOCACHE','SHUNTE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('SAN MARTIN','TOCACHE','UCHIZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TACNA','TACNA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TACNA','ALTO DE LA ALIANZA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TACNA','CALANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TACNA','CIUDAD NUEVA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TACNA','INCLAN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TACNA','PACHIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TACNA','PALCA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TACNA','POCOLLAY');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TACNA','SAMA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TACNA','CORONEL GREGORIO ALBARRACIN LANCHIPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','CANDARAVE','CANDARAVE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','CANDARAVE','CAIRANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','CANDARAVE','CAMILACA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','CANDARAVE','CURIBAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','CANDARAVE','HUANUARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','CANDARAVE','QUILAHUANI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','JORGE BASADRE','LOCUMBA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','JORGE BASADRE','ILABAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','JORGE BASADRE','ITE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TARATA','TARATA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TARATA','HEROES ALBARRACIN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TARATA','ESTIQUE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TARATA','ESTIQUE-PAMPA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TARATA','SITAJARA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TARATA','SUSAPAYA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TARATA','TARUCACHI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TACNA','TARATA','TICACO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','TUMBES','TUMBES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','TUMBES','CORRALES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','TUMBES','LA CRUZ');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','TUMBES','PAMPAS DE HOSPITAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','TUMBES','SAN JACINTO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','TUMBES','SAN JUAN DE LA VIRGEN');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','CONTRALMIRANTE VILLAR','ZORRITOS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','CONTRALMIRANTE VILLAR','CASITAS');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','CONTRALMIRANTE VILLAR','CANOAS DE PUNTA SAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','ZARUMILLA','ZARUMILLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','ZARUMILLA','AGUAS VERDES');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','ZARUMILLA','MATAPALO');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('TUMBES','ZARUMILLA','PAPAYAL');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','CORONEL PORTILLO','CALLERIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','CORONEL PORTILLO','CAMPOVERDE');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','CORONEL PORTILLO','IPARIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','CORONEL PORTILLO','MASISEA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','CORONEL PORTILLO','YARINACOCHA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','CORONEL PORTILLO','NUEVA REQUENA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','ATALAYA','RAYMONDI');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','ATALAYA','SEPAHUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','ATALAYA','TAHUANIA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','ATALAYA','YURUA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','PADRE ABAD','PADRE ABAD');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','PADRE ABAD','IRAZOLA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','PADRE ABAD','CURIMANA');
INSERT INTO Ubigeo ( dep, pro, dis) VALUES  ('UCAYALI','PURUS','PURUS');







/*Insercion de Datos EstudioBasicos*/
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('P','I','SEPULVEDA DE MENORES','12/12/2000','12/12/2005','I');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('P','C','JOSE BUENAVENTURA SEPULVEDA','12/12/2000','12/12/2005','A');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('P','I','EGUREN','05-05-2000','12/12/2005','A');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('S','C','CENTRO DE MUJERES','02/08/2001','02/05/2013','I');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('S','I','SANTA RITA DE CASSIA','01/04/1995','12/03/2000','A');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('S','C','REPUBLICA DE CHILE','03/05/2000','12/12/2005','I');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('P','I','VALDIVIA','08/09/1980','12/12/1985','I');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('S','C','VALDIVIA','12/12/2000','12/06/2004','A');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('P','I','JOSE BUENAVENTURA SEPULVEDA','12/12/2000','12/12/2005','A');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('P','C','BONIFATTI','12/12/2000','12/10/2005','I');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('P','C','VALDIVIA','12/12/1990','12/12/1995','A');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('S','I','CENTRO DE VARONES','12/12/2004','12/12/2009','A');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('S','I','COLEGIO LA CONCEPCION','12/06/1999','12/12/2009','A');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('P','C','JOSE BUENAVENTURA SEPULVEDA','12/12/2000','12/12/2005','A');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('P','C','COLEGIO LA CONCEPCION','12/12/2000','12/12/2005','I');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('P','I','SEPULVEDA DE MENORES','05/11/2000','12/12/2005','I');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('S','I','JOSE BUENAVENTURA SEPULVEDA','12/12/2000','12/12/2005','A');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('P','C','COLEGIO LA CONCEPCION','05/02/2004','12/12/2005','A');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('P','I','SEPULVEDA DE MENORES','12/12/2000','12/12/2005','I');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('S','I','CENTRO DE VARONES','12/12/1969','12/12/1974','A');
INSERT INTO EstudioBasicos ( EducBasi, CulmiBasi, CentrEstuBasi,DesdBasi,HasBasi,EstadoBasi) VALUES  ('S','C','CENTRO DE VARONES','05/12/2004','12/10/2009','I');





/*Insercion de Datos EstudiosSuperior*/
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('PINST. SUPERIOR','DERECHO','UNIVERSIDAD DEL CALLAO','12/12/1971','12/12/1976','ESTUDIANTE','A');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('UNIVERSITARIOS','CONTABILIDAD','UNIVERSIDAD DEL CALLAO','12/12/2000','12/12/2005','EGRESADO','A');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('ESPECIALISTA','SECRETARIA','UNIVERSIDAD DE HUACHO','12/12/1960','12/12/1966','BACHILLER','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('SUBESPECIALIDAD','ADMINISTRACION','UNIVERSIDAD DEL CAÑETE','12/12/2000','12/12/2005','TITULADO','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('MAESTRIA','DOCTORA','UNIVERSIDAD DE ICA','12/12/2000','12/12/2005','BACHILLER','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('DOCTORADO','ADMINISTRACION','UNIVERSIDAD DE ICA','12/12/2000','12/12/2005','EGRESADO','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('DOCTORADO','DOCTORA','UNIVERSIDAD DEL CALLAO','12/12/1955','12/12/1960','BACHILLER','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('PINST. SUPERIOR','DERECHO','UNIVERSIDAD DE HUACHO','12/12/2000','12/12/2005','ESTUDIANTE','A');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('PINST. SUPERIOR','DOCTORA','U NACIONAL MAYOR DE SAN MARCOS','12/12/2000','12/12/2005','BACHILLER','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('MAESTRIA','CONTABILIDAD','CONDORAY','12/12/1960','12/12/1965','ESTUDIANTE','A');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('SUBESPECIALIDAD','DOCTORA','UNI','12/12/2000','12/12/2005','TITULADO','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('PINST. SUPERIOR','DERECHO','UNIVERSIDAD DEL CALLAO','12/12/2000','12/12/2005','TITULADO','A');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('DOCTORADO','DERECHO','UNIVERSIDAD DEL CALLAO','12/12/2000','12/12/2005','ESTUDIANTE','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('PINST. SUPERIOR','DERECHO','UNIVERSIDAD DE LIMA','12/12/2000','12/12/2005','ESTUDIANTE','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('PINST. SUPERIOR','DERECHO','UNIVERSIDAD DE ICA','12/12/2000','12/12/2005','EGRESADO','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('MAESTRIA','CONTABILIDAD','UNIVERSIDAD DE HUACHO','12/12/2000','12/12/2005','EGRESADO','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('PINST. SUPERIOR','DERECHO','UNIVERSIDAD DEL CAÑETE','12/12/2000','12/12/2005','TITULADO','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('UNIVERSITARIOS','DOCTORA','U NACIONAL MAYOR DE SAN MARCOS','12/12/2000','12/12/2005','TITULADO','A');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('MAESTRIA','SECRETARIA','VILLARREAL','12/12/1966','12/12/1971','ESTUDIANTE','A');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('DOCTORADO','DERECHO','UNIVERSIDAD DE LIMA','12/12/2000','12/12/2005','BACHILLER','A');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('SUBESPECIALIDAD','DERECHO','UNIVERSIDAD DEL CALLAO','12/12/2000','12/12/2005','BACHILLER','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('DOCTORADO','CONTABILIDAD','UNIVERSIDAD DE ICA','12/12/2000','12/12/2005','BACHILLER','A');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('ESPECIALISTA','ADMINISTRACION','UNI','12/12/2000','12/12/2005','TITULADO','I');
INSERT INTO EstudiosSuperior ( EduSuper, EspeSuper, CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,GradAcadObte,EstadoSuper) VALUES  ('ESPECIALISTA','CONTABILIDAD','UNI','12/12/2000','12/12/2005','EGRESADO','A');





/*Insercion de Datos Familiares*/
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('CARLA','SANCHEZ','HERMANA','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('DIANA','SANCHEZ','HERMANA','SECRETARIA','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('ANGGELO','CANDELA','TIO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('AUGUSTO','CARLENS','PRIMO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('PATRICIA','PEREZ','MAMA','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('ANDREA','SOLIS','PRIMA','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('EUGENIO','DAMAZO','PADRASTRO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('PANTERA','GORRO','TIO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('PERLA','CENTENO','TIA','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('CARMELA','APOYALA','HERMANA','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('PEDRO','PEDRALEZ','PRIMO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('JUAN','VICENTE','PRIMO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('MARIO','DIMARIA','PRIMO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('GIGI','DUSSUOLO','HERMANA','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('SCARLETH','VIVEZ','HERMANA','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('MARIA','DE LAS NIEVES','HERMANA','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('WILLIAN','ROBINS','TIO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('SARA','SOTELO','HERMANA','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('PARTAEL','CARLOSA','TIO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('MARICARMEN','MARIN','HERMANA','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('CESAR','DILVEREZ','TIO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('JESUS','CANALETAS','PADRASTRO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('JAROL','JESUSI','PADRASTRO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('LALO','NAPAN','HERMANA','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');
INSERT INTO Familiares ( NomFami, ApelFami, ParFami,OcuFami,FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami) VALUES  ('RAFAEL','PERALTA','HERMANO','ADMINISTRADOR','12/12/1979','0236589','CASADO','CON FACILIDAD','A');

-- Consultas
select * from Familiares
select * from Emergencia
select * from Datos
select * from DetalleDialecto
select * from Dialecto
select * from Empleado
select * from EstudioBasicos
select * from Ubigeo
-- End of file.

