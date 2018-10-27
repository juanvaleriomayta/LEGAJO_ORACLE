package Controller;

import dao.ImplDatosD;
import dao.ImplEmpleadoD;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.DatosM;


@ManagedBean
@SessionScoped
public class DatosC implements Serializable {

    private DatosM datos = new DatosM();
    private List<DatosM> lstDatos;
    private String accion;

    public void registrarDatos(String CodigoEmpleado) throws Exception {
        ImplDatosD dao;
        try {
            dao = new ImplDatosD();
            datos.setCodEmpleado(CodigoEmpleado);
            dao.registrarDatos(datos);
            this.limpiarDatos();
            this.listarDatos();
        } catch (Exception e) {
            throw e;

        }
    }
    
    public void operarDatos() throws Exception {
        switch (accion) {
            case "Registrar":
                this.registrar();
                break;
            case "Modificar":
                this.modificarDatos();
                break;
        }
    }

    public void limpiarDatos() {
        datos = new DatosM();
    }

    private void registrar() throws Exception {
        ImplDatosD ImplDAO;
        ImplEmpleadoD dao2;
        try {
            ImplDAO = new ImplDatosD();
            dao2 = new ImplEmpleadoD();
            datos.setCodEmpleado(dao2.obtenerCodigoEmpleado(datos.getEmpleado()));
            ImplDAO.registrar(datos);
            listarDatos();
            limpiarDatos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;
        }
    }

    public List<String> completeText(String query) throws SQLException, Exception {
        ImplDatosD ImplDAO = new ImplDatosD();
        return ImplDAO.autocompleteEmpleado(query);
    }

    public void listarDatos() throws Exception {
        ImplDatosD ImplDAO;
        try {
            ImplDAO = new ImplDatosD();
            lstDatos = ImplDAO.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerDatosID(String Codigo) throws Exception {
        ImplDatosD ImplDAO;
        try {
            ImplDAO = new ImplDatosD();
            this.datos = ImplDAO.leerID(Codigo);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarDatosInactivos() throws Exception {
        ImplDatosD ImplDAO;

        try {
            ImplDAO = new ImplDatosD();
            lstDatos = ImplDAO.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarDatos() throws Exception {
        ImplDatosD ImplDAO;
        ImplEmpleadoD dao2;
        try {
            ImplDAO = new ImplDatosD();
            dao2 = new ImplEmpleadoD();
            datos.setCodEmpleado(dao2.obtenerCodigoEmpleado(datos.getEmpleado()));
            ImplDAO.modificar(datos);
            listarDatos();
            limpiarDatos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminarDatos(DatosM dat) throws Exception {
        ImplDatosD ImplDAO;
        try {
            ImplDAO = new ImplDatosD();
            ImplDAO.eliminar(dat);
            listarDatos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            throw e;
        }
    }

    //Getter and Setter
    public List<DatosM> getLstDatos() {
        return lstDatos;
    }

    public void setLstDatos(List<DatosM> lstDatos) {
        this.lstDatos = lstDatos;
    }

    public DatosM getDatos() {
        return datos;
    }

    public void setDatos(DatosM datos) {
        this.datos = datos;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
