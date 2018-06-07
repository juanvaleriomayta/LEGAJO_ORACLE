package dao;

import dao.interaces.DialectoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Dialecto;


public class DialectoDao extends DAO implements DialectoI{

    @Override
    public void registrar(Dialecto dia) throws Exception {
        try {
            this.Conexion();

            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Dialecto (NomDial) values(?)");
            st.setString(1, dia.getNomDial());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    @Override
    public List<Dialecto> listar() throws Exception {
        List<Dialecto> lista;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT IdDial, NomDial FROM Dialecto");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Dialecto dia = new Dialecto();
                dia.setIdDial(rs.getInt("IdDial"));
                dia.setNomDial(rs.getString("NomDial"));

                lista.add(dia);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Dialecto leerID(Dialecto dia) throws Exception {
        Dialecto dial = null;
        ResultSet rs;

        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT IdDial,NomDial  FROM Dialecto WHERE IdDial=?");
            st.setInt(1, dia.getIdDial());
            rs = st.executeQuery();
            while (rs.next()) {
                dial = new Dialecto();
                dial.setIdDial(rs.getInt("IdDial"));
                dial.setNomDial(rs.getString("NomDial"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return dial;
    }

    @Override
    public void modificar(Dialecto dia) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Dialecto SET NomDial = ? WHERE IdDial = ?");
            st.setString(1, dia.getNomDial());
            st.setInt(2, dia.getIdDial());
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Dialecto dia) throws Exception {
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Dialecto WHERE IdDial = ?");
            st.setInt(1, dia.getIdDial());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
