package bean;

import dao.EmpleadoDao;
import dao.EstudiosBasicosDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.EstudiosBasicos;

@ManagedBean
@SessionScoped
public class EstudiosBasicosC implements Serializable {

    private EstudiosBasicos estudiosBasicos = new EstudiosBasicos();
    private List<EstudiosBasicos> lstEstudiosBasicos;
    private String accion;

    public void registrarEstudiosBasicos() throws Exception {
        EstudiosBasicosDao dao;

        try {
            dao = new EstudiosBasicosDao();
            dao.registrarEstudiosBasicos(estudiosBasicos);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;

        }
    }

    public List<String> completeText(String query) throws SQLException {
        EstudiosBasicosDao dao = new EstudiosBasicosDao();
        return dao.autocompleteEmpleado(query);
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
        estudiosBasicos = new EstudiosBasicos();
    }

    public void registrar() throws Exception {
        EstudiosBasicosDao dao;
        EmpleadoDao dao2;

        try {
            dao = new EstudiosBasicosDao();
            dao2 = new EmpleadoDao();
            estudiosBasicos.setCodEmpleado(dao2.obtenerCodigoEmpleado(estudiosBasicos.getEmpleado()));
            dao.registrar(estudiosBasicos);
            this.listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;

        }
    }

    public void listar() throws Exception {
        EstudiosBasicosDao dao;
        try {
            dao = new EstudiosBasicosDao();
            lstEstudiosBasicos = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        EstudiosBasicosDao dao;

        try {
            dao = new EstudiosBasicosDao();
            lstEstudiosBasicos = dao.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String Codigo) throws Exception {
        EstudiosBasicosDao dao;
        try {
            dao = new EstudiosBasicosDao();
            this.estudiosBasicos = dao.leerID(Codigo);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        EstudiosBasicosDao dao;
        EmpleadoDao dao2;
        try {
            dao = new EstudiosBasicosDao();
            dao2 = new EmpleadoDao();
            estudiosBasicos.setCodEmpleado(dao2.obtenerCodigoEmpleado(estudiosBasicos.getEmpleado()));
            dao.modificar(estudiosBasicos);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(EstudiosBasicos bas) throws Exception {
        EstudiosBasicosDao dao;
        try {
            dao = new EstudiosBasicosDao();
            dao.eliminar(bas);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            throw e;
        }
    }

    //Getter and Setter
    public EstudiosBasicos getEstudiosBasicos() {
        return estudiosBasicos;
    }

    public void setEstudiosBasicos(EstudiosBasicos estudiosBasicos) {
        this.estudiosBasicos = estudiosBasicos;
    }

    public List<EstudiosBasicos> getLstEstudiosBasicos() {
        return lstEstudiosBasicos;
    }

    public void setLstEstudiosBasicos(List<EstudiosBasicos> lstEstudiosBasicos) {
        this.lstEstudiosBasicos = lstEstudiosBasicos;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }
}
