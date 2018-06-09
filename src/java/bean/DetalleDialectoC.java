package bean;

import dao.DetalleDialectoDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.DetalleDialecto;

@ManagedBean
@SessionScoped
public class DetalleDialectoC implements Serializable {

    private DetalleDialecto detalleDialecto = new DetalleDialecto();
    private List<DetalleDialecto> lstDetalleDialecto;
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
        detalleDialecto = new DetalleDialecto();
    }

    private void registrar() throws Exception {
        DetalleDialectoDao dao;

        try {
            dao = new DetalleDialectoDao();
            dao.registrar(detalleDialecto);
            this.listarActivos();

        } catch (Exception e) {
            throw e;
        }
    }

    public void listarActivos() throws Exception {
        DetalleDialectoDao dao;

        try {
            dao = new DetalleDialectoDao();
            lstDetalleDialecto = dao.listarActivos();
        } catch (Exception e) {
            throw e;
        }
    }
     public void listarInactivos() throws Exception {
        DetalleDialectoDao dao;

        try {
            dao = new DetalleDialectoDao();
           lstDetalleDialecto = dao.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(DetalleDialecto detdia) throws Exception {
        DetalleDialectoDao dao;
        DetalleDialecto temp;

        try {
            dao = new DetalleDialectoDao();
            temp = dao.leerID(detdia);

            if (temp != null) {
                this.detalleDialecto = temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void modificar() throws Exception {
        DetalleDialectoDao dao;
        try {
            dao = new DetalleDialectoDao();
            dao.modificar(detalleDialecto);
            this.listarActivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(DetalleDialecto detdia) throws Exception {
        DetalleDialectoDao dao;
        try {
            dao = new DetalleDialectoDao();
            dao.eliminar(detdia);
            this.listarActivos();
        } catch (Exception e) {
            throw e;
        }
    }
    //Getter and Setter
      public DetalleDialecto getDetalleDialecto() {
        return detalleDialecto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }
    
    public void setDetalleDialecto(DetalleDialecto detalleDialecto) {
        this.detalleDialecto = detalleDialecto;
    }

    public List<DetalleDialecto> getLstDetalleDialecto() {
        return lstDetalleDialecto;
    }

    public void setLstDetalleDialecto(List<DetalleDialecto> lstDetalleDialecto) {
        this.lstDetalleDialecto = lstDetalleDialecto;
    }
}
