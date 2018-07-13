package dao.interaces;

import java.util.List;
import modelo.DetalleDialecto;

public interface DetalleDialectoI {

    public void registrar(DetalleDialectoI detdia) throws Exception;

    public List<DetalleDialecto> listarActivos() throws Exception;

    public List<DetalleDialecto> listarInactivos() throws Exception;

    public DetalleDialecto leerID(String detdia) throws Exception;

    public void modificar(DetalleDialecto detdia) throws Exception;

    public void eliminar(DetalleDialecto detdia) throws Exception;
}
