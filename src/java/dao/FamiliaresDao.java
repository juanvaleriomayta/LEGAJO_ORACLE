package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Familiares;

public class FamiliaresDao extends DAO {

    public void registrarFamiliar(Familiares fam, String tipo) throws Exception {
        this.Conexion();
        try {
            String sql = "INSERT INTO Familiares  (Nom,Ape,Par,Ocu,FecNac,Tel,Cel,EstCiv,vive) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, fam.getNom());
            st.setString(2, fam.getApe());
            st.setString(3, fam.getPar());
            st.setString(4, fam.getOcu());
            st.setString(5, fam.getFecNac());
            st.setString(6, fam.getTel());
            st.setString(7, fam.getCel());
            st.setString(8, fam.getEstCiv());
            st.setString(9, fam.getVive());
            st.setString(10, tipo);
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void registrar(Familiares fam) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Familiares  (Nom,Ape,Par,Ocu,FecNac,Tel,Cel,EstCiv,vive) values(?,?,?,?,?,?,?,?,?)");
            st.setString(1, fam.getNom());
            st.setString(2, fam.getApe());
            st.setString(3, fam.getPar());
            st.setString(4, fam.getOcu());
            st.setString(5, fam.getFecNac());
            st.setString(6, fam.getTel());
            st.setString(7, fam.getCel());
            st.setString(8, fam.getEstCiv());
            st.setString(9, fam.getVive());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<Familiares> listar() throws Exception {
        List<Familiares> lista;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT CodFami, Nom,Ape,Par,Ocu,FORMAT(FecNac,'dd/MM/yyyy') as FecNac,Tel,Cel,EstCiv,vive FROM Familiares");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Familiares fam = new Familiares();
                fam.setCodFami(rs.getInt("CodFami"));
                fam.setNom(rs.getString("Nom"));
                fam.setApe(rs.getString("Ape"));
                fam.setPar(rs.getString("Par"));
                fam.setOcu(rs.getString("Ocu"));
                fam.setFecNac(rs.getString("FecNac"));
                fam.setTel(rs.getString("Tel"));
                fam.setCel(rs.getString("Cel"));
                fam.setEstCiv(rs.getString("EstCiv"));
                fam.setVive(rs.getString("vive"));
                lista.add(fam);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public Familiares leerID(Familiares fam) throws Exception {
        Familiares fami = null;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT CodFami,Nom,Ape,Par,Ocu,FecNac,Tel,Cel,EstCiv,vive  FROM Familiares WHERE CodFami=?");
            st.setInt(1, fam.getCodFami());
            rs = st.executeQuery();
            while (rs.next()) {
                fami = new Familiares();
                fami.setCodFami(rs.getInt("CodFami"));
                fami.setNom(rs.getString("Nom"));
                fami.setApe(rs.getString("Ape"));
                fami.setPar(rs.getString("Par"));
                fami.setOcu(rs.getString("Ocu"));
                fami.setFecNac(rs.getString("FecNac"));
                fami.setTel(rs.getString("Tel"));
                fami.setCel(rs.getString("Cel"));
                fami.setEstCiv(rs.getString("EstCiv"));
                fami.setVive(rs.getString("vive"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return fami;
    }

    public void modificar(Familiares fam) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Familiares SET  Nom = ?, Ape = ?,Par = ?, Ocu = ?, FecNac = convert(date, ?, 103),Tel = ?, Cel = ?, EstCiv = ?, vive = ? WHERE CodFami = ?");
            st.setString(1, fam.getNom());
            st.setString(2, fam.getApe());
            st.setString(3, fam.getPar());
            st.setString(4, fam.getOcu());
            st.setString(5, fam.getFecNac());
            st.setString(6, fam.getTel());
            st.setString(7, fam.getCel());
            st.setString(8, fam.getEstCiv());
            st.setString(9, fam.getVive());
            st.setInt(10, fam.getCodFami());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(Familiares fam) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Familiares WHERE CodFami = ?");
            st.setInt(1, fam.getCodFami());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
