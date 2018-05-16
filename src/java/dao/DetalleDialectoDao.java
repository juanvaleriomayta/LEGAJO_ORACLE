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
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO DetDial (Lee,Hab,Escri) values(?,?,?)");
            st.setString(1, detdia.getLee());
            st.setString(2, detdia.getHabla());
            st.setString(3, detdia.getEscribe());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public List<DetalleDialecto> listar() throws Exception {
        List<DetalleDialecto> lista;
        ResultSet rs;
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT idDetDial, Lee,Hab,Escri FROM DetDial");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                DetalleDialecto detdia = new DetalleDialecto();
                detdia.setIdDetDial(rs.getInt("idDetDial"));
                detdia.setLee(rs.getString("Lee"));
                detdia.setHabla(rs.getString("Hab"));
                detdia.setEscribe(rs.getString("Escri"));
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
            PreparedStatement st = this.getCn().prepareStatement("SELECT idDetDial,Lee,Hab,Escri  FROM DetDial WHERE idDetDial=?");
            st.setInt(1, detdia.getIdDetDial());
            rs = st.executeQuery();
            while (rs.next()) {
                detdial = new DetalleDialecto();
                detdial.setIdDetDial(rs.getInt("idDetDial"));
                detdial.setLee(rs.getString("Lee"));
                detdial.setHabla(rs.getString("Hab"));
                detdial.setEscribe(rs.getString("Escri"));
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
            PreparedStatement st = this.getCn().prepareStatement("UPDATE DetDial SET Lee = ?, Hab = ?, Escri = ? WHERE idDetDial = ?");
            st.setString(1, detdia.getLee());
            st.setString(2, detdia.getHabla());
            st.setString(3, detdia.getEscribe());
            st.setInt(4, detdia.getIdDetDial());
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
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM DetDial WHERE idDetDial = ?");
            st.setInt(1, detdia.getIdDetDial());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
