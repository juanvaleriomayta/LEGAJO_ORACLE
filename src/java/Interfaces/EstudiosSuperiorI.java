/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import modelo.EstudiosSuperiorM;

/**
 *
 * @author JUAN VALERIO
 */
public interface EstudiosSuperiorI {
    
    //
    public void registrarEstudiosSuperiores(EstudiosSuperiorM sup) throws Exception;
    
    //Este metodo sirve para registrar para los datos superiores del empleado
    public void registrar(EstudiosSuperiorM sup) throws Exception ;
    
    //Este metodo sirve para listar los datos superiores del empleado
    public List<EstudiosSuperiorM> listar() throws Exception;
    
    //Este metodo sirve para leer el codigo identificador de los datos del empleado
    public EstudiosSuperiorM leerID(String sup) throws Exception;
    
    //Este metodo sirve para modificar los datos superiores del empleado
    public void modificar(EstudiosSuperiorM sup) throws Exception;
    
    //Este emtodo sirve para eliminar los datos superiores del empleado
    public void eliminar(EstudiosSuperiorM sup) throws Exception;
    
    //Este metodo sirve para listar todos los inactivos
    public List<EstudiosSuperiorM> listarInactivos() throws Exception ;
}
