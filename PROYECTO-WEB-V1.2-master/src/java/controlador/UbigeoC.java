package controlador;

import dao.UbigeoDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Ubigeo;

@ManagedBean
@SessionScoped
public class UbigeoC {
    
    private Ubigeo ubigeo = new Ubigeo();

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }
    
    public void registrar() throws Exception{
        UbigeoDao dao;
        try {
            dao = new UbigeoDao();
            dao.Registrar(ubigeo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registrado"));
        } catch (Exception e) {
        }
    }
}
