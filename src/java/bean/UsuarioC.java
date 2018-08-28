package bean;

import dao.UsuarioDao;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import modelo.Usuario;
import org.primefaces.context.RequestContext;
import services.SessionUtils;

@Data
@Named(value = "Login")
@SessionScoped
public class UsuarioC implements Serializable {

    //Objeto de Sesion
    private Usuario usuario = new Usuario();

    private List<Usuario> lstUsuario;
    private String accion;

    //Variables de Logeo
    private String IdUsuario;
    private String NombreUsuario;
    private String Pass;
    private String Nombre;
    private String Estado;
    private int intentos, number;

    public void increment() {
        number++;
        if (number > 5) {
            number = 0;
            intentos = 0;
            RequestContext.getCurrentInstance().execute(" location.reload (); ");
        }
    }

    public void startSessionEmpleado() throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            usuario = dao.IniciarSesion(NombreUsuario, Pass);
            if (getUsuario() != null) {
                intentos = 0;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", getUsuario());
                switch (usuario.getNivel()) {
                    case "admin":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/Legajo/Vistas/template/MensajeUsuario.xhtml");
                        break;
                    case "user":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/Legajo/Vistas/template/MensajeUsuario.xhtml");
                        break;
                }
            } else {
                setPass(null);
                usuario = new Usuario();
                intentos++;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CONTRASEÑA O USUARIO INCORRECTO"));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void finishSession() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear(); //Cierra la Session
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Legajo"); // Mandamos al UsuarioC
    }

    public void securityLogin() throws IOException {
        Usuario us = SessionUtils.obtenerObjetoSesion();
        if (us != null) {
            switch (us.getNivel()) {
                case "admin":
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/Legajo/Vistas/template/MensajeUsuario.xhtml");
                    break;
                case "user":
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/Legajo/Vistas/template/MensajeUsuario.xhtml");
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

    public void registrar() throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            dao.Registrar(getUsuario());
            limpiar();
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
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
        usuario = new Usuario();
    }

    public void listar() throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            lstUsuario = dao.Listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarInactivos() throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            lstUsuario = dao.ListarInactivos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            dao.Modificar(usuario);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "CORREGIR LOS DATOS"));
            throw e;
        }
    }

    public void eliminar(Usuario user) throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            dao.Eliminar(user);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ELIMINADO", "CORRECTAMENTE"));
        } catch (Exception e) {
            throw e;
        }

    }

    public void leerID(String Codigo) throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            this.usuario = dao.LeerId(Codigo);
            this.accion = "Modificar";
        } catch (Exception e) {
            throw e;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(List<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();
        this.accion = accion;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
