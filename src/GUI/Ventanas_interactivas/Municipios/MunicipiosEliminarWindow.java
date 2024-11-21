package GUI.Ventanas_interactivas.Municipios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.HashSet;
import java.util.Vector;

public class MunicipiosEliminarWindow extends JFrame {
    private JTable dataTable;
    private DefaultTableModel tableModel;
    private HashSet<Integer> deletedRowsIds;

    public MunicipiosEliminarWindow() {
        // Configuración de la ventana
        setTitle("Eliminar Municipios");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        deletedRowsIds = new HashSet<>();

        // Mensaje superior
        JLabel messageLabel = new JLabel("Eliminar Municipios", SwingConstants.CENTER);
        add(messageLabel, BorderLayout.NORTH);

        // Panel para mostrar los datos de la tabla
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dataTable = new JTable(tableModel);
        dataTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = dataTable.getSelectedRow();
                    if (row != -1) {
                        int id = (int) tableModel.getValueAt(row, 0);
                        deletedRowsIds.add(id);
                        tableModel.removeRow(row);
                    }
                }
            }
        });
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(dataTable), BorderLayout.CENTER);

        // Añadir el panel de la tabla al centro
        add(tablePanel, BorderLayout.CENTER);

        // Botón para guardar y cerrar
        JButton guardarBtn = new JButton("Guardar y Cerrar");
        guardarBtn.addActionListener(e -> saveAndClose());
        add(guardarBtn, BorderLayout.SOUTH);

        // Mostrar los datos de la tabla "Municipios"
        mostrarDatosTabla("Municipios");
    }

    // Método para mostrar datos de la tabla seleccionada
    private void mostrarDatosTabla(String tableName) {
        // Limpiar modelo de la tabla
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);

        String url = "jdbc:sqlite:G:/Mi unidad/DISEÑO Y ARQUITECTURA DE SOFTWARE/Proyecto Parcial 2/src/Database/Proyecto parcial 2 Diseño y arquitectura de software.db";
        String query = "SELECT * FROM " + tableName;

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Obtener nombres de columnas
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Agregar nombres de columnas al modelo de tabla
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Agregar filas al modelo de tabla
            while (rs.next()) {
                Vector<Object> row = new Vector<>(columnCount);
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                tableModel.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al consultar la tabla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Método para guardar los cambios y cerrar la ventana
    private void saveAndClose() {
        String url = "jdbc:sqlite:G:/Mi unidad/DISEÑO Y ARQUITECTURA DE SOFTWARE/Proyecto Parcial 2/src/Database/Proyecto parcial 2 Diseño y arquitectura de software.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            conn.setAutoCommit(false); // Habilitar transacciones

            try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Municipios WHERE id = ?")) {
                for (Integer id : deletedRowsIds) {
                    pstmt.setInt(1, id);
                    pstmt.executeUpdate();
                }
            }

            conn.commit(); // Confirmar transacción

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la tabla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // Cerrar la ventana una vez guardados los cambios
        dispose();
    }
}
