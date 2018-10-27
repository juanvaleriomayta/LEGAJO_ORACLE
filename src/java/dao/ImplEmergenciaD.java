package dao;

import Interfaces.EmergenciasI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EmergenciaM;

public class ImplEmergenciaD extends ImplDAO implements EmergenciasI {

    @Override
    public void registrarEmergencia(EmergenciaM eme) throws Exception {
        try {
            this.Conexion();
            String sql = "EXEC SP_EMERGENCIA ?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, eme.getNomEmer());
            st.setString(2, eme.getApeEmer());
            st.setString(3, eme.getParenEmer());
            st.setString(4, eme.getTelEmer());
            st.setString(5, eme.getCelEmer());
            st.setString(6, "A");
            st.setString(7, eme.getCodEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<String> autocompleteEmpleado(String Consulta) throws SQLException, Exception {
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

    @Override
    public void registrar(EmergenciaM eme) throws Exception {
        try {
            this.Conexion();
            String sql = "EXEC SP_EMERGENCIA ?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, eme.getNomEmer());
            st.setString(2, eme.getApeEmer());
            st.setString(3, eme.getParenEmer());
            st.setString(4, eme.getTelEmer());
            st.setString(5, eme.getCelEmer());
            st.setString(6, "A");
            st.setString(7, eme.getCodEmpleado());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<EmergenciaM> listar() throws Exception {
        List<EmergenciaM> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT * FROM vw_EmerEmplActi";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EmergenciaM eme = new EmergenciaM();
                eme.setIdEmerg(rs.getString("IdEmerg"));
                eme.setNomEmer(rs.getString("NomEmer"));
                eme.setApeEmer(rs.getString("ApeEmer"));
                eme.setParenEmer(rs.getString("ParenEmer"));
                eme.setTelEmer(rs.getString("TelEmer"));
                eme.setCelEmer(rs.getString("CelularEmer"));
                eme.setEstadoEmer(rs.getString("EstadoEmer"));
                eme.setEmpleado(rs.getString("Empleado"));
                lista.add(eme);

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<EmergenciaM> listarInactivos() throws Exception {
        List<EmergenciaM> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT * FROM vw_EmerEmplInac";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EmergenciaM eme = new EmergenciaM();
                eme.setIdEmerg(rs.getString("IdEmerg"));
                eme.setNomEmer(rs.getString("NomEmer"));
                eme.setApeEmer(rs.getString("ApeEmer"));
                eme.setParenEmer(rs.getString("ParenEmer"));
                eme.setTelEmer(rs.getString("TelEmer"));
                eme.setCelEmer(rs.getString("CelularEmer"));
                eme.setEstadoEmer(rs.getString("EstadoEmer"));
                eme.setEmpleado(rs.getString("Empleado"));
                lista.add(eme);

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public EmergenciaM leerID(String Codigo) throws Exception {
        EmergenciaM emer = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT IdEmerg,NomEmer, ApeEmer, ParenEmer, TelEmer, CelularEmer, EstadoEmer, UPPER(CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado' FROM Emergencia LEFT OUTER JOIN Empleado on Emergencia.Empleado_idEmpl = Empleado.idEmpl WHERE IdEmerg=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, Codigo);
            rs = st.executeQuery();
            while (rs.next()) {
                emer = new EmergenciaM();
                emer.setIdEmerg(rs.getString("IdEmerg"));
                emer.setNomEmer(rs.getString("NomEmer"));
                emer.setApeEmer(rs.getString("ApeEmer"));
                emer.setParenEmer(rs.getString("ParenEmer"));
                emer.setTelEmer(rs.getString("TelEmer"));
                emer.setCelEmer(rs.getString("CelularEmer"));
                emer.setEstadoEmer(rs.getString("EstadoEmer"));
                emer.setEmpleado(rs.getString("Empleado"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return emer;
    }

    @Override
    public void modificar(EmergenciaM eme) throws Exception {
        try {
            this.Conexion();
            String sql = "SP_EMERGENCIA_UPDATE ?,?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, eme.getIdEmerg());
            st.setString(2, eme.getNomEmer());
            st.setString(3, eme.getApeEmer());
            st.setString(4, eme.getParenEmer());
            st.setString(5, eme.getTelEmer());
            st.setString(6, eme.getCelEmer());
            st.setString(7, eme.getEstadoEmer());
            st.setString(8, eme.getCodEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(EmergenciaM eme) throws Exception {
        try {
            this.Conexion();
            String sql = "Update Emergencia set EstadoEmer = 'I' where IdEmerg=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, eme.getIdEmerg());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
