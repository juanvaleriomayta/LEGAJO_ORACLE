package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Ubigeo;

public class UbigeoDao extends DAO {

    public void registrar(Ubigeo ubi) throws Exception {
        try {
            this.Conexion();

            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Ubigeo (Dep,Pro,Dis) values(?,?,?)");
            st.setString(1, ubi.getDepartamenmto());
            st.setString(2, ubi.getProvincia());
            st.setString(3, ubi.getDistrito());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public List<Ubigeo> listar() throws Exception {
        List<Ubigeo> lista;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT CodUbi, Dep,Pro,Dis FROM Ubigeo");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Ubigeo ubi = new Ubigeo();
                ubi.setCodigoUbigeo(rs.getInt("CodUbi"));
                ubi.setDepartamenmto(rs.getString("Dep"));
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

    public Ubigeo leerID(Ubigeo ubi) throws Exception {
        Ubigeo ubig = null;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT CodUbi,Dep,Pro,Dis  FROM Ubigeo WHERE CodUbi=?");
            st.setInt(1, ubi.getCodigoUbigeo());
            rs = st.executeQuery();
            while (rs.next()) {
                ubig = new Ubigeo();
                ubig.setCodigoUbigeo(rs.getInt("CodUbi"));
                ubig.setDepartamenmto(rs.getString("Dep"));
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

    public void modificar(Ubigeo ubi) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Ubigeo SET Dep = ?, Pro = ?, Dis = ? WHERE CodUbi = ?");
            st.setString(1, ubi.getDepartamenmto());
            st.setString(2, ubi.getProvincia());
            st.setString(3, ubi.getDistrito());                    
            st.setInt(4, ubi.getCodigoUbigeo());
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(Ubigeo ubi) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Ubigeo WHERE CodUbi = ?");
            st.setInt(1, ubi.getCodigoUbigeo());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
