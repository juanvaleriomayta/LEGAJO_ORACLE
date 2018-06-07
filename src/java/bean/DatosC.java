package bean;

import dao.DatosDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Datos;

@ManagedBean
@SessionScoped
public class DatosC implements Serializable{

    private Datos datos = new Datos();
    private List<Datos> lstDatos;
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
        this.datos.setIdLegajo(0);
        this.datos.setCon("");
        this.datos.setApreCali("");
        this.datos.setSerPre("");
        this.datos.setIntProCapPerf("");
        this.datos.setRefPer("");
        this.datos.setBonPer("");
        this.datos.setComInfTper("");
        this.datos.setBonFam("");

    }

    private void registrar() throws Exception {
        DatosDao dao;

        try {
            dao = new DatosDao();
            dao.registrar(datos);
            this.limpiar();
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;

        }
    }

    public void listar() throws Exception {
        DatosDao dao;

        try {
            dao = new DatosDao();
            lstDatos = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Datos dat) throws Exception {
        DatosDao dao;
        Datos temp;

        try {
            dao = new DatosDao();
            temp = dao.leerID(dat);

            if (temp != null) {
                this.datos = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        DatosDao dao;

        try {
            dao = new DatosDao();
            dao.modificar(datos);
            this.listar();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Datos dat) throws Exception {
        DatosDao dao;

        try {
            dao = new DatosDao();
            dao.eliminar(dat);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }
    
    
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
