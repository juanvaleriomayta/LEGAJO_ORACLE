package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DetalleDialecto;



public class DetalleDialectoDao extends DAO{
    
    public void registrar(DetalleDialecto detdia) throws Exception {
        try {
            this.Conexion();

            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO DetDial (Le,Hab,Escri) values(?,?,?)");
            st.setString(1, detdia.getLe());
            st.setString(2, detdia.getHab());
            st.setString(3, detdia.getEscri());
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
            PreparedStatement st = this.getCn().prepareCall("SELECT IdDetDial, Le,Hab,Escri FROM DetDial");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                DetalleDialecto detdia = new DetalleDialecto();
                detdia.setIdDetDial(rs.getInt("IdDetDial"));
                detdia.setLe(rs.getString("Le"));
                detdia.setHab(rs.getString("Hab"));
                detdia.setEscri(rs.getString("Escri"));
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
            PreparedStatement st = this.getCn().prepareStatement("SELECT IdDetDial,Le,Hab,Escri  FROM DetDial WHERE IdDetDial=?");
            st.setInt(1, detdia.getIdDetDial());
            rs = st.executeQuery();
            while (rs.next()) {
                detdial = new DetalleDialecto();
                detdial.setIdDetDial(rs.getInt("IdDetDial"));
                detdial.setLe(rs.getString("Le"));
                detdial.setHab(rs.getString("Hab"));
                detdial.setEscri(rs.getString("Escri"));
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
            PreparedStatement st = this.getCn().prepareStatement("UPDATE IdDetDial SET Le = ?, Hab = ?, Escri = ? WHERE IdDetDial = ?");
            st.setString(1, detdia.getLe());
            st.setString(2, detdia.getHab());
            st.setString(3, detdia.getEscri());                  
            st.setInt(4, detdia.getIdDetDial());
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
