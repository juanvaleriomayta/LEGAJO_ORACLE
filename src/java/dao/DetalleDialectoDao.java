package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DetalleDialecto;

public class DetalleDialectoDao extends DAO {

    public void registrar(DetalleDialecto detdia) throws Exception {
        try {
            this.Conexion();
            String sql = "EXEC SP_DETALLEDIALECTO ?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, detdia.getLee());
            st.setString(2, detdia.getHabla());
            st.setString(3, detdia.getEscribe());
            st.setString(4, "A");
            st.setString(5, detdia.getCodEmpleado());
            st.setString(6, detdia.getCodDialecto());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<String> autocompleteDialecto(String Dialecto) throws SQLException {
        this.Conexion();
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "select NomDial AS Dialecto from Dialecto where  UPPER(NomDial) like UPPER(?)";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Dialecto + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {

                Lista.add(rs.getString("Dialecto"));
            }
            return Lista;
        } catch (SQLException e) {
            throw e;
        }
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

    public List<DetalleDialecto> listarActivos() throws Exception {
        List<DetalleDialecto> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM vw_DetaEmplActi";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                DetalleDialecto detdia = new DetalleDialecto();
                detdia.setIdDetDial(rs.getString("idDetDial"));
                detdia.setLee(rs.getString("Lee"));
                detdia.setHabla(rs.getString("Habla"));
                detdia.setEscribe(rs.getString("Escribe"));
                detdia.setEstado(rs.getString("Estado"));
                detdia.setEmpleado(rs.getString("Empleado"));
                detdia.setDialecto(rs.getString("Dialecto"));
                lista.add(detdia);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<DetalleDialecto> listarInactivos() throws Exception {
        List<DetalleDialecto> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM vw_DetaEmplInac";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                DetalleDialecto detdia = new DetalleDialecto();
                detdia.setIdDetDial(rs.getString("idDetDial"));
                detdia.setLee(rs.getString("Lee"));
                detdia.setHabla(rs.getString("Habla"));
                detdia.setEscribe(rs.getString("Escribe"));
                detdia.setEstado(rs.getString("Estado"));
                detdia.setEmpleado(rs.getString("Empleado"));
                detdia.setDialecto(rs.getString("Dialecto"));
                lista.add(detdia);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public DetalleDialecto leerID(String Codigo) throws Exception {
        DetalleDialecto detdial = null;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT idDetDial,Lee,Habla,Escribe,Estado,CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate) AS 'Empleado',Dialecto.NomDial AS 'Dialecto'  FROM DetalleDialecto LEFT OUTER JOIN Empleado ON DetalleDialecto.Empleado_idEmpl = Empleado.idEmpl  LEFT OUTER JOIN Dialecto on DetalleDialecto.Dialecto_IdDial = Dialecto.IdDial WHERE idDetDial=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, Codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                detdial = new DetalleDialecto();
                detdial.setIdDetDial(rs.getString("idDetDial"));
                detdial.setLee(rs.getString("Lee"));
                detdial.setHabla(rs.getString("Habla"));
                detdial.setEscribe(rs.getString("Escribe"));
                detdial.setEstado(rs.getString("Estado"));
                detdial.setEmpleado(rs.getString("Empleado"));
                detdial.setDialecto(rs.getString("Dialecto"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return detdial;
    }

    public void modificar(DetalleDialecto detdia) throws Exception {
        try {
            this.Conexion();
            String sql = "EXEC SP_DetalleDialectoUpdate ?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, detdia.getIdDetDial());
            st.setString(2, detdia.getLee());
            st.setString(3, detdia.getHabla());
            st.setString(4, detdia.getEscribe());
            st.setString(5, detdia.getEstado());
            st.setString(6, detdia.getCodEmpleado());
            st.setString(7, detdia.getCodDialecto());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(DetalleDialecto detdia) throws Exception {
        try {
            this.Conexion();
            String sql = "Update DetalleDialecto set Estado ='I' WHERE idDetDial = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, detdia.getIdDetDial());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
