/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interaces;

import java.util.List;
import modelo.Empleado;

/**
 *
 * @author JUAN VALERIO
 */
public interface EmpleadoI {

    //Este metodo permite registrar los datos del empleado de un formulario
    public void registrarEmpleado(Empleado emp) throws Exception;

    //Este metodo permite registrar los datos del empleado
    public void registrar(Empleado emp) throws Exception;

    //Este metodo permite listar la cantidad de empleados que estan activos
    public List<Empleado> listarActivosNombrados() throws Exception;
    
    //Este metodo permite listar la cantidad de empleados que estan activos
    public List<Empleado> listarActivosCas() throws Exception;
    
    //Este metodo permite listar la cantidad de empleados que estan activos
    
    public List<Empleado> listarActivosCesante() throws Exception;

    //Este metodo permite listar la cantidad de empleados que estan inactivos
    public List<Empleado> listarInactivos() throws Exception;

    //Este metodo permite leer los codigos identificadores de cada mpleado
    public Empleado leerID(String emp) throws Exception;

    //Este metodo permite modificar loa datos registrados del empleado
    public void modificar(Empleado emp) throws Exception;

    //Este metodo permite eliminar los datos del empleado
    public void eliminar(Empleado emp) throws Exception;
}
