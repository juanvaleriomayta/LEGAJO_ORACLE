package Controller;

import dao.ImplEmpleadoD;
import dao.ImplFamiliaresD;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.FamiliaresM;

@ManagedBean
@SessionScoped
public class FamiliaresC implements Serializable {

    private FamiliaresM familiar = new FamiliaresM();
    private List<FamiliaresM> lstFamiliares;
    private String accion;

    public void registrarFamiliar(String CodigoEmpleado) throws Exception {
        ImplFamiliaresD ImplDAO;

        try {
            ImplDAO = new ImplFamiliaresD();
            familiar.setCodiEmpleado(CodigoEmpleado);
            ImplDAO.registrarFamiliar(familiar);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;
        }
    }

    public List<String> completeText(String query) throws SQLException {
        ImplFamiliaresD ImplDAO = new ImplFamiliaresD();
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
        familiar = new FamiliaresM();
    }

    private void registrar() throws Exception {
        ImplFamiliaresD ImplDAO;
        ImplEmpleadoD dao2;
        try {
            ImplDAO = new ImplFamiliaresD();
            dao2 = new ImplEmpleadoD();
            familiar.setCodiEmpleado(dao2.obtenerCodigoEmpleado(familiar.getEmpleado()));
            ImplDAO.registrar(familiar);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        ImplFamiliaresD ImplDAO;
        try {
            ImplDAO = new ImplFamiliaresD();
            lstFamiliares = ImplDAO.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        ImplFamiliaresD ImplDAO;
        try {
            ImplDAO = new ImplFamiliaresD();
            lstFamiliares = ImplDAO.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String Codigo) throws Exception {
        ImplFamiliaresD ImplDAO;
        try {
            ImplDAO = new ImplFamiliaresD();
            this.familiar = ImplDAO.leerID(Codigo);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        ImplFamiliaresD ImplDAO;
        ImplEmpleadoD dao2;
        try {
            ImplDAO = new ImplFamiliaresD();
            dao2 = new ImplEmpleadoD();
            familiar.setCodiEmpleado(dao2.obtenerCodigoEmpleado(familiar.getEmpleado()));
            ImplDAO.modificar(familiar);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(FamiliaresM fam) throws Exception {
        ImplFamiliaresD ImplDAO;
        try {
            ImplDAO = new ImplFamiliaresD();
            ImplDAO.eliminar(fam);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            throw e;
        }
    }

    

    public FamiliaresM getFamiliar() {
        return familiar;
    }

    public void setFamiliar(FamiliaresM familiar) {
        this.familiar = familiar;
    }

    public List<FamiliaresM> getLstFamiliares() {
        return lstFamiliares;
    }

    /**
     * Getter and Setter
     *
     * @return
     */
    public void setLstFamiliares(List<FamiliaresM> lstFamiliares) {    
        this.lstFamiliares = lstFamiliares;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

}
