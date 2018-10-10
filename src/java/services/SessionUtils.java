package services;


import javax.faces.context.FacesContext;

import modelo.UsuarioM;

public class SessionUtils {

    public static UsuarioM obtenerObjetoSesion() {
        return (UsuarioM) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
    }

    public static String ObtenerNombreSesion() {
        UsuarioM us = (UsuarioM) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
        if (us != null) {
            return us.getNombre();
        } else {
            return null;
        }
    }

    public static String ObtenerCodigoSesion() {
        UsuarioM us = (UsuarioM) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario");
        if (us != null) {
            return us.getIdUsuario();
        } else {
            return null;
        }
    }

}
