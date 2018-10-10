package Interfaces;

import java.util.List;
import modelo.DialectoM;


public interface DialectoI {
    
    
    //Este metodo es para registrar o guardar los datos dialecto
    public void registrar(DialectoM dia) throws Exception;
    
    //Este metodo es para listar todos los datos dialectos
    public List<DialectoM> listar() throws Exception;
    
    //Este metodo es para leer el codigo identificador de los dialectos 
    public DialectoM leerID(DialectoM dia) throws Exception;
    
    //Este metodo sirve para modificar los datos dialecto correspondiente
    public void modificar(DialectoM dia) throws Exception;
    
    //Este metodo se usa para eliminar los datos dialectos que fueroin registrados
    public void eliminar(DialectoM dia) throws Exception;
}
