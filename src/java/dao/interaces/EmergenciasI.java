/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interaces;

import java.util.List;
import modelo.Emergencia;

/**
 *
 * @author JUAN VALERIO
 */
public interface EmergenciasI {

    //Este metodo permite registrar los datos emergentes o cotactos del empleado de un formulario completo
    public void registrarEmergencia(Emergencia eme) throws Exception;

    //Este metodo permite registrar los datos emergentes o contactos del empleado
    public void registrar(Emergencia eme) throws Exception;

    //Este metodo permite listar la canidad de datos emergentes o contactos del emepleado
    public List<Emergencia> listar() throws Exception;

    //Este metodo permite leer el codigo identificador de los datos emergente o contactos del empleado
    public Emergencia leerID(Emergencia eme) throws Exception;

    //Este metodo permite modificar los datos emergentes o contactos del empleado
    public void modificar(Emergencia eme) throws Exception;

    //Este metodo permite eliminar u ocultar los datos emergente o contactos del empleado
    public void eliminar(Emergencia eme) throws Exception;
}
