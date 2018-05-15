package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Estudios;



public class EstudiosDao extends DAO{

    public void registrar(Estudios estu) throws Exception {
        try {
            this.Conexion();

            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Estudios (DatSuper,tipGraAca,Desd,Has,Carre) values(?,?,?,?,?)");
            st.setString(1, estu.getDatSuper());
            st.setString(2, estu.getTipGraAca());
            st.setString(3, estu.getDesd());
            st.setString(4, estu.getHas());
            st.setString(5, estu.getCarre());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public List<Estudios> listar() throws Exception {
        List<Estudios> lista;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdEstuGenEmpl, DatSuper,tipGraAca,Desd,Has,Carre FROM Estudios");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Estudios estu = new Estudios();
                estu.setIdEstuGenEmpl(rs.getInt("IdEstuGenEmpl"));
                estu.setDatSuper(rs.getString("DatSuper"));
                estu.setTipGraAca(rs.getString("tipGraAca"));
                estu.setDesd(rs.getString("Desd"));
                estu.setHas(rs.getString("Has"));
                estu.setCarre(rs.getString("Carre"));
                lista.add(estu);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public Estudios leerID(Estudios estu) throws Exception {
        Estudios estud = null;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT IdEstuGenEmpl, DatSuper,tipGraAca,Desd,Has,Carre  FROM Estudios WHERE IdEstuGenEmpl=?");
            st.setInt(1, estu.getIdEstuGenEmpl());
            rs = st.executeQuery();
            while (rs.next()) {
                estud = new Estudios();
                estud.setIdEstuGenEmpl(rs.getInt("IdEstuGenEmpl"));
                estud.setDatSuper(rs.getString("DatSuper"));
                estud.setTipGraAca(rs.getString("tipGraAca"));
                estud.setDesd(rs.getString("Desd"));
                estud.setHas(rs.getString("Has"));
                estud.setCarre(rs.getString("Carre"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return estud;
    }

    public void modificar(Estudios estu) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Estudios SET DatSuper = ?, TipGraAca = ?, Desd = ?, Has = ?,Carre = ?   WHERE IdEstuGenEmpl = ?");
            st.setString(1, estu.getDatSuper());
            st.setString(2, estu.getTipGraAca());
            st.setString(3, estu.getDesd());
            st.setString(4, estu.getHas());
            st.setString(5, estu.getCarre());
            st.setInt(6, estu.getIdEstuGenEmpl());
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(Estudios estu) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Estudios WHERE IdEstuGenEmpl = ?");
            st.setInt(1, estu.getIdEstuGenEmpl());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
