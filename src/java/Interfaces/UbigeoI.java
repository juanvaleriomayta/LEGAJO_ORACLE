package Interfaces;

import java.sql.SQLException;
import java.util.List;
import modelo.UbigeoM;

public interface UbigeoI {

    //Metodo para poder convertir el Nombre del automcomplete en su codigo
    public String obtenerCodigoUbigeo(String Ubigeo) throws SQLException;

    //Lista las coincidencias del automcomplete de Ubigeo    
    public List<String> autocompleteUbigeo(String Consulta) throws SQLException;

    //Este metodo registra los datos de ubigeo
    public void registrar(UbigeoM ubi) throws Exception;

    //Este metodo lista los datos de ubigeo
    public List<UbigeoM> listar() throws Exception;

    //Estre metodo registra los codigos identificadores de cada ubigeo
    public UbigeoM leerID(UbigeoM ubi) throws Exception;

    //Este metodo modifica los datos del ubigeo
    public void modificar(UbigeoM ubi) throws Exception;

    //Este metodo permite eliminar u ocultar los datos del ubigeo
    public void eliminar(UbigeoM ubi) throws Exception;
}
