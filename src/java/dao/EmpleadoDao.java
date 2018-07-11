package dao;

import dao.interaces.EmpleadoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import modelo.Empleado;

@ManagedBean(name = "lisEmpl")
public class EmpleadoDao extends DAO implements EmpleadoI {

    @Override
    public void registrarEmpleado(Empleado emp) throws Exception {
        try {
            this.Conexion();
            String sql = "EXEC sp_Empleados ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, emp.getDNI());
            st.setString(2, emp.getNom());
            st.setString(3, emp.getApelPate());
            st.setString(4, emp.getApelMate());
            st.setString(5, emp.getRUC());
            st.setString(6, emp.getEmail());
            st.setString(7, emp.getTelf());
            st.setString(8, emp.getCel());
            st.setString(9, emp.getFecNac());
            st.setString(10, emp.getGrupSang());
            st.setString(11, emp.getEstCiv());
            st.setString(12, emp.getConLab());
            st.setString(13, emp.getCarnAseg());
            st.setString(14, emp.getRefe());
            st.setString(15, emp.getLeye());
            st.setString(16, emp.getFecIng());
            st.setString(17, emp.getFecNom());
            st.setString(18, emp.getDatCony());
            st.setString(19, emp.getUbigActu());
            st.setString(20, "A");
            st.setString(21, emp.getOrigen());

//            st.setString(22, emp.getFamiliaresNom());
//            st.setString(23, emp.getFamiliaresApe());
//            st.setString(24, emp.getEmergenciaNom());
//            st.setString(25, emp.getEmergenciaApe());
//            st.setString(26, emp.getEstuBasiEducacion());
//            st.setString(27, emp.getEstuBasiCentroEstudos());
//            st.setString(28, emp.getEstuSuperEducacion());
//            st.setString(29, emp.getEstuSuperCentroEstudios());
            st.setString(30, emp.getPass());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void registrar(Empleado emp) throws Exception {
        try {
            this.Conexion();
            String sql = "EXEC sp_Empleados ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, emp.getDNI());
            st.setString(2, emp.getNom());
            st.setString(3, emp.getApelPate());
            st.setString(4, emp.getApelMate());
            st.setString(5, emp.getRUC());
            st.setString(6, emp.getEmail());
            st.setString(7, emp.getTelf());
            st.setString(8, emp.getCel());
            st.setString(9, emp.getFecNac());
            st.setString(10, emp.getGrupSang());
            st.setString(11, emp.getEstCiv());
            st.setString(12, emp.getConLab());
            st.setString(13, emp.getCarnAseg());
            st.setString(14, emp.getRefe());
            st.setString(15, emp.getLeye());
            st.setString(16, emp.getFecIng());
            st.setString(17, emp.getFecNom());
            st.setString(18, emp.getDatCony());
            st.setString(19, emp.getUbigActu());
            st.setString(20, "A");
            st.setString(21, emp.getOrigen());

//            st.setString(22, emp.getFamiliaresNom());
//            st.setString(23, emp.getFamiliaresApe());
//            st.setString(24, emp.getEmergenciaNom());
//            st.setString(25, emp.getEmergenciaApe());
//            st.setString(26, emp.getEstuBasiEducacion());
//            st.setString(27, emp.getEstuBasiCentroEstudos());
//            st.setString(28, emp.getEstuSuperEducacion());
//            st.setString(29, emp.getEstuSuperCentroEstudios());
//            st.setString(30, emp.getPass());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public String obtenerCodigoEmpleado(String Empleado) throws SQLException {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "select idEmpl from Empleado where concat(Nom,',',ApelPate,',',ApelMate) like ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Empleado);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("idEmpl");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }

    public Empleado sessionEmpleado(String DNI, String Pass) throws Exception {
        this.Conexion();
        ResultSet rs;
        Empleado emp = null;
        try {
            String sql = "select idEmpl,Nom,ApelPate,ApelMate,RUC,Email,Telf,Cel,FecNac,GrupSang,EstCiv,ConLab,CarnAseg,Refe,Leye,FecIng,FecNom,DatCony,UbigActu,Origen from Empleado where DNI like ? and Pass like ? AND Est like 'A'";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, DNI);
            st.setString(2, Pass);
            rs = st.executeQuery();
            if (rs.next()) {
                emp = new Empleado();
                emp.setNom(rs.getString("idEmpl"));
                emp.setNom(rs.getString("Nom"));
                emp.setApelPate(rs.getString("ApelPate"));
                emp.setApelMate(rs.getString("ApelMate"));
                emp.setRUC(rs.getString("RUC"));
                emp.setEmail(rs.getString("Email"));
                emp.setCel(rs.getString("Cel"));
                emp.setFecNac(rs.getString("FecNac"));
                emp.setGrupSang(rs.getString("GrupSang"));
                emp.setEstCiv(rs.getString("EstCiv"));
                emp.setConLab(rs.getString("ConLab"));  
                emp.setCarnAseg(rs.getString("CarnAseg"));
                emp.setRefe(rs.getString("Refe"));
                emp.setLeye(rs.getString("Leye"));
                emp.setFecIng(rs.getString("FecIng"));
                emp.setFecNom(rs.getString("FecNom"));
                emp.setDatCony(rs.getString("DatCony"));
                emp.setTelf(rs.getString("Telf"));
                emp.setUbigActu(rs.getString("UbigActu"));
                emp.setOrigen(rs.getString("Origen"));
//                emp.setFamiliaresNom(rs.getString("NomFami"));
//                emp.setFamiliaresApe(rs.getString("ApelFami"));
//                emp.setEmergenciaNom(rs.getString("NomEmer"));
//                emp.setEmergenciaApe(rs.getString("ApeEmer"));
//                emp.setEstuBasiEducacion(rs.getString("EducBasi"));
//                emp.setEstuBasiCentroEstudos(rs.getString("CentrEstuBasi"));
//                emp.setEstuSuperEducacion(rs.getString("EduSuper"));
//                emp.setEstuSuperCentroEstudios(rs.getString("CentrEstuSuper"));
            }
            return emp;
        } catch (SQLException e) {
            throw e;
        }

    }
    
    public List<String> autocompleteEmpleado(String Consulta) throws SQLException {
        this.Conexion();
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "select concat(Nom,',',ApelPate,',',ApelMate) AS Apellidos from Empleado where UPPER(Nom) like UPPER(?) or UPPER(ApelPate) like UPPER(?)  or UPPER(ApelMate) like UPPER(?)";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            ps.setString(2, "%" + Consulta + "%");
            ps.setString(3, "%" + Consulta + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {

                Lista.add(rs.getString("Apellidos"));
            }
            return Lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override

    public List<Empleado> listarActivos() throws Exception {
        List<Empleado> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM vw_Empleados";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setIdEmpl(rs.getString("idEmpl"));
                emp.setDNI(rs.getString("DNI"));
                emp.setNom(rs.getString("Nom"));
                emp.setApelPate(rs.getString("ApelPate"));
                emp.setApelMate(rs.getString("ApelMate"));
                emp.setRUC(rs.getString("RUC"));
                emp.setEmail(rs.getString("Email"));
                emp.setCel(rs.getString("Cel"));
                emp.setFecNac(rs.getString("FecNac"));
                emp.setGrupSang(rs.getString("GrupSang"));
                emp.setEstCiv(rs.getString("EstCiv"));
                emp.setConLab(rs.getString("ConLab"));
                emp.setCarnAseg(rs.getString("CarnAseg"));
                emp.setRefe(rs.getString("Refe"));
                emp.setLeye(rs.getString("Leye"));
                emp.setFecIng(rs.getString("FecIng"));
                emp.setFecNom(rs.getString("FecNom"));
                emp.setDatCony(rs.getString("DatCony"));
                emp.setTelf(rs.getString("Telf"));
                emp.setUbigActu(rs.getString("Direccion"));
                emp.setOrigen(rs.getString("Lugar de Nacimiento"));
                emp.setEst(rs.getString("Est"));
//                emp.setFamiliaresNom(rs.getString("NomFami"));
//                emp.setFamiliaresApe(rs.getString("ApelFami"));
//                emp.setEmergenciaNom(rs.getString("NomEmer"));
//                emp.setEmergenciaApe(rs.getString("ApeEmer"));
//                emp.setEstuBasiEducacion(rs.getString("EducBasi"));
//                emp.setEstuBasiCentroEstudos(rs.getString("CentrEstuBasi"));
//                emp.setEstuSuperEducacion(rs.getString("EduSuper"));
//                emp.setEstuSuperCentroEstudios(rs.getString("CentrEstuSuper"));
                lista.add(emp);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public List<Empleado> listarInactivos() throws Exception {
        List<Empleado> lista;
        ResultSet rs;

        try {
            this.Conexion();

            String sql = "SELECT * FROM vw_EmpleadosInac";

            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setDNI(rs.getString("DNI"));
                emp.setNom(rs.getString("Nom"));
                emp.setApelPate(rs.getString("ApelPate"));
                emp.setApelMate(rs.getString("ApelMate"));
                emp.setRUC(rs.getString("RUC"));
                emp.setEmail(rs.getString("Email"));
                emp.setCel(rs.getString("Cel"));
                emp.setFecNac(rs.getString("FecNac"));
                emp.setGrupSang(rs.getString("GrupSang"));
                emp.setEstCiv(rs.getString("EstCiv"));
                emp.setConLab(rs.getString("ConLab"));
                emp.setCarnAseg(rs.getString("CarnAseg"));
                emp.setRefe(rs.getString("Refe"));
                emp.setLeye(rs.getString("Leye"));
                emp.setFecIng(rs.getString("FecIng"));
                emp.setFecNom(rs.getString("FecNom"));
                emp.setDatCony(rs.getString("DatCony"));
                emp.setTelf(rs.getString("Telf"));
                emp.setUbigActu(rs.getString("Direccion"));
                emp.setOrigen(rs.getString("Lugar de Nacimiento"));
                emp.setEst(rs.getString("Est"));
//                emp.setFamiliaresNom(rs.getString("NomFami"));
//                emp.setFamiliaresApe(rs.getString("ApelFami"));
//                emp.setEmergenciaNom(rs.getString("NomEmer"));
//                emp.setEmergenciaApe(rs.getString("ApeEmer"));
//                emp.setEstuBasiEducacion(rs.getString("EducBasi"));
//                emp.setEstuBasiCentroEstudos(rs.getString("CentrEstuBasi"));
//                emp.setEstuSuperEducacion(rs.getString("EduSuper"));
//                emp.setEstuSuperCentroEstudios(rs.getString("CentrEstuSuper"));
                lista.add(emp);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Empleado leerID(String codigo) throws Exception {
        Empleado emple = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT idEmpl, DNI,Nom,ApelPate,ApelMate,RUC,Email,Telf,Cel,CONVERT(nvarchar(10),FecNac,103) AS FecNac,GrupSang,EstCiv,ConLab,CarnAseg,Refe,Leye,CONVERT(nvarchar(10),FecIng,103) AS FecIng,CONVERT(nvarchar(10),FecNom,103) AS FecNom,DatCony,UbigActu,Est,Origen FROM Empleado WHERE idEmpl=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                emple = new Empleado();
                emple.setIdEmpl(rs.getString("idEmpl"));
                emple.setDNI(rs.getString("DNI"));
                emple.setNom(rs.getString("Nom"));
                emple.setApelPate(rs.getString("ApelPate"));
                emple.setApelMate(rs.getString("ApelMate"));
                emple.setRUC(rs.getString("RUC"));
                emple.setEmail(rs.getString("Email"));
                emple.setTelf(rs.getString("Telf"));
                emple.setCel(rs.getString("Cel"));
                emple.setFecNac(rs.getString("FecNac"));
                emple.setGrupSang(rs.getString("GrupSang"));
                emple.setEstCiv(rs.getString("EstCiv"));
                emple.setConLab(rs.getString("ConLab"));
                emple.setCarnAseg(rs.getString("CarnAseg"));
                emple.setRefe(rs.getString("Refe"));
                emple.setLeye(rs.getString("Leye"));
                emple.setFecIng(rs.getString("FecIng"));
                emple.setFecNom(rs.getString("FecNom"));
                emple.setDatCony(rs.getString("DatCony"));
                emple.setUbigActu(rs.getString("UbigActu"));
                emple.setEst(rs.getString("Est"));
                emple.setOrigen(rs.getString("Origen"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return emple;
    }

    @Override
    public void modificar(Empleado emp) throws Exception {
        try {
            this.Conexion();
            String sql = "EXEC SP_EMPLEADO_UPDATE ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
//            String sql = "UPDATE Empleado SET DNI = ?, Nom = ?, ApelPate = ?, ApelMate = ?,RUC = ?, Email = ?,Telf = ?,Cel = ?,FecNac=to_date(?,'DD/MM/YYYY'),GrupSang = ?,EstCiv = ?,ConLab = ?,CarnAseg = ?,Refe = ?,Leye = ?,FecIng=to_date('DD/MM/YYYY'),FecNom=to_date('DD/MM/YYYY'),DatCony = ?,UbigActu = ?,UbigOrig = ?,Est = ? WHERE idEmpl = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, emp.getIdEmpl());
            st.setString(2, emp.getDNI());
            st.setString(3, emp.getNom());
            st.setString(4, emp.getApelPate());
            st.setString(5, emp.getApelMate());
            st.setString(6, emp.getRUC());
            st.setString(7, emp.getEmail());
            st.setString(8, emp.getTelf());
            st.setString(9, emp.getCel());
            st.setString(10, emp.getFecNac());
            st.setString(11, emp.getGrupSang());
            st.setString(12, emp.getEstCiv());
            st.setString(13, emp.getConLab());
            st.setString(14, emp.getCarnAseg());
            st.setString(15, emp.getRefe());
            st.setString(16, emp.getLeye());
            st.setString(17, emp.getFecIng());
            st.setString(18, emp.getFecNom());
            st.setString(19, emp.getDatCony());
            st.setString(20, emp.getUbigActu());
            st.setString(21, emp.getEst());
            st.setString(22, emp.getOrigen());

            //            st.setString(23, emp.getPass());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Empleado emp) throws Exception {
        try {
            this.Conexion();
            String sql = "Update Empleado set Est=? WHERE idEmpl = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, "I");
            st.setString(2, emp.getIdEmpl());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
