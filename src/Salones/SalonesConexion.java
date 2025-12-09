package Salones;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class SalonesConexion {

    private static final String URL = "jdbc:mysql://localhost:3306/horarios";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public void crearSalon1(JTextField txtID1, JComboBox<String> jComboBox1, JComboBox<String> jComboBox2, JTextField txtID5){
        String sql = "INSERT INTO salones (ID, Proyector, Computadores, Tableros) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, Integer.parseInt(crearSalon_vista.txtID1.getText()));
            pstmt.setString(2, crearSalon_vista.jComboBox1.getSelectedItem().toString());
            pstmt.setInt(3, Integer.parseInt(crearSalon_vista.txtID5.getText()));
            pstmt.setInt(4, Integer.parseInt(crearSalon_vista.jComboBox2.getSelectedItem().toString()));

            int verificacion = pstmt.executeUpdate();
            if (verificacion > 0) {
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
    public void eliminarSalon(JTextField ID){
        String sql = "DELETE FROM salones  WHERE ID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setInt(1, Integer.parseInt(ID.getText()));

            int verificacion = pstmt.executeUpdate();
            if (verificacion > 0) {
                System.out.println("El salon fue eliminado exitosamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el Salon: " + e.getMessage());
        }

    }
    public void actualizarSalon(JTextField ID, JComboBox<String> jComboBox1, JComboBox<String> jComboBox2, JTextField txtNumComputadores){
        String sql = "UPDATE salones SET Proyector = ?, Computadores = ?, tableros = ? WHERE ID = ?";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, jComboBox1.getSelectedItem().toString());
            pstmt.setString(2, txtNumComputadores.getText());
            pstmt.setString(3, jComboBox2.getSelectedItem().toString());
            pstmt.setInt(4, Integer.parseInt(ID.getText()));
            int verificacion = pstmt.executeUpdate();
            if (verificacion > 0) {
                System.out.println("El salon fue actualizado exitosamente.");
            }
        }
        catch (SQLException e){
            System.out.println("Error al actualizar el Salon: " + e.getMessage());
        }
    }
}
