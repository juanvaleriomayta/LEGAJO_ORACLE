package dao.interaces;

import java.sql.SQLException;
import java.util.List;
import modelo.Ubigeo;

public interface UbigeoI {

    //Metodo para poder convertir el Nombre del automcomplete en su codigo
    public String obtenerCodigoUbigeo(String Ubigeo) throws SQLException;

    //Lista las coincidencias del automcomplete de Ubigeo    
    public List<String> autocompleteUbigeo(String Consulta) throws SQLException;

    //Este metodo registra los datos de ubigeo
    public void registrar(Ubigeo ubi) throws Exception;

    //Este metodo lista los datos de ubigeo
    public List<Ubigeo> listar() throws Exception;

    //Estre metodo registra los codigos identificadores de cada ubigeo
    public Ubigeo leerID(Ubigeo ubi) throws Exception;

    //Este metodo modifica los datos del ubigeo
    public void modificar(Ubigeo ubi) throws Exception;

    //Este metodo permite eliminar u ocultar los datos del ubigeo
    public void eliminar(Ubigeo ubi) throws Exception;
}
