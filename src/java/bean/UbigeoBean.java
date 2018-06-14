package bean;

import dao.UbigeoDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Ubigeo;

@ManagedBean
@SessionScoped

public class UbigeoBean implements Serializable{

    private Ubigeo ubigeo = new Ubigeo();
    private List<Ubigeo> lstUbigeo;
    private String accion;
    
    public List<String> completeText(String query) throws SQLException {               
        UbigeoDao dao = new UbigeoDao();
        return dao.autocompleteUbigeo(query);
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
        ubigeo = new Ubigeo();

    }

    private void registrar() throws Exception {
        UbigeoDao dao;

        try {
            dao = new UbigeoDao();
            dao.registrar(ubigeo);
            
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;

        }
    }

    public void listar() throws Exception {
        UbigeoDao dao;

        try {
            dao = new UbigeoDao();
            lstUbigeo = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Ubigeo ubi) throws Exception {
        UbigeoDao dao;
        Ubigeo temp;

        try {
            dao = new UbigeoDao();
            temp = dao.leerID(ubi);

            if (temp != null) {
                this.ubigeo = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        UbigeoDao dao;

        try {
            dao = new UbigeoDao();
            dao.modificar(ubigeo);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Ubigeo ubi) throws Exception {
        UbigeoDao dao;

        try {
            dao = new UbigeoDao();
            dao.eliminar(ubi);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }
    //Getter and Setter
       public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    public List<Ubigeo> getLstUbigeo() {
        return lstUbigeo;
    }

    public void setLstUbigeo(List<Ubigeo> lstUbigeo) {
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
