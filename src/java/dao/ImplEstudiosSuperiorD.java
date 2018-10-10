package dao;

import Interfaces.EstudiosSuperiorI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EstudiosSuperiorM;

public class ImplEstudiosSuperiorD extends ImplDAO implements EstudiosSuperiorI {

    @Override
    public void registrarEstudiosSuperiores(EstudiosSuperiorM sup) throws Exception {
        try {
            this.Conexion();
            String sql = "EXEC SP_ESTUDIOSUPER ?,?,?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, sup.getEduSuper());
            st.setString(2, sup.getEspe());
            st.setString(3, sup.getCentrEstu());
            st.setString(4, sup.getDesd());
            st.setString(5, sup.getHast());
            st.setString(6, sup.getCulmi());
            st.setString(7, sup.getGradAcadObte());
            st.setString(8, "A");
            st.setString(9, sup.getCodiEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public void registrar(EstudiosSuperiorM sup) throws Exception {
        try {
            this.Conexion();
            String sql = "EXEC SP_ESTUDIOSUPER ?,?,?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, sup.getEduSuper());
            st.setString(2, sup.getEspe());
            st.setString(3, sup.getCentrEstu());
            st.setString(4, sup.getDesd());
            st.setString(5, sup.getHast());
            st.setString(6, sup.getCulmi());
            st.setString(7, sup.getGradAcadObte());
            st.setString(8, "A");
            st.setString(9, sup.getCodiEmpleado());
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
    public List<EstudiosSuperiorM> listar() throws Exception {
        List<EstudiosSuperiorM> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "select * from vw_EstuSuperEmpl";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EstudiosSuperiorM sup = new EstudiosSuperiorM();
                sup.setIdEstuSuper(rs.getString("IdEstuSuper"));
                sup.setEduSuper(rs.getString("EduSuper"));
                sup.setEspe(rs.getString("EspeSuper"));
                sup.setCentrEstu(rs.getString("CentrEstuSuper"));
                sup.setDesd(rs.getString("DesdSuper"));
                sup.setHast(rs.getString("HastSuper"));
                sup.setCulmi(rs.getString("CulmiSuper"));
                sup.setGradAcadObte(rs.getString("GradAcadObte"));
                sup.setEstado(rs.getString("EstadoSuper"));
                sup.setEmpleado(rs.getString("Empleado"));
                lista.add(sup);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public List<EstudiosSuperiorM> listarInactivos() throws Exception {
        List<EstudiosSuperiorM> listar;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "select * from vw_EstuSuperEmplInac";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            listar = new ArrayList();
            while (rs.next()) {
                EstudiosSuperiorM sup = new EstudiosSuperiorM();
                sup.setIdEstuSuper(rs.getString("IdEstuSuper"));
                sup.setEduSuper(rs.getString("EduSuper"));
                sup.setEspe(rs.getString("EspeSuper"));
                sup.setCentrEstu(rs.getString("CentrEstuSuper"));
                sup.setDesd(rs.getString("DesdSuper"));
                sup.setHast(rs.getString("HastSuper"));
                sup.setCulmi(rs.getString("CulmiSuper"));
                sup.setGradAcadObte(rs.getString("GradAcadObte"));
                sup.setEstado(rs.getString("EstadoSuper"));
                sup.setEmpleado(rs.getString("Empleado"));
                listar.add(sup);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listar;
    }

    @Override
    public EstudiosSuperiorM leerID(String Codigo) throws Exception {
        EstudiosSuperiorM supe = null;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT IdEstuSuper ,EduSuper,EspeSuper,CentrEstuSuper,CONVERT(nvarchar(10),DesdSuper,103) AS DesdSuper,CONVERT(nvarchar(10),HastSuper,103) AS HastSuper,CulmiSuper,GradAcadObte,EstadoSuper,UPPER(CONCAT (Empleado.Nom,',',Empleado.ApelPate,',',Empleado.ApelMate)) AS 'Empleado'  FROM EstudiosSuperior LEFT OUTER JOIN Empleado on EstudiosSuperior.Empleado_idEmpl = Empleado.idEmpl WHERE IdEstuSuper=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, Codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                supe = new EstudiosSuperiorM();
                supe.setIdEstuSuper(rs.getString("IdEstuSuper"));
                supe.setEduSuper(rs.getString("EduSuper"));
                supe.setEspe(rs.getString("EspeSuper"));
                supe.setCentrEstu(rs.getString("CentrEstuSuper"));
                supe.setDesd(rs.getString("DesdSuper"));
                supe.setHast(rs.getString("HastSuper"));
                supe.setCulmi(rs.getString("CulmiSuper"));
                supe.setGradAcadObte(rs.getString("GradAcadObte"));
                supe.setEstado(rs.getString("EstadoSuper"));
                supe.setEmpleado(rs.getString("Empleado"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return supe;
    }

    @Override
    public void modificar(EstudiosSuperiorM sup) throws Exception {
        try {
            this.Conexion();
            String sql = "SP_ESTUDIOS_SUPER_UPDATE ?,?,?,?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, sup.getIdEstuSuper());
            st.setString(2, sup.getEduSuper());
            st.setString(3, sup.getEspe());
            st.setString(4, sup.getCentrEstu());
            st.setString(5, sup.getDesd());
            st.setString(6, sup.getHast());
            st.setString(7, sup.getCulmi());
            st.setString(8, sup.getGradAcadObte());
            st.setString(9, sup.getEstado());
            st.setString(10, sup.getCodiEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(EstudiosSuperiorM sup) throws Exception {
        try {
            this.Conexion();
            String sql = " Update EstudiosSuperior set EstadoSuper = 'I' Where IdEstuSuper =? ";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, sup.getIdEstuSuper());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

}
