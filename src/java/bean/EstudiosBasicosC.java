package bean;

import dao.EstudiosBasicosDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
        this.estudiosBasicos.setIdEstuBasi(0);
        this.estudiosBasicos.setEduc("");
        this.estudiosBasicos.setCulmi("");
        this.estudiosBasicos.setCentrEstu("");
        this.estudiosBasicos.setDesd("");
        this.estudiosBasicos.setHas("");

    }

    private void registrar() throws Exception {
        EstudiosBasicosDao dao;

        try {
            dao = new EstudiosBasicosDao();
            dao.registrar(estudiosBasicos);
            this.listar();
        } catch (Exception e) {
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

    public void leerID(EstudiosBasicos bas) throws Exception {
        EstudiosBasicosDao dao;
        EstudiosBasicos temp;

        try {
            dao = new EstudiosBasicosDao();
            temp = dao.leerID(bas);

            if (temp != null) {
                this.estudiosBasicos = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        EstudiosBasicosDao dao;

        try {
            dao = new EstudiosBasicosDao();
            dao.modificar(estudiosBasicos);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(EstudiosBasicos bas) throws Exception {
        EstudiosBasicosDao dao;

        try {
            dao = new EstudiosBasicosDao();
            dao.eliminar(bas);
            this.listar();
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
