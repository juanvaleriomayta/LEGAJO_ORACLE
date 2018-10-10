package Controller;


import dao.ImplDialectoD;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.DialectoM;

@ManagedBean
@SessionScoped
public class DialectoC {

    private DialectoM dialecto = new DialectoM();
    private List<DialectoM> lstDialecto;

    private String accion;
    
    
    public List<String> completeTextDialecto(String query) throws SQLException {               
        ImplDialectoD ImplDAO = new ImplDialectoD();
        return ImplDAO.autocompleteDialecto(query);
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
        dialecto = new DialectoM();

    }

    private void registrar() throws Exception {
        ImplDialectoD dao;

        try {
            dao = new ImplDialectoD();
            dao.registrar(dialecto);
            this.limpiar();
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;

        }
    }

    public void listar() throws Exception {
        ImplDialectoD dao;

        try {
            dao = new ImplDialectoD();
            lstDialecto = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(DialectoM dia) throws Exception {
        ImplDialectoD ImplDAO;
        DialectoM temp;

        try {
            ImplDAO = new ImplDialectoD();
            temp = ImplDAO.leerID(dia);

            if (temp != null) {
                this.dialecto = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        ImplDialectoD dao;

        try {
            dao = new ImplDialectoD();
            dao.modificar(dialecto);
            this.listar();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(DialectoM dia) throws Exception {
        ImplDialectoD dao;

        try {
            dao = new ImplDialectoD();
            dao.eliminar(dia);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    //Getter ans Setter

    public DialectoM getDialecto() {
        return dialecto;
    }

    public void setDialecto(DialectoM dialecto) {
        this.dialecto = dialecto;
    }

    public List<DialectoM> getLstDialecto() {
        return lstDialecto;
    }

    public void setLstDialecto(List<DialectoM> lstDialecto) {
        this.lstDialecto = lstDialecto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
}
