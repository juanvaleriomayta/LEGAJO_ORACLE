package dao;

import dao.interaces.FamiliaresI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Familiares;

public class FamiliaresDao extends DAO implements FamiliaresI {

    @Override
    public void registrarFamiliar(Familiares fam) throws Exception {
        this.Conexion();
        try {
            String sql = "INSERT INTO Familiares  (NomFami,ApelFami,ParFami,OcuFami,FecNacFami,TelfFami,CelelularFami,EstCivFami,viveFami,EstadoFami, Empleado_idEmpl) values(?,?,?,?,?,CONVERT(DATE,?, 103),?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, fam.getNomFami());
            st.setString(2, fam.getApe());
            st.setString(3, fam.getPar());
            st.setString(4, fam.getOcu());
            st.setString(5, fam.getFecNac());
            st.setString(6, fam.getTel());
            st.setString(7, fam.getCel());
            st.setString(8, fam.getEstCiv());
            st.setString(9, fam.getVive());
            st.setString(10, fam.getEstado());
            st.setString(11, fam.getEmpleadoNom());
            st.setString(12, fam.getEmpleadoApe());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void registrar(Familiares fam) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO Familiares  (NomFami,ApelFami,ParFami,OcuFami,FecNacFami,TelfFami,CelelularFami,EstCivFami,viveFami,EstadoFami, Empleado_idEmpl) values(?,?,?,?,?,CONVERT(DATE,?, 103),?,?,?,?,?)";

            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, fam.getNomFami());
            st.setString(2, fam.getApe());
            st.setString(3, fam.getPar());
            st.setString(4, fam.getOcu());
            st.setString(5, fam.getFecNac());
            st.setString(6, fam.getTel());
            st.setString(7, fam.getCel());
            st.setString(8, fam.getEstCiv());
            st.setString(9, fam.getVive());
            st.setString(10, fam.getEstado());
            st.setString(11, fam.getEmpleadoNom());
            st.setString(12, fam.getEmpleadoApe());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Familiares> listar() throws Exception {
        List<Familiares> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "select * from vw_FamiEmplActi";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Familiares fam = new Familiares();
                fam.setNomFami(rs.getString("NomFami"));
                fam.setApe(rs.getString("ApelFami"));
                fam.setPar(rs.getString("ParFami"));
                fam.setOcu(rs.getString("OcuFami"));
                fam.setFecNac(rs.getString("FecNacFami"));
                fam.setTel(rs.getString("TelfFami"));
                fam.setCel(rs.getString("CelularFami"));
                fam.setEstCiv(rs.getString("EstCivFami"));
                fam.setVive(rs.getString("viveFami"));
                fam.setEstado(rs.getString("EstadoFami"));
                fam.setEmpleadoNom(rs.getString("Nombre del Empleado"));
                fam.setEmpleadoApe(rs.getString("Apellido del Empleado"));
                lista.add(fam);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<Familiares> listarInactivos() throws Exception {
        List<Familiares> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "select * from vw_FamiEmplInac";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Familiares fam = new Familiares();
                fam.setNomFami(rs.getString("NomFami"));
                fam.setApe(rs.getString("ApelFami"));
                fam.setPar(rs.getString("ParFami"));
                fam.setOcu(rs.getString("OcuFami"));
                fam.setFecNac(rs.getString("FecNacFami"));
                fam.setTel(rs.getString("TelfFami"));
                fam.setCel(rs.getString("CelularFami"));
                fam.setEstCiv(rs.getString("EstCivFami"));
                fam.setVive(rs.getString("viveFami"));
                fam.setEstado(rs.getString("EstadoFami"));
                fam.setEmpleadoNom(rs.getString("Nombre del Empleado"));
                fam.setEmpleadoApe(rs.getString("Apellido del Empleado"));
                lista.add(fam);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Familiares leerID(Familiares fam) throws Exception {
        Familiares fami = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT CodFami,NomFami,ApelFami,ParFami,OcuFami,CONVERT(nvarchar(10), FecNacFami, 103) AS FecNac,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami,Empleado_idEmpl FROM Familiares WHERE CodFami=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, fam.getCodFami());
            rs = st.executeQuery();
            while (rs.next()) {
                fami = new Familiares();
                fami.setCodFami(rs.getInt("CodFami"));
                fami.setNomFami(rs.getString("NomFami"));
                fami.setApe(rs.getString("ApelFami"));
                fami.setPar(rs.getString("ParFami"));
                fami.setOcu(rs.getString("OcuFami"));
                fami.setFecNac(rs.getString("FecNacFami"));
                fami.setTel(rs.getString("TelfFami"));
                fami.setCel(rs.getString("CelularFami"));
                fami.setEstCiv(rs.getString("EstCivFami"));
                fami.setVive(rs.getString("viveFami"));
                fami.setEstado(rs.getString("EstadoFami"));
                fami.setEmpleadoNom(rs.getString("Nombre del Empleado"));
                fami.setEmpleadoApe(rs.getString("Apellido del Empleado"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return fami;
    }

    @Override
    public void modificar(Familiares fam) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE Familiares SET  NomFami = ?, ApelFami = ?,ParFami = ?, OcuFami = ?, FecNacFami = convert(date, ?, 103),TelfFami = ?, CelularFami = ?, EstCivFami = ?, viveFami = ?,EstadoFami = ?,Empleado_idEmpl WHERE CodFami = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, fam.getNomFami());
            st.setString(2, fam.getApe());
            st.setString(3, fam.getPar());
            st.setString(4, fam.getOcu());
            st.setString(5, fam.getFecNac());
            st.setString(6, fam.getTel());
            st.setString(7, fam.getCel());
            st.setString(8, fam.getEstCiv());
            st.setString(9, fam.getVive());
            st.setString(10, fam.getEstado());
            st.setString(11, fam.getEmpleadoNom());
            st.setString(12, fam.getEmpleadoApe());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Familiares fam) throws Exception {
        try {
            this.Conexion();
            String sql = "Update Familiares set Estado = 'I' Where CodFami = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, fam.getCodFami());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
