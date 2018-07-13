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
            String sql = "EXEC sp_EstudiosBasicos ?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, bas.getEduc());
            st.setString(2, bas.getCulmi());
            st.setString(3, bas.getCentrEstu());
            st.setString(4, bas.getDesd());
            st.setString(5, bas.getHas());
            st.setString(6, "A");
            st.setString(7, bas.getCodEmpleado());
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
            String sql = "EXEC sp_EstudiosBasicos ?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, bas.getEduc());
            st.setString(2, bas.getCulmi());
            st.setString(3, bas.getCentrEstu());
            st.setString(4, bas.getDesd());
            st.setString(5, bas.getHas());
            st.setString(6, "A");
            st.setString(7, bas.getCodEmpleado());
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
                bas.setIdEstuBasi(rs.getString("IdEstuBasi"));
                bas.setEduc(rs.getString("EducBasi"));
                bas.setCulmi(rs.getString("CulmiBasi"));
                bas.setCentrEstu(rs.getString("CentrEstuBasi"));
                bas.setDesd(rs.getString("DesdBasi"));
                bas.setHas(rs.getString("HasBasi"));
                bas.setEstado(rs.getString("EstadoBasi"));
                bas.setEmpleado(rs.getString("Empleado"));
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
            String sql = "SELECT * FROM vw_EstuBasiEmplInac";
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
                bas.setEmpleado(rs.getString("Empleado"));
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
    public EstudiosBasicos leerID(String Codigo) throws Exception {
        EstudiosBasicos basi = null;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT IdEstuBasi, EducBasi,CulmiBasi,CentrEstuBasi,CONVERT(date,DesdBasi,103) AS DesdBasi,CONVERT(date,HasBasi,103) AS HasBasi,EstadoBasi,UPPER(CONCAT (Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'  FROM EstudioBasicos LEFT OUTER JOIN Empleado ON EstudioBasicos.Empleado_idEmpl = Empleado.idEmpl WHERE IdEstuBasi=? ";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, Codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                basi = new EstudiosBasicos();
                basi.setIdEstuBasi(rs.getString("IdEstuBasi"));
                basi.setEduc(rs.getString("EducBasi"));
                basi.setCulmi(rs.getString("CulmiBasi"));
                basi.setCentrEstu(rs.getString("CentrEstuBasi"));
                basi.setDesd(rs.getString("DesdBasi"));
                basi.setHas(rs.getString("HasBasi"));
                basi.setEstado(rs.getString("EstadoBasi"));
                basi.setEmpleado(rs.getString("Empleado"));
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
            String sql =" EXEC SP_EstudiosBasicosUpdate ?,?,?,?,?,?,?,?";
//            String sql = "SP_EstudiosBasicosUpdate @IdEstuBasi=?,@EducBasi=?,@CulmiBasi=?,@CentrEstuBasi=?,@DesdBasi=?,@HasBasi=?,@EstadoBasi=?,@Empleado_idEmpl=? ";
//            String sql = "UPDATE EstudioBasicos SET EducBasi = ?, CulmiBasi=?,CentrEstuBasi=? , DesdBasi = convert(date, ?, 103), HasBasi = convert(date, ?, 103),EstadoBasi=?,Empleado_idEmpl  WHERE IdEstuBasi = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, bas.getIdEstuBasi());
            st.setString(2, bas.getEduc());
            st.setString(3, bas.getCulmi());
            st.setString(4, bas.getCentrEstu());
            st.setString(5, bas.getDesd());
            st.setString(6, bas.getHas());
            st.setString(7, bas.getEstado());
            st.setString(8, bas.getCodEmpleado());
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
            String sql = "Update EstudioBasicos set Estado =? where = IdEstuBasi = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, "I");
            st.setString(1, bas.getIdEstuBasi());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
