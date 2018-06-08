package modelo;

public class DetalleDialecto {
    private int idDetDial;
    private String Lee,Habla,Escribe,Estado;

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getIdDetDial() {
        return idDetDial;
    }

    public void setIdDetDial(int idDetDial) {
        this.idDetDial = idDetDial;
    }

    public String getLee() {
        return Lee;
    }

    public void setLee(String Lee) {
        this.Lee = Lee;
    }

    public String getHabla() {
        return Habla;
    }

    public void setHabla(String Habla) {
        this.Habla = Habla;
    }

    public String getEscribe() {
        return Escribe;
    }

    public void setEscribe(String Escribe) {
        this.Escribe = Escribe;
    }

}