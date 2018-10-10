package Interfaces;

import java.sql.SQLException;
import java.util.List;
import modelo.DatosM;

public interface DatosI {

    public void registrar(DatosM dat) throws Exception;

    public List<String> autocompleteEmpleado(String Consulta) throws SQLException;

    public List<DatosM> listar() throws Exception;

    public List<DatosM> listarInactivos() throws Exception;

    public DatosM leerID(String Codigo) throws Exception;

    public void modificar(DatosM dat) throws Exception;

    public void eliminar(DatosM dat) throws Exception;
}
