package dao.interaces;

import java.util.List;
import modelo.Dialecto;


public interface DialectoI {
    
    
    //Este metodo es para registrar o guardar los datos dialecto
    public void registrar(Dialecto dia) throws Exception;
    
    //Este metodo es para listar todos los datos dialectos
    public List<Dialecto> listar() throws Exception;
    
    //Este metodo es para leer el codigo identificador de los dialectos 
    public Dialecto leerID(Dialecto dia) throws Exception;
    
    //Este metodo sirve para modificar los datos dialecto correspondiente
    public void modificar(Dialecto dia) throws Exception;
    
    //Este metodo se usa para eliminar los datos dialectos que fueroin registrados
    public void eliminar(Dialecto dia) throws Exception;
}
