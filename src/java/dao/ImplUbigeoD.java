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
            String sql = "select CodUbi from Ubigeo where concat(Dep,',',Pro,',',Dis) like ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Ubigeo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CodUbi");
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
            String sql = "select concat(Dep,',',Pro,',',Dis) AS Dis from Ubigeo where Dis like upper(?)";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {

                Lista.add(rs.getString("Dis"));
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
            String sql = "INSERT INTO Ubigeo (Dep,Pro,Dis) values(?,?,?)";
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
            String sql = "SELECT * FROM VIEW VW_UBIGEO";
//            String sql = "select * from Ubigeo";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                UbigeoM ubi = new UbigeoM();
                ubi.setCodigoUbigeo(rs.getInt("CodUbi"));
                ubi.setDepartamento(rs.getString("Dep"));
                ubi.setProvincia(rs.getString("Pro"));
                ubi.setDistrito(rs.getString("Dis"));
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
            String sql = "SELECT CodUbi,Dep,Pro,Dis FROM Ubigeo WHERE CodUbi=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, ubi.getCodigoUbigeo());
            rs = st.executeQuery();
            while (rs.next()) {
                ubig = new UbigeoM();
                ubig.setCodigoUbigeo(rs.getInt("CodUbi"));
                ubig.setDepartamento(rs.getString("Dep"));
                ubig.setProvincia(rs.getString("Pro"));
                ubig.setDistrito(rs.getString("Dis"));
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
            String sql = "UPDATE Ubigeo SET Dep = ?,Pro = ?, Dis = ? WHERE CodUbi = ?";
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
            String sql = "DELETE FROM Ubigeo WHERE CodUbi = ?";
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
