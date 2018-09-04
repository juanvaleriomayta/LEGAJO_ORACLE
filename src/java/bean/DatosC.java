package bean;

import dao.DatosDao;
import dao.EmpleadoDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Datos;


@ManagedBean
@SessionScoped
public class DatosC implements Serializable {

    private Datos datos = new Datos();
    private List<Datos> lstDatos;
    private String accion;

    public void registrarDatos(String CodigoEmpleado) throws Exception {
        DatosDao dao;
        try {
            dao = new DatosDao();
            datos.setCodEmpleado(CodigoEmpleado);
            dao.registrarDatos(datos);
            this.limpiar();
            this.listar();
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
        datos = new Datos();
    }

    private void registrar() throws Exception {
        DatosDao dao;
        EmpleadoDao dao2;
        try {
            dao = new DatosDao();
            dao2 = new EmpleadoDao();
            datos.setCodEmpleado(dao2.obtenerCodigoEmpleado(datos.getEmpleado()));
            dao.registrar(datos);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;
        }
    }

    public List<String> completeText(String query) throws SQLException {
        DatosDao dao = new DatosDao();
        return dao.autocompleteEmpleado(query);
    }

    public void listar() throws Exception {
        DatosDao dao;
        try {
            dao = new DatosDao();
            lstDatos = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String Codigo) throws Exception {
        DatosDao dao;
        try {
            dao = new DatosDao();
            this.datos = dao.leerID(Codigo);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        DatosDao dao;

        try {
            dao = new DatosDao();
            lstDatos = dao.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        DatosDao dao;
        EmpleadoDao dao2;
        try {
            dao = new DatosDao();
            dao2 = new EmpleadoDao();
            datos.setCodEmpleado(dao2.obtenerCodigoEmpleado(datos.getEmpleado()));
            dao.modificar(datos);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(Datos dat) throws Exception {
        DatosDao dao;
        try {
            dao = new DatosDao();
            dao.eliminar(dat);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            throw e;
        }
    }

    //Getter and Setter
    public List<Datos> getLstDatos() {
        return lstDatos;
    }

    public void setLstDatos(List<Datos> lstDatos) {
        this.lstDatos = lstDatos;
    }

    public Datos getDatos() {
        return datos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
