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
            String sql = "INSERT INTO EstudiosSuperiores (EduSuper,Espe,CentrEstu,Desd,Hast,Culmi,Estado,GradAcadObte) values(?,?,?,?,CONVERT(DATE, ?,103),CONVERT(Date, ? , 103),?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, sup.getEduSuper());
            st.setString(2, sup.getEspe());
            st.setString(3, sup.getCentrEstu());
            st.setString(4, sup.getDesd());
            st.setString(5, sup.getHast());
            st.setString(6, sup.getCulmi());
            st.setString(7, sup.getGradAcadObte());
            st.setString(8, sup.getEstado());
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
            String sql = "INSERT INTO EstudiosSuperiores (EduSuper,Espe,CentrEstu,Desd,Hast,Culmi,Estado,GradAcadObte) values(?,?,?,?,CONVERT(DATE,?,103),CONVERT(DATE,?,103),?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, sup.getEduSuper());
            st.setString(2, sup.getEspe());
            st.setString(3, sup.getCentrEstu());
            st.setString(4, sup.getDesd());
            st.setString(5, sup.getHast());
            st.setString(6, sup.getCulmi());
            st.setString(7, sup.getGradAcadObte());
            st.setString(8, sup.getEstado());
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
            String sql = " select IdEstuSuper,EduSuper,Espe,CentrEstu,Desd,Hast,Culmi,GradAcadObte,Estado, Empleado.Nom as 'Nombre del Empleado'    \n"
                    + " from EstudiosSuperior\n"
                    + " inner join Empleado Empleado on Empleado.Nom = Empleado.Nom\n"
                    + " where Estado like 'Activo'";
//            String sql = "SELECT IdEstuSuper, EduSuper,Culmi,Espe,CentrEstu,FORMAT(Desd,'dd/MM/yyyy') as Desd,FORMAT(Hast,'dd/MM/yyyy') as Hast,Culmi,GradAcadObte FROM EstudiosSuperiores Where Estado like 'Activo'";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EstudiosSuperior sup = new EstudiosSuperior();
                sup.setIdEstuSuper(rs.getInt("IdEstuSuper"));
                sup.setEduSuper(rs.getString("EduSuper"));
                sup.setEspe(rs.getString("Espe"));
                sup.setCentrEstu(rs.getString("CentrEstu"));
                sup.setDesd(rs.getString("Desd"));
                sup.setHast(rs.getString("Hast"));
                sup.setCulmi(rs.getString("Culmi"));
                sup.setGradAcadObte(rs.getString("GradAcadObte"));
                sup.setEstado(rs.getString("Estado"));
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
            String sql = " select IdEstuSuper,EduSuper,Espe,CentrEstu,FORMAT(Desd,'dd/MM/yyyy')as Desd,FORMAT(Hast, 'dd/MM/yyyy')as Hast,Culmi,GradAcadObte,Estado, Empleado.Nom as 'Nombre del Empleado'    \n"
                    + " from EstudiosSuperior\n"
                    + " inner join Empleado Empleado on Empleado.Nom = Empleado.Nom\n"
                    + " where Estado like 'Inactivo'";
//            String sql = "SELECT IdEstuSuper, EduSuper,Culmi,Espe,CentrEstu,FORMAT(Desd,'dd/MM/yyyy') as Desd,FORMAT(Hast,'dd/MM/yyyy') as Hast,Culmi,GradAcadObte FROM EstudiosSuperiores Where Estado like 'Activo'";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EstudiosSuperior sup = new EstudiosSuperior();
                sup.setIdEstuSuper(rs.getInt("IdEstuSuper"));
                sup.setEduSuper(rs.getString("EduSuper"));
                sup.setEspe(rs.getString("Espe"));
                sup.setCentrEstu(rs.getString("CentrEstu"));
                sup.setDesd(rs.getString("Desd"));
                sup.setHast(rs.getString("Hast"));
                sup.setCulmi(rs.getString("Culmi"));
                sup.setGradAcadObte(rs.getString("GradAcadObte"));
                sup.setEstado(rs.getString("Estado"));
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
            String sql = "SELECT IdEstuSuper ,EduSuper,Espe,CentrEstu,CONVERT(nvarchar(10),Desd,103) AS Desd,CONVERT(nvarchar(10),Has,103) AS Has,Culmi,GradAcadObte,Estado FROM EstudiosSuperiores WHERE IdEstuSuper=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, sup.getIdEstuSuper());
            rs = st.executeQuery();
            while (rs.next()) {
                supe = new EstudiosSuperior();
                supe.setIdEstuSuper(rs.getInt("IdEstuSuper"));
                supe.setEduSuper(rs.getString("EduSuper"));
                supe.setEspe(rs.getString("Espe"));
                supe.setCentrEstu(rs.getString("CentrEstu"));
                supe.setDesd(rs.getString("Desd"));
                supe.setHast(rs.getString("Hast"));
                supe.setCulmi(rs.getString("Culmi"));
                supe.setGradAcadObte(rs.getString("GradAcadObte"));
                supe.setEstado(rs.getString("Estado"));

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
            String sql = "UPDATE EstudiosSuperiores SET EduSuper = ?, Espe=?,CentrEstu =?, Desd = convert(date, ?, 103), Hast = convert(date, ?, 103),Culmi=?,GradAcadObte=? ,Estado = ? WHERE IdEstuSuper = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, sup.getEduSuper());
            st.setString(2, sup.getEspe());
            st.setString(3, sup.getCentrEstu());
            st.setString(4, sup.getDesd());
            st.setString(5, sup.getHast());
            st.setString(6, sup.getCulmi());
            st.setString(7, sup.getGradAcadObte());
            st.setInt(8, sup.getIdEstuSuper());
            st.setString(9, sup.getEstado());
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
