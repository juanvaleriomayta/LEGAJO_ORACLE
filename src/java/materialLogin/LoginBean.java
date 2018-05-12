/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package materialLogin;



import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

/**
 *
 * @author JUAN VALERIO
 */
@Named(value = "login")
@RequestScoped
public class LoginBean {

    private String DNIUsuario;
    private String Clave;

    public String getDNIUsuario() {
        return DNIUsuario;
    }

    public void setDNIUsuario(String DNIUsuario) {
        this.DNIUsuario = DNIUsuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }
    
    public LoginBean() {
    }
    
    public void login(){
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("swal('login success!','Congratulation! you are logged in','success')");
    }
}
