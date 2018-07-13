package dao;

import modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao extends DAO {

    public Usuario IniciarSesion(String User, String Pass) throws Exception {
        this.Conexion();
        ResultSet rs;
        Usuario usuario = null;
        try {
            String sql = "Select Nom, ApelPate,DNI from Empleado where DNI like ? and Est like 'Activo'";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, User);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getString("DNI"));
                usuario.setNomUsuario(rs.getString("Nom"));
                usuario.setApeUsuario(rs.getString("ApelPate"));
                usuario.setUsuario(User);
                usuario.setContraUsuario(Pass);
            }
            return usuario;
        } catch (SQLException e) {
            throw e;
        }
    }

}
