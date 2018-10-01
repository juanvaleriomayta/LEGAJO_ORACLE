package dao;

import modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import services.Encriptar;

public class UsuarioDao extends DAO {

    public Usuario IniciarSesion(String User, String Passw) throws Exception {
        this.Conexion();
        ResultSet rs;
        Usuario usuario = null;
        try {
            String sql = "Select IdUsuario,Nombre,Estado,Nivel from Usuario where Usuario like ? and Pass like ? and Estado like 'A'";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, User);
            ps.setString(2, Encriptar.encriptar(Passw));
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getString("IdUsuario"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setEstado(rs.getString("Estado"));
                usuario.setNivel(rs.getString("Nivel"));
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

    public void Registrar(Usuario user) throws Exception {
        try {
            this.Conexion();
            String sql = "INSERT INTO Usuario (Usuario,Pass,Nombre,Estado,Nivel) VALUES(?,?,?,?,?)";
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

    public List<Usuario> Listar() throws Exception {
        List<Usuario> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "select * from VW_USUARIO";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            Usuario user;
            while (rs.next()) {
                user = new Usuario();
                user.setIdUsuario(rs.getString("IdUsuario"));
                user.setUsuario(rs.getString("Usuario"));
                user.setPass(rs.getString("Pass"));
                user.setNombre(rs.getString("Nombre"));
                user.setEstado(rs.getString("Estado"));
                user.setNivel(rs.getString("Nivel"));
                lista.add(user);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
     public List<Usuario> ListarInactivos() throws Exception {
        List<Usuario> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "select * from VW_USUARIO_INACTIVOS";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            Usuario user;
            while (rs.next()) {
                user = new Usuario();
                user.setIdUsuario(rs.getString("IdUsuario"));
                user.setUsuario(rs.getString("Usuario"));
                user.setPass(rs.getString("Pass"));
                user.setNombre(rs.getString("Nombre"));
                user.setEstado(rs.getString("Estado"));
                user.setNivel(rs.getString("Nivel"));
                lista.add(user);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public Usuario LeerId(String Codigo) throws Exception {
        Usuario user = null;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "select IdUsuario, Usuario,Pass,Nombre,Estado,Nivel FROM Usuario WHERE IdUsuario=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, Codigo);
            rs = st.executeQuery();
            if (rs.next()) {
                user = new Usuario();
                user.setIdUsuario(rs.getString("IdUsuario"));
                user.setUsuario(rs.getString("Usuario"));
                user.setPass(rs.getString("Pass"));
                user.setNombre(rs.getString("Nombre"));
                user.setEstado(rs.getString("Estado"));
                user.setNivel(rs.getString("Nivel"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return user;
    }

    public void Modificar(Usuario user) throws Exception {
        try {
            this.Conexion();
            String sql = "UPDATE Usuario SET Usuario=?,Pass=?,Nombre=?,Estado=?,Nivel=? where IdUsuario=?";
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

    public void Eliminar(Usuario user) throws Exception {
        try {
            this.Conexion();
            String sql = "Update Usuario set Estado='I' WHERE IdUsuario=?";
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
