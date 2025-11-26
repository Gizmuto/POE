package Salones;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class SalonesConexion {

    private static final String URL = "jdbc:mysql://localhost:3306/horarios";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public void crearSalon1(){
        String sql = "INSERT INTO salones (ID, Proyector, Computadores, Tableros) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, Integer.parseInt(crearSalon_vista.txtID1.getText()));
            pstmt.setString(2, crearSalon_vista.jComboBox1.getSelectedItem().toString());
            pstmt.setInt(3, Integer.parseInt(crearSalon_vista.txtID5.getText()));
            pstmt.setInt(4, Integer.parseInt(crearSalon_vista.jComboBox2.getSelectedItem().toString()));

            int filasInsertadas = pstmt.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Un nuevo salon fue insertado exitosamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar el salon: " + e.getMessage());
        }


    }
    public void mostrarSalones(JTable salones) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("PROYECTOR");
        modelo.addColumn("COMPUTADORES");
        modelo.addColumn("TABLEROS");

        String sql =  "SELECT * FROM salones";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Limpiar el modelo antes de cargar nuevos datos
            modelo.setRowCount(0);

            while (rs.next()) {
                String ID = rs.getString("ID");
                String proyector = rs.getString("Proyector");
                String computador = rs.getString("Computadores");
                String tablero = rs.getString("Tableros");
                modelo.addRow(new Object[]{ID, proyector, computador, tablero});
            }
            salones.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }



    }
    public void eliminarSalon(){
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
