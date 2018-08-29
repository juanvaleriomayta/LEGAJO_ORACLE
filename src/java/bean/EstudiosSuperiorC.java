package bean;

import dao.EmpleadoDao;
import dao.EstudiosSuperiorDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.EstudiosSuperior;

@ManagedBean
@SessionScoped
public class EstudiosSuperiorC implements Serializable {

    private EstudiosSuperior estudiosSuperior = new EstudiosSuperior();
    private List<EstudiosSuperior> lstEstudiosSuperior;
    private String accion;

    public void registrarEstudiosSuperiores(String CodigoEmpleado) throws Exception {
        EstudiosSuperiorDao dao;
        try {
            dao = new EstudiosSuperiorDao();
            estudiosSuperior.setCodiEmpleado(CodigoEmpleado);
            dao.registrarEstudiosSuperiores(estudiosSuperior);
            this.limpiar();
            this.listar();
        } catch (Exception e) {
            throw e;

        }
    }

    public List<String> completeText(String query) throws SQLException {
        EstudiosSuperiorDao dao = new EstudiosSuperiorDao();
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
        estudiosSuperior = new EstudiosSuperior();

    }

    public void registrar() throws Exception {
        EstudiosSuperiorDao dao;
        EmpleadoDao dao2;

        try {
            dao = new EstudiosSuperiorDao();
            dao2 = new EmpleadoDao();
            estudiosSuperior.setCodiEmpleado(dao2.obtenerCodigoEmpleado(estudiosSuperior.getEmpleado()));
            dao.registrar(estudiosSuperior);
            listar();
            limpiar();
        } catch (Exception e) {
            throw e;

        }
    }

    public void listar() throws Exception {
        EstudiosSuperiorDao dao;

        try {
            dao = new EstudiosSuperiorDao();
            lstEstudiosSuperior = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        EstudiosSuperiorDao dao;

        try {
            dao = new EstudiosSuperiorDao();
            lstEstudiosSuperior = dao.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String Codigo) throws Exception {
        EstudiosSuperiorDao dao;
        try {
            dao = new EstudiosSuperiorDao();
            this.estudiosSuperior = dao.leerID(Codigo);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        EstudiosSuperiorDao dao;
        EmpleadoDao dao2;
        try {
            dao = new EstudiosSuperiorDao();
            dao2 = new EmpleadoDao();
            estudiosSuperior.setCodiEmpleado(dao2.obtenerCodigoEmpleado(estudiosSuperior.getEmpleado()));
            dao.modificar(estudiosSuperior);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(EstudiosSuperior sup) throws Exception {
        EstudiosSuperiorDao dao;
        try {
            dao = new EstudiosSuperiorDao();
            dao.eliminar(sup);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            throw e;
        }
    }

    //Getter and Setter
    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public EstudiosSuperior getEstudiosSuperior() {
        return estudiosSuperior;
    }

    public void setEstudiosSuperior(EstudiosSuperior estudiosSuperior) {
        this.estudiosSuperior = estudiosSuperior;
    }

    public List<EstudiosSuperior> getLstEstudiosSuperior() {
        return lstEstudiosSuperior;
    }

    public void setLstEstudiosSuperior(List<EstudiosSuperior> lstEstudiosSuperior) {
        this.lstEstudiosSuperior = lstEstudiosSuperior;
    }

    public String getAccion() {
        return accion;
    }

}
