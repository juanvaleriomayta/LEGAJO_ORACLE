package bean;

import dao.EmpleadoDao;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.Empleado;
import services.SessionUtils;

@Data
@Named(value = "Login")
@SessionScoped
public class Login implements Serializable {

    //Objeto de Sesion
    private Empleado empleado = new Empleado();

    //Variables de Logeo
    private String DNI;
    private String Pass;

    public void startSessionEmpleado() throws Exception {
        EmpleadoDao dao;
        try {
            dao = new EmpleadoDao();
            empleado = dao.sessionEmpleado(DNI, Pass);
            if (empleado != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("DNI", empleado);

                FacesContext.getCurrentInstance().getExternalContext().redirect("/Legajo/Vistas/empleados/Empleados.xhtml");

            } else {
                setPass(null);
                empleado = new Empleado();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contraseña/Usuario Incorrecto"));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void finishSession() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear(); //Cierra la Session
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Legajo"); // Mandamos al Login
    }

    public void securityLogin() throws IOException {
        Empleado us = SessionUtils.obtenerObjetoSesion();
        if (us != null) {
            switch (us.getEst()) {
                case "A":
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/Legajo/Vistas/empleados/Empleados.xhtml");
                    break;                            
            }
        }
    }

    public void securitySession() throws IOException {
        if (SessionUtils.obtenerObjetoSesion() == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Legajo");
        }
    }

    public void obtenerDatos() {
        System.out.println(SessionUtils.ObtenerCodigoSesion());
        System.out.println(SessionUtils.ObtenerNombreSesion());
    }

}
