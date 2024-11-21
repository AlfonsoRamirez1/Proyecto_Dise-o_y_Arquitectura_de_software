package GUI.Ventanas_interactivas.Actividades_economicas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ActividadesEconomicasConsultaWindow extends JFrame {
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public ActividadesEconomicasConsultaWindow() {
        // Configuración de la ventana
        setTitle("Consulta de Actividades Económicas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Mensaje superior
        JLabel messageLabel = new JLabel("Tabla de Actividades Económicas", SwingConstants.CENTER);
        add(messageLabel, BorderLayout.NORTH);

        // Panel para mostrar los datos de la tabla
        tableModel = new DefaultTableModel();
        dataTable = new JTable(tableModel);
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(dataTable), BorderLayout.CENTER);

        // Añadir el panel de la tabla al centro
        add(tablePanel, BorderLayout.CENTER);

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
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al consultar la tabla: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}