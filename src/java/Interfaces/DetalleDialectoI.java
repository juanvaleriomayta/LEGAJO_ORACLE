package Interfaces;

import java.util.List;
import modelo.DetalleDialectoM;

public interface DetalleDialectoI {

    public void registrar(DetalleDialectoM detdia) throws Exception;

    public List<DetalleDialectoM> listarActivos() throws Exception;

    public List<DetalleDialectoM> listarInactivos() throws Exception;

    public DetalleDialectoM leerID(String detdia) throws Exception;

    public void modificar(DetalleDialectoM detdia) throws Exception;

    public void eliminar(DetalleDialectoM detdia) throws Exception;
}
