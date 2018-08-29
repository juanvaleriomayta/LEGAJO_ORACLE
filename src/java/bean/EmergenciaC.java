package bean;

import dao.EmergenciaDao;
import dao.EmpleadoDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Emergencia;

@ManagedBean
@SessionScoped
public class EmergenciaC implements Serializable {

    private Emergencia emergencia = new Emergencia();
    private List<Emergencia> lstEmergencia;
    private String accion;

    public void registrarEmergencia(String CodigoEmpleado) throws Exception {
        EmergenciaDao dao;

        try {
            dao = new EmergenciaDao();
            emergencia.setCodEmpleado(CodigoEmpleado);
            dao.registrarEmergencia(emergencia);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;
        }
    }

    public List<String> completeText(String query) throws SQLException {
        EmergenciaDao dao = new EmergenciaDao();
        return dao.autocompleteEmpleado(query);

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
        emergencia = new Emergencia();

    }

    private void registrar() throws Exception {
        EmergenciaDao dao;
        EmpleadoDao dao2;

        try {
            dao = new EmergenciaDao();
            dao2 = new EmpleadoDao();
            emergencia.setCodEmpleado(dao2.obtenerCodigoEmpleado(emergencia.getEmpleado()));
            dao.registrar(emergencia);
            listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        EmergenciaDao dao;

        try {
            dao = new EmergenciaDao();
            lstEmergencia = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        EmergenciaDao dao;

        try {
            dao = new EmergenciaDao();
            lstEmergencia = dao.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String Codigo) throws Exception {
        EmergenciaDao dao;
        try {
            dao = new EmergenciaDao();
            this.emergencia = dao.leerID(Codigo);
            this.accion = "Modificar";

        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        EmergenciaDao dao;
        EmpleadoDao dao2;

        try {
            dao = new EmergenciaDao();
            dao2 = new EmpleadoDao();
            emergencia.setCodEmpleado(dao2.obtenerCodigoEmpleado(emergencia.getEmpleado()));
            dao.modificar(emergencia);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(Emergencia eme) throws Exception {
        EmergenciaDao dao;
        try {
            dao = new EmergenciaDao();
            dao.eliminar(eme);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            throw e;
        }
    }

    //Getter and Setter
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public Emergencia getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(Emergencia emergencia) {
        this.emergencia = emergencia;
    }

    public List<Emergencia> getLstEmergencia() {
        return lstEmergencia;
    }

    public void setLstEmergencia(List<Emergencia> lstEmergencia) {
        this.lstEmergencia = lstEmergencia;
    }
}
