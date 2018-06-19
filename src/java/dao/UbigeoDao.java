package dao;

import dao.interaces.UbigeoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Ubigeo;

public class UbigeoDao extends DAO implements UbigeoI {

    @Override
    public String obtenerCodigoUbigeo(String Ubigeo) throws SQLException {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "select CodUbi from Ubigeo where concat(departamento,',',provincia,',',distrito) like ?";
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

    @Override
    public List<String> autocompleteUbigeo(String Consulta) throws SQLException {
        this.Conexion();
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "select concat(departamento,',',provincia,',',distrito) AS distrito from ubigeo where Dis like upper(?)";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {

                Lista.add(rs.getString("distrito"));
            }
            return Lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void registrar(Ubigeo ubi) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO Ubigeo (departamento,provincia,distrito) values(?,?,?)";
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
    public List<Ubigeo> listar() throws Exception {
        List<Ubigeo> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = " select Ubigeo.CodUbi, Ubigeo.departamento, Ubigeo.provincia, Ubigeo.distrito, Empleado.Nom as 'Nombre del Empleado'\n"
                    + " from Ubigeo\n"
                    + " inner join Empleado on Empleado.Nom = Empleado.Nom\n"
                    + " where Empleado.Est like 'Activo'";
//            String sql = "SELECT CodUbi, Dep,Pro,Dis FROM Ubigeo";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Ubigeo ubi = new Ubigeo();
                ubi.setCodigoUbigeo(rs.getInt("CodUbi"));
                ubi.setDepartamento(rs.getString("departamento"));
                ubi.setProvincia(rs.getString("provincia"));
                ubi.setDistrito(rs.getString("distrito"));
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
    public Ubigeo leerID(Ubigeo ubi) throws Exception {
        Ubigeo ubig = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT CodUbi,Dep,provincia,distrito  FROM Ubigeo WHERE CodUbi=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, ubi.getCodigoUbigeo());
            rs = st.executeQuery();
            while (rs.next()) {
                ubig = new Ubigeo();
                ubig.setCodigoUbigeo(rs.getInt("CodUbi"));
                ubig.setDepartamento(rs.getString("Dep"));
                ubig.setProvincia(rs.getString("provincia"));
                ubig.setDistrito(rs.getString("distrito"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return ubig;
    }

    @Override
    public void modificar(Ubigeo ubi) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE Ubigeo SET departamento = ?, provincia = ?, distrito = ? WHERE CodUbi = ?";
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
    public void eliminar(Ubigeo ubi) throws Exception {
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
