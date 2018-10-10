/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import modelo.EstudiosBasicosM;

/**
 *
 * @author JUAN VALERIO
 */
public interface EstudiosBasicosI {
    
    //Este metodo me premite registrar los datos basicos del empleado de un formulario
     public void registrarEstudiosBasicos(EstudiosBasicosM bas) throws Exception;
     
     //Este metodo me  permite registra los datos basicos del empleado
     public void registrar(EstudiosBasicosM bas) throws Exception;
     
     //Este metodo nos permite listar los datos basicos registrados
     public List<EstudiosBasicosM> listar() throws Exception;
     
     //Este metodo permite leer los codigos identificadores de datos basicos del empleado
     public EstudiosBasicosM leerID(String bas) throws Exception ;
     
     //Este metodo permite modificar los datos basicos del empleado
     public void modificar(EstudiosBasicosM bas) throws Exception;
     
     //Este metodo nos permite eliminar los datos basicos del empleado
     public void eliminar(EstudiosBasicosM bas) throws Exception;
}
