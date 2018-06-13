package dao;

import dao.interaces.EmergenciasI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Emergencia;

public class EmergenciaDao extends DAO implements EmergenciasI{
    
    
    @Override
    public void registrarEmergencia(Emergencia eme) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO Emergencia (Nom, Ape,Paren,Tel,Cel,Estado) values(?,?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, eme.getNom());
            st.setString(2, eme.getApe());
            st.setString(3, eme.getParen());
            st.setString(4, eme.getTel());
            st.setString(5, eme.getCel());
            st.setString(6, eme.getEstado());
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
            String sql = "INSERT INTO Emergencia (Nom, Ape,Paren,Tel,Cel,Estado) values(?,?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, eme.getNom());
            st.setString(2, eme.getApe());
            st.setString(3, eme.getParen());
            st.setString(4, eme.getTel());
            st.setString(5, eme.getCel());
            st.setString(6, eme.getEstado());
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
            //select * from vw_Emergencia
            String sql =  "SELECT IdEmerg, Nom, Ape,Paren,Tel,Cel,Estado FROM Emergencia Where Estado like 'Activo'";
            PreparedStatement st = this.getCn().prepareCall(sql);
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
                eme.setEstado(rs.getString("Estado"));
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
            String sql = "SELECT IdEmerg, Nom, Ape,Paren,Tel,Cel,Estado FROM Emergencia WHERE IdEmerg=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
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
                emer.setEstado(rs.getString("Estado"));
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
            String sql = "UPDATE Emergencia SET Nom=?, Ape=?,Paren=?,Tel=?,Cel=?,Estado=? WHERE IdEmerg = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, eme.getNom());
            st.setString(2, eme.getApe());
            st.setString(3, eme.getParen());
            st.setString(4, eme.getTel());
            st.setString(5, eme.getCel());
            st.setInt(6, eme.getIdEmerg());
            st.setString(7, eme.getEstado());
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
