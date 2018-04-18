package dao;

import java.util.List;
import modelo.Empleado;

public interface IEmpleado {

    void guardar(Empleado empleado) throws Exception;

    void modificar(Empleado empleado) throws Exception;

    void eliminar(int empleado) throws Exception;

    List<Empleado> listarTodos() throws Exception;

    Empleado listarPorCod(int Cod_Empelado) throws Exception;

}
