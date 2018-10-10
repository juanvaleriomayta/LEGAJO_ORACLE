package dao;

import Interfaces.FamiliaresI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.FamiliaresM;

public class ImplFamiliaresD extends ImplDAO implements FamiliaresI {

    @Override
    public void registrarFamiliar(FamiliaresM fam) throws Exception {
        this.Conexion();
        try {
            String sql = "EXEC SP_FAMILIARES ?,?,?,?,?,?,?,?,?,?,?";
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
            st.setString(10, "A");
            st.setString(11, fam.getCodiEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void registrar(FamiliaresM fam) throws Exception {
        try {
            this.Conexion();

            String sql = "EXEC SP_FAMILIARES ?,?,?,?,?,?,?,?,?,?,?";
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
            st.setString(10, "A");
            st.setString(11, fam.getCodiEmpleado());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<FamiliaresM> listar() throws Exception {
        List<FamiliaresM> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "select * from vw_FamiEmplActi";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                FamiliaresM fam = new FamiliaresM();
                fam.setCodFami(rs.getString("idFami"));
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
                fam.setEmpleado(rs.getString("Empleado"));

                lista.add(fam);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<String> autocompleteEmpleado(String Consulta) throws SQLException {
        this.Conexion();
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "select concat(Nom,',',ApelPate,',',ApelMate) AS Empleado from Empleado where UPPER(Nom) like UPPER(?) or UPPER(ApelPate) like UPPER(?)  or UPPER(ApelMate) like UPPER(?)";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {

                Lista.add(rs.getString("Empleado"));
            }
            return Lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<FamiliaresM> listarInactivos() throws Exception {
        List<FamiliaresM> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "select * from vw_FamiEmplInac";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                FamiliaresM fam = new FamiliaresM();
                fam.setCodFami(rs.getString("idFami"));
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
                fam.setEmpleado(rs.getString("Empleado"));
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
    public FamiliaresM leerID(String Codigo) throws Exception {
        FamiliaresM fami = null;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT idFami,NomFami,ApelFami,ParFami,OcuFami,CONVERT(nvarchar(10), FecNacFami, 103) AS FecNacFami,TelfFami,CelularFami,EstCivFami,viveFami,EstadoFami,UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado' FROM Familiares LEFT OUTER JOIN Empleado on Familiares.Empleado_idEmpl = Empleado.idEmpl  WHERE idFami=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, Codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                fami = new FamiliaresM();
                fami.setCodFami(rs.getString("idFami"));
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
                fami.setEmpleado(rs.getString("Empleado"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return fami;
    }

    @Override
    public void modificar(FamiliaresM fam) throws Exception {
        try {
            this.Conexion();
            String sql = "SP_FAMILIARES_UPDATE ?,?,?,?,?,?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, fam.getCodFami());
            st.setString(2, fam.getNomFami());
            st.setString(3, fam.getApe());
            st.setString(4, fam.getPar());
            st.setString(5, fam.getOcu());
            st.setString(6, fam.getFecNac());
            st.setString(7, fam.getTel());
            st.setString(8, fam.getCel());
            st.setString(9, fam.getEstCiv());
            st.setString(10, fam.getVive());
            st.setString(11, fam.getEstado());
            st.setString(12, fam.getCodiEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(FamiliaresM fam) throws Exception {
        try {
            this.Conexion();
            String sql = "Update Familiares set EstadoFami = 'I' Where idFami = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, fam.getCodFami());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
