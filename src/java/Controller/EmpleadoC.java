package Controller;

import dao.ImplEmpleadoD;
import dao.ImplReportEmpleadoD;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.EmpleadoM;

@Data
@ManagedBean
@SessionScoped
public class EmpleadoC implements Serializable {

    private EmpleadoM empleado = new EmpleadoM();
    private List<EmpleadoM> lstEmpleado;
    private String accion;

    private String CodigoTemporal;

    public void redireccion() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(EmpleadoC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> completeText(String query) throws SQLException, Exception {
        ImplEmpleadoD ImplDAO = new ImplEmpleadoD();
        return ImplDAO.autocompleteEmpleado(query);
    }

    public void ingresarEmpleado() throws Exception {
        ImplEmpleadoD ImplDAO;

        try {
            ImplDAO = new ImplEmpleadoD();
            ImplDAO.registrarEmpleado(empleado);
            CodigoTemporal = ImplDAO.CodigoEmpleado(empleado.getDNI());
            this.limpiar();
            this.listarActivosNombrados();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("REGISTRADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR AL MOMENTO DE INGRESAR"));
            throw e;
        }
    }

    public void operarCas() throws Exception {
        switch (accion) {
            case "Registrar":
                this.registrarCas();
                break;
            case "Modificar":
                this.modificar();
                break;
        }
    }

    public void operarCesante() throws Exception {
        switch (accion) {
            case "Registrar":
                this.registrarCas();
                break;
            case "Modificar":
                this.modificar();
                break;
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

    public void operarNombrado() throws Exception {
        switch (accion) {
            case "Registrar":
                this.registrarNombrado();
                break;
            case "Modificar":
                this.modificar();
                break;
        }
    }

    public void registrarCas() throws Exception {
        ImplEmpleadoD ImplDAO;
        try {
            ImplDAO = new ImplEmpleadoD();
            ImplDAO.registrarCAS(empleado);
            listarActivosNombrados();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("REGISTRADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR AL MOMENTO DE INGRESAR"));
            throw e;

        }
    }

    public void registrarCesante() throws Exception {
        ImplEmpleadoD ImplDAO;

        try {
            ImplDAO = new ImplEmpleadoD();
            ImplDAO.registrarCESANTE(empleado);
            listarActivosNombrados();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("REGISTRADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR AL MOMENTO DE INGRESAR"));
            throw e;

        }
    }

    public void registrar() throws Exception {
        ImplEmpleadoD ImplDAO;

        try {
            ImplDAO = new ImplEmpleadoD();
            ImplDAO.registrarEmpleado(empleado);
            listarActivosNombrados();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("REGISTRADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR AL MOMENTO DE INGRESAR"));
            throw e;

        }
    }

    public void registrarNombrado() throws Exception {
        ImplEmpleadoD ImplDAO;

        try {
            ImplDAO = new ImplEmpleadoD();
            ImplDAO.registrarNombrado(empleado);
            listarActivosNombrados();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("REGISTRADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR AL MOMENTO DE INGRESAR"));
            throw e;

        }
    }

    public void listarActivosNombrados() throws Exception {
        ImplEmpleadoD ImplDAO;

        try {
            ImplDAO = new ImplEmpleadoD();
            lstEmpleado = ImplDAO.listarActivosNombrados();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarActivosCas() throws Exception {
        ImplEmpleadoD ImplDAO;

        try {
            ImplDAO = new ImplEmpleadoD();
            lstEmpleado = ImplDAO.listarActivosCas();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarActivosCesante() throws Exception {
        ImplEmpleadoD ImplDAO;

        try {
            ImplDAO = new ImplEmpleadoD();
            lstEmpleado = ImplDAO.listarActivosCesante();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        ImplEmpleadoD ImplDAO;

        try {
            ImplDAO = new ImplEmpleadoD();
            lstEmpleado = ImplDAO.listarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(String emp) throws Exception {
        ImplEmpleadoD ImplDAO;
        try {
            ImplDAO = new ImplEmpleadoD();
            this.empleado = ImplDAO.leerID(emp);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        ImplEmpleadoD ImplDAO;

        try {
            ImplDAO = new ImplEmpleadoD();
            ImplDAO.modificar(empleado);
            listarActivosNombrados();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(EmpleadoM emp) throws Exception {
        ImplEmpleadoD ImplDAO;
        try {
            ImplDAO = new ImplEmpleadoD();
            ImplDAO.eliminar(emp);
            listarActivosNombrados();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
        empleado = new EmpleadoM();
    }

    //    Funcionalidad generar eh madar a descargar reportes
    // Recibe el codigo del empleado
    public void decargar(String CodigoEmpleado) throws Exception {
        ImplReportEmpleadoD report = new ImplReportEmpleadoD();
        try {
            Map<String, Object> parameters = new HashMap(); // Libro de parametros
            parameters.put("Codigo", CodigoEmpleado); //Insertamos un parametro
            report.exportarPDF(parameters); //Pido exportar Reporte con los parametros
//            report.exportarPDF2(parameters);
        } catch (Exception e) {
            throw e;
        }
    }
}
