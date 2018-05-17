package bean;

import dao.ContactosDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Contactos;

@Named(value = "contactoController")
@SessionScoped
public class ContactoController implements Serializable {

    private Contactos contactos = new Contactos();
    private Contactos familiar = new Contactos();
    private List<Contactos> lstContactos;
    private String accion;

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

    private void addContacto() throws Exception {
        ContactosDao dao;
        try {
            dao = new ContactosDao();
            dao.registrarContacto(contactos, "C");
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    private void addFamiliar() throws Exception {
        ContactosDao dao;
        try {
            dao = new ContactosDao();
            dao.registrarContacto(familiar, "F");
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void ingresarContacto() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ingresando Contacto"));
    }

    public void limpiar() {
        this.contactos.setCodConEmp(0);
        this.contactos.setTipDeFami("");
        this.contactos.setNom("");
        this.contactos.setApe("");
        this.contactos.setPar("");
        this.contactos.setOcu("");
        this.contactos.setFecNac("");
        this.contactos.setTel("");
        this.contactos.setCel("");
        this.contactos.setEstCiv("");
        this.contactos.setVive("");
    }

    private void registrar() throws Exception {
        ContactosDao dao;
        try {
            dao = new ContactosDao();
            dao.registrar(contactos);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        ContactosDao dao;
        try {
            dao = new ContactosDao();
            lstContactos = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Contactos cont) throws Exception {
        ContactosDao dao;
        Contactos temp;
        try {
            dao = new ContactosDao();
            temp = dao.leerID(cont);

            if (temp != null) {
                this.contactos = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        ContactosDao dao;
        try {
            dao = new ContactosDao();
            dao.modificar(contactos);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Contactos cont) throws Exception {
        ContactosDao dao;
        try {
            dao = new ContactosDao();
            dao.eliminar(cont);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Getter and Setter

     */
    public Contactos getContactos() {
        return contactos;
    }

    public void setContactos(Contactos contactos) {
        this.contactos = contactos;
    }

    public List<Contactos> getLstContactos() {
        return lstContactos;
    }

    public void setLstContactos(List<Contactos> lstContactos) {
        this.lstContactos = lstContactos;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Contactos getFamiliar() {
        return familiar;
    }

    public void setFamiliar(Contactos familiar) {
        this.familiar = familiar;
    }

}
