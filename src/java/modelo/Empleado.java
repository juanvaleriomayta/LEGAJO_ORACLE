package modelo;

import java.sql.Date;


public class Empleado {
    private int codigo;
    private String Nom, Apel, Telf, GrupSang, RUC,Email, LugNac, Dir,Cel,EstCiv,ConLab,
            Dialec,Lee,Habl,Escr,Est;
    private Date fecNac, desd, has, fecIng;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        this.
                Nom = nom;
    }

    public String getApel() {
        return Apel;
    }

    public void setApel(String apel) {
        this.Apel = apel;
    }

    public String getTelf() {
        return Telf;
    }

    public void setTelf(String telf) {
        this.Telf = telf;
    }

    public String getGrupSang() {
        return GrupSang;
    }

    public void setGrupSang(String grupSang) {
        this.GrupSang = grupSang;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getLugNac() {
        return LugNac;
    }

    public void setLugNac(String LugNac) {
        this.LugNac = LugNac;
    }

    public String getDir() {
        return Dir;
    }

    public void setDir(String Dir) {
        this.Dir = Dir;
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

    public String getConLab() {
        return ConLab;
    }

    public void setConLab(String ConLab) {
        this.ConLab = ConLab;
    }

    public String getDialec() {
        return Dialec;
    }

    public void setDialec(String Dialec) {
        this.Dialec = Dialec;
    }

    public String getLee() {
        return Lee;
    }

    public void setLee(String Lee) {
        this.Lee = Lee;
    }

    public String getHabl() {
        return Habl;
    }

    public void setHabl(String Habl) {
        this.Habl = Habl;
    }

    public String getEscr() {
        return Escr;
    }

    public void setEscr(String Escr) {
        this.Escr = Escr;
    }

    public String getEst() {
        return Est;
    }

    public void setEst(String Est) {
        this.Est = Est;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public Date getDesd() {
        return desd;
    }

    public void setDesd(Date desd) {
        this.desd = desd;
    }

    public Date getHas() {
        return has;
    }

    public void setHas(Date has) {
        this.has = has;
    }

    public Date getFecIng() {
        return fecIng;
    }

    public void setFecIng(Date fecIng) {
        this.fecIng = fecIng;
    }

    public void add(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
