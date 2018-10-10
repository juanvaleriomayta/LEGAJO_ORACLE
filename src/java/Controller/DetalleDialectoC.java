package Controller;

import dao.ImplDetalleDialectoD;
import dao.ImplDialectoD;
import dao.ImplEmpleadoD;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.DetalleDialectoM;

@ManagedBean
@SessionScoped
public class DetalleDialectoC implements Serializable {

    private DetalleDialectoM detalleDialecto = new DetalleDialectoM();
    private List<DetalleDialectoM> lstDetalleDialecto;
    private String accion;

    private String codigoDialecto;

   
    public void registrarDialecto(String CodigoEmpleado) throws Exception {
        ImplDetalleDialectoD ImplDAO;
        try {
            ImplDAO = new ImplDetalleDialectoD();
            detalleDialecto.setCodEmpleado(CodigoEmpleado);
           // codigoDialecto = dao.CodigoDialecto(detalleDialecto.getDialecto());
            ImplDAO.registrarDetalle(detalleDialecto);
            this.limpiar();
            this.listarActivos();
        } catch (Exception e) {
            throw e;

        }
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
        detalleDialecto = new DetalleDialectoM();
    }

    public void registrar() throws Exception {
        ImplDetalleDialectoD ImplDAO;
        ImplEmpleadoD dao2;
        ImplDialectoD dao3;
        try {
            ImplDAO = new ImplDetalleDialectoD();
            dao2 = new ImplEmpleadoD();
            dao3 = new ImplDialectoD();
            detalleDialecto.setCodEmpleado(dao2.obtenerCodigoEmpleado(detalleDialecto.getEmpleado()));
            detalleDialecto.setCodDialecto(dao3.obtenerCodigoDialecto(detalleDialecto.getDialecto()));
            ImplDAO.registrar(detalleDialecto);
            listarActivos();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;
        }
    }

    public List<String> completText(String query) throws SQLException {
        ImplDetalleDialectoD ImplDAO = new ImplDetalleDialectoD();
        return ImplDAO.autocompleteEmpleado(query);
    }

    public void listarActivos() throws Exception {
        ImplDetalleDialectoD ImplDAO;

        try {
            ImplDAO = new ImplDetalleDialectoD();
            lstDetalleDialecto = ImplDAO.listarActivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        ImplDetalleDialectoD ImplDAO;

        try {
            ImplDAO = new ImplDetalleDialectoD();
            lstDetalleDialecto = ImplDAO.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String Codigo) throws Exception {
        ImplDetalleDialectoD ImplDAO;
        try {
            ImplDAO = new ImplDetalleDialectoD();
            this.detalleDialecto = ImplDAO.leerID(Codigo);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        ImplDetalleDialectoD ImplDAO;
        ImplEmpleadoD dao2;
        ImplDialectoD dao3;
        try {
            ImplDAO = new ImplDetalleDialectoD();
            dao2 = new ImplEmpleadoD();
            dao3 = new ImplDialectoD();
            detalleDialecto.setCodEmpleado(dao2.obtenerCodigoEmpleado(detalleDialecto.getEmpleado()));
            detalleDialecto.setCodDialecto(dao3.obtenerCodigoDialecto(detalleDialecto.getDialecto()));
            ImplDAO.modificar(detalleDialecto);
            listarActivos();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(DetalleDialectoM detdia) throws Exception {
        ImplDetalleDialectoD ImplDAO;
        try {
            ImplDAO = new ImplDetalleDialectoD();
            ImplDAO.eliminar(detdia);
            listarActivos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            throw e;
        }
    }

    //Getter and Setter
    public DetalleDialectoM getDetalleDialecto() {
        return detalleDialecto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public void setDetalleDialecto(DetalleDialectoM detalleDialecto) {
        this.detalleDialecto = detalleDialecto;
    }

    public List<DetalleDialectoM> getLstDetalleDialecto() {
        return lstDetalleDialecto;
    }

    public void setLstDetalleDialecto(List<DetalleDialectoM> lstDetalleDialecto) {
        this.lstDetalleDialecto = lstDetalleDialecto;
    }

    public String getCodigoDialecto() {
        return codigoDialecto;
    }

    public void setCodigoDialecto(String codigoDialecto) {
        this.codigoDialecto = codigoDialecto;
    }


}
