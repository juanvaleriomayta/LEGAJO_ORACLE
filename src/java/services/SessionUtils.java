package services;


import javax.faces.context.FacesContext;
import modelo.Usuario;

public class SessionUtils {

    public static Usuario obtenerObjetoSesion() {
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
    }

    public static String ObtenerNombreSesion() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
        if (us != null) {
            return us.getNombre();
        } else {
            return null;
        }
    }

    public static String ObtenerCodigoSesion() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
        if (us != null) {
            return us.getIdUsuario();
        } else {
            return null;
        }
    }

}
