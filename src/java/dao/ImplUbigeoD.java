package dao;

import Interfaces.UbigeoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.UbigeoM;

public class ImplUbigeoD extends ImplDAO implements UbigeoI {

    public String obtenerCodigoUbigeo(String Ubigeo) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "SELECT CODUBI FROM UBIGEO WHERE DEPUBI| |PROUBI| |DISUBI LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Ubigeo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODUBI");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<String> autocompleteUbigeo(String Consulta) throws SQLException, Exception{
        this.Conexion();
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "SELECT UPPER(DEPUBI||' '||PROUBI||' '||DISUBI) AS DISUBI FROM UBIGEO WHERE DISUBI LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {

                Lista.add(rs.getString("DISUBI"));
            }
            return Lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void registrar(UbigeoM ubi) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO UBIGEO (DEPUBI,PROUBI,DISUBI) VALUES(?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, ubi.getDepartamento());
            st.setString(2, ubi.getProvincia());
            st.setString(3, ubi.getDistrito());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public List<UbigeoM> listar() throws Exception {
        List<UbigeoM> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT * FROM  VW_UBIGEO";
//            String sql = "select * from Ubigeo";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                UbigeoM ubi = new UbigeoM();
                ubi.setCodigoUbigeo(rs.getInt("CODUBI"));
                ubi.setDepartamento(rs.getString("DEPUBI"));
                ubi.setProvincia(rs.getString("PROUBI"));
                ubi.setDistrito(rs.getString("DISUBI"));
                lista.add(ubi);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public UbigeoM leerID(UbigeoM ubi) throws Exception {
        UbigeoM ubig = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT CODUBI,DEPUBI,PROUBI,DISUBI FROM UBIGEO WHERE CODUBI LIKE ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, ubi.getCodigoUbigeo());
            rs = st.executeQuery();
            while (rs.next()) {
                ubig = new UbigeoM();
                ubig.setCodigoUbigeo(rs.getInt("CODUBI"));
                ubig.setDepartamento(rs.getString("DEPUBI"));
                ubig.setProvincia(rs.getString("PROUBI"));
                ubig.setDistrito(rs.getString("DISUBI"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return ubig;
    }

    @Override
    public void modificar(UbigeoM ubi) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE UBIGEO SET DEPUBI = ?,PROUBI = ?, DISUBI = ? WHERE CODUBI LIKE ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, ubi.getDepartamento());
            st.setString(2, ubi.getProvincia());
            st.setString(3, ubi.getDistrito());
            st.setInt(4, ubi.getCodigoUbigeo());
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(UbigeoM ubi) throws Exception {
        try {
            this.Conexion();
            String sql = "DELETE FROM UBIGEO WHERE CODUBI LIKE ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, ubi.getCodigoUbigeo());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

}
