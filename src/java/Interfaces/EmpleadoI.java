/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import modelo.EmpleadoM;

/**
 *
 * @author JUAN VALERIO
 */
public interface EmpleadoI {

    //Este metodo permite registrar los datos del empleado de un formulario
    public void registrarEmpleado(EmpleadoM emp) throws Exception;

    //Este metodo permite registrar los datos del empleado
  

    //Este metodo permite listar la cantidad de empleados que estan activos
    public List<EmpleadoM> listarActivosNombrados() throws Exception;
    
    //Este metodo permite listar la cantidad de empleados que estan activos
    public List<EmpleadoM> listarActivosCas() throws Exception;
    
    //Este metodo permite listar la cantidad de empleados que estan activos
    
    public List<EmpleadoM> listarActivosCesante() throws Exception;

    //Este metodo permite listar la cantidad de empleados que estan inactivos
    public List<EmpleadoM> listarInactivos() throws Exception;

    //Este metodo permite leer los codigos identificadores de cada mpleado
    public EmpleadoM leerID(String emp) throws Exception;

    //Este metodo permite modificar loa datos registrados del empleado
    public void modificar(EmpleadoM emp) throws Exception;

    //Este metodo permite eliminar los datos del empleado
    public void eliminar(EmpleadoM emp) throws Exception;
}
