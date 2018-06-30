package bean;

import dao.UsuarioDao;
import modelo.Usuario;
import Services.Session;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;

@Data
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioC implements Serializable {

    //Objeto de Sesion
    private Usuario usuario = new Usuario();
    
    //Variables de Logeo
    private String User;
    private String Pass;

    public void IniciarSesion() throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            usuario = dao.IniciarSesion(User, Pass);
            if (usuario != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", usuario);
                switch (usuario.getTipoUsuario()) {
                    case "1":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/SistemaLegajo/faces/Vistas/Empleados/Empleados.xhtml");
                        break;
                    case "2":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/SistemaLegajo/faces/Vistas/Empleados/EmpleadosInac.xhtml");
                        break;
                }
            } else {
                setPass(null);
                usuario = new Usuario();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La Contraseña o el Usuario es Incorrecto"));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void finalizarSesion() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear(); //Cierra la Session
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SistemaLegajo"); // Mandamos al Login
    }

//    public void seguridadLogin() throws IOException {
//        Usuario us = Session.obtenerObjetoSesion();
//        if (us != null) {
//            switch (us.getTipoUsuario()) {
//                case "1":
//                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SistemaLegajo/faces/Vistas/Empleado/Empleado.xhtml");
//                    break;
//                case "2":
//                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SistemaLegajo/faces/Vistas/Empleado/EmpleadoInac.xhtml");
//                    break;
//            }
//        }
//    }

    public void seguridadSession() throws IOException {
        if (Session.obtenerObjetoSesion() == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SistemaRezola");
        }
    }

    public void obtenerDatos() {
        System.out.println(Session.ObtenerCodigoSesion());
        System.out.println(Session.ObtenerNombreSesion());
    }

}
