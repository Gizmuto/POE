package Usuarios.iniciarSesion;
import com.mysql.cj.protocol.Resultset;
import Alfa.Horarios ;
import javax.swing.*;
import java.sql.*;
public class IniciarSesionConexion {
    private static final String URL = "jdbc:mysql://localhost:3306/horarios";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public void IniciarSesion(JTextField Nombre_usuario, JTextField contraseña_usuario){
        String sql = "SELECT * FROM usuarios";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet rs = pstmt.executeQuery();
            String usuario = rs.getString(3);
            String contraseña = rs.getString(4);
            if(Nombre_usuario.getText().equals(usuario) && contraseña_usuario.getText().equals(contraseña)){
                Horarios temp = new Horarios();
            }else{
                System.out.println("Usuario o Contraseña incorrectos");
            }

        }catch(SQLException e){
            System.out.println("Error en IniciarSesionConexion" + e.getMessage());
        }
    }
}
