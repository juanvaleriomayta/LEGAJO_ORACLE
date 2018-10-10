package modelo;

import lombok.Data;

@Data
public class DetalleDialectoM {

    private String idDetDial;
    private String Lee;
    private String Habla;
    private String Escribe;
    private String Estado;
    
    //Empleado
    private String Empleado;
    private String CodEmpleado;
    
    //Dialecto
    private String Dialecto;
    private String CodDialecto;

}
