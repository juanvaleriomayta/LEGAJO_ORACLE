/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interaces;

import java.util.List;
import modelo.EstudiosSuperior;

/**
 *
 * @author JUAN VALERIO
 */
public interface EstudiosSuperiorI {
    
    //
    public void registrarEstudiosSuperiores(EstudiosSuperior sup) throws Exception;
    
    //Este metodo sirve para registrar para los datos superiores del empleado
    public void registrar(EstudiosSuperior sup) throws Exception ;
    
    //Este metodo sirve para listar los datos superiores del empleado
    public List<EstudiosSuperior> listar() throws Exception;
    
    //Este metodo sirve para leer el codigo identificador de los datos del empleado
    public EstudiosSuperior leerID(EstudiosSuperior sup) throws Exception;
    
    //Este metodo sirve para modificar los datos superiores del empleado
    public void modificar(EstudiosSuperior sup) throws Exception;
    
    //Este emtodo sirve para eliminar los datos superiores del empleado
    public void eliminar(EstudiosSuperior sup) throws Exception;
}
