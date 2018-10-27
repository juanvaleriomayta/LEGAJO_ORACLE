package Controller;


import dao.ImplEmpleadoD;
import dao.ImplEstudiosBasicosD;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.EstudiosBasicosM;

@ManagedBean
@SessionScoped
public class EstudiosBasicosC implements Serializable {

    private EstudiosBasicosM estudiosBasicos = new EstudiosBasicosM();
    private List<EstudiosBasicosM> lstEstudiosBasicos;
    private String accion;

    public void registrarEstudiosBasicos(String CodigoEmpleado) throws Exception {
        ImplEstudiosBasicosD ImplDAO;

        try {
            ImplDAO = new ImplEstudiosBasicosD();
            estudiosBasicos.setCodEmpleado(CodigoEmpleado);
            ImplDAO.registrarEstudiosBasicos(estudiosBasicos);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;

        }
    }

    public List<String> completeText(String query) throws SQLException, Exception {
        ImplEstudiosBasicosD ImplDAO = new ImplEstudiosBasicosD();
        return ImplDAO.autocompleteEmpleado(query);
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
        estudiosBasicos = new EstudiosBasicosM();
    }

    public void registrar() throws Exception {
        ImplEstudiosBasicosD ImplDAO;
        ImplEmpleadoD dao2;

        try {
            ImplDAO = new ImplEstudiosBasicosD();
            dao2 = new ImplEmpleadoD();
            estudiosBasicos.setCodEmpleado(dao2.obtenerCodigoEmpleado(estudiosBasicos.getEmpleado()));
            ImplDAO.registrar(estudiosBasicos);
            this.listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;

        }
    }

    public void listar() throws Exception {
        ImplEstudiosBasicosD ImplDAO;
        try {
            ImplDAO = new ImplEstudiosBasicosD();
            lstEstudiosBasicos = ImplDAO.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        ImplEstudiosBasicosD ImplDAO;

        try {
            ImplDAO = new ImplEstudiosBasicosD();
            lstEstudiosBasicos = ImplDAO.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String Codigo) throws Exception {
        ImplEstudiosBasicosD ImplDAO;
        try {
            ImplDAO = new ImplEstudiosBasicosD();
            this.estudiosBasicos = ImplDAO.leerID(Codigo);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        ImplEstudiosBasicosD ImplDAO;
        ImplEmpleadoD dao2;
        try {
            ImplDAO = new ImplEstudiosBasicosD();
            dao2 = new ImplEmpleadoD();
            estudiosBasicos.setCodEmpleado(dao2.obtenerCodigoEmpleado(estudiosBasicos.getEmpleado()));
            ImplDAO.modificar(estudiosBasicos);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(EstudiosBasicosM bas) throws Exception {
        ImplEstudiosBasicosD ImplDAO;
        try {
            ImplDAO = new ImplEstudiosBasicosD();
            ImplDAO.eliminar(bas);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            throw e;
        }
    }

    //Getter and Setter

    public EstudiosBasicosM getEstudiosBasicos() {
        return estudiosBasicos;
    }

    public void setEstudiosBasicos(EstudiosBasicosM estudiosBasicos) {
        this.estudiosBasicos = estudiosBasicos;
    }

    public List<EstudiosBasicosM> getLstEstudiosBasicos() {
        return lstEstudiosBasicos;
    }

    public void setLstEstudiosBasicos(List<EstudiosBasicosM> lstEstudiosBasicos) {
        this.lstEstudiosBasicos = lstEstudiosBasicos;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
   
}
