package bean;

import dao.DetalleDialectoDao;
import dao.DialectoDao;
import dao.EmpleadoDao;
import java.io.Serializable;
import java.sql.SQLException;
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
        detalleDialecto = new DetalleDialecto();
    }

    public void registrar() throws Exception {
        DetalleDialectoDao dao;
        EmpleadoDao dao2;
        DialectoDao dao3;
        try {
            dao = new DetalleDialectoDao();
            dao2 = new EmpleadoDao();
            dao3 = new DialectoDao();
            detalleDialecto.setCodEmpleado(dao2.obtenerCodigoEmpleado(detalleDialecto.getEmpleado()));
            detalleDialecto.setCodDialecto(dao3.obtenerCodigoDialecto(detalleDialecto.getDialecto()));
            dao.registrar(detalleDialecto);
            listarActivos();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;
        }
    }

    public List<String> completText(String query) throws SQLException {
        DetalleDialectoDao dao = new DetalleDialectoDao();
        return dao.autocompleteEmpleado(query);
    }

    public void listarActivos() throws Exception {
        DetalleDialectoDao dao;

        try {
            dao = new DetalleDialectoDao();
            lstDetalleDialecto = dao.listarActivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        DetalleDialectoDao dao;

        try {
            dao = new DetalleDialectoDao();
            lstDetalleDialecto = dao.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String Codigo) throws Exception {
        DetalleDialectoDao dao;
        try {
            dao = new DetalleDialectoDao();
            this.detalleDialecto = dao.leerID(Codigo);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        DetalleDialectoDao dao;
        EmpleadoDao dao2;
        DialectoDao dao3;
        try {
            dao = new DetalleDialectoDao();
            dao2 = new EmpleadoDao();
            dao3 = new DialectoDao();
            detalleDialecto.setCodEmpleado(dao2.obtenerCodigoEmpleado(detalleDialecto.getEmpleado()));
            detalleDialecto.setCodDialecto(dao3.obtenerCodigoDialecto(detalleDialecto.getDialecto()));
            dao.modificar(detalleDialecto);
            listarActivos();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(DetalleDialecto detdia) throws Exception {
        DetalleDialectoDao dao;
        try {
            dao = new DetalleDialectoDao();
            dao.eliminar(detdia);
            listarActivos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            throw e;
        }
    }

    //Getter and Setter
    public DetalleDialecto getDetalleDialecto() {
        return detalleDialecto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
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
}
