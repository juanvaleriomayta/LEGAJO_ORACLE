package modelo;

import lombok.Data;

@Data
public class Empleado {

    private int idEmpl;
    private String DNI;
    private String Nom;
    private String ApelPate;
    private String ApelMate;
    private String RUC;
    private String Email;
    private String Telf;
    private String Cel;
    private String FecNac;
    private String GrupSang;
    private String EstCiv;
    private String ConLab;
    private String CarnAseg;
    private String Refe;
    private String Leye;
    private String FecIng;
    private String FecNom;
    private String DatCony;
    private String UbigActu;
    private String UbigOrig;
    private String Est;
    private String ubigeo;
    private String familiares;
    private String emergencia;
    private String estudiosbasicos;
    private String estudiossuperiores;
    
    
    //Distrito
    private String DistritoOrigen;
    private String DistritoActual;
    
}
