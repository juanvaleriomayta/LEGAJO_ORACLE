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
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Empleado (DNI, Nom, Apel, Telf, GrupSang, RUC,Email,Cel,EstCiv,ConLab, "
                    + "Dialec,Lee,Habl,Escr,Est,FecNac, Desd, Has, FecIng) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CONVERT(date,?,103),CONVERT(date,?,103),CONVERT(date,?,103),CONVERT(date,?,103) )");
            st.setString(1, empl.getDNI());
            st.setString(2, empl.getNom());
            st.setString(3, empl.getApel());
            st.setString(4, empl.getTelf());
            st.setString(5, empl.getGrupSang());
            st.setString(6, empl.getRUC());
            st.setString(7, empl.getEmail());
            st.setString(8, empl.getCel());
            st.setString(9, empl.getEstCiv());
            st.setString(10, empl.getConLab());
            st.setString(11, empl.getDialec());
            st.setString(12, empl.getLee());
            st.setString(13, empl.getHabl());
            st.setString(14, empl.getEscr());
            st.setString(15, empl.getEst());
            st.setString(16, empl.getFecNac());
            st.setString(17, empl.getDesd());
            st.setString(18, empl.getHas());
            st.setString(19, empl.getFecIng());
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
        this.Conexion();
        try {
            String sql = "update Empleado set DNI=?, Nom=?, Apel=?, Telf=?, GrupSang=?, RUC=?,Email=?,Cel=?,EstCiv=?,ConLab=?, Dialec=?,Lee=?,Habl=?,Escr=?,Est=?,FecNac=?, Desd=?, Has=?, FecIng=? where idEmpl=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, emp.getDNI());
            st.setString(2, emp.getNom());
            st.setString(3, emp.getApel());
            st.setString(4, emp.getTelf());
            st.setString(5, emp.getGrupSang());
            st.setString(6, emp.getRUC());
            st.setString(7, emp.getEmail());
            st.setString(8, emp.getCel());
            st.setString(9, emp.getEstCiv());
            st.setString(10, emp.getConLab());
            st.setString(11, emp.getDialec());
            st.setString(12, emp.getLee());
            st.setString(13, emp.getHabl());
            st.setString(14, emp.getEscr());
            st.setString(15, emp.getEst());
            st.setString(16, emp.getFecNac());
            st.setString(17, emp.getDesd());
            st.setString(18, emp.getHas());
            st.setString(19, emp.getFecIng());
            st.setInt(20, emp.getIdEmpl());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<Empleado> listarEmp() throws Exception {
        this.Conexion();
        List<Empleado> lista;
        ResultSet rs;
        try {
            String sql = "select * from Empleado";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            Empleado model;
            while (rs.next()) {
                model = new Empleado();
                model.setDNI(rs.getString("DNI"));
                model.setNom(rs.getString("Nom"));
                model.setApel(rs.getString("Apel"));
                model.setTelf(rs.getString("Telf"));
                model.setGrupSang(rs.getString("GrupSang"));
                model.setRUC(rs.getString("RUC"));
                model.setFecNac(rs.getString("FecNac"));
                model.setEmail(rs.getString("Email"));
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
                model.setIdEmpl(rs.getInt("idEmpl"));
                lista.add(model);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public Empleado jalarDataEmpl(int cod) throws SQLException {
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "select  idEmpl, Nom,Apel,Telf,GrupSang,RUC,FecNac,Email,Cel,EstCiv,ConLab,FecIng,Desd,"
                    + "Has,Dialec,Lee,Habl,Escr,Est from Empleado where idEmpl = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            Empleado Emp = new Empleado();
            rs.next();
            Emp.setIdEmpl(rs.getInt("idEmpl"));
            Emp.setNom(rs.getString("Nom"));
            Emp.setApel(rs.getString("Apel"));
            Emp.setTelf(rs.getString("Telf"));
            Emp.setGrupSang(rs.getString("GrupSang"));
            Emp.setRUC(rs.getString("RUC"));
            Emp.setFecNac(rs.getString("FecNac"));
            Emp.setEmail(rs.getString("Email"));
            Emp.setCel(rs.getString("Cel"));
            Emp.setEstCiv(rs.getString("EstCiv"));
            Emp.setConLab(rs.getString("ConLab"));
            Emp.setFecIng(rs.getString("FecIng"));
            Emp.setDesd(rs.getString("Desd"));
            Emp.setHas(rs.getString("Has"));
            Emp.setDialec(rs.getString("Dialec"));
            Emp.setLee(rs.getString("Lee"));
            Emp.setHabl(rs.getString("Habl"));
            Emp.setEscr(rs.getString("Escr"));
            Emp.setEst(rs.getString("Est"));
            
            return Emp;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

}
