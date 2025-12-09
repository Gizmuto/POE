package Usuarios.registrar;
import javax.swing.*;
import java.sql.*;
public class registrarUsuariosConexion {
    private static final String URL = "jdbc:mysql://localhost:3306/horarios";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public void registrarusuario(JComboBox comboBox, JTextField nombre_usuario, JTextField contraseña) {
        String sql = "INSERT INTO usuarios (id_rol, nombre_usuario, contraseña ) VALUES(?,?,?)";

        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, evaluarRol(comboBox));
            pstmt.setString(2, nombre_usuario.getText());
            pstmt.setString(3, contraseña.getText());

        }catch(SQLException e){
            System.out.println("Error al registrar usuario");
        }
    }
    public int evaluarRol(JComboBox comboBox){
        if(comboBox.getSelectedItem().toString().equals("Docente")){
            return 2;
        }else if(comboBox.getSelectedItem().toString().equals("administrador")){
            return 1;
        }else{
            return 0;
        }

    }
}
