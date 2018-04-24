package controlador;

import dao.EmpleadoDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Empleado;


@ManagedBean
@SessionScoped
public class EmpleadoC {
    
    private Empleado empleado = new Empleado();
    private List<Empleado> listaEmp;
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public void registrar() throws Exception{
        EmpleadoDao dao;
        try {
            dao = new EmpleadoDao();
            dao.Registrar(empleado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
        }
    }
    public void Listar() throws Exception{
        EmpleadoDao dao;
        try {
            dao = new EmpleadoDao();
            listaEmp = dao.listarEmp();
        } catch (Exception e) {
            throw e;
        }
       
    }

    public void eliminar() throws Exception{
        EmpleadoDao dao;
        try {
            dao = new EmpleadoDao();
            dao.Eliminar(empleado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
        }
    }
    
    public void modificar() throws Exception{
        EmpleadoDao dao;
        try {
            dao = new EmpleadoDao();
            dao.Modificar(empleado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
        }
    }
    
    public List<Empleado> getListaEmp() {
        return listaEmp;
    }

    public void setListaEmp(List<Empleado> listaEmp) {
        this.listaEmp = listaEmp;
    }
}
