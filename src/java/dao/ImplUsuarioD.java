package dao;

import modelo.UsuarioM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import services.Encriptar;

public class ImplUsuarioD extends ImplDAO {

    public UsuarioM IniciarSesion(String User, String Passw) throws Exception {
        this.Conexion();
        ResultSet rs;
        UsuarioM usuario = null;
        try {
            String sql = "Select CODUSU,NOMUSU,ESTUSU,LEVUSU FROM USUARIO WHERE USUUSU LIKE ? AND PWSUSU LIKE ? AND ESTUSU LIKE 'A'";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, User);
            ps.setString(2, Encriptar.encriptar(Passw));
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new UsuarioM();
                usuario.setIdUsuario(rs.getString("CODUSU"));
                usuario.setNombre(rs.getString("NOMUSU"));
                usuario.setEstado(rs.getString("ESTUSU"));
                usuario.setNivel(rs.getString("LEVUSU"));
                usuario.setUsuario(User);
                usuario.setPass(Passw);
            }
            return usuario;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void Registrar(UsuarioM user) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO USUARIO (USUUSU,PWSUSU,NOMUSU,ESTUSU,LEVUSU) VALUES (?,?,?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, user.getUsuario());
            st.setString(2, Encriptar.encriptar(user.getPass()));
            st.setString(3, user.getNombre());
            st.setString(4, "A");
            st.setString(5, user.getNivel());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<UsuarioM> Listar() throws Exception {
        List<UsuarioM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM USUARIO";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            UsuarioM user;
            while (rs.next()) {
                user = new UsuarioM();
                user.setIdUsuario(rs.getString("CODUSU"));
                user.setUsuario(rs.getString("USUUSU"));
                user.setPass(rs.getString("PWSUSU"));
                user.setNombre(rs.getString("NOMUSU"));
                user.setEstado(rs.getString("ESTUSU"));
                user.setNivel(rs.getString("LEVUSU"));
                lista.add(user);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
     public List<UsuarioM> ListarInactivos() throws Exception {
        List<UsuarioM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM VW_USUARIO_INACTIVOS";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            UsuarioM user;
            while (rs.next()) {
                user = new UsuarioM();
                user.setIdUsuario(rs.getString("CODUSU"));
                user.setUsuario(rs.getString("USUUSU"));
                user.setPass(rs.getString("PSWUSU"));
                user.setNombre(rs.getString("NOMUSU"));
                user.setEstado(rs.getString("ESTUSU"));
                user.setNivel(rs.getString("LEVUSU"));
                lista.add(user);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public UsuarioM LeerId(String Codigo) throws Exception {
        UsuarioM user = null;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT CODUSU,USUUSU,PWSUSU,NOMUSU,ESTUSU,LEVUSU FROM USUARIO WHERE CODUSU LIKE ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, Codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                user = new UsuarioM();
                user.setIdUsuario(rs.getString("CODUSU"));
                user.setUsuario(rs.getString("USUUSU"));
                user.setPass(rs.getString("PWSUSU"));
                user.setNombre(rs.getString("NOMUSU"));
                user.setEstado(rs.getString("ESTUSU"));
                user.setNivel(rs.getString("LEVUSU"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return user;
    }

    public void Modificar(UsuarioM user) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE USUARIO SET USUUSU=?,PWSUSU=?,NOMUSU=?,ESTUSU=?,LEVUSU=? WHERE CODUSU LIKE ?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
           
            st.setString(1, user.getUsuario());
            st.setString(2, Encriptar.encriptar(user.getPass()));
            st.setString(3, user.getNombre());
            st.setString(4, user.getEstado());
            st.setString(5, user.getNivel());
             st.setString(6, user.getIdUsuario());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void Eliminar(UsuarioM user) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE USUARIO SET ESTUSU='I' WHERE CODUSU=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, user.getIdUsuario());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }
}
