package Profesores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class ProfesorConexion {
    private static final String URL = "jdbc:mysql://localhost:3306/horarios";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    //CRUD de profesores
    public void crearProfesor(JTextField txtID, JTextField txtID1, String[] cursos){
        String sql = "INSERT INTO profesores (ID, Docente, CursoImpartible1, CursoImpartible2, CursoImpartible3, CursoImpartible4, HorariosDisponibles_dia, HorariosDisponibles_hora) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, Integer.parseInt(txtID.getText()));
            pstmt.setString(2, txtID1.getText());
            pstmt.setString(3, cursos[0]);
            pstmt.setString(4, cursos[1]);
            pstmt.setString(5, cursos[2]);
            pstmt.setString(6, cursos[3]);
            pstmt.setString(7, "");
            pstmt.setString(8, "");

            int verificacion = pstmt.executeUpdate();
            if (verificacion > 0) {
                System.out.println("Un nuevo Docente fue insertado exitosamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar el Docente: " + e.getMessage());
        }


    }
    public void mostrarProfesores(JTable profesor) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("DOCENTE");
        modelo.addColumn("CURSOIMPARTIBLE1");
        modelo.addColumn("CURSOIMPARTIBLE2");
        modelo.addColumn("CURSOIMPARTIBLE3");
        modelo.addColumn("CURSOIMPARTIBLE4");
        modelo.addColumn("HORARIOSDISPONIBLE(DIA)");
        modelo.addColumn("HORARIOSDISPONIBLE(HORA)");

        String sql =  "SELECT * FROM profesores";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Limpiar el modelo antes de cargar nuevos datos
            modelo.setRowCount(0);

            while (rs.next()) {
                String ID = rs.getString("ID");
                String Docente = rs.getString("Docente");
                String CI1 = rs.getString("CursoImpartible1");
                String CI2 = rs.getString("CursoImpartible2");
                String CI3 = rs.getString("CursoImpartible3");
                String CI4 = rs.getString("CursoImpartible4");
                String HDdia = rs.getString("HorariosDisponibles_dia");
                String HDhora = rs.getString("HorariosDisponibles_hora");

                modelo.addRow(new Object[]{ID, Docente, CI1, CI2, CI3, CI4, HDdia, HDhora});
            }
            profesor.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }



    }
    public void eliminarProfesor(JTextField ID){
        String sql = "DELETE FROM profesores  WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, Integer.parseInt(ID.getText()));
            int verificacion = pstmt.executeUpdate();
            if (verificacion > 0) {
                System.out.println("El docente fue eliminado exitosamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }

    }
    public void actualizarProfesor(JTextField txtID1, JTextField ID, String[] partes ){
        String sql = "UPDATE profesores SET DOCENTE = ?, CursoImpartible1 = ?, CursoImpartible2 = ?, CursoImpartible3 = ?, CursoImpartible4 = ? WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, txtID1.getText());
            pstmt.setString(2, partes[0]);
            pstmt.setString(3, partes[1]);
            pstmt.setString(4, partes[2]);
            pstmt.setString(5, partes[3]);
            pstmt.setInt(6, Integer.parseInt(ID.getText()));

            int verificacion = pstmt.executeUpdate();
            if (verificacion > 0) {
                System.out.println("El docente fue actualizado exitosamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el Docente: " + e.getMessage());
        }
    }

    public ResultSet buscarProfesorPorID(int id) {
        String sql = "SELECT * FROM profesores WHERE ID = ?";

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);

            return pstmt.executeQuery();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el profesor: " + e.getMessage());
            return null;
        }
    }


}
