package Controller;

import dao.ImplUbigeoD;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.UbigeoM;

@ManagedBean
@SessionScoped

public class UbigeoBean implements Serializable{

    private UbigeoM ubigeo = new UbigeoM();
    private List<UbigeoM> lstUbigeo;
    private String accion;
    
    public List<String> completeText(String query) throws SQLException {               
        ImplUbigeoD ImplDAO = new ImplUbigeoD();
        return ImplDAO.autocompleteUbigeo(query);
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
        ubigeo = new UbigeoM();

    }

    private void registrar() throws Exception {
        ImplUbigeoD ImplDAO;

        try {
            ImplDAO = new ImplUbigeoD();
            ImplDAO.registrar(ubigeo);
            
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;

        }
    }

    public void listar() throws Exception {
        ImplUbigeoD ImplDAO;

        try {
            ImplDAO = new ImplUbigeoD();
            lstUbigeo = ImplDAO.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(UbigeoM ubi) throws Exception {
        ImplUbigeoD ImplDAO;
        UbigeoM temp;

        try {
            ImplDAO = new ImplUbigeoD();
            temp = ImplDAO.leerID(ubi);

            if (temp != null) {
                this.ubigeo = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        ImplUbigeoD ImplDAO;

        try {
            ImplDAO = new ImplUbigeoD();
            ImplDAO.modificar(ubigeo);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(UbigeoM ubi) throws Exception {
        ImplUbigeoD ImplDAO;

        try {
            ImplDAO = new ImplUbigeoD();
            ImplDAO.eliminar(ubi);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }
    //Getter and Setter

    public UbigeoM getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(UbigeoM ubigeo) {
        this.ubigeo = ubigeo;
    }

    public List<UbigeoM> getLstUbigeo() {
        return lstUbigeo;
    }

    public void setLstUbigeo(List<UbigeoM> lstUbigeo) {
        this.lstUbigeo = lstUbigeo;
    }
      

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }
}
