package Controller;

import dao.ImplEmpleadoD;
import dao.ImplEstudiosSuperiorD;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.EstudiosSuperiorM;

@ManagedBean
@SessionScoped
public class EstudiosSuperiorC implements Serializable {

    private EstudiosSuperiorM estudiosSuperior = new EstudiosSuperiorM();
    private List<EstudiosSuperiorM> lstEstudiosSuperior;
    private String accion;

    public void registrarEstudiosSuperiores(String CodigoEmpleado) throws Exception {
        ImplEstudiosSuperiorD ImplDAO;
        try {
            ImplDAO = new ImplEstudiosSuperiorD();
            estudiosSuperior.setCodiEmpleado(CodigoEmpleado);
            ImplDAO.registrarEstudiosSuperiores(estudiosSuperior);
            this.limpiar();
            this.listar();
        } catch (Exception e) {
            throw e;

        }
    }

    public List<String> completeText(String query) throws SQLException {
        ImplEstudiosSuperiorD ImplDAO = new ImplEstudiosSuperiorD();
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
        estudiosSuperior = new EstudiosSuperiorM();

    }

    public void registrar() throws Exception {
        ImplEstudiosSuperiorD ImplDAO;
        ImplEmpleadoD dao2;

        try {
            ImplDAO = new ImplEstudiosSuperiorD();
            dao2 = new ImplEmpleadoD();
            estudiosSuperior.setCodiEmpleado(dao2.obtenerCodigoEmpleado(estudiosSuperior.getEmpleado()));
            ImplDAO.registrar(estudiosSuperior);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            throw e;

        }
    }

    public void listar() throws Exception {
        ImplEstudiosSuperiorD ImplDAO;

        try {
            ImplDAO = new ImplEstudiosSuperiorD();
            lstEstudiosSuperior = ImplDAO.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        ImplEstudiosSuperiorD ImplDAO;

        try {
            ImplDAO = new ImplEstudiosSuperiorD();
            lstEstudiosSuperior = ImplDAO.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String Codigo) throws Exception {
        ImplEstudiosSuperiorD ImplDAO;
        try {
            ImplDAO = new ImplEstudiosSuperiorD();
            this.estudiosSuperior = ImplDAO.leerID(Codigo);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        ImplEstudiosSuperiorD ImplDAO;
        ImplEmpleadoD dao2;
        try {
            ImplDAO = new ImplEstudiosSuperiorD();
            dao2 = new ImplEmpleadoD();
            estudiosSuperior.setCodiEmpleado(dao2.obtenerCodigoEmpleado(estudiosSuperior.getEmpleado()));
            ImplDAO.modificar(estudiosSuperior);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(EstudiosSuperiorM sup) throws Exception {
        ImplEstudiosSuperiorD ImplDAO;
        try {
            ImplDAO = new ImplEstudiosSuperiorD();
            ImplDAO.eliminar(sup);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            throw e;
        }
    }

    //Getter and Setter

    public EstudiosSuperiorM getEstudiosSuperior() {
        return estudiosSuperior;
    }

    public void setEstudiosSuperior(EstudiosSuperiorM estudiosSuperior) {
        this.estudiosSuperior = estudiosSuperior;
    }

    public List<EstudiosSuperiorM> getLstEstudiosSuperior() {
        return lstEstudiosSuperior;
    }

    public void setLstEstudiosSuperior(List<EstudiosSuperiorM> lstEstudiosSuperior) {
        this.lstEstudiosSuperior = lstEstudiosSuperior;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    

    

}
