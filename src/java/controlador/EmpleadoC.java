package controlador;

import dao.EmpleadoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import modelo.Empleado;

@Named(value = "EmpleadoC")
@SessionScoped
public class EmpleadoC implements Serializable {
    private List<Empleado> lstEmpleado;
    private Empleado empleado;            

    public EmpleadoC() {
        empleado = new Empleado();
    }

    public List<Empleado> getLstEmpleado() {
        return lstEmpleado;
    }

    public void setLstEmpleado(List<Empleado> lstEmpleado) {
        this.lstEmpleado = lstEmpleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public void Listar (){
        EmpleadoDao dao;
        
        try {
            dao = new EmpleadoDao();
            dao.guardar(empleado);
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
