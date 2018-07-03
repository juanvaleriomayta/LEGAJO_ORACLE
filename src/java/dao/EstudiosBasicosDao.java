package dao;

import dao.interaces.EstudiosBasicosI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EstudiosBasicos;

public class EstudiosBasicosDao extends DAO implements EstudiosBasicosI {

    @Override
    public void registrarEstudiosBasicos(EstudiosBasicos bas) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO EstudiosBasicos (EducBasi,CulmiBasi,CentrEstuBasi,DesdBasi, HasBasi,EstadoBasi,Empleado_idEmpl) values(?,?,?,CONVERT(DATE,? ,103),CONVERT(DATE,?,103),?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, bas.getEduc());
            st.setString(2, bas.getCulmi());
            st.setString(3, bas.getCentrEstu());
            st.setString(4, bas.getDesd());
            st.setString(5, bas.getHas());
            st.setString(6, bas.getEstado());
            st.setString(7, bas.getEmpleadoNom());
            st.setString(8, bas.getEmpleadoApe());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public void registrar(EstudiosBasicos bas) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO EstudiosBasicos (EducBasi,CulmiBasi,CentrEstuBasi,DesdBasi, HasBasi,EstadoBasi,Empleado_idEmpl) values(?,?,?,CONVERT(DATE,? ,103),CONVERT(DATE,?,103),?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, bas.getEduc());
            st.setString(2, bas.getCulmi());
            st.setString(3, bas.getCentrEstu());
            st.setString(4, bas.getDesd());
            st.setString(5, bas.getHas());
            st.setString(6, bas.getEstado());
            st.setString(7, bas.getEmpleadoNom());
            st.setString(8, bas.getEmpleadoApe());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public List<EstudiosBasicos> listar() throws Exception {
        List<EstudiosBasicos> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "Select * FROM vw_EstuBasiEmpl";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EstudiosBasicos bas = new EstudiosBasicos();
                bas.setEduc(rs.getString("EducBasi"));
                bas.setCulmi(rs.getString("Culmibasi"));
                bas.setCentrEstu(rs.getString("CentrEstuBasi"));
                bas.setDesd(rs.getString("DesdBasi"));
                bas.setHas(rs.getString("HasBasi"));
                bas.setEstado(rs.getString("EstadoBasi"));
                bas.setEmpleadoNom(rs.getString("Nombre del Empleado"));
                bas.setEmpleadoApe(rs.getString("Apellido del Empleado"));
                lista.add(bas);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<EstudiosBasicos> listarInactivos() throws Exception {
        List<EstudiosBasicos> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "Select * FROM vw_EstuBasiEmplInac";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EstudiosBasicos bas = new EstudiosBasicos();
                bas.setEduc(rs.getString("EducBasi"));
                bas.setCulmi(rs.getString("CulmiBasi"));
                bas.setCentrEstu(rs.getString("CentrEstuBasi"));
                bas.setDesd(rs.getString("DesdBasi"));
                bas.setHas(rs.getString("HasBasi"));
                bas.setEstado(rs.getString("EstadoBasi"));
                bas.setEmpleadoNom(rs.getString("Nombre del Empleado"));
                bas.setEmpleadoApe(rs.getString("Apellido del Empleado"));
                lista.add(bas);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public EstudiosBasicos leerID(EstudiosBasicos bas) throws Exception {
        EstudiosBasicos basi = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT IdEstuBasi, EducBasi,CulmiBasi,CentrEstuBasi,CONVERT(nvarchar(10),DesdBasi,103) AS DesdBasi,CONVERT(nvarchar(10),HasBasi,103) AS HasBasi,EstadoBasi,Empleado_idEmpl  FROM EstudiosBasicos WHERE IdEstuBasi=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, bas.getIdEstuBasi());
            rs = st.executeQuery();
            while (rs.next()) {
                basi = new EstudiosBasicos();
                basi.setIdEstuBasi(rs.getInt("IdEstuBasi"));
                basi.setEduc(rs.getString("Educ"));
                basi.setCulmi(rs.getString("Culmi"));
                basi.setCentrEstu(rs.getString("CentrEstuBasi"));
                basi.setDesd(rs.getString("DesdBasi"));
                basi.setHas(rs.getString("HasBasi"));
                basi.setEstado(rs.getString("EstadoBasi"));
                basi.setEmpleadoNom(rs.getString("Nombre del Empleado"));
                basi.setEmpleadoApe(rs.getString("Apellido del Empleado"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return basi;
    }

    @Override
    public void modificar(EstudiosBasicos bas) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE EstudiosBasicos SET EducBasi = ?, CulmiBasi=?,CentrEstuBasi=? , DesdBasi = convert(date, ?, 103), HasBasi = convert(date, ?, 103),EstadoBasi=?,Empleado_idEmpl  WHERE IdEstuBasi = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, bas.getEduc());
            st.setString(2, bas.getCulmi());
            st.setString(3, bas.getCentrEstu());
            st.setString(4, bas.getDesd());
            st.setString(5, bas.getHas());
            st.setInt(6, bas.getIdEstuBasi());
            st.setString(7, bas.getEstado());
            st.setString(8, bas.getEmpleadoNom());
            st.setString(9, bas.getEmpleadoApe());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(EstudiosBasicos bas) throws Exception {
        try {
            this.Conexion();
            String sql = "Update EstudiosBasicos set Estado = 'I' where = IdEstuBasi = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, bas.getIdEstuBasi());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
