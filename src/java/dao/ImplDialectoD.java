package dao;


import Interfaces.DialectoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DialectoM;

public class ImplDialectoD extends ImplDAO implements DialectoI {

    @Override
    public void registrar(DialectoM dia) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO Dialecto (NomDial) values(?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, dia.getNomDial());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public String obtenerCodigoDialecto(String Dialecto) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "select IdDial from Dialecto where NomDial like ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Dialecto);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("IdDial");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<String> autocompleteDialecto(String Consulta) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "select NomDial from Dialecto where NomDial like ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {

                Lista.add(rs.getString("NomDial"));
            }
            return Lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<DialectoM> listar() throws Exception {
        List<DialectoM> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT * FROM Dialecto";
//            String sql = "SELECT IdDial, NomDial FROM Dialecto";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                DialectoM dia = new DialectoM();
                dia.setIdDial(rs.getInt("IdDial"));
                dia.setNomDial(rs.getString("NomDial"));
                lista.add(dia);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public DialectoM leerID(DialectoM dia) throws Exception {
        DialectoM dial = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT IdDial,NomDial  FROM Dialecto WHERE IdDial=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, dia.getIdDial());
            rs = st.executeQuery();
            while (rs.next()) {
                dial = new DialectoM();
                dial.setIdDial(rs.getInt("IdDial"));
                dial.setNomDial(rs.getString("NomDial"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return dial;
    }

    @Override
    public void modificar(DialectoM dia) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE Dialecto SET NomDial = ? WHERE IdDial = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, dia.getNomDial());
            st.setInt(2, dia.getIdDial());
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(DialectoM dia) throws Exception {
        try {
            this.Conexion();
            String sql = "DELETE FROM Dialecto WHERE IdDial = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, dia.getIdDial());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }


}
