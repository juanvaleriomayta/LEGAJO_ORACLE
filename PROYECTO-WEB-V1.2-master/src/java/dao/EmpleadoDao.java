package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

public class EmpleadoDao extends Conexion {

    public void Registrar(Empleado empl) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Empleado (DNI, Nom, Apel, Telf, GrupSang, RUC,Email, LugNac, Dir,Cel,EstCiv,ConLab, Dialec,Lee,Habl,Escr,Est,FecNac, Desd, Has, FecIng) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )");
            st.setString(1, empl.getDNI());
            st.setString(2, empl.getNom());
            st.setString(3, empl.getApel());
            st.setString(4, empl.getTelf());
            st.setString(5, empl.getGrupSang());
            st.setString(6, empl.getRUC());
            st.setString(7, empl.getEmail());
            st.setString(8, empl.getLugNac());
            st.setString(9, empl.getDir());
            st.setString(10, empl.getCel());
            st.setString(11, empl.getEstCiv());
            st.setString(12, empl.getConLab());
            st.setString(13, empl.getDialec());
            st.setString(14, empl.getLee());
            st.setString(15, empl.getHabl());
            st.setString(16, empl.getEscr());
            st.setString(17, empl.getEst());
            st.setString(18, empl.getFecNac());
            st.setString(19, empl.getDesd());
            st.setString(20, empl.getHas());
            st.setString(21, empl.getFecIng());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
    public void Eliminar(Empleado emp) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE from Empleado where idEmpl=?");
            st.setInt(1, emp.getIdEmpl());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();

        }
    }
    
    
public void Modificar(Empleado emp) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("update Empleado set DNI=?, Nom=?, Apel=?, Telf=?, GrupSang=?, RUC=?,Email=?, LugNac=?, Dir=?,Cel=?,EstCiv=?,ConLab=?, Dialec=?,Lee=?,Habl=?,Escr=?,Est=?,FecNac=?, Desd=?, Has=?, FecIng=? where idEmpl=?");
            st.setString(1, emp.getDNI());
            st.setString(2, emp.getNom());
            st.setString(3, emp.getApel());
            st.setString(4, emp.getTelf());
            st.setString(5, emp.getGrupSang());
            st.setString(6, emp.getRUC());
            st.setString(7, emp.getEmail());
            st.setString(8, emp.getLugNac());
            st.setString(9, emp.getDir());
            st.setString(10, emp.getCel());
            st.setString(11, emp.getEstCiv());
            st.setString(12, emp.getConLab());
            st.setString(13, emp.getDialec());
            st.setString(14, emp.getLee());
            st.setString(15, emp.getHabl());
            st.setString(16, emp.getEscr());
            st.setString(17, emp.getEst());
            st.setString(18, emp.getFecNac());
            st.setString(19, emp.getDesd());
            st.setString(20, emp.getHas());
            st.setString(21, emp.getFecIng());
            st.setInt(22, emp.getIdEmpl());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();

        }
    }
    
public List<Empleado> listarEmp() throws Exception{
    List<Empleado> lista;
    ResultSet rs;
    try {
        this.Conexion();
        String sql = "select * from Empleado";
        PreparedStatement st = this.getCn().prepareCall(sql);
        rs = st.executeQuery();
        lista = new ArrayList();
        Empleado model ;
        while(rs.next()){
            model = new Empleado();
            model.setDNI(rs.getString("DNI"));
            model.setNom(rs.getString("Nom"));
            model.setApel(rs.getString("Apel"));
            model.setTelf(rs.getString("Tel"));
            model.setGrupSang(rs.getString("GrupSang"));
            model.setRUC(rs.getString("RUC"));
            model.setFecNac(rs.getString("FecNac"));
            model.setEmail(rs.getString("Email"));
            model.setLugNac(rs.getString("LugNac"));
            model.setDir(rs.getString("Dir"));
            model.setCel(rs.getString("Cel"));
            model.setEstCiv(rs.getString("EstCiv"));
            model.setConLab(rs.getString("ConLab"));
            model.setFecIng(rs.getString("FecIng"));
            model.setDesd(rs.getString("Desd"));
            model.setHas(rs.getString("Has"));
            model.setDialec(rs.getString("Dialec"));
            model.setLee(rs.getString("Lee"));
            model.setHabl(rs.getString("Habl"));
            model.setEscr(rs.getString("Escr"));
            model.setEst(rs.getString("Est"));
            lista.add(model);           
         } 
    } catch (SQLException e) {
        throw e;
    }
    return lista;
}

}


