package Services;

import modelo.Usuario;
import javax.faces.context.FacesContext;

public class Session {

    public static Usuario obtenerObjetoSesion() {
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
    }

    public static String ObtenerNombreSesion() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            return us.getNomUsuario();
        } else {
            return null;
        }
    }

    public static String ObtenerCodigoSesion() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            return us.getIdUsuario();
        } else {
            return null;
        }
    }

}
