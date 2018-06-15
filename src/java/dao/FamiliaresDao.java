package dao;

import dao.interaces.FamiliaresI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Familiares;

public class FamiliaresDao extends DAO implements FamiliaresI {

    @Override
    public void registrarFamiliar(Familiares fam) throws Exception {
        this.Conexion();
        try {
            String sql = "INSERT INTO Familiares  (NomFami,Ape,Par,Ocu,FecNac,Tel,Cel,EstCiv,vive,Estado) values(?,?,?,?,?,CONVERT(DATE,?, 103),?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, fam.getNomFami());
            st.setString(2, fam.getApe());
            st.setString(3, fam.getPar());
            st.setString(4, fam.getOcu());
            st.setString(5, fam.getFecNac());
            st.setString(6, fam.getTel());
            st.setString(7, fam.getCel());
            st.setString(8, fam.getEstCiv());
            st.setString(9, fam.getVive());
            st.setString(10, fam.getEstado());

            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void registrar(Familiares fam) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO Familiares  (NomFami,Ape,Par,Ocu,FecNac,Tel,Cel,EstCiv,vive,Estado) values(?,?,?,?,?,CONVERT(DATE,?, 103),?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, fam.getNomFami());
            st.setString(2, fam.getApe());
            st.setString(3, fam.getPar());
            st.setString(4, fam.getOcu());
            st.setString(5, fam.getFecNac());
            st.setString(6, fam.getTel());
            st.setString(7, fam.getCel());
            st.setString(8, fam.getEstCiv());
            st.setString(9, fam.getVive());
            st.setString(10, fam.getEstado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Familiares> listar() throws Exception {
        List<Familiares> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = " select Familiares.CodFami, Familiares.NomFami, Familiares.Ape, Familiares.Par, Familiares.Ocu, Familiares.FecNac, Familiares.Tel,Familiares.CelularFami, Familiares.EstCivFami,Familiares.vive,Familiares.Estado, Empleado.Nom as 'Nombre del Empleado'\n"
                    + "                    from Familiares\n"
                    + "                      inner join Empleado Empleado on Empleado.Nom = Empleado.Nom\n"
                    + "                 where Estado like 'Activo'";
//            String sql = "select * from vw_FamiliaresAct";
//            String sql = "select CodFami, NomFami, Ape, Par, Ocu, FecNac, Tel,CelularFami, EstCiv,vive, Empleado.Nom as 'Nombre del Empleado'\n"
//                    + " from Familiares\n"
//                    + " inner join Empleado Empleado on Empleado.Nom = Empleado.Nom\n"
//                    + " where Estado like 'Activo'";
//            String sql = "SELECT CodFami, NomFami,Ape,Par,Ocu,FORMAT(FecNac,'dd/MM/yyyy') as FecNac,Tel,Cel,EstCiv,vive FROM Familiares Where Estado like 'Activo'";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Familiares fam = new Familiares();
                fam.setCodFami(rs.getInt("CodFami"));
                fam.setNomFami(rs.getString("NomFami"));
                fam.setApe(rs.getString("Ape"));
                fam.setPar(rs.getString("Par"));
                fam.setOcu(rs.getString("Ocu"));
                fam.setFecNac(rs.getString("FecNac"));
                fam.setTel(rs.getString("Tel"));
                fam.setCel(rs.getString("CelularFami"));
                fam.setEstCiv(rs.getString("EstCivFami"));
                fam.setVive(rs.getString("vive"));
                fam.setEstado(rs.getString("Estado"));
                lista.add(fam);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<Familiares> listarInactivos() throws Exception {
        List<Familiares> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "select Familiares.CodFami, Familiares.NomFami, Familiares.Ape, Familiares.Par, Familiares.Ocu, Familiares.FecNac, Familiares.Tel,Familiares.CelularFami, Familiares.EstCivFami,Familiares.vive,Familiares.Estado, Empleado.Nom as 'Nombre del Empleado'\n"
                    + " from Familiares\n"
                    + " inner join Empleado Empleado on Empleado.Nom = Empleado.Nom\n"
                    + " where Estado like 'Inactivo'";
//            String sql = "SELECT CodFami, NomFami,Ape,Par,Ocu,FORMAT(FecNac,'dd/MM/yyyy') as FecNac,Tel,Cel,EstCiv,vive FROM Familiares Where Estado like 'Activo'";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Familiares fam = new Familiares();
                fam.setCodFami(rs.getInt("CodFami"));
                fam.setNomFami(rs.getString("NomFami"));
                fam.setApe(rs.getString("Ape"));
                fam.setPar(rs.getString("Par"));
                fam.setOcu(rs.getString("Ocu"));
                fam.setFecNac(rs.getString("FecNac"));
                fam.setTel(rs.getString("Tel"));
                fam.setCel(rs.getString("Cel"));
                fam.setEstCiv(rs.getString("EstCiv"));
                fam.setVive(rs.getString("vive"));
                fam.setEstado(rs.getString("Estado"));
                lista.add(fam);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Familiares leerID(Familiares fam) throws Exception {
        Familiares fami = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT CodFami,NomFami,Ape,Par,Ocu,CONVERT(nvarchar(10), FecNac, 103) AS FecNac,Tel,Cel,EstCiv,vive,Estado  FROM Familiares WHERE CodFami=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, fam.getCodFami());
            rs = st.executeQuery();
            while (rs.next()) {
                fami = new Familiares();
                fami.setCodFami(rs.getInt("CodFami"));
                fami.setNomFami(rs.getString("Nom"));
                fami.setApe(rs.getString("Ape"));
                fami.setPar(rs.getString("Par"));
                fami.setOcu(rs.getString("Ocu"));
                fami.setFecNac(rs.getString("FecNac"));
                fami.setTel(rs.getString("Tel"));
                fami.setCel(rs.getString("Cel"));
                fami.setEstCiv(rs.getString("EstCiv"));
                fami.setVive(rs.getString("vive"));
                fami.setEstado(rs.getString("Estado"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return fami;
    }

    @Override
    public void modificar(Familiares fam) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE Familiares SET  NomFami = ?, Ape = ?,Par = ?, Ocu = ?, FecNac = convert(date, ?, 103),Tel = ?, Cel = ?, EstCiv = ?, vive = ?,Estado = ? WHERE CodFami = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, fam.getNomFami());
            st.setString(2, fam.getApe());
            st.setString(3, fam.getPar());
            st.setString(4, fam.getOcu());
            st.setString(5, fam.getFecNac());
            st.setString(6, fam.getTel());
            st.setString(7, fam.getCel());
            st.setString(8, fam.getEstCiv());
            st.setString(9, fam.getVive());
            st.setInt(10, fam.getCodFami());
            st.setString(11, fam.getEstado());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Familiares fam) throws Exception {
        try {
            this.Conexion();
            String sql = "Update Familiares set Estado = 'Inactivo' Where CodFami = ?";
            //String sql = "DELETE FROM Familiares WHERE CodFami = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setInt(1, fam.getCodFami());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
