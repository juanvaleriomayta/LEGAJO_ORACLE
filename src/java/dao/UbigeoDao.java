package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Ubigeo;

public class UbigeoDao extends Conexion{
    
    public void Registrar (Ubigeo ubi) throws Exception{
        try {
            this.Conexion();
            PreparedStatement ps = this.getCn().prepareStatement("INSERT INTO Ubigeo (Dep,Pro,Dis) values (?,?,?)");
            ps.setString(1, ubi.getDep());
            ps.setString(2, ubi.getPro());
            ps.setString(3, ubi.getDis());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            this.Cerrar();
        }
    }
}
