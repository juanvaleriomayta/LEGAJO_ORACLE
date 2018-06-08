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
            String sql = "INSERT INTO EstudiosBasicos (Educ,Culmi,CentrEstu,Desd,Hasm,Estado) values(?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, bas.getEduc());
            st.setString(2, bas.getCulmi());
            st.setString(3, bas.getCentrEstu());
            st.setString(4, bas.getDesd());
            st.setString(5, bas.getHas());
            st.setString(6, bas.getEstado());

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
            String sql = "INSERT INTO EstudiosBasicos (Educ,Culmi,CentrEstu,Desd,Has,Estado) values(?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, bas.getEduc());
            st.setString(2, bas.getCulmi());
            st.setString(3, bas.getCentrEstu());
            st.setString(4, bas.getDesd());
            st.setString(5, bas.getHas());
            st.setString(6, bas.getEstado());

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
            //select * from vw_EstudioBasico
            String sql = "SELECT IdEstuBasi, Educ,Culmi,CentrEstu,FORMAT(Desd,'dd/MM/yyyy') as Desd,FORMAT(Has,'dd/MM/yyyy') as Has FROM EstudiosBasicos";
            PreparedStatement st = this.getCn().prepareCall(sql);
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
                bas.setEstado(rs.getString("Estado"));

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
            String sql = "SELECT IdEstuBasi, Educ,Culmi,CentrEstu,Desd,Has,Estado  FROM EstudiosBasicos WHERE IdEstuBasi=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
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
                basi.setEstado(rs.getString("Estado"));

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
            String sql = "UPDATE EstudiosBasicos SET Educ = ?, Culmi=?,CentrEstu=? , Desd = convert(date, ?, 103), Has = convert(date, ?, 103),Estado=?  WHERE IdEstuBasi = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, bas.getEduc());
            st.setString(2, bas.getCulmi());
            st.setString(3, bas.getCentrEstu());
            st.setString(4, bas.getDesd());
            st.setString(5, bas.getHas());
            st.setInt(6, bas.getIdEstuBasi());
            st.setString(7, bas.getEstado());
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
            String sql = "DELETE FROM EstudiosBasicos WHERE IdEstuBasi = ?";
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
