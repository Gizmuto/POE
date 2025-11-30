package Cursos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class CursosConexion {
    private static final String URL = "jdbc:mysql://localhost:3306/horarios";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public void crearCurso(){
        String sql = "INSERT INTO cursos (Codigo,id_Docente, Grupo, Cupo, Docente_responsable, Horario) VALUES (?, ?, ?, ?, ?, ?)";
        String sql2 = "SELECT Docente FROM profesores WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            PreparedStatement pstmt1 = conn.prepareStatement(sql2);
            pstmt1.setInt(1,Integer.parseInt(crearCurso_vista.txtID2.getText()));
            ResultSet rs = pstmt1.executeQuery();
            rs.next();
            String nombreDocente = rs.getString(1);

            pstmt.setInt(1, Integer.parseInt(crearCurso_vista.txtID5.getText()));
            pstmt.setInt(2, Integer.parseInt(crearCurso_vista.txtID2.getText()));
            pstmt.setString(3, crearCurso_vista.txtID.getText());
            pstmt.setString(4,crearCurso_vista.txtID1.getText() );
            pstmt.setString(5, nombreDocente );
            pstmt.setString(6, "");

            int filasInsertadas = pstmt.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Un nuevo salon fue insertado exitosamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar el salon: " + e.getMessage());
        }


    }
    public void mostrarCurso(JTable curso) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CODIGO");
        modelo.addColumn("GRUPO");
        modelo.addColumn("CUPO");
        modelo.addColumn("DOCENTE_RESPONSABLE");
        modelo.addColumn("HORARIO");

        String sql =  "SELECT * FROM cursos";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Limpiar el modelo antes de cargar nuevos datos
            modelo.setRowCount(0);

            while (rs.next()) {
                String Codigo = rs.getString("Codigo");
                String Grupo = rs.getString("Grupo");
                String Cupo = rs.getString("Cupo");
                String DR = rs.getString("Docente_responsable");
                String Horario = rs.getString("Horario");
                modelo.addRow(new Object[]{Codigo,Grupo, Cupo, DR, Horario});
            }
            curso.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }



    }
    public void eliminarCurso(){
        String sql = "DELETE FROM salones  WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {



            int filasInsertadas = pstmt.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("El salon fue eliminado exitosamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el Salon: " + e.getMessage());
        }

    }
}
