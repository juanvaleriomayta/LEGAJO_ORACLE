package bean;

import dao.EstudiosSuperiorDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.EstudiosSuperior;

@ManagedBean
@SessionScoped
public class EstudiosSuperiorC implements Serializable {

    private EstudiosSuperior estudiosSuperior = new EstudiosSuperior();
    private List<EstudiosSuperior> lstEstudiosSuperior;
    private String accion;

    
    
        public void registrarEstudiosSuperiores() throws Exception {
        EstudiosSuperiorDao dao;

        try {
            dao = new EstudiosSuperiorDao();
            dao.registrarEstudiosSuperiores(estudiosSuperior);
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
        this.estudiosSuperior.setIdEstuSuper(0);
        this.estudiosSuperior.setEduSuper("");
        this.estudiosSuperior.setEspe("");
        this.estudiosSuperior.setCentrEstu("");
        this.estudiosSuperior.setDesd("");
        this.estudiosSuperior.setHast("");
        this.estudiosSuperior.setCulmi("");
        this.estudiosSuperior.setGradAcadObte("");

    }

    private void registrar() throws Exception {
        EstudiosSuperiorDao dao;

        try {
            dao = new EstudiosSuperiorDao();
            dao.registrar(estudiosSuperior);
            this.listar();
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

    public void leerID(EstudiosSuperior sup) throws Exception {
        EstudiosSuperiorDao dao;
        EstudiosSuperior temp;

        try {
            dao = new EstudiosSuperiorDao();
            temp = dao.leerID(sup);

            if (temp != null) {
                this.estudiosSuperior = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        EstudiosSuperiorDao dao;

        try {
            dao = new EstudiosSuperiorDao();
            dao.modificar(estudiosSuperior);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(EstudiosSuperior sup) throws Exception {
        EstudiosSuperiorDao dao;

        try {
            dao = new EstudiosSuperiorDao();
            dao.eliminar(sup);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    
    
    
    
    
    
    
    
    
    
    
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
