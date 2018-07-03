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
            String sql = "INSERT INTO DetalleDialecto (Lee,Habla,Escribe,Estado,Empleado_idEmpl,Dialecto_idDial) values(?,?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, detdia.getLee());
            st.setString(2, detdia.getHabla());
            st.setString(3, detdia.getEscribe());
            st.setString(4, detdia.getEstado());
            st.setString(5, detdia.getEmpleadoNom());
            st.setString(6, detdia.getEmpleadoApel());
            st.setString(7, detdia.getDialectoNom());
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
                detdia.setEmpleadoNom(rs.getString("Nom"));
                detdia.setEmpleadoApel(rs.getString("Apellido del Empleado"));
                detdia.setDialectoNom(rs.getString("NomDial"));
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
                detdia.setEmpleadoNom(rs.getString("Nom"));
                detdia.setEmpleadoApel(rs.getString("Apellido del Empleado"));
                detdia.setDialectoNom(rs.getString("NomDial"));
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
                detdia.setEmpleadoNom(rs.getString("Nom"));
                detdia.setEmpleadoApel(rs.getString("Apellido del Empleado"));
                detdia.setDialectoNom(rs.getString("NomDial"));
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
            String sql = "UPDATE DetalleDialecto SET Lee = ?, Habla = ?, Escribe = ?,Estado=?, Empleado_idEmpl=?,Dialecto_IdDial WHERE idDetDial = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, detdia.getIdDetDial());
            st.setString(2, detdia.getLee());
            st.setString(3, detdia.getHabla());
            st.setString(4, detdia.getEscribe());
            st.setString(5, detdia.getEstado());
            st.setString(6, detdia.getEmpleadoNom());
            st.setString(7, detdia.getEmpleadoApel());
            st.setString(8, detdia.getDialectoNom());
                                
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
            String sql = "Update DetalleDialecto set Estado = 'I' WHERE idDetDial = ?";
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
