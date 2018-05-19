package bean;

import dao.EmpleadoDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Empleado;

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
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
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

    public void limpiar() {
        this.empleado.setIdEmpl(0);
        this.empleado.setDNI("");
        this.empleado.setNom("");
        this.empleado.setApelPate("");
        this.empleado.setApelMate("");
        this.empleado.setRUC("");
        this.empleado.setEmail("");
        this.empleado.setTelf("");
        this.empleado.setCel("");
        this.empleado.setFecNac("");
        this.empleado.setGrupSang("");
        this.empleado.setEstCiv("");
        this.empleado.setConLab("");
        this.empleado.setCarnAseg("");
        this.empleado.setRefe("");
        this.empleado.setLeye("");
        this.empleado.setFecIng("");
        this.empleado.setFecNom("");
        this.empleado.setDatCony("");
        this.empleado.setUbigActu("");
        this.empleado.setUbigOrig("");
        this.empleado.setEst("");

    }

    private void registrar() throws Exception {
        EmpleadoDao dao;

        try {
            dao = new EmpleadoDao();
            dao.registrar(empleado);

            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;

        }
    }

    public void listar() throws Exception {
        EmpleadoDao dao;

        try {
            dao = new EmpleadoDao();
            lstEmpleado = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
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

    private void modificar() throws Exception {
        EmpleadoDao dao;

        try {
            dao = new EmpleadoDao();
            dao.modificar(empleado);
            this.listar();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Empleado emp) throws Exception {
        EmpleadoDao dao;

        try {
            dao = new EmpleadoDao();
            dao.eliminar(emp);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }
}
