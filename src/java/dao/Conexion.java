package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection cnx;

    public Connection conectar() throws Exception {
        if (cnx != null) { // si esta abierta la conexion
            return cnx;
        }
        try {
            String url = "jdbc:sqlserver://35.229.54.77:1433;databaseName=SistLegajo";
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String user = "root";
            String pwd = "root";
            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, pwd);
            return cnx;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la Conexion" + e.getMessage());
            throw e;
        }
    }

    public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (cnx != null) {
            if (cnx.isClosed() == false) {
                cnx.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Conexion cn = new Conexion();
        if (cn.conectar() != null) {
            System.out.println("Conectado");
        }
    }

    /*
    *Getter and Setter
     */
    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

}
