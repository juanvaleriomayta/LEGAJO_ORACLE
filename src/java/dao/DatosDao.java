package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Datos;

public class DatosDao extends DAO {

       public void registrarDatos(Datos dat) throws Exception {
        try {
            this.Conexion();
            String sql = "SP_DATOS_ADD ?,?,?,?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, dat.getCon());
            st.setString(2, dat.getApreCali());
            st.setString(3, dat.getSerPre());
            st.setString(4, dat.getIntProCapPerf());
            st.setString(5, dat.getRefPer());
            st.setString(6, dat.getBonPer());
            st.setString(7, dat.getComInfTper());
            st.setString(8, dat.getBonFam());
            st.setString(9, dat.getCodEmpleado());
            st.setString(10, "A");
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

       
    public void registrar(Datos dat) throws Exception {
        try {
            this.Conexion();
            String sql = "SP_DATOS_ADD ?,?,?,?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, dat.getCon());
            st.setString(2, dat.getApreCali());
            st.setString(3, dat.getSerPre());
            st.setString(4, dat.getIntProCapPerf());
            st.setString(5, dat.getRefPer());
            st.setString(6, dat.getBonPer());
            st.setString(7, dat.getComInfTper());
            st.setString(8, dat.getBonFam());
            st.setString(9, dat.getCodEmpleado());
            st.setString(10, "A");
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
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

    public List<Datos> listar() throws Exception {
        List<Datos> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT * FROM VW_LISTAR_DATOS";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Datos dat = new Datos();
                dat.setIdLegajo(rs.getString("IdLegajo"));
                dat.setCon(rs.getString("Con"));
                dat.setApreCali(rs.getString("ApreCali"));
                dat.setSerPre(rs.getString("SerPre"));
                dat.setIntProCapPerf(rs.getString("IntProCapPerf"));
                dat.setRefPer(rs.getString("RefPer"));
                dat.setBonPer(rs.getString("BonPer"));
                dat.setComInfTper(rs.getString("ComInfTper"));
                dat.setBonFam(rs.getString("BonFam"));
                dat.setEmpleado(rs.getString("Empleado"));
                dat.setEstado(rs.getString("Estado"));
                lista.add(dat);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<Datos> listarInactivos() throws Exception {
        List<Datos> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT * FROM VW_LISTAR_DATOS_INACTIVOS";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Datos dat = new Datos();
                dat.setIdLegajo(rs.getString("IdLegajo"));
                dat.setCon(rs.getString("Con"));
                dat.setApreCali(rs.getString("ApreCali"));
                dat.setSerPre(rs.getString("SerPre"));
                dat.setIntProCapPerf(rs.getString("IntProCapPerf"));
                dat.setRefPer(rs.getString("RefPer"));
                dat.setBonPer(rs.getString("BonPer"));
                dat.setComInfTper(rs.getString("ComInfTper"));
                dat.setBonFam(rs.getString("BonFam"));
                dat.setEmpleado(rs.getString("Empleado"));
                dat.setEstado(rs.getString("Estado"));
                lista.add(dat);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public Datos leerID(String Codigo) throws Exception {
        Datos dato = null;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT IdLegajo,Con, ApreCali, SerPre, IntProCapPerf, RefPer, BonPer, ComInfTper, BonFam, Estado,CONCAT(Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate) AS 'Empleado'  FROM Datos   LEFT OUTER JOIN Empleado ON Datos.Empleado_idEmpl = Empleado.idEmpl  WHERE IdLegajo=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, Codigo);
            rs = st.executeQuery();
            while (rs.next()) {
                dato = new Datos();
                dato.setIdLegajo(rs.getString("IdLegajo"));
                dato.setCon(rs.getString("Con"));
                dato.setApreCali(rs.getString("ApreCali"));
                dato.setSerPre(rs.getString("SerPre"));
                dato.setIntProCapPerf(rs.getString("IntProCapPerf"));
                dato.setRefPer(rs.getString("RefPer"));
                dato.setBonPer(rs.getString("BonPer"));
                dato.setComInfTper(rs.getString("ComInfTper"));
                dato.setBonFam(rs.getString("BonFam"));
                dato.setEmpleado(rs.getString("Empleado"));
                dato.setEstado(rs.getString("Estado"));
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
            String sql = "EXEC SP_DATOS_UPDATE ?,?,?,?,?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, dat.getIdLegajo());
            st.setString(2, dat.getCon());
            st.setString(3, dat.getApreCali());
            st.setString(4, dat.getSerPre());
            st.setString(5, dat.getIntProCapPerf());
            st.setString(6, dat.getRefPer());
            st.setString(7, dat.getBonPer());
            st.setString(8, dat.getComInfTper());
            st.setString(9, dat.getBonFam());
            st.setString(10, dat.getEstado());
            st.setString(11, dat.getCodEmpleado());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(Datos dat) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE Datos set Estado = 'I' where IdLegajo = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, dat.getIdLegajo());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
