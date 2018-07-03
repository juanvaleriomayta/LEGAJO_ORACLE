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
    private String Est;
          
    //Familiares
    private String FamiliaresNom;
    private String FamiliaresApe;
    
    //Emergencia
    private String EmergenciaNom;
    private String EmergenciaApe;
    
    //Estudios basicos
    private String EstuBasiEducacion;
    private String EstuBasiCentroEstudos;
    
    //Estudios Superiores
    private String EstuSuperEducacion;
    private String EstuSuperCentroEstudios;
    
    //Distrito
    private String LugarNacimineto;
    private String Direccion;
        
}
