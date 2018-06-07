package dao.interaces;

import java.sql.SQLException;
import java.util.List;
import modelo.Ubigeo;

public interface UbigeoI {

    //Metodo para poder convertir el Nombre del automcomplete en su codigo
    public String obtenerCodigoUbigeo(String Ubigeo) throws SQLException;

    //Lista las coincidencias del automcomplete de Ubigeo    
    public List<String> autocompleteUbigeo(String Consulta) throws SQLException;

    public void registrar(Ubigeo ubi) throws Exception;

    public List<Ubigeo> listar() throws Exception;

    public Ubigeo leerID(Ubigeo ubi) throws Exception;

    public void modificar(Ubigeo ubi) throws Exception;

    public void eliminar(Ubigeo ubi) throws Exception;
}
