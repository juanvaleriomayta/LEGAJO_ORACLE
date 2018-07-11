package services;

import modelo.Empleado;
import javax.faces.context.FacesContext;

public class SessionUtils {

    public static Empleado obtenerObjetoSesion() {
        return (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
    }

    public static String ObtenerNombreSesion() {
        Empleado us = (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            return us.getNom();
        } else {
            return null;
        }
    }

    public static String ObtenerCodigoSesion() {
        Empleado us = (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            return us.getIdEmpl();
        } else {
            return null;
        }
    }

}
