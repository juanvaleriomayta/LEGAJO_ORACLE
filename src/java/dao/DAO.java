package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DAO {

    private Connection cn;

    public void Conexion() {
        try {
            if (cn == null) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                //  cn = DriverManager.getConnection("jdbc:sqlserver://35.229.54.77:1433;database=Legajo", "root", "root");

                cn = DriverManager.getConnection("jdbc:sqlserver://sql.jcondori.com:1433;database=Legajo", "root", "root");

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
                cn = null;
            }
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.Conexion();
        if (dao.getCn() != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("No hay Conexion");
        }
    }
}
