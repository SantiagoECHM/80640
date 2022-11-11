import java.net.ConnectException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url="jdbc:mysql://127.0.0.1:3306/nombreBD";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "";
    private static Connection connection = null;

    public static Connection getConnection(){
        try{
            Class.forname(DriverName);
            connection = DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println("No encontró el driver");
        }
        return connection;
    }
}
