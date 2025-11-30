package ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBD {
    public static Connection obtenerConexion(){
        String host = "localhost";
        String user = "root";
        String password = "";
        int port = 3306;
        String url = "";
        String database = "horarios";
        Connection c = null;
        try{
            url = String.format("jdbc:mysql://%s:%d/%s",
                    host,port,database);
            System.out.println("URL: " + url);
            c = DriverManager.getConnection(url, user,
                    password);
            System.out.println("Conexión OK");
        }
        catch(SQLException e){
            System.out.println("Error en la conexión "+
                    e);
        }
        return c;
    }
}
