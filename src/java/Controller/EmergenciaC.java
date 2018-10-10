package Controller;

import dao.ImplEmergenciaD;
import dao.ImplEmpleadoD;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.EmergenciaM;

@ManagedBean
@SessionScoped
public class EmergenciaC implements Serializable {

    private EmergenciaM emergencia = new EmergenciaM();
    private List<EmergenciaM> lstEmergencia;
    private String accion;

    public void registrarEmergencia(String CodigoEmpleado) throws Exception {
        ImplEmergenciaD ImplDAO;

        try {
            ImplDAO = new ImplEmergenciaD();
            emergencia.setCodEmpleado(CodigoEmpleado);
            ImplDAO.registrarEmergencia(emergencia);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;
        }
    }

    public List<String> completeText(String query) throws SQLException {
        ImplEmergenciaD ImplDAO = new ImplEmergenciaD();
        return ImplDAO.autocompleteEmpleado(query);

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
        emergencia = new EmergenciaM();

    }

    private void registrar() throws Exception {
        ImplEmergenciaD ImplDAO;
        ImplEmpleadoD dao2;

        try {
            ImplDAO = new ImplEmergenciaD();
            dao2 = new ImplEmpleadoD();
            emergencia.setCodEmpleado(dao2.obtenerCodigoEmpleado(emergencia.getEmpleado()));
            ImplDAO.registrar(emergencia);
            listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        ImplEmergenciaD ImplDAO;

        try {
            ImplDAO = new ImplEmergenciaD();
            lstEmergencia = ImplDAO.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        ImplEmergenciaD ImplDAO;

        try {
            ImplDAO = new ImplEmergenciaD();
            lstEmergencia = ImplDAO.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String Codigo) throws Exception {
        ImplEmergenciaD ImplDAO;
        try {
            ImplDAO = new ImplEmergenciaD();
            this.emergencia = ImplDAO.leerID(Codigo);
            this.accion = "Modificar";

        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        ImplEmergenciaD ImplDAO;
        ImplEmpleadoD dao2;

        try {
            ImplDAO = new ImplEmergenciaD();
            dao2 = new ImplEmpleadoD();
            emergencia.setCodEmpleado(dao2.obtenerCodigoEmpleado(emergencia.getEmpleado()));
            ImplDAO.modificar(emergencia);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(EmergenciaM eme) throws Exception {
        ImplEmergenciaD ImplDAO;
        try {
            ImplDAO = new ImplEmergenciaD();
            ImplDAO.eliminar(eme);
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

    public EmergenciaM getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(EmergenciaM emergencia) {
        this.emergencia = emergencia;
    }

    public List<EmergenciaM> getLstEmergencia() {
        return lstEmergencia;
    }

    public void setLstEmergencia(List<EmergenciaM> lstEmergencia) {
        this.lstEmergencia = lstEmergencia;
    }

}
