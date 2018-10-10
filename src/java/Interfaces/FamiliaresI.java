/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import modelo.FamiliaresM;

/**
 *
 * @author JUAN VALERIO
 */
public interface FamiliaresI {
    
    //Este metodo sirve para registrar los familiares del empleado del formulario completo
    public void registrarFamiliar(FamiliaresM fam) throws Exception;
    
    //Este metodo sirve para registrar los datos de familiares del empleado
    public void registrar(FamiliaresM fam) throws Exception;
    
    //Este metodo sirve para listra los datos de familiares del empleado
    public List<FamiliaresM> listar() throws Exception;
    
    //Este metodo sirve para leer por codigo identificador de los familiares del empleado
    public FamiliaresM leerID(String fam) throws Exception;
    
    //Este metodo sirve para modificar los datos de familiares del empleado
    public void modificar(FamiliaresM fam) throws Exception;
    
    //Este metodo sirve para eliminar los datos familiares del empleado
    public void eliminar(FamiliaresM fam) throws Exception;
}
