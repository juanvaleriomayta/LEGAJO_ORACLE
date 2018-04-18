package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

public class EmpleadoDao extends Conexion implements IEmpleado {

    @Override
    public void guardar(Empleado empleado) throws Exception {
        try {
            String query = "insert into Empleado (Nom, Apel, Telf, GrupSang, RUC,Email, LugNac, Dir,Cel"
                    + "EstCiv,ConLab, Dialec,Lee,Habl,Escr,Est,FecNac, Desd, Has, FecIng) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(query);
            ps.setString(1, empleado.getNom());
            ps.setString(2, empleado.getApel());
            ps.setString(3, empleado.getTelf());
            ps.setString(4, empleado.getGrupSang());
            ps.setString(5, empleado.getRUC());
            ps.setString(6, empleado.getEmail());
            ps.setString(7, empleado.getLugNac());
            ps.setString(8, empleado.getDir());
            ps.setString(9, empleado.getCel());
            ps.setString(10, empleado.getEstCiv());
            ps.setString(11, empleado.getConLab());
            ps.setString(12, empleado.getDialec());
            ps.setString(13, empleado.getLee());
            ps.setString(14, empleado.getHabl());
            ps.setString(15, empleado.getEscr());
            ps.setString(16, empleado.getEst());
            ps.setDate(17, empleado.getFecNac());
            ps.setDate(18, empleado.getDesd());
            ps.setDate(19, empleado.getHas());
            ps.setDate(20, empleado.getFecIng());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.getStackTrace();
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Empleado empleado) throws Exception {
        try {
            String query = "update empleado set Nom=?, Apel=?, Telf=?, GrupSang=?, RUC=?,Email=?, LugNac=?, Dir=?,Cel=? "
                    + "EstCiv=?,ConLab=?, Dialec=?,Lee=?,Habl=?,Escr=?,Est=?,FecNac=?, Desd=?, Has=?, FecIng=? WHERE CodEmpleado=?";
            PreparedStatement ps = this.conectar().prepareStatement(query);
            ps.setString(1, empleado.getNom());
            ps.setString(2, empleado.getApel());
            ps.setString(3, empleado.getTelf());
            ps.setString(4, empleado.getGrupSang());
            ps.setString(5, empleado.getRUC());
            ps.setString(6, empleado.getEmail());
            ps.setString(7, empleado.getLugNac());
            ps.setString(8, empleado.getDir());
            ps.setString(9, empleado.getCel());
            ps.setString(10, empleado.getEstCiv());
            ps.setString(11, empleado.getConLab());
            ps.setString(12, empleado.getDialec());
            ps.setString(13, empleado.getLee());
            ps.setString(14, empleado.getHabl());
            ps.setString(15, empleado.getEscr());
            ps.setString(16, empleado.getEst());
            ps.setDate(17, empleado.getFecNac());
            ps.setDate(18, empleado.getDesd());
            ps.setDate(19, empleado.getHas());
            ps.setDate(20, empleado.getFecIng());
            ps.setInt(21, empleado.getCodigo());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /*public void eliminar(int Cod_Empleado) throws Exception {
        try {
            String query ="delete from empleado where numpac=?";
            PreparedStatement ps=cx.prepareStatement(query);
            ps.setInt(1, Cod_Empleado);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }*/
    @Override
    public List<Empleado> listarTodos() throws Exception {
        List<Empleado> empleados = new ArrayList<>();
        try {
            String sql = "select * from Empleado";
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setNom(rs.getString("Nom"));
                empleado.setApel(rs.getString("Apel"));
                empleado.setTelf(rs.getString("Telf"));
                empleado.setGrupSang(rs.getString("GrupSang"));
                empleado.setRUC(rs.getString("RUC"));
                empleado.setEmail(rs.getString("Email"));
                empleado.setLugNac(rs.getString("LugNac"));
                empleado.setDir(rs.getString("Dir"));
                empleado.setCel(rs.getString("Cel"));
                empleado.setEstCiv(rs.getString("EstCiv"));
                empleado.setConLab(rs.getString("ConLab"));
                empleado.setDialec(rs.getString("Dialec"));
                empleado.setLee(rs.getString("Lee"));
                empleado.setHabl(rs.getString("Habl"));
                empleado.setEscr(rs.getString("Escr"));
                empleado.setEst(rs.getString("Est"));
                empleado.setFecNac(rs.getDate("FecNac"));
                empleado.setDesd(rs.getDate("Desd"));
                empleado.setHas(rs.getDate("Has"));
                empleado.setFecIng(rs.getDate("FecIng"));
                empleado.add(empleado);
            }
            st.close();
            rs.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Empleado listarPorCod(int Cod_Empelado) throws Exception {
        Empleado empleado = new Empleado();
        try {
            String Cod_Empleado = null;
            String sql = "select * from empleado where numpac=" + Cod_Empleado;
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                empleado.setNom(rs.getString("Nom"));
                empleado.setApel(rs.getString("Apel"));
                empleado.setTelf(rs.getString("Telf"));
                empleado.setGrupSang(rs.getString("GrupSang"));
                empleado.setRUC(rs.getString("RUC"));
                empleado.setEmail(rs.getString("Email"));
                empleado.setLugNac(rs.getString("LugNac"));
                empleado.setDir(rs.getString("Dir"));
                empleado.setCel(rs.getString("Cel"));
                empleado.setEstCiv(rs.getString("EstCiv"));
                empleado.setConLab(rs.getString("ConLab"));
                empleado.setDialec(rs.getString("Dialec"));
                empleado.setLee(rs.getString("Lee"));
                empleado.setHabl(rs.getString("Habl"));
                empleado.setEscr(rs.getString("Escr"));
                empleado.setEst(rs.getString("Est"));
                empleado.setFecNac(rs.getDate("FecNac"));
                empleado.setDesd(rs.getDate("Desd"));
                empleado.setHas(rs.getDate("Has"));
                empleado.setFecIng(rs.getDate("FecIng"));
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public void eliminar(int empleado) throws Exception {
        try {
            String query = "delete from empleado where numpac=?";
            PreparedStatement ps = this.conectar().prepareStatement(query);
            ps.setInt(1, empleado);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
