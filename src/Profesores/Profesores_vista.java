package Profesores;

import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Profesores_vista extends javax.swing.JPanel {

    public Profesores_vista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProfesores = new javax.swing.JTable();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        setMaximumSize(new java.awt.Dimension(668, 508));
        setMinimumSize(new java.awt.Dimension(668, 508));
        setPreferredSize(new java.awt.Dimension(668, 508));

        jLabel1.setBackground(new java.awt.Color(255, 229, 229));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROFESORES");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel1.setMaximumSize(new java.awt.Dimension(680, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(680, 40));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(680, 40));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(656, 188));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(656, 188));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(656, 188));
        jScrollPane1.setRequestFocusEnabled(false);

        tblProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DOCENTE", "CURSOS IMPARTIBLES", "HORARIOS DISPONIBLES"
            }
        ));
        tblProfesores.setMaximumSize(new java.awt.Dimension(668, 80));
        tblProfesores.setMinimumSize(new java.awt.Dimension(668, 80));
        tblProfesores.setPreferredSize(new java.awt.Dimension(668, 80));
        tblProfesores.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblProfesores);

        btnCrear.setBackground(new java.awt.Color(255, 242, 255));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCrear.setText("NUEVO");
        btnCrear.setMaximumSize(new java.awt.Dimension(106, 33));
        btnCrear.setMinimumSize(new java.awt.Dimension(106, 33));
        btnCrear.setPreferredSize(new java.awt.Dimension(106, 33));
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 242, 255));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setMaximumSize(new java.awt.Dimension(106, 33));
        btnEditar.setMinimumSize(new java.awt.Dimension(106, 33));
        btnEditar.setPreferredSize(new java.awt.Dimension(106, 33));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 242, 255));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setMaximumSize(new java.awt.Dimension(106, 33));
        btnEliminar.setMinimumSize(new java.awt.Dimension(106, 33));
        btnEliminar.setPreferredSize(new java.awt.Dimension(106, 33));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(255, 204, 204));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizar.setText("ACTUALIZAR TABLA");
        btnActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        btnActualizar.setMaximumSize(new java.awt.Dimension(106, 33));
        btnActualizar.setMinimumSize(new java.awt.Dimension(106, 33));
        btnActualizar.setPreferredSize(new java.awt.Dimension(106, 33));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        crearProfesor_vista tmp = new crearProfesor_vista();
        tmp.setVisible(true);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String idBuscar = JOptionPane.showInputDialog(null,
            "Ingrese la identificación del profesor a editar:");
        //AQUI DEBE IR VALIDACIÓN DE ID EN BASE DE DATOS Y CARGAR DATOS 
        //AL FORMULARIO editarProfesor
        //
        editarProfesor_vista tmp = new editarProfesor_vista();
        tmp.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String idBuscar = JOptionPane.showInputDialog(
                null, "Ingrese la identificación del profesor a eliminar:"
        );

        if (idBuscar == null || idBuscar.trim().isEmpty()) {
            return;
        }

        try {

            ProfesorConexion conexion = new ProfesorConexion();
            ResultSet rs = conexion.buscarProfesorPorID(Integer.parseInt(idBuscar));

            if (rs != null && rs.next()) {

                eliminarProfesor_vista tmp = new eliminarProfesor_vista();

                // === SETEO DE CAMPOS USANDO GETTERS ESTÁTICOS ===
                eliminarProfesor_vista.getID().setText(rs.getString("ID"));
                eliminarProfesor_vista.getTxtDocente().setText(rs.getString("Docente"));

                // Cursos
                String c1 = rs.getString("CursoImpartible1");
                String c2 = rs.getString("CursoImpartible2");
                String c3 = rs.getString("CursoImpartible3");
                String c4 = rs.getString("CursoImpartible4");

                String cursos = "";

                if (c1 != null && !c1.isEmpty()) cursos += c1 + " | ";
                if (c2 != null && !c2.isEmpty()) cursos += c2 + " | ";
                if (c3 != null && !c3.isEmpty()) cursos += c3 + " | ";
                if (c4 != null && !c4.isEmpty()) cursos += c4 + " | ";

                if (cursos.endsWith(" | ")) {
                    cursos = cursos.substring(0, cursos.length() - 3);
                }

                eliminarProfesor_vista.getTxtCursos().setText(cursos);

                // === TABLA DE HORARIOS ===
                DefaultTableModel modelo =
                        (DefaultTableModel) eliminarProfesor_vista.getTblHorarios().getModel();

                modelo.setRowCount(1);

                for (int col = 0; col < modelo.getColumnCount(); col++) {
                    modelo.setValueAt("", 0, col);
                }

                String diasBD  = rs.getString("HorariosDisponibles_dia");
                String horasBD = rs.getString("HorariosDisponibles_hora");

                if (diasBD != null && horasBD != null) {
                    String[] dias  = diasBD.split(",");
                    String[] horas = horasBD.split(",");

                    for (int i = 0; i < dias.length; i++) {

                        String dia  = dias[i].trim();
                        String hora = horas[i].trim();

                        int col = switch (dia) {
                            case "Lunes"     -> 0;
                            case "Martes"    -> 1;
                            case "Miercoles" -> 2;
                            case "Jueves"    -> 3;
                            case "Viernes"   -> 4;
                            case "Sabado"    -> 5;
                            default          -> -1;
                        };

                        if (col != -1) {
                            String actual = (String) modelo.getValueAt(0, col);
                            if (actual == null || actual.isEmpty()) {
                                modelo.setValueAt(hora, 0, col);
                            } else {
                                modelo.setValueAt(actual + "\n" + hora, 0, col);
                            }
                        }
                    }
                }

                tmp.setVisible(true);
                this.setVisible(false);

            } else {

                JOptionPane.showMessageDialog(null,
                        "No existe un profesor con ese ID.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al procesar los datos: " + e.getMessage());
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            new ProfesorConexion().mostrarProfesores(tblProfesores);            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error SQL: " + e.getMessage());
        } 
    }//GEN-LAST:event_btnActualizarActionPerformed

    public static JTable getTblProfesores() {
        return tblProfesores;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblProfesores;
    // End of variables declaration//GEN-END:variables
}
