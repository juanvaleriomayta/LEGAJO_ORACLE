package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Emergencia;

public class EmergenciaDao extends DAO {

    public void registrar(Emergencia eme) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Emergencia (Nom, Ape,Paren,Tel,Cel) values(?,?,?,?,?)");
            st.setString(1, eme.getNom());
            st.setString(2, eme.getApe());
            st.setString(3, eme.getParen());
            st.setString(4, eme.getTel());
            st.setString(5, eme.getCel());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<Emergencia> listar() throws Exception {
        List<Emergencia> lista;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdEmerg, Nom, Ape,Paren,Tel,Cel FROM Emergencia");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Emergencia eme = new Emergencia();
                eme.setIdEmerg(rs.getInt("IdEmerg"));
                eme.setNom(rs.getString("Nom"));
                eme.setApe(rs.getString("Ape"));
                eme.setParen(rs.getString("Paren"));
                eme.setTel(rs.getString("Tel"));
                eme.setCel(rs.getString("Cel"));
                lista.add(eme);
                
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public Emergencia leerID(Emergencia eme) throws Exception {
        Emergencia emer = null;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT IdEmerg, Nom, Ape,Paren,Tel,Cel FROM Emergencia WHERE IdEmerg=?");
            st.setInt(1, eme.getIdEmerg());
            rs = st.executeQuery();
            while (rs.next()) {
                emer = new Emergencia();
                emer.setIdEmerg(rs.getInt("IdEmerg"));
                emer.setNom(rs.getString("Nom"));
                emer.setApe(rs.getString("Ape"));
                emer.setParen(rs.getString("Paren"));
                emer.setTel(rs.getString("Tel"));
                emer.setCel(rs.getString("Cel"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return emer;
    }

    public void modificar(Emergencia eme) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Emergencia SET Nom=?, Ape=?,Paren=?,Tel=?,Cel=? WHERE IdEmerg = ?");
            st.setString(1, eme.getNom());
            st.setString(2, eme.getApe());
            st.setString(3, eme.getParen());
            st.setString(4, eme.getTel());
            st.setString(5, eme.getCel());
            st.setInt(6, eme.getIdEmerg());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(Emergencia eme) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Emergencia WHERE IdEmerg = ?");
            st.setInt(1, eme.getIdEmerg());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
