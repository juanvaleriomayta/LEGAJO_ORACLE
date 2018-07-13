package dao.interaces;

import java.sql.SQLException;
import java.util.List;
import modelo.Datos;

public interface DatosI {

    public void registrar(Datos dat) throws Exception;

    public List<String> autocompleteEmpleado(String Consulta) throws SQLException;

    public List<Datos> listar() throws Exception;

    public List<Datos> listarInactivos() throws Exception;

    public Datos leerID(String Codigo) throws Exception;

    public void modificar(Datos dat) throws Exception;

    public void eliminar(Datos dat) throws Exception;
}
