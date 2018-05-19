package bean;

import dao.EstudiosDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Estudios;

@ManagedBean
@SessionScoped
public class EstudiosC implements Serializable{

    private Estudios estudios = new Estudios();
    private Estudios superiores = new Estudios();
    private List<Estudios> lstEstudios;
    private String accion;

    public void registrarSecundarios() throws Exception {
        EstudiosDao dao;
        try {
            dao = new EstudiosDao();
            dao.registrarEstudios(estudios, "SE");
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado Estudios SE con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void registrarSuperiores() throws Exception {
        EstudiosDao dao;
        try {
            dao = new EstudiosDao();
            dao.registrarSuperiores(superiores, "SU");
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado Estudios SU con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public Estudios getSuperiores() {
        return superiores;
    }

    public void setSuperiores(Estudios superiores) {
        this.superiores = superiores;
    }
       
    public Estudios getEstudios() {
        return estudios;
    }

    public void setEstudios(Estudios estudios) {
        this.estudios = estudios;
    }

    public List<Estudios> getLstEstudios() {
        return lstEstudios;
    }

    public void setLstEstudios(List<Estudios> lstEstudios) {
        this.lstEstudios = lstEstudios;
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
        this.estudios.setIdEstuGenEmpl(0);
        this.estudios.setDatSuper("");
        this.estudios.setTipGraAca("");
        this.estudios.setDesd("");
        this.estudios.setHas("");
        this.estudios.setCarre("");

    }

    private void registrar() throws Exception {
        EstudiosDao dao;

        try {
            dao = new EstudiosDao();
            dao.registrar(estudios);
            this.limpiar();
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Agregado con Exito"));
        } catch (Exception e) {
            throw e;

        }
    }

    public void listar() throws Exception {
        EstudiosDao dao;

        try {
            dao = new EstudiosDao();
            lstEstudios = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Listado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Estudios estu) throws Exception {
        EstudiosDao dao;
        Estudios temp;

        try {
            dao = new EstudiosDao();
            temp = dao.leerID(estu);

            if (temp != null) {
                this.estudios = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        EstudiosDao dao;

        try {
            dao = new EstudiosDao();
            dao.modificar(estudios);
            this.listar();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modificado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Estudios estu) throws Exception {
        EstudiosDao dao;

        try {
            dao = new EstudiosDao();
            dao.eliminar(estu);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Eliminado con Exito"));
        } catch (Exception e) {
            throw e;
        }
    }
}
