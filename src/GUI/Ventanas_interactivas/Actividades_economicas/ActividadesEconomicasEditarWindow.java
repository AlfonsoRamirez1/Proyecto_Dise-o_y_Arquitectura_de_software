package GUI.Ventanas_interactivas.Actividades_economicas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class ActividadesEconomicasEditarWindow extends JFrame {
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public ActividadesEconomicasEditarWindow() {
        // Configuración de la ventana
        setTitle("Editar Actividades Económicas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Mensaje superior
        JLabel messageLabel = new JLabel("Editar Tabla de Actividades Económicas", SwingConstants.CENTER);
        add(messageLabel, BorderLayout.NORTH);

        // Panel para mostrar los datos de la tabla
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Permitir la edición de todas las celdas
                return true;
            }
        };
        dataTable = new JTable(tableModel);
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(dataTable), BorderLayout.CENTER);

        // Añadir el panel de la tabla al centro
        add(tablePanel, BorderLayout.CENTER);

        // Botón para guardar y cerrar
        JButton guardarBtn = new JButton("Guardar y Cerrar");
        guardarBtn.addActionListener(e -> saveAndClose());
        add(guardarBtn, BorderLayout.SOUTH);

        // Mostrar los datos de la tabla "ActividadesEconomicas"
        mostrarDatosTabla("ActividadesEconomicas");
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
        String query = "UPDATE ActividadesEconomicas SET ";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            for (int row = 0; row < tableModel.getRowCount(); row++) {
                StringBuilder sb = new StringBuilder(query);
                for (int col = 0; col < tableModel.getColumnCount(); col++) {
                    String columnName = tableModel.getColumnName(col);
                    Object cellValue = tableModel.getValueAt(row, col);

                    sb.append(columnName).append(" = '").append(cellValue).append("'");

                    if (col < tableModel.getColumnCount() - 1) {
                        sb.append(", ");
                    }
                }

                sb.append(" WHERE id = ").append(tableModel.getValueAt(row, 0));

                stmt.executeUpdate(sb.toString());
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la tabla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // Cerrar la ventana una vez guardados los cambios
        dispose();
    }
}