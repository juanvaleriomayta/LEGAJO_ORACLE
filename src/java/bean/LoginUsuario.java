package bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "LoginUsuario")
@SessionScoped
public class LoginUsuario implements Serializable{
    
    
    private String user;

    public void inicioSession() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", user);
    }

    public void obtenerSession() {
        System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username"));
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
