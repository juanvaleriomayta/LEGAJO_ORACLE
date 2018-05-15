package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

public class EmpleadoDao extends DAO {

    public void registrar(Empleado emp) throws Exception {
        try {
            this.Conexion();

            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Empleado (DNI,Nom,ApelPate,ApelMate,RUC,Email,Telf,Cel,FecNac,GrupSang,EstCiv,ConLab,CarnAseg,Refe,Leye,FecIng,FecNom,DatCony,UbigActu,UbigOrig,Est) values(?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?,?)");
            st.setString(1, emp.getDNI());
            st.setString(2, emp.getNom());
            st.setString(3, emp.getApelPate());
            st.setString(4, emp.getApelMate());
            st.setString(5, emp.getRUC());
            st.setString(6, emp.getEmail());
            st.setString(7, emp.getTelf());
            st.setString(8, emp.getCel());
            st.setString(9, emp.getFecNac());
            st.setString(10, emp.getGrupSang());
            st.setString(11, emp.getEstCiv());
            st.setString(12, emp.getConLab());
            st.setString(13, emp.getCarnAseg());
            st.setString(14, emp.getRefe());
            st.setString(15, emp.getLeye());
            st.setString(16, emp.getFecIng());
            st.setString(17, emp.getFecNom());
            st.setString(18, emp.getDatCony());
            st.setString(19, emp.getUbigActu());
            st.setString(20, emp.getUbigOrig());
            st.setString(21, emp.getEst());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public List<Empleado> listar() throws Exception {
        List<Empleado> lista;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT idEmpl, DNI,Nom,ApelPate,ApelMate,RUC,Email,Telf,Cel,FecNac,GrupSang,EstCiv,ConLab,CarnAseg,Refe,Leye,FecIng,FecNom,DatCony,UbigActu,UbigOrig,Est FROM Empleado");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setIdEmpl(rs.getInt("idEmpl"));
                emp.setDNI(rs.getString("DNI"));
                emp.setNom(rs.getString("Nom"));
                emp.setApelPate(rs.getString("ApelPate"));
                emp.setApelMate(rs.getString("ApelMate"));
                emp.setRUC(rs.getString("RUC"));
                emp.setEmail(rs.getString("Email"));
                emp.setTelf(rs.getString("Telf"));
                emp.setCel(rs.getString("Cel"));
                emp.setFecNac(rs.getString("FecNac"));
                emp.setGrupSang(rs.getString("GrupSang"));
                emp.setEstCiv(rs.getString("EstCiv"));
                emp.setConLab(rs.getString("ConLab"));
                emp.setCarnAseg(rs.getString("CarnAseg"));
                emp.setRefe(rs.getString("Refe"));
                emp.setLeye(rs.getString("Leye"));
                emp.setFecIng(rs.getString("FecIng"));
                emp.setFecNom(rs.getString("FecNom"));
                emp.setDatCony(rs.getString("DatCony"));
                emp.setUbigActu(rs.getString("UbigActu"));
                emp.setUbigOrig(rs.getString("UbigOrig"));
                emp.setEst(rs.getString("Est"));

                lista.add(emp);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public Empleado leerID(Empleado emp) throws Exception {
        Empleado emple = null;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT idEmpl, DNI,Nom,ApelPate,ApelMate,RUC,Email,Telf,Cel,FecNac,GrupSang,EstCiv,ConLab,CarnAseg,Refe,Leye,FecIng,FecNom,DatCony,UbigActu,UbigOrig,Est FROM Empleado WHERE idEmpl=?");
            st.setInt(1, emp.getIdEmpl());
            rs = st.executeQuery();
            while (rs.next()) {
                emple = new Empleado();
                emple.setIdEmpl(rs.getInt("idEmpl"));
                emple.setDNI(rs.getString("DNI"));
                emple.setNom(rs.getString("Nom"));
                emple.setApelPate(rs.getString("ApelPate"));
                emple.setApelMate(rs.getString("ApelMate"));
                emple.setRUC(rs.getString("RUC"));
                emple.setEmail(rs.getString("Email"));
                emple.setTelf(rs.getString("Telf"));
                emple.setCel(rs.getString("Cel"));
                emple.setFecNac(rs.getString("FecNac"));
                emple.setGrupSang(rs.getString("GrupSang"));
                emple.setEstCiv(rs.getString("EstCiv"));
                emple.setConLab(rs.getString("ConLab"));
                emple.setCarnAseg(rs.getString("CarnAseg"));
                emple.setRefe(rs.getString("Refe"));
                emple.setLeye(rs.getString("Leye"));
                emple.setFecIng(rs.getString("FecIng"));
                emple.setFecNom(rs.getString("FecNom"));
                emple.setDatCony(rs.getString("DatCony"));
                emple.setUbigActu(rs.getString("UbigActu"));
                emple.setUbigOrig(rs.getString("UbigOrig"));
                emple.setEst(rs.getString("Est"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return emple;
    }

    public void modificar(Empleado emp) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Empleado SET DNI = ?, Nom = ?, ApelPate = ?, ApelMate = ?,RUC = ?, Email = ?,Telf = ?,Cel = ?,FecNac = ?,GrupSang = ?,EstCiv = ?,ConLab = ?,CarnAseg = ?,Refe = ?,Leye = ?,FecIng = ?,FecNom = ?,DatCony = ?,UbigActu = ?,UbigOrig = ?,Est = ? WHERE idEmpl = ?");
            st.setString(1, emp.getDNI());
            st.setString(2, emp.getNom());
            st.setString(3, emp.getApelPate());
            st.setString(4, emp.getApelMate());
            st.setString(5, emp.getRUC());
            st.setString(6, emp.getEmail());
            st.setString(7, emp.getTelf());
            st.setString(8, emp.getCel());
            st.setString(9, emp.getFecNac());
            st.setString(10, emp.getGrupSang());
            st.setString(11, emp.getEstCiv());
            st.setString(12, emp.getConLab());
            st.setString(13, emp.getCarnAseg());
            st.setString(14, emp.getRefe());
            st.setString(15, emp.getLeye());
            st.setString(16, emp.getFecIng());
            st.setString(17, emp.getFecNom());
            st.setString(18, emp.getDatCony());
            st.setString(19, emp.getUbigActu());
            st.setString(20, emp.getUbigOrig());
            st.setString(21, emp.getEst());
            st.setInt(22, emp.getIdEmpl());
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(Empleado emp) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Empleado WHERE idEmpl = ?");
            st.setInt(1, emp.getIdEmpl());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
