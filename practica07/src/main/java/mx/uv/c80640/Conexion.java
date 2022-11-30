package mx.uv.c80640;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/usuarioDB";
    private static String DriverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String pass = "1234";
    private static Connection connection = null;

    public static Connection getConnection(){
        try{
            Class.forName(DriverName);
            connection = (Connection)DriverManager.getConnection(url, username, password);
        }catch (SQLException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("No se encontro el driver");
        }
        return connection;
    }
    
}
