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
            String sql = "INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado,Dialecto_idDial) values(?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, detdia.getLee());
            st.setString(2, detdia.getHabla());
            st.setString(3, detdia.getEscribe());
            st.setString(4, detdia.getEstado());
            st.setString(5, detdia.getEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
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
                detdia.setLee(rs.getString("Lee"));
                detdia.setHabla(rs.getString("Habla"));
                detdia.setEscribe(rs.getString("Escribe"));
                detdia.setEstado(rs.getString("Estado"));
                detdia.setEmpleado(rs.getString("Empleado_idEmpl"));
                detdia.setDialecto(rs.getString("Dialecto_IdDial"));
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
                detdia.setLee(rs.getString("Lee"));
                detdia.setHabla(rs.getString("Habla"));
                detdia.setEscribe(rs.getString("Escribe"));
                detdia.setEstado(rs.getString("Estado"));
                detdia.setEmpleado(rs.getString("Empleado_idEmpl"));
                detdia.setDialecto(rs.getString("Dialecto_IdDial"));
                lista.add(detdia);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public DetalleDialecto leerID(DetalleDialecto detdia) throws Exception {

        DetalleDialecto detdial = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT idDetDial,Lee,Habla,Escribe,Estado  FROM DetalleDialecto WHERE idDetDial=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, detdia.getIdDetDial());
            rs = st.executeQuery();
            while (rs.next()) {
                detdial = new DetalleDialecto();
                detdial.setIdDetDial(rs.getInt("idDetDial"));
                detdial.setLee(rs.getString("Lee"));
                detdial.setHabla(rs.getString("Habla"));
                detdial.setEscribe(rs.getString("Escribe"));
                detdia.setEstado(rs.getString("Estado"));
                detdia.setEmpleado(rs.getString("Empleado_idEmpl"));
                detdia.setDialecto(rs.getString("Dialecto_IdDial"));
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
            String sql = "UPDATE DetalleDialecto SET Lee = ?, Habla = ?, Escribe = ?,Estado=?, Empleado_idEmpl=? WHERE idDetDial = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, detdia.getIdDetDial());
            st.setString(2, detdia.getLee());
            st.setString(3, detdia.getHabla());
            st.setString(4, detdia.getEscribe());
            st.setString(5, detdia.getEstado());
            st.setInt(6, detdia.getIdDetDial());

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
            String sql = "Update DetalleDialecto set Estado = 'Inactivo' WHERE idDetDial = ?";
            //String sql = "DELETE FROM DetDial WHERE idDetDial = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, detdia.getIdDetDial());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
