package bean;

import dao.EmpleadoDao;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.Empleado;

@Data
@ManagedBean
@SessionScoped
public class EmpleadoC implements Serializable {

    private Empleado empleado = new Empleado();
    private List<Empleado> lstEmpleado;
    private String accion;

    public void redireccion() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(EmpleadoC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> completeText(String query) throws SQLException {
        EmpleadoDao dao = new EmpleadoDao();
        return dao.autocompleteEmpleado(query);
    }

    public void ingresarEmpleado() throws Exception {
        EmpleadoDao dao;

        try {
            dao = new EmpleadoDao();
            dao.registrarEmpleado(empleado);
            this.limpiar();
            this.listarActivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void operar() throws Exception {
        switch (accion) {
            case "Registrar":
                this.registrar();
                break;
            case "Modificar":
                this.modificar();
                break;
        }
    }

    public void registrar() throws Exception {
        EmpleadoDao dao;

        try {
            dao = new EmpleadoDao();
            dao.registrar(empleado);
            this.listarActivos();
        } catch (Exception e) {
            throw e;

        }
    }

    public void listarActivos() throws Exception {
        EmpleadoDao dao;

        try {
            dao = new EmpleadoDao();
            lstEmpleado = dao.listarActivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        EmpleadoDao dao;

        try {
            dao = new EmpleadoDao();
            lstEmpleado = dao.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String emp) throws Exception {
        EmpleadoDao dao;
        try {
            dao = new EmpleadoDao();
            this.empleado = dao.leerID(emp);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        EmpleadoDao dao;

        try {
            dao = new EmpleadoDao();
            dao.modificar(empleado);
            listarActivos();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(Empleado emp) throws Exception {
        EmpleadoDao dao;

        try {
            dao = new EmpleadoDao();
            dao.eliminar(emp);
            this.listarActivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
        empleado = new Empleado();
    }

}
