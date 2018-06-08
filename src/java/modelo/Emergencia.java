package modelo;


public class Emergencia {
    
    private int IdEmerg;
    private String Nom,Ape,Paren,Tel,Cel,Estado;

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIdEmerg() {
        return IdEmerg;
    }

    public void setIdEmerg(int IdEmerg) {
        this.IdEmerg = IdEmerg;
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

    public String getParen() {
        return Paren;
    }

    public void setParen(String Paren) {
        this.Paren = Paren;
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
    
    
}
