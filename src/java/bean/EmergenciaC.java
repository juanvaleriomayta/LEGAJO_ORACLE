package bean;

import dao.EmergenciaDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Emergencia;

@ManagedBean
@SessionScoped
public class EmergenciaC implements Serializable {

    private Emergencia emergencia = new Emergencia();
    private List<Emergencia> lstEmergencia;
    private String accion;

    public void registrarEmergencia() throws Exception {
        EmergenciaDao dao;

        try {
            dao = new EmergenciaDao();
            dao.registrarEmergencia(emergencia);
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
        emergencia = new Emergencia();
      
    }

    private void registrar() throws Exception {
        EmergenciaDao dao;

        try {
            dao = new EmergenciaDao();
            dao.registrar(emergencia);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        EmergenciaDao dao;

        try {
            dao = new EmergenciaDao();
            lstEmergencia = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Emergencia eme) throws Exception {
        EmergenciaDao dao;
        Emergencia temp;

        try {
            dao = new EmergenciaDao();
            temp = dao.leerID(eme);

            if (temp != null) {
                this.emergencia = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        EmergenciaDao dao;

        try {
            dao = new EmergenciaDao();
            dao.modificar(emergencia);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Emergencia eme) throws Exception {
        EmergenciaDao dao;

        try {
            dao = new EmergenciaDao();
            dao.eliminar(eme);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    //Getter and Setter
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public Emergencia getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(Emergencia emergencia) {
        this.emergencia = emergencia;
    }

    public List<Emergencia> getLstEmergencia() {
        return lstEmergencia;
    }

    public void setLstEmergencia(List<Emergencia> lstEmergencia) {
        this.lstEmergencia = lstEmergencia;
    }
}
