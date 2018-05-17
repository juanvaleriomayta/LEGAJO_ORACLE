package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Contactos;




public class ContactosDao extends DAO {
    
    public void registrarContacto(Contactos cont, String tipo) throws Exception {
        this.Conexion();
        try {
            String sql = "INSERT INTO Contactos  (Nom,Ape,Par,Ocu,FecNac,Tel,Cel,EstCiv,vive,TipDeFami) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, cont.getNom());
            st.setString(2, cont.getApe());
            st.setString(3, cont.getPar());
            st.setString(4, cont.getOcu());
            st.setString(5, cont.getFecNac());
            st.setString(6, cont.getTel());
            st.setString(7, cont.getCel());
            st.setString(8, cont.getEstCiv());
            st.setString(9, cont.getVive());
            st.setString(10, tipo);
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void registrar(Contactos  cont) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Contactos  (TipDeFami,Nom,Ape,Par,Ocu,FecNac,Tel,Cel,EstCiv,vive) values(?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, cont.getTipDeFami());
            st.setString(2, cont.getNom());
            st.setString(3, cont.getApe());
            st.setString(4, cont.getPar());
            st.setString(5, cont.getOcu());
            st.setString(6, cont.getFecNac());
            st.setString(7, cont.getTel());
            st.setString(8, cont.getCel());
            st.setString(9, cont.getEstCiv());
            st.setString(10, cont.getVive());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }

    public List<Contactos> listar() throws Exception{
        List<Contactos> lista;
        ResultSet rs;
        
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareCall("SELECT CodConEmp, TipDeFami,Nom,Ape,Par,Ocu,FecNac,Tel,Cel,EstCiv,vive FROM Contactos");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Contactos cont = new Contactos();
                cont.setCodConEmp(rs.getInt("CodConEmp"));
                cont.setTipDeFami(rs.getString("TipDeFami"));
                cont.setNom(rs.getString("Nom"));
                cont.setApe(rs.getString("Ape"));
                cont.setPar(rs.getString("Par"));
                cont.setOcu(rs.getString("Ocu"));
                cont.setFecNac(rs.getString("FecNac"));
                cont.setTel(rs.getString("Tel"));
                cont.setCel(rs.getString("Cel"));
                cont.setEstCiv(rs.getString("EstCiv"));
                cont.setVive(rs.getString("vive"));
                lista.add(cont);
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
        return lista;
       } 
    
    public Contactos  leerID(Contactos  cont) throws Exception{
        Contactos  conta  = null;
        ResultSet rs;
        
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("SELECT CodConEmp,TipDeFami,Nom,Ape,Par,Ocu,FecNac,Tel,Cel,EstCiv,vive  FROM Contactos WHERE CodConEmp=?");
            st.setInt(1, cont.getCodConEmp());
            rs = st.executeQuery();
            while(rs.next()){
                conta = new Contactos();
                conta.setCodConEmp(rs.getInt("CodConEmp"));
                conta.setTipDeFami(rs.getString("TipDeFami"));
                conta.setNom(rs.getString("Nom"));
                conta.setApe(rs.getString("Ape"));
                conta.setPar(rs.getString("Par"));
                conta.setOcu(rs.getString("Ocu"));
                conta.setFecNac(rs.getString("FecNac"));
                conta.setTel(rs.getString("Tel"));
                conta.setCel(rs.getString("Cel"));
                conta.setEstCiv(rs.getString("EstCiv"));
                conta.setVive(rs.getString("vive"));
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
        return conta;
       } 
    
    public void modificar(Contactos cont) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Contactos SET TipDeFami = ?, Nom = ?, Ape = ?,Par = ?, Ocu = ?, FecNac = ?,Tel = ?, Cel = ?, EstCiv = ?, vive = ? WHERE CodConEmp = ?");
            st.setString(1, cont.getTipDeFami());
            st.setString(2, cont.getNom());
            st.setString(3, cont.getApe());
            st.setString(4, cont.getPar());
            st.setString(5, cont.getOcu());
            st.setString(6, cont.getFecNac());
            st.setString(7, cont.getTel());
            st.setString(8, cont.getCel());
            st.setString(9, cont.getEstCiv());
            st.setString(10, cont.getVive());
            st.setInt(11, cont.getCodConEmp());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }
    public void eliminar(Contactos cont) throws Exception{
        try {
            this.Conexion();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Contactos WHERE CodConEmp = ?");
            st.setInt(1, cont.getCodConEmp());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }
}
