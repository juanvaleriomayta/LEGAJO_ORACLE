package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EstudiosSuperior;

public class EstudiosSuperiorDao extends DAO {

    public void registrar(EstudiosSuperior sup) throws Exception {
        try {
            this.Conexion();

            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO EstudiosSuperiores (EduSuper,Espe,CentrEstu,Desd,Hast,Culmi,GradAcadObte) values(?,?,?,?,?,?,?)");
            st.setString(1, sup.getEduSuper());
            st.setString(2, sup.getEspe());
            st.setString(3, sup.getCentrEstu());
            st.setString(4, sup.getDesd());
            st.setString(5, sup.getHast());
            st.setString(6, sup.getCulmi());
            st.setString(7, sup.getGradAcadObte());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public List<EstudiosSuperior> listar() throws Exception {
        List<EstudiosSuperior> lista;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdEstuSuper, EduSuper,Culmi,Espe,CentrEstu,FORMAT(Desd,'dd/MM/yyyy') as Desd,FORMAT(Hast,'dd/MM/yyyy') as Hast,Culmi,GradAcadObte FROM EstudiosSuperiores");
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

                lista.add(sup);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public EstudiosSuperior leerID(EstudiosSuperior sup) throws Exception {
        EstudiosSuperior supe = null;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT IdEstuSuper ,EduSuper,Espe,CentrEstu,Desd,Hast,Culmi,GradAcadObte FROM EstudiosSuperiores WHERE IdEstuSuper=?");
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

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return supe;
    }

    public void modificar(EstudiosSuperior sup) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE EstudiosSuperiores SET EduSuper = ?, Espe=?,CentrEstu =?, Desd = convert(date, ?, 103), Hast = convert(date, ?, 103),Culmi=?,GradAcadObte=?  WHERE IdEstuSuper = ?");
            st.setString(1, sup.getEduSuper());
            st.setString(2, sup.getEspe());
            st.setString(3, sup.getCentrEstu());
            st.setString(4, sup.getDesd());
            st.setString(5, sup.getHast());
            st.setString(6, sup.getCulmi());
            st.setString(7, sup.getGradAcadObte());
            st.setInt(8, sup.getIdEstuSuper());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(EstudiosSuperior sup) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM EstudiosSuperiores WHERE IdEstuSuper = ?");
            st.setInt(1, sup.getIdEstuSuper());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
