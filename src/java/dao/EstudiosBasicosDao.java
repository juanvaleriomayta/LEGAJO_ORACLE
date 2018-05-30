package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.EstudiosBasicos;

public class EstudiosBasicosDao extends DAO {

    public void registrarEstudiosBasicos(EstudiosBasicos bas) throws Exception {
        try {
            this.Conexion();

            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO EstudiosBasicos (Educ,Culmi,CentrEstu,Desd,Has) values(?,?,?,?,?)");
            st.setString(1, bas.getEduc());
            st.setString(2, bas.getCulmi());
            st.setString(3, bas.getCentrEstu());
            st.setString(4, bas.getDesd());
            st.setString(5, bas.getHas());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }
    
    
    public void registrar(EstudiosBasicos bas) throws Exception {
        try {
            this.Conexion();

            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO EstudiosBasicos (Educ,Culmi,CentrEstu,Desd,Has) values(?,?,?,?,?)");
            st.setString(1, bas.getEduc());
            st.setString(2, bas.getCulmi());
            st.setString(3, bas.getCentrEstu());
            st.setString(4, bas.getDesd());
            st.setString(5, bas.getHas());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public List<EstudiosBasicos> listar() throws Exception {
        List<EstudiosBasicos> lista;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdEstuBasi, Educ,Culmi,CentrEstu,FORMAT(Desd,'dd/MM/yyyy') as Desd,FORMAT(Has,'dd/MM/yyyy') as Has FROM EstudiosBasicos");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EstudiosBasicos bas = new EstudiosBasicos();
                bas.setIdEstuBasi(rs.getInt("IdEstuBasi"));
                bas.setEduc(rs.getString("Educ"));
                bas.setCulmi(rs.getString("Culmi"));
                bas.setCentrEstu(rs.getString("CentrEstu"));
                bas.setDesd(rs.getString("Desd"));
                bas.setHas(rs.getString("Has"));

                lista.add(bas);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public EstudiosBasicos leerID(EstudiosBasicos bas) throws Exception {
        EstudiosBasicos basi = null;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT IdEstuBasi, Educ,Culmi,CentrEstu,Desd,Has  FROM EstudiosBasicos WHERE IdEstuBasi=?");
            st.setInt(1, bas.getIdEstuBasi());
            rs = st.executeQuery();
            while (rs.next()) {
                basi = new EstudiosBasicos();
                basi.setIdEstuBasi(rs.getInt("IdEstuBasi"));
                basi.setEduc(rs.getString("Educ"));
                basi.setCulmi(rs.getString("Culmi"));
                basi.setCentrEstu(rs.getString("CentrEstu"));
                basi.setDesd(rs.getString("Desd"));
                basi.setHas(rs.getString("Has"));

            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return basi;
    }

    public void modificar(EstudiosBasicos bas) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE EstudiosBasicos SET Educ = ?, Culmi=?,CentrEstu=? , Desd = convert(date, ?, 103), Has = convert(date, ?, 103)  WHERE IdEstuBasi = ?");
            st.setString(1, bas.getEduc());
            st.setString(2, bas.getCulmi());
            st.setString(3, bas.getCentrEstu());
            st.setString(4, bas.getDesd());
            st.setString(5, bas.getHas());
            st.setInt(6, bas.getIdEstuBasi());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(EstudiosBasicos bas) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM EstudiosBasicos WHERE IdEstuBasi = ?");
            st.setInt(1, bas.getIdEstuBasi());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
