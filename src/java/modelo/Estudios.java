package modelo;


public class Estudios {
    private int IdEstuGenEmpl;
    private String DatSuper,tipGraAca,Desd,Has,Carre,CentEstuSecun;

    public int getIdEstuGenEmpl() {
        return IdEstuGenEmpl;
    }

    public String getCentEstuSecun() {
        return CentEstuSecun;
    }

    public void setCentEstuSecun(String CentEstuSecun) {
        this.CentEstuSecun = CentEstuSecun;
    }

    public void setIdEstuGenEmpl(int IdEstuGenEmpl) {
        this.IdEstuGenEmpl = IdEstuGenEmpl;
    }

    public String getDatSuper() {
        return DatSuper;
    }

    public void setDatSuper(String DatSuper) {
        this.DatSuper = DatSuper;
    }

    public String getTipGraAca() {
        return tipGraAca;
    }

    public void setTipGraAca(String tipGraAca) {
        this.tipGraAca = tipGraAca;
    }

    public String getDesd() {
        return Desd;
    }

    public void setDesd(String Desd) {
        this.Desd = Desd;
    }

    public String getHas() {
        return Has;
    }

    public void setHas(String Has) {
        this.Has = Has;
    }

    public String getCarre() {
        return Carre;
    }

    public void setCarre(String Carre) {
        this.Carre = Carre;
    }
}
