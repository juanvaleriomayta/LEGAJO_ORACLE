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

    //Este metodo permite listra la cantidad de datos del empleado registrados
    public List<Empleado> listar() throws Exception;

    //Este metodo permite leer los codigos identificadores de cada mpleado
    public Empleado leerID(Empleado emp) throws Exception;

    //Este metodo permite modificar loa datos registrados del empleado
    public void modificar(Empleado emp) throws Exception;

    //Este metodo permite eliminar los datos del empleado
    public void eliminar(Empleado emp) throws Exception;
}
