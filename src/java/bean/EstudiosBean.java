package bean;

import dao.EstudiosDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Estudios;

@ManagedBean
@ViewScoped
public class EstudiosBean {

    private Estudios estudios = new Estudios();
    private List<Estudios> lstEstudios;
    private String accion;

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
