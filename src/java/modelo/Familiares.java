package modelo;

public class Familiares {

    private int CodFami;
    private String Nom, Ape, Par, Ocu, FecNac, Tel, Cel, EstCiv, vive, Estado;
    private Empleado empleado;

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getCodFami() {
        return CodFami;
    }

    public void setCodFami(int CodFami) {
        this.CodFami = CodFami;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getApe() {
        return Ape;
    }

    public void setApe(String Ape) {
        this.Ape = Ape;
    }

    public String getPar() {
        return Par;
    }

    public void setPar(String Par) {
        this.Par = Par;
    }

    public String getOcu() {
        return Ocu;
    }

    public void setOcu(String Ocu) {
        this.Ocu = Ocu;
    }

    public String getFecNac() {
        return FecNac;
    }

    public void setFecNac(String FecNac) {
        this.FecNac = FecNac;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getCel() {
        return Cel;
    }

    public void setCel(String Cel) {
        this.Cel = Cel;
    }

    public String getEstCiv() {
        return EstCiv;
    }

    public void setEstCiv(String EstCiv) {
        this.EstCiv = EstCiv;
    }

    public String getVive() {
        return vive;
    }

    public void setVive(String vive) {
        this.vive = vive;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
