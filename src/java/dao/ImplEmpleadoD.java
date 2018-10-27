package dao;

import Interfaces.EmpleadoI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import modelo.EmpleadoM;

@ManagedBean(name = "lisEmpl")
public class ImplEmpleadoD extends ImplDAO implements EmpleadoI {

    @Override
    public void registrarEmpleado(EmpleadoM emp) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO EMPLEADO (DNIEMPL,NOMEMPL,APEPATEEMPL,APEMATEEMPL,RUCEMPL,EMAILEMPL,TELEMPL,CELEMPL,FECNACEMPL,GRUPSANGEMPL,ESTCIVEMPL,CONLABEMPL,CARASEEMPL,REFEEMPL,LEYEMPL,FEUNGEMPL,FECNONEMPL,DATCONYEMPL,UBIGEMPL,ESTEMPL,ORIEMPL) VALUES (?,?,?,?,?,?,?,?,TO_DATE(FECNACEMPL,'DD/MM/YYYY'),?,?,?,?,?,?,TO_DATE(FEUNGEMPL,'DD/MM/YYYY'),TO_DATE(FECNONEMPL,'DD/MM/YYYY'),?,?,?,?)";
//            String sql = "EXEC sp_Empleados ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
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
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void registrarNombrado(EmpleadoM emp) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO EMPLEADO (DNIEMPL,NOMEMPL,APEPATEEMPL,APEMATEEMPL,RUCEMPL,EMAILEMPL,TELEMPL,CELEMPL,FECNACEMPL,GRUPSANGEMPL,ESTCIVEMPL,CONLABEMPL,CARASEEMPL,REFEEMPL,LEYEMPL,FEUNGEMPL,FECNONEMPL,DATCONYEMPL,UBIGEMPL,ESTEMPL,ORIEMPL) VALUES (?,?,?,?,?,?,?,?,TO_DATE(FECNACEMPL,'DD/MM/YYYY'),?,?,?,?,?,?,TO_DATE(FEUNGEMPL,'DD/MM/YYYY'),TO_DATE(FECNONEMPL,'DD/MM/YYYY'),?,?,?,?)";
//            String sql = "EXEC sp_Empleados ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
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
            st.setString(12, "NOMBRADO");
            st.setString(13, emp.getCarnAseg());
            st.setString(14, emp.getRefe());
            st.setString(15, emp.getLeye());
            st.setString(16, emp.getFecIng());
            st.setString(17, emp.getFecNom());
            st.setString(18, emp.getDatCony());
            st.setString(19, emp.getUbigActu());
            st.setString(20, "A");
            st.setString(21, emp.getOrigen());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public void registrarCAS(EmpleadoM emp) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO EMPLEADO (DNIEMPL,NOMEMPL,APEPATEEMPL,APEMATEEMPL,RUCEMPL,EMAILEMPL,TELEMPL,CELEMPL,FECNACEMPL,GRUPSANGEMPL,ESTCIVEMPL,CONLABEMPL,CARASEEMPL,REFEEMPL,LEYEMPL,FEUNGEMPL,FECNONEMPL,DATCONYEMPL,UBIGEMPL,ESTEMPL,ORIEMPL) VALUES (?,?,?,?,?,?,?,?,TO_DATE(FECNACEMPL,'DD/MM/YYYY'),?,?,?,?,?,?,TO_DATE(FEUNGEMPL,'DD/MM/YYYY'),TO_DATE(FECNONEMPL,'DD/MM/YYYY'),?,?,?,?)";
//            String sql = "EXEC sp_Empleados ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
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
            st.setString(12, "CAS");
            st.setString(13, emp.getCarnAseg());
            st.setString(14, emp.getRefe());
            st.setString(15, emp.getLeye());
            st.setString(16, emp.getFecIng());
            st.setString(17, emp.getFecNom());
            st.setString(18, emp.getDatCony());
            st.setString(19, emp.getUbigActu());
            st.setString(20, "A");
            st.setString(21, emp.getOrigen());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public void registrarCESANTE(EmpleadoM emp) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO EMPLEADO (DNIEMPL,NOMEMPL,APEPATEEMPL,APEMATEEMPL,RUCEMPL,EMAILEMPL,TELEMPL,CELEMPL,FECNACEMPL,GRUPSANGEMPL,ESTCIVEMPL,CONLABEMPL,CARASEEMPL,REFEEMPL,LEYEMPL,FEUNGEMPL,FECNONEMPL,DATCONYEMPL,UBIGEMPL,ESTEMPL,ORIEMPL) VALUES (?,?,?,?,?,?,?,?,TO_DATE(FECNACEMPL,'DD/MM/YYYY'),?,?,?,?,?,?,TO_DATE(FEUNGEMPL,'DD/MM/YYYY'),TO_DATE(FECNONEMPL,'DD/MM/YYYY'),?,?,?,?)";
//            String sql = "EXEC sp_Empleados ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
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
            st.setString(12, "CESANTE");
            st.setString(13, emp.getCarnAseg());
            st.setString(14, emp.getRefe());
            st.setString(15, emp.getLeye());
            st.setString(16, emp.getFecIng());
            st.setString(17, emp.getFecNom());
            st.setString(18, emp.getDatCony());
            st.setString(19, emp.getUbigActu());
            st.setString(20, "A");
            st.setString(21, emp.getOrigen());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public String obtenerCodigoEmpleado(String Empleado) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "SELECT CODEMPL FROM EMPLEADO WHERE NOMEMPL| |APEPATEEMPL| |APEMATEEMPL like ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Empleado);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODEMPL");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }
    }
    
     public String CodigoEmpleado(String Empleado) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        try {
            String sql = "SELECT CODEMPL FROM EMPLEADO WHERE DNIEMPL LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, Empleado);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("CODEMPL");
            }
            return null;
        } catch (SQLException e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    public List<String> autocompleteEmpleado(String Consulta) throws SQLException, Exception {
        this.Conexion();
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "SELECT NOMEMPL| |APEPATEEMPL| |APEMATEEMPL AS APELLIDOS FROM EMPLEADO WHERE UPPER(NOMEMPL) LIKE UPPER(?) OR UPPER(APEPATEEMPL) LIKE UPPER(?)  OR UPPER(APEMATEEMPL) LIKE UPPER(?)";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, "%" + Consulta + "%");
            ps.setString(2, "%" + Consulta + "%");
            ps.setString(3, "%" + Consulta + "%");
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {

                Lista.add(rs.getString("APELLIDOS"));
            }
            return Lista;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<EmpleadoM> listarActivosNombrados() throws Exception {
        List<EmpleadoM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM VW_EMPLEADOSNOMBRADOS";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EmpleadoM emp = new EmpleadoM();
                emp.setIdEmpl(rs.getString("CODEMPL"));
                emp.setDNI(rs.getString("DNIEMPL"));
                emp.setNom(rs.getString("NOMEMPL"));
                emp.setApelPate(rs.getString("APEPATEEMPL"));
                emp.setApelMate(rs.getString("APEMATEEMPL"));
                emp.setRUC(rs.getString("RUCEMPL"));
                emp.setEmail(rs.getString("EMAILEMPL"));
                emp.setTelf(rs.getString("TELEMPL"));
                emp.setCel(rs.getString("CELEMPL"));
                emp.setFecNac(rs.getString("FECNACEMPL"));
                emp.setGrupSang(rs.getString("GRUPSANGEMPL"));
                emp.setEstCiv(rs.getString("ESTCIVEMPL"));
                emp.setConLab(rs.getString("CONLABEMPL"));
                emp.setCarnAseg(rs.getString("CARASEEMPL"));
                emp.setRefe(rs.getString("REFEEMPL"));
                emp.setLeye(rs.getString("LEYEMPL"));
                emp.setFecIng(rs.getString("FEUNGEMPL"));
                emp.setFecNom(rs.getString("FECNONEMPL"));
                emp.setDatCony(rs.getString("DATCONYEMPL"));
                emp.setUbigActu(rs.getString("DIRECCION"));
                emp.setEst(rs.getString("ESTEMPL"));
                emp.setOrigen(rs.getString("LUGAR DE NACIMIENTO"));
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
    public List<EmpleadoM> listarActivosCas() throws Exception {
        List<EmpleadoM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM VW_EMPLEADOSCAS";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EmpleadoM emp = new EmpleadoM();
                emp.setIdEmpl(rs.getString("CODEMPL"));
                emp.setDNI(rs.getString("DNIEMPL"));
                emp.setNom(rs.getString("NOMEMPL"));
                emp.setApelPate(rs.getString("APEPATEEMPL"));
                emp.setApelMate(rs.getString("APEMATEEMPL"));
                emp.setRUC(rs.getString("RUCEMPL"));
                emp.setEmail(rs.getString("EMAILEMPL"));
                emp.setTelf(rs.getString("TELEMPL"));
                emp.setCel(rs.getString("CELEMPL"));
                emp.setFecNac(rs.getString("FECNACEMPL"));
                emp.setGrupSang(rs.getString("GRUPSANGEMPL"));
                emp.setEstCiv(rs.getString("ESTCIVEMPL"));
                emp.setConLab(rs.getString("CONLABEMPL"));
                emp.setCarnAseg(rs.getString("CARASEEMPL"));
                emp.setRefe(rs.getString("REFEEMPL"));
                emp.setLeye(rs.getString("LEYEMPL"));
                emp.setFecIng(rs.getString("FEUNGEMPL"));
                emp.setFecNom(rs.getString("FECNONEMPL"));
                emp.setDatCony(rs.getString("DATCONYEMPL"));
                emp.setUbigActu(rs.getString("DIRECCION"));
                emp.setEst(rs.getString("ESTEMPL"));
                emp.setOrigen(rs.getString("LUGAR DE NACIMIENTO"));
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
    public List<EmpleadoM> listarActivosCesante() throws Exception {
        List<EmpleadoM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM VW_EMPLEADOSCESANTE";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EmpleadoM emp = new EmpleadoM();
                emp.setIdEmpl(rs.getString("CODEMPL"));
                emp.setDNI(rs.getString("DNIEMPL"));
                emp.setNom(rs.getString("NOMEMPL"));
                emp.setApelPate(rs.getString("APEPATEEMPL"));
                emp.setApelMate(rs.getString("APEMATEEMPL"));
                emp.setRUC(rs.getString("RUCEMPL"));
                emp.setEmail(rs.getString("EMAILEMPL"));
                emp.setTelf(rs.getString("TELEMPL"));
                emp.setCel(rs.getString("CELEMPL"));
                emp.setFecNac(rs.getString("FECNACEMPL"));
                emp.setGrupSang(rs.getString("GRUPSANGEMPL"));
                emp.setEstCiv(rs.getString("ESTCIVEMPL"));
                emp.setConLab(rs.getString("CONLABEMPL"));
                emp.setCarnAseg(rs.getString("CARASEEMPL"));
                emp.setRefe(rs.getString("REFEEMPL"));
                emp.setLeye(rs.getString("LEYEMPL"));
                emp.setFecIng(rs.getString("FEUNGEMPL"));
                emp.setFecNom(rs.getString("FECNONEMPL"));
                emp.setDatCony(rs.getString("DATCONYEMPL"));
                emp.setUbigActu(rs.getString("DIRECCION"));
                emp.setEst(rs.getString("ESTEMPL"));
                emp.setOrigen(rs.getString("LUGAR DE NACIMIENTO"));
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
    public List<EmpleadoM> listarInactivos() throws Exception {
        List<EmpleadoM> lista;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT * FROM VW_EMPLEADOSINAC";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                EmpleadoM emp = new EmpleadoM();
                emp.setIdEmpl(rs.getString("CODEMPL"));
                emp.setDNI(rs.getString("DNIEMPL"));
                emp.setNom(rs.getString("NOMEMPL"));
                emp.setApelPate(rs.getString("APEPATEEMPL"));
                emp.setApelMate(rs.getString("APEMATEEMPL"));
                emp.setRUC(rs.getString("RUCEMPL"));
                emp.setEmail(rs.getString("EMAILEMPL"));
                emp.setTelf(rs.getString("TELEMPL"));
                emp.setCel(rs.getString("CELEMPL"));
                emp.setFecNac(rs.getString("FECNACEMPL"));
                emp.setGrupSang(rs.getString("GRUPSANGEMPL"));
                emp.setEstCiv(rs.getString("ESTCIVEMPL"));
                emp.setConLab(rs.getString("CONLABEMPL"));
                emp.setCarnAseg(rs.getString("CARASEEMPL"));
                emp.setRefe(rs.getString("REFEEMPL"));
                emp.setLeye(rs.getString("LEYEMPL"));
                emp.setFecIng(rs.getString("FEUNGEMPL"));
                emp.setFecNom(rs.getString("FECNONEMPL"));
                emp.setDatCony(rs.getString("DATCONYEMPL"));
                emp.setUbigActu(rs.getString("DIRECCION"));
                emp.setEst(rs.getString("ESTEMPL"));
                emp.setOrigen(rs.getString("LUGAR DE NACIMIENTO"));
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
    public EmpleadoM leerID(String codigo) throws Exception {
        EmpleadoM emple = null;
        ResultSet rs;

        try {
            this.Conexion();
            String sql = "SELECT CODEMPL, DNIEMPL,NOMEMPL,APEPATEEMPL,APEMATEEMPL,RUCEMPL,EMAILEMPL,TELEMPL,CELEMPL,TO_CHAR(FECNACEMPL,'DD/MM/YYYY') AS FECNACEMPL,GRUPSANGEMPL,ESTCIVEMPL,CONLABEMPL,CARASEEMPL,REFEEMPL,LEYEMPL,TO_CHAR(FEUNGEMPL,'DD/MM/YYYY') AS FEUNGEMPL,TO_CHAR(FECNONEMPL,'DD/MM/YYYY') AS FECNONEMPL,DATCONYEMPL,UBIGEMPL,ESTEMPL,ORIEMPL FROM EMPLEADO WHERE CODEMPL LIKE ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                emple = new EmpleadoM();
                emple.setIdEmpl(rs.getString("CODEMPL"));
                emple.setDNI(rs.getString("DNIEMPL"));
                emple.setNom(rs.getString("NOMEMPL"));
                emple.setApelPate(rs.getString("APEPATEEMPL"));
                emple.setApelMate(rs.getString("APEMATEEMPL"));
                emple.setRUC(rs.getString("RUCEMPL"));
                emple.setEmail(rs.getString("EMAILEMPL"));
                emple.setTelf(rs.getString("TELEMPL"));
                emple.setCel(rs.getString("CELEMPL"));
                emple.setFecNac(rs.getString("FECNACEMPL"));
                emple.setGrupSang(rs.getString("GRUPSANGEMPL"));
                emple.setEstCiv(rs.getString("ESTCIVEMPL"));
                emple.setConLab(rs.getString("CONLABEMPL"));
                emple.setCarnAseg(rs.getString("CARASEEMPL"));
                emple.setRefe(rs.getString("REFEEMPL"));
                emple.setLeye(rs.getString("LEYEMPL"));
                emple.setFecIng(rs.getString("FEUNGEMPL"));
                emple.setFecNom(rs.getString("FECNONEMPL"));
                emple.setDatCony(rs.getString("DATCONYEMPL"));
                emple.setUbigActu(rs.getString("UBIGEMPL"));
                emple.setEst(rs.getString("ESTEMPL"));
                emple.setOrigen(rs.getString("ORIEMPL"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return emple;
    }

    @Override
    public void modificar(EmpleadoM emp) throws Exception {
        try {
            this.Conexion();
            String sql = "EXEC SP_EMPLEADO_UPDATE ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
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
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(EmpleadoM emp) throws Exception {
        try {
            this.Conexion();
            String sql = "Update Empleado set Est='I' WHERE idEmpl = ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, emp.getIdEmpl());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }



   
}
