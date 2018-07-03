package dao;

import dao.interaces.EstudiosSuperiorI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EstudiosSuperior;

public class EstudiosSuperiorDao extends DAO implements EstudiosSuperiorI {

    @Override
    public void registrarEstudiosSuperiores(EstudiosSuperior sup) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO EstudiosSuperiores (EduSuper,EspeSuper,CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,EstadoSuper,GradAcadObte,Empleado_idEmpl) values(?,?,?,?,CONVERT(DATE, ?,103),CONVERT(Date, ? , 103),?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, sup.getEduSuper());
            st.setString(2, sup.getEspe());
            st.setString(3, sup.getCentrEstu());
            st.setString(4, sup.getDesd());
            st.setString(5, sup.getHast());
            st.setString(6, sup.getCulmi());
            st.setString(7, sup.getGradAcadObte());
            st.setString(8, sup.getEstado());
            st.setString(9, sup.getEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public void registrar(EstudiosSuperior sup) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO EstudiosSuperiores (EduSuper,EspeSuper,CentrEstuSuper,DesdSuper,HastSuper,CulmiSuper,EstadoSuper,GradAcadObte,Empleado_idEmpl) values(?,?,?,?,CONVERT(DATE,?,103),CONVERT(DATE,?,103),?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, sup.getEduSuper());
            st.setString(2, sup.getEspe());
            st.setString(3, sup.getCentrEstu());
            st.setString(4, sup.getDesd());
            st.setString(5, sup.getHast());
            st.setString(6, sup.getCulmi());
            st.setString(7, sup.getGradAcadObte());
            st.setString(8, sup.getEstado());
            st.setString(9, sup.getEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public List<EstudiosSuperior> listar() throws Exception {
        List<EstudiosSuperior> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "select * from vw_EstuSuperEmpl";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EstudiosSuperior sup = new EstudiosSuperior();
                sup.setEduSuper(rs.getString("EduSuper"));
                sup.setEspe(rs.getString("EspeSuper"));
                sup.setCentrEstu(rs.getString("CentrEstuSuper"));
                sup.setDesd(rs.getString("DesdSuper"));
                sup.setHast(rs.getString("HastSuper"));
                sup.setCulmi(rs.getString("CulmiSuper"));
                sup.setGradAcadObte(rs.getString("GradAcadObte"));
                sup.setEstado(rs.getString("EstadoSuper"));
                sup.setEmpleado(rs.getString("Empleado_idEmpl"));
                lista.add(sup);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
     public List<EstudiosSuperior> listarInactivos() throws Exception {
        List<EstudiosSuperior> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "select * from vw_EstuSuperEmplInac";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EstudiosSuperior sup = new EstudiosSuperior();
                sup.setEduSuper(rs.getString("EduSuper"));
                sup.setEspe(rs.getString("EspeSuper"));
                sup.setCentrEstu(rs.getString("CentrEstuSuper"));
                sup.setDesd(rs.getString("DesdSuper"));
                sup.setHast(rs.getString("HastSuper"));
                sup.setCulmi(rs.getString("CulmiSupe"));
                sup.setGradAcadObte(rs.getString("GradAcadObte"));
                sup.setEstado(rs.getString("EstadoSuper"));
                sup.setEmpleado(rs.getString("Empleado_idEmpl"));
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
    public EstudiosSuperior leerID(EstudiosSuperior sup) throws Exception {
        EstudiosSuperior supe = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT IdEstuSuper ,EduSuper,EspeSuper,CentrEstuSuper,CONVERT(nvarchar(10),DesdSuper,103) AS Desd,CONVERT(nvarchar(10),HastSuper,103) AS Has,CulmiSuper,GradAcadObte,EstadoSuper,Empleado_idEmpl FROM EstudiosSuperiores WHERE IdEstuSuper=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, sup.getIdEstuSuper());
            rs = st.executeQuery();
            while (rs.next()) {
                supe = new EstudiosSuperior();
                supe.setIdEstuSuper(rs.getInt("IdEstuSuper"));
                supe.setEduSuper(rs.getString("EduSuper"));
                supe.setEspe(rs.getString("EspeSuper"));
                supe.setCentrEstu(rs.getString("CentrEstuSuper"));
                supe.setDesd(rs.getString("DesdSuper"));
                supe.setHast(rs.getString("HastSuper"));
                supe.setCulmi(rs.getString("CulmiSuper"));
                supe.setGradAcadObte(rs.getString("GradAcadObte"));
                supe.setEstado(rs.getString("EstadoSuper"));
                supe.setEmpleado(rs.getString("Empleado_idEmpl"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return supe;
    }

    @Override
    public void modificar(EstudiosSuperior sup) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE EstudiosSuperiores SET EduSuper = ?, EspeSuper=?,CentrEstuSuper =?, DesdSuper = convert(date, ?, 103), HastSuper = convert(date, ?, 103),CulmiSuper=?,GradAcadObte=? ,EstadoSuper = ?,Empleado_idEmpl=? WHERE IdEstuSuper = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, sup.getEduSuper());
            st.setString(2, sup.getEspe());
            st.setString(3, sup.getCentrEstu());
            st.setString(4, sup.getDesd());
            st.setString(5, sup.getHast());
            st.setString(6, sup.getCulmi());
            st.setString(7, sup.getGradAcadObte());
            st.setString(8, sup.getEstado());
            st.setString(9, sup.getEmpleado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(EstudiosSuperior sup) throws Exception {
        try {
            this.Conexion();
            String sql = " Update EstudiosSuperiores set Estado = 'Inactivo' Where IdEstuSuper =? ";
            //String sql = "DELETE FROM EstudiosSuperiores WHERE IdEstuSuper = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, sup.getIdEstuSuper());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
