package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DetalleDialecto;

public class DetalleDialectoDao extends DAO {

    public void registrar(DetalleDialecto detdia) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO DetalleDialecto (Lee,Hab,Escri,Estado) values(?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, detdia.getLee());
            st.setString(2, detdia.getHabla());
            st.setString(3, detdia.getEscribe());
            st.setString(4, detdia.getEstado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public List<DetalleDialecto> listarActivos() throws Exception {
        List<DetalleDialecto> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = " select idDetDial, Lee, Habla, Escribe, Dialecto.NomDial,Estado, Empleado.Nom as 'Nombre del Empleado'\n"
                    + " from DetalleDialecto\n"
                    + " left outer join Dialecto Dialecto on Dialecto.NomDial = Dialecto.NomDial\n"
                    + " left outer join Empleado Empleado on Empleado.Nom = Empleado.Nom\n"
                    + " where Estado like 'Activo'";
            //      String sql = "SELECT idDetDial, Lee,Hab,Escri, Estado FROM DetalleDialecto";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                DetalleDialecto detdia = new DetalleDialecto();
                detdia.setIdDetDial(rs.getInt("idDetDial"));
                detdia.setLee(rs.getString("Lee"));
                detdia.setHabla(rs.getString("Hab"));
                detdia.setEscribe(rs.getString("Escri"));
                detdia.setEstado(rs.getString("Estado"));
                lista.add(detdia);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<DetalleDialecto> listarInactivos() throws Exception {
        List<DetalleDialecto> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = " select idDetDial, Lee, Habla, Escribe, Dialecto.NomDial,Estado, Empleado.Nom as 'Nombre del Empleado'\n"
                    + " from DetalleDialecto\n"
                    + " left outer join Dialecto Dialecto on Dialecto.NomDial = Dialecto.NomDial\n"
                    + " left outer join Empleado Empleado on Empleado.Nom = Empleado.Nom\n"
                    + " where Estado like 'Inactivo'";
//           String sql = "Select * from vw_DetalleDialectoInac";
            //    String sql = "SELECT idDetDial, Lee,Hab,Escri, Estado FROM DetalleDialecto Where Estado like 'Inactivo'";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                DetalleDialecto detdia = new DetalleDialecto();
                detdia.setIdDetDial(rs.getInt("idDetDial"));
                detdia.setLee(rs.getString("Lee"));
                detdia.setHabla(rs.getString("Hab"));
                detdia.setEscribe(rs.getString("Escri"));
                detdia.setEstado(rs.getString("Estado"));
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
            String sql = "SELECT idDetDial,Lee,Hab,Escri,Estado  FROM DetalleDialecto WHERE idDetDial=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, detdia.getIdDetDial());
            rs = st.executeQuery();
            while (rs.next()) {
                detdial = new DetalleDialecto();
                detdial.setIdDetDial(rs.getInt("idDetDial"));
                detdial.setLee(rs.getString("Lee"));
                detdial.setHabla(rs.getString("Hab"));
                detdial.setEscribe(rs.getString("Escri"));
                detdia.setEstado(rs.getString("Estado"));
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
            String sql = "UPDATE DetalleDialecto SET Lee = ?, Hab = ?, Escri = ?,Estado=? WHERE idDetDial = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, detdia.getLee());
            st.setString(2, detdia.getHabla());
            st.setString(3, detdia.getEscribe());
            st.setString(4, detdia.getEstado());
            st.setInt(5, detdia.getIdDetDial());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(DetalleDialecto detdia) throws Exception {
        try {
            this.Conexion();
            String sql = "Update DetalleDialecto set Estado = 'Inactivo' WHERE idDetDial = ?";
            //String sql = "DELETE FROM DetDial WHERE idDetDial = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, detdia.getIdDetDial());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
