package bean;

import dao.FamiliaresDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Familiares;

@ManagedBean
@SessionScoped
public class FamiliaresC implements Serializable {

    private Familiares familiar = new Familiares();
    private List<Familiares> lstFamiliares;
    private String accion;

    public void registrarFamiliar() throws Exception {
        FamiliaresDao dao;
        
        try {
            dao = new FamiliaresDao();
            dao.registrarFamiliar(familiar);
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
        this.familiar.setCodFami(0);
        this.familiar.setNombre("");
        this.familiar.setApe("");
        this.familiar.setPar("");
        this.familiar.setOcu("");
        this.familiar.setFecNac("");
        this.familiar.setTel("");
        this.familiar.setCel("");
        this.familiar.setEstCiv("");
        this.familiar.setVive("");
    }

    private void registrar() throws Exception {
        FamiliaresDao dao;
        try {
            dao = new FamiliaresDao();
            dao.registrar(familiar);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        FamiliaresDao dao;
        try {
            dao = new FamiliaresDao();
            lstFamiliares = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Familiares fam) throws Exception {
        FamiliaresDao dao;
        Familiares temp;
        try {
            dao = new FamiliaresDao();
            temp = dao.leerID(fam);

            if (temp != null) {
                this.familiar = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        FamiliaresDao dao;
        try {
            dao = new FamiliaresDao();
            dao.modificar(familiar);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Familiares fam) throws Exception {
        FamiliaresDao dao;
        try {
            dao = new FamiliaresDao();
            dao.eliminar(fam);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Getter and Setter
     *
     * @return
     */
    public Familiares getFamiliar() {
        return familiar;
    }

    public void setFamiliar(Familiares familiar) {
        this.familiar = familiar;
    }

    public List<Familiares> getLstFamiliares() {
        return lstFamiliares;
    }

    public void setLstFamiliares(List<Familiares> lstFamiliares) {
        this.lstFamiliares = lstFamiliares;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

}
