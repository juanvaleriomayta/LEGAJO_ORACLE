package controlador;

import dao.EmpleadoDao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Empleado;

@ManagedBean
@SessionScoped
public class EmpleadoC {

    private Empleado empleado = new Empleado();
    private List<Empleado> listaEmp = new ArrayList();
    
    @PostConstruct
    public void start(){
        try {        
            listar();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void registrar() throws Exception {
        EmpleadoDao dao;
        try {
            dao = new EmpleadoDao();
            dao.Registrar(empleado);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        EmpleadoDao dao;
        try {
            dao = new EmpleadoDao();
            listaEmp = dao.listarEmp();
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Empleado emp) throws Exception {
        EmpleadoDao dao;
        try {
            dao = new EmpleadoDao();
            dao.Eliminar(emp);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar(Empleado emp) throws Exception {
        EmpleadoDao dao;
        try {
            dao = new EmpleadoDao();
            dao.Modificar(empleado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Getter and Setter
     *
     * @return 
     */
    public List<Empleado> getListaEmp() {
        return listaEmp;
    }

    public void setListaEmp(List<Empleado> listaEmp) {
        this.listaEmp = listaEmp;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
}
