package dao;

import dao.interaces.EmergenciasI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Emergencia;

public class EmergenciaDao extends DAO implements EmergenciasI {

    @Override
    public void registrarEmergencia(Emergencia eme) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO Emergencia (NomEmer, ApeEmer,ParenEmer,TelEmer,CelularEmer,EstadoEmer, Empleado_idEmpl) values(?,?,?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, eme.getNomEmer());
            st.setString(2, eme.getApeEmer());
            st.setString(3, eme.getParenEmer());
            st.setString(4, eme.getTelEmer());
            st.setString(5, eme.getCelEmer());
            st.setString(6, eme.getEstadoEmer());
            st.setString(7, eme.getEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void registrar(Emergencia eme) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO Emergencia (NomEmer, ApeEmer,ParenEmer,TelEmer,CelularEmer,EstadoEmer,Empleado_idEmpl) values(?,?,?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, eme.getNomEmer());
            st.setString(2, eme.getApeEmer());
            st.setString(3, eme.getParenEmer());
            st.setString(4, eme.getTelEmer());
            st.setString(5, eme.getCelEmer());
            st.setString(6, eme.getEstadoEmer());
            st.setString(7, eme.getEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Emergencia> listar() throws Exception {
        List<Emergencia> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT * FROM vw_EmerEmplActi";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Emergencia eme = new Emergencia();
                eme.setNomEmer(rs.getString("NomEmer"));
                eme.setApeEmer(rs.getString("ApeEmer"));
                eme.setParenEmer(rs.getString("ParenEmer"));
                eme.setTelEmer(rs.getString("TelEmer"));
                eme.setCelEmer(rs.getString("CelularEmer"));
                eme.setEstadoEmer(rs.getString("EstadoEmer"));
                eme.setEmpleado(rs.getString("Empleado_idEmpl"));

                lista.add(eme);

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<Emergencia> listarInactivos() throws Exception {
        List<Emergencia> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT * FROM vw_EmerEmplInac";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Emergencia eme = new Emergencia();
                eme.setNomEmer(rs.getString("NomEmer"));
                eme.setApeEmer(rs.getString("ApeEmer"));
                eme.setParenEmer(rs.getString("ParenEmer"));
                eme.setTelEmer(rs.getString("TelEmer"));
                eme.setCelEmer(rs.getString("CelularEmer"));
                eme.setEstadoEmer(rs.getString("EstadoEmer"));
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
    public Emergencia leerID(Emergencia eme) throws Exception {
        Emergencia emer = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT IdEmerg, NomEmer, ApeEmer,ParenEmer,TelEmer,CelularEmer,EstadoEmer, Empleado_idEmpl FROM Emergencia WHERE IdEmerg=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, eme.getIdEmerg());
            rs = st.executeQuery();
            while (rs.next()) {
                emer = new Emergencia();
                emer.setIdEmerg(rs.getInt("IdEmerg"));
                emer.setNomEmer(rs.getString("NomEmer"));
                emer.setApeEmer(rs.getString("ApeEmer"));
                emer.setParenEmer(rs.getString("ParenEmer"));
                emer.setTelEmer(rs.getString("TelEmer"));
                emer.setCelEmer(rs.getString("CelularEmer"));
                emer.setEstadoEmer(rs.getString("EstadoEmer"));
                emer.setEmpleado(rs.getString("Empleado_idEmpl"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return emer;
    }

    @Override
    public void modificar(Emergencia eme) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE Emergencia SET NomEmer=?, ApeEmer=?,ParenEmer=?,TelEmer=?,CelularEmer=?,EstadoEmer=?,Empleado_idEmpl=? WHERE IdEmerg = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, eme.getNomEmer());
            st.setString(2, eme.getApeEmer());
            st.setString(3, eme.getParenEmer());
            st.setString(4, eme.getTelEmer());
            st.setString(5, eme.getCelEmer());
            st.setString(6, eme.getEstadoEmer());
            st.setString(7, eme.getEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Emergencia eme) throws Exception {
        try {
            this.Conexion();
            String sql = "Update Emergencia set Estado = 'Inactivo' where IdEmerg=?";
            //String sql = "DELETE FROM Emergencia WHERE IdEmerg = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, eme.getIdEmerg());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
