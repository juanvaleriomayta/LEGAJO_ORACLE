package bean;

import dao.DialectoDao;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Dialecto;

@ManagedBean
@ViewScoped
public class DialectoC {

    private Dialecto dialecto = new Dialecto();
    private List<Dialecto> lstDialecto;

    private String accion;
    
    
    public List<String> completeTextDialecto(String query) throws SQLException {               
        DialectoDao dao = new DialectoDao();
        return dao.autocompleteDialecto(query);
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
        dialecto = new Dialecto();

    }

    private void registrar() throws Exception {
        DialectoDao dao;

        try {
            dao = new DialectoDao();
            dao.registrar(dialecto);
            this.limpiar();
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;

        }
    }

    public void listar() throws Exception {
        DialectoDao dao;

        try {
            dao = new DialectoDao();
            lstDialecto = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Dialecto dia) throws Exception {
        DialectoDao dao;
        Dialecto temp;

        try {
            dao = new DialectoDao();
            temp = dao.leerID(dia);

            if (temp != null) {
                this.dialecto = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        DialectoDao dao;

        try {
            dao = new DialectoDao();
            dao.modificar(dialecto);
            this.listar();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Dialecto dia) throws Exception {
        DialectoDao dao;

        try {
            dao = new DialectoDao();
            dao.eliminar(dia);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    //Getter ans Setter
    public List<Dialecto> getLstDialecto() {
        return lstDialecto;
    }

    public void setLstDialecto(List<Dialecto> lstDialecto) {
        this.lstDialecto = lstDialecto;
    }

    public Dialecto getDialecto() {
        return dialecto;
    }

    public void setDialecto(Dialecto dialecto) {
        this.dialecto = dialecto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
