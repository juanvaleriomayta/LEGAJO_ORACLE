package modelo;

import lombok.Data;

@Data
public class DetalleDialecto {

    private int idDetDial;
    private String Lee;
    private String Habla;
    private String Escribe;
    private String Estado;
    
    //Empleado
    private String EmpleadoNom;
    private String EmpleadoApel;
    
    //Dialecto
    private String DialectoNom;           

}
