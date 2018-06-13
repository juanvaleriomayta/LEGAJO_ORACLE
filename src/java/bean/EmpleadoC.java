package bean;

import dao.EmpleadoDao;
import dao.UbigeoDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void leerID(Empleado emp) throws Exception {
        EmpleadoDao dao;
        Empleado temp;

        try {
            dao = new EmpleadoDao();
            temp = dao.leerID(emp);

            if (temp != null) {
                this.empleado = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        EmpleadoDao dao;

        try {
            dao = new EmpleadoDao();
            dao.modificar(empleado);
            this.listarActivos();
        } catch (Exception e) {
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
