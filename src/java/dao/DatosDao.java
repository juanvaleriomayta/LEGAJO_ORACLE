package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Datos;


public class DatosDao extends DAO {

    public void registrar(Datos dat) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO Datos (Con, ApreCali, SerPre, IntProCapPerf, RefPer, BonPer, ComInfTper, BonFam) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, dat.getCon());
            st.setString(2, dat.getApreCali());
            st.setString(3, dat.getSerPre());
            st.setString(4, dat.getIntProCapPerf());
            st.setString(5, dat.getRefPer());
            st.setString(6, dat.getBonPer());
            st.setString(7, dat.getComInfTper());
            st.setString(8, dat.getBonFam());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public List<Datos> listar() throws Exception {
        List<Datos> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT IdLegajo, Con, ApreCali, SerPre, IntProCapPerf, RefPer, BonPer, ComInfTper, BonFam FROM Datos";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Datos dat = new Datos();
                dat.setIdLegajo(rs.getInt("IdLegajo"));
                dat.setCon(rs.getString("Con"));
                dat.setApreCali(rs.getString("ApreCali"));
                dat.setSerPre(rs.getString("SerPre"));
                dat.setIntProCapPerf(rs.getString("IntProCapPerf"));
                dat.setRefPer(rs.getString("RefPer"));
                dat.setBonPer(rs.getString("BonPer"));
                dat.setComInfTper(rs.getString("ComInfTper"));
                dat.setBonFam(rs.getString("BonFam"));
                lista.add(dat);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public Datos leerID(Datos dat) throws Exception {
        Datos dato = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT IdLegajo,Con, ApreCali, SerPre, IntProCapPerf, RefPer, BonPer, ComInfTper, BonFam  FROM Datos WHERE IdLegajo=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, dat.getIdLegajo());
            rs = st.executeQuery();
            while (rs.next()) {
                dato = new Datos();
                dato.setIdLegajo(rs.getInt("IdLegajo"));
                dato.setCon(rs.getString("Con"));
                dato.setApreCali(rs.getString("ApreCali"));
                dato.setSerPre(rs.getString("SerPre"));
                dato.setIntProCapPerf(rs.getString("IntProCapPerf"));
                dato.setRefPer(rs.getString("RefPer"));
                dato.setBonPer(rs.getString("BonPer"));
                dato.setComInfTper(rs.getString("ComInfTper"));
                dato.setBonFam(rs.getString("BonFam"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return dato;
    }

    public void modificar(Datos dat) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE Datos SET Con = ?, ApreCali = ?, SerPre = ?,IntProCapPerf = ?, RefPer = ?, BonPer = ?,ComInfTper = ?, BonFam = ? WHERE IdLegajo = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, dat.getCon());
            st.setString(2, dat.getApreCali());
            st.setString(3, dat.getSerPre());
            st.setString(4, dat.getIntProCapPerf());
            st.setString(5, dat.getRefPer());
            st.setString(6, dat.getBonPer());
            st.setString(7, dat.getComInfTper());
            st.setString(8, dat.getBonFam());
            st.setInt(9, dat.getIdLegajo());
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(Datos dat) throws Exception {
        try {
            this.Conexion();
            String sql = "DELETE FROM Datos WHERE IdLegajo = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, dat.getIdLegajo());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
