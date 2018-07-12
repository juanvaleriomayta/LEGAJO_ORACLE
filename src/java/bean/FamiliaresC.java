package bean;

import dao.EmpleadoDao;
import dao.FamiliaresDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Familiares;

@ManagedBean
@SessionScoped
public class FamiliaresC implements Serializable {

    private Familiares familiar = new Familiares();
    private List<Familiares> lstFamiliares;
    private String accion;

    public void registrarFamiliar() throws Exception {
        FamiliaresDao dao;

        try {
            dao = new FamiliaresDao();
            dao.registrarFamiliar(familiar);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;
        }
    }

    public List<String> completeText(String query) throws SQLException {
        FamiliaresDao dao = new FamiliaresDao();
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
        familiar = new Familiares();
    }

    private void registrar() throws Exception {
        FamiliaresDao dao;
        EmpleadoDao dao2;
        try {
            dao = new FamiliaresDao();
            dao2 = new EmpleadoDao();
            familiar.setCodiEmpleado(dao2.obtenerCodigoEmpleado(familiar.getEmpleado()));
            dao.registrar(familiar);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        FamiliaresDao dao;
        try {
            dao = new FamiliaresDao();
            lstFamiliares = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        FamiliaresDao dao;
        try {
            dao = new FamiliaresDao();
            lstFamiliares = dao.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String Codigo) throws Exception {
        FamiliaresDao dao;
        try {
            dao = new FamiliaresDao();
            this.familiar = dao.leerID(Codigo);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        FamiliaresDao dao;
        EmpleadoDao dao2;
        try {
            dao = new FamiliaresDao();
            dao2 = new EmpleadoDao();
            familiar.setCodiEmpleado(dao2.obtenerCodigoEmpleado(familiar.getEmpleado()));
            dao.modificar(familiar);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(Familiares fam) throws Exception {
        FamiliaresDao dao;
        try {
            dao = new FamiliaresDao();
            dao.eliminar(fam);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Getter and Setter
     *
     * @return
     */
    public Familiares getFamiliar() {
        return familiar;
    }

    public void setFamiliar(Familiares familiar) {
        this.familiar = familiar;
    }

    public List<Familiares> getLstFamiliares() {
        return lstFamiliares;
    }

    public void setLstFamiliares(List<Familiares> lstFamiliares) {
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
