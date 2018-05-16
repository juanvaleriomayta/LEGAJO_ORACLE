package bean;

import dao.DetalleDialectoDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.DetalleDialecto;

@ManagedBean
@SessionScoped
public class DetalleDialectoC implements Serializable {

    private DetalleDialecto detalleDialecto = new DetalleDialecto();
    private List<DetalleDialecto> lstDetalleDialecto;
    private String accion;

    public DetalleDialecto getDetalleDialecto() {
        return detalleDialecto;
    }

    public void setDetalleDialecto(DetalleDialecto detalleDialecto) {
        this.detalleDialecto = detalleDialecto;
    }

    public List<DetalleDialecto> getLstDetalleDialecto() {
        return lstDetalleDialecto;
    }

    public void setLstDetalleDialecto(List<DetalleDialecto> lstDetalleDialecto) {
        this.lstDetalleDialecto = lstDetalleDialecto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
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
        this.detalleDialecto.setIdDetDial(0);
        this.detalleDialecto.setLee("");
        this.detalleDialecto.setHabla("");
        this.detalleDialecto.setEscribe("");
    }

    private void registrar() throws Exception {
        DetalleDialectoDao dao;

        try {
            dao = new DetalleDialectoDao();
            dao.registrar(detalleDialecto);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));

        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        DetalleDialectoDao dao;

        try {
            dao = new DetalleDialectoDao();
            lstDetalleDialecto = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(DetalleDialecto detdia) throws Exception {
        DetalleDialectoDao dao;
        DetalleDialecto temp;

        try {
            dao = new DetalleDialectoDao();
            temp = dao.leerID(detdia);

            if (temp != null) {
                this.detalleDialecto = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        DetalleDialectoDao dao;
        try {
            dao = new DetalleDialectoDao();
            dao.modificar(detalleDialecto);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(DetalleDialecto detdia) throws Exception {
        DetalleDialectoDao dao;
        try {
            dao = new DetalleDialectoDao();
            dao.eliminar(detdia);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }
}
