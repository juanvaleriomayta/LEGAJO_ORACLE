package controlador;

import dao.EmpleadoDao;
import java.sql.SQLException;
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
    private Empleado Valerio;
    private String selectDialec;

    public String getSelectDialec() {
        return selectDialec;
    }

    public void setSelectDialec(String selectDialec) {
        this.selectDialec = selectDialec;
    }

    @PostConstruct
    public void start() {
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

    public Empleado getValerio() {
        return Valerio;
    }

    public void setValerio(Empleado Valerio) {
        this.Valerio = Valerio;
    }

    public void Mdatos(int cod) throws Exception {
        EmpleadoDao dao;
        try {
            dao = new EmpleadoDao();
            Valerio = dao.jalarDataEmpl(cod);

        } catch (SQLException e) {
            throw e;
        }
    }

    public void Modificar() throws Exception {
        EmpleadoDao dao;
        try {
            dao = new EmpleadoDao();
            dao.Modificar(Valerio);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
}
